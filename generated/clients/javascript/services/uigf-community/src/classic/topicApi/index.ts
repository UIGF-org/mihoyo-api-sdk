// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext } from "../../api/communityContext.js";
import { getFullInfo } from "../../api/topicApi/operations.js";
import { TopicApiGetFullInfoOptionalParams } from "../../api/topicApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a TopicApi operations. */
export interface TopicApiOperations {
  getFullInfo: (
    gids: string,
    id: string,
    options?: TopicApiGetFullInfoOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getTopicApi(context: CommunityContext) {
  return {
    getFullInfo: (gids: string, id: string, options?: TopicApiGetFullInfoOptionalParams) =>
      getFullInfo(context, gids, id, options),
  };
}

export function _getTopicApiOperations(context: CommunityContext): TopicApiOperations {
  return {
    ..._getTopicApi(context),
  };
}
