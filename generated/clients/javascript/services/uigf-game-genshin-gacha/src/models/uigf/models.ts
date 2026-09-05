// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../static-helpers/serialization/serialize-record.js";

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseGachaLogPage {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: GachaLogPage;
}

export function apiResponseGachaLogPageDeserializer(item: any): ApiResponseGachaLogPage {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: gachaLogPageDeserializer(item["data"]),
  };
}

/** model interface GachaLogPage */
export interface GachaLogPage {
  page?: number;
  size?: number;
  total?: number;
  region?: string;
  list: GachaItem[];
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function gachaLogPageDeserializer(item: any): GachaLogPage {
  return {
    additionalProperties: serializeRecord(item, ["page", "size", "total", "region", "list"]),
    page: item["page"],
    size: item["size"],
    total: item["total"],
    region: item["region"],
    list: gachaItemArrayDeserializer(item["list"]),
  };
}

export function gachaItemArrayDeserializer(result: Array<GachaItem>): any[] {
  return result.map((item) => {
    return gachaItemDeserializer(item);
  });
}

/** model interface GachaItem */
export interface GachaItem {
  uid?: string;
  gachaType?: string;
  itemId?: string;
  count?: string;
  time?: string;
  name?: string;
  itemType?: string;
  rankType?: string;
  id: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function gachaItemDeserializer(item: any): GachaItem {
  return {
    additionalProperties: serializeRecord(item, [
      "uid",
      "gacha_type",
      "item_id",
      "count",
      "time",
      "name",
      "item_type",
      "rank_type",
      "id",
    ]),
    uid: item["uid"],
    gachaType: item["gacha_type"],
    itemId: item["item_id"],
    count: item["count"],
    time: item["time"],
    name: item["name"],
    itemType: item["item_type"],
    rankType: item["rank_type"],
    id: item["id"],
  };
}
