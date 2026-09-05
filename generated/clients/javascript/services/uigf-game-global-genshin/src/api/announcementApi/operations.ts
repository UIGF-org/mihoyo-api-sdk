// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalGenshinContext as Client } from "../index.js";
import {
  ApiResponseAnnouncementList,
  apiResponseAnnouncementListDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  AnnouncementApiGetAlertOptionalParams,
  AnnouncementApiGetContentOptionalParams,
  AnnouncementApiListOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getAlertSend(
  context: Client,
  game: string,
  gameBiz: string,
  lang: string,
  bundleId: string,
  platform: "pc" | "android" | "ios",
  region: string,
  options: AnnouncementApiGetAlertOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/common/hk4e_global/announcement/api/getAlertAnn{?game,game_biz,lang,bundle_id,platform,region,level,uid,channel_id}",
    {
      game: game,
      game_biz: gameBiz,
      lang: lang,
      bundle_id: bundleId,
      platform: platform,
      region: region,
      level: options?.level,
      uid: options?.uid,
      channel_id: options?.channelId,
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

export async function _getAlertDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseAnnouncementList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseAnnouncementListDeserializer(result.body);
}

export async function getAlert(
  context: Client,
  game: string,
  gameBiz: string,
  lang: string,
  bundleId: string,
  platform: "pc" | "android" | "ios",
  region: string,
  options: AnnouncementApiGetAlertOptionalParams = { requestOptions: {} },
): Promise<ApiResponseAnnouncementList> {
  const result = await _getAlertSend(
    context,
    game,
    gameBiz,
    lang,
    bundleId,
    platform,
    region,
    options,
  );
  return _getAlertDeserialize(result);
}

export function _getContentSend(
  context: Client,
  game: string,
  gameBiz: string,
  lang: string,
  bundleId: string,
  platform: "pc" | "android" | "ios",
  region: string,
  options: AnnouncementApiGetContentOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/common/hk4e_global/announcement/api/getAnnContent{?game,game_biz,lang,bundle_id,platform,region,level,uid,channel_id}",
    {
      game: game,
      game_biz: gameBiz,
      lang: lang,
      bundle_id: bundleId,
      platform: platform,
      region: region,
      level: options?.level,
      uid: options?.uid,
      channel_id: options?.channelId,
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

export async function _getContentDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseAnnouncementList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseAnnouncementListDeserializer(result.body);
}

export async function getContent(
  context: Client,
  game: string,
  gameBiz: string,
  lang: string,
  bundleId: string,
  platform: "pc" | "android" | "ios",
  region: string,
  options: AnnouncementApiGetContentOptionalParams = { requestOptions: {} },
): Promise<ApiResponseAnnouncementList> {
  const result = await _getContentSend(
    context,
    game,
    gameBiz,
    lang,
    bundleId,
    platform,
    region,
    options,
  );
  return _getContentDeserialize(result);
}

export function _listSend(
  context: Client,
  game: string,
  gameBiz: string,
  lang: string,
  bundleId: string,
  platform: "pc" | "android" | "ios",
  region: string,
  options: AnnouncementApiListOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/common/hk4e_global/announcement/api/getAnnList{?game,game_biz,lang,bundle_id,platform,region,level,uid,channel_id}",
    {
      game: game,
      game_biz: gameBiz,
      lang: lang,
      bundle_id: bundleId,
      platform: platform,
      region: region,
      level: options?.level,
      uid: options?.uid,
      channel_id: options?.channelId,
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

export async function _listDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseAnnouncementList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseAnnouncementListDeserializer(result.body);
}

export async function list(
  context: Client,
  game: string,
  gameBiz: string,
  lang: string,
  bundleId: string,
  platform: "pc" | "android" | "ios",
  region: string,
  options: AnnouncementApiListOptionalParams = { requestOptions: {} },
): Promise<ApiResponseAnnouncementList> {
  const result = await _listSend(context, game, gameBiz, lang, bundleId, platform, region, options);
  return _listDeserialize(result);
}
