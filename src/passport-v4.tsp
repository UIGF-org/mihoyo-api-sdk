import "@typespec/http";

using TypeSpec.Http;

/** The V4 LToken verifier for a legitimately obtained LToken cookie. */
@service(#{ title: "UIGF MiHoYo Passport V4 API" })
@server("https://passport-api-v4.mihoyo.com", "CN Passport V4 API")
namespace UIGF.PassportV4;

@route("/account/ma-cn-session/web")
interface SessionApi {
  @post
  @route("/verifyLtoken")
  verifyLToken(
    @header("Cookie") cookie: string,
    @body body: UIGF.JsonObject,
  ): UIGF.ApiResponse<UIGF.Passport.TokenInfo>;
}
