// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameAccountContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { ActionTicketApiGetBySTokenOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getBySTokenSend(
  context: Client,
  cookie: string,
  ds: string,
  actionType: string,
  stoken: string,
  uid: string,
  options: ActionTicketApiGetBySTokenOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/auth/api/getActionTicketBySToken{?action_type,stoken,uid}",
    {
      action_type: actionType,
      stoken: stoken,
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

export async function _getBySTokenDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getBySToken(
  context: Client,
  cookie: string,
  ds: string,
  actionType: string,
  stoken: string,
  uid: string,
  options: ActionTicketApiGetBySTokenOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getBySTokenSend(context, cookie, ds, actionType, stoken, uid, options);
  return _getBySTokenDeserialize(result);
}
