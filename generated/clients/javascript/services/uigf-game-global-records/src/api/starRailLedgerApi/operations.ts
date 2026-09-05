// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalRecordsContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  StarRailLedgerApiGetMonthDetailOptionalParams,
  StarRailLedgerApiGetMonthInfoOptionalParams,
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
  options: StarRailLedgerApiGetMonthDetailOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/srledger/month_detail{?type,current_page,page_size,month,lang,role_id,server}",
    {
      type: typeParam,
      current_page: currentPage,
      page_size: options?.pageSize,
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
  options: StarRailLedgerApiGetMonthDetailOptionalParams = { requestOptions: {} },
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
  options: StarRailLedgerApiGetMonthInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/srledger/month_info{?month,lang,role_id,server}",
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
  options: StarRailLedgerApiGetMonthInfoOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getMonthInfoSend(context, cookie, roleId, server, options);
  return _getMonthInfoDeserialize(result);
}
