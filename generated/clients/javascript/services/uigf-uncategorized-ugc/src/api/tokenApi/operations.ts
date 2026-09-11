// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { UncategorizedUGCContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import { TokenApiGetOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getSend(
  context: Client,
  authkey: string,
  authAppid: string,
  lang: string,
  options: TokenApiGetOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/ugc_login/v1/client/ugc_token{?authkey,auth_appid,authkey_ver,sign_type,lang}",
    {
      authkey: authkey,
      auth_appid: authAppid,
      authkey_ver: "1",
      sign_type: "2",
      lang: lang,
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

export async function _getDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function get(
  context: Client,
  authkey: string,
  authAppid: string,
  lang: string,
  options: TokenApiGetOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getSend(context, authkey, authAppid, lang, options);
  return _getDeserialize(result);
}
