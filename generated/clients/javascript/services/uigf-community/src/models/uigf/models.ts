// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../static-helpers/serialization/serialize-record.js";
import {
  Post,
  postDeserializer,
  PostList,
  postListDeserializer,
  ForumList,
  forumListDeserializer,
} from "./community/models.js";

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseCommunityUser {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: CommunityUser;
}

export function apiResponseCommunityUserDeserializer(item: any): ApiResponseCommunityUser {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: communityUserDeserializer(item["data"]),
  };
}

/** A user profile returned by community-account APIs. */
export interface CommunityUser {
  uid: string;
  nickname?: string;
  introduce?: string;
  avatarUrl?: string;
  gender?: number;
  levelExp?: JsonObject;
  communityInfo?: JsonObject;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function communityUserDeserializer(item: any): CommunityUser {
  return {
    additionalProperties: serializeRecord(item, [
      "uid",
      "nickname",
      "introduce",
      "avatar_url",
      "gender",
      "level_exp",
      "community_info",
    ]),
    uid: item["uid"],
    nickname: item["nickname"],
    introduce: item["introduce"],
    avatarUrl: item["avatar_url"],
    gender: item["gender"],
    levelExp: !item["level_exp"] ? item["level_exp"] : jsonObjectDeserializer(item["level_exp"]),
    communityInfo: !item["community_info"]
      ? item["community_info"]
      : jsonObjectDeserializer(item["community_info"]),
  };
}

/** A JSON object whose vendor-defined properties are preserved by generated clients. */
export interface JsonObject {
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function jsonObjectDeserializer(item: any): JsonObject {
  return {
    additionalProperties: serializeRecord(item, []),
  };
}

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseJsonObject {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: JsonObject;
}

export function apiResponseJsonObjectDeserializer(item: any): ApiResponseJsonObject {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: jsonObjectDeserializer(item["data"]),
  };
}

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponsePost {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: Post;
}

export function apiResponsePostDeserializer(item: any): ApiResponsePost {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: postDeserializer(item["data"]),
  };
}

export function jsonObjectArrayDeserializer(result: Array<JsonObject>): any[] {
  return result.map((item) => {
    return jsonObjectDeserializer(item);
  });
}

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponsePostList {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: PostList;
}

export function apiResponsePostListDeserializer(item: any): ApiResponsePostList {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: postListDeserializer(item["data"]),
  };
}

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
export interface ApiResponseForumList {
  /** Vendor result code. `0` normally represents success. */
  retcode: number;
  /** Vendor diagnostic message. */
  message: string;
  /** Endpoint-specific payload. */
  data: ForumList;
}

export function apiResponseForumListDeserializer(item: any): ApiResponseForumList {
  return {
    retcode: item["retcode"],
    message: item["message"],
    data: forumListDeserializer(item["data"]),
  };
}
