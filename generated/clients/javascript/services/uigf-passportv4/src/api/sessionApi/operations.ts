// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportV4Context as Client } from "../index.js";
import {
  JsonObject,
  jsonObjectSerializer,
  ApiResponseTokenInfo,
  apiResponseTokenInfoDeserializer,
} from "../../models/uigf/models.js";
import { SessionApiVerifyLTokenOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _verifyLTokenSend(
  context: Client,
  cookie: string,
  body: JsonObject,
  options: SessionApiVerifyLTokenOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/ma-cn-session/web/verifyLtoken")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
      body: jsonObjectSerializer(body),
    });
}

export async function _verifyLTokenDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseTokenInfo> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseTokenInfoDeserializer(result.body);
}

export async function verifyLToken(
  context: Client,
  cookie: string,
  body: JsonObject,
  options: SessionApiVerifyLTokenOptionalParams = { requestOptions: {} },
): Promise<ApiResponseTokenInfo> {
  const result = await _verifyLTokenSend(context, cookie, body, options);
  return _verifyLTokenDeserialize(result);
}
