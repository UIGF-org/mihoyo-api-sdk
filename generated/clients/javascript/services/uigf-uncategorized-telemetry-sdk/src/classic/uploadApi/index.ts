// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetrySDKContext } from "../../api/uncategorizedTelemetrySDKContext.js";
import { upload } from "../../api/uploadApi/operations.js";
import { UploadApiUploadOptionalParams } from "../../api/uploadApi/options.js";
import { JsonObject } from "../../models/uigf/models.js";
import { UploadResponse } from "../../models/uigf/uncategorized/models.js";

/** Interface representing a UploadApi operations. */
export interface UploadApiOperations {
  upload: (body: JsonObject[], options?: UploadApiUploadOptionalParams) => Promise<UploadResponse>;
}

function _getUploadApi(context: UncategorizedTelemetrySDKContext) {
  return {
    upload: (body: JsonObject[], options?: UploadApiUploadOptionalParams) =>
      upload(context, body, options),
  };
}

export function _getUploadApiOperations(
  context: UncategorizedTelemetrySDKContext,
): UploadApiOperations {
  return {
    ..._getUploadApi(context),
  };
}
