// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface CurrentRegionApiQueryOptionalParams extends OperationOptions {
  accountType?: string;
  aid?: string;
  binary?: string;
  channelId?: string;
  dispatchSeed?: string;
  keyId?: string;
  lang?: string;
  platform?: string;
  subChannelId?: string;
  time?: string;
  version?: string;
}
