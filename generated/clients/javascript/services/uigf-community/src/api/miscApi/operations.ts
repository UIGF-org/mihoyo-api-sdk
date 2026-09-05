// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext as Client } from "../index.js";
import {
  VerificationCreateRequest,
  verificationCreateRequestSerializer,
  VerificationSubmitRequest,
  verificationSubmitRequestSerializer,
} from "../../models/uigf/community/models.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  MiscApiGetGeetestChallengeOptionalParams,
  MiscApiVerifyVerificationOptionalParams,
  MiscApiCreateVerificationOptionalParams,
  MiscApiGetEmoticonSetOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getGeetestChallengeSend(
  context: Client,
  cookie: string,
  options: MiscApiGetGeetestChallengeOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/misc/api/getGeetestChallenge{?action_type}",
    {
      action_type: options?.actionType,
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

export async function _getGeetestChallengeDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getGeetestChallenge(
  context: Client,
  cookie: string,
  options: MiscApiGetGeetestChallengeOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getGeetestChallengeSend(context, cookie, options);
  return _getGeetestChallengeDeserialize(result);
}

export function _verifyVerificationSend(
  context: Client,
  cookie: string,
  body: VerificationSubmitRequest,
  options: MiscApiVerifyVerificationOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/misc/api/verifyVerification")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
      body: verificationSubmitRequestSerializer(body),
    });
}

export async function _verifyVerificationDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

/** Submits verification output obtained from the official challenge provider. */
export async function verifyVerification(
  context: Client,
  cookie: string,
  body: VerificationSubmitRequest,
  options: MiscApiVerifyVerificationOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _verifyVerificationSend(context, cookie, body, options);
  return _verifyVerificationDeserialize(result);
}

export function _createVerificationSend(
  context: Client,
  cookie: string,
  body: VerificationCreateRequest,
  options: MiscApiCreateVerificationOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/misc/api/createVerification")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { cookie: cookie, accept: "application/json", ...options.requestOptions?.headers },
      body: verificationCreateRequestSerializer(body),
    });
}

export async function _createVerificationDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

/** Creates the official verification challenge required by selected operations. */
export async function createVerification(
  context: Client,
  cookie: string,
  body: VerificationCreateRequest,
  options: MiscApiCreateVerificationOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _createVerificationSend(context, cookie, body, options);
  return _createVerificationDeserialize(result);
}

export function _getEmoticonSetSend(
  context: Client,
  options: MiscApiGetEmoticonSetOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/misc/api/emoticon_set")
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getEmoticonSetDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getEmoticonSet(
  context: Client,
  options: MiscApiGetEmoticonSetOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getEmoticonSetSend(context, options);
  return _getEmoticonSetDeserialize(result);
}
