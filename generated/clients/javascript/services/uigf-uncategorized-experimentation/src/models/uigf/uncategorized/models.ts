// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { ApiResponseArray, jsonObjectArrayDeserializer } from "../models.js";

/** model interface ExperimentListRequest */
export interface ExperimentListRequest {
  appId: number;
  appSign: string;
  params: ExperimentParameter[];
  sceneId: string;
  uid: string;
}

export function experimentListRequestSerializer(item: ExperimentListRequest): any {
  return {
    app_id: item["appId"],
    app_sign: item["appSign"],
    params: experimentParameterArraySerializer(item["params"]),
    scene_id: item["sceneId"],
    uid: item["uid"],
  };
}

export function experimentParameterArraySerializer(result: Array<ExperimentParameter>): any[] {
  return result.map((item) => {
    return experimentParameterSerializer(item);
  });
}

/** model interface ExperimentParameter */
export interface ExperimentParameter {
  k: string;
  v: string;
}

export function experimentParameterSerializer(item: ExperimentParameter): any {
  return { k: item["k"], v: item["v"] };
}

/** model interface ExperimentListResponse */
export interface ExperimentListResponse extends ApiResponseArray {
  success?: boolean;
}

export function experimentListResponseDeserializer(item: any): ExperimentListResponse {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: jsonObjectArrayDeserializer(item["data"]),
    success: item["success"],
  };
}
