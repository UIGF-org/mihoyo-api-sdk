// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CheckInContext, CheckInClientOptionalParams, createCheckIn } from "./api/index.js";
import { CheckInApiOperations, _getCheckInApiOperations } from "./classic/checkInApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { CheckInClientOptionalParams } from "./api/checkInContext.js";

export class CheckInClient {
  private _client: CheckInContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: CheckInClientOptionalParams = {}) {
    this._client = createCheckIn(options);
    this.pipeline = this._client.pipeline;
    this.checkInApi = _getCheckInApiOperations(this._client);
  }

  /** The operation groups for checkInApi */
  public readonly checkInApi: CheckInApiOperations;
}
