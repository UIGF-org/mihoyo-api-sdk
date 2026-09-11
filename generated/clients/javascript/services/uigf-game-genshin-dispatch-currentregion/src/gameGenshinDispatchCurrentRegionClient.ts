// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinDispatchCurrentRegionContext,
  GameGenshinDispatchCurrentRegionClientOptionalParams,
  createGameGenshinDispatchCurrentRegion,
} from "./api/index.js";
import {
  CurrentRegionApiOperations,
  _getCurrentRegionApiOperations,
} from "./classic/currentRegionApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinDispatchCurrentRegionClientOptionalParams } from "./api/gameGenshinDispatchCurrentRegionContext.js";

export class GameGenshinDispatchCurrentRegionClient {
  private _client: GameGenshinDispatchCurrentRegionContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinDispatchCurrentRegionClientOptionalParams = {}) {
    this._client = createGameGenshinDispatchCurrentRegion(options);
    this.pipeline = this._client.pipeline;
    this.currentRegionApi = _getCurrentRegionApiOperations(this._client);
  }

  /** The operation groups for currentRegionApi */
  public readonly currentRegionApi: CurrentRegionApiOperations;
}
