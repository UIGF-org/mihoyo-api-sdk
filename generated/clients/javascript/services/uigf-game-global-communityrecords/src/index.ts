// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGlobalCommunityRecordsClient } from "./gameGlobalCommunityRecordsClient.js";
export type {
  ApiResponseCommunityUser,
  CommunityUser,
  JsonObject,
  ApiResponseJsonObject,
} from "./models/uigf/index.js";
export type { GameGlobalCommunityRecordsClientOptionalParams } from "./api/index.js";
export type {
  GenshinChallengeApiGetStygianOnslaughtOptionalParams,
  GenshinChallengeApiGetImaginariumTheaterOptionalParams,
  GenshinChallengeApiGetSpiralAbyssOptionalParams,
} from "./api/genshinChallengeApi/index.js";
export type {
  HonkaiImpactApiGetDailyNoteOptionalParams,
  HonkaiImpactApiGetIndexOptionalParams,
} from "./api/honkaiImpactApi/index.js";
export type {
  StarRailChallengeApiGetSimulatedUniverseOptionalParams,
  StarRailChallengeApiGetApocalypticShadowOptionalParams,
  StarRailChallengeApiGetPureFictionOptionalParams,
  StarRailChallengeApiGetForgottenHallOptionalParams,
} from "./api/starRailChallengeApi/index.js";
export type { UserApiGetFullInfoOptionalParams } from "./api/userApi/index.js";
export type {
  GenshinChallengeApiOperations,
  HonkaiImpactApiOperations,
  StarRailChallengeApiOperations,
  UserApiOperations,
} from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
