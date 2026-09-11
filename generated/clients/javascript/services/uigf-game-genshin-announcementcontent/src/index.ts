// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGenshinAnnouncementContentClient } from "./gameGenshinAnnouncementContentClient.js";
export type {
  ApiResponseAnnouncementList,
  AnnouncementList,
  Announcement,
} from "./models/uigf/index.js";
export type { GameGenshinAnnouncementContentClientOptionalParams } from "./api/index.js";
export type { ContentApiGetOptionalParams } from "./api/contentApi/index.js";
export type { ContentApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
