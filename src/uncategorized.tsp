import "@typespec/http";

using TypeSpec.Http;

/**
 * Endpoints observed in official traffic that do not yet have a stable product
 * namespace. They are kept separate from gameplay and account APIs until a
 * later capture establishes a narrower contract.
 */
namespace UIGF.Uncategorized {
  model ComboTokenRequest {
    biz: string;
  }

  model ExperimentParameter {
    k: string;
    v: string;
  }

  model ExperimentListRequest {
    app_id: int32;
    app_sign: string;
    params: ExperimentParameter[];
    scene_id: string;
    uid: string;
  }

  model ExperimentListResponse extends UIGF.ApiResponse<UIGF.JsonObject[]> {
    success?: boolean;
  }

  model UploadResponse {
    code: int32;
    message: string;
  }

  model TelemetryUploadHeaders {
    @header("Authorization") authorization?: string;
    @header("CONTENT-MD5") contentMd5?: string;
    @header("DATE") date?: string;
    @header("cms-signature") cmsSignature?: string;
  }

  model H5LogRequest {
    data: string;
  }
}

/** Token exchange endpoint whose product ownership cannot be inferred from the capture. */
@service(#{ title: "UIGF Uncategorized Combo Token API" })
@server("https://api-takumi.mihoyo.com", "MiHoYo Takumi API")
namespace UIGF.Uncategorized.ComboToken {
  @route("/upload/outer")
  interface ComboTokenApi {
    @post
    @route("/GetStByComboToken")
    exchange(
      @body body: UIGF.Uncategorized.ComboTokenRequest,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}

/** UGC token and binary level-gateway endpoints. */
@service(#{ title: "UIGF Uncategorized UGC API" })
@server("https://ugc-api.mihoyo.com", "MiHoYo UGC API")
namespace UIGF.Uncategorized.UGC {
  @route("/ugc_login/v1/client")
  interface TokenApi {
    @get
    @route("/ugc_token")
    get(
      ...UIGF.Game.AuthKeyQuery,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }

  @route("/ugc_gateway/v1")
  interface LevelApi {
    /** The observed request and response use the vendor's protobuf media type. */
    @post
    @route("/level_rec/index_redpoint")
    getIndexRedpoint(): bytes;

    /** The gateway payload is opaque protobuf data in the available capture. */
    @post
    @route("/levels/collection/tiny_info")
    getCollectionTinyInfo(
      @body body: bytes,
    ): bytes;
  }
}

/** Feature-experiment assignments returned to the official game client. */
@service(#{ title: "UIGF Uncategorized Experiment API" })
@server("https://data-abtest-api.mihoyo.com", "MiHoYo experiment API")
namespace UIGF.Uncategorized.Experimentation {
  @route("/data_abtest_api/config/experiment")
  interface ExperimentApi {
    @post
    @route("/list")
    list(
      @body body: UIGF.Uncategorized.ExperimentListRequest,
    ): UIGF.Uncategorized.ExperimentListResponse;
  }
}

/** Game SDK diagnostics, crash reports, and performance configuration. */
@service(#{ title: "UIGF Uncategorized Game Telemetry API" })
@server("https://ys-log-upload.mihoyo.com", "MiHoYo game telemetry API")
namespace UIGF.Uncategorized.Telemetry.Game {
  @route("/perf/config")
  interface PerformanceApi {
    @get
    @route("/verify")
    verify(
      @query device_id: string,
      @query name: string,
      @query platform: string,
    ): UIGF.Uncategorized.UploadResponse;
  }

  interface UploadApi {
    /** The official client signs the upload headers; signing is intentionally caller-owned. */
    @post
    @route("/crash/dataUpload")
    uploadCrash(
      ...UIGF.Uncategorized.TelemetryUploadHeaders,
      @body body: UIGF.JsonObject[],
    ): UIGF.Uncategorized.UploadResponse;

    @post
    @route("/sdk/dataUpload")
    uploadSdk(
      ...UIGF.Uncategorized.TelemetryUploadHeaders,
      @body body: UIGF.JsonObject[],
    ): UIGF.Uncategorized.UploadResponse;

    @post
    @route("/ys_custom/dataUpload")
    uploadCustom(
      ...UIGF.Uncategorized.TelemetryUploadHeaders,
      @body body: UIGF.JsonObject[],
    ): UIGF.Uncategorized.UploadResponse;
  }
}

/** SDK telemetry upload endpoint with the same observed event-array payload shape. */
@service(#{ title: "UIGF Uncategorized SDK Telemetry API" })
@server("https://sdk-log-upload.mihoyo.com", "MiHoYo SDK telemetry API")
namespace UIGF.Uncategorized.Telemetry.SDK {
  interface UploadApi {
    @post
    @route("/sdk/dataUpload")
    upload(
      ...UIGF.Uncategorized.TelemetryUploadHeaders,
      @body body: UIGF.JsonObject[],
    ): UIGF.Uncategorized.UploadResponse;
  }
}

/** Web-view telemetry batch endpoint. */
@service(#{ title: "UIGF Uncategorized H5 Telemetry API" })
@server("https://h5log-api-dualstack.mihoyo.com", "MiHoYo H5 telemetry API")
namespace UIGF.Uncategorized.Telemetry.H5 {
  @route("/common/h5log/log")
  interface BatchApi {
    @post
    @route("/batch")
    upload(
      @query topic: string,
      @header("DATE") date?: string,
      @body body: UIGF.Uncategorized.H5LogRequest,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}

/** Raw game crash-report endpoint observed on the Yuanshen service host. */
@service(#{ title: "UIGF Uncategorized Yuanshen Crash API" })
@server("https://cnuspider.yuanshen.com", "Yuanshen crash report API")
namespace UIGF.Uncategorized.Telemetry.Crash {
  interface CrashApi {
    @post
    @route("/log")
    upload(
      @body body: UIGF.JsonObject,
    ): void;
  }
}
