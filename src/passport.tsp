import "@typespec/http";

using TypeSpec.Http;

/** Passport, login-ticket, QR login, and account-token APIs for CN services. */
@service(#{ title: "UIGF MiHoYo Passport API" })
@server("https://passport-api.mihoyo.com", "CN Passport API")
namespace UIGF.Passport;

model DeviceContext extends Record<unknown> {
  device: string;
  device_fp?: string;
  device_name?: string;
  device_model?: string;
  device_id?: string;
  app_id?: string;
}

model QrLoginCreateRequest extends DeviceContext {
  app_id: string;
}

model QrLoginStatusRequest extends DeviceContext {
  ticket: string;
  app_id: string;
}

model MobileCaptchaLoginRequest extends DeviceContext {
  mobile: string;
  mobile_captcha: string;
  action_ticket?: string;
  game_biz?: string;
}

model LoginCaptchaRequest extends DeviceContext {
  action_type: string;
  game_biz?: string;
}

model AuthTicketRequest extends DeviceContext {
  game_biz: string;
}

model GameTokenRequest {
  account_id: int64;
  game_token: string;
}

model AuthTicketLoginRequest {
  ticket: string;
}

model TokenExchangeRequest {
  dst_token_type: string;
  mid: string;
  src_token: string;
}

model STokenTokenRequest {
  account_id?: int64;

  @header("Cookie")
  cookie: string;
}

model TokenInfo extends Record<unknown> {
  account_id?: int64;
  uid?: string;
  token?: string;
  game_token?: string;
  stoken?: string;
  ltoken?: string;
  cookie_token?: string;
  mid?: string;
}

model QrLoginTicket extends Record<unknown> {
  ticket: string;
  url?: string;
  expires_in?: int32;
}

model QrLoginStatus extends Record<unknown> {
  stat?: string;
  status?: string;
  payload?: JsonObject;
}

@route("/account/ma-cn-verifier/app/createAuthTicketByGameBiz")
interface AuthTicketApi {
  /** Creates an action ticket for a game-biz authentication flow. */
  @post
  createByGameBiz(@body body: AuthTicketRequest): ApiResponse<TokenInfo>;
}

@route("/account/ma-cn-verifier/verifier/createLoginCaptcha")
interface CaptchaApi {
  /** Starts the vendor login-captcha challenge. Solve it through the official flow. */
  @post
  create(@body body: LoginCaptchaRequest): ApiResponse<JsonObject>;
}

@route("/account/ma-cn-passport/app")
interface QrLoginApi {
  /** Creates an official QR login ticket. */
  @post
  @route("/createQRLogin")
  create(@body body: QrLoginCreateRequest): ApiResponse<QrLoginTicket>;

  /** Queries an official QR login ticket. */
  @post
  @route("/queryQRLoginStatus")
  getStatus(@body body: QrLoginStatusRequest): ApiResponse<QrLoginStatus>;

  /** Logs in with a mobile-number captcha obtained through the official flow. */
  @post
  @route("/loginByMobileCaptcha")
  loginByMobileCaptcha(
    @body body: MobileCaptchaLoginRequest,
  ): ApiResponse<TokenInfo>;

  /** Exchanges an official auth ticket for the associated login-session payload. */
  @post
  @route("/loginByAuthTicket")
  loginByAuthTicket(@body body: AuthTicketLoginRequest): ApiResponse<TokenInfo>;
}

@route("/account/ma-cn-session/app")
interface SessionApi {
  /** Exchanges a game token for an SToken/session payload. */
  @post
  @route("/getTokenByGameToken")
  getTokenByGameToken(@body body: GameTokenRequest): ApiResponse<TokenInfo>;

  /** Exchanges a source token for the requested destination token type. */
  @post
  @route("/exchange")
  exchange(@body body: TokenExchangeRequest): ApiResponse<TokenInfo>;
}

@route("/account/auth/api")
interface AccountTokenApi {
  /** Returns account information for an authenticated SToken cookie. */
  @get
  @route("/getCookieAccountInfoBySToken")
  getCookieAccountInfoBySToken(
    @header("Cookie") cookie: string,
  ): ApiResponse<TokenInfo>;

  /** Exchanges an SToken cookie for an LToken payload. */
  @get
  @route("/getLTokenBySToken")
  getLTokenBySToken(@header("Cookie") cookie: string): ApiResponse<TokenInfo>;
}
