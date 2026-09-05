// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportV4Context } from "../../api/passportV4Context.js";
import { verifyLToken } from "../../api/sessionApi/operations.js";
import { SessionApiVerifyLTokenOptionalParams } from "../../api/sessionApi/options.js";
import { JsonObject, ApiResponseTokenInfo } from "../../models/uigf/models.js";

/** Interface representing a SessionApi operations. */
export interface SessionApiOperations {
  verifyLToken: (
    cookie: string,
    body: JsonObject,
    options?: SessionApiVerifyLTokenOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
}

function _getSessionApi(context: PassportV4Context) {
  return {
    verifyLToken: (
      cookie: string,
      body: JsonObject,
      options?: SessionApiVerifyLTokenOptionalParams,
    ) => verifyLToken(context, cookie, body, options),
  };
}

export function _getSessionApiOperations(context: PassportV4Context): SessionApiOperations {
  return {
    ..._getSessionApi(context),
  };
}
