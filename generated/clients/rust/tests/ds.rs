//! Verifies Dynamic Secret signing in the generated Rust client.
//!
//! The crate is not published with these tests; they exist so that `cargo test` in
//! `generated/clients/rust` proves the DS policy reaches the wire. `tools/rust-ds.test.mjs`
//! runs them as part of `npm test`.

use std::io::{Read, Write};
use std::net::{TcpListener, TcpStream};
use std::sync::{Arc, Mutex};
use std::thread;

use azure_core::http::RequestContent;
use uigf_mihoyo::ds::{
    canonicalize_query, create, DsError, DsGeneration, DsSigner, DsSigningOptions,
};
use uigf_mihoyo::game::account::{GameAccountClient, GameAccountClientOptions};
use uigf_mihoyo::game::cn::records::{
    CnGameRecordsClient, CnGameRecordsClientOptions,
    models::CnGameRecordsStarRailApiClientGetSimulatedUniverseOptions,
};

const SALT: &str = "caller-provided-salt";

#[test]
fn v1_matches_the_reference_digest() {
    let signature = create(
        &DsSigningOptions::new(SALT, DsGeneration::V1)
            .with_timestamp(1_700_000_000)
            .with_nonce("abc123"),
    )
    .expect("V1 signing");

    assert_eq!("4e73fb371dec2794ccd8908d6d1c0273", signature.digest);
    assert_eq!(
        "1700000000,abc123,4e73fb371dec2794ccd8908d6d1c0273",
        signature.value
    );
    assert_eq!("salt=caller-provided-salt&t=1700000000&r=abc123", signature.payload);
}

