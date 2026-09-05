// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface FeedApiGetLotteryUserShowOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface FeedApiGetTimelineOptionalParams extends OperationOptions {
  offset?: number;
  size?: number;
  lastId?: string;
}

/** Optional parameters. */
export interface FeedApiGetRecentForumPostsOptionalParams extends OperationOptions {
  offset?: number;
  size?: number;
  lastId?: string;
}

/** Optional parameters. */
export interface FeedApiGetHotForumPostsOptionalParams extends OperationOptions {
  offset?: number;
  size?: number;
  lastId?: string;
}

/** Optional parameters. */
export interface FeedApiGetNewsOptionalParams extends OperationOptions {
  offset?: number;
  size?: number;
  lastId?: string;
}
