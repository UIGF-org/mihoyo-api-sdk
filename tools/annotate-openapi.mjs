import { readFile, writeFile } from "node:fs/promises";
import { resolve } from "node:path";
import { parse, stringify } from "yaml";

const outputDirectory = resolve(process.cwd(), process.argv[2] ?? "generated");
const manifestPath = resolve(outputDirectory, "ds", "ds-manifest.json");
const manifest = JSON.parse(await readFile(manifestPath, "utf8"));

function toExtension(requirement) {
  return {
    generation: requirement.generation,
    header: requirement.header,
    ...(requirement.generation === "v2"
      ? {
          canonicalization: {
            body: requirement.body,
            query: requirement.query,
          },
        }
      : {}),
  };
}

for (const service of manifest.services) {
  const specificationPath = resolve(
    outputDirectory,
    "openapi",
    `openapi.${service.service}.yaml`,
  );
  const specification = parse(await readFile(specificationPath, "utf8"));
  const pending = new Map(
    service.operations.map((requirement) => [requirement.operationId, requirement]),
  );

  for (const pathItem of Object.values(specification.paths ?? {})) {
    for (const method of ["get", "put", "post", "patch", "delete", "head", "options"]) {
      const operation = pathItem?.[method];
      if (!operation?.operationId) continue;

      const requirement = pending.get(operation.operationId);
      if (!requirement) continue;

      operation["x-uigf-ds"] = toExtension(requirement);
      pending.delete(operation.operationId);
    }
  }

  if (pending.size > 0) {
    throw new Error(
      `Could not locate DS operations in ${specificationPath}: ${[...pending.keys()].join(", ")}`,
    );
  }

  await writeFile(specificationPath, stringify(specification), "utf8");
}
