# UIGF MiHoYo API SDK specification

This repository consolidates the HTTP contracts exercised by `mihoyo-api-collect`,
`SnapHutaoArchive`, `Starward`, and `TeyvatGuide` into a single TypeSpec service.
The root namespace is `UIGF`; its child namespaces are grouped by API product rather
than by the source application that happened to use an endpoint.

The project deliberately describes transport contracts only. Callers must obtain
credentials legitimately and provide the required `Cookie`, `DS`, device, app-version,
referer, and challenge headers for the selected endpoint. The SDK does not embed
dynamic-secret salts, account credentials, CAPTCHA bypasses, or payment credentials.

The Node.js runtime export `@uigf/mihoyo-api-sdk/ds` does implement the reusable DS
algorithm. It supports the V1 (`salt,t,r`) and V2 (`salt,t,r,b,q`) layouts, canonical
query ordering, deterministic test inputs, and caller-supplied salts. Use the exact
serialized HTTP body returned by `serializeDsJsonBody()` for both V2 signing and the
outgoing request body.

## Build

```powershell
npm install
npm run build
```

The current OpenAPI 3.0 documents are emitted to `generated/openapi/`. One document
is emitted per service host so generated clients never treat CN and global API hosts
as interchangeable alternatives. DS-decorated operations receive an `x-uigf-ds`
extension during the build, while `generated/ds/ds-manifest.json` exposes the same
data for a custom client emitter. The extension identifies the DS header, the V1/V2
generation, and—when V2 is needed—the exact-body and lexicographic-query rules.

## API domains

- `UIGF.Passport`: CN passport and account-token flows.
- `UIGF.Community`: MiYouShe forum, post, topic, and mission APIs.
- `UIGF.CheckIn`: daily game check-in APIs.
- `UIGF.Game`: game announcements, gacha history, game records, and cultivation.
- `UIGF.Launcher`: HoYoPlay metadata and Sophon download manifests.
- `UIGF.Utility`: device fingerprinting and livestream redemption-code refresh.
- `UIGF.Commerce`: shop catalogue and order-status contracts.

`data` is intentionally an extensible JSON object for endpoints whose payload shape is
product-version-dependent. Stable, commonly consumed payloads such as accounts, role
lists, gacha entries, announcements, and launcher metadata have dedicated models.

## License

MIT. See [LICENSE](LICENSE).
