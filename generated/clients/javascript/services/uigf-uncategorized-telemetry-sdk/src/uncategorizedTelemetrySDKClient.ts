// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  UncategorizedTelemetrySDKContext,
  UncategorizedTelemetrySDKClientOptionalParams,
  createUncategorizedTelemetrySDK,
} from "./api/index.js";
import { UploadApiOperations, _getUploadApiOperations } from "./classic/uploadApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { UncategorizedTelemetrySDKClientOptionalParams } from "./api/uncategorizedTelemetrySDKContext.js";

export class UncategorizedTelemetrySDKClient {
  private _client: UncategorizedTelemetrySDKContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: UncategorizedTelemetrySDKClientOptionalParams = {}) {
    this._client = createUncategorizedTelemetrySDK(options);
    this.pipeline = this._client.pipeline;
    this.uploadApi = _getUploadApiOperations(this._client);
  }

  /** The operation groups for uploadApi */
  public readonly uploadApi: UploadApiOperations;
}
