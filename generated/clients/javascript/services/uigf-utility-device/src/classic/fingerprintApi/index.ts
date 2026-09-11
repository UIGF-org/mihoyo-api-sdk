// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UtilityDeviceContext } from "../../api/utilityDeviceContext.js";
import { getFingerprint, getExtensionList } from "../../api/fingerprintApi/operations.js";
import {
  FingerprintApiGetFingerprintOptionalParams,
  FingerprintApiGetExtensionListOptionalParams,
} from "../../api/fingerprintApi/options.js";
import { DeviceFingerprintRequest } from "../../models/uigf/game/models.js";
import {
  ApiResponseDeviceExtensionList,
  ApiResponseDeviceFingerprint,
} from "../../models/uigf/models.js";

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
  /** Returns the client extension fields expected by the fingerprint registration endpoint. */
  getExtensionList: (
    platform: string,
    options?: FingerprintApiGetExtensionListOptionalParams,
  ) => Promise<ApiResponseDeviceExtensionList>;
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
    getExtensionList: (platform: string, options?: FingerprintApiGetExtensionListOptionalParams) =>
      getExtensionList(context, platform, options),
  };
}

export function _getFingerprintApiOperations(
  context: UtilityDeviceContext,
): FingerprintApiOperations {
  return {
    ..._getFingerprintApi(context),
  };
}
