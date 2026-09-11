// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinAnnouncementContentContext as Client } from "../index.js";
import {
  ApiResponseAnnouncementList,
  apiResponseAnnouncementListDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { ContentApiGetOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getSend(
  context: Client,
  game: string,
  gameBiz: string,
  lang: string,
  bundleId: string,
  platform: "pc" | "android" | "ios",
  region: string,
  options: ContentApiGetOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/common/hk4e_cn/announcement/api/getAnnContent{?t,game,game_biz,lang,bundle_id,platform,region,level,uid,channel_id}",
    {
      t: options?.t,
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

export async function _getDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseAnnouncementList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseAnnouncementListDeserializer(result.body);
}

export async function get(
  context: Client,
  game: string,
  gameBiz: string,
  lang: string,
  bundleId: string,
  platform: "pc" | "android" | "ios",
  region: string,
  options: ContentApiGetOptionalParams = { requestOptions: {} },
): Promise<ApiResponseAnnouncementList> {
  const result = await _getSend(context, game, gameBiz, lang, bundleId, platform, region, options);
  return _getDeserialize(result);
}
