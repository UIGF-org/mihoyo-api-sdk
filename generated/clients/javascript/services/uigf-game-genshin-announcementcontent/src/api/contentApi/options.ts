// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface ContentApiGetOptionalParams extends OperationOptions {
  t?: string;
  level?: number;
  uid?: string;
  channelId?: number;
}
