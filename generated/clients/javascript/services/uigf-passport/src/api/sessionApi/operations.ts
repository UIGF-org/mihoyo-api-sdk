// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext as Client } from "../index.js";
import {
  ApiResponseTokenInfo,
  apiResponseTokenInfoDeserializer,
} from "../../models/uigf/models.js";
import {
  GameTokenRequest,
  gameTokenRequestSerializer,
  TokenExchangeRequest,
  tokenExchangeRequestSerializer,
} from "../../models/uigf/passport/models.js";
import {
  SessionApiExchangeOptionalParams,
  SessionApiGetTokenByGameTokenOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _exchangeSend(
  context: Client,
  body: TokenExchangeRequest,
  options: SessionApiExchangeOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/ma-cn-session/app/exchange")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: tokenExchangeRequestSerializer(body),
    });
}

export async function _exchangeDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseTokenInfo> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseTokenInfoDeserializer(result.body);
}

/** Exchanges a source token for the requested destination token type. */
export async function exchange(
  context: Client,
  body: TokenExchangeRequest,
  options: SessionApiExchangeOptionalParams = { requestOptions: {} },
): Promise<ApiResponseTokenInfo> {
  const result = await _exchangeSend(context, body, options);
  return _exchangeDeserialize(result);
}

export function _getTokenByGameTokenSend(
  context: Client,
  body: GameTokenRequest,
  options: SessionApiGetTokenByGameTokenOptionalParams = { requestOptions: {} },
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

export async function _getTokenByGameTokenDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseTokenInfo> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseTokenInfoDeserializer(result.body);
}

/** Exchanges a game token for an SToken/session payload. */
export async function getTokenByGameToken(
  context: Client,
  body: GameTokenRequest,
  options: SessionApiGetTokenByGameTokenOptionalParams = { requestOptions: {} },
): Promise<ApiResponseTokenInfo> {
  const result = await _getTokenByGameTokenSend(context, body, options);
  return _getTokenByGameTokenDeserialize(result);
}
