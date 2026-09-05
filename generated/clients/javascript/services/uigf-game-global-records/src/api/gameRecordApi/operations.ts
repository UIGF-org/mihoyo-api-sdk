// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalRecordsContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  GameRecordApiGetStarRailChallengePeakOptionalParams,
  GameRecordApiGetStarRailDailyNoteOptionalParams,
  GameRecordApiGetStarRailIndexOptionalParams,
  GameRecordApiGetGenshinDailyNoteOptionalParams,
  GameRecordApiGetGenshinIndexOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getStarRailChallengePeakSend(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetStarRailChallengePeakOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record/app/hkrpg/api/challenge_peak{?schedule_type,need_detail,need_all,server,role_id}",
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
        ...(options?.ds !== undefined ? { ds: options?.ds } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getStarRailChallengePeakDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getStarRailChallengePeak(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetStarRailChallengePeakOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getStarRailChallengePeakSend(context, cookie, server, roleId, options);
  return _getStarRailChallengePeakDeserialize(result);
}

export function _getStarRailDailyNoteSend(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetStarRailDailyNoteOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record/app/hkrpg/api/note{?server,role_id}",
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
        ...(options?.ds !== undefined ? { ds: options?.ds } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getStarRailDailyNoteDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getStarRailDailyNote(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetStarRailDailyNoteOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getStarRailDailyNoteSend(context, cookie, server, roleId, options);
  return _getStarRailDailyNoteDeserialize(result);
}

export function _getStarRailIndexSend(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetStarRailIndexOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record/app/hkrpg/api/index{?server,role_id}",
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
        ...(options?.ds !== undefined ? { ds: options?.ds } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getStarRailIndexDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getStarRailIndex(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetStarRailIndexOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getStarRailIndexSend(context, cookie, server, roleId, options);
  return _getStarRailIndexDeserialize(result);
}

export function _getGenshinDailyNoteSend(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetGenshinDailyNoteOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record/app/genshin/api/dailyNote{?server,role_id}",
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
        ...(options?.ds !== undefined ? { ds: options?.ds } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getGenshinDailyNoteDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getGenshinDailyNote(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetGenshinDailyNoteOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getGenshinDailyNoteSend(context, cookie, server, roleId, options);
  return _getGenshinDailyNoteDeserialize(result);
}

export function _getGenshinIndexSend(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetGenshinIndexOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record/app/genshin/api/index{?avatar_list_type,server,role_id}",
    {
      avatar_list_type: options?.avatarListType,
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
        ...(options?.ds !== undefined ? { ds: options?.ds } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getGenshinIndexDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getGenshinIndex(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetGenshinIndexOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getGenshinIndexSend(context, cookie, server, roleId, options);
  return _getGenshinIndexDeserialize(result);
}
