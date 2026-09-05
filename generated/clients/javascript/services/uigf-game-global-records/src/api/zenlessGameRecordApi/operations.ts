// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalRecordsContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
  ApiResponseGachaLogPage,
  apiResponseGachaLogPageDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  ZenlessGameRecordApiGetThresholdSimulationDetailOptionalParams,
  ZenlessGameRecordApiGetThresholdSimulationSummaryOptionalParams,
  ZenlessGameRecordApiGetDeadlyAssaultOptionalParams,
  ZenlessGameRecordApiGetShiyuDefenseOptionalParams,
  ZenlessGameRecordApiGetGachaRecordOptionalParams,
  ZenlessGameRecordApiGetDailyNoteOptionalParams,
  ZenlessGameRecordApiGetIndexOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getThresholdSimulationDetailSend(
  context: Client,
  cookie: string,
  region: string,
  uid: string,
  voidFrontId: number,
  options: ZenlessGameRecordApiGetThresholdSimulationDetailOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record_zzz/api/zzz/void_front_battle_detail{?region,uid,void_front_id}",
    {
      region: region,
      uid: uid,
      void_front_id: voidFrontId,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getThresholdSimulationDetailDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getThresholdSimulationDetail(
  context: Client,
  cookie: string,
  region: string,
  uid: string,
  voidFrontId: number,
  options: ZenlessGameRecordApiGetThresholdSimulationDetailOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getThresholdSimulationDetailSend(
    context,
    cookie,
    region,
    uid,
    voidFrontId,
    options,
  );
  return _getThresholdSimulationDetailDeserialize(result);
}

export function _getThresholdSimulationSummarySend(
  context: Client,
  cookie: string,
  region: string,
  uid: string,
  options: ZenlessGameRecordApiGetThresholdSimulationSummaryOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record_zzz/api/zzz/void_front_battle_abstract_info{?region,uid}",
    {
      region: region,
      uid: uid,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getThresholdSimulationSummaryDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getThresholdSimulationSummary(
  context: Client,
  cookie: string,
  region: string,
  uid: string,
  options: ZenlessGameRecordApiGetThresholdSimulationSummaryOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getThresholdSimulationSummarySend(context, cookie, region, uid, options);
  return _getThresholdSimulationSummaryDeserialize(result);
}

export function _getDeadlyAssaultSend(
  context: Client,
  cookie: string,
  scheduleType: number,
  region: string,
  uid: string,
  options: ZenlessGameRecordApiGetDeadlyAssaultOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record_zzz/api/zzz/hadal_mem_detail_v2{?schedule_type,region,uid}",
    {
      schedule_type: scheduleType,
      region: region,
      uid: uid,
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

export async function _getDeadlyAssaultDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getDeadlyAssault(
  context: Client,
  cookie: string,
  scheduleType: number,
  region: string,
  uid: string,
  options: ZenlessGameRecordApiGetDeadlyAssaultOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getDeadlyAssaultSend(context, cookie, scheduleType, region, uid, options);
  return _getDeadlyAssaultDeserialize(result);
}

export function _getShiyuDefenseSend(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: ZenlessGameRecordApiGetShiyuDefenseOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record_zzz/api/zzz/hadal_info_v2{?schedule_type,need_detail,need_all,server,role_id}",
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

export async function _getShiyuDefenseDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getShiyuDefense(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: ZenlessGameRecordApiGetShiyuDefenseOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getShiyuDefenseSend(context, cookie, server, roleId, options);
  return _getShiyuDefenseDeserialize(result);
}

export function _getGachaRecordSend(
  context: Client,
  cookie: string,
  uid: string,
  region: string,
  gachaType: number,
  options: ZenlessGameRecordApiGetGachaRecordOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record_zzz/api/zzz/gacha_record{?uid,region,gacha_type,end_id,lang}",
    {
      uid: uid,
      region: region,
      gacha_type: gachaType,
      end_id: options?.endId,
      lang: options?.lang,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getGachaRecordDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseGachaLogPage> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseGachaLogPageDeserializer(result.body);
}

export async function getGachaRecord(
  context: Client,
  cookie: string,
  uid: string,
  region: string,
  gachaType: number,
  options: ZenlessGameRecordApiGetGachaRecordOptionalParams = { requestOptions: {} },
): Promise<ApiResponseGachaLogPage> {
  const result = await _getGachaRecordSend(context, cookie, uid, region, gachaType, options);
  return _getGachaRecordDeserialize(result);
}

export function _getDailyNoteSend(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: ZenlessGameRecordApiGetDailyNoteOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record_zzz/api/zzz/note{?server,role_id}",
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
  server: string,
  roleId: string,
  options: ZenlessGameRecordApiGetDailyNoteOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getDailyNoteSend(context, cookie, server, roleId, options);
  return _getDailyNoteDeserialize(result);
}

export function _getIndexSend(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: ZenlessGameRecordApiGetIndexOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/game_record_zzz/api/zzz/index{?server,role_id}",
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
  server: string,
  roleId: string,
  options: ZenlessGameRecordApiGetIndexOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getIndexSend(context, cookie, server, roleId, options);
  return _getIndexDeserialize(result);
}
