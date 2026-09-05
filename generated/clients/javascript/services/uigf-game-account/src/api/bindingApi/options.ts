// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface BindingApiGetRolesOptionalParams extends OperationOptions {
  ds?: string;
  gameBiz?: string;
}

/** Optional parameters. */
export interface BindingApiGenerateAuthKeyOptionalParams extends OperationOptions {}
