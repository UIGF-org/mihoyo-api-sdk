// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface UploadApiUploadCustomOptionalParams extends OperationOptions {
  authorization?: string;
  contentMd5?: string;
  dateParam?: string;
  cmsSignature?: string;
}

/** Optional parameters. */
export interface UploadApiUploadSdkOptionalParams extends OperationOptions {
  authorization?: string;
  contentMd5?: string;
  dateParam?: string;
  cmsSignature?: string;
}

/** Optional parameters. */
export interface UploadApiUploadCrashOptionalParams extends OperationOptions {
  authorization?: string;
  contentMd5?: string;
  dateParam?: string;
  cmsSignature?: string;
}
