// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalCommunityRecordsContext as Client } from "../index.js";
import {
  ApiResponseCommunityUser,
  apiResponseCommunityUserDeserializer,
} from "../../models/uigf/models.js";
import { UserApiGetFullInfoOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getFullInfoSend(
  context: Client,
  cookie: string,
  options: UserApiGetFullInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/community/user/wapi/getUserFullInfo")
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: {
        cookie: cookie,
        ...(options?.ds !== undefined ? { ds: options?.ds } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getFullInfoDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseCommunityUser> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseCommunityUserDeserializer(result.body);
}

export async function getFullInfo(
  context: Client,
  cookie: string,
  options: UserApiGetFullInfoOptionalParams = { requestOptions: {} },
): Promise<ApiResponseCommunityUser> {
  const result = await _getFullInfoSend(context, cookie, options);
  return _getFullInfoDeserialize(result);
}
