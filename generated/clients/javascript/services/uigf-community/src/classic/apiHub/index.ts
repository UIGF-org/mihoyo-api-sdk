// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext } from "../../api/communityContext.js";
import {
  setPostVote,
  signIn,
  getHome,
  getVoteResults,
  getVotes,
  getMissionState,
  getShareConfig,
  getMissions,
  getGameList,
  getAppConfig,
  getAllGamesForums,
} from "../../api/apiHub/operations.js";
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
} from "../../api/apiHub/options.js";
import { SignInRequest, LikePostRequest } from "../../models/uigf/community/models.js";
import { ApiResponseJsonObject, ApiResponseForumList } from "../../models/uigf/models.js";

/** Interface representing a ApiHub operations. */
export interface ApiHubOperations {
  setPostVote: (
    cookie: string,
    ds: string,
    body: LikePostRequest,
    options?: ApiHubSetPostVoteOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  signIn: (
    cookie: string,
    ds: string,
    body: SignInRequest,
    options?: ApiHubSignInOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getHome: (gids: number, options?: ApiHubGetHomeOptionalParams) => Promise<ApiResponseJsonObject>;
  getVoteResults: (
    ownerUid: string,
    voteIds: string,
    options?: ApiHubGetVoteResultsOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getVotes: (
    ownerUid: string,
    voteIds: string,
    options?: ApiHubGetVotesOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getMissionState: (
    cookie: string,
    ds: string,
    pointSn: string,
    options?: ApiHubGetMissionStateOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getShareConfig: (
    cookie: string,
    ds: string,
    entityId: string,
    entityType: number,
    options?: ApiHubGetShareConfigOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getMissions: (
    cookie: string,
    ds: string,
    pointSn: string,
    options?: ApiHubGetMissionsOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getGameList: (options?: ApiHubGetGameListOptionalParams) => Promise<ApiResponseForumList>;
  getAppConfig: (options?: ApiHubGetAppConfigOptionalParams) => Promise<ApiResponseJsonObject>;
  getAllGamesForums: (
    options?: ApiHubGetAllGamesForumsOptionalParams,
  ) => Promise<ApiResponseForumList>;
}

function _getApiHub(context: CommunityContext) {
  return {
    setPostVote: (
      cookie: string,
      ds: string,
      body: LikePostRequest,
      options?: ApiHubSetPostVoteOptionalParams,
    ) => setPostVote(context, cookie, ds, body, options),
    signIn: (
      cookie: string,
      ds: string,
      body: SignInRequest,
      options?: ApiHubSignInOptionalParams,
    ) => signIn(context, cookie, ds, body, options),
    getHome: (gids: number, options?: ApiHubGetHomeOptionalParams) =>
      getHome(context, gids, options),
    getVoteResults: (
      ownerUid: string,
      voteIds: string,
      options?: ApiHubGetVoteResultsOptionalParams,
    ) => getVoteResults(context, ownerUid, voteIds, options),
    getVotes: (ownerUid: string, voteIds: string, options?: ApiHubGetVotesOptionalParams) =>
      getVotes(context, ownerUid, voteIds, options),
    getMissionState: (
      cookie: string,
      ds: string,
      pointSn: string,
      options?: ApiHubGetMissionStateOptionalParams,
    ) => getMissionState(context, cookie, ds, pointSn, options),
    getShareConfig: (
      cookie: string,
      ds: string,
      entityId: string,
      entityType: number,
      options?: ApiHubGetShareConfigOptionalParams,
    ) => getShareConfig(context, cookie, ds, entityId, entityType, options),
    getMissions: (
      cookie: string,
      ds: string,
      pointSn: string,
      options?: ApiHubGetMissionsOptionalParams,
    ) => getMissions(context, cookie, ds, pointSn, options),
    getGameList: (options?: ApiHubGetGameListOptionalParams) => getGameList(context, options),
    getAppConfig: (options?: ApiHubGetAppConfigOptionalParams) => getAppConfig(context, options),
    getAllGamesForums: (options?: ApiHubGetAllGamesForumsOptionalParams) =>
      getAllGamesForums(context, options),
  };
}

export function _getApiHubOperations(context: CommunityContext): ApiHubOperations {
  return {
    ..._getApiHub(context),
  };
}
