import { createHash, randomBytes, randomInt } from "node:crypto";

/** The two Dynamic Secret payload layouts observed in the reference clients. */
export type DsGeneration = 1 | 2;

/** A scalar query value accepted by the canonical query helper. */
export type DsQueryValue = string | number | boolean | readonly (string | number | boolean)[];

/** Query input that can be normalized before it is placed in the DS payload. */
export type DsQuery = string | URL | URLSearchParams | Readonly<Record<string, DsQueryValue>>;

/**
 * Input to the Dynamic Secret algorithm. `salt` is deliberately supplied by the
 * caller: this package never contains vendor salts or discovers them at runtime.
 */
export interface DsSigningOptions {
  readonly salt: string;
  readonly generation: DsGeneration;
  /** Exact serialized HTTP request body. Required only when the request has a body. */
  readonly body?: string;
  /** Query parameters; V2 query segments are sorted lexicographically. */
  readonly query?: DsQuery;
  /** Unix seconds. Supplying this makes signing deterministic for tests/retries. */
  readonly timestamp?: number;
  /** Six-character V1 or numeric V2 nonce. Supplying this makes signing deterministic. */
  readonly nonce?: string;
}

/** Parsed form of a generated `DS` header. */
export interface DsSignature {
  readonly value: string;
  readonly timestamp: number;
  readonly nonce: string;
  readonly digest: string;
  readonly payload: string;
}

const ALPHANUMERIC_LOWER = "0123456789abcdefghijklmnopqrstuvwxyz";

/**
 * Sorts query segments exactly as the reference desktop clients do: by their
 * already-serialized `key=value` text. Pass a string when the HTTP client has
 * custom encoding rules and that exact wire representation must be signed.
 */
export function canonicalizeDsQuery(query: DsQuery | undefined): string {
  if (query === undefined) return "";

  if (typeof query === "string") return canonicalizeQueryString(query);
  if (query instanceof URL) return canonicalizeQueryString(decodeURIComponent(query.search));
  if (query instanceof URLSearchParams) {
    return canonicalizeQueryString(
      [...query.entries()].map(([key, value]) => `${key}=${value}`).join("&"),
    );
  }

  return Object.keys(query)
    .sort()
    .map((key) => `${key}=${String(query[key])}`)
    .join("&");
}

/** Generates a DS header using caller-provided salt material. */
export function createDs(options: DsSigningOptions): DsSignature {
  if (options.salt.length === 0) {
    throw new Error("DS salt must be provided by the caller.");
  }

  const timestamp = options.timestamp ?? Math.floor(Date.now() / 1000);
  if (!Number.isSafeInteger(timestamp) || timestamp < 0) {
    throw new RangeError("DS timestamp must be a non-negative safe integer in Unix seconds.");
  }

  const nonce = options.nonce ?? createNonce(options.generation);
  validateNonce(options.generation, nonce);

  const prefix = `salt=${options.salt}&t=${timestamp}&r=${nonce}`;
  const payload =
    options.generation === 1
      ? prefix
      : `${prefix}&b=${options.body ?? ""}&q=${canonicalizeDsQuery(options.query)}`;
  const digest = createHash("md5").update(payload, "utf8").digest("hex");

  return { value: `${timestamp},${nonce},${digest}`, timestamp, nonce, digest, payload };
}

/** Returns only the HTTP header value for code that does not need signing diagnostics. */
export function createDsHeader(options: DsSigningOptions): string {
  return createDs(options).value;
}

/**
 * Serializes a JSON body for both signing and HTTP transmission. Use the returned
 * string unchanged as the request body so V2's `b` component stays byte-for-byte
 * identical to the transmitted JSON.
 */
export function serializeDsJsonBody(value: unknown): string {
  const serialized = JSON.stringify(value);
  if (serialized === undefined) {
    throw new TypeError("DS JSON body must serialize to a JSON value.");
  }
  return serialized;
}

function canonicalizeQueryString(query: string): string {
  const withoutQuestionMark = query.startsWith("?") ? query.slice(1) : query;
  if (withoutQuestionMark.length === 0) return "";
  return withoutQuestionMark.split("&").sort().join("&");
}

function createNonce(generation: DsGeneration): string {
  if (generation === 2) return String(randomInt(100_000, 200_001));

  const bytes = randomBytes(6);
  let nonce = "";
  for (const byte of bytes) nonce += ALPHANUMERIC_LOWER[byte % ALPHANUMERIC_LOWER.length];
  return nonce;
}

function validateNonce(generation: DsGeneration, nonce: string): void {
  if (generation === 1 && !/^[0-9a-z]{6}$/.test(nonce)) {
    throw new RangeError("V1 DS nonce must contain exactly six lowercase alphanumeric characters.");
  }
  if (generation === 2 && !/^\d+$/.test(nonce)) {
    throw new RangeError("V2 DS nonce must be numeric.");
  }
}
