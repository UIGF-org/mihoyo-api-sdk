//! Dynamic Secret (DS) signing for the generated clients.
//!
//! The salt is deliberately a call-time parameter: this crate ships no salt registry
//! and never discovers salt material at runtime. Callers that already hold a salt can
//! install [`DsSigner::configure`] on the generated client options to have the `DS`
//! header added automatically to every DS-protected operation whose header is omitted.
//!
//! V1 signs `salt={salt}&t={timestamp}&r={nonce}`; V2 adds the exact serialized
//! request body and the sorted query string as `&b={body}&q={query}`.
//!
//! Salt material is redacted from every `Debug` implementation in this module, so
//! diagnostics and panic messages cannot leak it.

use std::sync::Arc;

use azure_core::error::ErrorKind;
use azure_core::http::headers::{HeaderName, HeaderValue};
use azure_core::http::policies::{Policy, PolicyResult};
use azure_core::http::{Body, ClientOptions, Context, Request};
use azure_core::Error;

use crate::ds_operation_map;

/// The header that carries a Dynamic Secret signature.
const DS_HEADER: HeaderName = HeaderName::from_static("ds");

/// Characters used by a V1 nonce.
const LOWER_ALPHANUMERIC: &[u8; 36] = b"0123456789abcdefghijklmnopqrstuvwxyz";

/// The two supported Dynamic Secret payload layouts.
#[derive(Clone, Copy, Debug, PartialEq, Eq)]
pub enum DsGeneration {
    /// `salt={salt}&t={timestamp}&r={nonce}`
    V1,
    /// `salt={salt}&t={timestamp}&r={nonce}&b={body}&q={query}`
    V2,
}

/// Everything that can go wrong while creating a Dynamic Secret signature.
#[derive(Clone, Debug, PartialEq, Eq)]
pub enum DsError {
    /// The caller did not supply salt material.
    MissingSalt,
    /// A V1 nonce must be exactly six lowercase alphanumeric characters.
    InvalidV1Nonce(String),
    /// A V2 nonce must be numeric.
    InvalidV2Nonce(String),
    /// The operating system did not provide random bytes for the nonce.
    Entropy,
}

impl std::fmt::Display for DsError {
    fn fmt(&self, formatter: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            DsError::MissingSalt => write!(formatter, "DS salt must be provided by the caller."),
            DsError::InvalidV1Nonce(nonce) => write!(
                formatter,
                "V1 DS nonce must contain exactly six lowercase alphanumeric characters, got '{nonce}'."
            ),
            DsError::InvalidV2Nonce(nonce) => {
                write!(formatter, "V2 DS nonce must be numeric, got '{nonce}'.")
            }
            DsError::Entropy => write!(formatter, "The operating system did not provide random bytes."),
        }
    }
}

impl std::error::Error for DsError {}

/// Replaces secret signing material in `Debug` output.
const REDACTED: &str = "<redacted>";

/// Input to the Dynamic Secret algorithm.
///
/// `salt` is supplied by the caller; this crate never contains vendor salts or
/// discovers them at runtime.
#[derive(Clone)]
pub struct DsSigningOptions {
    salt: String,
    generation: DsGeneration,
    body: Option<String>,
    query: Option<String>,
    timestamp: Option<u64>,
    nonce: Option<String>,
}

// The salt is secret signing material, so a derived `Debug` implementation would copy
// it into logs and panic messages.
impl std::fmt::Debug for DsSigningOptions {
    fn fmt(&self, formatter: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        formatter
            .debug_struct("DsSigningOptions")
            .field("salt", &REDACTED)
            .field("generation", &self.generation)
            .field("body", &self.body)
            .field("query", &self.query)
            .field("timestamp", &self.timestamp)
            .field("nonce", &self.nonce)
            .finish()
    }
}

impl DsSigningOptions {
    /// Creates signing input for `generation` using caller-supplied salt material.
    pub fn new(salt: impl Into<String>, generation: DsGeneration) -> Self {
        Self {
            salt: salt.into(),
            generation,
            body: None,
            query: None,
            timestamp: None,
            nonce: None,
        }
    }

