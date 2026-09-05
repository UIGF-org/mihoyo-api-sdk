// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGlobalGenshinClient } from "./gameGlobalGenshinClient.js";
export type {
  ApiResponseAnnouncementList,
  AnnouncementList,
  Announcement,
  ApiResponseJsonObject,
  JsonObject,
} from "./models/uigf/index.js";
export type { GameGlobalGenshinClientOptionalParams } from "./api/index.js";
export type {
  AnnouncementApiGetAlertOptionalParams,
  AnnouncementApiGetContentOptionalParams,
  AnnouncementApiListOptionalParams,
} from "./api/announcementApi/index.js";
export type {
  LedgerApiGetMonthDetailOptionalParams,
  LedgerApiGetMonthInfoOptionalParams,
} from "./api/ledgerApi/index.js";
export type { AnnouncementApiOperations, LedgerApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
