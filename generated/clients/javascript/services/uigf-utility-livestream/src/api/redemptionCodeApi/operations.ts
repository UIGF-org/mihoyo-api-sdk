// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UtilityLiveStreamContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { RedemptionCodeApiRefreshOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _refreshSend(
  context: Client,
  activityId: string,
  options: RedemptionCodeApiRefreshOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/event/miyolive/refreshCode")
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: {
        "x-rpc-act_id": activityId,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _refreshDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function refresh(
  context: Client,
  activityId: string,
  options: RedemptionCodeApiRefreshOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _refreshSend(context, activityId, options);
  return _refreshDeserialize(result);
}
