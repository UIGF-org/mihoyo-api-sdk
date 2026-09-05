// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { GameGlobalRecordsContext } from "../../api/gameGlobalRecordsContext.js";
import {
  getThresholdSimulationDetail,
  getThresholdSimulationSummary,
  getDeadlyAssault,
  getShiyuDefense,
  getGachaRecord,
  getDailyNote,
  getIndex,
} from "../../api/zenlessGameRecordApi/operations.js";
import {
  ZenlessGameRecordApiGetThresholdSimulationDetailOptionalParams,
  ZenlessGameRecordApiGetThresholdSimulationSummaryOptionalParams,
  ZenlessGameRecordApiGetDeadlyAssaultOptionalParams,
  ZenlessGameRecordApiGetShiyuDefenseOptionalParams,
  ZenlessGameRecordApiGetGachaRecordOptionalParams,
  ZenlessGameRecordApiGetDailyNoteOptionalParams,
  ZenlessGameRecordApiGetIndexOptionalParams,
} from "../../api/zenlessGameRecordApi/options.js";
import { ApiResponseJsonObject, ApiResponseGachaLogPage } from "../../models/uigf/models.js";

/** Interface representing a ZenlessGameRecordApi operations. */
export interface ZenlessGameRecordApiOperations {
  getThresholdSimulationDetail: (
    cookie: string,
    region: string,
    uid: string,
    voidFrontId: number,
    options?: ZenlessGameRecordApiGetThresholdSimulationDetailOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getThresholdSimulationSummary: (
    cookie: string,
    region: string,
    uid: string,
    options?: ZenlessGameRecordApiGetThresholdSimulationSummaryOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getDeadlyAssault: (
    cookie: string,
    scheduleType: number,
    region: string,
    uid: string,
    options?: ZenlessGameRecordApiGetDeadlyAssaultOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getShiyuDefense: (
    cookie: string,
    server: string,
    roleId: string,
    options?: ZenlessGameRecordApiGetShiyuDefenseOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getGachaRecord: (
    cookie: string,
    uid: string,
    region: string,
    gachaType: number,
    options?: ZenlessGameRecordApiGetGachaRecordOptionalParams,
  ) => Promise<ApiResponseGachaLogPage>;
  getDailyNote: (
    cookie: string,
    server: string,
    roleId: string,
    options?: ZenlessGameRecordApiGetDailyNoteOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
  getIndex: (
    cookie: string,
    server: string,
    roleId: string,
    options?: ZenlessGameRecordApiGetIndexOptionalParams,
  ) => Promise<ApiResponseJsonObject>;
}

function _getZenlessGameRecordApi(context: GameGlobalRecordsContext) {
  return {
    getThresholdSimulationDetail: (
      cookie: string,
      region: string,
      uid: string,
      voidFrontId: number,
      options?: ZenlessGameRecordApiGetThresholdSimulationDetailOptionalParams,
    ) => getThresholdSimulationDetail(context, cookie, region, uid, voidFrontId, options),
    getThresholdSimulationSummary: (
      cookie: string,
      region: string,
      uid: string,
      options?: ZenlessGameRecordApiGetThresholdSimulationSummaryOptionalParams,
    ) => getThresholdSimulationSummary(context, cookie, region, uid, options),
    getDeadlyAssault: (
      cookie: string,
      scheduleType: number,
      region: string,
      uid: string,
      options?: ZenlessGameRecordApiGetDeadlyAssaultOptionalParams,
    ) => getDeadlyAssault(context, cookie, scheduleType, region, uid, options),
    getShiyuDefense: (
      cookie: string,
      server: string,
      roleId: string,
      options?: ZenlessGameRecordApiGetShiyuDefenseOptionalParams,
    ) => getShiyuDefense(context, cookie, server, roleId, options),
    getGachaRecord: (
      cookie: string,
      uid: string,
      region: string,
      gachaType: number,
      options?: ZenlessGameRecordApiGetGachaRecordOptionalParams,
    ) => getGachaRecord(context, cookie, uid, region, gachaType, options),
    getDailyNote: (
      cookie: string,
      server: string,
      roleId: string,
      options?: ZenlessGameRecordApiGetDailyNoteOptionalParams,
    ) => getDailyNote(context, cookie, server, roleId, options),
    getIndex: (
      cookie: string,
      server: string,
      roleId: string,
      options?: ZenlessGameRecordApiGetIndexOptionalParams,
    ) => getIndex(context, cookie, server, roleId, options),
  };
}

export function _getZenlessGameRecordApiOperations(
  context: GameGlobalRecordsContext,
): ZenlessGameRecordApiOperations {
  return {
    ..._getZenlessGameRecordApi(context),
  };
}
