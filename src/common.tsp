import "@typespec/http";

using TypeSpec.Http;

namespace UIGF;

/** A JSON object whose vendor-defined properties are preserved by generated clients. */
model JsonObject extends Record<unknown> {}

/** Common response wrapper returned by MiHoYo and HoYoLAB services. */
model ApiResponse<T> {
  /** Vendor result code. `0` normally represents success. */
  retcode: int32;

  /** Vendor diagnostic message. */
  message: string;

  /** Endpoint-specific payload. */
  data: T;
}

/** Common envelope used by the HoYoPlay and Sophon APIs. */
model LauncherResponse<T> {
  retcode: int32;
  message: string;
  data: T;
}

/** Cookie-based authentication carried by the endpoint's `Cookie` header. */
model CookieHeaders {
  @header("Cookie")
  cookie: string;
}

/** Headers used by APIs that require a Dynamic Secret (DS) request signature. */
model SignedHeaders extends CookieHeaders {
  @header("DS")
  ds: string;

  @header("x-rpc-app_version")
  appVersion?: string;

  @header("x-rpc-client_type")
  clientType?: string;

  @header("x-rpc-device_id")
  deviceId?: string;

  @header("x-rpc-device_fp")
  deviceFingerprint?: string;

  @header("x-rpc-challenge")
  challenge?: string;
}

/** Standard game account identity reused by record APIs. */
model GameRole {
  game_biz: string;
  region: string;
  game_uid: string;
  nickname?: string;
  level?: int32;
  is_chosen?: boolean;
  region_name?: string;
  game_name?: string;
}

model GameRoleList {
  list: GameRole[];
}

/** A user profile returned by community-account APIs. */
model CommunityUser extends Record<unknown> {
  uid: string;
  nickname?: string;
  introduce?: string;
  avatar_url?: string;
  gender?: int32;
  level_exp?: JsonObject;
  community_info?: JsonObject;
}

model Pagination {
  @query
  page?: int32;

  @query
  size?: int32;
}

model RoleQuery {
  @query("role_id")
  roleId: string;

  @query
  server: string;
}

model LedgerQuery extends RoleQuery {
  @query
  month?: string;

  @query
  lang?: string;
}

/** A game announcement query shared by CN and global announcement hosts. */
model AnnouncementQuery {
  @query
  game: string;

  @query("game_biz")
  gameBiz: string;

  @query
  lang: string;

  @query("bundle_id")
  bundleId: string;

  @query
  platform: "pc" | "android" | "ios";

  @query
  region: string;

  @query
  level?: int32;

  @query
  uid?: string;

  @query("channel_id")
  channelId?: int32;
}

model Announcement extends Record<unknown> {
  ann_id?: int64;
  title?: string;
  subtitle?: string;
  banner?: string;
  content?: string;
  start_time?: string;
  end_time?: string;
  type?: int32;
}

model AnnouncementList extends Record<unknown> {
  list?: Announcement[];
  alert?: boolean;
}

model GachaItem extends Record<unknown> {
  uid?: string;
  gacha_type?: string;
  item_id?: string;
  count?: string;
  time?: string;
  name?: string;
  item_type?: string;
  rank_type?: string;
  id: string;
}

model GachaLogPage extends Record<unknown> {
  page?: int32;
  size?: int32;
  total?: int32;
  region?: string;
  list: GachaItem[];
}
