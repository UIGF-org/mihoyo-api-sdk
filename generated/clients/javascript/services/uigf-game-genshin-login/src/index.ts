// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGenshinLoginClient } from "./gameGenshinLoginClient.js";
export type { ApiResponsePandaQrResponse } from "./models/uigf/index.js";
export type { PandaQrRequest, PandaQrResponse } from "./models/uigf/game/index.js";
export type { GameGenshinLoginClientOptionalParams } from "./api/index.js";
export type {
  PandaQrApiGetStatusOptionalParams,
  PandaQrApiCreateOptionalParams,
} from "./api/pandaQrApi/index.js";
export type { PandaQrApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
