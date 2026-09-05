// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  LauncherCNContext,
  LauncherCNClientOptionalParams,
  createLauncherCN,
} from "./api/index.js";
import { MetadataApiOperations, _getMetadataApiOperations } from "./classic/metadataApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { LauncherCNClientOptionalParams } from "./api/launcherCNContext.js";

export class LauncherCNClient {
  private _client: LauncherCNContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: LauncherCNClientOptionalParams = {}) {
    this._client = createLauncherCN(options);
    this.pipeline = this._client.pipeline;
    this.metadataApi = _getMetadataApiOperations(this._client);
  }

  /** The operation groups for metadataApi */
  public readonly metadataApi: MetadataApiOperations;
}
