// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameCNEventsContext,
  GameCNEventsClientOptionalParams,
  createGameCNEvents,
} from "./api/index.js";
import {
  StarRailLedgerApiOperations,
  _getStarRailLedgerApiOperations,
} from "./classic/starRailLedgerApi/index.js";
import {
  ZenlessCultivationApiOperations,
  _getZenlessCultivationApiOperations,
} from "./classic/zenlessCultivationApi/index.js";
import {
  ZenlessLedgerApiOperations,
  _getZenlessLedgerApiOperations,
} from "./classic/zenlessLedgerApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameCNEventsClientOptionalParams } from "./api/gameCNEventsContext.js";

export class GameCNEventsClient {
  private _client: GameCNEventsContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameCNEventsClientOptionalParams = {}) {
    this._client = createGameCNEvents(options);
    this.pipeline = this._client.pipeline;
    this.zenlessCultivationApi = _getZenlessCultivationApiOperations(this._client);
    this.zenlessLedgerApi = _getZenlessLedgerApiOperations(this._client);
    this.starRailLedgerApi = _getStarRailLedgerApiOperations(this._client);
  }

  /** The operation groups for zenlessCultivationApi */
  public readonly zenlessCultivationApi: ZenlessCultivationApiOperations;
  /** The operation groups for zenlessLedgerApi */
  public readonly zenlessLedgerApi: ZenlessLedgerApiOperations;
  /** The operation groups for starRailLedgerApi */
  public readonly starRailLedgerApi: StarRailLedgerApiOperations;
}
