// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedExperimentationContext as Client } from "../index.js";
import {
  ExperimentListRequest,
  experimentListRequestSerializer,
  ExperimentListResponse,
  experimentListResponseDeserializer,
} from "../../models/uigf/uncategorized/models.js";
import { ExperimentApiListOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _listSend(
  context: Client,
  body: ExperimentListRequest,
  options: ExperimentApiListOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/data_abtest_api/config/experiment/list")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: experimentListRequestSerializer(body),
    });
}

export async function _listDeserialize(
  result: PathUncheckedResponse,
): Promise<ExperimentListResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return experimentListResponseDeserializer(result.body);
}

export async function list(
  context: Client,
  body: ExperimentListRequest,
  options: ExperimentApiListOptionalParams = { requestOptions: {} },
): Promise<ExperimentListResponse> {
  const result = await _listSend(context, body, options);
  return _listDeserialize(result);
}
