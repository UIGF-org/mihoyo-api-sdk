import assert from "node:assert/strict";
import { spawn } from "node:child_process";
import { createHash } from "node:crypto";
import { once } from "node:events";
import { mkdtemp, mkdir, rm, writeFile } from "node:fs/promises";
import { createServer } from "node:http";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const root = fileURLToPath(new URL("../", import.meta.url));
const clientProject = join(root, "generated", "clients", "csharp", "src", "UIGF.Mihoyo.csproj").replaceAll("\\", "/");

test("C# client automatically signs V1 and V2 business requests", async () => {
  const requests = [];
  const server = createServer((incoming, response) => {
    requests.push({ ds: incoming.headers.ds, url: incoming.url });
    response.writeHead(200, { "content-type": "application/json" });
    response.end('{"retcode":0,"message":"OK","data":{}}');
  });
  server.listen(0, "127.0.0.1");
  await once(server, "listening");
  const endpoint = `http://127.0.0.1:${server.address().port}`;
  const directory = await mkdtemp(join(tmpdir(), "uigf-csharp-ds-"));
  try {
    await mkdir(directory, { recursive: true });
    await writeFile(join(directory, "DsSignerVectors.csproj"), `
<Project Sdk="Microsoft.NET.Sdk">
  <PropertyGroup><OutputType>Exe</OutputType><TargetFramework>net8.0</TargetFramework></PropertyGroup>
  <ItemGroup><ProjectReference Include="${clientProject}" /></ItemGroup>
</Project>
`);
    await writeFile(join(directory, "Program.cs"), `
using UIGF.Mihoyo;
using UIGF.Game.Genshin.Record;
using UIGF.Game.Account;
using UIGF.Game;
using System;
using System.ClientModel.Primitives;
using System.Net.Http;

static void Equal(string expected, string actual)
{
    if (expected != actual) throw new Exception($"Expected '{expected}', got '{actual}'.");
}

var v1 = DsSigner.Create(new DsSigningOptions("caller-provided-salt", DsGeneration.V1)
{
    Timestamp = 1_700_000_000,
    Nonce = "abc123",
});
Equal("4e73fb371dec2794ccd8908d6d1c0273", v1.Digest);
Equal("1700000000,abc123,4e73fb371dec2794ccd8908d6d1c0273", v1.Value);

var v2 = DsSigner.Create(new DsSigningOptions("caller-provided-salt", DsGeneration.V2)
{
    Body = "{\\\"b\\\":2,\\\"a\\\":1}",
    Query = "z=last&a=first",
    Timestamp = 1_700_000_000,
    Nonce = "123456",
});
Equal("a=first&z=last", DsSigner.CanonicalizeQuery("?z=last&a=first"));
Equal("dea0c2f2d886ba77d909103b373292c9", v2.Digest);
Equal("1700000000,123456,dea0c2f2d886ba77d909103b373292c9", v2.Value);

var options = DsSigner.CreateClientOptions("caller-provided-salt");
options.Transport = new HttpClientPipelineTransport(new HttpClient(new HttpClientHandler { UseProxy = false }));
var client = new RecordClient(new Uri("${endpoint}"), options);
await client.GetCardApiClient().GetGameRecordCardAsync("ltuid=123", "42");

var accountOptions = DsSigner.CreateClientOptions("caller-provided-salt");
accountOptions.Transport = new HttpClientPipelineTransport(new HttpClient(new HttpClientHandler { UseProxy = false }));
var accountClient = new GameAccountClient(new Uri("${endpoint}"), accountOptions);
await accountClient.GetGameBindingApiClient().GenerateAuthKeyAsync(
    "ltuid=123",
    new AuthKeyRequest("hk4e_cn", "hk4e_cn", "100000001", "cn_gf01"));
`);
    const result = await run("dotnet", ["run", "--project", join(directory, "DsSignerVectors.csproj"), "--configuration", "Release", "--nologo"], {
      cwd: root,
      env: { ...process.env, NO_PROXY: "127.0.0.1,localhost", no_proxy: "127.0.0.1,localhost" },
    });
    assert.equal(result.error, undefined, result.error?.message);
    assert.equal(result.status, 0, `${result.stdout}\n${result.stderr}`);
    const v2 = requests.find((request) => request.url === "/game_record/app/card/wapi/getGameRecordCard?uid=42");
    assert.match(v2?.ds ?? "", /^\d+,\d+,[0-9a-f]{32}$/);
    const [v2Timestamp, v2Nonce, v2Digest] = v2.ds.split(",");
    const v2Payload = `salt=caller-provided-salt&t=${v2Timestamp}&r=${v2Nonce}&b=&q=uid=42`;
    assert.equal(v2Digest, createHash("md5").update(v2Payload, "utf8").digest("hex"));

    const v1 = requests.find((request) => request.url === "/binding/api/genAuthKey");
    assert.match(v1?.ds ?? "", /^\d+,[0-9a-z]{6},[0-9a-f]{32}$/);
    const [v1Timestamp, v1Nonce, v1Digest] = v1.ds.split(",");
    const v1Payload = `salt=caller-provided-salt&t=${v1Timestamp}&r=${v1Nonce}`;
    assert.equal(v1Digest, createHash("md5").update(v1Payload, "utf8").digest("hex"));
  } finally {
    await rm(directory, { recursive: true, force: true });
    server.close();
    await once(server, "close");
  }
});

function run(command, args, options) {
  return new Promise((resolve) => {
    const child = spawn(command, args, options);
    let stdout = "";
    let stderr = "";
    let error;
    child.stdout.setEncoding("utf8").on("data", (chunk) => { stdout += chunk; });
    child.stderr.setEncoding("utf8").on("data", (chunk) => { stderr += chunk; });
    child.on("error", (reason) => { error = reason; });
    child.on("close", (status) => resolve({ error, status, stderr, stdout }));
  });
}
