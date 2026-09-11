// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  UncategorizedTelemetryGameContext,
  UncategorizedTelemetryGameClientOptionalParams,
  createUncategorizedTelemetryGame,
} from "./api/index.js";
import {
  PerformanceApiOperations,
  _getPerformanceApiOperations,
} from "./classic/performanceApi/index.js";
import { UploadApiOperations, _getUploadApiOperations } from "./classic/uploadApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { UncategorizedTelemetryGameClientOptionalParams } from "./api/uncategorizedTelemetryGameContext.js";

export class UncategorizedTelemetryGameClient {
  private _client: UncategorizedTelemetryGameContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: UncategorizedTelemetryGameClientOptionalParams = {}) {
    this._client = createUncategorizedTelemetryGame(options);
    this.pipeline = this._client.pipeline;
    this.uploadApi = _getUploadApiOperations(this._client);
    this.performanceApi = _getPerformanceApiOperations(this._client);
  }

  /** The operation groups for uploadApi */
  public readonly uploadApi: UploadApiOperations;
  /** The operation groups for performanceApi */
  public readonly performanceApi: PerformanceApiOperations;
}
