// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext } from "../../api/passportContext.js";
import { exchange, getTokenByGameToken } from "../../api/sessionApi/operations.js";
import {
  SessionApiExchangeOptionalParams,
  SessionApiGetTokenByGameTokenOptionalParams,
} from "../../api/sessionApi/options.js";
import { ApiResponseTokenInfo } from "../../models/uigf/models.js";
import { GameTokenRequest, TokenExchangeRequest } from "../../models/uigf/passport/models.js";

/** Interface representing a SessionApi operations. */
export interface SessionApiOperations {
  /** Exchanges a source token for the requested destination token type. */
  exchange: (
    body: TokenExchangeRequest,
    options?: SessionApiExchangeOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
  /** Exchanges a game token for an SToken/session payload. */
  getTokenByGameToken: (
    body: GameTokenRequest,
    options?: SessionApiGetTokenByGameTokenOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
}

function _getSessionApi(context: PassportContext) {
  return {
    exchange: (body: TokenExchangeRequest, options?: SessionApiExchangeOptionalParams) =>
      exchange(context, body, options),
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
