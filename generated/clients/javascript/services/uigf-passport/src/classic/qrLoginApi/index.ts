// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext } from "../../api/passportContext.js";
import {
  loginByAuthTicket,
  loginByMobileCaptcha,
  getStatus,
  create,
} from "../../api/qrLoginApi/operations.js";
import {
  QrLoginApiLoginByAuthTicketOptionalParams,
  QrLoginApiLoginByMobileCaptchaOptionalParams,
  QrLoginApiGetStatusOptionalParams,
  QrLoginApiCreateOptionalParams,
} from "../../api/qrLoginApi/options.js";
import {
  ApiResponseTokenInfo,
  ApiResponseQrLoginTicket,
  ApiResponseQrLoginStatus,
} from "../../models/uigf/models.js";
import {
  QrLoginCreateRequest,
  QrLoginStatusRequest,
  MobileCaptchaLoginRequest,
  AuthTicketLoginRequest,
} from "../../models/uigf/passport/models.js";

/** Interface representing a QrLoginApi operations. */
export interface QrLoginApiOperations {
  /** Exchanges an official auth ticket for the associated login-session payload. */
  loginByAuthTicket: (
    body: AuthTicketLoginRequest,
    options?: QrLoginApiLoginByAuthTicketOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
  /** Logs in with a mobile-number captcha obtained through the official flow. */
  loginByMobileCaptcha: (
    body: MobileCaptchaLoginRequest,
    options?: QrLoginApiLoginByMobileCaptchaOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
  /** Queries an official QR login ticket. */
  getStatus: (
    body: QrLoginStatusRequest,
    options?: QrLoginApiGetStatusOptionalParams,
  ) => Promise<ApiResponseQrLoginStatus>;
  /** Creates an official QR login ticket. */
  create: (
    body: QrLoginCreateRequest,
    options?: QrLoginApiCreateOptionalParams,
  ) => Promise<ApiResponseQrLoginTicket>;
}

function _getQrLoginApi(context: PassportContext) {
  return {
    loginByAuthTicket: (
      body: AuthTicketLoginRequest,
      options?: QrLoginApiLoginByAuthTicketOptionalParams,
    ) => loginByAuthTicket(context, body, options),
    loginByMobileCaptcha: (
      body: MobileCaptchaLoginRequest,
      options?: QrLoginApiLoginByMobileCaptchaOptionalParams,
    ) => loginByMobileCaptcha(context, body, options),
    getStatus: (body: QrLoginStatusRequest, options?: QrLoginApiGetStatusOptionalParams) =>
      getStatus(context, body, options),
    create: (body: QrLoginCreateRequest, options?: QrLoginApiCreateOptionalParams) =>
      create(context, body, options),
  };
}

export function _getQrLoginApiOperations(context: PassportContext): QrLoginApiOperations {
  return {
    ..._getQrLoginApi(context),
  };
}
