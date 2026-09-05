// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameCNRecordsContext } from "../../api/gameCNRecordsContext.js";
import { getIndex } from "../../api/honkaiImpactApi/operations.js";
import { HonkaiImpactApiGetIndexOptionalParams } from "../../api/honkaiImpactApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a HonkaiImpactApi operations. */
export interface HonkaiImpactApiOperations {
  getIndex: (
    cookie: string,
    server: string,
    roleId: string,
    options?: HonkaiImpactApiGetIndexOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getHonkaiImpactApi(context: GameCNRecordsContext) {
  return {
    getIndex: (
      cookie: string,
      server: string,
      roleId: string,
      options?: HonkaiImpactApiGetIndexOptionalParams,
    ) => getIndex(context, cookie, server, roleId, options),
  };
}

export function _getHonkaiImpactApiOperations(
  context: GameCNRecordsContext,
): HonkaiImpactApiOperations {
  return {
    ..._getHonkaiImpactApi(context),
  };
}
