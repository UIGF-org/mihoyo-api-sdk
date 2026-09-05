import "@typespec/http";
import "@uigf/typespec-ds";

using TypeSpec.Http;

/** International HoYoLAB account binding APIs. */
@service(#{ title: "UIGF HoYoLAB Account API" })
@server("https://api-account-os.hoyolab.com", "HoYoLAB Account API")
namespace UIGF.Game.Global.Account {
  @route("/binding/api")
  interface BindingApi {
    @get
    @route("/getUserGameRolesByCookieToken")
    getRoles(
      @header("Cookie") cookie: string,
      @query game_biz: string,
    ): UIGF.ApiResponse<UIGF.GameRoleList>;
  }
}

/** International HoYoLAB game record APIs for Genshin, Star Rail, ZZZ, and Honkai Impact 3rd. */
@service(#{ title: "UIGF HoYoLAB Game Record API" })
@server("https://sg-public-api.hoyolab.com", "HoYoLAB Global Game Record API")
namespace UIGF.Game.Global.Records {
  @route("/event/game_record/app")
  @UIGF.Security.requiresDs("v2")
  interface GameRecordApi {
    @get
    @route("/genshin/api/index")
    getGenshinIndex(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      @query avatar_list_type?: int32,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/genshin/api/dailyNote")
    getGenshinDailyNote(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/hkrpg/api/index")
    getStarRailIndex(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/hkrpg/api/note")
    getStarRailDailyNote(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/hkrpg/api/challenge_peak")
    getStarRailChallengePeak(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }

  @route("/event/game_record_zzz/api/zzz")
  @UIGF.Security.requiresDs("v2")
  interface ZenlessGameRecordApi {
    @get
    @route("/index")
    getIndex(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/note")
    getDailyNote(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/gacha_record")
    getGachaRecord(
      @header("Cookie") cookie: string,
      @query uid: string,
      @query region: string,
      @query gacha_type: int32,
      @query end_id?: int64,
      @query lang?: string,
    ): UIGF.ApiResponse<UIGF.GachaLogPage>;

    @get
    @route("/hadal_info_v2")
    getShiyuDefense(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/hadal_mem_detail_v2")
    getDeadlyAssault(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      @query schedule_type: int32,
      @query region: string,
      @query uid: string,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/void_front_battle_abstract_info")
    getThresholdSimulationSummary(
      @header("Cookie") cookie: string,
      @query region: string,
      @query uid: string,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/void_front_battle_detail")
    getThresholdSimulationDetail(
      @header("Cookie") cookie: string,
      @query region: string,
      @query uid: string,
      @query void_front_id: int32,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }

  @route("/event/nap_cultivate_tool/user")
  interface ZenlessCultivationApi {
    @get
    @route("/item_list")
    getItems(
      @header("Cookie") cookie: string,
      @query uid: string,
      @query region: string,
      @query avatar_id: int32,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/icon_info")
    getIconInfo(
      @header("Cookie") cookie: string,
      @query uid: string,
      @query region: string,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }

  @route("/event/srledger")
  interface StarRailLedgerApi {
    @get
    @route("/month_info")
    getMonthInfo(
      @header("Cookie") cookie: string,
      ...UIGF.LedgerQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/month_detail")
    getMonthDetail(
      @header("Cookie") cookie: string,
      @query type: int32,
      @query current_page: int32,
      @query page_size?: int32,
      ...UIGF.LedgerQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }

  @route("/event/nap_ledger")
  interface ZenlessLedgerApi {
    @get
    @route("/month_info")
    getMonthInfo(
      @header("Cookie") cookie: string,
      ...UIGF.LedgerQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/month_detail")
    getMonthDetail(
      @header("Cookie") cookie: string,
      @query type: string,
      @query current_page: int32,
      @query page_size?: int32,
      ...UIGF.LedgerQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}

/** Global Genshin announcement and Traveller's Diary APIs. */
@service(#{ title: "UIGF Genshin Global API" })
@server("https://sg-hk4e-api.hoyoverse.com", "Global Genshin API")
namespace UIGF.Game.Global.Genshin {
  @route("/common/hk4e_global/announcement/api")
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

  @route("/event/ysledgeros")
  interface LedgerApi {
    @get
    @route("/month_info")
    getMonthInfo(
      @header("Cookie") cookie: string,
      ...UIGF.LedgerQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/month_detail")
    getMonthDetail(
      @header("Cookie") cookie: string,
      @query type: int32,
      @query current_page: int32,
      ...UIGF.LedgerQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}

/** Global community user, non-Genshin record, and Genshin challenge APIs on bbs-api-os. */
@service(#{ title: "UIGF HoYoLAB Community Record API" })
@server("https://bbs-api-os.hoyolab.com", "HoYoLAB Community Record API")
namespace UIGF.Game.Global.CommunityRecords {
  @route("/community/user/wapi")
  @UIGF.Security.requiresDs("v2")
  interface UserApi {
    @get
    @route("/getUserFullInfo")
    getFullInfo(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
    ): UIGF.ApiResponse<UIGF.CommunityUser>;
  }

  @route("/game_record/app/genshin/api")
  @UIGF.Security.requiresDs("v2")
  interface GenshinChallengeApi {
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
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/hard_challenge")
    getStygianOnslaught(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }

  @route("/game_record/app/hkrpg/api")
  @UIGF.Security.requiresDs("v2")
  interface StarRailChallengeApi {
    @get
    @route("/challenge")
    getForgottenHall(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/challenge_story")
    getPureFiction(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/challenge_boss")
    getApocalypticShadow(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/rogue")
    getSimulatedUniverse(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }

  @route("/game_record/app/honkai3rd/api")
  @UIGF.Security.requiresDs("v2")
  interface HonkaiImpactApi {
    @get
    @route("/index")
    getIndex(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/note")
    getDailyNote(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}
