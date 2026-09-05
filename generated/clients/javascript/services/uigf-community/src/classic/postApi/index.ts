// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext } from "../../api/communityContext.js";
import {
  setFavorite,
  search,
  getUserPosts,
  getTopicPosts,
  getSubReplies,
  getReplies,
  getFullInCollection,
  getFull,
} from "../../api/postApi/operations.js";
import {
  PostApiSetFavoriteOptionalParams,
  PostApiSearchOptionalParams,
  PostApiGetUserPostsOptionalParams,
  PostApiGetTopicPostsOptionalParams,
  PostApiGetSubRepliesOptionalParams,
  PostApiGetRepliesOptionalParams,
  PostApiGetFullInCollectionOptionalParams,
  PostApiGetFullOptionalParams,
} from "../../api/postApi/options.js";
import { FavoritePostRequest } from "../../models/uigf/community/models.js";
import {
  ApiResponseJsonObject,
  ApiResponsePost,
  ApiResponsePostList,
} from "../../models/uigf/models.js";

/** Interface representing a PostApi operations. */
export interface PostApiOperations {
  setFavorite: (
    cookie: string,
    ds: string,
    body: FavoritePostRequest,
    options?: PostApiSetFavoriteOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  search: (
    gids: string,
    keyword: string,
    options?: PostApiSearchOptionalParams,
  ) => Promise<ApiResponsePostList>;
  getUserPosts: (
    uid: string,
    gids: string,
    options?: PostApiGetUserPostsOptionalParams,
  ) => Promise<ApiResponsePostList>;
  getTopicPosts: (
    gids: string,
    topicId: string,
    options?: PostApiGetTopicPostsOptionalParams,
  ) => Promise<ApiResponsePostList>;
  getSubReplies: (
    postId: string,
    replyId: string,
    options?: PostApiGetSubRepliesOptionalParams,
  ) => Promise<ApiResponsePostList>;
  getReplies: (
    postId: string,
    options?: PostApiGetRepliesOptionalParams,
  ) => Promise<ApiResponsePostList>;
  getFullInCollection: (
    collectionId: string,
    postId: string,
    gids: string,
    options?: PostApiGetFullInCollectionOptionalParams,
  ) => Promise<ApiResponsePost>;
  getFull: (postId: string, options?: PostApiGetFullOptionalParams) => Promise<ApiResponsePost>;
}

function _getPostApi(context: CommunityContext) {
  return {
    setFavorite: (
      cookie: string,
      ds: string,
      body: FavoritePostRequest,
      options?: PostApiSetFavoriteOptionalParams,
    ) => setFavorite(context, cookie, ds, body, options),
    search: (gids: string, keyword: string, options?: PostApiSearchOptionalParams) =>
      search(context, gids, keyword, options),
    getUserPosts: (uid: string, gids: string, options?: PostApiGetUserPostsOptionalParams) =>
      getUserPosts(context, uid, gids, options),
    getTopicPosts: (gids: string, topicId: string, options?: PostApiGetTopicPostsOptionalParams) =>
      getTopicPosts(context, gids, topicId, options),
    getSubReplies: (
      postId: string,
      replyId: string,
      options?: PostApiGetSubRepliesOptionalParams,
    ) => getSubReplies(context, postId, replyId, options),
    getReplies: (postId: string, options?: PostApiGetRepliesOptionalParams) =>
      getReplies(context, postId, options),
    getFullInCollection: (
      collectionId: string,
      postId: string,
      gids: string,
      options?: PostApiGetFullInCollectionOptionalParams,
    ) => getFullInCollection(context, collectionId, postId, gids, options),
    getFull: (postId: string, options?: PostApiGetFullOptionalParams) =>
      getFull(context, postId, options),
  };
}

export function _getPostApiOperations(context: CommunityContext): PostApiOperations {
  return {
    ..._getPostApi(context),
  };
}
