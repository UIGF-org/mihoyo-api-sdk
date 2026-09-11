// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface UgcApiGetAlertOptionalParams extends OperationOptions {
  level?: number;
  uid?: string;
  channelId?: number;
}
