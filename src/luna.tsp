import "@typespec/http";

using TypeSpec.Http;

/** Daily game check-in endpoints. The selected game is carried in `x-rpc-signgame`. */
@service(#{ title: "UIGF MiHoYo Luna Check-In API" })
@server("https://api-takumi.mihoyo.com", "MiHoYo Event API")
namespace UIGF.CheckIn;

@route("/event/luna")
interface CheckInApi {
  @get
  @route("/{game}/home")
  getHome(
    @path game: string,
    @header("Cookie") cookie: string,
    @header("x-rpc-signgame") signGame?: string,
    @query lang: string = "zh-cn",
    @query act_id: string,
  ): UIGF.ApiResponse<UIGF.JsonObject>;

  @get
  @route("/{game}/info")
  getInfo(
    @path game: string,
    @header("Cookie") cookie: string,
    @header("x-rpc-signgame") signGame?: string,
    @query lang: string = "zh-cn",
    @query act_id: string,
  ): UIGF.ApiResponse<UIGF.JsonObject>;

  @post
  @route("/{game}/sign")
  sign(
    @path game: string,
    @header("Cookie") cookie: string,
    @header("x-rpc-signgame") signGame?: string,
    @body body: UIGF.Community.LunaCheckInRequest,
  ): UIGF.ApiResponse<UIGF.JsonObject>;

  @get
  @route("/{game}/resign_info")
  getResignInfo(
    @path game: string,
    @header("Cookie") cookie: string,
    @header("x-rpc-signgame") signGame?: string,
    @query lang: string = "zh-cn",
    @query act_id: string,
  ): UIGF.ApiResponse<UIGF.JsonObject>;

  @post
  @route("/{game}/resign")
  resign(
    @path game: string,
    @header("Cookie") cookie: string,
    @header("x-rpc-signgame") signGame?: string,
    @body body: UIGF.Community.LunaCheckInRequest,
  ): UIGF.ApiResponse<UIGF.JsonObject>;
}
