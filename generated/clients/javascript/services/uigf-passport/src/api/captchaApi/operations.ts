// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import {
  LoginCaptchaRequest,
  loginCaptchaRequestSerializer,
} from "../../models/uigf/passport/models.js";
import { CaptchaApiCreateOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _createSend(
  context: Client,
  body: LoginCaptchaRequest,
  options: CaptchaApiCreateOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/ma-cn-verifier/verifier/createLoginCaptcha")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: loginCaptchaRequestSerializer(body),
    });
}

export async function _createDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

/** Starts the vendor login-captcha challenge. Solve it through the official flow. */
export async function create(
  context: Client,
  body: LoginCaptchaRequest,
  options: CaptchaApiCreateOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _createSend(context, body, options);
  return _createDeserialize(result);
}
