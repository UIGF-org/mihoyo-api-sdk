/** Dynamic Secret signing input. The caller owns salt retrieval and rotation. */
namespace UIGF.Security;

/**
 * `@requiresDs("v1" | "v2")` is supplied by the local `@uigf/typespec-ds`
 * library. Its custom emitter writes a DS manifest; the post-processor then adds
 * an `x-uigf-ds` extension to each corresponding OpenAPI operation.
 */
enum DsGeneration {
  /** `salt={salt}&t={timestamp}&r={nonce}` */
  v1,

  /** `salt={salt}&t={timestamp}&r={nonce}&b={body}&q={query}` */
  v2,
}

/**
 * Contract for the executable `@uigf/mihoyo-api-sdk/ds` runtime. `salt` is
 * supplied by the application and must not be persisted in this specification.
 */
model DsSigningInput {
  generation: DsGeneration;
  timestamp?: int64;
  nonce?: string;
  body?: string;
  query?: string;
}

model DsSigningResult {
  value: string;
  timestamp: int64;
  nonce: string;
  digest: string;
}
