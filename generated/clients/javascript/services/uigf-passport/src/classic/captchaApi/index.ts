// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext } from "../../api/passportContext.js";
import { create } from "../../api/captchaApi/operations.js";
import { CaptchaApiCreateOptionalParams } from "../../api/captchaApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";
import { LoginCaptchaRequest } from "../../models/uigf/passport/models.js";

/** Interface representing a CaptchaApi operations. */
export interface CaptchaApiOperations {
  /** Starts the vendor login-captcha challenge. Solve it through the official flow. */
  create: (
    body: LoginCaptchaRequest,
    options?: CaptchaApiCreateOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getCaptchaApi(context: PassportContext) {
  return {
    create: (body: LoginCaptchaRequest, options?: CaptchaApiCreateOptionalParams) =>
      create(context, body, options),
  };
}

export function _getCaptchaApiOperations(context: PassportContext): CaptchaApiOperations {
  return {
    ..._getCaptchaApi(context),
  };
}
