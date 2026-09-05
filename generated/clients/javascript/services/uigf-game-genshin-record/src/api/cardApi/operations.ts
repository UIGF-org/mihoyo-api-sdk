// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinRecordContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { CardApiGetGameRecordCardOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getGameRecordCardSend(
  context: Client,
  cookie: string,
  ds: string,
  uid: string,
  options: CardApiGetGameRecordCardOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/card/wapi/getGameRecordCard{?uid}",
    {
      uid: uid,
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

export async function _getGameRecordCardDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getGameRecordCard(
  context: Client,
  cookie: string,
  ds: string,
  uid: string,
  options: CardApiGetGameRecordCardOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getGameRecordCardSend(context, cookie, ds, uid, options);
  return _getGameRecordCardDeserialize(result);
}
