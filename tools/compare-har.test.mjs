import assert from "node:assert/strict";
import test from "node:test";
import { collectHarEndpoints, compareEndpoints } from "./compare-har.mjs";

test("HAR comparison excludes static assets and never retains request values", () => {
  const collected = collectHarEndpoints({
    log: {
      entries: [
        {
          request: {
            method: "GET",
            url: "https://api-takumi.mihoyo.com/event/example?token=secret-value&lang=zh-cn",
            queryString: [{ name: "token", value: "secret-value" }, { name: "lang", value: "zh-cn" }],
          },
          response: { status: 200 },
        },
        {
          request: { method: "GET", url: "https://webstatic.mihoyo.com/event/example.js" },
          response: { status: 200 },
        },
      ],
    },
  });

  assert.equal(collected.endpoints.length, 1);
  assert.deepEqual(collected.endpoints[0].query, ["lang", "token"]);
  assert.equal(JSON.stringify(collected), JSON.stringify(collected).replaceAll("secret-value", ""));
});

test("HAR comparison reports host and parameter mismatches", () => {
  const report = compareEndpoints(
    [{ method: "get", origin: "https://static.mihoyo.com", path: "/example", count: 1, statuses: [200], query: ["known", "new"], bodyKind: "object", bodyFields: ["known", "new"] }],
    [{ service: "Example", method: "get", origin: "https://api.mihoyo.com", path: "/example", query: ["known"], bodyFields: ["known"] }],
  );

  assert.equal(report[0].status, "host-mismatch");
  assert.deepEqual(report[0].undocumentedQuery, ["new"]);
  assert.deepEqual(report[0].undocumentedBodyFields, ["new"]);
});

test("HAR comparison recognizes parameterized OpenAPI paths", () => {
  const report = compareEndpoints(
    [{ method: "post", origin: "https://sdk.mihoyo.com", path: "/hk4e_cn/mdk/example", count: 1, statuses: [200], query: [], bodyKind: "empty", bodyFields: [] }],
    [{ service: "Dynamic", method: "post", origin: undefined, path: "/{gameBiz}/mdk/example", query: [], bodyFields: [], bodyAllowsAdditionalProperties: false }],
  );

  assert.equal(report[0].status, "covered-by-dynamic-server");
});
