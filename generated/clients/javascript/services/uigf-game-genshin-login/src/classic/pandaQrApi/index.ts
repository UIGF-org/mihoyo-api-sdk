// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGenshinLoginContext } from "../../api/gameGenshinLoginContext.js";
import { getStatus, create } from "../../api/pandaQrApi/operations.js";
import {
  PandaQrApiGetStatusOptionalParams,
  PandaQrApiCreateOptionalParams,
} from "../../api/pandaQrApi/options.js";
import { PandaQrRequest } from "../../models/uigf/game/models.js";
import { ApiResponsePandaQrResponse } from "../../models/uigf/models.js";

/** Interface representing a PandaQrApi operations. */
export interface PandaQrApiOperations {
  /** The upstream endpoint is deprecated; use only where officially supported. */
  getStatus: (
    body: PandaQrRequest,
    options?: PandaQrApiGetStatusOptionalParams,
  ) => Promise<ApiResponsePandaQrResponse>;
  /** The upstream endpoint is deprecated; use only where officially supported. */
  create: (
    body: PandaQrRequest,
    options?: PandaQrApiCreateOptionalParams,
  ) => Promise<ApiResponsePandaQrResponse>;
}

function _getPandaQrApi(context: GameGenshinLoginContext) {
  return {
    getStatus: (body: PandaQrRequest, options?: PandaQrApiGetStatusOptionalParams) =>
      getStatus(context, body, options),
    create: (body: PandaQrRequest, options?: PandaQrApiCreateOptionalParams) =>
      create(context, body, options),
  };
}

export function _getPandaQrApiOperations(context: GameGenshinLoginContext): PandaQrApiOperations {
  return {
    ..._getPandaQrApi(context),
  };
}
