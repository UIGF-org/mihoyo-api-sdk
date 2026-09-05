// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalCommunityRecordsContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  GenshinChallengeApiGetStygianOnslaughtOptionalParams,
  GenshinChallengeApiGetImaginariumTheaterOptionalParams,
  GenshinChallengeApiGetSpiralAbyssOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getStygianOnslaughtSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GenshinChallengeApiGetStygianOnslaughtOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/genshin/api/hard_challenge{?schedule_type,need_detail,need_all,server,role_id}",
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

export async function _getStygianOnslaughtDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getStygianOnslaught(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GenshinChallengeApiGetStygianOnslaughtOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getStygianOnslaughtSend(context, cookie, ds, server, roleId, options);
  return _getStygianOnslaughtDeserialize(result);
}

export function _getImaginariumTheaterSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GenshinChallengeApiGetImaginariumTheaterOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/genshin/api/role_combat{?schedule_type,need_detail,need_all,server,role_id}",
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

export async function _getImaginariumTheaterDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getImaginariumTheater(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GenshinChallengeApiGetImaginariumTheaterOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getImaginariumTheaterSend(context, cookie, ds, server, roleId, options);
  return _getImaginariumTheaterDeserialize(result);
}

export function _getSpiralAbyssSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GenshinChallengeApiGetSpiralAbyssOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/genshin/api/spiralAbyss{?schedule_type,need_detail,need_all,server,role_id}",
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

export async function _getSpiralAbyssDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getSpiralAbyss(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GenshinChallengeApiGetSpiralAbyssOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getSpiralAbyssSend(context, cookie, ds, server, roleId, options);
  return _getSpiralAbyssDeserialize(result);
}
