// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
  ApiResponsePostList,
  apiResponsePostListDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  FeedApiGetLotteryUserShowOptionalParams,
  FeedApiGetTimelineOptionalParams,
  FeedApiGetRecentForumPostsOptionalParams,
  FeedApiGetHotForumPostsOptionalParams,
  FeedApiGetNewsOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getLotteryUserShowSend(
  context: Client,
  lotteryId: string,
  options: FeedApiGetLotteryUserShowOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/painter/wapi/lotteryUserShow{?lottery_id}",
    {
      lottery_id: lotteryId,
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

export async function _getLotteryUserShowDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getLotteryUserShow(
  context: Client,
  lotteryId: string,
  options: FeedApiGetLotteryUserShowOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getLotteryUserShowSend(context, lotteryId, options);
  return _getLotteryUserShowDeserialize(result);
}

export function _getTimelineSend(
  context: Client,
  gids: string,
  options: FeedApiGetTimelineOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/painter/wapi/getTimelineList{?gids,offset,size,last_id}",
    {
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

export async function _getTimelineDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePostList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostListDeserializer(result.body);
}

export async function getTimeline(
  context: Client,
  gids: string,
  options: FeedApiGetTimelineOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePostList> {
  const result = await _getTimelineSend(context, gids, options);
  return _getTimelineDeserialize(result);
}

export function _getRecentForumPostsSend(
  context: Client,
  gids: string,
  options: FeedApiGetRecentForumPostsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/painter/wapi/getRecentForumPostList{?gids,offset,size,last_id}",
    {
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

export async function _getRecentForumPostsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePostList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostListDeserializer(result.body);
}

export async function getRecentForumPosts(
  context: Client,
  gids: string,
  options: FeedApiGetRecentForumPostsOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePostList> {
  const result = await _getRecentForumPostsSend(context, gids, options);
  return _getRecentForumPostsDeserialize(result);
}

export function _getHotForumPostsSend(
  context: Client,
  gids: string,
  options: FeedApiGetHotForumPostsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/painter/wapi/getHotForumPostList{?gids,offset,size,last_id}",
    {
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

export async function _getHotForumPostsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePostList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostListDeserializer(result.body);
}

export async function getHotForumPosts(
  context: Client,
  gids: string,
  options: FeedApiGetHotForumPostsOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePostList> {
  const result = await _getHotForumPostsSend(context, gids, options);
  return _getHotForumPostsDeserialize(result);
}

export function _getNewsSend(
  context: Client,
  gids: string,
  options: FeedApiGetNewsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/painter/wapi/getNewsList{?gids,offset,size,last_id}",
    {
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

export async function _getNewsDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponsePostList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponsePostListDeserializer(result.body);
}

export async function getNews(
  context: Client,
  gids: string,
  options: FeedApiGetNewsOptionalParams = { requestOptions: {} },
): Promise<ApiResponsePostList> {
  const result = await _getNewsSend(context, gids, options);
  return _getNewsDeserialize(result);
}
