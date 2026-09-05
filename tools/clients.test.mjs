import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import { createRequire } from "node:module";
import { fileURLToPath } from "node:url";
import test from "node:test";
import { compile, getNamespaceFullName, listServices, NodeHost } from "@typespec/compiler";
import { getAllHttpServices } from "@typespec/http";
import * as sdk from "../generated/clients/javascript/dist/index.js";

const require = createRequire(new URL("../generated/clients/javascript/package.json", import.meta.url));
const { createHttpHeaders } = require("@azure/core-rest-pipeline");

function mockResponse(data = { preserved_vendor_field: true }, status = 200) {
  const requests = [];
  return {
    requests,
    options: {
      retryOptions: { maxRetries: 0 },
      httpClient: {
        async sendRequest(request) {
          requests.push(request);
          return { request, status, headers: createHttpHeaders({ "content-type": "application/json" }),
            bodyAsText: JSON.stringify({ retcode: 0, message: "OK", data }) };
        },
      },
    },
  };
}

test("all four SDKs cover every TypeSpec service, and all JS clients can be constructed", async () => {
  const program = await compile(NodeHost, fileURLToPath(new URL("../main.tsp", import.meta.url)), { noEmit: true });
  assert.equal(program.hasError(), false);
  const services = listServices(program).map((s) => getNamespaceFullName(s.type)).sort();
  for (const language of ["csharp", "java", "python", "javascript"]) {
    const manifest = JSON.parse(await readFile(new URL(`../generated/clients/${language}/services.json`, import.meta.url)));
    assert.deepEqual(manifest.services, services, language);
  }
  assert.equal(Object.keys(sdk).length, services.length);
  const [httpServices] = getAllHttpServices(program);
  const normalize = (name) => name.replaceAll("_", "").toLowerCase();
  for (const service of services) {
    const name = service.split(".").slice(1).join("");
    const Client = sdk[name][`${name}Client`];
    assert.equal(typeof Client, "function", service);
    const mock = mockResponse();
    const client = service === "UIGF.Commerce.CN" ? new Client("https://hk4e-sdk.mihoyo.com", mock.options) : new Client(mock.options);
    assert.ok(client.pipeline, service);
    const httpService = httpServices.find((s) => getNamespaceFullName(s.namespace) === service);
    for (const { operation } of httpService.operations) {
      const group = operation.interface
        ? client[Object.keys(client).find((key) => normalize(key) === normalize(operation.interface.name))]
        : client;
      assert.ok(group, `${service}.${operation.interface?.name}`);
      const method = Object.keys(group).find((key) => normalize(key) === normalize(operation.name));
      assert.equal(typeof group[method], "function", `${service}.${operation.name}`);
    }
    assert.equal(mock.requests.length, 0);
  }
});

test("signed requests preserve wire names, false and zero query values", async () => {
  const mock = mockResponse();
  const client = new sdk.GameCNRecords.GameCNRecordsClient(mock.options);
  const response = await client.starRailApi.getSimulatedUniverse("cookie-placeholder", "ds-placeholder", "prod_gf_cn", "123456", {
    scheduleType: 0, needDetail: false, needAll: false,
  });
  const request = mock.requests[0];
  const url = new URL(request.url);
  assert.equal(url.origin, "https://api-takumi-record.mihoyo.com");
  assert.equal(url.pathname, "/game_record/app/hkrpg/api/rogue");
  assert.equal(url.searchParams.get("role_id"), "123456");
  assert.equal(url.searchParams.get("need_detail"), "false");
  assert.equal(url.searchParams.getAll("need_detail").length, 1);
  assert.equal(url.searchParams.get("need_all"), "false");
  assert.equal(url.searchParams.get("schedule_type"), "0");
  assert.equal(request.headers.get("Cookie"), "cookie-placeholder");
  assert.equal(request.headers.get("DS"), "ds-placeholder");
  assert.equal(response.data.additionalProperties.preserved_vendor_field, true);
});

test("POST sends arbitrary JSON payloads and Cookie to the correct service", async () => {
  const mock = mockResponse({ token: "placeholder" });
  const client = new sdk.PassportV4.PassportV4Client(mock.options);
  await client.sessionApi.verifyLToken("cookie-placeholder", {
    additionalProperties: { ltoken: "placeholder", custom_field: { value: 0 } },
  });
  assert.equal(mock.requests[0].method, "POST");
  assert.equal(new URL(mock.requests[0].url).origin, "https://passport-api-v4.mihoyo.com");
  assert.deepEqual(JSON.parse(mock.requests[0].body), { ltoken: "placeholder", custom_field: { value: 0 } });
});

test("Commerce uses the selected endpoint and encodes order query parameters", async () => {
  const mock = mockResponse();
  const client = new sdk.CommerceCN.CommerceCNClient("https://hk4e-sdk.mihoyo.com", mock.options);
  await client.shopApi.checkOrder("hk4e_cn", "order & 123", "hk4e", "cn_gf01", "123456");
  const url = new URL(mock.requests[0].url);
  assert.equal(url.origin, "https://hk4e-sdk.mihoyo.com");
  assert.equal(url.pathname, "/hk4e_cn/mdk/atropos/api/checkOrder");
  assert.equal(url.searchParams.get("order_no"), "order & 123");
});

test("HTTP errors reject instead of returning a successful result", async () => {
  const mock = mockResponse({}, 403);
  const client = new sdk.GameCNRecords.GameCNRecordsClient(mock.options);
  await assert.rejects(client.starRailApi.getSimulatedUniverse("cookie", "ds", "prod_gf_cn", "123456"), { statusCode: 403 });
});
