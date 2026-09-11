// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinAnnouncementsContext } from "../../api/gameGenshinAnnouncementsContext.js";
import { getAlertPicture, getAlert, list } from "../../api/announcementApi/operations.js";
import {
  AnnouncementApiGetAlertPictureOptionalParams,
  AnnouncementApiGetAlertOptionalParams,
  AnnouncementApiListOptionalParams,
} from "../../api/announcementApi/options.js";
import { ApiResponseAnnouncementList } from "../../models/uigf/models.js";

/** Interface representing a AnnouncementApi operations. */
export interface AnnouncementApiOperations {
  getAlertPicture: (
    game: string,
    gameBiz: string,
    lang: string,
    bundleId: string,
    platform: "pc" | "android" | "ios",
    region: string,
    options?: AnnouncementApiGetAlertPictureOptionalParams,
  ) => Promise<ApiResponseAnnouncementList>;
  getAlert: (
    game: string,
    gameBiz: string,
    lang: string,
    bundleId: string,
    platform: "pc" | "android" | "ios",
    region: string,
    options?: AnnouncementApiGetAlertOptionalParams,
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
    getAlertPicture: (
      game: string,
      gameBiz: string,
      lang: string,
      bundleId: string,
      platform: "pc" | "android" | "ios",
      region: string,
      options?: AnnouncementApiGetAlertPictureOptionalParams,
    ) => getAlertPicture(context, game, gameBiz, lang, bundleId, platform, region, options),
    getAlert: (
      game: string,
      gameBiz: string,
      lang: string,
      bundleId: string,
      platform: "pc" | "android" | "ios",
      region: string,
      options?: AnnouncementApiGetAlertOptionalParams,
    ) => getAlert(context, game, gameBiz, lang, bundleId, platform, region, options),
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
