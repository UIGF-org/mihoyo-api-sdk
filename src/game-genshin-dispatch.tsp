import "@typespec/http";

using TypeSpec.Http;

namespace UIGF.Game.Genshin.Dispatch {
  model CurrentRegionQuery {
    @query account_type?: string;
    @query aid?: string;
    @query binary?: string;
    @query channel_id?: string;
    @query dispatchSeed?: string;
    @query key_id?: string;
    @query lang?: string;
    @query platform?: string;
    @query sub_channel_id?: string;
    @query time?: string;
    @query version?: string;
  }

  model RegionListQuery {
    @query binary?: string;
    @query channel_id?: string;
    @query lang?: string;
    @query platform?: string;
    @query sub_channel_id?: string;
    @query time?: string;
    @query version?: string;
  }

  model SignedDispatchResponse {
    content: string;
    sign: string;
  }
}

/** Resolves the current Genshin region from the CN game dispatch service. */
@service(#{ title: "UIGF Genshin CN Current Region Dispatch API" })
@server("https://cngfdispatch.yuanshen.com", "CN Genshin current-region dispatch API")
namespace UIGF.Game.Genshin.Dispatch.CurrentRegion {
  interface CurrentRegionApi {
    @get
    @route("/query_cur_region")
    query(
      ...UIGF.Game.Genshin.Dispatch.CurrentRegionQuery,
    ): UIGF.Game.Genshin.Dispatch.SignedDispatchResponse;
  }
}

/** Returns the encrypted CN Genshin region list delivered by the global dispatcher. */
@service(#{ title: "UIGF Genshin CN Region List Dispatch API" })
@server("https://dispatchcnglobal.yuanshen.com", "CN Genshin region-list dispatch API")
namespace UIGF.Game.Genshin.Dispatch.RegionList {
  interface RegionListApi {
    @get
    @route("/query_region_list")
    query(
      ...UIGF.Game.Genshin.Dispatch.RegionListQuery,
    ): bytes;
  }
}

/** Resolves the game gateway address for a selected CN Genshin region. */
@service(#{ title: "UIGF Genshin CN Gate Dispatch API" })
@server("https://dispatch-hk4e-cn-cn-gf01.mihoyo.com", "CN Genshin gate dispatch API")
namespace UIGF.Game.Genshin.Dispatch.Gate {
  @route("/dispatch/dispatch")
  interface GateApi {
    @get
    @route("/getGateAddress")
    getAddress(
      @query game: string,
      @query region: string,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}