#[test]
fn v2_matches_the_reference_digest() {
    let signature = create(
        &DsSigningOptions::new(SALT, DsGeneration::V2)
            .with_body(r#"{"b":2,"a":1}"#)
            .with_query("z=last&a=first")
            .with_timestamp(1_700_000_000)
            .with_nonce("123456"),
    )
    .expect("V2 signing");

    assert_eq!("dea0c2f2d886ba77d909103b373292c9", signature.digest);
    assert_eq!(
        "1700000000,123456,dea0c2f2d886ba77d909103b373292c9",
        signature.value
    );
    assert_eq!("a=first&z=last", canonicalize_query("?z=last&a=first"));
}

#[test]
fn generated_nonces_have_the_shape_each_generation_requires() {
    for _ in 0..64 {
        let v1 = create(&DsSigningOptions::new(SALT, DsGeneration::V1)).expect("V1 signing");
        assert_eq!(6, v1.nonce.len());
        assert!(v1
            .nonce
            .bytes()
            .all(|byte| byte.is_ascii_digit() || byte.is_ascii_lowercase()));

        let v2 = create(&DsSigningOptions::new(SALT, DsGeneration::V2)).expect("V2 signing");
        let nonce: u32 = v2.nonce.parse().expect("numeric V2 nonce");
        assert!((100_000..=200_000).contains(&nonce));
    }
}

#[test]
fn invalid_input_is_rejected() {
    assert!(matches!(
        create(&DsSigningOptions::new("", DsGeneration::V1)),
        Err(DsError::MissingSalt)
    ));
    assert!(matches!(
        create(&DsSigningOptions::new(SALT, DsGeneration::V1).with_nonce("ABC123")),
        Err(DsError::InvalidV1Nonce(_))
    ));
    assert!(matches!(
        create(&DsSigningOptions::new(SALT, DsGeneration::V2).with_nonce("12ab")),
        Err(DsError::InvalidV2Nonce(_))
    ));
    assert!(matches!(DsSigner::create_policy(""), Err(DsError::MissingSalt)));
}

#[test]
fn debug_output_never_reveals_the_salt() {
    // A dedicated value, so the assertion cannot pass because of an unrelated string.
    const SECRET: &str = "s3cret-salt-material-6f2a";

    let options = DsSigningOptions::new(SECRET, DsGeneration::V2)
        .with_body(r#"{"token":"placeholder"}"#)
        .with_query("a=1")
        .with_timestamp(1_700_000_000)
        .with_nonce("123456");
    let rendered = format!("{options:?}");
    assert!(!rendered.contains(SECRET), "DsSigningOptions leaked: {rendered}");
    assert!(rendered.contains("<redacted>"), "salt is not marked: {rendered}");

    let signature = create(&options).expect("V2 signing");
    // The payload starts with `salt=`, so hiding the field alone would not be enough.
    assert!(signature.payload.contains(SECRET));
    let rendered = format!("{signature:?}");
    assert!(!rendered.contains(SECRET), "DsSignature leaked: {rendered}");
    assert!(rendered.contains(&signature.digest), "digest should stay visible: {rendered}");

    // `Policy` requires `Debug`, and the pipeline may print its policies.
    let policy = DsSigner::create_policy(SECRET).expect("create policy");
    let rendered = format!("{policy:?}");
    assert!(!rendered.contains(SECRET), "DsSigningPolicy leaked: {rendered}");
}

#[tokio::test]
async fn clients_sign_omitted_ds_headers_without_replacing_explicit_ones() {
    let (endpoint, recorded) = start_mock_server();

    let mut records_options = CnGameRecordsClientOptions::default();
    DsSigner::configure(&mut records_options.client_options, SALT).expect("configure");
    let records = CnGameRecordsClient::with_no_credential(&endpoint, Some(records_options))
        .expect("create records client");

    records
        .get_cn_game_records_star_rail_api_client()
        .get_simulated_universe("ltuid=123".to_owned(), "prod_gf_cn", "123456", None)
        .await
        .expect("V2 request");

    records
        .get_cn_game_records_star_rail_api_client()
        .get_simulated_universe(
            "ltuid=123".to_owned(),
            "prod_gf_cn",
            "42",
            Some(CnGameRecordsStarRailApiClientGetSimulatedUniverseOptions {
                ds: Some("explicit-ds".to_owned()),
                ..Default::default()
            }),
        )
        .await
        .expect("explicit DS request");

    let mut account_options = GameAccountClientOptions::default();
    DsSigner::configure(&mut account_options.client_options, SALT).expect("configure");
    let account = GameAccountClient::with_no_credential(&endpoint, Some(account_options))
        .expect("create account client");

    account
        .get_game_account_binding_api_client()
        .generate_auth_key(
            "ltuid=123".to_owned(),
            RequestContent::from_str(r#"{"game_biz":"hk4e_cn","game_uid":100000001,"region":"cn_gf01"}"#),
            None,
        )
        .await
        .expect("V1 request");

    let requests = recorded.lock().expect("recorded requests");

    let v2 = find(
        &requests,
        "/game_record/app/hkrpg/api/rogue?role_id=123456&server=prod_gf_cn",
    );
    let [timestamp, nonce, digest] = split_header(&v2.ds);
    assert!(nonce.parse::<u32>().is_ok(), "V2 nonce must be numeric: {nonce}");
    let query = canonicalize_query(v2.target.split_once('?').expect("query string").1);
    assert_eq!(
        digest,
        md5(&format!(
            "salt={SALT}&t={timestamp}&r={nonce}&b=&q={query}"
        )),
        "V2 digest must cover the transmitted query"
    );

    let v1 = find(&requests, "/binding/api/genAuthKey");
    let [timestamp, nonce, digest] = split_header(&v1.ds);
    assert_eq!(6, nonce.len(), "V1 nonce must be six characters: {nonce}");
    assert_eq!(
        digest,
        md5(&format!("salt={SALT}&t={timestamp}&r={nonce}")),
        "V1 digest must cover only salt, timestamp and nonce"
    );

    let explicit = find(
        &requests,
        "/game_record/app/hkrpg/api/rogue?role_id=42&server=prod_gf_cn",
    );
    assert_eq!(Some("explicit-ds".to_owned()), explicit.ds);
}

fn md5(payload: &str) -> String {
    format!("{:x}", md5::compute(payload.as_bytes()))
}

fn split_header(ds: &Option<String>) -> [String; 3] {
    let value = ds.as_ref().expect("DS header must be present");
    let parts: Vec<String> = value.split(',').map(str::to_owned).collect();
    assert_eq!(3, parts.len(), "unexpected DS header: {value}");
    assert_eq!(32, parts[2].len(), "unexpected DS digest: {value}");
    assert!(parts[2].bytes().all(|byte| byte.is_ascii_hexdigit()));
    [parts[0].clone(), parts[1].clone(), parts[2].clone()]
}

fn find<'a>(requests: &'a [RecordedRequest], target: &str) -> &'a RecordedRequest {
    requests
        .iter()
        .find(|request| request.target == target)
        .unwrap_or_else(|| {
            panic!(
                "no request for {target}; recorded: {:?}",
                requests.iter().map(|request| &request.target).collect::<Vec<_>>()
            )
        })
}

#[derive(Debug)]
struct RecordedRequest {
    target: String,
    ds: Option<String>,
}

/// Serves every request with a generic success envelope and records the request line and
/// `DS` header, mirroring the mock transports the other client tests use.
fn start_mock_server() -> (String, Arc<Mutex<Vec<RecordedRequest>>>) {
    let listener = TcpListener::bind("127.0.0.1:0").expect("bind mock server");
    let endpoint = format!("http://{}", listener.local_addr().expect("mock address"));
    let recorded = Arc::new(Mutex::new(Vec::new()));
    let sink = Arc::clone(&recorded);

    thread::spawn(move || {
        for stream in listener.incoming() {
            let Ok(stream) = stream else { break };
            handle(stream, &sink);
        }
    });

    (endpoint, recorded)
}

fn handle(mut stream: TcpStream, sink: &Arc<Mutex<Vec<RecordedRequest>>>) {
    let mut buffer = Vec::new();
    let mut chunk = [0u8; 4096];
    let header_end = loop {
        match stream.read(&mut chunk) {
            Ok(0) | Err(_) => return,
            Ok(read) => {
                buffer.extend_from_slice(&chunk[..read]);
                if let Some(index) = buffer.windows(4).position(|w| w == b"\r\n\r\n") {
                    break index + 4;
                }
            }
        }
    };

    let head = String::from_utf8_lossy(&buffer[..header_end]).into_owned();
    let mut lines = head.split("\r\n");
    let target = lines
        .next()
        .and_then(|line| line.split(' ').nth(1))
        .unwrap_or_default()
        .to_owned();
    let mut ds = None;
    let mut content_length = 0usize;
    for line in lines {
        let Some((name, value)) = line.split_once(':') else {
            continue;
        };
        if name.eq_ignore_ascii_case("ds") {
            ds = Some(value.trim().to_owned());
        } else if name.eq_ignore_ascii_case("content-length") {
            content_length = value.trim().parse().unwrap_or(0);
        }
    }

    let mut remaining = content_length.saturating_sub(buffer.len() - header_end);
    while remaining > 0 {
        match stream.read(&mut chunk) {
            Ok(0) | Err(_) => break,
            Ok(read) => remaining = remaining.saturating_sub(read),
        }
    }

    sink.lock().expect("record request").push(RecordedRequest { target, ds });

    const PAYLOAD: &str = r#"{"retcode":0,"message":"OK","data":{}}"#;
    let response = format!(
        "HTTP/1.1 200 OK\r\ncontent-type: application/json\r\ncontent-length: {}\r\nconnection: close\r\n\r\n{PAYLOAD}",
        PAYLOAD.len()
    );
    let _ = stream.write_all(response.as_bytes());
    let _ = stream.flush();
}
