// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext as Client } from "../index.js";
import {
  ApiResponseTokenInfo,
  apiResponseTokenInfoDeserializer,
} from "../../models/uigf/models.js";
import {
  AuthTicketRequest,
  authTicketRequestSerializer,
} from "../../models/uigf/passport/models.js";
import { AuthTicketApiCreateByGameBizOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _createByGameBizSend(
  context: Client,
  body: AuthTicketRequest,
  options: AuthTicketApiCreateByGameBizOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/ma-cn-verifier/app/createAuthTicketByGameBiz")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: authTicketRequestSerializer(body),
    });
}

export async function _createByGameBizDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseTokenInfo> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseTokenInfoDeserializer(result.body);
}

/** Creates an action ticket for a game-biz authentication flow. */
export async function createByGameBiz(
  context: Client,
  body: AuthTicketRequest,
  options: AuthTicketApiCreateByGameBizOptionalParams = { requestOptions: {} },
): Promise<ApiResponseTokenInfo> {
  const result = await _createByGameBizSend(context, body, options);
  return _createByGameBizDeserialize(result);
}
