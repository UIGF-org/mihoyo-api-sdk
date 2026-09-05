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
  authkey: string,
  gachaType: string,
  lang: string,
  authAppid: string,
  options: GachaLogApiGetBeyondHistoryOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/gacha_info/api/getBeyondGachaLog{?authkey,gacha_type,end_id,lang,auth_appid,authkey_ver,sign_type,size}",
    {
      authkey: authkey,
      gacha_type: gachaType,
      end_id: options?.endId,
      lang: lang,
      auth_appid: authAppid,
      authkey_ver: "1",
      sign_type: "2",
      size: options?.size,
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
  authkey: string,
  gachaType: string,
  lang: string,
  authAppid: string,
  options: GachaLogApiGetBeyondHistoryOptionalParams = { requestOptions: {} },
): Promise<ApiResponseGachaLogPage> {
  const result = await _getBeyondHistorySend(context, authkey, gachaType, lang, authAppid, options);
  return _getBeyondHistoryDeserialize(result);
}

export function _getHistorySend(
  context: Client,
  authkey: string,
  gachaType: string,
  lang: string,
  authAppid: string,
  options: GachaLogApiGetHistoryOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/gacha_info/api/getGachaLog{?authkey,gacha_type,end_id,lang,auth_appid,authkey_ver,sign_type,size}",
    {
      authkey: authkey,
      gacha_type: gachaType,
      end_id: options?.endId,
      lang: lang,
      auth_appid: authAppid,
      authkey_ver: "1",
      sign_type: "2",
      size: options?.size,
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
  authkey: string,
  gachaType: string,
  lang: string,
  authAppid: string,
  options: GachaLogApiGetHistoryOptionalParams = { requestOptions: {} },
): Promise<ApiResponseGachaLogPage> {
  const result = await _getHistorySend(context, authkey, gachaType, lang, authAppid, options);
  return _getHistoryDeserialize(result);
}
