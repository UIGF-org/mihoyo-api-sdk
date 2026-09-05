// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameAccountContext } from "../../api/gameAccountContext.js";
import { getHomePositions, getGachaPool } from "../../api/genshinObcApi/operations.js";
import {
  GenshinObcApiGetHomePositionsOptionalParams,
  GenshinObcApiGetGachaPoolOptionalParams,
} from "../../api/genshinObcApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a GenshinObcApi operations. */
export interface GenshinObcApiOperations {
  getHomePositions: (
    appSn: string,
    options?: GenshinObcApiGetHomePositionsOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getGachaPool: (
    appSn: string,
    options?: GenshinObcApiGetGachaPoolOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getGenshinObcApi(context: GameAccountContext) {
  return {
    getHomePositions: (appSn: string, options?: GenshinObcApiGetHomePositionsOptionalParams) =>
      getHomePositions(context, appSn, options),
    getGachaPool: (appSn: string, options?: GenshinObcApiGetGachaPoolOptionalParams) =>
      getGachaPool(context, appSn, options),
  };
}

export function _getGenshinObcApiOperations(context: GameAccountContext): GenshinObcApiOperations {
  return {
    ..._getGenshinObcApi(context),
  };
}
