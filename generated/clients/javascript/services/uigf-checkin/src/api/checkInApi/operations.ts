// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CheckInContext as Client } from "../index.js";
import {
  LunaCheckInRequest,
  lunaCheckInRequestSerializer,
} from "../../models/uigf/community/models.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  CheckInApiResignOptionalParams,
  CheckInApiGetResignInfoOptionalParams,
  CheckInApiSignOptionalParams,
  CheckInApiGetInfoOptionalParams,
  CheckInApiGetHomeOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _resignSend(
  context: Client,
  game: string,
  cookie: string,
  body: LunaCheckInRequest,
  options: CheckInApiResignOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/luna/{game}/resign",
    {
      game: game,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ...(options?.signGame !== undefined ? { "x-rpc-signgame": options?.signGame } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: lunaCheckInRequestSerializer(body),
    });
}

export async function _resignDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function resign(
  context: Client,
  game: string,
  cookie: string,
  body: LunaCheckInRequest,
  options: CheckInApiResignOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _resignSend(context, game, cookie, body, options);
  return _resignDeserialize(result);
}

export function _getResignInfoSend(
  context: Client,
  game: string,
  cookie: string,
  lang: string,
  actId: string,
  options: CheckInApiGetResignInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/luna/{game}/resign_info{?lang,act_id}",
    {
      game: game,
      lang: lang,
      act_id: actId,
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
        ...(options?.signGame !== undefined ? { "x-rpc-signgame": options?.signGame } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getResignInfoDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getResignInfo(
  context: Client,
  game: string,
  cookie: string,
  lang: string,
  actId: string,
  options: CheckInApiGetResignInfoOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getResignInfoSend(context, game, cookie, lang, actId, options);
  return _getResignInfoDeserialize(result);
}

export function _signSend(
  context: Client,
  game: string,
  cookie: string,
  body: LunaCheckInRequest,
  options: CheckInApiSignOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/luna/{game}/sign",
    {
      game: game,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ...(options?.signGame !== undefined ? { "x-rpc-signgame": options?.signGame } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: lunaCheckInRequestSerializer(body),
    });
}

export async function _signDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function sign(
  context: Client,
  game: string,
  cookie: string,
  body: LunaCheckInRequest,
  options: CheckInApiSignOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _signSend(context, game, cookie, body, options);
  return _signDeserialize(result);
}

export function _getInfoSend(
  context: Client,
  game: string,
  cookie: string,
  lang: string,
  actId: string,
  options: CheckInApiGetInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/luna/{game}/info{?lang,act_id}",
    {
      game: game,
      lang: lang,
      act_id: actId,
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
        ...(options?.signGame !== undefined ? { "x-rpc-signgame": options?.signGame } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getInfoDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getInfo(
  context: Client,
  game: string,
  cookie: string,
  lang: string,
  actId: string,
  options: CheckInApiGetInfoOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getInfoSend(context, game, cookie, lang, actId, options);
  return _getInfoDeserialize(result);
}

export function _getHomeSend(
  context: Client,
  game: string,
  cookie: string,
  lang: string,
  actId: string,
  options: CheckInApiGetHomeOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/event/luna/{game}/home{?lang,act_id}",
    {
      game: game,
      lang: lang,
      act_id: actId,
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
        ...(options?.signGame !== undefined ? { "x-rpc-signgame": options?.signGame } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getHomeDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getHome(
  context: Client,
  game: string,
  cookie: string,
  lang: string,
  actId: string,
  options: CheckInApiGetHomeOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getHomeSend(context, game, cookie, lang, actId, options);
  return _getHomeDeserialize(result);
}
