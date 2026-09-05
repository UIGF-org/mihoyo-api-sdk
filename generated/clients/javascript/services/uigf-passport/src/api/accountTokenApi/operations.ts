// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext as Client } from "../index.js";
import {
  ApiResponseTokenInfo,
  apiResponseTokenInfoDeserializer,
} from "../../models/uigf/models.js";
import {
  AccountTokenApiGetLTokenBySTokenOptionalParams,
  AccountTokenApiGetCookieAccountInfoBySTokenOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getLTokenBySTokenSend(
  context: Client,
  cookie: string,
  options: AccountTokenApiGetLTokenBySTokenOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/auth/api/getLTokenBySToken")
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getLTokenBySTokenDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseTokenInfo> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseTokenInfoDeserializer(result.body);
}

/** Exchanges an SToken cookie for an LToken payload. */
export async function getLTokenBySToken(
  context: Client,
  cookie: string,
  options: AccountTokenApiGetLTokenBySTokenOptionalParams = { requestOptions: {} },
): Promise<ApiResponseTokenInfo> {
  const result = await _getLTokenBySTokenSend(context, cookie, options);
  return _getLTokenBySTokenDeserialize(result);
}

export function _getCookieAccountInfoBySTokenSend(
  context: Client,
  cookie: string,
  options: AccountTokenApiGetCookieAccountInfoBySTokenOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/account/auth/api/getCookieAccountInfoBySToken")
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getCookieAccountInfoBySTokenDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseTokenInfo> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseTokenInfoDeserializer(result.body);
}

/** Returns account information for an authenticated SToken cookie. */
export async function getCookieAccountInfoBySToken(
  context: Client,
  cookie: string,
  options: AccountTokenApiGetCookieAccountInfoBySTokenOptionalParams = { requestOptions: {} },
): Promise<ApiResponseTokenInfo> {
  const result = await _getCookieAccountInfoBySTokenSend(context, cookie, options);
  return _getCookieAccountInfoBySTokenDeserialize(result);
}
