// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinAnnouncementsContext } from "../../api/gameGenshinAnnouncementsContext.js";
import { getAlert, getContent, list } from "../../api/announcementApi/operations.js";
import {
  AnnouncementApiGetAlertOptionalParams,
  AnnouncementApiGetContentOptionalParams,
  AnnouncementApiListOptionalParams,
} from "../../api/announcementApi/options.js";
import { ApiResponseAnnouncementList } from "../../models/uigf/models.js";

/** Interface representing a AnnouncementApi operations. */
export interface AnnouncementApiOperations {
  getAlert: (
    game: string,
    gameBiz: string,
    lang: string,
    bundleId: string,
    platform: "pc" | "android" | "ios",
    region: string,
    options?: AnnouncementApiGetAlertOptionalParams,
  ) => Promise<ApiResponseAnnouncementList>;
  getContent: (
    game: string,
    gameBiz: string,
    lang: string,
    bundleId: string,
    platform: "pc" | "android" | "ios",
    region: string,
    options?: AnnouncementApiGetContentOptionalParams,
  ) => Promise<ApiResponseAnnouncementList>;
  list: (
    game: string,
    gameBiz: string,
    lang: string,
    bundleId: string,
    platform: "pc" | "android" | "ios",
    region: string,
    options?: AnnouncementApiListOptionalParams,
  ) => Promise<ApiResponseAnnouncementList>;
}

function _getAnnouncementApi(context: GameGenshinAnnouncementsContext) {
  return {
    getAlert: (
      game: string,
      gameBiz: string,
      lang: string,
      bundleId: string,
      platform: "pc" | "android" | "ios",
      region: string,
      options?: AnnouncementApiGetAlertOptionalParams,
    ) => getAlert(context, game, gameBiz, lang, bundleId, platform, region, options),
    getContent: (
      game: string,
      gameBiz: string,
      lang: string,
      bundleId: string,
      platform: "pc" | "android" | "ios",
      region: string,
      options?: AnnouncementApiGetContentOptionalParams,
    ) => getContent(context, game, gameBiz, lang, bundleId, platform, region, options),
    list: (
      game: string,
      gameBiz: string,
      lang: string,
      bundleId: string,
      platform: "pc" | "android" | "ios",
      region: string,
      options?: AnnouncementApiListOptionalParams,
    ) => list(context, game, gameBiz, lang, bundleId, platform, region, options),
  };
}

export function _getAnnouncementApiOperations(
  context: GameGenshinAnnouncementsContext,
): AnnouncementApiOperations {
  return {
    ..._getAnnouncementApi(context),
  };
}
