// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../static-helpers/serialization/serialize-record.js";

/** model interface DeviceFingerprintRequest */
export interface DeviceFingerprintRequest {
  seedId: string;
  deviceId: string;
  platform: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function deviceFingerprintRequestSerializer(item: DeviceFingerprintRequest): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    seed_id: item["seedId"],
    device_id: item["deviceId"],
    platform: item["platform"],
  };
}

/** model interface DeviceFingerprint */
export interface DeviceFingerprint {
  deviceFp?: string;
  code?: number;
  msg?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function deviceFingerprintDeserializer(item: any): DeviceFingerprint {
  return {
    additionalProperties: serializeRecord(item, ["device_fp", "code", "msg"]),
    deviceFp: item["device_fp"],
    code: item["code"],
    msg: item["msg"],
  };
}
