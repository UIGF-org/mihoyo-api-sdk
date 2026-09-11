// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinGachaContext as Client } from "../index.js";
import {
  ApiResponseGachaLogPage,
  apiResponseGachaLogPageDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  GachaLogApiGetBeyondHistoryOptionalParams,
  GachaLogApiGetHistoryOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getBeyondHistorySend(
  context: Client,
  gachaType: string,
  authkey: string,
  authAppid: string,
  lang: string,
  options: GachaLogApiGetBeyondHistoryOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/gacha_info/api/getBeyondGachaLog{?gacha_type,gacha_id,end_id,page,size,region,game_biz,device_type,game_version,init_type,no_joypad_close,timestamp,win_mode,authkey,auth_appid,authkey_ver,sign_type,lang}",
    {
      gacha_type: gachaType,
      gacha_id: options?.gachaId,
      end_id: options?.endId,
      page: options?.page,
      size: options?.size,
      region: options?.region,
      game_biz: options?.gameBiz,
      device_type: options?.deviceType,
      game_version: options?.gameVersion,
      init_type: options?.initType,
      no_joypad_close: options?.noJoypadClose,
      timestamp: options?.timestamp,
      win_mode: options?.winMode,
      authkey: authkey,
      auth_appid: authAppid,
      authkey_ver: "1",
      sign_type: "2",
      lang: lang,
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

export async function _getBeyondHistoryDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseGachaLogPage> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseGachaLogPageDeserializer(result.body);
}

export async function getBeyondHistory(
  context: Client,
  gachaType: string,
  authkey: string,
  authAppid: string,
  lang: string,
  options: GachaLogApiGetBeyondHistoryOptionalParams = { requestOptions: {} },
): Promise<ApiResponseGachaLogPage> {
  const result = await _getBeyondHistorySend(context, gachaType, authkey, authAppid, lang, options);
  return _getBeyondHistoryDeserialize(result);
}

export function _getHistorySend(
  context: Client,
  gachaType: string,
  authkey: string,
  authAppid: string,
  lang: string,
  options: GachaLogApiGetHistoryOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/gacha_info/api/getGachaLog{?gacha_type,gacha_id,end_id,page,size,region,game_biz,device_type,game_version,init_type,no_joypad_close,timestamp,win_mode,authkey,auth_appid,authkey_ver,sign_type,lang}",
    {
      gacha_type: gachaType,
      gacha_id: options?.gachaId,
      end_id: options?.endId,
      page: options?.page,
      size: options?.size,
      region: options?.region,
      game_biz: options?.gameBiz,
      device_type: options?.deviceType,
      game_version: options?.gameVersion,
      init_type: options?.initType,
      no_joypad_close: options?.noJoypadClose,
      timestamp: options?.timestamp,
      win_mode: options?.winMode,
      authkey: authkey,
      auth_appid: authAppid,
      authkey_ver: "1",
      sign_type: "2",
      lang: lang,
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

export async function _getHistoryDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseGachaLogPage> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseGachaLogPageDeserializer(result.body);
}

export async function getHistory(
  context: Client,
  gachaType: string,
  authkey: string,
  authAppid: string,
  lang: string,
  options: GachaLogApiGetHistoryOptionalParams = { requestOptions: {} },
): Promise<ApiResponseGachaLogPage> {
  const result = await _getHistorySend(context, gachaType, authkey, authAppid, lang, options);
  return _getHistoryDeserialize(result);
}
