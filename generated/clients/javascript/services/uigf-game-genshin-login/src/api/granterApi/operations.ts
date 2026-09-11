// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinLoginContext as Client } from "../index.js";
import {
  GranterLoginRequest,
  granterLoginRequestSerializer,
} from "../../models/uigf/game/genshin/sdk/models.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { GranterApiLoginOptionalParams } from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _loginSend(
  context: Client,
  body: GranterLoginRequest,
  options: GranterApiLoginOptionalParams = { requestOptions: {} },
): StreamableMethod {
  return context
    .path("/hk4e_cn/combo/granter/login/v2/login")
    .post({
      ...operationOptionsToRequestParameters(options),
      contentType: "application/json",
      headers: {
        ...(options?.rpcAppId !== undefined ? { "x-rpc-app_id": options?.rpcAppId } : {}),
        ...(options?.rpcAppVersion !== undefined
          ? { "x-rpc-app_version": options?.rpcAppVersion }
          : {}),
        ...(options?.rpcChannelId !== undefined
          ? { "x-rpc-channel_id": options?.rpcChannelId }
          : {}),
        ...(options?.rpcChannelVersion !== undefined
          ? { "x-rpc-channel_version": options?.rpcChannelVersion }
          : {}),
        ...(options?.rpcClientType !== undefined
          ? { "x-rpc-client_type": options?.rpcClientType }
          : {}),
        ...(options?.rpcComboVersion !== undefined
          ? { "x-rpc-combo_version": options?.rpcComboVersion }
          : {}),
        ...(options?.rpcDeviceFingerprint !== undefined
          ? { "x-rpc-device_fp": options?.rpcDeviceFingerprint }
          : {}),
        ...(options?.rpcDeviceId !== undefined ? { "x-rpc-device_id": options?.rpcDeviceId } : {}),
        ...(options?.rpcDeviceModel !== undefined
          ? { "x-rpc-device_model": options?.rpcDeviceModel }
          : {}),
        ...(options?.rpcDeviceName !== undefined
          ? { "x-rpc-device_name": options?.rpcDeviceName }
          : {}),
        ...(options?.rpcGameBiz !== undefined ? { "x-rpc-game_biz": options?.rpcGameBiz } : {}),
        ...(options?.rpcGoodsThirdParty !== undefined
          ? { "x-rpc-goods_third_party": options?.rpcGoodsThirdParty }
          : {}),
        ...(options?.rpcLanguage !== undefined ? { "x-rpc-language": options?.rpcLanguage } : {}),
        ...(options?.rpcMdkVersion !== undefined
          ? { "x-rpc-mdk_version": options?.rpcMdkVersion }
          : {}),
        ...(options?.rpcPaymentVersion !== undefined
          ? { "x-rpc-payment_version": options?.rpcPaymentVersion }
          : {}),
        ...(options?.rpcSdkVersion !== undefined
          ? { "x-rpc-sdk_version": options?.rpcSdkVersion }
          : {}),
        ...(options?.rpcSubChannelId !== undefined
          ? { "x-rpc-sub_channel_id": options?.rpcSubChannelId }
          : {}),
        ...(options?.rpcSystemVersion !== undefined
          ? { "x-rpc-sys_version": options?.rpcSystemVersion }
          : {}),
        accept: "application/json",
        ...options.requestOptions?.headers,
      },
      body: granterLoginRequestSerializer(body),
    });
}

export async function _loginDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

/** Submits the caller-provided official granter login payload. */
export async function login(
  context: Client,
  body: GranterLoginRequest,
  options: GranterApiLoginOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _loginSend(context, body, options);
  return _loginDeserialize(result);
}
