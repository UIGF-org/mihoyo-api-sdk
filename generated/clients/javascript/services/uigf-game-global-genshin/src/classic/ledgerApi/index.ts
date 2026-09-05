// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalGenshinContext } from "../../api/gameGlobalGenshinContext.js";
import { getMonthDetail, getMonthInfo } from "../../api/ledgerApi/operations.js";
import {
  LedgerApiGetMonthDetailOptionalParams,
  LedgerApiGetMonthInfoOptionalParams,
} from "../../api/ledgerApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a LedgerApi operations. */
export interface LedgerApiOperations {
  getMonthDetail: (
    cookie: string,
    typeParam: number,
    currentPage: number,
    roleId: string,
    server: string,
    options?: LedgerApiGetMonthDetailOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getMonthInfo: (
    cookie: string,
    roleId: string,
    server: string,
    options?: LedgerApiGetMonthInfoOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getLedgerApi(context: GameGlobalGenshinContext) {
  return {
    getMonthDetail: (
      cookie: string,
      typeParam: number,
      currentPage: number,
      roleId: string,
      server: string,
      options?: LedgerApiGetMonthDetailOptionalParams,
    ) => getMonthDetail(context, cookie, typeParam, currentPage, roleId, server, options),
    getMonthInfo: (
      cookie: string,
      roleId: string,
      server: string,
      options?: LedgerApiGetMonthInfoOptionalParams,
    ) => getMonthInfo(context, cookie, roleId, server, options),
  };
}

export function _getLedgerApiOperations(context: GameGlobalGenshinContext): LedgerApiOperations {
  return {
    ..._getLedgerApi(context),
  };
}
