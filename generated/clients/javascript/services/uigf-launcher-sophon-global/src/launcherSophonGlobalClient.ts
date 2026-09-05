// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  LauncherSophonGlobalContext,
  LauncherSophonGlobalClientOptionalParams,
  createLauncherSophonGlobal,
} from "./api/index.js";
import { BuildApiOperations, _getBuildApiOperations } from "./classic/buildApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { LauncherSophonGlobalClientOptionalParams } from "./api/launcherSophonGlobalContext.js";

export class LauncherSophonGlobalClient {
  private _client: LauncherSophonGlobalContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: LauncherSophonGlobalClientOptionalParams = {}) {
    this._client = createLauncherSophonGlobal(options);
    this.pipeline = this._client.pipeline;
    this.buildApi = _getBuildApiOperations(this._client);
  }

  /** The operation groups for buildApi */
  public readonly buildApi: BuildApiOperations;
}
