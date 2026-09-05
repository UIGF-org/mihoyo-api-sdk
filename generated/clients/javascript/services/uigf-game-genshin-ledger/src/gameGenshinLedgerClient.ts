// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinLedgerContext,
  GameGenshinLedgerClientOptionalParams,
  createGameGenshinLedger,
} from "./api/index.js";
import { LedgerApiOperations, _getLedgerApiOperations } from "./classic/ledgerApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinLedgerClientOptionalParams } from "./api/gameGenshinLedgerContext.js";

export class GameGenshinLedgerClient {
  private _client: GameGenshinLedgerContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinLedgerClientOptionalParams = {}) {
    this._client = createGameGenshinLedger(options);
    this.pipeline = this._client.pipeline;
    this.ledgerApi = _getLedgerApiOperations(this._client);
  }

  /** The operation groups for ledgerApi */
  public readonly ledgerApi: LedgerApiOperations;
}
