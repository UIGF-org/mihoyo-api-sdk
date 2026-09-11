// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  UncategorizedComboTokenContext,
  UncategorizedComboTokenClientOptionalParams,
  createUncategorizedComboToken,
} from "./api/index.js";
import {
  ComboTokenApiOperations,
  _getComboTokenApiOperations,
} from "./classic/comboTokenApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { UncategorizedComboTokenClientOptionalParams } from "./api/uncategorizedComboTokenContext.js";

export class UncategorizedComboTokenClient {
  private _client: UncategorizedComboTokenContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: UncategorizedComboTokenClientOptionalParams = {}) {
    this._client = createUncategorizedComboToken(options);
    this.pipeline = this._client.pipeline;
    this.comboTokenApi = _getComboTokenApiOperations(this._client);
  }

  /** The operation groups for comboTokenApi */
  public readonly comboTokenApi: ComboTokenApiOperations;
}
