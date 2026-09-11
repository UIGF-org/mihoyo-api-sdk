// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGenshinUgcAnnouncementsClient } from "./gameGenshinUgcAnnouncementsClient.js";
export type {
  ApiResponseAnnouncementList,
  AnnouncementList,
  Announcement,
} from "./models/uigf/index.js";
export type { GameGenshinUgcAnnouncementsClientOptionalParams } from "./api/index.js";
export type { UgcApiGetAlertOptionalParams } from "./api/ugcApi/index.js";
export type { UgcApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
