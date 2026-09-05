// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface MetadataApiGetDxConfigsOptionalParams extends OperationOptions {
  gameIds?: string[];
}

/** Optional parameters. */
export interface MetadataApiGetWpfPackagesOptionalParams extends OperationOptions {
  gameIds?: string[];
}

/** Optional parameters. */
export interface MetadataApiGetGameBranchesOptionalParams extends OperationOptions {
  gameIds?: string[];
}

/** Optional parameters. */
export interface MetadataApiGetGameScanInfoOptionalParams extends OperationOptions {
  gameIds?: string[];
}

/** Optional parameters. */
export interface MetadataApiGetGameConfigsOptionalParams extends OperationOptions {
  gameIds?: string[];
}

/** Optional parameters. */
export interface MetadataApiGetDeprecatedFileConfigsOptionalParams extends OperationOptions {
  channel?: number;
  subChannel?: number;
  gameIds?: string[];
}

/** Optional parameters. */
export interface MetadataApiGetGameChannelSdksOptionalParams extends OperationOptions {
  channel?: number;
  subChannel?: number;
  gameIds?: string[];
}

/** Optional parameters. */
export interface MetadataApiGetGamePackagesOptionalParams extends OperationOptions {
  gameIds?: string[];
}

/** Optional parameters. */
export interface MetadataApiGetAllGameBasicInfoOptionalParams extends OperationOptions {
  gameIds?: string[];
}
