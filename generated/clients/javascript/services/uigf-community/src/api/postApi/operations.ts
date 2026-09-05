// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext as Client } from "../index.js";
import {
  FavoritePostRequest,
  favoritePostRequestSerializer,
} from "../../models/uigf/community/models.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
  ApiResponsePost,
  apiResponsePostDeserializer,
  ApiResponsePostList,
  apiResponsePostListDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  PostApiSetFavoriteOptionalParams,
  PostApiSearchOptionalParams,
  PostApiGetUserPostsOptionalParams,
  PostApiGetTopicPostsOptionalParams,
  PostApiGetSubRepliesOptionalParams,
  PostApiGetRepliesOptionalParams,
  PostApiGetFullInCollectionOptionalParams,
  PostApiGetFullOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _setFavoriteSend(
  context: Client,
  cookie: string,
  ds: string,
  body: FavoritePostRequest,
  options: PostApiSetFavoriteOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/post/wapi/userFavoritePost")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        cookie: cookie,
        ds: ds,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: favoritePostRequestSerializer(body),
    });
}

export async function _setFavoriteDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function setFavorite(
  context: Client,
  cookie: string,
  ds: string,
  body: FavoritePostRequest,
  options: PostApiSetFavoriteOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _setFavoriteSend(context, cookie, ds, body, options);
  return _setFavoriteDeserialize(result);
}

export function _searchSend(
  context: Client,
  gids: string,
  keyword: string,
  options: PostApiSearchOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/post/wapi/searchPosts{?gids,keyword,offset,size,last_id}",
    {
      gids: gids,
      keyword: keyword,
      offset: options?.offset,
      size: options?.size,
      last_id: options?.lastId,
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

export async function _searchDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePostList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostListDeserializer(result.body);
}

export async function search(
  context: Client,
  gids: string,
  keyword: string,
  options: PostApiSearchOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePostList> {
  const result = await _searchSend(context, gids, keyword, options);
  return _searchDeserialize(result);
}

export function _getUserPostsSend(
  context: Client,
  uid: string,
  gids: string,
  options: PostApiGetUserPostsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/post/wapi/userPost{?uid,gids,offset,size,last_id}",
    {
      uid: uid,
      gids: gids,
      offset: options?.offset,
      size: options?.size,
      last_id: options?.lastId,
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

export async function _getUserPostsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePostList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostListDeserializer(result.body);
}

export async function getUserPosts(
  context: Client,
  uid: string,
  gids: string,
  options: PostApiGetUserPostsOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePostList> {
  const result = await _getUserPostsSend(context, uid, gids, options);
  return _getUserPostsDeserialize(result);
}

export function _getTopicPostsSend(
  context: Client,
  gids: string,
  topicId: string,
  options: PostApiGetTopicPostsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/post/wapi/getTopicPostList{?gids,topic_id,offset,size,last_id}",
    {
      gids: gids,
      topic_id: topicId,
      offset: options?.offset,
      size: options?.size,
      last_id: options?.lastId,
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

export async function _getTopicPostsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePostList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostListDeserializer(result.body);
}

export async function getTopicPosts(
  context: Client,
  gids: string,
  topicId: string,
  options: PostApiGetTopicPostsOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePostList> {
  const result = await _getTopicPostsSend(context, gids, topicId, options);
  return _getTopicPostsDeserialize(result);
}

export function _getSubRepliesSend(
  context: Client,
  postId: string,
  replyId: string,
  options: PostApiGetSubRepliesOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/post/wapi/getSubReplies{?post_id,reply_id,last_id,size}",
    {
      post_id: postId,
      reply_id: replyId,
      last_id: options?.lastId,
      size: options?.size,
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

export async function _getSubRepliesDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePostList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostListDeserializer(result.body);
}

export async function getSubReplies(
  context: Client,
  postId: string,
  replyId: string,
  options: PostApiGetSubRepliesOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePostList> {
  const result = await _getSubRepliesSend(context, postId, replyId, options);
  return _getSubRepliesDeserialize(result);
}

export function _getRepliesSend(
  context: Client,
  postId: string,
  options: PostApiGetRepliesOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/post/wapi/getPostReplies{?last_id,size,post_id,gids,read}",
    {
      last_id: options?.lastId,
      size: options?.size,
      post_id: postId,
      gids: options?.gids,
      read: options?.read,
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

export async function _getRepliesDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePostList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostListDeserializer(result.body);
}

export async function getReplies(
  context: Client,
  postId: string,
  options: PostApiGetRepliesOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePostList> {
  const result = await _getRepliesSend(context, postId, options);
  return _getRepliesDeserialize(result);
}

export function _getFullInCollectionSend(
  context: Client,
  collectionId: string,
  postId: string,
  gids: string,
  options: PostApiGetFullInCollectionOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/post/wapi/getPostFullInCollection{?collection_id,post_id,gids}",
    {
      collection_id: collectionId,
      post_id: postId,
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

export async function _getFullInCollectionDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePost> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostDeserializer(result.body);
}

export async function getFullInCollection(
  context: Client,
  collectionId: string,
  postId: string,
  gids: string,
  options: PostApiGetFullInCollectionOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePost> {
  const result = await _getFullInCollectionSend(context, collectionId, postId, gids, options);
  return _getFullInCollectionDeserialize(result);
}

export function _getFullSend(
  context: Client,
  postId: string,
  options: PostApiGetFullOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/post/wapi/getPostFull{?post_id,gids,read}",
    {
      post_id: postId,
      gids: options?.gids,
      read: options?.read,
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
        ...(options?.cookie !== undefined ? { cookie: options?.cookie } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
    });
}

export async function _getFullDeserialize(result: PathUncheckedResponse): Promise<ApiResponsePost> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostDeserializer(result.body);
}

export async function getFull(
  context: Client,
  postId: string,
  options: PostApiGetFullOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePost> {
  const result = await _getFullSend(context, postId, options);
  return _getFullDeserialize(result);
}
