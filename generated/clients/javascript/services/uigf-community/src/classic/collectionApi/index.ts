// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext } from "../../api/communityContext.js";
import { getDetail } from "../../api/collectionApi/operations.js";
import { CollectionApiGetDetailOptionalParams } from "../../api/collectionApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a CollectionApi operations. */
export interface CollectionApiOperations {
  getDetail: (
    gids: number,
    id: string,
    options?: CollectionApiGetDetailOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getCollectionApi(context: CommunityContext) {
  return {
    getDetail: (gids: number, id: string, options?: CollectionApiGetDetailOptionalParams) =>
      getDetail(context, gids, id, options),
  };
}

export function _getCollectionApiOperations(context: CommunityContext): CollectionApiOperations {
  return {
    ..._getCollectionApi(context),
  };
}
