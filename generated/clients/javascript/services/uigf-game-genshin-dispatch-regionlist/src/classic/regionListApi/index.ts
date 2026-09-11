// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinDispatchRegionListContext } from "../../api/gameGenshinDispatchRegionListContext.js";
import { query } from "../../api/regionListApi/operations.js";
import { RegionListApiQueryOptionalParams } from "../../api/regionListApi/options.js";
import { RegionListApiQueryResponse } from "../../models/models.js";

/** Interface representing a RegionListApi operations. */
export interface RegionListApiOperations {
  query: (options?: RegionListApiQueryOptionalParams) => Promise<RegionListApiQueryResponse>;
}

function _getRegionListApi(context: GameGenshinDispatchRegionListContext) {
  return {
    query: (options?: RegionListApiQueryOptionalParams) => query(context, options),
  };
}

export function _getRegionListApiOperations(
  context: GameGenshinDispatchRegionListContext,
): RegionListApiOperations {
  return {
    ..._getRegionListApi(context),
  };
}
