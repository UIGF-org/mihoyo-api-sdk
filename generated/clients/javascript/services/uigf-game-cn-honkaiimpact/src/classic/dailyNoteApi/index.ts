// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameCNHonkaiImpactContext } from "../../api/gameCNHonkaiImpactContext.js";
import { getDailyNote } from "../../api/dailyNoteApi/operations.js";
import { DailyNoteApiGetDailyNoteOptionalParams } from "../../api/dailyNoteApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a DailyNoteApi operations. */
export interface DailyNoteApiOperations {
  getDailyNote: (
    cookie: string,
    server: string,
    roleId: string,
    options?: DailyNoteApiGetDailyNoteOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getDailyNoteApi(context: GameCNHonkaiImpactContext) {
  return {
    getDailyNote: (
      cookie: string,
      server: string,
      roleId: string,
      options?: DailyNoteApiGetDailyNoteOptionalParams,
    ) => getDailyNote(context, cookie, server, roleId, options),
  };
}

export function _getDailyNoteApiOperations(
  context: GameCNHonkaiImpactContext,
): DailyNoteApiOperations {
  return {
    ..._getDailyNoteApi(context),
  };
}
