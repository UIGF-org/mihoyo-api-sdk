// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinRecordContext as Client } from "../index.js";
import {
  CharacterListRequest,
  characterListRequestSerializer,
  CharacterDetailRequest,
  characterDetailRequestSerializer,
} from "../../models/uigf/game/models.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
  ApiResponseCharacterList,
  apiResponseCharacterListDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  GameRecordApiGetCharacterTpsOptionalParams,
  GameRecordApiGetActivityCalendarOptionalParams,
  GameRecordApiGetStygianPopularityOptionalParams,
  GameRecordApiGetStygianOnslaughtOptionalParams,
  GameRecordApiGetCharacterMasterOptionalParams,
  GameRecordApiGetImaginariumTheaterOptionalParams,
  GameRecordApiGetSpiralAbyssOptionalParams,
  GameRecordApiGetDailyNoteOptionalParams,
  GameRecordApiGetCharacterDetailsOptionalParams,
  GameRecordApiListCharactersOptionalParams,
  GameRecordApiGetIndexOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getCharacterTpsSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetCharacterTpsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/genshin/api/tps{?server,role_id}",
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

export async function _getCharacterTpsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getCharacterTps(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetCharacterTpsOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getCharacterTpsSend(context, cookie, ds, server, roleId, options);
  return _getCharacterTpsDeserialize(result);
}

export function _getActivityCalendarSend(
  context: Client,
  cookie: string,
  ds: string,
  body: CharacterListRequest,
  options: GameRecordApiGetActivityCalendarOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/game_record/app/genshin/api/act_calendar")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        ...(options?.challenge !== undefined ? { "x-rpc-challenge": options?.challenge } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: characterListRequestSerializer(body),
    });
}

export async function _getActivityCalendarDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getActivityCalendar(
  context: Client,
  cookie: string,
  ds: string,
  body: CharacterListRequest,
  options: GameRecordApiGetActivityCalendarOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getActivityCalendarSend(context, cookie, ds, body, options);
  return _getActivityCalendarDeserialize(result);
}

export function _getStygianPopularitySend(
  context: Client,
  server: string,
  roleId: number,
  options: GameRecordApiGetStygianPopularityOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/genshin/api/hard_challenge/popularity{?server,role_id}",
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
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getStygianPopularityDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getStygianPopularity(
  context: Client,
  server: string,
  roleId: number,
  options: GameRecordApiGetStygianPopularityOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getStygianPopularitySend(context, server, roleId, options);
  return _getStygianPopularityDeserialize(result);
}

export function _getStygianOnslaughtSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetStygianOnslaughtOptionalParams = { requestOptions: {} },
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
  options: GameRecordApiGetStygianOnslaughtOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getStygianOnslaughtSend(context, cookie, ds, server, roleId, options);
  return _getStygianOnslaughtDeserialize(result);
}

export function _getCharacterMasterSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetCharacterMasterOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/genshin/api/char_master{?server,role_id}",
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

export async function _getCharacterMasterDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getCharacterMaster(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetCharacterMasterOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getCharacterMasterSend(context, cookie, ds, server, roleId, options);
  return _getCharacterMasterDeserialize(result);
}

export function _getImaginariumTheaterSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetImaginariumTheaterOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/genshin/api/role_combat{?active,schedule_type,need_detail,need_all,server,role_id}",
    {
      active: options?.active,
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
  options: GameRecordApiGetImaginariumTheaterOptionalParams = { requestOptions: {} },
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
  options: GameRecordApiGetSpiralAbyssOptionalParams = { requestOptions: {} },
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
  options: GameRecordApiGetSpiralAbyssOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getSpiralAbyssSend(context, cookie, ds, server, roleId, options);
  return _getSpiralAbyssDeserialize(result);
}

export function _getDailyNoteSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetDailyNoteOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/genshin/api/dailyNote{?server,role_id}",
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
  options: GameRecordApiGetDailyNoteOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getDailyNoteSend(context, cookie, ds, server, roleId, options);
  return _getDailyNoteDeserialize(result);
}

export function _getCharacterDetailsSend(
  context: Client,
  cookie: string,
  ds: string,
  body: CharacterDetailRequest,
  options: GameRecordApiGetCharacterDetailsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/game_record/app/genshin/api/character/detail")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: characterDetailRequestSerializer(body),
    });
}

export async function _getCharacterDetailsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseCharacterList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseCharacterListDeserializer(result.body);
}

/** Character IDs should be sent in batches of at most 40, as used by TeyvatGuide. */
export async function getCharacterDetails(
  context: Client,
  cookie: string,
  ds: string,
  body: CharacterDetailRequest,
  options: GameRecordApiGetCharacterDetailsOptionalParams = { requestOptions: {} },
): Promise<ApiResponseCharacterList> {
  const result = await _getCharacterDetailsSend(context, cookie, ds, body, options);
  return _getCharacterDetailsDeserialize(result);
}

export function _listCharactersSend(
  context: Client,
  cookie: string,
  ds: string,
  body: CharacterListRequest,
  options: GameRecordApiListCharactersOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/game_record/app/genshin/api/character/list")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: characterListRequestSerializer(body),
    });
}

export async function _listCharactersDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseCharacterList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseCharacterListDeserializer(result.body);
}

export async function listCharacters(
  context: Client,
  cookie: string,
  ds: string,
  body: CharacterListRequest,
  options: GameRecordApiListCharactersOptionalParams = { requestOptions: {} },
): Promise<ApiResponseCharacterList> {
  const result = await _listCharactersSend(context, cookie, ds, body, options);
  return _listCharactersDeserialize(result);
}

export function _getIndexSend(
  context: Client,
  cookie: string,
  ds: string,
  server: string,
  roleId: string,
  options: GameRecordApiGetIndexOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/genshin/api/index{?avatar_list_type,server,role_id}",
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
  options: GameRecordApiGetIndexOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getIndexSend(context, cookie, ds, server, roleId, options);
  return _getIndexDeserialize(result);
}
