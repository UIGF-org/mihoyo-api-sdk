// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinDispatchRegionListContext,
  GameGenshinDispatchRegionListClientOptionalParams,
  createGameGenshinDispatchRegionList,
} from "./api/index.js";
import {
  RegionListApiOperations,
  _getRegionListApiOperations,
} from "./classic/regionListApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinDispatchRegionListClientOptionalParams } from "./api/gameGenshinDispatchRegionListContext.js";

export class GameGenshinDispatchRegionListClient {
  private _client: GameGenshinDispatchRegionListContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinDispatchRegionListClientOptionalParams = {}) {
    this._client = createGameGenshinDispatchRegionList(options);
    this.pipeline = this._client.pipeline;
    this.regionListApi = _getRegionListApiOperations(this._client);
  }

  /** The operation groups for regionListApi */
  public readonly regionListApi: RegionListApiOperations;
}
