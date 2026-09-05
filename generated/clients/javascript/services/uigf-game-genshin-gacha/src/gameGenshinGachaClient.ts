// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinGachaContext,
  GameGenshinGachaClientOptionalParams,
  createGameGenshinGacha,
} from "./api/index.js";
import { GachaLogApiOperations, _getGachaLogApiOperations } from "./classic/gachaLogApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinGachaClientOptionalParams } from "./api/gameGenshinGachaContext.js";

export class GameGenshinGachaClient {
  private _client: GameGenshinGachaContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinGachaClientOptionalParams = {}) {
    this._client = createGameGenshinGacha(options);
    this.pipeline = this._client.pipeline;
    this.gachaLogApi = _getGachaLogApiOperations(this._client);
  }

  /** The operation groups for gachaLogApi */
  public readonly gachaLogApi: GachaLogApiOperations;
}
