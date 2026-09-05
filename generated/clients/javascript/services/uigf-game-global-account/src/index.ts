// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

export { GameGlobalAccountClient } from "./gameGlobalAccountClient.js";
export type { ApiResponseGameRoleList, GameRoleList, GameRole } from "./models/uigf/index.js";
export type { GameGlobalAccountClientOptionalParams } from "./api/index.js";
export type { BindingApiGetRolesOptionalParams } from "./api/bindingApi/index.js";
export type { BindingApiOperations } from "./classic/index.js";
export { RestError, isRestError } from "@azure/core-rest-pipeline";
