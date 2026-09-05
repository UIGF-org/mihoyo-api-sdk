// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGenshinRecordClient } from "./gameGenshinRecordClient.js";
export type {
  ApiResponseJsonObject,
  JsonObject,
  ApiResponseCharacterList,
} from "./models/uigf/index.js";
export type {
  CharacterListRequest,
  CharacterList,
  Character,
  CharacterDetailRequest,
} from "./models/uigf/game/index.js";
export type { GameGenshinRecordClientOptionalParams } from "./api/index.js";
export type { CardApiGetGameRecordCardOptionalParams } from "./api/cardApi/index.js";
export type {
  GameRecordApiGetCharacterTpsOptionalParams,
  GameRecordApiGetActivityCalendarOptionalParams,
  GameRecordApiGetStygianPopularityOptionalParams,
  GameRecordApiGetStygianOnslaughtOptionalParams,
  GameRecordApiGetCharacterMasterOptionalParams,
  GameRecordApiGetImaginariumTheaterOptionalParams,
  GameRecordApiGetSpiralAbyssOptionalParams,
  GameRecordApiGetDailyNoteOptionalParams,
  GameRecordApiGetCharacterDetailsOptionalParams,
  GameRecordApiListCharactersOptionalParams,
  GameRecordApiGetIndexOptionalParams,
} from "./api/gameRecordApi/index.js";
export type { CardApiOperations, GameRecordApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
