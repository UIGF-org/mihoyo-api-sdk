import { delimiter, join } from "node:path";
import { fileURLToPath } from "node:url";
import { spawnSync } from "node:child_process";

const root = fileURLToPath(new URL("../", import.meta.url));
const languages = process.argv.length > 2 ? process.argv.slice(2) : ["csharp", "java", "python", "javascript"];
process.env.PATH = [process.env.JAVA_HOME, process.env.MAVEN_HOME]
  .filter(Boolean).map((home) => join(home, "bin")).concat(process.env.PATH ?? "").join(delimiter);

for (const language of languages) {
  const cwd = join(root, "generated", "clients", language);
  switch (language) {
    case "csharp":
      run("dotnet", ["pack", "src/UIGF.Mihoyo.csproj", "--configuration", "Release", "--nologo"], cwd);
      break;
    case "java":
      run("mvn", ["--batch-mode", "--no-transfer-progress", "package"], cwd);
      break;
    case "python":
      run("python", ["-m", "pip", "wheel", ".", "--no-deps", "--wheel-dir", "dist"], cwd);
      break;
    case "javascript":
      run("npm", ["install", "--no-audit", "--no-fund"], cwd);
      run("npm", ["run", "build"], cwd);
      run("npm", ["pack", "--silent"], cwd);
      break;
    default:
      throw new Error(`Unknown language: ${language}`);
  }
}

function run(command, args, cwd) {
  const result = spawnSync(command, args, {
    cwd, stdio: "inherit", shell: process.platform === "win32" && ["npm", "mvn"].includes(command),
  });
  if (result.error) throw result.error;
  if (result.status !== 0) throw new Error(`${command} failed (${result.status}).`);
}
