// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameCNEventsContext } from "../../api/gameCNEventsContext.js";
import { getMonthDetail, getMonthInfo } from "../../api/starRailLedgerApi/operations.js";
import {
  StarRailLedgerApiGetMonthDetailOptionalParams,
  StarRailLedgerApiGetMonthInfoOptionalParams,
} from "../../api/starRailLedgerApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a StarRailLedgerApi operations. */
export interface StarRailLedgerApiOperations {
  getMonthDetail: (
    cookie: string,
    typeParam: number,
    currentPage: number,
    roleId: string,
    server: string,
    options?: StarRailLedgerApiGetMonthDetailOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getMonthInfo: (
    cookie: string,
    roleId: string,
    server: string,
    options?: StarRailLedgerApiGetMonthInfoOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getStarRailLedgerApi(context: GameCNEventsContext) {
  return {
    getMonthDetail: (
      cookie: string,
      typeParam: number,
      currentPage: number,
      roleId: string,
      server: string,
      options?: StarRailLedgerApiGetMonthDetailOptionalParams,
    ) => getMonthDetail(context, cookie, typeParam, currentPage, roleId, server, options),
    getMonthInfo: (
      cookie: string,
      roleId: string,
      server: string,
      options?: StarRailLedgerApiGetMonthInfoOptionalParams,
    ) => getMonthInfo(context, cookie, roleId, server, options),
  };
}

export function _getStarRailLedgerApiOperations(
  context: GameCNEventsContext,
): StarRailLedgerApiOperations {
  return {
    ..._getStarRailLedgerApi(context),
  };
}
