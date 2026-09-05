// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface ZenlessLedgerApiGetMonthDetailOptionalParams extends OperationOptions {
  pageSize?: number;
  month?: string;
  lang?: string;
}

/** Optional parameters. */
export interface ZenlessLedgerApiGetMonthInfoOptionalParams extends OperationOptions {
  month?: string;
  lang?: string;
}
