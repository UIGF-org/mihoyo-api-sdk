# Source coverage

This specification is an integration of observed request contracts, not a copy of
any reference project's implementation. The source projects were inspected only
for API paths, HTTP methods, query/body fields, and stable response shapes.

| Source | Extracted surface | TypeSpec location |
| --- | --- | --- |
| `mihoyo-api-collect/hoyolab` and `other` | passport, QR login, MiYouShe, authentication requirements, device fingerprint, livestream, shop/order | `src/passport*.tsp`, `src/community.tsp`, `src/utility.tsp`, `src/commerce.tsp` |
| `TeyvatGuide/src/request` | forum/post/feed/topic, Luna check-in, CN Genshin records, gacha, announcements, OBC, cultivation, HoYoPlay | `src/community.tsp`, `src/luna.tsp`, `src/game-*.tsp`, `src/launcher.tsp` |
| `SnapHutaoArchive/.../Web/Hoyolab` | shared account, game-record, calculator, gacha, announcement, and signing header semantics | `src/common.tsp`, `src/game*.tsp`, `src/passport*.tsp` |
| `Starward/src/Starward.Core` | CN/global Genshin, Star Rail, ZZZ, and HI3 record paths; ledgers; HoYoPlay/Sophon metadata | `src/game-global.tsp`, `src/game-records-cn.tsp`, `src/launcher.tsp` |

The following intentionally remain outside the SDK:

- dynamic-secret salts and vendor/private signing keys;
- saved cookies, account tokens, device fingerprints, CAPTCHA solutions, and payment data;
- implementation that fabricates client telemetry or bypasses official authentication,
  CAPTCHA, purchase, or rate-limit controls.

Generated clients should accept these values from a legitimate caller and expose the
headers documented by each operation.

The `runtime/ds.ts` Node.js module implements only the documented, reusable V1/V2
DS payload construction and MD5 digest process. Its salt is a required call-time
parameter; it does not contain a salt registry or credential-retrieval workflow.

`@UIGF.Security.requiresDs("v1" | "v2")` is a custom TypeSpec decorator. The
local `@uigf/typespec-ds` emitter resolves it to DS operation metadata, and the
OpenAPI post-processor turns that metadata into `x-uigf-ds`. This keeps signing
selection attached to the TypeSpec operation instead of relying on a hand-maintained
SDK-side endpoint list.
