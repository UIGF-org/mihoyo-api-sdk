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

model GenshinGachaQuery {
  @query
  authkey: string;

  @query
  gacha_type: string;

  @query
  end_id?: string;

  @query
  lang: string = "zh-cn";

  @query
  auth_appid: string = "webview_gacha";

  @query
  authkey_ver: "1" = "1";

  @query
  sign_type: "2" = "2";

  @query
  size?: int32;
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
  seed_id: string;
  device_id: string;
  platform: string;
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
