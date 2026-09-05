// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinLoginContext,
  GameGenshinLoginClientOptionalParams,
  createGameGenshinLogin,
} from "./api/index.js";
import { PandaQrApiOperations, _getPandaQrApiOperations } from "./classic/pandaQrApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinLoginClientOptionalParams } from "./api/gameGenshinLoginContext.js";

export class GameGenshinLoginClient {
  private _client: GameGenshinLoginContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinLoginClientOptionalParams = {}) {
    this._client = createGameGenshinLogin(options);
    this.pipeline = this._client.pipeline;
    this.pandaQrApi = _getPandaQrApiOperations(this._client);
  }

  /** The operation groups for pandaQrApi */
  public readonly pandaQrApi: PandaQrApiOperations;
}
