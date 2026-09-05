// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinLedgerContext as Client } from "../index.js";
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
  ds: string,
  month: number,
  page: number,
  typeParam: number,
  bindUid: string,
  bindRegion: string,
  options: LedgerApiGetMonthDetailOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/ys_ledger/monthDetail{?month,page,type,limit,bind_uid,bind_region}",
    {
      month: month,
      page: page,
      type: typeParam,
      limit: options?.limit,
      bind_uid: bindUid,
      bind_region: bindRegion,
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
  ds: string,
  month: number,
  page: number,
  typeParam: number,
  bindUid: string,
  bindRegion: string,
  options: LedgerApiGetMonthDetailOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getMonthDetailSend(
    context,
    cookie,
    ds,
    month,
    page,
    typeParam,
    bindUid,
    bindRegion,
    options,
  );
  return _getMonthDetailDeserialize(result);
}

export function _getMonthInfoSend(
  context: Client,
  cookie: string,
  ds: string,
  bindUid: string,
  bindRegion: string,
  options: LedgerApiGetMonthInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/ys_ledger/monthInfo{?month,bind_uid,bind_region}",
    {
      month: options?.month,
      bind_uid: bindUid,
      bind_region: bindRegion,
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
  ds: string,
  bindUid: string,
  bindRegion: string,
  options: LedgerApiGetMonthInfoOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getMonthInfoSend(context, cookie, ds, bindUid, bindRegion, options);
  return _getMonthInfoDeserialize(result);
}
