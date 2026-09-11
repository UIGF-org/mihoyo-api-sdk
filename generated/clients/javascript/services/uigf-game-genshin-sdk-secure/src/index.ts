// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGenshinSDKSecureClient } from "./gameGenshinSDKSecureClient.js";
export type { ApiResponseJsonObject, JsonObject } from "./models/uigf/index.js";
export type {
  ProtocolVersionRequest,
  RedDotRequest,
} from "./models/uigf/game/genshin/sdk/index.js";
export type { GameGenshinSDKSecureClientOptionalParams } from "./api/index.js";
export type {
  SecureApiGetRedDotsOptionalParams,
  SecureApiCompareProtocolVersionOptionalParams,
} from "./api/secureApi/index.js";
export type { SecureApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
