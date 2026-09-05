// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext as Client } from "../index.js";
import {
  SignInRequest,
  signInRequestSerializer,
  LikePostRequest,
  likePostRequestSerializer,
} from "../../models/uigf/community/models.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
  ApiResponseForumList,
  apiResponseForumListDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  ApiHubSetPostVoteOptionalParams,
  ApiHubSignInOptionalParams,
  ApiHubGetHomeOptionalParams,
  ApiHubGetVoteResultsOptionalParams,
  ApiHubGetVotesOptionalParams,
  ApiHubGetMissionStateOptionalParams,
  ApiHubGetShareConfigOptionalParams,
  ApiHubGetMissionsOptionalParams,
  ApiHubGetGameListOptionalParams,
  ApiHubGetAppConfigOptionalParams,
  ApiHubGetAllGamesForumsOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _setPostVoteSend(
  context: Client,
  cookie: string,
  ds: string,
  body: LikePostRequest,
  options: ApiHubSetPostVoteOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/apihub/api/upvotePost")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: likePostRequestSerializer(body),
    });
}

export async function _setPostVoteDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function setPostVote(
  context: Client,
  cookie: string,
  ds: string,
  body: LikePostRequest,
  options: ApiHubSetPostVoteOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _setPostVoteSend(context, cookie, ds, body, options);
  return _setPostVoteDeserialize(result);
}

export function _signInSend(
  context: Client,
  cookie: string,
  ds: string,
  body: SignInRequest,
  options: ApiHubSignInOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/apihub/app/api/signIn")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        ...(options?.challenge !== undefined ? { "x-rpc-challenge": options?.challenge } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: signInRequestSerializer(body),
    });
}

export async function _signInDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function signIn(
  context: Client,
  cookie: string,
  ds: string,
  body: SignInRequest,
  options: ApiHubSignInOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _signInSend(context, cookie, ds, body, options);
  return _signInDeserialize(result);
}

export function _getHomeSend(
  context: Client,
  gids: number,
  options: ApiHubGetHomeOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/apihub/api/home/new{?gids}",
    {
      gids: gids,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
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
  gids: number,
  options: ApiHubGetHomeOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getHomeSend(context, gids, options);
  return _getHomeDeserialize(result);
}

export function _getVoteResultsSend(
  context: Client,
  ownerUid: string,
  voteIds: string,
  options: ApiHubGetVoteResultsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/apihub/api/getVotesResult{?owner_uid,vote_ids}",
    {
      owner_uid: ownerUid,
      vote_ids: voteIds,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getVoteResultsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getVoteResults(
  context: Client,
  ownerUid: string,
  voteIds: string,
  options: ApiHubGetVoteResultsOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getVoteResultsSend(context, ownerUid, voteIds, options);
  return _getVoteResultsDeserialize(result);
}

export function _getVotesSend(
  context: Client,
  ownerUid: string,
  voteIds: string,
  options: ApiHubGetVotesOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/apihub/api/getVotes{?owner_uid,vote_ids}",
    {
      owner_uid: ownerUid,
      vote_ids: voteIds,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getVotesDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getVotes(
  context: Client,
  ownerUid: string,
  voteIds: string,
  options: ApiHubGetVotesOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getVotesSend(context, ownerUid, voteIds, options);
  return _getVotesDeserialize(result);
}

export function _getMissionStateSend(
  context: Client,
  cookie: string,
  ds: string,
  pointSn: string,
  options: ApiHubGetMissionStateOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/apihub/wapi/getUserMissionsState{?point_sn}",
    {
      point_sn: pointSn,
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

export async function _getMissionStateDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getMissionState(
  context: Client,
  cookie: string,
  ds: string,
  pointSn: string,
  options: ApiHubGetMissionStateOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getMissionStateSend(context, cookie, ds, pointSn, options);
  return _getMissionStateDeserialize(result);
}

export function _getShareConfigSend(
  context: Client,
  cookie: string,
  ds: string,
  entityId: string,
  entityType: number,
  options: ApiHubGetShareConfigOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/apihub/api/getShareConf{?entity_id,entity_type}",
    {
      entity_id: entityId,
      entity_type: entityType,
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

export async function _getShareConfigDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getShareConfig(
  context: Client,
  cookie: string,
  ds: string,
  entityId: string,
  entityType: number,
  options: ApiHubGetShareConfigOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getShareConfigSend(context, cookie, ds, entityId, entityType, options);
  return _getShareConfigDeserialize(result);
}

export function _getMissionsSend(
  context: Client,
  cookie: string,
  ds: string,
  pointSn: string,
  options: ApiHubGetMissionsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/apihub/wapi/getMissions{?point_sn}",
    {
      point_sn: pointSn,
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

export async function _getMissionsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getMissions(
  context: Client,
  cookie: string,
  ds: string,
  pointSn: string,
  options: ApiHubGetMissionsOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getMissionsSend(context, cookie, ds, pointSn, options);
  return _getMissionsDeserialize(result);
}

export function _getGameListSend(
  context: Client,
  options: ApiHubGetGameListOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/apihub/wapi/getGameList")
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getGameListDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseForumList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseForumListDeserializer(result.body);
}

export async function getGameList(
  context: Client,
  options: ApiHubGetGameListOptionalParams = { requestOptions: {} },
): Promise<ApiResponseForumList> {
  const result = await _getGameListSend(context, options);
  return _getGameListDeserialize(result);
}

export function _getAppConfigSend(
  context: Client,
  options: ApiHubGetAppConfigOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/apihub/api/getAppConfig{?gid}",
    {
      gid: options?.gid,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getAppConfigDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getAppConfig(
  context: Client,
  options: ApiHubGetAppConfigOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getAppConfigSend(context, options);
  return _getAppConfigDeserialize(result);
}

export function _getAllGamesForumsSend(
  context: Client,
  options: ApiHubGetAllGamesForumsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/apihub/wapi/getAllGamesForums")
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getAllGamesForumsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseForumList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseForumListDeserializer(result.body);
}

export async function getAllGamesForums(
  context: Client,
  options: ApiHubGetAllGamesForumsOptionalParams = { requestOptions: {} },
): Promise<ApiResponseForumList> {
  const result = await _getAllGamesForumsSend(context, options);
  return _getAllGamesForumsDeserialize(result);
}
