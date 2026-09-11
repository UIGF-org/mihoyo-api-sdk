// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinUgcAnnouncementsContext as Client } from "../index.js";
import {
  ApiResponseAnnouncementList,
  apiResponseAnnouncementListDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { UgcApiGetAlertOptionalParams } from "./options.js";
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
  options: UgcApiGetAlertOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/common/hk4eugc_cn/announcement/api/getAlertAnn{?game,game_biz,lang,bundle_id,platform,region,level,uid,channel_id}",
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
  options: UgcApiGetAlertOptionalParams = { requestOptions: {} },
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
