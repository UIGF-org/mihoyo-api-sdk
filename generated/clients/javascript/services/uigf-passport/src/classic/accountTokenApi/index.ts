// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext } from "../../api/passportContext.js";
import {
  getLTokenBySToken,
  getCookieAccountInfoBySToken,
} from "../../api/accountTokenApi/operations.js";
import {
  AccountTokenApiGetLTokenBySTokenOptionalParams,
  AccountTokenApiGetCookieAccountInfoBySTokenOptionalParams,
} from "../../api/accountTokenApi/options.js";
import { ApiResponseTokenInfo } from "../../models/uigf/models.js";

/** Interface representing a AccountTokenApi operations. */
export interface AccountTokenApiOperations {
  /** Exchanges an SToken cookie for an LToken payload. */
  getLTokenBySToken: (
    cookie: string,
    options?: AccountTokenApiGetLTokenBySTokenOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
  /** Returns account information for an authenticated SToken cookie. */
  getCookieAccountInfoBySToken: (
    cookie: string,
    options?: AccountTokenApiGetCookieAccountInfoBySTokenOptionalParams,
  ) => Promise<ApiResponseTokenInfo>;
}

function _getAccountTokenApi(context: PassportContext) {
  return {
    getLTokenBySToken: (cookie: string, options?: AccountTokenApiGetLTokenBySTokenOptionalParams) =>
      getLTokenBySToken(context, cookie, options),
    getCookieAccountInfoBySToken: (
      cookie: string,
      options?: AccountTokenApiGetCookieAccountInfoBySTokenOptionalParams,
    ) => getCookieAccountInfoBySToken(context, cookie, options),
  };
}

export function _getAccountTokenApiOperations(context: PassportContext): AccountTokenApiOperations {
  return {
    ..._getAccountTokenApi(context),
  };
}
