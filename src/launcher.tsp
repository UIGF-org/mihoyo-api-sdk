import "@typespec/http";

using TypeSpec.Http;

namespace UIGF.Launcher {
  model LauncherQuery {
    @query("launcher_id")
    launcherId: string;

    @query
    language: string;

    @query("game_ids[]")
    gameIds?: string[];
  }

  model ChannelQuery extends LauncherQuery {
    @query
    channel?: int32;

    @query("sub_channel")
    subChannel?: int32;
  }

  model SophonBuildQuery {
    @query
    branch: string;

    @query("package_id")
    packageId: string;

    @query
    password: string;

    @query
    tag?: string;
  }

  model GpuInfo extends Record<unknown> {
    name?: string;
    vendor_id?: int32;
    device_id?: int32;
  }

  model DxConfigRequest {
    launcher_id: string;
    language: string;
    game_ids: string[];
    gpu_info: GpuInfo[];
  }

  model GamePackage extends Record<unknown> {
    game_id?: string;
    game_name?: string;
    main?: JsonObject;
    pre_download?: JsonObject;
  }

  model GameBasicInfo extends Record<unknown> {
    game_info_list?: JsonObject[];
  }
}

/** HoYoPlay launcher metadata for CN official and Bilibili launcher IDs. */
@service(#{ title: "UIGF HoYoPlay CN API" })
@server("https://hyp-api.mihoyo.com", "CN HoYoPlay API")
namespace UIGF.Launcher.CN {
  @route("/hyp/hyp-connect/api")
  interface MetadataApi {
    @get
    @route("/getAllGameBasicInfo")
    getAllGameBasicInfo(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.Launcher.GameBasicInfo>;

    @get
    @route("/getGamePackages")
    getGamePackages(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameChannelSDKs")
    getGameChannelSdks(
      ...UIGF.Launcher.ChannelQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameDeprecatedFileConfigs")
    getDeprecatedFileConfigs(
      ...UIGF.Launcher.ChannelQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameConfigs")
    getGameConfigs(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameScanInfo")
    getGameScanInfo(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameBranches")
    getGameBranches(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getWPFPackages")
    getWpfPackages(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @post
    @route("/getDXConfigs")
    getDxConfigs(
      ...UIGF.Launcher.LauncherQuery,
      @body body: UIGF.Launcher.DxConfigRequest,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;
  }
}

/** HoYoPlay launcher metadata for the global launcher. */
@service(#{ title: "UIGF HoYoPlay Global API" })
@server("https://sg-hyp-api.hoyoverse.com", "Global HoYoPlay API")
namespace UIGF.Launcher.Global {
  @route("/hyp/hyp-connect/api")
  interface MetadataApi {
    @get
    @route("/getAllGameBasicInfo")
    getAllGameBasicInfo(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.Launcher.GameBasicInfo>;

    @get
    @route("/getGamePackages")
    getGamePackages(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameChannelSDKs")
    getGameChannelSdks(
      ...UIGF.Launcher.ChannelQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameDeprecatedFileConfigs")
    getDeprecatedFileConfigs(
      ...UIGF.Launcher.ChannelQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameConfigs")
    getGameConfigs(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameScanInfo")
    getGameScanInfo(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getGameBranches")
    getGameBranches(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @get
    @route("/getWPFPackages")
    getWpfPackages(
      ...UIGF.Launcher.LauncherQuery,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;

    @post
    @route("/getDXConfigs")
    getDxConfigs(
      ...UIGF.Launcher.LauncherQuery,
      @body body: UIGF.Launcher.DxConfigRequest,
    ): UIGF.LauncherResponse<UIGF.JsonObject>;
  }
}

/** CN Sophon chunk and incremental-patch manifests. */
@service(#{ title: "UIGF Sophon CN API" })
@server("https://downloader-api.mihoyo.com", "CN Sophon Downloader API")
namespace UIGF.Launcher.Sophon.CN {
  @route("/downloader/sophon_chunk/api")
  interface BuildApi {
    @get
    @route("/getBuild")
    getBuild(
      ...UIGF.Launcher.SophonBuildQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @post
    @route("/getPatchBuild")
    getPatchBuild(
      ...UIGF.Launcher.SophonBuildQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}

/** Global Sophon chunk and incremental-patch manifests. */
@service(#{ title: "UIGF Sophon Global API" })
@server(
  "https://sg-downloader-api.hoyoverse.com",
  "Global Sophon Downloader API"
)
namespace UIGF.Launcher.Sophon.Global {
  @route("/downloader/sophon_chunk/api")
  interface BuildApi {
    @get
    @route("/getBuild")
    getBuild(
      ...UIGF.Launcher.SophonBuildQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;

    @post
    @route("/getPatchBuild")
    getPatchBuild(
      ...UIGF.Launcher.SophonBuildQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}
