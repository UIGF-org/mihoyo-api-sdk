// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedTelemetryGameContext as Client } from "../index.js";
import { JsonObject, jsonObjectArraySerializer } from "../../models/uigf/models.js";
import {
  UploadResponse,
  uploadResponseDeserializer,
} from "../../models/uigf/uncategorized/models.js";
import {
  UploadApiUploadCustomOptionalParams,
  UploadApiUploadSdkOptionalParams,
  UploadApiUploadCrashOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _uploadCustomSend(
  context: Client,
  body: JsonObject[],
  options: UploadApiUploadCustomOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/ys_custom/dataUpload")
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

export async function _uploadCustomDeserialize(
  result: PathUncheckedResponse,
): Promise<UploadResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return uploadResponseDeserializer(result.body);
}

export async function uploadCustom(
  context: Client,
  body: JsonObject[],
  options: UploadApiUploadCustomOptionalParams = { requestOptions: {} },
): Promise<UploadResponse> {
  const result = await _uploadCustomSend(context, body, options);
  return _uploadCustomDeserialize(result);
}

export function _uploadSdkSend(
  context: Client,
  body: JsonObject[],
  options: UploadApiUploadSdkOptionalParams = { requestOptions: {} },
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

export async function _uploadSdkDeserialize(
  result: PathUncheckedResponse,
): Promise<UploadResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return uploadResponseDeserializer(result.body);
}

export async function uploadSdk(
  context: Client,
  body: JsonObject[],
  options: UploadApiUploadSdkOptionalParams = { requestOptions: {} },
): Promise<UploadResponse> {
  const result = await _uploadSdkSend(context, body, options);
  return _uploadSdkDeserialize(result);
}

export function _uploadCrashSend(
  context: Client,
  body: JsonObject[],
  options: UploadApiUploadCrashOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/crash/dataUpload")
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

export async function _uploadCrashDeserialize(
  result: PathUncheckedResponse,
): Promise<UploadResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return uploadResponseDeserializer(result.body);
}

/** The official client signs the upload headers; signing is intentionally caller-owned. */
export async function uploadCrash(
  context: Client,
  body: JsonObject[],
  options: UploadApiUploadCrashOptionalParams = { requestOptions: {} },
): Promise<UploadResponse> {
  const result = await _uploadCrashSend(context, body, options);
  return _uploadCrashDeserialize(result);
}
