// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinLedgerContext } from "../../api/gameGenshinLedgerContext.js";
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
    ds: string,
    month: number,
    page: number,
    typeParam: number,
    bindUid: string,
    bindRegion: string,
    options?: LedgerApiGetMonthDetailOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getMonthInfo: (
    cookie: string,
    ds: string,
    bindUid: string,
    bindRegion: string,
    options?: LedgerApiGetMonthInfoOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getLedgerApi(context: GameGenshinLedgerContext) {
  return {
    getMonthDetail: (
      cookie: string,
      ds: string,
      month: number,
      page: number,
      typeParam: number,
      bindUid: string,
      bindRegion: string,
      options?: LedgerApiGetMonthDetailOptionalParams,
    ) => getMonthDetail(context, cookie, ds, month, page, typeParam, bindUid, bindRegion, options),
    getMonthInfo: (
      cookie: string,
      ds: string,
      bindUid: string,
      bindRegion: string,
      options?: LedgerApiGetMonthInfoOptionalParams,
    ) => getMonthInfo(context, cookie, ds, bindUid, bindRegion, options),
  };
}

export function _getLedgerApiOperations(context: GameGenshinLedgerContext): LedgerApiOperations {
  return {
    ..._getLedgerApi(context),
  };
}
