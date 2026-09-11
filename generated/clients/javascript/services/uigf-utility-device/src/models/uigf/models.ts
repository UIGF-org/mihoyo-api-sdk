// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { DeviceFingerprint, deviceFingerprintDeserializer } from "./game/models.js";
import { DeviceExtensionList, deviceExtensionListDeserializer } from "./utility/device/models.js";

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseDeviceExtensionList {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: DeviceExtensionList;
}

export function apiResponseDeviceExtensionListDeserializer(
  item: any,
): ApiResponseDeviceExtensionList {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: deviceExtensionListDeserializer(item["data"]),
  };
}

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseDeviceFingerprint {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: DeviceFingerprint;
}

export function apiResponseDeviceFingerprintDeserializer(item: any): ApiResponseDeviceFingerprint {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: deviceFingerprintDeserializer(item["data"]),
  };
}
