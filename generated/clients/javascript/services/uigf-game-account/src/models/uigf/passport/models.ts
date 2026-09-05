// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../static-helpers/serialization/serialize-record.js";

/** model interface GameTokenRequest */
export interface GameTokenRequest {
  accountId: number;
  gameToken: string;
}

export function gameTokenRequestSerializer(item: GameTokenRequest): any {
  return { account_id: item["accountId"], game_token: item["gameToken"] };
}

/** model interface TokenInfo */
export interface TokenInfo {
  accountId?: number;
  uid?: string;
  token?: string;
  gameToken?: string;
  stoken?: string;
  ltoken?: string;
  cookieToken?: string;
  mid?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function tokenInfoDeserializer(item: any): TokenInfo {
  return {
    additionalProperties: serializeRecord(item, [
      "account_id",
      "uid",
      "token",
      "game_token",
      "stoken",
      "ltoken",
      "cookie_token",
      "mid",
    ]),
    accountId: item["account_id"],
    uid: item["uid"],
    token: item["token"],
    gameToken: item["game_token"],
    stoken: item["stoken"],
    ltoken: item["ltoken"],
    cookieToken: item["cookie_token"],
    mid: item["mid"],
  };
}
