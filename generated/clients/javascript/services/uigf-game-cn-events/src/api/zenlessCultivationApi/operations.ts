// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameCNEventsContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  ZenlessCultivationApiGetIconInfoOptionalParams,
  ZenlessCultivationApiGetItemsOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getIconInfoSend(
  context: Client,
  cookie: string,
  uid: string,
  region: string,
  options: ZenlessCultivationApiGetIconInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/nap_cultivate_tool/user/icon_info{?uid,region}",
    {
      uid: uid,
      region: region,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getIconInfoDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getIconInfo(
  context: Client,
  cookie: string,
  uid: string,
  region: string,
  options: ZenlessCultivationApiGetIconInfoOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getIconInfoSend(context, cookie, uid, region, options);
  return _getIconInfoDeserialize(result);
}

export function _getItemsSend(
  context: Client,
  cookie: string,
  uid: string,
  region: string,
  avatarId: number,
  options: ZenlessCultivationApiGetItemsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/nap_cultivate_tool/user/item_list{?uid,region,avatar_id}",
    {
      uid: uid,
      region: region,
      avatar_id: avatarId,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getItemsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getItems(
  context: Client,
  cookie: string,
  uid: string,
  region: string,
  avatarId: number,
  options: ZenlessCultivationApiGetItemsOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getItemsSend(context, cookie, uid, region, avatarId, options);
  return _getItemsDeserialize(result);
}
