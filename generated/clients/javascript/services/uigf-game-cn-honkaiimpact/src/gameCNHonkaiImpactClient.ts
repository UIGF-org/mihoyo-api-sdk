// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameCNHonkaiImpactContext,
  GameCNHonkaiImpactClientOptionalParams,
  createGameCNHonkaiImpact,
} from "./api/index.js";
import {
  DailyNoteApiOperations,
  _getDailyNoteApiOperations,
} from "./classic/dailyNoteApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameCNHonkaiImpactClientOptionalParams } from "./api/gameCNHonkaiImpactContext.js";

export class GameCNHonkaiImpactClient {
  private _client: GameCNHonkaiImpactContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameCNHonkaiImpactClientOptionalParams = {}) {
    this._client = createGameCNHonkaiImpact(options);
    this.pipeline = this._client.pipeline;
    this.dailyNoteApi = _getDailyNoteApiOperations(this._client);
  }

  /** The operation groups for dailyNoteApi */
  public readonly dailyNoteApi: DailyNoteApiOperations;
}
