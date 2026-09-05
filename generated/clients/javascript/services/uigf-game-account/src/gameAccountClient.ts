// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameAccountContext,
  GameAccountClientOptionalParams,
  createGameAccount,
} from "./api/index.js";
import {
  ActionTicketApiOperations,
  _getActionTicketApiOperations,
} from "./classic/actionTicketApi/index.js";
import { BindingApiOperations, _getBindingApiOperations } from "./classic/bindingApi/index.js";
import {
  CultivationApiOperations,
  _getCultivationApiOperations,
} from "./classic/cultivationApi/index.js";
import {
  GameTokenApiOperations,
  _getGameTokenApiOperations,
} from "./classic/gameTokenApi/index.js";
import {
  GenshinObcApiOperations,
  _getGenshinObcApiOperations,
} from "./classic/genshinObcApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameAccountClientOptionalParams } from "./api/gameAccountContext.js";

export class GameAccountClient {
  private _client: GameAccountContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameAccountClientOptionalParams = {}) {
    this._client = createGameAccount(options);
    this.pipeline = this._client.pipeline;
    this.cultivationApi = _getCultivationApiOperations(this._client);
    this.genshinObcApi = _getGenshinObcApiOperations(this._client);
    this.bindingApi = _getBindingApiOperations(this._client);
    this.actionTicketApi = _getActionTicketApiOperations(this._client);
    this.gameTokenApi = _getGameTokenApiOperations(this._client);
  }

  /** The operation groups for cultivationApi */
  public readonly cultivationApi: CultivationApiOperations;
  /** The operation groups for genshinObcApi */
  public readonly genshinObcApi: GenshinObcApiOperations;
  /** The operation groups for bindingApi */
  public readonly bindingApi: BindingApiOperations;
  /** The operation groups for actionTicketApi */
  public readonly actionTicketApi: ActionTicketApiOperations;
  /** The operation groups for gameTokenApi */
  public readonly gameTokenApi: GameTokenApiOperations;
}
