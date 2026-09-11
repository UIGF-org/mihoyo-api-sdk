// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  UncategorizedTelemetryH5Context,
  UncategorizedTelemetryH5ClientOptionalParams,
  createUncategorizedTelemetryH5,
} from "./api/index.js";
import { BatchApiOperations, _getBatchApiOperations } from "./classic/batchApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { UncategorizedTelemetryH5ClientOptionalParams } from "./api/uncategorizedTelemetryH5Context.js";

export class UncategorizedTelemetryH5Client {
  private _client: UncategorizedTelemetryH5Context;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: UncategorizedTelemetryH5ClientOptionalParams = {}) {
    this._client = createUncategorizedTelemetryH5(options);
    this.pipeline = this._client.pipeline;
    this.batchApi = _getBatchApiOperations(this._client);
  }

  /** The operation groups for batchApi */
  public readonly batchApi: BatchApiOperations;
}
