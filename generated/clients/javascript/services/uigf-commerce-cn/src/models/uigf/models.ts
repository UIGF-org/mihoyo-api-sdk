// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../static-helpers/serialization/serialize-record.js";
import {
  ShopGoods,
  shopGoodsDeserializer,
  OrderStatus,
  orderStatusDeserializer,
} from "./commerce/models.js";

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseShopGoods {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: ShopGoods;
}

export function apiResponseShopGoodsDeserializer(item: any): ApiResponseShopGoods {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: shopGoodsDeserializer(item["data"]),
  };
}

/** A JSON object whose vendor-defined properties are preserved by generated clients. */
export interface JsonObject {
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function jsonObjectSerializer(item: JsonObject): any {
  return { ...serializeRecord(item.additionalProperties ?? {}) };
}

export function jsonObjectDeserializer(item: any): JsonObject {
  return {
    additionalProperties: serializeRecord(item, []),
  };
}

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseJsonObject {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: JsonObject;
}

export function apiResponseJsonObjectDeserializer(item: any): ApiResponseJsonObject {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: jsonObjectDeserializer(item["data"]),
  };
}

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseOrderStatus {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: OrderStatus;
}

export function apiResponseOrderStatusDeserializer(item: any): ApiResponseOrderStatus {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: orderStatusDeserializer(item["data"]),
  };
}
