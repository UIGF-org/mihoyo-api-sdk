// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalCommunityRecordsContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  StarRailChallengeApiGetSimulatedUniverseOptionalParams,
  StarRailChallengeApiGetApocalypticShadowOptionalParams,
  StarRailChallengeApiGetPureFictionOptionalParams,
  StarRailChallengeApiGetForgottenHallOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getSimulatedUniverseSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailChallengeApiGetSimulatedUniverseOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/hkrpg/api/rogue{?schedule_type,need_detail,need_all,server,role_id}",
    {
      schedule_type: options?.scheduleType,
      need_detail: options?.needDetail,
      need_all: options?.needAll,
      server: server,
      role_id: roleId,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getSimulatedUniverseDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getSimulatedUniverse(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailChallengeApiGetSimulatedUniverseOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getSimulatedUniverseSend(context, cookie, ds, server, roleId, options);
  return _getSimulatedUniverseDeserialize(result);
}

export function _getApocalypticShadowSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailChallengeApiGetApocalypticShadowOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/hkrpg/api/challenge_boss{?schedule_type,need_detail,need_all,server,role_id}",
    {
      schedule_type: options?.scheduleType,
      need_detail: options?.needDetail,
      need_all: options?.needAll,
      server: server,
      role_id: roleId,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getApocalypticShadowDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getApocalypticShadow(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailChallengeApiGetApocalypticShadowOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getApocalypticShadowSend(context, cookie, ds, server, roleId, options);
  return _getApocalypticShadowDeserialize(result);
}

export function _getPureFictionSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailChallengeApiGetPureFictionOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/hkrpg/api/challenge_story{?schedule_type,need_detail,need_all,server,role_id}",
    {
      schedule_type: options?.scheduleType,
      need_detail: options?.needDetail,
      need_all: options?.needAll,
      server: server,
      role_id: roleId,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getPureFictionDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getPureFiction(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailChallengeApiGetPureFictionOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getPureFictionSend(context, cookie, ds, server, roleId, options);
  return _getPureFictionDeserialize(result);
}

export function _getForgottenHallSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailChallengeApiGetForgottenHallOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/hkrpg/api/challenge{?schedule_type,need_detail,need_all,server,role_id}",
    {
      schedule_type: options?.scheduleType,
      need_detail: options?.needDetail,
      need_all: options?.needAll,
      server: server,
      role_id: roleId,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getForgottenHallDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getForgottenHall(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailChallengeApiGetForgottenHallOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getForgottenHallSend(context, cookie, ds, server, roleId, options);
  return _getForgottenHallDeserialize(result);
}
