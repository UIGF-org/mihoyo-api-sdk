// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinRecordContext } from "../../api/gameGenshinRecordContext.js";
import { getGameRecordCard } from "../../api/cardApi/operations.js";
import { CardApiGetGameRecordCardOptionalParams } from "../../api/cardApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a CardApi operations. */
export interface CardApiOperations {
  getGameRecordCard: (
    cookie: string,
    ds: string,
    uid: string,
    options?: CardApiGetGameRecordCardOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getCardApi(context: GameGenshinRecordContext) {
  return {
    getGameRecordCard: (
      cookie: string,
      ds: string,
      uid: string,
      options?: CardApiGetGameRecordCardOptionalParams,
    ) => getGameRecordCard(context, cookie, ds, uid, options),
  };
}

export function _getCardApiOperations(context: GameGenshinRecordContext): CardApiOperations {
  return {
    ..._getCardApi(context),
  };
}
