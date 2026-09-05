// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface AnnouncementApiGetAlertOptionalParams extends OperationOptions {
  level?: number;
  uid?: string;
  channelId?: number;
}

/** Optional parameters. */
export interface AnnouncementApiGetContentOptionalParams extends OperationOptions {
  level?: number;
  uid?: string;
  channelId?: number;
}

/** Optional parameters. */
export interface AnnouncementApiListOptionalParams extends OperationOptions {
  level?: number;
  uid?: string;
  channelId?: number;
}
