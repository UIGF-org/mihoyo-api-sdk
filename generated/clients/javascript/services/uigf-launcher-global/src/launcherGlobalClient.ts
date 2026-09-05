// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  LauncherGlobalContext,
  LauncherGlobalClientOptionalParams,
  createLauncherGlobal,
} from "./api/index.js";
import { MetadataApiOperations, _getMetadataApiOperations } from "./classic/metadataApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { LauncherGlobalClientOptionalParams } from "./api/launcherGlobalContext.js";

export class LauncherGlobalClient {
  private _client: LauncherGlobalContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: LauncherGlobalClientOptionalParams = {}) {
    this._client = createLauncherGlobal(options);
    this.pipeline = this._client.pipeline;
    this.metadataApi = _getMetadataApiOperations(this._client);
  }

  /** The operation groups for metadataApi */
  public readonly metadataApi: MetadataApiOperations;
}
