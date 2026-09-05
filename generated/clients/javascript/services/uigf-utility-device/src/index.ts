// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { UtilityDeviceClient } from "./utilityDeviceClient.js";
export type { ApiResponseDeviceFingerprint } from "./models/uigf/index.js";
export type { DeviceFingerprintRequest, DeviceFingerprint } from "./models/uigf/game/index.js";
export type { UtilityDeviceClientOptionalParams } from "./api/index.js";
export type { FingerprintApiGetFingerprintOptionalParams } from "./api/fingerprintApi/index.js";
export type { FingerprintApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
