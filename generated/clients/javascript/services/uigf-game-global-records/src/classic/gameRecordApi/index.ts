// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalRecordsContext } from "../../api/gameGlobalRecordsContext.js";
import {
  getStarRailChallengePeak,
  getStarRailDailyNote,
  getStarRailIndex,
  getGenshinDailyNote,
  getGenshinIndex,
} from "../../api/gameRecordApi/operations.js";
import {
  GameRecordApiGetStarRailChallengePeakOptionalParams,
  GameRecordApiGetStarRailDailyNoteOptionalParams,
  GameRecordApiGetStarRailIndexOptionalParams,
  GameRecordApiGetGenshinDailyNoteOptionalParams,
  GameRecordApiGetGenshinIndexOptionalParams,
} from "../../api/gameRecordApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a GameRecordApi operations. */
export interface GameRecordApiOperations {
  getStarRailChallengePeak: (
    cookie: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetStarRailChallengePeakOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getStarRailDailyNote: (
    cookie: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetStarRailDailyNoteOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getStarRailIndex: (
    cookie: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetStarRailIndexOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getGenshinDailyNote: (
    cookie: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetGenshinDailyNoteOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getGenshinIndex: (
    cookie: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetGenshinIndexOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getGameRecordApi(context: GameGlobalRecordsContext) {
  return {
    getStarRailChallengePeak: (
      cookie: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetStarRailChallengePeakOptionalParams,
    ) => getStarRailChallengePeak(context, cookie, server, roleId, options),
    getStarRailDailyNote: (
      cookie: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetStarRailDailyNoteOptionalParams,
    ) => getStarRailDailyNote(context, cookie, server, roleId, options),
    getStarRailIndex: (
      cookie: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetStarRailIndexOptionalParams,
    ) => getStarRailIndex(context, cookie, server, roleId, options),
    getGenshinDailyNote: (
      cookie: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetGenshinDailyNoteOptionalParams,
    ) => getGenshinDailyNote(context, cookie, server, roleId, options),
    getGenshinIndex: (
      cookie: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetGenshinIndexOptionalParams,
    ) => getGenshinIndex(context, cookie, server, roleId, options),
  };
}

export function _getGameRecordApiOperations(
  context: GameGlobalRecordsContext,
): GameRecordApiOperations {
  return {
    ..._getGameRecordApi(context),
  };
}
