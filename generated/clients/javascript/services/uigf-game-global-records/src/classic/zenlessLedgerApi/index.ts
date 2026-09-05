// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalRecordsContext } from "../../api/gameGlobalRecordsContext.js";
import { getMonthDetail, getMonthInfo } from "../../api/zenlessLedgerApi/operations.js";
import {
  ZenlessLedgerApiGetMonthDetailOptionalParams,
  ZenlessLedgerApiGetMonthInfoOptionalParams,
} from "../../api/zenlessLedgerApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a ZenlessLedgerApi operations. */
export interface ZenlessLedgerApiOperations {
  getMonthDetail: (
    cookie: string,
    typeParam: string,
    currentPage: number,
    roleId: string,
    server: string,
    options?: ZenlessLedgerApiGetMonthDetailOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getMonthInfo: (
    cookie: string,
    roleId: string,
    server: string,
    options?: ZenlessLedgerApiGetMonthInfoOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getZenlessLedgerApi(context: GameGlobalRecordsContext) {
  return {
    getMonthDetail: (
      cookie: string,
      typeParam: string,
      currentPage: number,
      roleId: string,
      server: string,
      options?: ZenlessLedgerApiGetMonthDetailOptionalParams,
    ) => getMonthDetail(context, cookie, typeParam, currentPage, roleId, server, options),
    getMonthInfo: (
      cookie: string,
      roleId: string,
      server: string,
      options?: ZenlessLedgerApiGetMonthInfoOptionalParams,
    ) => getMonthInfo(context, cookie, roleId, server, options),
  };
}

export function _getZenlessLedgerApiOperations(
  context: GameGlobalRecordsContext,
): ZenlessLedgerApiOperations {
  return {
    ..._getZenlessLedgerApi(context),
  };
}
