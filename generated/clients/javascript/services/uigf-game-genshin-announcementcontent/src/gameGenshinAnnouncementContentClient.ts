// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinAnnouncementContentContext,
  GameGenshinAnnouncementContentClientOptionalParams,
  createGameGenshinAnnouncementContent,
} from "./api/index.js";
import { ContentApiOperations, _getContentApiOperations } from "./classic/contentApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinAnnouncementContentClientOptionalParams } from "./api/gameGenshinAnnouncementContentContext.js";

export class GameGenshinAnnouncementContentClient {
  private _client: GameGenshinAnnouncementContentContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinAnnouncementContentClientOptionalParams = {}) {
    this._client = createGameGenshinAnnouncementContent(options);
    this.pipeline = this._client.pipeline;
    this.contentApi = _getContentApiOperations(this._client);
  }

  /** The operation groups for contentApi */
  public readonly contentApi: ContentApiOperations;
}
