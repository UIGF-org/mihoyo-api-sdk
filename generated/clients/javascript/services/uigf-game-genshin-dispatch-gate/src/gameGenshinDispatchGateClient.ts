// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinDispatchGateContext,
  GameGenshinDispatchGateClientOptionalParams,
  createGameGenshinDispatchGate,
} from "./api/index.js";
import { GateApiOperations, _getGateApiOperations } from "./classic/gateApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinDispatchGateClientOptionalParams } from "./api/gameGenshinDispatchGateContext.js";

export class GameGenshinDispatchGateClient {
  private _client: GameGenshinDispatchGateContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinDispatchGateClientOptionalParams = {}) {
    this._client = createGameGenshinDispatchGate(options);
    this.pipeline = this._client.pipeline;
    this.gateApi = _getGateApiOperations(this._client);
  }

  /** The operation groups for gateApi */
  public readonly gateApi: GateApiOperations;
}
