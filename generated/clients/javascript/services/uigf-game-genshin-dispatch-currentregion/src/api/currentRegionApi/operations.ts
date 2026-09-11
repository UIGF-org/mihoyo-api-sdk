// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinDispatchCurrentRegionContext as Client } from "../index.js";
import {
  SignedDispatchResponse,
  signedDispatchResponseDeserializer,
} from "../../models/uigf/game/genshin/dispatch/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { CurrentRegionApiQueryOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _querySend(
  context: Client,
  options: CurrentRegionApiQueryOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/query_cur_region{?account_type,aid,binary,channel_id,dispatchSeed,key_id,lang,platform,sub_channel_id,time,version}",
    {
      account_type: options?.accountType,
      aid: options?.aid,
      binary: options?.binary,
      channel_id: options?.channelId,
      dispatchSeed: options?.dispatchSeed,
      key_id: options?.keyId,
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
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _queryDeserialize(
  result: PathUncheckedResponse,
): Promise<SignedDispatchResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return signedDispatchResponseDeserializer(result.body);
}

export async function query(
  context: Client,
  options: CurrentRegionApiQueryOptionalParams = { requestOptions: {} },
): Promise<SignedDispatchResponse> {
  const result = await _querySend(context, options);
  return _queryDeserialize(result);
}
