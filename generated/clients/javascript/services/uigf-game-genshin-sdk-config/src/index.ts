// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGenshinSDKConfigClient } from "./gameGenshinSDKConfigClient.js";
export type { ApiResponseJsonObject, JsonObject } from "./models/uigf/index.js";
export type { GameGenshinSDKConfigClientOptionalParams } from "./api/index.js";
export type {
  ConfigApiGetShieldConfigOptionalParams,
  ConfigApiGetGranterConfigOptionalParams,
  ConfigApiGetPrecacheOptionalParams,
  ConfigApiGetComboOptionalParams,
} from "./api/configApi/index.js";
export type { ConfigApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
