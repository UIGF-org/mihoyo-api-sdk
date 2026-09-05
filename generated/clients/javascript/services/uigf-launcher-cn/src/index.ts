// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { LauncherCNClient } from "./launcherCNClient.js";
export type {
  LauncherResponseGameBasicInfo,
  JsonObject,
  LauncherResponseJsonObject,
} from "./models/uigf/index.js";
export type { GameBasicInfo, DxConfigRequest, GpuInfo } from "./models/uigf/launcher/index.js";
export type { LauncherCNClientOptionalParams } from "./api/index.js";
export type {
  MetadataApiGetDxConfigsOptionalParams,
  MetadataApiGetWpfPackagesOptionalParams,
  MetadataApiGetGameBranchesOptionalParams,
  MetadataApiGetGameScanInfoOptionalParams,
  MetadataApiGetGameConfigsOptionalParams,
  MetadataApiGetDeprecatedFileConfigsOptionalParams,
  MetadataApiGetGameChannelSdksOptionalParams,
  MetadataApiGetGamePackagesOptionalParams,
  MetadataApiGetAllGameBasicInfoOptionalParams,
} from "./api/metadataApi/index.js";
export type { MetadataApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