    /// Sets the exact serialized HTTP request body used by V2 signing.
    pub fn with_body(mut self, body: impl Into<String>) -> Self {
        self.body = Some(body.into());
        self
    }

    /// Sets the HTTP query string used by V2 signing. Query segments are sorted.
    pub fn with_query(mut self, query: impl Into<String>) -> Self {
        self.query = Some(query.into());
        self
    }

    /// Sets Unix seconds. Supplying this makes signing deterministic.
    pub fn with_timestamp(mut self, timestamp: u64) -> Self {
        self.timestamp = Some(timestamp);
        self
    }

    /// Sets a six-character V1 or numeric V2 nonce. Supplying this makes signing deterministic.
    pub fn with_nonce(mut self, nonce: impl Into<String>) -> Self {
        self.nonce = Some(nonce.into());
        self
    }
}

/// A generated Dynamic Secret header and its signing inputs.
#[derive(Clone, PartialEq, Eq)]
pub struct DsSignature {
    /// The value to send in the HTTP `DS` header.
    pub value: String,
    /// The Unix-seconds timestamp used to create the signature.
    pub timestamp: u64,
    /// The nonce used to create the signature.
    pub nonce: String,
    /// The lowercase MD5 digest of [`DsSignature::payload`].
    pub digest: String,
    /// The unsigned Dynamic Secret payload. It embeds the caller's salt, so it is
    /// redacted from `Debug` output; do not log this field.
    pub payload: String,
}

// `payload` is the MD5 preimage and starts with `salt=`, so a derived `Debug`
// implementation would leak the salt that `DsSigningOptions` redacts.
impl std::fmt::Debug for DsSignature {
    fn fmt(&self, formatter: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        formatter
            .debug_struct("DsSignature")
            .field("value", &self.value)
            .field("timestamp", &self.timestamp)
            .field("nonce", &self.nonce)
            .field("digest", &self.digest)
            .field("payload", &REDACTED)
            .finish()
    }
}

/// Creates a Dynamic Secret header and exposes its deterministic signing details.
pub fn create(options: &DsSigningOptions) -> Result<DsSignature, DsError> {
    if options.salt.is_empty() {
        return Err(DsError::MissingSalt);
    }

    let timestamp = options.timestamp.unwrap_or_else(current_timestamp);
    let nonce = match &options.nonce {
        Some(nonce) => nonce.clone(),
        None => create_nonce(options.generation)?,
    };
    validate_nonce(options.generation, &nonce)?;

    let prefix = format!("salt={}&t={timestamp}&r={nonce}", options.salt);
    let payload = match options.generation {
        DsGeneration::V1 => prefix,
        DsGeneration::V2 => format!(
            "{prefix}&b={}&q={}",
            options.body.as_deref().unwrap_or_default(),
            canonicalize_query(options.query.as_deref().unwrap_or_default()),
        ),
    };
    let digest = format!("{:x}", md5::compute(payload.as_bytes()));

    Ok(DsSignature {
        value: format!("{timestamp},{nonce},{digest}"),
        timestamp,
        nonce,
        digest,
        payload,
    })
}

/// Creates only the value required by an HTTP `DS` header.
pub fn create_header(options: &DsSigningOptions) -> Result<String, DsError> {
    create(options).map(|signature| signature.value)
}

/// Sorts already-serialized query segments for V2 signing, exactly as the reference
/// desktop clients do. A leading `?` is ignored.
pub fn canonicalize_query(query: &str) -> String {
    let query = query.strip_prefix('?').unwrap_or(query);
    if query.is_empty() {
        return String::new();
    }

    let mut segments: Vec<&str> = query.split('&').collect();
    segments.sort_unstable();
    segments.join("&")
}

/// Adds automatic DS signing to generated client options.
///
/// The policy runs per try, immediately before the transport, so the signature always
/// covers the bytes that are actually sent. Requests that already carry a non-empty
/// `DS` header are left untouched.
pub struct DsSigner;

impl DsSigner {
    /// Adds a DS signing policy to `options` without replacing existing policies.
    pub fn configure(options: &mut ClientOptions, salt: impl Into<String>) -> Result<(), DsError> {
        let policy = DsSigner::create_policy(salt)?;
        options.per_try_policies.push(policy);
        Ok(())
    }

