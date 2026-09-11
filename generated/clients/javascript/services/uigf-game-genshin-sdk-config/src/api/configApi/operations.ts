// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinSDKConfigContext as Client } from "../index.js";
import {
  ApiResponseJsonObject,
  apiResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  ConfigApiGetShieldConfigOptionalParams,
  ConfigApiGetGranterConfigOptionalParams,
  ConfigApiGetPrecacheOptionalParams,
  ConfigApiGetComboOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getShieldConfigSend(
  context: Client,
  clientParam: string,
  gameKey: string,
  options: ConfigApiGetShieldConfigOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hk4e_cn/mdk/shield/api/loadConfig{?client,game_key}",
    {
      client: clientParam,
      game_key: gameKey,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
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
    });
}

export async function _getShieldConfigDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getShieldConfig(
  context: Client,
  clientParam: string,
  gameKey: string,
  options: ConfigApiGetShieldConfigOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getShieldConfigSend(context, clientParam, gameKey, options);
  return _getShieldConfigDeserialize(result);
}

export function _getGranterConfigSend(
  context: Client,
  appId: string,
  channelId: string,
  clientType: string,
  options: ConfigApiGetGranterConfigOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hk4e_cn/combo/granter/api/getConfig{?app_id,channel_id,client_type}",
    {
      app_id: appId,
      channel_id: channelId,
      client_type: clientType,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
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
    });
}

export async function _getGranterConfigDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getGranterConfig(
  context: Client,
  appId: string,
  channelId: string,
  clientType: string,
  options: ConfigApiGetGranterConfigOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getGranterConfigSend(context, appId, channelId, clientType, options);
  return _getGranterConfigDeserialize(result);
}

export function _getPrecacheSend(
  context: Client,
  biz: string,
  clientParam: string,
  options: ConfigApiGetPrecacheOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/combo/box/api/config/sw/precache{?biz,client}",
    {
      biz: biz,
      client: clientParam,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
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
    });
}

export async function _getPrecacheDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getPrecache(
  context: Client,
  biz: string,
  clientParam: string,
  options: ConfigApiGetPrecacheOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getPrecacheSend(context, biz, clientParam, options);
  return _getPrecacheDeserialize(result);
}

export function _getComboSend(
  context: Client,
  bizKey: string,
  clientType: string,
  options: ConfigApiGetComboOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/combo/box/api/config/sdk/combo{?biz_key,client_type}",
    {
      biz_key: bizKey,
      client_type: clientType,
    },
    {
      allowReserved: options?.requestOptions?.skipUrlEncoding,
    },
  );
  return context
    .path(path)
    .get({
      ...operationOptionsToRequestParameters(options),
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
    });
}

export async function _getComboDeserialize(
  result: PathUncheckedResponse,
): Promise<ApiResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return apiResponseJsonObjectDeserializer(result.body);
}

export async function getCombo(
  context: Client,
  bizKey: string,
  clientType: string,
  options: ConfigApiGetComboOptionalParams = { requestOptions: {} },
): Promise<ApiResponseJsonObject> {
  const result = await _getComboSend(context, bizKey, clientType, options);
  return _getComboDeserialize(result);
}
