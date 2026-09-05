// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../static-helpers/serialization/serialize-record.js";

/** model interface AuthKeyRequest */
export interface AuthKeyRequest {
  authAppid: string;
  gameBiz: string;
  gameUid: string;
  region: string;
}

export function authKeyRequestSerializer(item: AuthKeyRequest): any {
  return {
    auth_appid: item["authAppid"],
    game_biz: item["gameBiz"],
    game_uid: item["gameUid"],
    region: item["region"],
  };
}

/** model interface CalculateRequest */
export interface CalculateRequest {
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function calculateRequestSerializer(item: CalculateRequest): any {
  return { ...serializeRecord(item.additionalProperties ?? {}) };
}
