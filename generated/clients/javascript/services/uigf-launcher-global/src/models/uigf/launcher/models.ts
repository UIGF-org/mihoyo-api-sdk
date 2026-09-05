// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../static-helpers/serialization/serialize-record.js";
import { jsonObjectArrayDeserializer, JsonObject } from "../models.js";

/** model interface GameBasicInfo */
export interface GameBasicInfo {
  gameInfoList?: JsonObject[];
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function gameBasicInfoDeserializer(item: any): GameBasicInfo {
  return {
    additionalProperties: serializeRecord(item, ["game_info_list"]),
    gameInfoList: !item["game_info_list"]
      ? item["game_info_list"]
      : jsonObjectArrayDeserializer(item["game_info_list"]),
  };
}

/** model interface DxConfigRequest */
export interface DxConfigRequest {
  launcherId: string;
  language: string;
  gameIds: string[];
  gpuInfo: GpuInfo[];
}

export function dxConfigRequestSerializer(item: DxConfigRequest): any {
  return {
    launcher_id: item["launcherId"],
    language: item["language"],
    game_ids: item["gameIds"].map((p: any) => {
      return p;
    }),
    gpu_info: gpuInfoArraySerializer(item["gpuInfo"]),
  };
}

export function gpuInfoArraySerializer(result: Array<GpuInfo>): any[] {
  return result.map((item) => {
    return gpuInfoSerializer(item);
  });
}

/** model interface GpuInfo */
export interface GpuInfo {
  name?: string;
  vendorId?: number;
  deviceId?: number;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function gpuInfoSerializer(item: GpuInfo): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    name: item["name"],
    vendor_id: item["vendorId"],
    device_id: item["deviceId"],
  };
}
