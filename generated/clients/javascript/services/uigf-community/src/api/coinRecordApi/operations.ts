// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { CoinRecordApiListOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _listSend(
  context: Client,
  cookie: string,
  ds: string,
  appId: string,
  pointSn: string,
  time: string,
  action: "1" | "2",
  size: number,
  options: CoinRecordApiListOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/common/homutreasure/v1/web/user/record{?app_id,point_sn,time,action,size}",
    {
      app_id: appId,
      point_sn: pointSn,
      time: time,
      action: action,
      size: size,
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
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _listDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

/** Returns MiYouShe coin earnings or spending records. */
export async function list(
  context: Client,
  cookie: string,
  ds: string,
  appId: string,
  pointSn: string,
  time: string,
  action: "1" | "2",
  size: number,
  options: CoinRecordApiListOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _listSend(context, cookie, ds, appId, pointSn, time, action, size, options);
  return _listDeserialize(result);
}
