// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalAccountContext } from "../../api/gameGlobalAccountContext.js";
import { getRoles } from "../../api/bindingApi/operations.js";
import { BindingApiGetRolesOptionalParams } from "../../api/bindingApi/options.js";
import { ApiResponseGameRoleList } from "../../models/uigf/models.js";

/** Interface representing a BindingApi operations. */
export interface BindingApiOperations {
  getRoles: (
    cookie: string,
    gameBiz: string,
    options?: BindingApiGetRolesOptionalParams,
  ) => Promise<ApiResponseGameRoleList>;
}

function _getBindingApi(context: GameGlobalAccountContext) {
  return {
    getRoles: (cookie: string, gameBiz: string, options?: BindingApiGetRolesOptionalParams) =>
      getRoles(context, cookie, gameBiz, options),
  };
}

export function _getBindingApiOperations(context: GameGlobalAccountContext): BindingApiOperations {
  return {
    ..._getBindingApi(context),
  };
}
