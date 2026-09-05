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
    authkey: string,
    gachaType: string,
    lang: string,
    authAppid: string,
    options?: GachaLogApiGetBeyondHistoryOptionalParams,
  ) => Promise<ApiResponseGachaLogPage>;
  getHistory: (
    authkey: string,
    gachaType: string,
    lang: string,
    authAppid: string,
    options?: GachaLogApiGetHistoryOptionalParams,
  ) => Promise<ApiResponseGachaLogPage>;
}

function _getGachaLogApi(context: GameGenshinGachaContext) {
  return {
    getBeyondHistory: (
      authkey: string,
      gachaType: string,
      lang: string,
      authAppid: string,
      options?: GachaLogApiGetBeyondHistoryOptionalParams,
    ) => getBeyondHistory(context, authkey, gachaType, lang, authAppid, options),
    getHistory: (
      authkey: string,
      gachaType: string,
      lang: string,
      authAppid: string,
      options?: GachaLogApiGetHistoryOptionalParams,
    ) => getHistory(context, authkey, gachaType, lang, authAppid, options),
  };
}

export function _getGachaLogApiOperations(context: GameGenshinGachaContext): GachaLogApiOperations {
  return {
    ..._getGachaLogApi(context),
  };
}
