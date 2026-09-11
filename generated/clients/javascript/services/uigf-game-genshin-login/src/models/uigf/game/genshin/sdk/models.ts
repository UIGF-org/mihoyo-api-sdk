// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */

/** model interface GranterLoginRequest */
export interface GranterLoginRequest {
  appId: string;
  channelId: string;
  data: string;
  device: string;
  sign: string;
}

export function granterLoginRequestSerializer(item: GranterLoginRequest): any {
  return {
    app_id: item["appId"],
    channel_id: item["channelId"],
    data: item["data"],
    device: item["device"],
    sign: item["sign"],
  };
}
