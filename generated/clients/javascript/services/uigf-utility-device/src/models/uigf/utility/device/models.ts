// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../../static-helpers/serialization/serialize-record.js";

/** model interface DeviceExtensionList */
export interface DeviceExtensionList {
  code?: number;
  extList?: string[];
  msg?: string;
  pkgList?: string[];
  pkgStr?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function deviceExtensionListDeserializer(item: any): DeviceExtensionList {
  return {
    additionalProperties: serializeRecord(item, ["code", "ext_list", "msg", "pkg_list", "pkg_str"]),
    code: item["code"],
    extList: !item["ext_list"]
      ? item["ext_list"]
      : item["ext_list"].map((p: any) => {
          return p;
        }),
    msg: item["msg"],
    pkgList: !item["pkg_list"]
      ? item["pkg_list"]
      : item["pkg_list"].map((p: any) => {
          return p;
        }),
    pkgStr: item["pkg_str"],
  };
}
