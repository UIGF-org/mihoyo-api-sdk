// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface ShopApiCheckOrderOptionalParams extends OperationOptions {
  cookie?: string;
}

/** Optional parameters. */
export interface ShopApiCreateOrderOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ShopApiFetchGoodsOptionalParams extends OperationOptions {
  cookie?: string;
}
