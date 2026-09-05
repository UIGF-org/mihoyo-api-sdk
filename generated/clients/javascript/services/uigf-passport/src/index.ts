// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { PassportClient } from "./passportClient.js";
export type {
  ApiResponseTokenInfo,
  ApiResponseJsonObject,
  JsonObject,
  ApiResponseQrLoginTicket,
  ApiResponseQrLoginStatus,
} from "./models/uigf/index.js";
export type {
  AuthTicketRequest,
  DeviceContext,
  TokenInfo,
  LoginCaptchaRequest,
  QrLoginCreateRequest,
  QrLoginTicket,
  QrLoginStatusRequest,
  QrLoginStatus,
  MobileCaptchaLoginRequest,
  GameTokenRequest,
} from "./models/uigf/passport/index.js";
export type { PassportClientOptionalParams } from "./api/index.js";
export type {
  AccountTokenApiGetLTokenBySTokenOptionalParams,
  AccountTokenApiGetCookieAccountInfoBySTokenOptionalParams,
} from "./api/accountTokenApi/index.js";
export type { AuthTicketApiCreateByGameBizOptionalParams } from "./api/authTicketApi/index.js";
export type { CaptchaApiCreateOptionalParams } from "./api/captchaApi/index.js";
export type {
  QrLoginApiLoginByMobileCaptchaOptionalParams,
  QrLoginApiGetStatusOptionalParams,
  QrLoginApiCreateOptionalParams,
} from "./api/qrLoginApi/index.js";
export type { SessionApiGetTokenByGameTokenOptionalParams } from "./api/sessionApi/index.js";
export type {
  AccountTokenApiOperations,
  AuthTicketApiOperations,
  CaptchaApiOperations,
  QrLoginApiOperations,
  SessionApiOperations,
} from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
