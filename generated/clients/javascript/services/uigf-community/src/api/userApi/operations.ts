// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext as Client } from "../index.js";
import {
  ApiResponseCommunityUser,
  apiResponseCommunityUserDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { UserApiGetFullInfoOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getFullInfoSend(
  context: Client,
  gids: string,
  options: UserApiGetFullInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/user/wapi/getUserFullInfo{?gids,uid}",
    {
      gids: gids,
      uid: options?.uid,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: {
        ...(options?.cookie !== undefined ? { cookie: options?.cookie } : {}),
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

/** Gets the authenticated or public MiYouShe user profile. */
export async function getFullInfo(
  context: Client,
  gids: string,
  options: UserApiGetFullInfoOptionalParams = { requestOptions: {} },
): Promise<ApiResponseCommunityUser> {
  const result = await _getFullInfoSend(context, gids, options);
  return _getFullInfoDeserialize(result);
}
