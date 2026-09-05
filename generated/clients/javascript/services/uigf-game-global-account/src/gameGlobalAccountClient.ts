// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGlobalAccountContext,
  GameGlobalAccountClientOptionalParams,
  createGameGlobalAccount,
} from "./api/index.js";
import { BindingApiOperations, _getBindingApiOperations } from "./classic/bindingApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGlobalAccountClientOptionalParams } from "./api/gameGlobalAccountContext.js";

export class GameGlobalAccountClient {
  private _client: GameGlobalAccountContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGlobalAccountClientOptionalParams = {}) {
    this._client = createGameGlobalAccount(options);
    this.pipeline = this._client.pipeline;
    this.bindingApi = _getBindingApiOperations(this._client);
  }

  /** The operation groups for bindingApi */
  public readonly bindingApi: BindingApiOperations;
}
