// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface RegionListApiQueryOptionalParams extends OperationOptions {
  binary?: string;
  channelId?: string;
  lang?: string;
  platform?: string;
  subChannelId?: string;
  time?: string;
  version?: string;
}
