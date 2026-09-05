// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { LauncherSophonGlobalContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { BuildApiGetPatchBuildOptionalParams, BuildApiGetBuildOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getPatchBuildSend(
  context: Client,
  branch: string,
  packageId: string,
  password: string,
  options: BuildApiGetPatchBuildOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/downloader/sophon_chunk/api/getPatchBuild{?branch,package_id,password,tag}",
    {
      branch: branch,
      package_id: packageId,
      password: password,
      tag: options?.tag,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .post({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getPatchBuildDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getPatchBuild(
  context: Client,
  branch: string,
  packageId: string,
  password: string,
  options: BuildApiGetPatchBuildOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getPatchBuildSend(context, branch, packageId, password, options);
  return _getPatchBuildDeserialize(result);
}

export function _getBuildSend(
  context: Client,
  branch: string,
  packageId: string,
  password: string,
  options: BuildApiGetBuildOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/downloader/sophon_chunk/api/getBuild{?branch,package_id,password,tag}",
    {
      branch: branch,
      package_id: packageId,
      password: password,
      tag: options?.tag,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _getBuildDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getBuild(
  context: Client,
  branch: string,
  packageId: string,
  password: string,
  options: BuildApiGetBuildOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getBuildSend(context, branch, packageId, password, options);
  return _getBuildDeserialize(result);
}
