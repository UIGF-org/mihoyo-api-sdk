// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext, CommunityClientOptionalParams, createCommunity } from "./api/index.js";
import { ApiHubOperations, _getApiHubOperations } from "./classic/apiHub/index.js";
import {
  CoinRecordApiOperations,
  _getCoinRecordApiOperations,
} from "./classic/coinRecordApi/index.js";
import {
  CollectionApiOperations,
  _getCollectionApiOperations,
} from "./classic/collectionApi/index.js";
import { FeedApiOperations, _getFeedApiOperations } from "./classic/feedApi/index.js";
import { MiscApiOperations, _getMiscApiOperations } from "./classic/miscApi/index.js";
import { PostApiOperations, _getPostApiOperations } from "./classic/postApi/index.js";
import { TopicApiOperations, _getTopicApiOperations } from "./classic/topicApi/index.js";
import { UserApiOperations, _getUserApiOperations } from "./classic/userApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { CommunityClientOptionalParams } from "./api/communityContext.js";

export class CommunityClient {
  private _client: CommunityContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: CommunityClientOptionalParams = {}) {
    this._client = createCommunity(options);
    this.pipeline = this._client.pipeline;
    this.apiHub = _getApiHubOperations(this._client);
    this.topicApi = _getTopicApiOperations(this._client);
    this.feedApi = _getFeedApiOperations(this._client);
    this.postApi = _getPostApiOperations(this._client);
    this.coinRecordApi = _getCoinRecordApiOperations(this._client);
    this.collectionApi = _getCollectionApiOperations(this._client);
    this.miscApi = _getMiscApiOperations(this._client);
    this.userApi = _getUserApiOperations(this._client);
  }

  /** The operation groups for apiHub */
  public readonly apiHub: ApiHubOperations;
  /** The operation groups for topicApi */
  public readonly topicApi: TopicApiOperations;
  /** The operation groups for feedApi */
  public readonly feedApi: FeedApiOperations;
  /** The operation groups for postApi */
  public readonly postApi: PostApiOperations;
  /** The operation groups for coinRecordApi */
  public readonly coinRecordApi: CoinRecordApiOperations;
  /** The operation groups for collectionApi */
  public readonly collectionApi: CollectionApiOperations;
  /** The operation groups for miscApi */
  public readonly miscApi: MiscApiOperations;
  /** The operation groups for userApi */
  public readonly userApi: UserApiOperations;
}
