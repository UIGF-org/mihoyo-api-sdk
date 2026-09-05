// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { LauncherGlobalContext as Client } from "../index.js";
import { DxConfigRequest, dxConfigRequestSerializer } from "../../models/uigf/launcher/models.js";
import {
  LauncherResponseGameBasicInfo,
  launcherResponseGameBasicInfoDeserializer,
  LauncherResponseJsonObject,
  launcherResponseJsonObjectDeserializer,
} from "../../models/uigf/models.js";
import { expandUrlTemplate } from "../../static-helpers/urlTemplate.js";
import {
  MetadataApiGetDxConfigsOptionalParams,
  MetadataApiGetWpfPackagesOptionalParams,
  MetadataApiGetGameBranchesOptionalParams,
  MetadataApiGetGameScanInfoOptionalParams,
  MetadataApiGetGameConfigsOptionalParams,
  MetadataApiGetDeprecatedFileConfigsOptionalParams,
  MetadataApiGetGameChannelSdksOptionalParams,
  MetadataApiGetGamePackagesOptionalParams,
  MetadataApiGetAllGameBasicInfoOptionalParams,
} from "./options.js";
import {
  StreamableMethod,
  PathUncheckedResponse,
  createRestError,
  operationOptionsToRequestParameters,
} from "@azure-rest/core-client";

export function _getDxConfigsSend(
  context: Client,
  launcherId: string,
  language: string,
  body: DxConfigRequest,
  options: MetadataApiGetDxConfigsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hyp/hyp-connect/api/getDXConfigs{?launcher_id,language,game_ids%5B%5D}",
    {
      launcher_id: launcherId,
      language: language,
      "game_ids%5B%5D": !options?.gameIds
        ? options?.gameIds
        : options?.gameIds.map((p: any) => {
            return p;
          }),
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
      headers: { accept: "application/json", ...options.requestOptions?.headers },
      body: dxConfigRequestSerializer(body),
    });
}

export async function _getDxConfigsDeserialize(
  result: PathUncheckedResponse,
): Promise<LauncherResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return launcherResponseJsonObjectDeserializer(result.body);
}

export async function getDxConfigs(
  context: Client,
  launcherId: string,
  language: string,
  body: DxConfigRequest,
  options: MetadataApiGetDxConfigsOptionalParams = { requestOptions: {} },
): Promise<LauncherResponseJsonObject> {
  const result = await _getDxConfigsSend(context, launcherId, language, body, options);
  return _getDxConfigsDeserialize(result);
}

