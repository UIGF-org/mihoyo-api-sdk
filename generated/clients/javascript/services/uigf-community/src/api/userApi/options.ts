// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface UserApiGetFullInfoOptionalParams extends OperationOptions {
  uid?: string;
  cookie?: string;
  ds?: string;
}
