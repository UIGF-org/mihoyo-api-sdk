// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGlobalRecordsContext,
  GameGlobalRecordsClientOptionalParams,
  createGameGlobalRecords,
} from "./api/index.js";
import {
  GameRecordApiOperations,
  _getGameRecordApiOperations,
} from "./classic/gameRecordApi/index.js";
import {
  StarRailLedgerApiOperations,
  _getStarRailLedgerApiOperations,
} from "./classic/starRailLedgerApi/index.js";
import {
  ZenlessCultivationApiOperations,
  _getZenlessCultivationApiOperations,
} from "./classic/zenlessCultivationApi/index.js";
import {
  ZenlessGameRecordApiOperations,
  _getZenlessGameRecordApiOperations,
} from "./classic/zenlessGameRecordApi/index.js";
import {
  ZenlessLedgerApiOperations,
  _getZenlessLedgerApiOperations,
} from "./classic/zenlessLedgerApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGlobalRecordsClientOptionalParams } from "./api/gameGlobalRecordsContext.js";

export class GameGlobalRecordsClient {
  private _client: GameGlobalRecordsContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGlobalRecordsClientOptionalParams = {}) {
    this._client = createGameGlobalRecords(options);
    this.pipeline = this._client.pipeline;
    this.zenlessLedgerApi = _getZenlessLedgerApiOperations(this._client);
    this.starRailLedgerApi = _getStarRailLedgerApiOperations(this._client);
    this.zenlessCultivationApi = _getZenlessCultivationApiOperations(this._client);
    this.zenlessGameRecordApi = _getZenlessGameRecordApiOperations(this._client);
    this.gameRecordApi = _getGameRecordApiOperations(this._client);
  }

  /** The operation groups for zenlessLedgerApi */
  public readonly zenlessLedgerApi: ZenlessLedgerApiOperations;
  /** The operation groups for starRailLedgerApi */
  public readonly starRailLedgerApi: StarRailLedgerApiOperations;
  /** The operation groups for zenlessCultivationApi */
  public readonly zenlessCultivationApi: ZenlessCultivationApiOperations;
  /** The operation groups for zenlessGameRecordApi */
  public readonly zenlessGameRecordApi: ZenlessGameRecordApiOperations;
  /** The operation groups for gameRecordApi */
  public readonly gameRecordApi: GameRecordApiOperations;
}
