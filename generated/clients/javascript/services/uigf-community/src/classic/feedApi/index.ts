// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext } from "../../api/communityContext.js";
import {
  getLotteryUserShow,
  getTimeline,
  getRecentForumPosts,
  getHotForumPosts,
  getNews,
} from "../../api/feedApi/operations.js";
import {
  FeedApiGetLotteryUserShowOptionalParams,
  FeedApiGetTimelineOptionalParams,
  FeedApiGetRecentForumPostsOptionalParams,
  FeedApiGetHotForumPostsOptionalParams,
  FeedApiGetNewsOptionalParams,
} from "../../api/feedApi/options.js";
import { ApiResponseJsonObject, ApiResponsePostList } from "../../models/uigf/models.js";

/** Interface representing a FeedApi operations. */
export interface FeedApiOperations {
  getLotteryUserShow: (
    lotteryId: string,
    options?: FeedApiGetLotteryUserShowOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getTimeline: (
    gids: string,
    options?: FeedApiGetTimelineOptionalParams,
  ) => Promise<ApiResponsePostList>;
  getRecentForumPosts: (
    gids: string,
    options?: FeedApiGetRecentForumPostsOptionalParams,
  ) => Promise<ApiResponsePostList>;
  getHotForumPosts: (
    gids: string,
    options?: FeedApiGetHotForumPostsOptionalParams,
  ) => Promise<ApiResponsePostList>;
  getNews: (gids: string, options?: FeedApiGetNewsOptionalParams) => Promise<ApiResponsePostList>;
}

function _getFeedApi(context: CommunityContext) {
  return {
    getLotteryUserShow: (lotteryId: string, options?: FeedApiGetLotteryUserShowOptionalParams) =>
      getLotteryUserShow(context, lotteryId, options),
    getTimeline: (gids: string, options?: FeedApiGetTimelineOptionalParams) =>
      getTimeline(context, gids, options),
    getRecentForumPosts: (gids: string, options?: FeedApiGetRecentForumPostsOptionalParams) =>
      getRecentForumPosts(context, gids, options),
    getHotForumPosts: (gids: string, options?: FeedApiGetHotForumPostsOptionalParams) =>
      getHotForumPosts(context, gids, options),
    getNews: (gids: string, options?: FeedApiGetNewsOptionalParams) =>
      getNews(context, gids, options),
  };
}

export function _getFeedApiOperations(context: CommunityContext): FeedApiOperations {
  return {
    ..._getFeedApi(context),
  };
}
