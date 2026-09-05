// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalCommunityRecordsContext } from "../../api/gameGlobalCommunityRecordsContext.js";
import { getFullInfo } from "../../api/userApi/operations.js";
import { UserApiGetFullInfoOptionalParams } from "../../api/userApi/options.js";
import { ApiResponseCommunityUser } from "../../models/uigf/models.js";

/** Interface representing a UserApi operations. */
export interface UserApiOperations {
  getFullInfo: (
    cookie: string,
    options?: UserApiGetFullInfoOptionalParams,
  ) => Promise<ApiResponseCommunityUser>;
}

function _getUserApi(context: GameGlobalCommunityRecordsContext) {
  return {
    getFullInfo: (cookie: string, options?: UserApiGetFullInfoOptionalParams) =>
      getFullInfo(context, cookie, options),
  };
}

export function _getUserApiOperations(
  context: GameGlobalCommunityRecordsContext,
): UserApiOperations {
  return {
    ..._getUserApi(context),
  };
}
