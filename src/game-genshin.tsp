import "@typespec/http";
import "@uigf/typespec-ds";

using TypeSpec.Http;

/** CN Genshin game-record APIs used by TeyvatGuide, Snap Hutao, and Starward. */
@service(#{ title: "UIGF Genshin CN Game Record API" })
@server("https://api-takumi-record.mihoyo.com", "CN Genshin Game Record API")
namespace UIGF.Game.Genshin.Record {
  @route("/game_record/app/genshin/api")
  @UIGF.Security.requiresDs("v2")
  interface GameRecordApi {
    @get
    @route("/index")
    getIndex(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      @query avatar_list_type?: int32,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @post
    @route("/character/list")
    listCharacters(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      @body body: UIGF.Game.CharacterListRequest,
    ): UIGF.ApiResponse<UIGF.Game.CharacterList>;

    /** Character IDs should be sent in batches of at most 40, as used by TeyvatGuide. */
    @post
    @route("/character/detail")
    getCharacterDetails(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      @body body: UIGF.Game.CharacterDetailRequest,
    ): UIGF.ApiResponse<UIGF.Game.CharacterList>;

    @get
    @route("/dailyNote")
    getDailyNote(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/spiralAbyss")
    getSpiralAbyss(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/role_combat")
    getImaginariumTheater(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      @query active?: int32,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/char_master")
    getCharacterMaster(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/hard_challenge")
    getStygianOnslaught(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/hard_challenge/popularity")
    getStygianPopularity(
      @query server: string,
      @query role_id: int64,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @post
    @route("/act_calendar")
    getActivityCalendar(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      @header("x-rpc-challenge") challenge?: string,
      @body body: UIGF.Game.CharacterListRequest,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/tps")
    getCharacterTps(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }

  @route("/game_record/app/card/wapi")
  @UIGF.Security.requiresDs("v2")
  interface CardApi {
    @get
    @route("/getGameRecordCard")
    getGameRecordCard(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      @query uid: string,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}

/** CN Genshin gacha-history endpoints. Respect the vendor's request rate limits. */
@service(#{ title: "UIGF Genshin CN Gacha API" })
@server("https://public-operation-hk4e.mihoyo.com", "CN Genshin Gacha API")
namespace UIGF.Game.Genshin.Gacha {
  @route("/gacha_info/api")
  interface GachaLogApi {
    @get
    @route("/getGachaLog")
    getHistory(
      ...UIGF.Game.GenshinGachaQuery,
    ): UIGF.ApiResponse<UIGF.GachaLogPage>;

    @get
    @route("/getBeyondGachaLog")
    getBeyondHistory(
      ...UIGF.Game.GenshinGachaQuery,
    ): UIGF.ApiResponse<UIGF.GachaLogPage>;
  }
}

/** CN Genshin announcement endpoints. */
@service(#{ title: "UIGF Genshin CN Announcement API" })
@server("https://hk4e-ann-api.mihoyo.com", "CN Genshin Announcement API")
namespace UIGF.Game.Genshin.Announcements {
  @route("/common/hk4e_cn/announcement/api")
  interface AnnouncementApi {
    @get
    @route("/getAnnList")
    list(...UIGF.AnnouncementQuery): UIGF.ApiResponse<UIGF.AnnouncementList>;

    @get
    @route("/getAnnContent")
    getContent(
      ...UIGF.AnnouncementQuery,
    ): UIGF.ApiResponse<UIGF.AnnouncementList>;

    @get
    @route("/getAlertAnn")
    getAlert(
      ...UIGF.AnnouncementQuery,
    ): UIGF.ApiResponse<UIGF.AnnouncementList>;
  }
}

/** Deprecated official QR login endpoints retained for compatibility with TeyvatGuide. */
@service(#{ title: "UIGF Genshin CN QR Login API" })
@server("https://hk4e-sdk.mihoyo.com", "CN Genshin SDK API")
namespace UIGF.Game.Genshin.Login {
  @route("/hk4e_cn/combo/panda/qrcode")
  interface PandaQrApi {
    /** The upstream endpoint is deprecated; use only where officially supported. */
    @post
    @route("/fetch")
    create(
      @body body: UIGF.Game.PandaQrRequest,
    ): UIGF.ApiResponse<UIGF.Game.PandaQrResponse>;

    /** The upstream endpoint is deprecated; use only where officially supported. */
    @post
    @route("/query")
    getStatus(
      @body body: UIGF.Game.PandaQrRequest,
    ): UIGF.ApiResponse<UIGF.Game.PandaQrResponse>;
  }
}

/** CN Genshin Traveller's Diary ledger APIs. */
@service(#{ title: "UIGF Genshin CN Ledger API" })
@server("https://hk4e-api.mihoyo.com", "CN Genshin Ledger API")
namespace UIGF.Game.Genshin.Ledger {
  @route("/event/ys_ledger")
  @UIGF.Security.requiresDs("v2")
  interface LedgerApi {
    @get
    @route("/monthInfo")
    getMonthInfo(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      @query month?: int32,
      @query bind_uid: string,
      @query bind_region: string,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/monthDetail")
    getMonthDetail(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      @query month: int32,
      @query page: int32,
      @query type: int32,
      @query limit?: int32,
      @query bind_uid: string,
      @query bind_region: string,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}
