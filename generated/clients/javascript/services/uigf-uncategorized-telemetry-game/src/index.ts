// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { UncategorizedTelemetryGameClient } from "./uncategorizedTelemetryGameClient.js";
export type { JsonObject } from "./models/uigf/index.js";
export type { UploadResponse } from "./models/uigf/uncategorized/index.js";
export type { UncategorizedTelemetryGameClientOptionalParams } from "./api/index.js";
export type { PerformanceApiVerifyOptionalParams } from "./api/performanceApi/index.js";
export type {
  UploadApiUploadCustomOptionalParams,
  UploadApiUploadSdkOptionalParams,
  UploadApiUploadCrashOptionalParams,
} from "./api/uploadApi/index.js";
export type { PerformanceApiOperations, UploadApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
