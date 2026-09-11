// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetryCrashContext } from "../../api/uncategorizedTelemetryCrashContext.js";
import { upload } from "../../api/crashApi/operations.js";
import { CrashApiUploadOptionalParams } from "../../api/crashApi/options.js";
import { JsonObject } from "../../models/uigf/models.js";

/** Interface representing a CrashApi operations. */
export interface CrashApiOperations {
  upload: (body: JsonObject, options?: CrashApiUploadOptionalParams) => Promise<void>;
}

function _getCrashApi(context: UncategorizedTelemetryCrashContext) {
  return {
    upload: (body: JsonObject, options?: CrashApiUploadOptionalParams) =>
      upload(context, body, options),
  };
}

export function _getCrashApiOperations(
  context: UncategorizedTelemetryCrashContext,
): CrashApiOperations {
  return {
    ..._getCrashApi(context),
  };
}
