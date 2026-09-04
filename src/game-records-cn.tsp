import "@typespec/http";
import "@uigf/typespec-ds";

using TypeSpec.Http;

/** CN game-record APIs for Honkai Impact 3rd, Star Rail, and Zenless Zone Zero. */
@service(#{ title: "UIGF MiHoYo CN Cross-Game Record API" })
@server("https://api-takumi-record.mihoyo.com", "CN Game Record API")
namespace UIGF.Game.CN.Records {
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
  }

  @route("/game_record/app/hkrpg/api")
  @UIGF.Security.requiresDs("v2")
  interface StarRailApi {
    @get
    @route("/index")
    getIndex(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/note")
    getDailyNote(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

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
      @query need_detail?: boolean,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/challenge_peak")
    getChallengePeak(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }

  @route("/event/game_record_zzz/api/zzz")
  @UIGF.Security.requiresDs("v2")
  interface ZenlessApi {
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
      @header("DS") ds: string,
      ...UIGF.Game.ScheduleRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @get
    @route("/hadal_mem_detail_v2")
    getDeadlyAssault(
      @header("Cookie") cookie: string,
      @header("DS") ds: string,
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
}

/** CN ledger and Zenless cultivation-tool APIs. */
@service(#{ title: "UIGF MiHoYo CN Game Event API" })
@server("https://api-takumi.mihoyo.com", "CN Takumi Event API")
namespace UIGF.Game.CN.Events {
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
}

/** CN Honkai Impact 3rd real-time note uses a dedicated activity host. */
@service(#{ title: "UIGF Honkai Impact 3rd CN API" })
@server("https://act-api-takumi.mihoyo.com", "CN Activity API")
namespace UIGF.Game.CN.HonkaiImpact {
  @route("/game_record/appv2/honkai3rd/api")
  @UIGF.Security.requiresDs("v2")
  interface DailyNoteApi {
    @get
    @route("/note")
    getDailyNote(
      @header("Cookie") cookie: string,
      @header("DS") ds?: string,
      ...UIGF.Game.GameRecordQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}
