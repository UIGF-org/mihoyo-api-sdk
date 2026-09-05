// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext } from "../../api/passportContext.js";
import { createByGameBiz } from "../../api/authTicketApi/operations.js";
import { AuthTicketApiCreateByGameBizOptionalParams } from "../../api/authTicketApi/options.js";
import { ApiResponseTokenInfo } from "../../models/uigf/models.js";
import { AuthTicketRequest } from "../../models/uigf/passport/models.js";

/** Interface representing a AuthTicketApi operations. */
export interface AuthTicketApiOperations {
  /** Creates an action ticket for a game-biz authentication flow. */
  createByGameBiz: (
    body: AuthTicketRequest,
    options?: AuthTicketApiCreateByGameBizOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
}

function _getAuthTicketApi(context: PassportContext) {
  return {
    createByGameBiz: (
      body: AuthTicketRequest,
      options?: AuthTicketApiCreateByGameBizOptionalParams,
    ) => createByGameBiz(context, body, options),
  };
}

export function _getAuthTicketApiOperations(context: PassportContext): AuthTicketApiOperations {
  return {
    ..._getAuthTicketApi(context),
  };
}
