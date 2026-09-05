// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalGenshinContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  LedgerApiGetMonthDetailOptionalParams,
  LedgerApiGetMonthInfoOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getMonthDetailSend(
  context: Client,
  cookie: string,
  typeParam: number,
  currentPage: number,
  roleId: string,
  server: string,
  options: LedgerApiGetMonthDetailOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/ysledgeros/month_detail{?type,current_page,month,lang,role_id,server}",
    {
      type: typeParam,
      current_page: currentPage,
      month: options?.month,
      lang: options?.lang,
      role_id: roleId,
      server: server,
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

export async function _getMonthDetailDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getMonthDetail(
  context: Client,
  cookie: string,
  typeParam: number,
  currentPage: number,
  roleId: string,
  server: string,
  options: LedgerApiGetMonthDetailOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getMonthDetailSend(
    context,
    cookie,
    typeParam,
    currentPage,
    roleId,
    server,
    options,
  );
  return _getMonthDetailDeserialize(result);
}

export function _getMonthInfoSend(
  context: Client,
  cookie: string,
  roleId: string,
  server: string,
  options: LedgerApiGetMonthInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/ysledgeros/month_info{?month,lang,role_id,server}",
    {
      month: options?.month,
      lang: options?.lang,
      role_id: roleId,
      server: server,
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

export async function _getMonthInfoDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getMonthInfo(
  context: Client,
  cookie: string,
  roleId: string,
  server: string,
  options: LedgerApiGetMonthInfoOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getMonthInfoSend(context, cookie, roleId, server, options);
  return _getMonthInfoDeserialize(result);
}
