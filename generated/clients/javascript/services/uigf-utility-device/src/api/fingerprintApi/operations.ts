// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UtilityDeviceContext as Client } from "../index.js";
import {
  DeviceFingerprintRequest,
  deviceFingerprintRequestSerializer,
} from "../../models/uigf/game/models.js";
import {
  ApiResponseDeviceExtensionList,
  apiResponseDeviceExtensionListDeserializer,
  ApiResponseDeviceFingerprint,
  apiResponseDeviceFingerprintDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  FingerprintApiGetFingerprintOptionalParams,
  FingerprintApiGetExtensionListOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getFingerprintSend(
  context: Client,
  appVersion: string,
  clientType: string,
  requestedWith: string,
  body: DeviceFingerprintRequest,
  options: FingerprintApiGetFingerprintOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/device-fp/api/getFp")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        "x-rpc-app_version": appVersion,
        "x-rpc-client_type": clientType,
        "x-requested-with": requestedWith,
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: deviceFingerprintRequestSerializer(body),
    });
}

export async function _getFingerprintDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseDeviceFingerprint> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseDeviceFingerprintDeserializer(result.body);
}

/** Registers a legitimate client device fingerprint and returns its `device_fp` value. */
export async function getFingerprint(
  context: Client,
  appVersion: string,
  clientType: string,
  requestedWith: string,
  body: DeviceFingerprintRequest,
  options: FingerprintApiGetFingerprintOptionalParams = { requestOptions: {} },
): Promise<ApiResponseDeviceFingerprint> {
  const result = await _getFingerprintSend(
    context,
    appVersion,
    clientType,
    requestedWith,
    body,
    options,
  );
  return _getFingerprintDeserialize(result);
}

export function _getExtensionListSend(
  context: Client,
  platform: string,
  options: FingerprintApiGetExtensionListOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/device-fp/api/getExtList{?platform}",
    {
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

export async function _getExtensionListDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseDeviceExtensionList> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseDeviceExtensionListDeserializer(result.body);
}

/** Returns the client extension fields expected by the fingerprint registration endpoint. */
export async function getExtensionList(
  context: Client,
  platform: string,
  options: FingerprintApiGetExtensionListOptionalParams = { requestOptions: {} },
): Promise<ApiResponseDeviceExtensionList> {
  const result = await _getExtensionListSend(context, platform, options);
  return _getExtensionListDeserialize(result);
}
