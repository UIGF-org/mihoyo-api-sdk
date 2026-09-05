// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface LedgerApiGetMonthDetailOptionalParams extends OperationOptions {
  limit?: number;
}

/** Optional parameters. */
export interface LedgerApiGetMonthInfoOptionalParams extends OperationOptions {
  month?: number;
}
