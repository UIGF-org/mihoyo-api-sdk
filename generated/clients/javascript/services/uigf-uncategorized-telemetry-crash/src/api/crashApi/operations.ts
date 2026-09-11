// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetryCrashContext as Client } from "../index.js";
import { JsonObject, jsonObjectSerializer } from "../../models/uigf/models.js";
import { CrashApiUploadOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _uploadSend(
  context: Client,
  body: JsonObject,
  options: CrashApiUploadOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/log")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      body: jsonObjectSerializer(body),
    });
}

export async function _uploadDeserialize(result: PathUncheckedResponse): Promise<void> {
  const expectedStatuses = ["204"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return;
}

export async function upload(
  context: Client,
  body: JsonObject,
  options: CrashApiUploadOptionalParams = { requestOptions: {} },
): Promise<void> {
  const result = await _uploadSend(context, body, options);
  return _uploadDeserialize(result);
}
