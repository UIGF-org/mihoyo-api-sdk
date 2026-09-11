// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetryH5Context as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { H5LogRequest, h5LogRequestSerializer } from "../../models/uigf/uncategorized/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { BatchApiUploadOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _uploadSend(
  context: Client,
  topic: string,
  body: H5LogRequest,
  options: BatchApiUploadOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/common/h5log/log/batch{?topic}",
    {
      topic: topic,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        ...(options?.dateParam !== undefined ? { date: options?.dateParam } : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: h5LogRequestSerializer(body),
    });
}

export async function _uploadDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function upload(
  context: Client,
  topic: string,
  body: H5LogRequest,
  options: BatchApiUploadOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _uploadSend(context, topic, body, options);
  return _uploadDeserialize(result);
}
