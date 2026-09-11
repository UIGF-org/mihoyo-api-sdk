// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface GranterApiLoginOptionalParams extends OperationOptions {
  rpcAppId?: string;
  rpcAppVersion?: string;
  rpcChannelId?: string;
  rpcChannelVersion?: string;
  rpcClientType?: string;
  rpcComboVersion?: string;
  rpcDeviceFingerprint?: string;
  rpcDeviceId?: string;
  rpcDeviceModel?: string;
  rpcDeviceName?: string;
  rpcGameBiz?: string;
  rpcGoodsThirdParty?: string;
  rpcLanguage?: string;
  rpcMdkVersion?: string;
  rpcPaymentVersion?: string;
  rpcSdkVersion?: string;
  rpcSubChannelId?: string;
  rpcSystemVersion?: string;
}
