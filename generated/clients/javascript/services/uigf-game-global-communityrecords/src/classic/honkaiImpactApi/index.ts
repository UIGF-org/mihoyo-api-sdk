// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalCommunityRecordsContext } from "../../api/gameGlobalCommunityRecordsContext.js";
import { getDailyNote, getIndex } from "../../api/honkaiImpactApi/operations.js";
import {
  HonkaiImpactApiGetDailyNoteOptionalParams,
  HonkaiImpactApiGetIndexOptionalParams,
} from "../../api/honkaiImpactApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a HonkaiImpactApi operations. */
export interface HonkaiImpactApiOperations {
  getDailyNote: (
    cookie: string,
    server: string,
    roleId: string,
    options?: HonkaiImpactApiGetDailyNoteOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getIndex: (
    cookie: string,
    server: string,
    roleId: string,
    options?: HonkaiImpactApiGetIndexOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getHonkaiImpactApi(context: GameGlobalCommunityRecordsContext) {
  return {
    getDailyNote: (
      cookie: string,
      server: string,
      roleId: string,
      options?: HonkaiImpactApiGetDailyNoteOptionalParams,
    ) => getDailyNote(context, cookie, server, roleId, options),
    getIndex: (
      cookie: string,
      server: string,
      roleId: string,
      options?: HonkaiImpactApiGetIndexOptionalParams,
    ) => getIndex(context, cookie, server, roleId, options),
  };
}

export function _getHonkaiImpactApiOperations(
  context: GameGlobalCommunityRecordsContext,
): HonkaiImpactApiOperations {
  return {
    ..._getHonkaiImpactApi(context),
  };
}
