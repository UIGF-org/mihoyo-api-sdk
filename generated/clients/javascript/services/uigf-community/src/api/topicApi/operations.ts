// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { TopicApiGetFullInfoOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getFullInfoSend(
  context: Client,
  gids: string,
  id: string,
  options: TopicApiGetFullInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/topic/wapi/getTopicFullInfo{?gids,id}",
    {
      gids: gids,
      id: id,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getFullInfoDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getFullInfo(
  context: Client,
  gids: string,
  id: string,
  options: TopicApiGetFullInfoOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getFullInfoSend(context, gids, id, options);
  return _getFullInfoDeserialize(result);
}
