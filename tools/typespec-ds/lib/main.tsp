import "@typespec/compiler";
import "../dist/tsp-index.js";

using TypeSpec.Reflection;

namespace UIGF.Security;

/**
 * Declares the Dynamic Secret generation required by an operation or interface.
 * The emitter writes the resolved requirement to the generated DS manifest.
 */
extern dec requiresDs(target: Operation | Interface, generation: "v1" | "v2");
