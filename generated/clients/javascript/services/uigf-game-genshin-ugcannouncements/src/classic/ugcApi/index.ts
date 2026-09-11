// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinUgcAnnouncementsContext } from "../../api/gameGenshinUgcAnnouncementsContext.js";
import { getAlert } from "../../api/ugcApi/operations.js";
import { UgcApiGetAlertOptionalParams } from "../../api/ugcApi/options.js";
import { ApiResponseAnnouncementList } from "../../models/uigf/models.js";

/** Interface representing a UgcApi operations. */
export interface UgcApiOperations {
  getAlert: (
    game: string,
    gameBiz: string,
    lang: string,
    bundleId: string,
    platform: "pc" | "android" | "ios",
    region: string,
    options?: UgcApiGetAlertOptionalParams,
  ) => Promise<ApiResponseAnnouncementList>;
}

function _getUgcApi(context: GameGenshinUgcAnnouncementsContext) {
  return {
    getAlert: (
      game: string,
      gameBiz: string,
      lang: string,
      bundleId: string,
      platform: "pc" | "android" | "ios",
      region: string,
      options?: UgcApiGetAlertOptionalParams,
    ) => getAlert(context, game, gameBiz, lang, bundleId, platform, region, options),
  };
}

export function _getUgcApiOperations(
  context: GameGenshinUgcAnnouncementsContext,
): UgcApiOperations {
  return {
    ..._getUgcApi(context),
  };
}
