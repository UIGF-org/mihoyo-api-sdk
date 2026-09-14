import assert from "node:assert/strict";
import { spawn } from "node:child_process";
import { readFile } from "node:fs/promises";
import { join } from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const crate = fileURLToPath(new URL("../generated/clients/rust", import.meta.url));
const cargo = await findCargo();

test("Rust client automatically signs omitted V1 and V2 DS headers", { skip: !cargo }, async () => {
  // The DS vectors, the nonce shape, and the live mock-server round trip all live in
  // tools/client-packaging/rust/tests/ds.rs so they exercise the generated pipeline.
  const result = await run("cargo", ["test", "--test", "ds"], crate);
  assert.equal(result.error, undefined, result.error?.message);
  assert.equal(result.status, 0, `${result.stdout}\n${result.stderr}`);
  assert.match(result.stdout, /test result: ok\. 6 passed; 0 failed/);
});

test("generated crate keeps the packaged manifest and DS modules", async () => {
  const manifest = await readFile(join(crate, "Cargo.toml"), "utf8");
  assert.match(manifest, /^name = "uigf-mihoyo"$/m);
  assert.match(manifest, /^edition = "2024"$/m);
  // The crate must not fall back to azure_core's defaults, which add deflate/gzip.
  assert.match(manifest, /^azure_core = \{ version = "1\.1", default-features = false, features = \["reqwest", "reqwest_rustls", "tokio"\] \}$/m);
  assert.match(manifest, /^md5 = "0\.8"$/m);

  const lib = await readFile(join(crate, "src", "lib.rs"), "utf8");
  assert.match(lib, /^mod ds_operation_map;$/m);
  assert.match(lib, /^pub mod ds;$/m);

  const map = await readFile(join(crate, "src", "ds_operation_map.rs"), "utf8");
  assert.match(map, /"\/game_record\/app\/hkrpg\/api\/rogue" => Some\(DsGeneration::V2\)/);
  assert.match(map, /"\/binding\/api\/genAuthKey" => Some\(DsGeneration::V1\)/);
});

async function findCargo() {
  const result = await run("cargo", ["--version"], crate);
  return result.status === 0 && result.error === undefined;
}

function run(command, args, cwd) {
  return new Promise((resolve) => {
    const child = spawn(command, args, { cwd });
    let stdout = "";
    let stderr = "";
    let error;
    child.stdout.setEncoding("utf8").on("data", (chunk) => { stdout += chunk; });
    child.stderr.setEncoding("utf8").on("data", (chunk) => { stderr += chunk; });
    child.on("error", (reason) => { error = reason; });
    child.on("close", (status) => resolve({ error, status, stderr, stdout }));
  });
}
