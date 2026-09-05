// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UtilityLiveStreamContext } from "../../api/utilityLiveStreamContext.js";
import { refresh } from "../../api/redemptionCodeApi/operations.js";
import { RedemptionCodeApiRefreshOptionalParams } from "../../api/redemptionCodeApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a RedemptionCodeApi operations. */
export interface RedemptionCodeApiOperations {
  refresh: (
    activityId: string,
    options?: RedemptionCodeApiRefreshOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getRedemptionCodeApi(context: UtilityLiveStreamContext) {
  return {
    refresh: (activityId: string, options?: RedemptionCodeApiRefreshOptionalParams) =>
      refresh(context, activityId, options),
  };
}

export function _getRedemptionCodeApiOperations(
  context: UtilityLiveStreamContext,
): RedemptionCodeApiOperations {
  return {
    ..._getRedemptionCodeApi(context),
  };
}
