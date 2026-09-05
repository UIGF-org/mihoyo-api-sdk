// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { CommerceCNClient } from "./commerceCNClient.js";
export type {
  ApiResponseShopGoods,
  JsonObject,
  ApiResponseJsonObject,
  ApiResponseOrderStatus,
} from "./models/uigf/index.js";
export type {
  ShopGoodsRequest,
  ShopGoods,
  ShopGood,
  BonusDescription,
  CreateOrderRequest,
  OrderStatus,
} from "./models/uigf/commerce/index.js";
export type { CommerceCNClientOptionalParams } from "./api/index.js";
export type {
  ShopApiCheckOrderOptionalParams,
  ShopApiCreateOrderOptionalParams,
  ShopApiFetchGoodsOptionalParams,
} from "./api/shopApi/index.js";
export type { ShopApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
