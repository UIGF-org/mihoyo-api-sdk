// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalAccountContext as Client } from "../index.js";
import {
  ApiResponseGameRoleList,
  apiResponseGameRoleListDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { BindingApiGetRolesOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getRolesSend(
  context: Client,
  cookie: string,
  gameBiz: string,
  options: BindingApiGetRolesOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/binding/api/getUserGameRolesByCookieToken{?game_biz}",
    {
      game_biz: gameBiz,
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

export async function _getRolesDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseGameRoleList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseGameRoleListDeserializer(result.body);
}

export async function getRoles(
  context: Client,
  cookie: string,
  gameBiz: string,
  options: BindingApiGetRolesOptionalParams = { requestOptions: {} },
): Promise<ApiResponseGameRoleList> {
  const result = await _getRolesSend(context, cookie, gameBiz, options);
  return _getRolesDeserialize(result);
}
