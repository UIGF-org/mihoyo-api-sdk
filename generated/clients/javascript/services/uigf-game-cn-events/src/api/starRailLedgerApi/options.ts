// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface StarRailLedgerApiGetMonthDetailOptionalParams extends OperationOptions {
  pageSize?: number;
  month?: string;
  lang?: string;
}

/** Optional parameters. */
export interface StarRailLedgerApiGetMonthInfoOptionalParams extends OperationOptions {
  month?: string;
  lang?: string;
}
