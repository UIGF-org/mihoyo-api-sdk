// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { OperationOptions } from "@azure-rest/core-client";

/** Optional parameters. */
export interface ZenlessGameRecordApiGetThresholdSimulationDetailOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ZenlessGameRecordApiGetThresholdSimulationSummaryOptionalParams extends OperationOptions {}

/** Optional parameters. */
export interface ZenlessGameRecordApiGetDeadlyAssaultOptionalParams extends OperationOptions {
  ds?: string;
}

/** Optional parameters. */
export interface ZenlessGameRecordApiGetShiyuDefenseOptionalParams extends OperationOptions {
  ds?: string;
  scheduleType?: number;
  needDetail?: boolean;
  needAll?: boolean;
}

/** Optional parameters. */
export interface ZenlessGameRecordApiGetGachaRecordOptionalParams extends OperationOptions {
  endId?: number;
  lang?: string;
}

/** Optional parameters. */
export interface ZenlessGameRecordApiGetDailyNoteOptionalParams extends OperationOptions {
  ds?: string;
}

/** Optional parameters. */
export interface ZenlessGameRecordApiGetIndexOptionalParams extends OperationOptions {
  ds?: string;
}
