// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext } from "../../api/communityContext.js";
import { getFullInfo } from "../../api/userApi/operations.js";
import { UserApiGetFullInfoOptionalParams } from "../../api/userApi/options.js";
import { ApiResponseCommunityUser } from "../../models/uigf/models.js";

/** Interface representing a UserApi operations. */
export interface UserApiOperations {
  /** Gets the authenticated or public MiYouShe user profile. */
  getFullInfo: (
    gids: string,
    options?: UserApiGetFullInfoOptionalParams,
  ) => Promise<ApiResponseCommunityUser>;
}

function _getUserApi(context: CommunityContext) {
  return {
    getFullInfo: (gids: string, options?: UserApiGetFullInfoOptionalParams) =>
      getFullInfo(context, gids, options),
  };
}

export function _getUserApiOperations(context: CommunityContext): UserApiOperations {
  return {
    ..._getUserApi(context),
  };
}
