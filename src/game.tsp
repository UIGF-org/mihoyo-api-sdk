import "@typespec/http";

using TypeSpec.Http;

namespace UIGF.Game;

model AuthKeyRequest {
  auth_appid: string = "webview_gacha";
  game_biz: string;
  game_uid: string;
  region: string;
}

model ActionTicketQuery {
  @query
  action_type: string;

  @query
  stoken: string;

  @query
  uid: string;
}

model CharacterListRequest {
  role_id: string;
  server: string;
}

model CharacterDetailRequest extends CharacterListRequest {
  character_ids: string[];
}

model AuthKeyQuery {
  @query
  authkey: string;

  @query
  auth_appid: string = "webview_gacha";

  @query
  authkey_ver: "1" = "1";

  @query
  sign_type: "2" = "2";

  @query
  lang: string = "zh-cn";
}

model GenshinGachaQuery extends AuthKeyQuery {
  @query
  gacha_type: string;

  @query
  gacha_id?: string;

  @query
  end_id?: string;

  @query
  page?: int32;

  @query
  size?: int32;

  @query
  region?: string;

  @query
  game_biz?: string;

  @query
  device_type?: string;

  @query
  game_version?: string;

  @query
  init_type?: string;

  @query
  no_joypad_close?: string;

  @query
  timestamp?: string;

  @query
  win_mode?: string;

}

model GameRecordQuery {
  @query
  server: string;

  @query("role_id")
  roleId: string;
}

model ScheduleRecordQuery extends GameRecordQuery {
  @query("schedule_type")
  scheduleType?: int32;

  @query("need_detail")
  needDetail?: boolean;

  @query("need_all")
  needAll?: boolean;
}

model LedgerRecordQuery extends GameRecordQuery {
  @query
  month?: string;

  @query
  type?: string;

  @query("current_page")
  currentPage?: int32;

  @query("page_size")
  pageSize?: int32;
}

model Character extends Record<unknown> {
  id?: int64;
  name?: string;
  level?: int32;
  image?: string;
  icon?: string;
  rarity?: int32;
  element?: string;
  fetter?: int32;
  actived_constellation_num?: int32;
}

model CharacterList extends Record<unknown> {
  list: Character[];
}

model DeviceFingerprintRequest extends Record<unknown> {
  app_name: string;
  device_fp: string;
  seed_id: string;
  device_id: string;
  ext_fields: string;
  platform: string;
  seed_time: string;
}

model DeviceFingerprint extends Record<unknown> {
  device_fp?: string;
  code?: int32;
  msg?: string;
}

model CalculateRequest extends Record<unknown> {}

model PandaQrRequest {
  app_id: int32;
  device: string;
  ticket?: string;
}

model PandaQrResponse extends Record<unknown> {
  ticket?: string;
  url?: string;
  stat?: string;
}
