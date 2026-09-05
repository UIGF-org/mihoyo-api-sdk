// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/*
 * This file contains only generated model types and their (de)serializers.
 * Disable the following rules for internal models with '_' prefix and deserializers which require 'any' for raw JSON input.
 */
/* eslint-disable @typescript-eslint/naming-convention */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { serializeRecord } from "../../../static-helpers/serialization/serialize-record.js";
import {
  CommunityUser,
  communityUserDeserializer,
  JsonObject,
  jsonObjectArrayDeserializer,
} from "../models.js";

/** model interface VerificationCreateRequest */
export interface VerificationCreateRequest {
  actionType: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function verificationCreateRequestSerializer(item: VerificationCreateRequest): any {
  return { ...serializeRecord(item.additionalProperties ?? {}), action_type: item["actionType"] };
}

/** model interface VerificationSubmitRequest */
export interface VerificationSubmitRequest {
  challenge: string;
  validate: string;
  seccode?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function verificationSubmitRequestSerializer(item: VerificationSubmitRequest): any {
  return {
    ...serializeRecord(item.additionalProperties ?? {}),
    challenge: item["challenge"],
    validate: item["validate"],
    seccode: item["seccode"],
  };
}

/** model interface Post */
export interface Post {
  postId?: string;
  subject?: string;
  content?: string;
  createdAt?: number;
  user?: CommunityUser;
  images?: JsonObject[];
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function postDeserializer(item: any): Post {
  return {
    additionalProperties: serializeRecord(item, [
      "post_id",
      "subject",
      "content",
      "created_at",
      "user",
      "images",
    ]),
    postId: item["post_id"],
    subject: item["subject"],
    content: item["content"],
    createdAt: item["created_at"],
    user: !item["user"] ? item["user"] : communityUserDeserializer(item["user"]),
    images: !item["images"] ? item["images"] : jsonObjectArrayDeserializer(item["images"]),
  };
}

/** model interface PostList */
export interface PostList {
  list?: Post[];
  isLast?: boolean;
  lastId?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function postListDeserializer(item: any): PostList {
  return {
    additionalProperties: serializeRecord(item, ["list", "is_last", "last_id"]),
    list: !item["list"] ? item["list"] : postArrayDeserializer(item["list"]),
    isLast: item["is_last"],
    lastId: item["last_id"],
  };
}

export function postArrayDeserializer(result: Array<Post>): any[] {
  return result.map((item) => {
    return postDeserializer(item);
  });
}

/** model interface FavoritePostRequest */
export interface FavoritePostRequest {
  postId: string;
  isCancel: boolean;
}

export function favoritePostRequestSerializer(item: FavoritePostRequest): any {
  return { post_id: item["postId"], is_cancel: item["isCancel"] };
}

/** model interface ForumList */
export interface ForumList {
  list?: Forum[];
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function forumListDeserializer(item: any): ForumList {
  return {
    additionalProperties: serializeRecord(item, ["list"]),
    list: !item["list"] ? item["list"] : forumArrayDeserializer(item["list"]),
  };
}

export function forumArrayDeserializer(result: Array<Forum>): any[] {
  return result.map((item) => {
    return forumDeserializer(item);
  });
}

/** model interface Forum */
export interface Forum {
  id?: number;
  gameId?: number;
  name?: string;
  icon?: string;
  /** Additional properties */
  additionalProperties?: Record<string, any>;
}

export function forumDeserializer(item: any): Forum {
  return {
    additionalProperties: serializeRecord(item, ["id", "game_id", "name", "icon"]),
    id: item["id"],
    gameId: item["game_id"],
    name: item["name"],
    icon: item["icon"],
  };
}

/** model interface SignInRequest */
export interface SignInRequest {
  gids: number;
}

export function signInRequestSerializer(item: SignInRequest): any {
  return { gids: item["gids"] };
}

/** model interface LikePostRequest */
export interface LikePostRequest {
  postId: string;
  isCancel: boolean;
}

export function likePostRequestSerializer(item: LikePostRequest): any {
  return { post_id: item["postId"], is_cancel: item["isCancel"] };
}
