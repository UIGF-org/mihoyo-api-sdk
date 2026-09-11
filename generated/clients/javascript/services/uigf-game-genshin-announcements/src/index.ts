// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGenshinAnnouncementsClient } from "./gameGenshinAnnouncementsClient.js";
export type {
  ApiResponseAnnouncementList,
  AnnouncementList,
  Announcement,
} from "./models/uigf/index.js";
export type { GameGenshinAnnouncementsClientOptionalParams } from "./api/index.js";
export type {
  AnnouncementApiGetAlertPictureOptionalParams,
  AnnouncementApiGetAlertOptionalParams,
  AnnouncementApiListOptionalParams,
} from "./api/announcementApi/index.js";
export type { AnnouncementApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
