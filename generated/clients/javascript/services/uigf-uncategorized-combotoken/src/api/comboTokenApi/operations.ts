// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedComboTokenContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import {
  ComboTokenRequest,
  comboTokenRequestSerializer,
} from "../../models/uigf/uncategorized/models.js";
import { ComboTokenApiExchangeOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _exchangeSend(
  context: Client,
  body: ComboTokenRequest,
  options: ComboTokenApiExchangeOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/upload/outer/GetStByComboToken")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: comboTokenRequestSerializer(body),
    });
}

export async function _exchangeDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function exchange(
  context: Client,
  body: ComboTokenRequest,
  options: ComboTokenApiExchangeOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _exchangeSend(context, body, options);
  return _exchangeDeserialize(result);
}
