// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinGachaContext } from "../../api/gameGenshinGachaContext.js";
import { getBeyondHistory, getHistory } from "../../api/gachaLogApi/operations.js";
import {
  GachaLogApiGetBeyondHistoryOptionalParams,
  GachaLogApiGetHistoryOptionalParams,
} from "../../api/gachaLogApi/options.js";
import { ApiResponseGachaLogPage } from "../../models/uigf/models.js";

/** Interface representing a GachaLogApi operations. */
export interface GachaLogApiOperations {
  getBeyondHistory: (
    gachaType: string,
    authkey: string,
    authAppid: string,
    lang: string,
    options?: GachaLogApiGetBeyondHistoryOptionalParams,
  ) => Promise<ApiResponseGachaLogPage>;
  getHistory: (
    gachaType: string,
    authkey: string,
    authAppid: string,
    lang: string,
    options?: GachaLogApiGetHistoryOptionalParams,
  ) => Promise<ApiResponseGachaLogPage>;
}

function _getGachaLogApi(context: GameGenshinGachaContext) {
  return {
    getBeyondHistory: (
      gachaType: string,
      authkey: string,
      authAppid: string,
      lang: string,
      options?: GachaLogApiGetBeyondHistoryOptionalParams,
    ) => getBeyondHistory(context, gachaType, authkey, authAppid, lang, options),
    getHistory: (
      gachaType: string,
      authkey: string,
      authAppid: string,
      lang: string,
      options?: GachaLogApiGetHistoryOptionalParams,
    ) => getHistory(context, gachaType, authkey, authAppid, lang, options),
  };
}

export function _getGachaLogApiOperations(context: GameGenshinGachaContext): GachaLogApiOperations {
  return {
    ..._getGachaLogApi(context),
  };
}
