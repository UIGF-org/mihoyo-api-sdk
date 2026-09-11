// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  UncategorizedExperimentationContext,
  UncategorizedExperimentationClientOptionalParams,
  createUncategorizedExperimentation,
} from "./api/index.js";
import {
  ExperimentApiOperations,
  _getExperimentApiOperations,
} from "./classic/experimentApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { UncategorizedExperimentationClientOptionalParams } from "./api/uncategorizedExperimentationContext.js";

export class UncategorizedExperimentationClient {
  private _client: UncategorizedExperimentationContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: UncategorizedExperimentationClientOptionalParams = {}) {
    this._client = createUncategorizedExperimentation(options);
    this.pipeline = this._client.pipeline;
    this.experimentApi = _getExperimentApiOperations(this._client);
  }

  /** The operation groups for experimentApi */
  public readonly experimentApi: ExperimentApiOperations;
}
