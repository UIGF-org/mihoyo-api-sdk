import {
  createTypeSpecLibrary,
  emitFile,
  getNamespaceFullName,
  resolvePath,
} from "@typespec/compiler";
import { getAllHttpServices } from "@typespec/http";

export const $lib = createTypeSpecLibrary({
  name: "@uigf/typespec-ds",
  diagnostics: {},
});

const dsRequirementKey = $lib.createStateSymbol("ds-requirement");

/** Stores the signing rule as native TypeSpec decorator state. */
export function $requiresDs(context, target, generation) {
  const value = typeof generation === "string" ? generation : generation.value;
  context.program.stateMap(dsRequirementKey).set(target, { generation: value });
}

function getDsRequirement(program, operation) {
  return (
    program.stateMap(dsRequirementKey).get(operation) ??
    (operation.interface
      ? program.stateMap(dsRequirementKey).get(operation.interface)
      : undefined)
  );
}

function requiresDsHeader(httpOperation) {
  return httpOperation.parameters.parameters.some(
    (parameter) =>
      parameter.type === "header" && parameter.name.toLowerCase() === "ds",
  );
}

function getOperationId(operation) {
  const containerName = operation.interface?.name ?? operation.namespace?.name;
  return containerName ? `${containerName}_${operation.name}` : operation.name;
}

/**
 * Emitter output intentionally contains protocol metadata only: no signing salt,
 * secret, cookie, or credential is written to the SDK artifact.
 */
export async function $onEmit(context) {
  const [services, diagnostics] = getAllHttpServices(context.program);
  context.program.reportDiagnostics(diagnostics);

  const emittedServices = services
    .map((service) => {
      const operations = service.operations.flatMap((httpOperation) => {
        const requirement = getDsRequirement(context.program, httpOperation.operation);
        if (!requirement || !requiresDsHeader(httpOperation)) {
          return [];
        }

        return [
          {
            operationId: getOperationId(httpOperation.operation),
            method: httpOperation.verb.toUpperCase(),
            path: httpOperation.path,
            generation: requirement.generation,
            header: "DS",
            ...(requirement.generation === "v2"
              ? {
                  body: "exact-serialized",
                  query: "lexicographic-segments",
                }
              : {}),
          },
        ];
      });

      return {
        service: getNamespaceFullName(service.namespace),
        operations,
      };
    })
    .filter((service) => service.operations.length > 0);

  await emitFile(context.program, {
    path: resolvePath(context.emitterOutputDir, "ds-manifest.json"),
    content: `${JSON.stringify(
      { version: 1, services: emittedServices },
      null,
      2,
    )}\n`,
  });
}
