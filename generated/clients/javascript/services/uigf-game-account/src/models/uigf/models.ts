// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../static-helpers/serialization/serialize-record.js";
import { TokenInfo, tokenInfoDeserializer } from "./passport/models.js";

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseTokenInfo {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: TokenInfo;
}

export function apiResponseTokenInfoDeserializer(item: any): ApiResponseTokenInfo {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: tokenInfoDeserializer(item["data"]),
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

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseGameRoleList {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: GameRoleList;
}

export function apiResponseGameRoleListDeserializer(item: any): ApiResponseGameRoleList {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: gameRoleListDeserializer(item["data"]),
  };
}

/** model interface GameRoleList */
export interface GameRoleList {
  list: GameRole[];
}

export function gameRoleListDeserializer(item: any): GameRoleList {
  return {
    list: gameRoleArrayDeserializer(item["list"]),
  };
}

export function gameRoleArrayDeserializer(result: Array<GameRole>): any[] {
  return result.map((item) => {
    return gameRoleDeserializer(item);
  });
}

/** Standard game account identity reused by record APIs. */
export interface GameRole {
  gameBiz: string;
  region: string;
  gameUid: string;
  nickname?: string;
  level?: number;
  isChosen?: boolean;
  regionName?: string;
  gameName?: string;
}

export function gameRoleDeserializer(item: any): GameRole {
  return {
    gameBiz: item["game_biz"],
    region: item["region"],
    gameUid: item["game_uid"],
    nickname: item["nickname"],
    level: item["level"],
    isChosen: item["is_chosen"],
    regionName: item["region_name"],
    gameName: item["game_name"],
  };
}
