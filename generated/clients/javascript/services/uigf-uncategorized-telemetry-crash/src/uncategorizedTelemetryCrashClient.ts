// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  UncategorizedTelemetryCrashContext,
  UncategorizedTelemetryCrashClientOptionalParams,
  createUncategorizedTelemetryCrash,
} from "./api/index.js";
import { CrashApiOperations, _getCrashApiOperations } from "./classic/crashApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { UncategorizedTelemetryCrashClientOptionalParams } from "./api/uncategorizedTelemetryCrashContext.js";

export class UncategorizedTelemetryCrashClient {
  private _client: UncategorizedTelemetryCrashContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: UncategorizedTelemetryCrashClientOptionalParams = {}) {
    this._client = createUncategorizedTelemetryCrash(options);
    this.pipeline = this._client.pipeline;
    this.crashApi = _getCrashApiOperations(this._client);
  }

  /** The operation groups for crashApi */
  public readonly crashApi: CrashApiOperations;
}
