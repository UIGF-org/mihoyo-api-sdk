// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGenshinGachaClient } from "./gameGenshinGachaClient.js";
export type { ApiResponseGachaLogPage, GachaLogPage, GachaItem } from "./models/uigf/index.js";
export type { GameGenshinGachaClientOptionalParams } from "./api/index.js";
export type {
  GachaLogApiGetBeyondHistoryOptionalParams,
  GachaLogApiGetHistoryOptionalParams,
} from "./api/gachaLogApi/index.js";
export type { GachaLogApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
