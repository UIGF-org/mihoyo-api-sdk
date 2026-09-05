// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinAnnouncementsContext,
  GameGenshinAnnouncementsClientOptionalParams,
  createGameGenshinAnnouncements,
} from "./api/index.js";
import {
  AnnouncementApiOperations,
  _getAnnouncementApiOperations,
} from "./classic/announcementApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinAnnouncementsClientOptionalParams } from "./api/gameGenshinAnnouncementsContext.js";

export class GameGenshinAnnouncementsClient {
  private _client: GameGenshinAnnouncementsContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinAnnouncementsClientOptionalParams = {}) {
    this._client = createGameGenshinAnnouncements(options);
    this.pipeline = this._client.pipeline;
    this.announcementApi = _getAnnouncementApiOperations(this._client);
  }

  /** The operation groups for announcementApi */
  public readonly announcementApi: AnnouncementApiOperations;
}
