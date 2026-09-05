// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameCNRecordsContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  StarRailApiGetChallengePeakOptionalParams,
  StarRailApiGetSimulatedUniverseOptionalParams,
  StarRailApiGetApocalypticShadowOptionalParams,
  StarRailApiGetPureFictionOptionalParams,
  StarRailApiGetForgottenHallOptionalParams,
  StarRailApiGetDailyNoteOptionalParams,
  StarRailApiGetIndexOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getChallengePeakSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailApiGetChallengePeakOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/hkrpg/api/challenge_peak{?schedule_type,need_detail,need_all,server,role_id}",
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

export async function _getChallengePeakDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getChallengePeak(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailApiGetChallengePeakOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getChallengePeakSend(context, cookie, ds, server, roleId, options);
  return _getChallengePeakDeserialize(result);
}

export function _getSimulatedUniverseSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailApiGetSimulatedUniverseOptionalParams = { requestOptions: {} },
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
  options: StarRailApiGetSimulatedUniverseOptionalParams = { requestOptions: {} },
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
  options: StarRailApiGetApocalypticShadowOptionalParams = { requestOptions: {} },
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
  options: StarRailApiGetApocalypticShadowOptionalParams = { requestOptions: {} },
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
  options: StarRailApiGetPureFictionOptionalParams = { requestOptions: {} },
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
  options: StarRailApiGetPureFictionOptionalParams = { requestOptions: {} },
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
  options: StarRailApiGetForgottenHallOptionalParams = { requestOptions: {} },
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
  options: StarRailApiGetForgottenHallOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getForgottenHallSend(context, cookie, ds, server, roleId, options);
  return _getForgottenHallDeserialize(result);
}

export function _getDailyNoteSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailApiGetDailyNoteOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/hkrpg/api/note{?server,role_id}",
    {
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

export async function _getDailyNoteDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getDailyNote(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailApiGetDailyNoteOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getDailyNoteSend(context, cookie, ds, server, roleId, options);
  return _getDailyNoteDeserialize(result);
}

export function _getIndexSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailApiGetIndexOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/hkrpg/api/index{?server,role_id}",
    {
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

export async function _getIndexDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getIndex(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: StarRailApiGetIndexOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getIndexSend(context, cookie, ds, server, roleId, options);
  return _getIndexDeserialize(result);
}