    /// Creates a pipeline policy for callers that build their own pipeline.
    pub fn create_policy(salt: impl Into<String>) -> Result<Arc<dyn Policy>, DsError> {
        let salt = salt.into();
        if salt.is_empty() {
            return Err(DsError::MissingSalt);
        }

        Ok(Arc::new(DsSigningPolicy { salt }))
    }
}

struct DsSigningPolicy {
    salt: String,
}

// `Policy` requires `Debug`, and the pipeline can print its policies, so the salt is
// redacted instead of derived.
impl std::fmt::Debug for DsSigningPolicy {
    fn fmt(&self, formatter: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        formatter
            .debug_struct("DsSigningPolicy")
            .field("salt", &REDACTED)
            .finish()
    }
}

#[async_trait::async_trait]
impl Policy for DsSigningPolicy {
    async fn send(
        &self,
        ctx: &Context,
        request: &mut Request,
        next: &[Arc<dyn Policy>],
    ) -> PolicyResult {
        self.sign(request)?;
        next[0].send(ctx, request, &next[1..]).await
    }
}

impl DsSigningPolicy {
    fn sign(&self, request: &mut Request) -> azure_core::Result<()> {
        let Some(generation) = ds_operation_map::generation(request.url().path()) else {
            return Ok(());
        };

        if let Some(existing) = request.headers().get_optional_str(&DS_HEADER) {
            if !existing.is_empty() {
                return Ok(());
            }
        }

        let options = DsSigningOptions::new(self.salt.clone(), generation)
            .with_body(request_body(request))
            .with_query(request.url().query().unwrap_or_default().to_owned());
        let signature = create(&options).map_err(to_azure_error)?;
        request.insert_header(DS_HEADER.clone(), HeaderValue::from(signature.value));
        Ok(())
    }
}

/// Reads the serialized bytes a generated client put in the request body. Streaming
/// bodies cannot be signed without buffering them, so they sign as an empty body.
fn request_body(request: &Request) -> String {
    match request.body() {
        Body::Bytes(bytes) => String::from_utf8_lossy(bytes).into_owned(),
        Body::SeekableStream(_) => String::new(),
    }
}

fn to_azure_error(error: DsError) -> Error {
    Error::with_message(ErrorKind::Other, error.to_string())
}

fn current_timestamp() -> u64 {
    std::time::SystemTime::now()
        .duration_since(std::time::UNIX_EPOCH)
        .map(|elapsed| elapsed.as_secs())
        .unwrap_or_default()
}

fn create_nonce(generation: DsGeneration) -> Result<String, DsError> {
    match generation {
        DsGeneration::V1 => {
            let mut bytes = [0u8; 6];
            getrandom::fill(&mut bytes).map_err(|_| DsError::Entropy)?;
            Ok(bytes
                .iter()
                .map(|byte| LOWER_ALPHANUMERIC[usize::from(*byte) % LOWER_ALPHANUMERIC.len()] as char)
                .collect())
        }
        DsGeneration::V2 => {
            let mut bytes = [0u8; 4];
            getrandom::fill(&mut bytes).map_err(|_| DsError::Entropy)?;
            let value = u32::from_le_bytes(bytes);
            Ok((100_000 + (value % 100_001)).to_string())
        }
    }
}

fn validate_nonce(generation: DsGeneration, nonce: &str) -> Result<(), DsError> {
    match generation {
        DsGeneration::V1 => {
            let valid = nonce.len() == 6
                && nonce
                    .bytes()
                    .all(|byte| byte.is_ascii_digit() || byte.is_ascii_lowercase());
            if valid {
                Ok(())
            } else {
                Err(DsError::InvalidV1Nonce(nonce.to_owned()))
            }
        }
        DsGeneration::V2 => {
            if !nonce.is_empty() && nonce.bytes().all(|byte| byte.is_ascii_digit()) {
                Ok(())
            } else {
                Err(DsError::InvalidV2Nonce(nonce.to_owned()))
            }
        }
    }
}
