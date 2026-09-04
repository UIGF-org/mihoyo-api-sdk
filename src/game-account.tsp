import "@typespec/http";
import "@uigf/typespec-ds";

using TypeSpec.Http;

/** CN game-account binding, Gacha auth-key, OBC, and cultivation calculator APIs. */
@service(#{ title: "UIGF MiHoYo Game Account API" })
@server("https://api-takumi.mihoyo.com", "CN Takumi API")
namespace UIGF.Game.Account;

@route("/account/ma-cn-session/app")
interface GameTokenApi {
  /** Exchanges the official game-token QR-login result for a session token. */
  @post
  @route("/getTokenByGameToken")
  exchangeGameToken(
    @body body: UIGF.Passport.GameTokenRequest,
  ): UIGF.ApiResponse<UIGF.Passport.TokenInfo>;
}

@route("/auth/api")
@UIGF.Security.requiresDs("v2")
interface ActionTicketApi {
  @get
  @route("/getActionTicketBySToken")
  getBySToken(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    ...UIGF.Game.ActionTicketQuery,
  ): UIGF.ApiResponse<UIGF.JsonObject>;
}

@route("/binding/api")
interface BindingApi {
  /** Generates an authenticated gacha authkey for a selected game role. */
  @post
  @route("/genAuthKey")
  @UIGF.Security.requiresDs("v1")
  generateAuthKey(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @body body: UIGF.Game.AuthKeyRequest,
  ): UIGF.ApiResponse<UIGF.JsonObject>;

  /** Lists game roles that are bound to the authenticated community account. */
  @get
  @route("/getUserGameRolesByCookie")
  getRoles(
    @header("Cookie") cookie: string,
    @header("DS") ds?: string,
    @query game_biz?: string,
  ): UIGF.ApiResponse<UIGF.GameRoleList>;
}

@route("/common/blackboard/ys_obc/v1")
interface GenshinObcApi {
  @get
  @route("/gacha_pool")
  getGachaPool(
    @query app_sn: string = "ys_obc",
  ): UIGF.ApiResponse<UIGF.JsonObject>;

  @get
  @route("/home/position")
  getHomePositions(
    @query app_sn: string = "ys_obc",
  ): UIGF.ApiResponse<UIGF.JsonObject>;
}

@route("/event/e20200928calculate")
@UIGF.Security.requiresDs("v2")
interface CultivationApi {
  /** Calculates material consumption for a batch of characters and weapons. */
  @post
  @route("/v3/batch_compute")
  batchCompute(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @body body: UIGF.Game.CalculateRequest,
  ): UIGF.ApiResponse<UIGF.JsonObject>;

  @post
  @route("/v1/avatar/list")
  listAvatars(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @body body: UIGF.Game.CalculateRequest,
  ): UIGF.ApiResponse<UIGF.JsonObject>;

  @post
  @route("/v1/weapon/list")
  listWeapons(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @body body: UIGF.Game.CalculateRequest,
  ): UIGF.ApiResponse<UIGF.JsonObject>;

  @post
  @route("/v1/sync/avatar/list")
  syncAvatarList(
    @header("Cookie") cookie: string,
    @header("DS") ds: string,
    @body body: UIGF.Game.CalculateRequest,
  ): UIGF.ApiResponse<UIGF.JsonObject>;
}
