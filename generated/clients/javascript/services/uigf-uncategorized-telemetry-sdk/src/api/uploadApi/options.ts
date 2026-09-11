// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface UploadApiUploadOptionalParams extends OperationOptions {
  authorization?: string;
  contentMd5?: string;
  dateParam?: string;
  cmsSignature?: string;
}
