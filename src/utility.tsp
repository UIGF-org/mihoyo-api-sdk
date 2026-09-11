import "@typespec/http";

using TypeSpec.Http;

/** CN device fingerprint registration contract. Do not submit fabricated device telemetry. */
@service(#{ title: "UIGF Device Fingerprint API" })
@server("https://public-data-api.mihoyo.com", "MiHoYo Public Data API")
namespace UIGF.Utility.Device {
  model DeviceExtensionList extends Record<unknown> {
    code?: int32;
    ext_list?: string[];
    msg?: string;
    pkg_list?: string[];
    pkg_str?: string;
  }

  @route("/device-fp/api")
  interface FingerprintApi {
    /** Returns the client extension fields expected by the fingerprint registration endpoint. */
    @get
    @route("/getExtList")
    getExtensionList(
      @query platform: string,
    ): UIGF.ApiResponse<DeviceExtensionList>;

    /** Registers a legitimate client device fingerprint and returns its `device_fp` value. */
    @post
    @route("/getFp")
    getFingerprint(
      @header("x-rpc-app_version") appVersion: string,
      @header("x-rpc-client_type") clientType: string,
      @header("x-requested-with") requestedWith: string,
      @body body: UIGF.Game.DeviceFingerprintRequest,
    ): UIGF.ApiResponse<UIGF.Game.DeviceFingerprint>;
  }
}

/** MiHoYo livestream redemption-code refresh endpoint. */
@service(#{ title: "UIGF MiYoLive API" })
@server("https://api-takumi-static.mihoyo.com", "MiYoLive API")
namespace UIGF.Utility.LiveStream {
  @route("/event/miyolive")
  interface RedemptionCodeApi {
    @get
    @route("/refreshCode")
    refresh(
      @header("x-rpc-act_id") activityId: string,
    ): UIGF.ApiResponse<UIGF.JsonObject>;
  }
}
