// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface GachaLogApiGetBeyondHistoryOptionalParams extends OperationOptions {
  gachaId?: string;
  endId?: string;
  page?: number;
  size?: number;
  region?: string;
  gameBiz?: string;
  deviceType?: string;
  gameVersion?: string;
  initType?: string;
  noJoypadClose?: string;
  timestamp?: string;
  winMode?: string;
}

/** Optional parameters. */
export interface GachaLogApiGetHistoryOptionalParams extends OperationOptions {
  gachaId?: string;
  endId?: string;
  page?: number;
  size?: number;
  region?: string;
  gameBiz?: string;
  deviceType?: string;
  gameVersion?: string;
  initType?: string;
  noJoypadClose?: string;
  timestamp?: string;
  winMode?: string;
}
