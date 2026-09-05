// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinRecordContext,
  GameGenshinRecordClientOptionalParams,
  createGameGenshinRecord,
} from "./api/index.js";
import { CardApiOperations, _getCardApiOperations } from "./classic/cardApi/index.js";
import {
  GameRecordApiOperations,
  _getGameRecordApiOperations,
} from "./classic/gameRecordApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinRecordClientOptionalParams } from "./api/gameGenshinRecordContext.js";

export class GameGenshinRecordClient {
  private _client: GameGenshinRecordContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinRecordClientOptionalParams = {}) {
    this._client = createGameGenshinRecord(options);
    this.pipeline = this._client.pipeline;
    this.cardApi = _getCardApiOperations(this._client);
    this.gameRecordApi = _getGameRecordApiOperations(this._client);
  }

  /** The operation groups for cardApi */
  public readonly cardApi: CardApiOperations;
  /** The operation groups for gameRecordApi */
  public readonly gameRecordApi: GameRecordApiOperations;
}
