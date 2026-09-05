// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { CheckInContext } from "../../api/checkInContext.js";
import { resign, getResignInfo, sign, getInfo, getHome } from "../../api/checkInApi/operations.js";
import {
  CheckInApiResignOptionalParams,
  CheckInApiGetResignInfoOptionalParams,
  CheckInApiSignOptionalParams,
  CheckInApiGetInfoOptionalParams,
  CheckInApiGetHomeOptionalParams,
} from "../../api/checkInApi/options.js";
import { LunaCheckInRequest } from "../../models/uigf/community/models.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";

/** Interface representing a CheckInApi operations. */
export interface CheckInApiOperations {
  resign: (
    game: string,
    cookie: string,
    body: LunaCheckInRequest,
    options?: CheckInApiResignOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getResignInfo: (
    game: string,
    cookie: string,
    lang: string,
    actId: string,
    options?: CheckInApiGetResignInfoOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  sign: (
    game: string,
    cookie: string,
    body: LunaCheckInRequest,
    options?: CheckInApiSignOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getInfo: (
    game: string,
    cookie: string,
    lang: string,
    actId: string,
    options?: CheckInApiGetInfoOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getHome: (
    game: string,
    cookie: string,
    lang: string,
    actId: string,
    options?: CheckInApiGetHomeOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getCheckInApi(context: CheckInContext) {
  return {
    resign: (
      game: string,
      cookie: string,
      body: LunaCheckInRequest,
      options?: CheckInApiResignOptionalParams,
    ) => resign(context, game, cookie, body, options),
    getResignInfo: (
      game: string,
      cookie: string,
      lang: string,
      actId: string,
      options?: CheckInApiGetResignInfoOptionalParams,
    ) => getResignInfo(context, game, cookie, lang, actId, options),
    sign: (
      game: string,
      cookie: string,
      body: LunaCheckInRequest,
      options?: CheckInApiSignOptionalParams,
    ) => sign(context, game, cookie, body, options),
    getInfo: (
      game: string,
      cookie: string,
      lang: string,
      actId: string,
      options?: CheckInApiGetInfoOptionalParams,
    ) => getInfo(context, game, cookie, lang, actId, options),
    getHome: (
      game: string,
      cookie: string,
      lang: string,
      actId: string,
      options?: CheckInApiGetHomeOptionalParams,
    ) => getHome(context, game, cookie, lang, actId, options),
  };
}

export function _getCheckInApiOperations(context: CheckInContext): CheckInApiOperations {
  return {
    ..._getCheckInApi(context),
  };
}
