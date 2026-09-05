// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface GachaLogApiGetBeyondHistoryOptionalParams extends OperationOptions {
  endId?: string;
  size?: number;
}

/** Optional parameters. */
export interface GachaLogApiGetHistoryOptionalParams extends OperationOptions {
  endId?: string;
  size?: number;
}
