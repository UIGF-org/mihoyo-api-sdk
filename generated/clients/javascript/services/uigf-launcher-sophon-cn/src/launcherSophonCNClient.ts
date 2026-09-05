// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  LauncherSophonCNContext,
  LauncherSophonCNClientOptionalParams,
  createLauncherSophonCN,
} from "./api/index.js";
import { BuildApiOperations, _getBuildApiOperations } from "./classic/buildApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { LauncherSophonCNClientOptionalParams } from "./api/launcherSophonCNContext.js";

export class LauncherSophonCNClient {
  private _client: LauncherSophonCNContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: LauncherSophonCNClientOptionalParams = {}) {
    this._client = createLauncherSophonCN(options);
    this.pipeline = this._client.pipeline;
    this.buildApi = _getBuildApiOperations(this._client);
  }

  /** The operation groups for buildApi */
  public readonly buildApi: BuildApiOperations;
}
