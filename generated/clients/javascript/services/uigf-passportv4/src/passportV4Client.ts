// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  PassportV4Context,
  PassportV4ClientOptionalParams,
  createPassportV4,
} from "./api/index.js";
import { SessionApiOperations, _getSessionApiOperations } from "./classic/sessionApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { PassportV4ClientOptionalParams } from "./api/passportV4Context.js";

export class PassportV4Client {
  private _client: PassportV4Context;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: PassportV4ClientOptionalParams = {}) {
    this._client = createPassportV4(options);
    this.pipeline = this._client.pipeline;
    this.sessionApi = _getSessionApiOperations(this._client);
  }

  /** The operation groups for sessionApi */
  public readonly sessionApi: SessionApiOperations;
}
