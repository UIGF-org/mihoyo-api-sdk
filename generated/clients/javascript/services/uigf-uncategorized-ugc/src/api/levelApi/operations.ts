// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedUGCContext as Client } from "../index.js";
import {
  LevelApiGetCollectionTinyInfoResponse,
  LevelApiGetIndexRedpointResponse,
} from "../../models/models.js";
import {
  LevelApiGetCollectionTinyInfoOptionalParams,
  LevelApiGetIndexRedpointOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getCollectionTinyInfoSend(
  context: Client,
  body: Uint8Array,
  options: LevelApiGetCollectionTinyInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/ugc_gateway/v1/levels/collection/tiny_info")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/octet-stream",
      headers: { accept: "application/octet-stream", ...options.requestOptions?.headers },
      body: body,
    });
}

export async function _getCollectionTinyInfoDeserialize(
  result: PathUncheckedResponse & LevelApiGetCollectionTinyInfoResponse,
): Promise<LevelApiGetCollectionTinyInfoResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return { blobBody: result.blobBody, readableStreamBody: result.readableStreamBody };
}

/** The gateway payload is opaque protobuf data in the available capture. */
export async function getCollectionTinyInfo(
  context: Client,
  body: Uint8Array,
  options: LevelApiGetCollectionTinyInfoOptionalParams = { requestOptions: {} },
): Promise<LevelApiGetCollectionTinyInfoResponse> {
  const result = await _getCollectionTinyInfoSend(context, body, options);
  return _getCollectionTinyInfoDeserialize(result);
}

export function _getIndexRedpointSend(
  context: Client,
  options: LevelApiGetIndexRedpointOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/ugc_gateway/v1/level_rec/index_redpoint")
    .post({
      ...operationOptionsToRequestParameters(options),
      headers: { accept: "application/octet-stream", ...options.requestOptions?.headers },
    });
}

export async function _getIndexRedpointDeserialize(
  result: PathUncheckedResponse & LevelApiGetIndexRedpointResponse,
): Promise<LevelApiGetIndexRedpointResponse> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return { blobBody: result.blobBody, readableStreamBody: result.readableStreamBody };
}

/** The observed request and response use the vendor's protobuf media type. */
export async function getIndexRedpoint(
  context: Client,
  options: LevelApiGetIndexRedpointOptionalParams = { requestOptions: {} },
): Promise<LevelApiGetIndexRedpointResponse> {
  const result = await _getIndexRedpointSend(context, options);
  return _getIndexRedpointDeserialize(result);
}
