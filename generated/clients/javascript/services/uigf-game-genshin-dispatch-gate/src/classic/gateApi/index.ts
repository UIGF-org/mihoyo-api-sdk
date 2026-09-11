// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinDispatchGateContext } from "../../api/gameGenshinDispatchGateContext.js";
import { getAddress } from "../../api/gateApi/operations.js";
import { GateApiGetAddressOptionalParams } from "../../api/gateApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a GateApi operations. */
export interface GateApiOperations {
  getAddress: (
    game: string,
    region: string,
    options?: GateApiGetAddressOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getGateApi(context: GameGenshinDispatchGateContext) {
  return {
    getAddress: (game: string, region: string, options?: GateApiGetAddressOptionalParams) =>
      getAddress(context, game, region, options),
  };
}

export function _getGateApiOperations(context: GameGenshinDispatchGateContext): GateApiOperations {
  return {
    ..._getGateApi(context),
  };
}
