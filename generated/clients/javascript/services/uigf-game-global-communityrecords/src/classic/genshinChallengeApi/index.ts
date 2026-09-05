// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalCommunityRecordsContext } from "../../api/gameGlobalCommunityRecordsContext.js";
import {
  getStygianOnslaught,
  getImaginariumTheater,
  getSpiralAbyss,
} from "../../api/genshinChallengeApi/operations.js";
import {
  GenshinChallengeApiGetStygianOnslaughtOptionalParams,
  GenshinChallengeApiGetImaginariumTheaterOptionalParams,
  GenshinChallengeApiGetSpiralAbyssOptionalParams,
} from "../../api/genshinChallengeApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a GenshinChallengeApi operations. */
export interface GenshinChallengeApiOperations {
  getStygianOnslaught: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GenshinChallengeApiGetStygianOnslaughtOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getImaginariumTheater: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GenshinChallengeApiGetImaginariumTheaterOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getSpiralAbyss: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GenshinChallengeApiGetSpiralAbyssOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getGenshinChallengeApi(context: GameGlobalCommunityRecordsContext) {
  return {
    getStygianOnslaught: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GenshinChallengeApiGetStygianOnslaughtOptionalParams,
    ) => getStygianOnslaught(context, cookie, ds, server, roleId, options),
    getImaginariumTheater: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GenshinChallengeApiGetImaginariumTheaterOptionalParams,
    ) => getImaginariumTheater(context, cookie, ds, server, roleId, options),
    getSpiralAbyss: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GenshinChallengeApiGetSpiralAbyssOptionalParams,
    ) => getSpiralAbyss(context, cookie, ds, server, roleId, options),
  };
}

export function _getGenshinChallengeApiOperations(
  context: GameGlobalCommunityRecordsContext,
): GenshinChallengeApiOperations {
  return {
    ..._getGenshinChallengeApi(context),
  };
}
