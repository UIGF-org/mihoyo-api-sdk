// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetryGameContext as Client } from "../index.js";
import {
  UploadResponse,
  uploadResponseDeserializer,
} from "../../models/uigf/uncategorized/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { PerformanceApiVerifyOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _verifySend(
  context: Client,
  deviceId: string,
  name: string,
  platform: string,
  options: PerformanceApiVerifyOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/perf/config/verify{?device_id,name,platform}",
    {
      device_id: deviceId,
      name: name,
      platform: platform,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/json", ...options.requestOptions?.headers },
    });
}

export async function _verifyDeserialize(result: PathUncheckedResponse): Promise<UploadResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return uploadResponseDeserializer(result.body);
}

export async function verify(
  context: Client,
  deviceId: string,
  name: string,
  platform: string,
  options: PerformanceApiVerifyOptionalParams = { requestOptions: {} },
): Promise<UploadResponse> {
  const result = await _verifySend(context, deviceId, name, platform, options);
  return _verifyDeserialize(result);
}
