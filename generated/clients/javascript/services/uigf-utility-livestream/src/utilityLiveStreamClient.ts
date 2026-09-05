// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  UtilityLiveStreamContext,
  UtilityLiveStreamClientOptionalParams,
  createUtilityLiveStream,
} from "./api/index.js";
import {
  RedemptionCodeApiOperations,
  _getRedemptionCodeApiOperations,
} from "./classic/redemptionCodeApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { UtilityLiveStreamClientOptionalParams } from "./api/utilityLiveStreamContext.js";

export class UtilityLiveStreamClient {
  private _client: UtilityLiveStreamContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: UtilityLiveStreamClientOptionalParams = {}) {
    this._client = createUtilityLiveStream(options);
    this.pipeline = this._client.pipeline;
    this.redemptionCodeApi = _getRedemptionCodeApiOperations(this._client);
  }

  /** The operation groups for redemptionCodeApi */
  public readonly redemptionCodeApi: RedemptionCodeApiOperations;
}
