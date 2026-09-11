// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */

/** model interface ProtocolVersionRequest */
export interface ProtocolVersionRequest {
  appId: string;
  channelId: string;
  language: string;
  major: string;
  minimum: string;
}

export function protocolVersionRequestSerializer(item: ProtocolVersionRequest): any {
  return {
    app_id: item["appId"],
    channel_id: item["channelId"],
    language: item["language"],
    major: item["major"],
    minimum: item["minimum"],
  };
}

/** model interface RedDotRequest */
export interface RedDotRequest {
  gameBiz: string;
  playerLevel: number;
  region: string;
  uid: string;
}

export function redDotRequestSerializer(item: RedDotRequest): any {
  return {
    game_biz: item["gameBiz"],
    player_level: item["playerLevel"],
    region: item["region"],
    uid: item["uid"],
  };
}
