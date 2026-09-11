// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */

/** model interface H5LogRequest */
export interface H5LogRequest {
  data: string;
}

export function h5LogRequestSerializer(item: H5LogRequest): any {
  return { data: item["data"] };
}
