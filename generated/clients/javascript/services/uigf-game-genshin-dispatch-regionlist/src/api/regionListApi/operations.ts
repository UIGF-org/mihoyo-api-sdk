// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinDispatchRegionListContext as Client } from "../index.js";
import { RegionListApiQueryResponse } from "../../models/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { RegionListApiQueryOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _querySend(
  context: Client,
  options: RegionListApiQueryOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/query_region_list{?binary,channel_id,lang,platform,sub_channel_id,time,version}",
    {
      binary: options?.binary,
      channel_id: options?.channelId,
      lang: options?.lang,
      platform: options?.platform,
      sub_channel_id: options?.subChannelId,
      time: options?.time,
      version: options?.version,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/octet-stream", ...options.requestOptions?.headers },
    });
}

export async function _queryDeserialize(
  result: PathUncheckedResponse & RegionListApiQueryResponse,
): Promise<RegionListApiQueryResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return { blobBody: result.blobBody, readableStreamBody: result.readableStreamBody };
}

export async function query(
  context: Client,
  options: RegionListApiQueryOptionalParams = { requestOptions: {} },
): Promise<RegionListApiQueryResponse> {
  const result = await _querySend(context, options);
  return _queryDeserialize(result);
}
