import assert from "node:assert/strict";
import test from "node:test";

import { canonicalizeDsQuery, createDs, serializeDsJsonBody } from "./ds.js";

test("creates deterministic generation 1 DS", () => {
  const signature = createDs({
    salt: "caller-provided-salt",
    generation: 1,
    timestamp: 1_700_000_000,
    nonce: "abc123",
  });

  assert.equal(signature.payload, "salt=caller-provided-salt&t=1700000000&r=abc123");
  assert.equal(signature.digest, "4e73fb371dec2794ccd8908d6d1c0273");
  assert.equal(signature.value, "1700000000,abc123,4e73fb371dec2794ccd8908d6d1c0273");
});

test("creates generation 2 DS from the exact body and sorted query", () => {
  const body = serializeDsJsonBody({ b: 2, a: 1 });
  const signature = createDs({
    salt: "caller-provided-salt",
    generation: 2,
    timestamp: 1_700_000_000,
    nonce: "123456",
    body,
    query: "z=last&a=first",
  });

  assert.equal(signature.payload, 'salt=caller-provided-salt&t=1700000000&r=123456&b={"b":2,"a":1}&q=a=first&z=last');
  assert.equal(signature.digest, "dea0c2f2d886ba77d909103b373292c9");
});

test("canonicalizes object, URL, and raw query input", () => {
  assert.equal(canonicalizeDsQuery({ z: true, a: [1, 2] }), "a=1,2&z=true");
  assert.equal(canonicalizeDsQuery(new URL("https://example.test/?z=last&a=first")), "a=first&z=last");
  assert.equal(canonicalizeDsQuery(new URL("https://example.test/?z=%2B&a=hello%20world")), "a=hello world&z=+");
  assert.equal(canonicalizeDsQuery("?z=last&a=first"), "a=first&z=last");
});

test("rejects absent salts and invalid nonces", () => {
  assert.throws(() => createDs({ salt: "", generation: 1, nonce: "abc123" }), /salt/);
  assert.throws(() => createDs({ salt: "s", generation: 1, nonce: "123" }), /six/);
  assert.throws(() => createDs({ salt: "s", generation: 2, nonce: "abc123" }), /numeric/);
});
