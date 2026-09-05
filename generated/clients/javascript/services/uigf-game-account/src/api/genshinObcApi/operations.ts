// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameAccountContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  GenshinObcApiGetHomePositionsOptionalParams,
  GenshinObcApiGetGachaPoolOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getHomePositionsSend(
  context: Client,
  appSn: string,
  options: GenshinObcApiGetHomePositionsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/common/blackboard/ys_obc/v1/home/position{?app_sn}",
    {
      app_sn: appSn,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getHomePositionsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getHomePositions(
  context: Client,
  appSn: string,
  options: GenshinObcApiGetHomePositionsOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getHomePositionsSend(context, appSn, options);
  return _getHomePositionsDeserialize(result);
}

export function _getGachaPoolSend(
  context: Client,
  appSn: string,
  options: GenshinObcApiGetGachaPoolOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/common/blackboard/ys_obc/v1/gacha_pool{?app_sn}",
    {
      app_sn: appSn,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getGachaPoolDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getGachaPool(
  context: Client,
  appSn: string,
  options: GenshinObcApiGetGachaPoolOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getGachaPoolSend(context, appSn, options);
  return _getGachaPoolDeserialize(result);
}
