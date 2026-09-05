// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../static-helpers/serialization/serialize-record.js";

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseAnnouncementList {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: AnnouncementList;
}

export function apiResponseAnnouncementListDeserializer(item: any): ApiResponseAnnouncementList {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: announcementListDeserializer(item["data"]),
  };
}

/** model interface AnnouncementList */
export interface AnnouncementList {
  list?: Announcement[];
  alert?: boolean;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function announcementListDeserializer(item: any): AnnouncementList {
  return {
    additionalProperties: serializeRecord(item, ["list", "alert"]),
    list: !item["list"] ? item["list"] : announcementArrayDeserializer(item["list"]),
    alert: item["alert"],
  };
}

export function announcementArrayDeserializer(result: Array<Announcement>): any[] {
  return result.map((item) => {
    return announcementDeserializer(item);
  });
}

/** model interface Announcement */
export interface Announcement {
  annId?: number;
  title?: string;
  subtitle?: string;
  banner?: string;
  content?: string;
  startTime?: string;
  endTime?: string;
  type?: number;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function announcementDeserializer(item: any): Announcement {
  return {
    additionalProperties: serializeRecord(item, [
      "ann_id",
      "title",
      "subtitle",
      "banner",
      "content",
      "start_time",
      "end_time",
      "type",
    ]),
    annId: item["ann_id"],
    title: item["title"],
    subtitle: item["subtitle"],
    banner: item["banner"],
    content: item["content"],
    startTime: item["start_time"],
    endTime: item["end_time"],
    type: item["type"],
  };
}
