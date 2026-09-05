// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface ApiHubSetPostVoteOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ApiHubSignInOptionalParams extends OperationOptions {
  challenge?: string;
}

/** Optional parameters. */
export interface ApiHubGetHomeOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ApiHubGetVoteResultsOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ApiHubGetVotesOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ApiHubGetMissionStateOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ApiHubGetShareConfigOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ApiHubGetMissionsOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ApiHubGetGameListOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ApiHubGetAppConfigOptionalParams extends OperationOptions {
  gid?: string;
}

/** Optional parameters. */
export interface ApiHubGetAllGamesForumsOptionalParams extends OperationOptions {}
