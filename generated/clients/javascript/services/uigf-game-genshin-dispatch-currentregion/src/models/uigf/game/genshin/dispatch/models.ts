// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */

/** model interface SignedDispatchResponse */
export interface SignedDispatchResponse {
  content: string;
  sign: string;
}

export function signedDispatchResponseDeserializer(item: any): SignedDispatchResponse {
  return {
    content: item["content"],
    sign: item["sign"],
  };
}
