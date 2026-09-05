// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { PandaQrResponse, pandaQrResponseDeserializer } from "./game/models.js";

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponsePandaQrResponse {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: PandaQrResponse;
}

export function apiResponsePandaQrResponseDeserializer(item: any): ApiResponsePandaQrResponse {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: pandaQrResponseDeserializer(item["data"]),
  };
}
