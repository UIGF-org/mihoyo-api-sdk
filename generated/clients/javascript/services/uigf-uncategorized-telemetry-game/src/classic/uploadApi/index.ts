// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetryGameContext } from "../../api/uncategorizedTelemetryGameContext.js";
import { uploadCustom, uploadSdk, uploadCrash } from "../../api/uploadApi/operations.js";
import {
  UploadApiUploadCustomOptionalParams,
  UploadApiUploadSdkOptionalParams,
  UploadApiUploadCrashOptionalParams,
} from "../../api/uploadApi/options.js";
import { JsonObject } from "../../models/uigf/models.js";
import { UploadResponse } from "../../models/uigf/uncategorized/models.js";

/** Interface representing a UploadApi operations. */
export interface UploadApiOperations {
  uploadCustom: (
    body: JsonObject[],
    options?: UploadApiUploadCustomOptionalParams,
  ) => Promise<UploadResponse>;
  uploadSdk: (
    body: JsonObject[],
    options?: UploadApiUploadSdkOptionalParams,
  ) => Promise<UploadResponse>;
  /** The official client signs the upload headers; signing is intentionally caller-owned. */
  uploadCrash: (
    body: JsonObject[],
    options?: UploadApiUploadCrashOptionalParams,
  ) => Promise<UploadResponse>;
}

function _getUploadApi(context: UncategorizedTelemetryGameContext) {
  return {
    uploadCustom: (body: JsonObject[], options?: UploadApiUploadCustomOptionalParams) =>
      uploadCustom(context, body, options),
    uploadSdk: (body: JsonObject[], options?: UploadApiUploadSdkOptionalParams) =>
      uploadSdk(context, body, options),
    uploadCrash: (body: JsonObject[], options?: UploadApiUploadCrashOptionalParams) =>
      uploadCrash(context, body, options),
  };
}

export function _getUploadApiOperations(
  context: UncategorizedTelemetryGameContext,
): UploadApiOperations {
  return {
    ..._getUploadApi(context),
  };
}
