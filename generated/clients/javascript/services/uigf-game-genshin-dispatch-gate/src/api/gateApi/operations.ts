// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinDispatchGateContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { GateApiGetAddressOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getAddressSend(
  context: Client,
  game: string,
  region: string,
  options: GateApiGetAddressOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/dispatch/dispatch/getGateAddress{?game,region}",
    {
      game: game,
      region: region,
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

export async function _getAddressDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getAddress(
  context: Client,
  game: string,
  region: string,
  options: GateApiGetAddressOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getAddressSend(context, game, region, options);
  return _getAddressDeserialize(result);
}
