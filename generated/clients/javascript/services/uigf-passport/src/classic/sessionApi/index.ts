// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext } from "../../api/passportContext.js";
import { getTokenByGameToken } from "../../api/sessionApi/operations.js";
import { SessionApiGetTokenByGameTokenOptionalParams } from "../../api/sessionApi/options.js";
import { ApiResponseTokenInfo } from "../../models/uigf/models.js";
import { GameTokenRequest } from "../../models/uigf/passport/models.js";

/** Interface representing a SessionApi operations. */
export interface SessionApiOperations {
  /** Exchanges a game token for an SToken/session payload. */
  getTokenByGameToken: (
    body: GameTokenRequest,
    options?: SessionApiGetTokenByGameTokenOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
}

function _getSessionApi(context: PassportContext) {
  return {
    getTokenByGameToken: (
      body: GameTokenRequest,
      options?: SessionApiGetTokenByGameTokenOptionalParams,
    ) => getTokenByGameToken(context, body, options),
  };
}

export function _getSessionApiOperations(context: PassportContext): SessionApiOperations {
  return {
    ..._getSessionApi(context),
  };
}
