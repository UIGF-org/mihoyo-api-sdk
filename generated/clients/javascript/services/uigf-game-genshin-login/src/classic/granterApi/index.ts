// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinLoginContext } from "../../api/gameGenshinLoginContext.js";
import { login } from "../../api/granterApi/operations.js";
import { GranterApiLoginOptionalParams } from "../../api/granterApi/options.js";
import { GranterLoginRequest } from "../../models/uigf/game/genshin/sdk/models.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a GranterApi operations. */
export interface GranterApiOperations {
  /** Submits the caller-provided official granter login payload. */
  login: (
    body: GranterLoginRequest,
    options?: GranterApiLoginOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getGranterApi(context: GameGenshinLoginContext) {
  return {
    login: (body: GranterLoginRequest, options?: GranterApiLoginOptionalParams) =>
      login(context, body, options),
  };
}

export function _getGranterApiOperations(context: GameGenshinLoginContext): GranterApiOperations {
  return {
    ..._getGranterApi(context),
  };
}
