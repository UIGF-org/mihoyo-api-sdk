// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedUGCContext } from "../../api/uncategorizedUGCContext.js";
import { get } from "../../api/tokenApi/operations.js";
import { TokenApiGetOptionalParams } from "../../api/tokenApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a TokenApi operations. */
export interface TokenApiOperations {
  get: (
    authkey: string,
    authAppid: string,
    lang: string,
    options?: TokenApiGetOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getTokenApi(context: UncategorizedUGCContext) {
  return {
    get: (authkey: string, authAppid: string, lang: string, options?: TokenApiGetOptionalParams) =>
      get(context, authkey, authAppid, lang, options),
  };
}

export function _getTokenApiOperations(context: UncategorizedUGCContext): TokenApiOperations {
  return {
    ..._getTokenApi(context),
  };
}
