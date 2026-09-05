// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import {
  CommerceCNContext,
  CommerceCNClientOptionalParams,
  createCommerceCN,
} from "./api/index.js";
import { ShopApiOperations, _getShopApiOperations } from "./classic/shopApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { CommerceCNClientOptionalParams } from "./api/commerceCNContext.js";

export class CommerceCNClient {
  private _client: CommerceCNContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(endpointParam: string, options: CommerceCNClientOptionalParams = {}) {
    this._client = createCommerceCN(endpointParam, options);
    this.pipeline = this._client.pipeline;
    this.shopApi = _getShopApiOperations(this._client);
  }

  /** The operation groups for shopApi */
  public readonly shopApi: ShopApiOperations;
}
