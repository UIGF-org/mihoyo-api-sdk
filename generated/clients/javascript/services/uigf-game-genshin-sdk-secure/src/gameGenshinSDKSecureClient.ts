// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  GameGenshinSDKSecureContext,
  GameGenshinSDKSecureClientOptionalParams,
  createGameGenshinSDKSecure,
} from "./api/index.js";
import { SecureApiOperations, _getSecureApiOperations } from "./classic/secureApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { GameGenshinSDKSecureClientOptionalParams } from "./api/gameGenshinSDKSecureContext.js";

export class GameGenshinSDKSecureClient {
  private _client: GameGenshinSDKSecureContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: GameGenshinSDKSecureClientOptionalParams = {}) {
    this._client = createGameGenshinSDKSecure(options);
    this.pipeline = this._client.pipeline;
    this.secureApi = _getSecureApiOperations(this._client);
  }

  /** The operation groups for secureApi */
  public readonly secureApi: SecureApiOperations;
}
