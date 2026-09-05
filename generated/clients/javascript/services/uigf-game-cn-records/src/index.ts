// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameCNRecordsClient } from "./gameCNRecordsClient.js";
export type {
  ApiResponseJsonObject,
  JsonObject,
  ApiResponseGachaLogPage,
  GachaLogPage,
  GachaItem,
} from "./models/uigf/index.js";
export type { GameCNRecordsClientOptionalParams } from "./api/index.js";
export type { HonkaiImpactApiGetIndexOptionalParams } from "./api/honkaiImpactApi/index.js";
export type {
  StarRailApiGetChallengePeakOptionalParams,
  StarRailApiGetSimulatedUniverseOptionalParams,
  StarRailApiGetApocalypticShadowOptionalParams,
  StarRailApiGetPureFictionOptionalParams,
  StarRailApiGetForgottenHallOptionalParams,
  StarRailApiGetDailyNoteOptionalParams,
  StarRailApiGetIndexOptionalParams,
} from "./api/starRailApi/index.js";
export type {
  ZenlessApiGetThresholdSimulationDetailOptionalParams,
  ZenlessApiGetThresholdSimulationSummaryOptionalParams,
  ZenlessApiGetDeadlyAssaultOptionalParams,
  ZenlessApiGetShiyuDefenseOptionalParams,
  ZenlessApiGetGachaRecordOptionalParams,
  ZenlessApiGetDailyNoteOptionalParams,
  ZenlessApiGetIndexOptionalParams,
} from "./api/zenlessApi/index.js";
export type {
  HonkaiImpactApiOperations,
  StarRailApiOperations,
  ZenlessApiOperations,
} from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
