// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface GameRecordApiGetStarRailChallengePeakOptionalParams extends OperationOptions {
  ds?: string;
  scheduleType?: number;
  needDetail?: boolean;
  needAll?: boolean;
}

/** Optional parameters. */
export interface GameRecordApiGetStarRailDailyNoteOptionalParams extends OperationOptions {
  ds?: string;
}

/** Optional parameters. */
export interface GameRecordApiGetStarRailIndexOptionalParams extends OperationOptions {
  ds?: string;
}

/** Optional parameters. */
export interface GameRecordApiGetGenshinDailyNoteOptionalParams extends OperationOptions {
  ds?: string;
}

/** Optional parameters. */
export interface GameRecordApiGetGenshinIndexOptionalParams extends OperationOptions {
  ds?: string;
  avatarListType?: number;
}
