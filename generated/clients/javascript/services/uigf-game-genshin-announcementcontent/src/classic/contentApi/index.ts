// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinAnnouncementContentContext } from "../../api/gameGenshinAnnouncementContentContext.js";
import { get } from "../../api/contentApi/operations.js";
import { ContentApiGetOptionalParams } from "../../api/contentApi/options.js";
import { ApiResponseAnnouncementList } from "../../models/uigf/models.js";

/** Interface representing a ContentApi operations. */
export interface ContentApiOperations {
  get: (
    game: string,
    gameBiz: string,
    lang: string,
    bundleId: string,
    platform: "pc" | "android" | "ios",
    region: string,
    options?: ContentApiGetOptionalParams,
  ) => Promise<ApiResponseAnnouncementList>;
}

function _getContentApi(context: GameGenshinAnnouncementContentContext) {
  return {
    get: (
      game: string,
      gameBiz: string,
      lang: string,
      bundleId: string,
      platform: "pc" | "android" | "ios",
      region: string,
      options?: ContentApiGetOptionalParams,
    ) => get(context, game, gameBiz, lang, bundleId, platform, region, options),
  };
}

export function _getContentApiOperations(
  context: GameGenshinAnnouncementContentContext,
): ContentApiOperations {
  return {
    ..._getContentApi(context),
  };
}
