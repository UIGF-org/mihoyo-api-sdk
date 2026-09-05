// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { LauncherGlobalContext } from "../../api/launcherGlobalContext.js";
import {
  getDxConfigs,
  getWpfPackages,
  getGameBranches,
  getGameScanInfo,
  getGameConfigs,
  getDeprecatedFileConfigs,
  getGameChannelSdks,
  getGamePackages,
  getAllGameBasicInfo,
} from "../../api/metadataApi/operations.js";
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
} from "../../api/metadataApi/options.js";
import { DxConfigRequest } from "../../models/uigf/launcher/models.js";
import {
  LauncherResponseGameBasicInfo,
  LauncherResponseJsonObject,
} from "../../models/uigf/models.js";

/** Interface representing a MetadataApi operations. */
export interface MetadataApiOperations {
  getDxConfigs: (
    launcherId: string,
    language: string,
    body: DxConfigRequest,
    options?: MetadataApiGetDxConfigsOptionalParams,
  ) => Promise<LauncherResponseJsonObject>;
  getWpfPackages: (
    launcherId: string,
    language: string,
    options?: MetadataApiGetWpfPackagesOptionalParams,
  ) => Promise<LauncherResponseJsonObject>;
  getGameBranches: (
    launcherId: string,
    language: string,
    options?: MetadataApiGetGameBranchesOptionalParams,
  ) => Promise<LauncherResponseJsonObject>;
  getGameScanInfo: (
    launcherId: string,
    language: string,
    options?: MetadataApiGetGameScanInfoOptionalParams,
  ) => Promise<LauncherResponseJsonObject>;
  getGameConfigs: (
    launcherId: string,
    language: string,
    options?: MetadataApiGetGameConfigsOptionalParams,
  ) => Promise<LauncherResponseJsonObject>;
  getDeprecatedFileConfigs: (
    launcherId: string,
    language: string,
    options?: MetadataApiGetDeprecatedFileConfigsOptionalParams,
  ) => Promise<LauncherResponseJsonObject>;
  getGameChannelSdks: (
    launcherId: string,
    language: string,
    options?: MetadataApiGetGameChannelSdksOptionalParams,
  ) => Promise<LauncherResponseJsonObject>;
  getGamePackages: (
    launcherId: string,
    language: string,
    options?: MetadataApiGetGamePackagesOptionalParams,
  ) => Promise<LauncherResponseJsonObject>;
  getAllGameBasicInfo: (
    launcherId: string,
    language: string,
    options?: MetadataApiGetAllGameBasicInfoOptionalParams,
  ) => Promise<LauncherResponseGameBasicInfo>;
}

function _getMetadataApi(context: LauncherGlobalContext) {
  return {
    getDxConfigs: (
      launcherId: string,
      language: string,
      body: DxConfigRequest,
      options?: MetadataApiGetDxConfigsOptionalParams,
    ) => getDxConfigs(context, launcherId, language, body, options),
    getWpfPackages: (
      launcherId: string,
      language: string,
      options?: MetadataApiGetWpfPackagesOptionalParams,
    ) => getWpfPackages(context, launcherId, language, options),
    getGameBranches: (
      launcherId: string,
      language: string,
      options?: MetadataApiGetGameBranchesOptionalParams,
    ) => getGameBranches(context, launcherId, language, options),
    getGameScanInfo: (
      launcherId: string,
      language: string,
      options?: MetadataApiGetGameScanInfoOptionalParams,
    ) => getGameScanInfo(context, launcherId, language, options),
    getGameConfigs: (
      launcherId: string,
      language: string,
      options?: MetadataApiGetGameConfigsOptionalParams,
    ) => getGameConfigs(context, launcherId, language, options),
    getDeprecatedFileConfigs: (
      launcherId: string,
      language: string,
      options?: MetadataApiGetDeprecatedFileConfigsOptionalParams,
    ) => getDeprecatedFileConfigs(context, launcherId, language, options),
    getGameChannelSdks: (
      launcherId: string,
      language: string,
      options?: MetadataApiGetGameChannelSdksOptionalParams,
    ) => getGameChannelSdks(context, launcherId, language, options),
    getGamePackages: (
      launcherId: string,
      language: string,
      options?: MetadataApiGetGamePackagesOptionalParams,
    ) => getGamePackages(context, launcherId, language, options),
    getAllGameBasicInfo: (
      launcherId: string,
      language: string,
      options?: MetadataApiGetAllGameBasicInfoOptionalParams,
    ) => getAllGameBasicInfo(context, launcherId, language, options),
  };
}

export function _getMetadataApiOperations(context: LauncherGlobalContext): MetadataApiOperations {
  return {
    ..._getMetadataApi(context),
  };
}
