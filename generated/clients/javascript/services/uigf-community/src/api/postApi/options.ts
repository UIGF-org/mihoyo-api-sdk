// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface PostApiSetFavoriteOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface PostApiSearchOptionalParams extends OperationOptions {
  offset?: number;
  size?: number;
  lastId?: string;
}

/** Optional parameters. */
export interface PostApiGetUserPostsOptionalParams extends OperationOptions {
  offset?: number;
  size?: number;
  lastId?: string;
}

/** Optional parameters. */
export interface PostApiGetTopicPostsOptionalParams extends OperationOptions {
  offset?: number;
  size?: number;
  lastId?: string;
}

/** Optional parameters. */
export interface PostApiGetSubRepliesOptionalParams extends OperationOptions {
  lastId?: string;
  size?: number;
}

/** Optional parameters. */
export interface PostApiGetRepliesOptionalParams extends OperationOptions {
  lastId?: string;
  size?: number;
  gids?: string;
  read?: number;
}

/** Optional parameters. */
export interface PostApiGetFullInCollectionOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface PostApiGetFullOptionalParams extends OperationOptions {
  cookie?: string;
  gids?: string;
  read?: number;
}
