// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameCNRecordsContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { HonkaiImpactApiGetIndexOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getIndexSend(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: HonkaiImpactApiGetIndexOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/game_record/app/honkai3rd/api/index{?server,role_id}",
    {
      server: server,
      role_id: roleId,
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
        ...(options?.ds !== undefined ? { ds: options?.ds } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getIndexDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getIndex(
  context: Client,
  cookie: string,
  server: string,
  roleId: string,
  options: HonkaiImpactApiGetIndexOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getIndexSend(context, cookie, server, roleId, options);
  return _getIndexDeserialize(result);
}
