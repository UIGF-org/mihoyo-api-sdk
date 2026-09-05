// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameAccountContext } from "../../api/gameAccountContext.js";
import { getBySToken } from "../../api/actionTicketApi/operations.js";
import { ActionTicketApiGetBySTokenOptionalParams } from "../../api/actionTicketApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a ActionTicketApi operations. */
export interface ActionTicketApiOperations {
  getBySToken: (
    cookie: string,
    ds: string,
    actionType: string,
    stoken: string,
    uid: string,
    options?: ActionTicketApiGetBySTokenOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getActionTicketApi(context: GameAccountContext) {
  return {
    getBySToken: (
      cookie: string,
      ds: string,
      actionType: string,
      stoken: string,
      uid: string,
      options?: ActionTicketApiGetBySTokenOptionalParams,
    ) => getBySToken(context, cookie, ds, actionType, stoken, uid, options),
  };
}

export function _getActionTicketApiOperations(
  context: GameAccountContext,
): ActionTicketApiOperations {
  return {
    ..._getActionTicketApi(context),
  };
}
