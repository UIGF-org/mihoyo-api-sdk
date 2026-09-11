// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../static-helpers/serialization/serialize-record.js";
import { JsonObject, jsonObjectDeserializer } from "../models.js";

/** model interface AuthTicketRequest */
export interface AuthTicketRequest extends DeviceContext {
  gameBiz: string;
}

export function authTicketRequestSerializer(item: AuthTicketRequest): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    device: item["device"],
    device_fp: item["deviceFp"],
    device_name: item["deviceName"],
    device_model: item["deviceModel"],
    device_id: item["deviceId"],
    app_id: item["appId"],
    game_biz: item["gameBiz"],
  };
}

/** model interface DeviceContext */
export interface DeviceContext {
  device: string;
  deviceFp?: string;
  deviceName?: string;
  deviceModel?: string;
  deviceId?: string;
  appId?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function deviceContextSerializer(item: DeviceContext): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    device: item["device"],
    device_fp: item["deviceFp"],
    device_name: item["deviceName"],
    device_model: item["deviceModel"],
    device_id: item["deviceId"],
    app_id: item["appId"],
  };
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

/** model interface LoginCaptchaRequest */
export interface LoginCaptchaRequest extends DeviceContext {
  actionType: string;
  gameBiz?: string;
}

export function loginCaptchaRequestSerializer(item: LoginCaptchaRequest): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    device: item["device"],
    device_fp: item["deviceFp"],
    device_name: item["deviceName"],
    device_model: item["deviceModel"],
    device_id: item["deviceId"],
    app_id: item["appId"],
    action_type: item["actionType"],
    game_biz: item["gameBiz"],
  };
}

/** model interface QrLoginCreateRequest */
export interface QrLoginCreateRequest extends DeviceContext {
  appId: string;
}

export function qrLoginCreateRequestSerializer(item: QrLoginCreateRequest): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    device: item["device"],
    device_fp: item["deviceFp"],
    device_name: item["deviceName"],
    device_model: item["deviceModel"],
    device_id: item["deviceId"],
    app_id: item["appId"],
  };
}

/** model interface QrLoginTicket */
export interface QrLoginTicket {
  ticket: string;
  url?: string;
  expiresIn?: number;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function qrLoginTicketDeserializer(item: any): QrLoginTicket {
  return {
    additionalProperties: serializeRecord(item, ["ticket", "url", "expires_in"]),
    ticket: item["ticket"],
    url: item["url"],
    expiresIn: item["expires_in"],
  };
}

/** model interface QrLoginStatusRequest */
export interface QrLoginStatusRequest extends DeviceContext {
  ticket: string;
  appId: string;
}

export function qrLoginStatusRequestSerializer(item: QrLoginStatusRequest): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    device: item["device"],
    device_fp: item["deviceFp"],
    device_name: item["deviceName"],
    device_model: item["deviceModel"],
    device_id: item["deviceId"],
    app_id: item["appId"],
    ticket: item["ticket"],
  };
}

/** model interface QrLoginStatus */
export interface QrLoginStatus {
  stat?: string;
  status?: string;
  payload?: JsonObject;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function qrLoginStatusDeserializer(item: any): QrLoginStatus {
  return {
    additionalProperties: serializeRecord(item, ["stat", "status", "payload"]),
    stat: item["stat"],
    status: item["status"],
    payload: !item["payload"] ? item["payload"] : jsonObjectDeserializer(item["payload"]),
  };
}

/** model interface MobileCaptchaLoginRequest */
export interface MobileCaptchaLoginRequest extends DeviceContext {
  mobile: string;
  mobileCaptcha: string;
  actionTicket?: string;
  gameBiz?: string;
}

export function mobileCaptchaLoginRequestSerializer(item: MobileCaptchaLoginRequest): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    device: item["device"],
    device_fp: item["deviceFp"],
    device_name: item["deviceName"],
    device_model: item["deviceModel"],
    device_id: item["deviceId"],
    app_id: item["appId"],
    mobile: item["mobile"],
    mobile_captcha: item["mobileCaptcha"],
    action_ticket: item["actionTicket"],
    game_biz: item["gameBiz"],
  };
}

/** model interface AuthTicketLoginRequest */
export interface AuthTicketLoginRequest {
  ticket: string;
}

export function authTicketLoginRequestSerializer(item: AuthTicketLoginRequest): any {
  return { ticket: item["ticket"] };
}

/** model interface GameTokenRequest */
export interface GameTokenRequest {
  accountId: number;
  gameToken: string;
}

export function gameTokenRequestSerializer(item: GameTokenRequest): any {
  return { account_id: item["accountId"], game_token: item["gameToken"] };
}

/** model interface TokenExchangeRequest */
export interface TokenExchangeRequest {
  dstTokenType: string;
  mid: string;
  srcToken: string;
}

export function tokenExchangeRequestSerializer(item: TokenExchangeRequest): any {
  return { dst_token_type: item["dstTokenType"], mid: item["mid"], src_token: item["srcToken"] };
}
