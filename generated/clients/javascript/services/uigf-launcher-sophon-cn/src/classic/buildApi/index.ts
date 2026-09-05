// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { LauncherSophonCNContext } from "../../api/launcherSophonCNContext.js";
import { getPatchBuild, getBuild } from "../../api/buildApi/operations.js";
import {
  BuildApiGetPatchBuildOptionalParams,
  BuildApiGetBuildOptionalParams,
} from "../../api/buildApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a BuildApi operations. */
export interface BuildApiOperations {
  getPatchBuild: (
    branch: string,
    packageId: string,
    password: string,
    options?: BuildApiGetPatchBuildOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getBuild: (
    branch: string,
    packageId: string,
    password: string,
    options?: BuildApiGetBuildOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getBuildApi(context: LauncherSophonCNContext) {
  return {
    getPatchBuild: (
      branch: string,
      packageId: string,
      password: string,
      options?: BuildApiGetPatchBuildOptionalParams,
    ) => getPatchBuild(context, branch, packageId, password, options),
    getBuild: (
      branch: string,
      packageId: string,
      password: string,
      options?: BuildApiGetBuildOptionalParams,
    ) => getBuild(context, branch, packageId, password, options),
  };
}

export function _getBuildApiOperations(context: LauncherSophonCNContext): BuildApiOperations {
  return {
    ..._getBuildApi(context),
  };
}
