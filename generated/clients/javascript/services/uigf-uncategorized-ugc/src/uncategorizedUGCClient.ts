// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  UncategorizedUGCContext,
  UncategorizedUGCClientOptionalParams,
  createUncategorizedUGC,
} from "./api/index.js";
import { LevelApiOperations, _getLevelApiOperations } from "./classic/levelApi/index.js";
import { TokenApiOperations, _getTokenApiOperations } from "./classic/tokenApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { UncategorizedUGCClientOptionalParams } from "./api/uncategorizedUGCContext.js";

export class UncategorizedUGCClient {
  private _client: UncategorizedUGCContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: UncategorizedUGCClientOptionalParams = {}) {
    this._client = createUncategorizedUGC(options);
    this.pipeline = this._client.pipeline;
    this.levelApi = _getLevelApiOperations(this._client);
    this.tokenApi = _getTokenApiOperations(this._client);
  }

  /** The operation groups for levelApi */
  public readonly levelApi: LevelApiOperations;
  /** The operation groups for tokenApi */
  public readonly tokenApi: TokenApiOperations;
}
