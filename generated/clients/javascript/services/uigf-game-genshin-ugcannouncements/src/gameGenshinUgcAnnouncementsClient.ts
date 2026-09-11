// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinUgcAnnouncementsContext,
  GameGenshinUgcAnnouncementsClientOptionalParams,
  createGameGenshinUgcAnnouncements,
} from "./api/index.js";
import { UgcApiOperations, _getUgcApiOperations } from "./classic/ugcApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinUgcAnnouncementsClientOptionalParams } from "./api/gameGenshinUgcAnnouncementsContext.js";

export class GameGenshinUgcAnnouncementsClient {
  private _client: GameGenshinUgcAnnouncementsContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinUgcAnnouncementsClientOptionalParams = {}) {
    this._client = createGameGenshinUgcAnnouncements(options);
    this.pipeline = this._client.pipeline;
    this.ugcApi = _getUgcApiOperations(this._client);
  }

  /** The operation groups for ugcApi */
  public readonly ugcApi: UgcApiOperations;
}
