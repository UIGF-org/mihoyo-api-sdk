// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetryGameContext } from "../../api/uncategorizedTelemetryGameContext.js";
import { verify } from "../../api/performanceApi/operations.js";
import { PerformanceApiVerifyOptionalParams } from "../../api/performanceApi/options.js";
import { UploadResponse } from "../../models/uigf/uncategorized/models.js";

/** Interface representing a PerformanceApi operations. */
export interface PerformanceApiOperations {
  verify: (
    deviceId: string,
    name: string,
    platform: string,
    options?: PerformanceApiVerifyOptionalParams,
  ) => Promise<UploadResponse>;
}

function _getPerformanceApi(context: UncategorizedTelemetryGameContext) {
  return {
    verify: (
      deviceId: string,
      name: string,
      platform: string,
      options?: PerformanceApiVerifyOptionalParams,
    ) => verify(context, deviceId, name, platform, options),
  };
}

export function _getPerformanceApiOperations(
  context: UncategorizedTelemetryGameContext,
): PerformanceApiOperations {
  return {
    ..._getPerformanceApi(context),
  };
}
