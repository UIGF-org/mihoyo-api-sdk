// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameCNRecordsContext,
  GameCNRecordsClientOptionalParams,
  createGameCNRecords,
} from "./api/index.js";
import {
  HonkaiImpactApiOperations,
  _getHonkaiImpactApiOperations,
} from "./classic/honkaiImpactApi/index.js";
import { StarRailApiOperations, _getStarRailApiOperations } from "./classic/starRailApi/index.js";
import { ZenlessApiOperations, _getZenlessApiOperations } from "./classic/zenlessApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameCNRecordsClientOptionalParams } from "./api/gameCNRecordsContext.js";

export class GameCNRecordsClient {
  private _client: GameCNRecordsContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameCNRecordsClientOptionalParams = {}) {
    this._client = createGameCNRecords(options);
    this.pipeline = this._client.pipeline;
    this.zenlessApi = _getZenlessApiOperations(this._client);
    this.starRailApi = _getStarRailApiOperations(this._client);
    this.honkaiImpactApi = _getHonkaiImpactApiOperations(this._client);
  }

  /** The operation groups for zenlessApi */
  public readonly zenlessApi: ZenlessApiOperations;
  /** The operation groups for starRailApi */
  public readonly starRailApi: StarRailApiOperations;
  /** The operation groups for honkaiImpactApi */
  public readonly honkaiImpactApi: HonkaiImpactApiOperations;
}
