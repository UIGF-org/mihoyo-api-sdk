// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinSDKConfigContext } from "../../api/gameGenshinSDKConfigContext.js";
import {
  getShieldConfig,
  getGranterConfig,
  getPrecache,
  getCombo,
} from "../../api/configApi/operations.js";
import {
  ConfigApiGetShieldConfigOptionalParams,
  ConfigApiGetGranterConfigOptionalParams,
  ConfigApiGetPrecacheOptionalParams,
  ConfigApiGetComboOptionalParams,
} from "../../api/configApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a ConfigApi operations. */
export interface ConfigApiOperations {
  getShieldConfig: (
    clientParam: string,
    gameKey: string,
    options?: ConfigApiGetShieldConfigOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getGranterConfig: (
    appId: string,
    channelId: string,
    clientType: string,
    options?: ConfigApiGetGranterConfigOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getPrecache: (
    biz: string,
    clientParam: string,
    options?: ConfigApiGetPrecacheOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getCombo: (
    bizKey: string,
    clientType: string,
    options?: ConfigApiGetComboOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getConfigApi(context: GameGenshinSDKConfigContext) {
  return {
    getShieldConfig: (
      clientParam: string,
      gameKey: string,
      options?: ConfigApiGetShieldConfigOptionalParams,
    ) => getShieldConfig(context, clientParam, gameKey, options),
    getGranterConfig: (
      appId: string,
      channelId: string,
      clientType: string,
      options?: ConfigApiGetGranterConfigOptionalParams,
    ) => getGranterConfig(context, appId, channelId, clientType, options),
    getPrecache: (biz: string, clientParam: string, options?: ConfigApiGetPrecacheOptionalParams) =>
      getPrecache(context, biz, clientParam, options),
    getCombo: (bizKey: string, clientType: string, options?: ConfigApiGetComboOptionalParams) =>
      getCombo(context, bizKey, clientType, options),
  };
}

export function _getConfigApiOperations(context: GameGenshinSDKConfigContext): ConfigApiOperations {
  return {
    ..._getConfigApi(context),
  };
}
