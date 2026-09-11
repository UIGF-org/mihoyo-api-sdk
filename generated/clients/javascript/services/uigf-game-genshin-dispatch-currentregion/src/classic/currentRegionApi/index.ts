// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinDispatchCurrentRegionContext } from "../../api/gameGenshinDispatchCurrentRegionContext.js";
import { query } from "../../api/currentRegionApi/operations.js";
import { CurrentRegionApiQueryOptionalParams } from "../../api/currentRegionApi/options.js";
import { SignedDispatchResponse } from "../../models/uigf/game/genshin/dispatch/models.js";

/** Interface representing a CurrentRegionApi operations. */
export interface CurrentRegionApiOperations {
  query: (options?: CurrentRegionApiQueryOptionalParams) => Promise<SignedDispatchResponse>;
}

function _getCurrentRegionApi(context: GameGenshinDispatchCurrentRegionContext) {
  return {
    query: (options?: CurrentRegionApiQueryOptionalParams) => query(context, options),
  };
}

export function _getCurrentRegionApiOperations(
  context: GameGenshinDispatchCurrentRegionContext,
): CurrentRegionApiOperations {
  return {
    ..._getCurrentRegionApi(context),
  };
}
