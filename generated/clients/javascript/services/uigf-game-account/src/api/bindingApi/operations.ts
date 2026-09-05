// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameAccountContext as Client } from "../index.js";
import { AuthKeyRequest, authKeyRequestSerializer } from "../../models/uigf/game/models.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
  ApiResponseGameRoleList,
  apiResponseGameRoleListDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  BindingApiGetRolesOptionalParams,
  BindingApiGenerateAuthKeyOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getRolesSend(
  context: Client,
  cookie: string,
  options: BindingApiGetRolesOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/binding/api/getUserGameRolesByCookie{?game_biz}",
    {
      game_biz: options?.gameBiz,
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

export async function _getRolesDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseGameRoleList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseGameRoleListDeserializer(result.body);
}

/** Lists game roles that are bound to the authenticated community account. */
export async function getRoles(
  context: Client,
  cookie: string,
  options: BindingApiGetRolesOptionalParams = { requestOptions: {} },
): Promise<ApiResponseGameRoleList> {
  const result = await _getRolesSend(context, cookie, options);
  return _getRolesDeserialize(result);
}

export function _generateAuthKeySend(
  context: Client,
  cookie: string,
  ds: string,
  body: AuthKeyRequest,
  options: BindingApiGenerateAuthKeyOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/binding/api/genAuthKey")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: authKeyRequestSerializer(body),
    });
}

export async function _generateAuthKeyDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

/** Generates an authenticated gacha authkey for a selected game role. */
export async function generateAuthKey(
  context: Client,
  cookie: string,
  ds: string,
  body: AuthKeyRequest,
  options: BindingApiGenerateAuthKeyOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _generateAuthKeySend(context, cookie, ds, body, options);
  return _generateAuthKeyDeserialize(result);
}
