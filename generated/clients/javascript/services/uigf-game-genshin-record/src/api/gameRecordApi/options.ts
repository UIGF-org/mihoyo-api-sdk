// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface GameRecordApiGetCharacterTpsOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface GameRecordApiGetActivityCalendarOptionalParams extends OperationOptions {
  challenge?: string;
}

/** Optional parameters. */
export interface GameRecordApiGetStygianPopularityOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface GameRecordApiGetStygianOnslaughtOptionalParams extends OperationOptions {
  scheduleType?: number;
  needDetail?: boolean;
  needAll?: boolean;
}

/** Optional parameters. */
export interface GameRecordApiGetCharacterMasterOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface GameRecordApiGetImaginariumTheaterOptionalParams extends OperationOptions {
  active?: number;
  scheduleType?: number;
  needDetail?: boolean;
  needAll?: boolean;
}

/** Optional parameters. */
export interface GameRecordApiGetSpiralAbyssOptionalParams extends OperationOptions {
  scheduleType?: number;
  needDetail?: boolean;
  needAll?: boolean;
}

/** Optional parameters. */
export interface GameRecordApiGetDailyNoteOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface GameRecordApiGetCharacterDetailsOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface GameRecordApiListCharactersOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface GameRecordApiGetIndexOptionalParams extends OperationOptions {
  avatarListType?: number;
}
