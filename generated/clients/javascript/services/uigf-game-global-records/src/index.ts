// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGlobalRecordsClient } from "./gameGlobalRecordsClient.js";
export type {
  ApiResponseJsonObject,
  JsonObject,
  ApiResponseGachaLogPage,
  GachaLogPage,
  GachaItem,
} from "./models/uigf/index.js";
export type { GameGlobalRecordsClientOptionalParams } from "./api/index.js";
export type {
  GameRecordApiGetStarRailChallengePeakOptionalParams,
  GameRecordApiGetStarRailDailyNoteOptionalParams,
  GameRecordApiGetStarRailIndexOptionalParams,
  GameRecordApiGetGenshinDailyNoteOptionalParams,
  GameRecordApiGetGenshinIndexOptionalParams,
} from "./api/gameRecordApi/index.js";
export type {
  StarRailLedgerApiGetMonthDetailOptionalParams,
  StarRailLedgerApiGetMonthInfoOptionalParams,
} from "./api/starRailLedgerApi/index.js";
export type {
  ZenlessCultivationApiGetIconInfoOptionalParams,
  ZenlessCultivationApiGetItemsOptionalParams,
} from "./api/zenlessCultivationApi/index.js";
export type {
  ZenlessGameRecordApiGetThresholdSimulationDetailOptionalParams,
  ZenlessGameRecordApiGetThresholdSimulationSummaryOptionalParams,
  ZenlessGameRecordApiGetDeadlyAssaultOptionalParams,
  ZenlessGameRecordApiGetShiyuDefenseOptionalParams,
  ZenlessGameRecordApiGetGachaRecordOptionalParams,
  ZenlessGameRecordApiGetDailyNoteOptionalParams,
  ZenlessGameRecordApiGetIndexOptionalParams,
} from "./api/zenlessGameRecordApi/index.js";
export type {
  ZenlessLedgerApiGetMonthDetailOptionalParams,
  ZenlessLedgerApiGetMonthInfoOptionalParams,
} from "./api/zenlessLedgerApi/index.js";
export type {
  GameRecordApiOperations,
  StarRailLedgerApiOperations,
  ZenlessCultivationApiOperations,
  ZenlessGameRecordApiOperations,
  ZenlessLedgerApiOperations,
} from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
