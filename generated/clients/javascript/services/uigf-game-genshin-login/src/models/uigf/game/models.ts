// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../static-helpers/serialization/serialize-record.js";

/** model interface PandaQrRequest */
export interface PandaQrRequest {
  appId: number;
  device: string;
  ticket?: string;
}

export function pandaQrRequestSerializer(item: PandaQrRequest): any {
  return { app_id: item["appId"], device: item["device"], ticket: item["ticket"] };
}

/** model interface PandaQrResponse */
export interface PandaQrResponse {
  ticket?: string;
  url?: string;
  stat?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function pandaQrResponseDeserializer(item: any): PandaQrResponse {
  return {
    additionalProperties: serializeRecord(item, ["ticket", "url", "stat"]),
    ticket: item["ticket"],
    url: item["url"],
    stat: item["stat"],
  };
}
