// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../static-helpers/serialization/serialize-record.js";

/** model interface LunaCheckInRequest */
export interface LunaCheckInRequest {
  actId: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function lunaCheckInRequestSerializer(item: LunaCheckInRequest): any {
  return { ...serializeRecord(item.additionalProperties ?? {}), act_id: item["actId"] };
}
