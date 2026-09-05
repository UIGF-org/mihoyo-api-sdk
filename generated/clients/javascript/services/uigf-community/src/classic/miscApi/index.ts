// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CommunityContext } from "../../api/communityContext.js";
import {
  getGeetestChallenge,
  verifyVerification,
  createVerification,
  getEmoticonSet,
} from "../../api/miscApi/operations.js";
import {
  MiscApiGetGeetestChallengeOptionalParams,
  MiscApiVerifyVerificationOptionalParams,
  MiscApiCreateVerificationOptionalParams,
  MiscApiGetEmoticonSetOptionalParams,
} from "../../api/miscApi/options.js";
import {
  VerificationCreateRequest,
  VerificationSubmitRequest,
} from "../../models/uigf/community/models.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a MiscApi operations. */
export interface MiscApiOperations {
  getGeetestChallenge: (
    cookie: string,
    options?: MiscApiGetGeetestChallengeOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  /** Submits verification output obtained from the official challenge provider. */
  verifyVerification: (
    cookie: string,
    body: VerificationSubmitRequest,
    options?: MiscApiVerifyVerificationOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  /** Creates the official verification challenge required by selected operations. */
  createVerification: (
    cookie: string,
    body: VerificationCreateRequest,
    options?: MiscApiCreateVerificationOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getEmoticonSet: (options?: MiscApiGetEmoticonSetOptionalParams) => Promise<ApiResponseJsonObject>;
}

function _getMiscApi(context: CommunityContext) {
  return {
    getGeetestChallenge: (cookie: string, options?: MiscApiGetGeetestChallengeOptionalParams) =>
      getGeetestChallenge(context, cookie, options),
    verifyVerification: (
      cookie: string,
      body: VerificationSubmitRequest,
      options?: MiscApiVerifyVerificationOptionalParams,
    ) => verifyVerification(context, cookie, body, options),
    createVerification: (
      cookie: string,
      body: VerificationCreateRequest,
      options?: MiscApiCreateVerificationOptionalParams,
    ) => createVerification(context, cookie, body, options),
    getEmoticonSet: (options?: MiscApiGetEmoticonSetOptionalParams) =>
      getEmoticonSet(context, options),
  };
}

export function _getMiscApiOperations(context: CommunityContext): MiscApiOperations {
  return {
    ..._getMiscApi(context),
  };
}
