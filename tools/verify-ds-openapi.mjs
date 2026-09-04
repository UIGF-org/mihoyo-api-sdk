import { readFile } from "node:fs/promises";
import { resolve } from "node:path";
import { parse } from "yaml";

const outputDirectory = resolve(process.cwd(), process.argv[2] ?? "generated");
const manifest = JSON.parse(
  await readFile(resolve(outputDirectory, "ds", "ds-manifest.json"), "utf8"),
);
let checked = 0;

for (const service of manifest.services) {
  const specificationPath = resolve(
    outputDirectory,
    "openapi",
    `openapi.${service.service}.yaml`,
  );
  const specification = parse(await readFile(specificationPath, "utf8"));
  const byOperationId = new Map();

  for (const pathItem of Object.values(specification.paths ?? {})) {
    for (const operation of Object.values(pathItem ?? {})) {
      if (operation?.operationId) byOperationId.set(operation.operationId, operation);
    }
  }

  for (const requirement of service.operations) {
    const extension = byOperationId.get(requirement.operationId)?.["x-uigf-ds"];
    if (!extension) {
      throw new Error(`Missing x-uigf-ds on ${service.service}/${requirement.operationId}.`);
    }
    if (extension.generation !== requirement.generation || extension.header !== "DS") {
      throw new Error(`Incorrect x-uigf-ds on ${service.service}/${requirement.operationId}.`);
    }
    if (
      requirement.generation === "v2" &&
      (extension.canonicalization?.body !== "exact-serialized" ||
        extension.canonicalization?.query !== "lexicographic-segments")
    ) {
      throw new Error(`Missing V2 canonicalization metadata on ${requirement.operationId}.`);
    }
    checked += 1;
  }
}

if (checked === 0) throw new Error("The DS emitter produced no annotated operations.");
console.log(`Verified x-uigf-ds metadata on ${checked} OpenAPI operations.`);
