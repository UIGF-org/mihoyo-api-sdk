// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetrySDKContext as Client } from "../index.js";
import { JsonObject, jsonObjectArraySerializer } from "../../models/uigf/models.js";
import {
  UploadResponse,
  uploadResponseDeserializer,
} from "../../models/uigf/uncategorized/models.js";
import { UploadApiUploadOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _uploadSend(
  context: Client,
  body: JsonObject[],
  options: UploadApiUploadOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/sdk/dataUpload")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        ...(options?.authorization !== undefined ? { authorization: options?.authorization } : {}),
        ...(options?.contentMd5 !== undefined ? { "content-md5": options?.contentMd5 } : {}),
        ...(options?.dateParam !== undefined ? { date: options?.dateParam } : {}),
        ...(options?.cmsSignature !== undefined ? { "cms-signature": options?.cmsSignature } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: jsonObjectArraySerializer(body),
    });
}

export async function _uploadDeserialize(result: PathUncheckedResponse): Promise<UploadResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return uploadResponseDeserializer(result.body);
}

export async function upload(
  context: Client,
  body: JsonObject[],
  options: UploadApiUploadOptionalParams = { requestOptions: {} },
): Promise<UploadResponse> {
  const result = await _uploadSend(context, body, options);
  return _uploadDeserialize(result);
}
