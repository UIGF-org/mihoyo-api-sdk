// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinSDKSecureContext } from "../../api/gameGenshinSDKSecureContext.js";
import { getRedDots, compareProtocolVersion } from "../../api/secureApi/operations.js";
import {
  SecureApiGetRedDotsOptionalParams,
  SecureApiCompareProtocolVersionOptionalParams,
} from "../../api/secureApi/options.js";
import {
  ProtocolVersionRequest,
  RedDotRequest,
} from "../../models/uigf/game/genshin/sdk/models.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a SecureApi operations. */
export interface SecureApiOperations {
  getRedDots: (
    body: RedDotRequest,
    options?: SecureApiGetRedDotsOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  compareProtocolVersion: (
    body: ProtocolVersionRequest,
    options?: SecureApiCompareProtocolVersionOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getSecureApi(context: GameGenshinSDKSecureContext) {
  return {
    getRedDots: (body: RedDotRequest, options?: SecureApiGetRedDotsOptionalParams) =>
      getRedDots(context, body, options),
    compareProtocolVersion: (
      body: ProtocolVersionRequest,
      options?: SecureApiCompareProtocolVersionOptionalParams,
    ) => compareProtocolVersion(context, body, options),
  };
}

export function _getSecureApiOperations(context: GameGenshinSDKSecureContext): SecureApiOperations {
  return {
    ..._getSecureApi(context),
  };
}
