// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameCNEventsClient } from "./gameCNEventsClient.js";
export type { ApiResponseJsonObject, JsonObject } from "./models/uigf/index.js";
export type { GameCNEventsClientOptionalParams } from "./api/index.js";
export type {
  StarRailLedgerApiGetMonthDetailOptionalParams,
  StarRailLedgerApiGetMonthInfoOptionalParams,
} from "./api/starRailLedgerApi/index.js";
export type {
  ZenlessCultivationApiGetIconInfoOptionalParams,
  ZenlessCultivationApiGetItemsOptionalParams,
} from "./api/zenlessCultivationApi/index.js";
export type {
  ZenlessLedgerApiGetMonthDetailOptionalParams,
  ZenlessLedgerApiGetMonthInfoOptionalParams,
} from "./api/zenlessLedgerApi/index.js";
export type {
  StarRailLedgerApiOperations,
  ZenlessCultivationApiOperations,
  ZenlessLedgerApiOperations,
} from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
