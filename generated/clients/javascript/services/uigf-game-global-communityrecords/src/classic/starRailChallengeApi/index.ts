// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalCommunityRecordsContext } from "../../api/gameGlobalCommunityRecordsContext.js";
import {
  getSimulatedUniverse,
  getApocalypticShadow,
  getPureFiction,
  getForgottenHall,
} from "../../api/starRailChallengeApi/operations.js";
import {
  StarRailChallengeApiGetSimulatedUniverseOptionalParams,
  StarRailChallengeApiGetApocalypticShadowOptionalParams,
  StarRailChallengeApiGetPureFictionOptionalParams,
  StarRailChallengeApiGetForgottenHallOptionalParams,
} from "../../api/starRailChallengeApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a StarRailChallengeApi operations. */
export interface StarRailChallengeApiOperations {
  getSimulatedUniverse: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailChallengeApiGetSimulatedUniverseOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getApocalypticShadow: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailChallengeApiGetApocalypticShadowOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getPureFiction: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailChallengeApiGetPureFictionOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getForgottenHall: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: StarRailChallengeApiGetForgottenHallOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getStarRailChallengeApi(context: GameGlobalCommunityRecordsContext) {
  return {
    getSimulatedUniverse: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailChallengeApiGetSimulatedUniverseOptionalParams,
    ) => getSimulatedUniverse(context, cookie, ds, server, roleId, options),
    getApocalypticShadow: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailChallengeApiGetApocalypticShadowOptionalParams,
    ) => getApocalypticShadow(context, cookie, ds, server, roleId, options),
    getPureFiction: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailChallengeApiGetPureFictionOptionalParams,
    ) => getPureFiction(context, cookie, ds, server, roleId, options),
    getForgottenHall: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: StarRailChallengeApiGetForgottenHallOptionalParams,
    ) => getForgottenHall(context, cookie, ds, server, roleId, options),
  };
}

export function _getStarRailChallengeApiOperations(
  context: GameGlobalCommunityRecordsContext,
): StarRailChallengeApiOperations {
  return {
    ..._getStarRailChallengeApi(context),
  };
}
