# UIGF MiHoYo API SDK

面向米哈游、米游社、HoYoLAB 与 HoYoverse 服务的统一社区 SDK 定义。

本项目以 TypeSpec 描述 API，使用微软官方 emitter 生成 C#、Java、Python 和 JavaScript/TypeScript 客户端，并提供 OpenAPI 文档和 DS 签名辅助能力。

## 使用

```powershell
npm ci
npm run build
npm run build:clients
```

生成前安装 Node.js 22+、.NET SDK 8+、JDK 17+、Maven，以及带 pip 的 Python 3.10+。Java 工具需在 `PATH` 中，也可设置 `JAVA_HOME`、`MAVEN_HOME`。首次安装 Python emitter 时会自动准备其生成环境。

`npm run build` 生成 OpenAPI、DS 辅助代码和四种语言的客户端源码；`npm run build:clients` 安装 JS 构建依赖，并构建 NuGet、JAR、wheel、npm 包。OpenAPI 位于 `generated/openapi/`。

| 语言 | 官方 emitter（已锁定版本） | 生成目录 | 构建产物 |
| --- | --- | --- | --- |
| C# | `@typespec/http-client-csharp` | `generated/clients/csharp/` | `src/bin/Release/UIGF.Mihoyo.0.1.0.nupkg` |
| Java | `@typespec/http-client-java` | `generated/clients/java/` | `target/uigf-checkin-1.0.0-beta.1.jar` |
| Python | `@typespec/http-client-python` | `generated/clients/python/` | `dist/uigf_mihoyo-0.1.0-py3-none-any.whl` |
| JS / TS | `@azure-tools/typespec-ts` | `generated/clients/javascript/` | `uigf-mihoyo-client-0.1.0.tgz`，含 ESM 和 `.d.ts` |

Java 的 artifactId/version 来自官方 emitter 的默认 POM；该 JAR 包含全部服务。C# 包以 .NET 8 为目标，因为当前预览 emitter 的配置类型依赖 .NET 8 的 `ExperimentalAttribute`。

仅生成某种语言：

```powershell
npm run generate:csharp
npm run generate:java
npm run generate:python
npm run generate:js
node tools/build-clients.mjs javascript
```

仅需要原有 OpenAPI 和 DS 功能时运行 `npm run build:spec`、`npm run build:runtime`，无需 Java 或 .NET 环境。

## 客户端使用

JS 和 TS 使用同一个包，按服务导出命名空间：

```typescript
import { GameCNRecords, CommerceCN } from "@uigf/mihoyo-client";

const records = new GameCNRecords.GameCNRecordsClient();
const result = await records.starRailApi.getSimulatedUniverse(
  cookie, ds, "prod_gf_cn", roleId,
  { needDetail: false },
);

const commerce = new CommerceCN.CommerceCNClient("https://hk4e-sdk.mihoyo.com");
```

JS/TS 中，`JsonObject` 等开放模型的动态字段放在 `additionalProperties` 中；序列化时会展开回原始 JSON 对象。

Python 提供同步和异步客户端，例如 `from uigf.game.cn.records import CnGameRecordsClient`；异步版本位于对应包的 `aio`。海外服务的 Python 命名空间使用 `overseas`，避免 `global` 关键字。

C# 可使用 `UIGF.Game.CN.Records.CnGameRecordsClient`，Java 可使用 `uigf.game.cn.records.CnGameRecordsClientBuilder`。各 SDK 的 `services.json` 列出覆盖的 24 个服务。

需要 DS 的接口接收调用者传入的 `ds` 和 `cookie`。现有 `runtime/ds.ts` 提供签名辅助函数；生成的客户端不会自动生成 DS。DS v2 必须与最终请求体字节和查询参数一致。

## 生成与验证

入口为 `client.tsp`，共享 `main.tsp` 的 HTTP 定义，并用官方客户端装饰器解决跨服务重名。修改 API 时编辑 `src/*.tsp`，重新生成即可。`tools/client-packaging/` 只维护包元数据和构建配置，HTTP 方法、模型、序列化器均由官方 emitter 生成。

JS/TS 使用 [微软 TypeSpec Azure 的 TypeScript emitter](https://github.com/Azure/typespec-azure/tree/main/packages/typespec-ts)。测试发现 `@typespec/http-client-js@0.16.1` 存在查询参数名称及 `false`/`0` 丢失问题，因此选用微软的另一官方 emitter。TypeScript 逐服务生成，再汇总为一个 npm 包，避免其多服务上下文类型冲突。其他语言使用 [TypeSpec 官方客户端 emitters](https://typespec.io/docs/emitters/clients/introduction/)。

生成成功后才替换对应语言目录；旧输出保留在被 Git 忽略的 `tsp-output/clients-*/previous-*` 中，可按需清理。修改生成目录内的文件会在下次生成时被替换。

```powershell
npm run check
npm test
npm run build:clients
npm run test:clients
```

客户端测试使用模拟 HTTP transport，检查全部服务和方法的 JS 导出、服务地址、Cookie/DS、查询参数名称、`false`/`0`、JSON 请求体、错误响应；不访问真实账号或业务接口。

安装生成的 Python wheel 后，可运行 `python tools/python-clients.test.py` 验证清单中全部同步客户端及异步模块的导入。异步网络调用需安装 `uigf-mihoyo[aio]` 的附加依赖。

## HAR 对比

先生成当前 OpenAPI，再传入新的 HAR 文件：

```powershell
npm run build:spec
npm run compare:har -- "C:\path\to\capture.har"
```

该工具仅保留方法、域名、路径、参数名、请求体顶层字段名和状态码；不会输出 Cookie、鉴权头、查询值或请求体值。报告会标记已覆盖、可配置宿主覆盖、宿主不一致和未收录的 API。需要机器可读结果时追加 `--json`；指定其他 OpenAPI 目录时使用 `--openapi <directory>`。

## 说明

这是非官方社区项目。接口、返回内容和可用性可能随服务端调整而变化。

请使用自己合法取得的账号与授权信息，并遵守相关服务条款。本项目不包含账号、Cookie、私钥或其他敏感凭据。

## 许可证

[MIT](LICENSE)
