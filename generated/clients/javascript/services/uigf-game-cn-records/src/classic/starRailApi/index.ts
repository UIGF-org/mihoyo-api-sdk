// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameCNRecordsContext } from "../../api/gameCNRecordsContext.js";
import {
  getChallengePeak,
  getSimulatedUniverse,
  getApocalypticShadow,
  getPureFiction,
  getForgottenHall,
  getDailyNote,
  getIndex,
} from "../../api/starRailApi/operations.js";
import {
  StarRailApiGetChallengePeakOptionalParams,
  StarRailApiGetSimulatedUniverseOptionalParams,
  StarRailApiGetApocalypticShadowOptionalParams,
  StarRailApiGetPureFictionOptionalParams,
  StarRailApiGetForgottenHallOptionalParams,
  StarRailApiGetDailyNoteOptionalParams,
  StarRailApiGetIndexOptionalParams,
} from "../../api/starRailApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a StarRailApi operations. */
export interface StarRailApiOperations {
  getChallengePeak: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailApiGetChallengePeakOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getSimulatedUniverse: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailApiGetSimulatedUniverseOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getApocalypticShadow: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailApiGetApocalypticShadowOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getPureFiction: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailApiGetPureFictionOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getForgottenHall: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailApiGetForgottenHallOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getDailyNote: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailApiGetDailyNoteOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getIndex: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailApiGetIndexOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getStarRailApi(context: GameCNRecordsContext) {
  return {
    getChallengePeak: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailApiGetChallengePeakOptionalParams,
    ) => getChallengePeak(context, cookie, ds, server, roleId, options),
    getSimulatedUniverse: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailApiGetSimulatedUniverseOptionalParams,
    ) => getSimulatedUniverse(context, cookie, ds, server, roleId, options),
    getApocalypticShadow: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailApiGetApocalypticShadowOptionalParams,
    ) => getApocalypticShadow(context, cookie, ds, server, roleId, options),
    getPureFiction: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailApiGetPureFictionOptionalParams,
    ) => getPureFiction(context, cookie, ds, server, roleId, options),
    getForgottenHall: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailApiGetForgottenHallOptionalParams,
    ) => getForgottenHall(context, cookie, ds, server, roleId, options),
    getDailyNote: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailApiGetDailyNoteOptionalParams,
    ) => getDailyNote(context, cookie, ds, server, roleId, options),
    getIndex: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailApiGetIndexOptionalParams,
    ) => getIndex(context, cookie, ds, server, roleId, options),
  };
}

export function _getStarRailApiOperations(context: GameCNRecordsContext): StarRailApiOperations {
  return {
    ..._getStarRailApi(context),
  };
}
