// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameAccountContext as Client } from "../index.js";
import { CalculateRequest, calculateRequestSerializer } from "../../models/uigf/game/models.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import {
  CultivationApiSyncAvatarListOptionalParams,
  CultivationApiListWeaponsOptionalParams,
  CultivationApiListAvatarsOptionalParams,
  CultivationApiBatchComputeOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _syncAvatarListSend(
  context: Client,
  cookie: string,
  ds: string,
  body: CalculateRequest,
  options: CultivationApiSyncAvatarListOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/event/e20200928calculate/v1/sync/avatar/list")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: calculateRequestSerializer(body),
    });
}

export async function _syncAvatarListDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function syncAvatarList(
  context: Client,
  cookie: string,
  ds: string,
  body: CalculateRequest,
  options: CultivationApiSyncAvatarListOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _syncAvatarListSend(context, cookie, ds, body, options);
  return _syncAvatarListDeserialize(result);
}

export function _listWeaponsSend(
  context: Client,
  cookie: string,
  ds: string,
  body: CalculateRequest,
  options: CultivationApiListWeaponsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/event/e20200928calculate/v1/weapon/list")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: calculateRequestSerializer(body),
    });
}

export async function _listWeaponsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function listWeapons(
  context: Client,
  cookie: string,
  ds: string,
  body: CalculateRequest,
  options: CultivationApiListWeaponsOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _listWeaponsSend(context, cookie, ds, body, options);
  return _listWeaponsDeserialize(result);
}

export function _listAvatarsSend(
  context: Client,
  cookie: string,
  ds: string,
  body: CalculateRequest,
  options: CultivationApiListAvatarsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/event/e20200928calculate/v1/avatar/list")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: calculateRequestSerializer(body),
    });
}

export async function _listAvatarsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function listAvatars(
  context: Client,
  cookie: string,
  ds: string,
  body: CalculateRequest,
  options: CultivationApiListAvatarsOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _listAvatarsSend(context, cookie, ds, body, options);
  return _listAvatarsDeserialize(result);
}

export function _batchComputeSend(
  context: Client,
  cookie: string,
  ds: string,
  body: CalculateRequest,
  options: CultivationApiBatchComputeOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/event/e20200928calculate/v3/batch_compute")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: calculateRequestSerializer(body),
    });
}

export async function _batchComputeDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

/** Calculates material consumption for a batch of characters and weapons. */
export async function batchCompute(
  context: Client,
  cookie: string,
  ds: string,
  body: CalculateRequest,
  options: CultivationApiBatchComputeOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _batchComputeSend(context, cookie, ds, body, options);
  return _batchComputeDeserialize(result);
}
