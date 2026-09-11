// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedComboTokenContext } from "../../api/uncategorizedComboTokenContext.js";
import { exchange } from "../../api/comboTokenApi/operations.js";
import { ComboTokenApiExchangeOptionalParams } from "../../api/comboTokenApi/options.js";
import { ApiResponseJsonObject } from "../../models/uigf/models.js";
import { ComboTokenRequest } from "../../models/uigf/uncategorized/models.js";

/** Interface representing a ComboTokenApi operations. */
export interface ComboTokenApiOperations {
  exchange: (
    body: ComboTokenRequest,
    options?: ComboTokenApiExchangeOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getComboTokenApi(context: UncategorizedComboTokenContext) {
  return {
    exchange: (body: ComboTokenRequest, options?: ComboTokenApiExchangeOptionalParams) =>
      exchange(context, body, options),
  };
}

export function _getComboTokenApiOperations(
  context: UncategorizedComboTokenContext,
): ComboTokenApiOperations {
  return {
    ..._getComboTokenApi(context),
  };
}
