// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  UtilityDeviceContext,
  UtilityDeviceClientOptionalParams,
  createUtilityDevice,
} from "./api/index.js";
import {
  FingerprintApiOperations,
  _getFingerprintApiOperations,
} from "./classic/fingerprintApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { UtilityDeviceClientOptionalParams } from "./api/utilityDeviceContext.js";

export class UtilityDeviceClient {
  private _client: UtilityDeviceContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: UtilityDeviceClientOptionalParams = {}) {
    this._client = createUtilityDevice(options);
    this.pipeline = this._client.pipeline;
    this.fingerprintApi = _getFingerprintApiOperations(this._client);
  }

  /** The operation groups for fingerprintApi */
  public readonly fingerprintApi: FingerprintApiOperations;
}
