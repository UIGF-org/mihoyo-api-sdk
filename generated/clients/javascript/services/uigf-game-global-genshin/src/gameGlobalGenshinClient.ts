// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGlobalGenshinContext,
  GameGlobalGenshinClientOptionalParams,
  createGameGlobalGenshin,
} from "./api/index.js";
import {
  AnnouncementApiOperations,
  _getAnnouncementApiOperations,
} from "./classic/announcementApi/index.js";
import { LedgerApiOperations, _getLedgerApiOperations } from "./classic/ledgerApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGlobalGenshinClientOptionalParams } from "./api/gameGlobalGenshinContext.js";

export class GameGlobalGenshinClient {
  private _client: GameGlobalGenshinContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGlobalGenshinClientOptionalParams = {}) {
    this._client = createGameGlobalGenshin(options);
    this.pipeline = this._client.pipeline;
    this.ledgerApi = _getLedgerApiOperations(this._client);
    this.announcementApi = _getAnnouncementApiOperations(this._client);
  }

  /** The operation groups for ledgerApi */
  public readonly ledgerApi: LedgerApiOperations;
  /** The operation groups for announcementApi */
  public readonly announcementApi: AnnouncementApiOperations;
}
