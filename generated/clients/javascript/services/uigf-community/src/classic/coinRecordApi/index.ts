// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext } from "../../api/communityContext.js";
import { list } from "../../api/coinRecordApi/operations.js";
import { CoinRecordApiListOptionalParams } from "../../api/coinRecordApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a CoinRecordApi operations. */
export interface CoinRecordApiOperations {
  /** Returns MiYouShe coin earnings or spending records. */
  list: (
    cookie: string,
    ds: string,
    appId: string,
    pointSn: string,
    time: string,
    action: "1" | "2",
    size: number,
    options?: CoinRecordApiListOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getCoinRecordApi(context: CommunityContext) {
  return {
    list: (
      cookie: string,
      ds: string,
      appId: string,
      pointSn: string,
      time: string,
      action: "1" | "2",
      size: number,
      options?: CoinRecordApiListOptionalParams,
    ) => list(context, cookie, ds, appId, pointSn, time, action, size, options),
  };
}

export function _getCoinRecordApiOperations(context: CommunityContext): CoinRecordApiOperations {
  return {
    ..._getCoinRecordApi(context),
  };
}
