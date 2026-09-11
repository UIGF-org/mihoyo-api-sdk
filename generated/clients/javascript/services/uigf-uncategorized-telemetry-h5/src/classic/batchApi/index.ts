// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetryH5Context } from "../../api/uncategorizedTelemetryH5Context.js";
import { upload } from "../../api/batchApi/operations.js";
import { BatchApiUploadOptionalParams } from "../../api/batchApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";
import { H5LogRequest } from "../../models/uigf/uncategorized/models.js";

/** Interface representing a BatchApi operations. */
export interface BatchApiOperations {
  upload: (
    topic: string,
    body: H5LogRequest,
    options?: BatchApiUploadOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getBatchApi(context: UncategorizedTelemetryH5Context) {
  return {
    upload: (topic: string, body: H5LogRequest, options?: BatchApiUploadOptionalParams) =>
      upload(context, topic, body, options),
  };
}

export function _getBatchApiOperations(
  context: UncategorizedTelemetryH5Context,
): BatchApiOperations {
  return {
    ..._getBatchApi(context),
  };
}
