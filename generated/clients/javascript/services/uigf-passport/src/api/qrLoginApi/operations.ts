// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext as Client } from "../index.js";
import {
  ApiResponseTokenInfo,
  apiResponseTokenInfoDeserializer,
  ApiResponseQrLoginTicket,
  apiResponseQrLoginTicketDeserializer,
  ApiResponseQrLoginStatus,
  apiResponseQrLoginStatusDeserializer,
} from "../../models/uigf/models.js";
import {
  QrLoginCreateRequest,
  qrLoginCreateRequestSerializer,
  QrLoginStatusRequest,
  qrLoginStatusRequestSerializer,
  MobileCaptchaLoginRequest,
  mobileCaptchaLoginRequestSerializer,
} from "../../models/uigf/passport/models.js";
import {
  QrLoginApiLoginByMobileCaptchaOptionalParams,
  QrLoginApiGetStatusOptionalParams,
  QrLoginApiCreateOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _loginByMobileCaptchaSend(
  context: Client,
  body: MobileCaptchaLoginRequest,
  options: QrLoginApiLoginByMobileCaptchaOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/ma-cn-passport/app/loginByMobileCaptcha")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: mobileCaptchaLoginRequestSerializer(body),
    });
}

export async function _loginByMobileCaptchaDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseTokenInfo> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseTokenInfoDeserializer(result.body);
}

/** Logs in with a mobile-number captcha obtained through the official flow. */
export async function loginByMobileCaptcha(
  context: Client,
  body: MobileCaptchaLoginRequest,
  options: QrLoginApiLoginByMobileCaptchaOptionalParams = { requestOptions: {} },
): Promise<ApiResponseTokenInfo> {
  const result = await _loginByMobileCaptchaSend(context, body, options);
  return _loginByMobileCaptchaDeserialize(result);
}

export function _getStatusSend(
  context: Client,
  body: QrLoginStatusRequest,
  options: QrLoginApiGetStatusOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/ma-cn-passport/app/queryQRLoginStatus")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: qrLoginStatusRequestSerializer(body),
    });
}

export async function _getStatusDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseQrLoginStatus> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseQrLoginStatusDeserializer(result.body);
}

/** Queries an official QR login ticket. */
export async function getStatus(
  context: Client,
  body: QrLoginStatusRequest,
  options: QrLoginApiGetStatusOptionalParams = { requestOptions: {} },
): Promise<ApiResponseQrLoginStatus> {
  const result = await _getStatusSend(context, body, options);
  return _getStatusDeserialize(result);
}

export function _createSend(
  context: Client,
  body: QrLoginCreateRequest,
  options: QrLoginApiCreateOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/ma-cn-passport/app/createQRLogin")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: qrLoginCreateRequestSerializer(body),
    });
}

export async function _createDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseQrLoginTicket> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseQrLoginTicketDeserializer(result.body);
}

/** Creates an official QR login ticket. */
export async function create(
  context: Client,
  body: QrLoginCreateRequest,
  options: QrLoginApiCreateOptionalParams = { requestOptions: {} },
): Promise<ApiResponseQrLoginTicket> {
  const result = await _createSend(context, body, options);
  return _createDeserialize(result);
}