export function _getWpfPackagesSend(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetWpfPackagesOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hyp/hyp-connect/api/getWPFPackages{?launcher_id,language,game_ids%5B%5D}",
    {
      launcher_id: launcherId,
      language: language,
      "game_ids%5B%5D": !options?.gameIds
        ? options?.gameIds
        : options?.gameIds.map((p: any) => {
            return p;
          }),
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

export async function _getWpfPackagesDeserialize(
  result: PathUncheckedResponse,
): Promise<LauncherResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return launcherResponseJsonObjectDeserializer(result.body);
}

export async function getWpfPackages(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetWpfPackagesOptionalParams = { requestOptions: {} },
): Promise<LauncherResponseJsonObject> {
  const result = await _getWpfPackagesSend(context, launcherId, language, options);
  return _getWpfPackagesDeserialize(result);
}

export function _getGameBranchesSend(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGameBranchesOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hyp/hyp-connect/api/getGameBranches{?launcher_id,language,game_ids%5B%5D}",
    {
      launcher_id: launcherId,
      language: language,
      "game_ids%5B%5D": !options?.gameIds
        ? options?.gameIds
        : options?.gameIds.map((p: any) => {
            return p;
          }),
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

export async function _getGameBranchesDeserialize(
  result: PathUncheckedResponse,
): Promise<LauncherResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return launcherResponseJsonObjectDeserializer(result.body);
}

export async function getGameBranches(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGameBranchesOptionalParams = { requestOptions: {} },
): Promise<LauncherResponseJsonObject> {
  const result = await _getGameBranchesSend(context, launcherId, language, options);
  return _getGameBranchesDeserialize(result);
}

export function _getGameScanInfoSend(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGameScanInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hyp/hyp-connect/api/getGameScanInfo{?launcher_id,language,game_ids%5B%5D}",
    {
      launcher_id: launcherId,
      language: language,
      "game_ids%5B%5D": !options?.gameIds
        ? options?.gameIds
        : options?.gameIds.map((p: any) => {
            return p;
          }),
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

export async function _getGameScanInfoDeserialize(
  result: PathUncheckedResponse,
): Promise<LauncherResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return launcherResponseJsonObjectDeserializer(result.body);
}

export async function getGameScanInfo(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGameScanInfoOptionalParams = { requestOptions: {} },
): Promise<LauncherResponseJsonObject> {
  const result = await _getGameScanInfoSend(context, launcherId, language, options);
  return _getGameScanInfoDeserialize(result);
}

export function _getGameConfigsSend(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGameConfigsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hyp/hyp-connect/api/getGameConfigs{?launcher_id,language,game_ids%5B%5D}",
    {
      launcher_id: launcherId,
      language: language,
      "game_ids%5B%5D": !options?.gameIds
        ? options?.gameIds
        : options?.gameIds.map((p: any) => {
            return p;
          }),
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

export async function _getGameConfigsDeserialize(
  result: PathUncheckedResponse,
): Promise<LauncherResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return launcherResponseJsonObjectDeserializer(result.body);
}

export async function getGameConfigs(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGameConfigsOptionalParams = { requestOptions: {} },
): Promise<LauncherResponseJsonObject> {
  const result = await _getGameConfigsSend(context, launcherId, language, options);
  return _getGameConfigsDeserialize(result);
}

export function _getDeprecatedFileConfigsSend(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetDeprecatedFileConfigsOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hyp/hyp-connect/api/getGameDeprecatedFileConfigs{?channel,sub_channel,launcher_id,language,game_ids%5B%5D}",
    {
      channel: options?.channel,
      sub_channel: options?.subChannel,
      launcher_id: launcherId,
      language: language,
      "game_ids%5B%5D": !options?.gameIds
        ? options?.gameIds
        : options?.gameIds.map((p: any) => {
            return p;
          }),
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

export async function _getDeprecatedFileConfigsDeserialize(
  result: PathUncheckedResponse,
): Promise<LauncherResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return launcherResponseJsonObjectDeserializer(result.body);
}

export async function getDeprecatedFileConfigs(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetDeprecatedFileConfigsOptionalParams = { requestOptions: {} },
): Promise<LauncherResponseJsonObject> {
  const result = await _getDeprecatedFileConfigsSend(context, launcherId, language, options);
  return _getDeprecatedFileConfigsDeserialize(result);
}

export function _getGameChannelSdksSend(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGameChannelSdksOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hyp/hyp-connect/api/getGameChannelSDKs{?channel,sub_channel,launcher_id,language,game_ids%5B%5D}",
    {
      channel: options?.channel,
      sub_channel: options?.subChannel,
      launcher_id: launcherId,
      language: language,
      "game_ids%5B%5D": !options?.gameIds
        ? options?.gameIds
        : options?.gameIds.map((p: any) => {
            return p;
          }),
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

export async function _getGameChannelSdksDeserialize(
  result: PathUncheckedResponse,
): Promise<LauncherResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return launcherResponseJsonObjectDeserializer(result.body);
}

export async function getGameChannelSdks(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGameChannelSdksOptionalParams = { requestOptions: {} },
): Promise<LauncherResponseJsonObject> {
  const result = await _getGameChannelSdksSend(context, launcherId, language, options);
  return _getGameChannelSdksDeserialize(result);
}

export function _getGamePackagesSend(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGamePackagesOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hyp/hyp-connect/api/getGamePackages{?launcher_id,language,game_ids%5B%5D}",
    {
      launcher_id: launcherId,
      language: language,
      "game_ids%5B%5D": !options?.gameIds
        ? options?.gameIds
        : options?.gameIds.map((p: any) => {
            return p;
          }),
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

export async function _getGamePackagesDeserialize(
  result: PathUncheckedResponse,
): Promise<LauncherResponseJsonObject> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return launcherResponseJsonObjectDeserializer(result.body);
}

export async function getGamePackages(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetGamePackagesOptionalParams = { requestOptions: {} },
): Promise<LauncherResponseJsonObject> {
  const result = await _getGamePackagesSend(context, launcherId, language, options);
  return _getGamePackagesDeserialize(result);
}

export function _getAllGameBasicInfoSend(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetAllGameBasicInfoOptionalParams = { requestOptions: {} },
): StreamableMethod {
  const path = expandUrlTemplate(
    "/hyp/hyp-connect/api/getAllGameBasicInfo{?launcher_id,language,game_ids%5B%5D}",
    {
      launcher_id: launcherId,
      language: language,
      "game_ids%5B%5D": !options?.gameIds
        ? options?.gameIds
        : options?.gameIds.map((p: any) => {
            return p;
          }),
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

export async function _getAllGameBasicInfoDeserialize(
  result: PathUncheckedResponse,
): Promise<LauncherResponseGameBasicInfo> {
  const expectedStatuses = ["200"];
  if (!expectedStatuses.includes(result.status)) {
    throw createRestError(result);
  }

  return launcherResponseGameBasicInfoDeserializer(result.body);
}

export async function getAllGameBasicInfo(
  context: Client,
  launcherId: string,
  language: string,
  options: MetadataApiGetAllGameBasicInfoOptionalParams = { requestOptions: {} },
): Promise<LauncherResponseGameBasicInfo> {
  const result = await _getAllGameBasicInfoSend(context, launcherId, language, options);
  return _getAllGameBasicInfoDeserialize(result);
}
