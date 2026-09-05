// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinLoginContext as Client } from "../index.js";
import { PandaQrRequest, pandaQrRequestSerializer } from "../../models/uigf/game/models.js";
import {
  ApiResponsePandaQrResponse,
  apiResponsePandaQrResponseDeserializer,
} from "../../models/uigf/models.js";
import { PandaQrApiGetStatusOptionalParams, PandaQrApiCreateOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getStatusSend(
  context: Client,
  body: PandaQrRequest,
  options: PandaQrApiGetStatusOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/hk4e_cn/combo/panda/qrcode/query")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: pandaQrRequestSerializer(body),
    });
}

export async function _getStatusDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePandaQrResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePandaQrResponseDeserializer(result.body);
}

/** The upstream endpoint is deprecated; use only where officially supported. */
export async function getStatus(
  context: Client,
  body: PandaQrRequest,
  options: PandaQrApiGetStatusOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePandaQrResponse> {
  const result = await _getStatusSend(context, body, options);
  return _getStatusDeserialize(result);
}

export function _createSend(
  context: Client,
  body: PandaQrRequest,
  options: PandaQrApiCreateOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/hk4e_cn/combo/panda/qrcode/fetch")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: pandaQrRequestSerializer(body),
    });
}

export async function _createDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePandaQrResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePandaQrResponseDeserializer(result.body);
}

/** The upstream endpoint is deprecated; use only where officially supported. */
export async function create(
  context: Client,
  body: PandaQrRequest,
  options: PandaQrApiCreateOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePandaQrResponse> {
  const result = await _createSend(context, body, options);
  return _createDeserialize(result);
}
