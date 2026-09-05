// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameAccountContext as Client } from "../index.js";
import {
  ApiResponseTokenInfo,
  apiResponseTokenInfoDeserializer,
} from "../../models/uigf/models.js";
import { GameTokenRequest, gameTokenRequestSerializer } from "../../models/uigf/passport/models.js";
import { GameTokenApiExchangeGameTokenOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _exchangeGameTokenSend(
  context: Client,
  body: GameTokenRequest,
  options: GameTokenApiExchangeGameTokenOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/ma-cn-session/app/getTokenByGameToken")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: gameTokenRequestSerializer(body),
    });
}

export async function _exchangeGameTokenDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseTokenInfo> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseTokenInfoDeserializer(result.body);
}

/** Exchanges the official game-token QR-login result for a session token. */
export async function exchangeGameToken(
  context: Client,
  body: GameTokenRequest,
  options: GameTokenApiExchangeGameTokenOptionalParams = { requestOptions: {} },
): Promise<ApiResponseTokenInfo> {
  const result = await _exchangeGameTokenSend(context, body, options);
  return _exchangeGameTokenDeserialize(result);
}
