// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../static-helpers/serialization/serialize-record.js";
import { JsonObject, jsonObjectSerializer } from "../models.js";

/** model interface ShopGoodsRequest */
export interface ShopGoodsRequest {
  releasedFlag?: boolean;
  game: string;
  region: string;
  uid: string;
  account: string;
}

export function shopGoodsRequestSerializer(item: ShopGoodsRequest): any {
  return {
    released_flag: item["releasedFlag"],
    game: item["game"],
    region: item["region"],
    uid: item["uid"],
    account: item["account"],
  };
}

/** model interface ShopGoods */
export interface ShopGoods {
  goodsList: ShopGood[];
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function shopGoodsDeserializer(item: any): ShopGoods {
  return {
    additionalProperties: serializeRecord(item, ["goods_list"]),
    goodsList: shopGoodArrayDeserializer(item["goods_list"]),
  };
}

export function shopGoodArrayDeserializer(result: Array<ShopGood>): any[] {
  return result.map((item) => {
    return shopGoodDeserializer(item);
  });
}

/** model interface ShopGood */
export interface ShopGood {
  goodsId: string;
  goodsName: string;
  goodsType?: string;
  goodsUnit?: string;
  goodsIcon?: string;
  currency?: string;
  price?: string;
  symbol?: string;
  tierId?: string;
  bonusDesc?: BonusDescription;
  onceBonusDesc?: BonusDescription;
  available?: boolean;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function shopGoodDeserializer(item: any): ShopGood {
  return {
    additionalProperties: serializeRecord(item, [
      "goods_id",
      "goods_name",
      "goods_type",
      "goods_unit",
      "goods_icon",
      "currency",
      "price",
      "symbol",
      "tier_id",
      "bonus_desc",
      "once_bonus_desc",
      "available",
    ]),
    goodsId: item["goods_id"],
    goodsName: item["goods_name"],
    goodsType: item["goods_type"],
    goodsUnit: item["goods_unit"],
    goodsIcon: item["goods_icon"],
    currency: item["currency"],
    price: item["price"],
    symbol: item["symbol"],
    tierId: item["tier_id"],
    bonusDesc: !item["bonus_desc"]
      ? item["bonus_desc"]
      : bonusDescriptionDeserializer(item["bonus_desc"]),
    onceBonusDesc: !item["once_bonus_desc"]
      ? item["once_bonus_desc"]
      : bonusDescriptionDeserializer(item["once_bonus_desc"]),
    available: item["available"],
  };
}

/** model interface BonusDescription */
export interface BonusDescription {
  bonusDesc?: string;
  bonusUnit?: number;
  bonusGoodsId?: string;
  bonusIcon?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function bonusDescriptionDeserializer(item: any): BonusDescription {
  return {
    additionalProperties: serializeRecord(item, [
      "bonus_desc",
      "bonus_unit",
      "bonus_goods_id",
      "bonus_icon",
    ]),
    bonusDesc: item["bonus_desc"],
    bonusUnit: item["bonus_unit"],
    bonusGoodsId: item["bonus_goods_id"],
    bonusIcon: item["bonus_icon"],
  };
}

/**
 * Vendor-signed order creation payload. `sign` must come from an authorized
 * official client or payment integration; this SDK intentionally does not
 * implement signing or retain payment secrets.
 */
export interface CreateOrderRequest {
  openId?: string;
  specialInfo?: string;
  order: JsonObject;
  sign: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function createOrderRequestSerializer(item: CreateOrderRequest): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    open_id: item["openId"],
    special_info: item["specialInfo"],
    order: jsonObjectSerializer(item["order"]),
    sign: item["sign"],
  };
}

/** model interface OrderStatus */
export interface OrderStatus {
  status?: number;
  amount?: string;
  goodsNum?: string;
  goodsTitle?: string;
  orderNo?: string;
  payPlat?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function orderStatusDeserializer(item: any): OrderStatus {
  return {
    additionalProperties: serializeRecord(item, [
      "status",
      "amount",
      "goods_num",
      "goods_title",
      "order_no",
      "pay_plat",
    ]),
    status: item["status"],
    amount: item["amount"],
    goodsNum: item["goods_num"],
    goodsTitle: item["goods_title"],
    orderNo: item["order_no"],
    payPlat: item["pay_plat"],
  };
}
