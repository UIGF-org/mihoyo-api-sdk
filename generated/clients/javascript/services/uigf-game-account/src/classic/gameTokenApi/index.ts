// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameAccountContext } from "../../api/gameAccountContext.js";
import { exchangeGameToken } from "../../api/gameTokenApi/operations.js";
import { GameTokenApiExchangeGameTokenOptionalParams } from "../../api/gameTokenApi/options.js";
import { ApiResponseTokenInfo } from "../../models/uigf/models.js";
import { GameTokenRequest } from "../../models/uigf/passport/models.js";

/** Interface representing a GameTokenApi operations. */
export interface GameTokenApiOperations {
  /** Exchanges the official game-token QR-login result for a session token. */
  exchangeGameToken: (
    body: GameTokenRequest,
    options?: GameTokenApiExchangeGameTokenOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
}

function _getGameTokenApi(context: GameAccountContext) {
  return {
    exchangeGameToken: (
      body: GameTokenRequest,
      options?: GameTokenApiExchangeGameTokenOptionalParams,
    ) => exchangeGameToken(context, body, options),
  };
}

export function _getGameTokenApiOperations(context: GameAccountContext): GameTokenApiOperations {
  return {
    ..._getGameTokenApi(context),
  };
}
