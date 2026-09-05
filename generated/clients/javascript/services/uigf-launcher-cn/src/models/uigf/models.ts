// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../static-helpers/serialization/serialize-record.js";
import { GameBasicInfo, gameBasicInfoDeserializer } from "./launcher/models.js";

/** Common envelope used by the HoYoPlay and Sophon APIs. */
export interface LauncherResponseGameBasicInfo {
  retcode: number;
  message: string;
  data: GameBasicInfo;
}

export function launcherResponseGameBasicInfoDeserializer(
  item: any,
): LauncherResponseGameBasicInfo {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: gameBasicInfoDeserializer(item["data"]),
  };
}

export function jsonObjectArrayDeserializer(result: Array<JsonObject>): any[] {
  return result.map((item) => {
    return jsonObjectDeserializer(item);
  });
}

/** A JSON object whose vendor-defined properties are preserved by generated clients. */
export interface JsonObject {
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function jsonObjectDeserializer(item: any): JsonObject {
  return {
    additionalProperties: serializeRecord(item, []),
  };
}

/** Common envelope used by the HoYoPlay and Sophon APIs. */
export interface LauncherResponseJsonObject {
  retcode: number;
  message: string;
  data: JsonObject;
}

export function launcherResponseJsonObjectDeserializer(item: any): LauncherResponseJsonObject {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: jsonObjectDeserializer(item["data"]),
  };
}
