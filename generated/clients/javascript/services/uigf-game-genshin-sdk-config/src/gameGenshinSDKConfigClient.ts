// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinSDKConfigContext,
  GameGenshinSDKConfigClientOptionalParams,
  createGameGenshinSDKConfig,
} from "./api/index.js";
import { ConfigApiOperations, _getConfigApiOperations } from "./classic/configApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinSDKConfigClientOptionalParams } from "./api/gameGenshinSDKConfigContext.js";

export class GameGenshinSDKConfigClient {
  private _client: GameGenshinSDKConfigContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinSDKConfigClientOptionalParams = {}) {
    this._client = createGameGenshinSDKConfig(options);
    this.pipeline = this._client.pipeline;
    this.configApi = _getConfigApiOperations(this._client);
  }

  /** The operation groups for configApi */
  public readonly configApi: ConfigApiOperations;
}
