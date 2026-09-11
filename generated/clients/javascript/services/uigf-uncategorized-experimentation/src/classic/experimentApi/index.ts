// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedExperimentationContext } from "../../api/uncategorizedExperimentationContext.js";
import { list } from "../../api/experimentApi/operations.js";
import { ExperimentApiListOptionalParams } from "../../api/experimentApi/options.js";
import {
  ExperimentListRequest,
  ExperimentListResponse,
} from "../../models/uigf/uncategorized/models.js";

/** Interface representing a ExperimentApi operations. */
export interface ExperimentApiOperations {
  list: (
    body: ExperimentListRequest,
    options?: ExperimentApiListOptionalParams,
  ) => Promise<ExperimentListResponse>;
}

function _getExperimentApi(context: UncategorizedExperimentationContext) {
  return {
    list: (body: ExperimentListRequest, options?: ExperimentApiListOptionalParams) =>
      list(context, body, options),
  };
}

export function _getExperimentApiOperations(
  context: UncategorizedExperimentationContext,
): ExperimentApiOperations {
  return {
    ..._getExperimentApi(context),
  };
}
