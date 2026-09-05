// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinRecordContext } from "../../api/gameGenshinRecordContext.js";
import {
  getCharacterTps,
  getActivityCalendar,
  getStygianPopularity,
  getStygianOnslaught,
  getCharacterMaster,
  getImaginariumTheater,
  getSpiralAbyss,
  getDailyNote,
  getCharacterDetails,
  listCharacters,
  getIndex,
} from "../../api/gameRecordApi/operations.js";
import {
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
} from "../../api/gameRecordApi/options.js";
import { CharacterListRequest, CharacterDetailRequest } from "../../models/uigf/game/models.js";
import { ApiResponseJsonObject, ApiResponseCharacterList } from "../../models/uigf/models.js";

/** Interface representing a GameRecordApi operations. */
export interface GameRecordApiOperations {
  getCharacterTps: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetCharacterTpsOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getActivityCalendar: (
    cookie: string,
    ds: string,
    body: CharacterListRequest,
    options?: GameRecordApiGetActivityCalendarOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getStygianPopularity: (
    server: string,
    roleId: number,
    options?: GameRecordApiGetStygianPopularityOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getStygianOnslaught: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetStygianOnslaughtOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getCharacterMaster: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetCharacterMasterOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getImaginariumTheater: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetImaginariumTheaterOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getSpiralAbyss: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetSpiralAbyssOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getDailyNote: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetDailyNoteOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  /** Character IDs should be sent in batches of at most 40, as used by TeyvatGuide. */
  getCharacterDetails: (
    cookie: string,
    ds: string,
    body: CharacterDetailRequest,
    options?: GameRecordApiGetCharacterDetailsOptionalParams,
  ) => Promise<ApiResponseCharacterList>;
  listCharacters: (
    cookie: string,
    ds: string,
    body: CharacterListRequest,
    options?: GameRecordApiListCharactersOptionalParams,
  ) => Promise<ApiResponseCharacterList>;
  getIndex: (
    cookie: string,
    ds: string,
    server: string,
    roleId: string,
    options?: GameRecordApiGetIndexOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getGameRecordApi(context: GameGenshinRecordContext) {
  return {
    getCharacterTps: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetCharacterTpsOptionalParams,
    ) => getCharacterTps(context, cookie, ds, server, roleId, options),
    getActivityCalendar: (
      cookie: string,
      ds: string,
      body: CharacterListRequest,
      options?: GameRecordApiGetActivityCalendarOptionalParams,
    ) => getActivityCalendar(context, cookie, ds, body, options),
    getStygianPopularity: (
      server: string,
      roleId: number,
      options?: GameRecordApiGetStygianPopularityOptionalParams,
    ) => getStygianPopularity(context, server, roleId, options),
    getStygianOnslaught: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetStygianOnslaughtOptionalParams,
    ) => getStygianOnslaught(context, cookie, ds, server, roleId, options),
    getCharacterMaster: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetCharacterMasterOptionalParams,
    ) => getCharacterMaster(context, cookie, ds, server, roleId, options),
    getImaginariumTheater: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetImaginariumTheaterOptionalParams,
    ) => getImaginariumTheater(context, cookie, ds, server, roleId, options),
    getSpiralAbyss: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetSpiralAbyssOptionalParams,
    ) => getSpiralAbyss(context, cookie, ds, server, roleId, options),
    getDailyNote: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetDailyNoteOptionalParams,
    ) => getDailyNote(context, cookie, ds, server, roleId, options),
    getCharacterDetails: (
      cookie: string,
      ds: string,
      body: CharacterDetailRequest,
      options?: GameRecordApiGetCharacterDetailsOptionalParams,
    ) => getCharacterDetails(context, cookie, ds, body, options),
    listCharacters: (
      cookie: string,
      ds: string,
      body: CharacterListRequest,
      options?: GameRecordApiListCharactersOptionalParams,
    ) => listCharacters(context, cookie, ds, body, options),
    getIndex: (
      cookie: string,
      ds: string,
      server: string,
      roleId: string,
      options?: GameRecordApiGetIndexOptionalParams,
    ) => getIndex(context, cookie, ds, server, roleId, options),
  };
}

export function _getGameRecordApiOperations(
  context: GameGenshinRecordContext,
): GameRecordApiOperations {
  return {
    ..._getGameRecordApi(context),
  };
}
