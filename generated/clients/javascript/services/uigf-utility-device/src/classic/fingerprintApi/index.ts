// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UtilityDeviceContext } from "../../api/utilityDeviceContext.js";
import { getFingerprint } from "../../api/fingerprintApi/operations.js";
import { FingerprintApiGetFingerprintOptionalParams } from "../../api/fingerprintApi/options.js";
import { DeviceFingerprintRequest } from "../../models/uigf/game/models.js";
import { ApiResponseDeviceFingerprint } from "../../models/uigf/models.js";

/** Interface representing a FingerprintApi operations. */
export interface FingerprintApiOperations {
  /** Registers a legitimate client device fingerprint and returns its `device_fp` value. */
  getFingerprint: (
    appVersion: string,
    clientType: string,
    requestedWith: string,
    body: DeviceFingerprintRequest,
    options?: FingerprintApiGetFingerprintOptionalParams,
  ) => Promise<ApiResponseDeviceFingerprint>;
}

function _getFingerprintApi(context: UtilityDeviceContext) {
  return {
    getFingerprint: (
      appVersion: string,
      clientType: string,
      requestedWith: string,
      body: DeviceFingerprintRequest,
      options?: FingerprintApiGetFingerprintOptionalParams,
    ) => getFingerprint(context, appVersion, clientType, requestedWith, body, options),
  };
}

export function _getFingerprintApiOperations(
  context: UtilityDeviceContext,
): FingerprintApiOperations {
  return {
    ..._getFingerprintApi(context),
  };
}
