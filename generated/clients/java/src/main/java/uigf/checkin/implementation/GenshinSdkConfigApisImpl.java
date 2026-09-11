package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.QueryParam;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import uigf.ApiResponseJsonObject;

/**
 * An instance of this class provides access to all the operations defined in GenshinSdkConfigApis.
 */
public final class GenshinSdkConfigApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GenshinSdkConfigApisService service;

    /**
     * The service client containing this operation class.
     */
    private final ConfigClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GenshinSdkConfigApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GenshinSdkConfigApisImpl(ConfigClientImpl client) {
        this.service = GenshinSdkConfigApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for ConfigClientGenshinSdkConfigApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "ConfigClientGenshinSdkConfigApis", host = "{endpoint}")
    public interface GenshinSdkConfigApisService {
        static GenshinSdkConfigApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GenshinSdkConfigApisServiceImpl");
                return (GenshinSdkConfigApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/combo/box/api/config/sdk/combo",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getCombo(@HostParam("endpoint") String endpoint,
            @QueryParam("biz_key") String bizKey, @QueryParam("client_type") String clientType,
            @HeaderParam("x-rpc-app_id") String rpcAppId, @HeaderParam("x-rpc-app_version") String rpcAppVersion,
            @HeaderParam("x-rpc-channel_id") String rpcChannelId,
            @HeaderParam("x-rpc-channel_version") String rpcChannelVersion,
            @HeaderParam("x-rpc-client_type") String rpcClientType,
            @HeaderParam("x-rpc-combo_version") String rpcComboVersion,
            @HeaderParam("x-rpc-device_fp") String rpcDeviceFingerprint,
            @HeaderParam("x-rpc-device_id") String rpcDeviceId,
            @HeaderParam("x-rpc-device_model") String rpcDeviceModel,
            @HeaderParam("x-rpc-device_name") String rpcDeviceName, @HeaderParam("x-rpc-game_biz") String rpcGameBiz,
            @HeaderParam("x-rpc-goods_third_party") String rpcGoodsThirdParty,
            @HeaderParam("x-rpc-language") String rpcLanguage, @HeaderParam("x-rpc-mdk_version") String rpcMdkVersion,
            @HeaderParam("x-rpc-payment_version") String rpcPaymentVersion,
            @HeaderParam("x-rpc-sdk_version") String rpcSdkVersion,
            @HeaderParam("x-rpc-sub_channel_id") String rpcSubChannelId,
            @HeaderParam("x-rpc-sys_version") String rpcSystemVersion, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/combo/box/api/config/sw/precache",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getPrecache(@HostParam("endpoint") String endpoint,
            @QueryParam("biz") String biz, @QueryParam("client") String client,
            @HeaderParam("x-rpc-app_id") String rpcAppId, @HeaderParam("x-rpc-app_version") String rpcAppVersion,
            @HeaderParam("x-rpc-channel_id") String rpcChannelId,
            @HeaderParam("x-rpc-channel_version") String rpcChannelVersion,
            @HeaderParam("x-rpc-client_type") String rpcClientType,
            @HeaderParam("x-rpc-combo_version") String rpcComboVersion,
            @HeaderParam("x-rpc-device_fp") String rpcDeviceFingerprint,
            @HeaderParam("x-rpc-device_id") String rpcDeviceId,
            @HeaderParam("x-rpc-device_model") String rpcDeviceModel,
            @HeaderParam("x-rpc-device_name") String rpcDeviceName, @HeaderParam("x-rpc-game_biz") String rpcGameBiz,
            @HeaderParam("x-rpc-goods_third_party") String rpcGoodsThirdParty,
            @HeaderParam("x-rpc-language") String rpcLanguage, @HeaderParam("x-rpc-mdk_version") String rpcMdkVersion,
            @HeaderParam("x-rpc-payment_version") String rpcPaymentVersion,
            @HeaderParam("x-rpc-sdk_version") String rpcSdkVersion,
            @HeaderParam("x-rpc-sub_channel_id") String rpcSubChannelId,
            @HeaderParam("x-rpc-sys_version") String rpcSystemVersion, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hk4e_cn/combo/granter/api/getConfig",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getGranterConfig(@HostParam("endpoint") String endpoint,
            @QueryParam("app_id") String appId, @QueryParam("channel_id") String channelId,
            @QueryParam("client_type") String clientType, @HeaderParam("x-rpc-app_id") String rpcAppId,
            @HeaderParam("x-rpc-app_version") String rpcAppVersion,
            @HeaderParam("x-rpc-channel_id") String rpcChannelId,
            @HeaderParam("x-rpc-channel_version") String rpcChannelVersion,
            @HeaderParam("x-rpc-client_type") String rpcClientType,
            @HeaderParam("x-rpc-combo_version") String rpcComboVersion,
            @HeaderParam("x-rpc-device_fp") String rpcDeviceFingerprint,
            @HeaderParam("x-rpc-device_id") String rpcDeviceId,
            @HeaderParam("x-rpc-device_model") String rpcDeviceModel,
            @HeaderParam("x-rpc-device_name") String rpcDeviceName, @HeaderParam("x-rpc-game_biz") String rpcGameBiz,
            @HeaderParam("x-rpc-goods_third_party") String rpcGoodsThirdParty,
            @HeaderParam("x-rpc-language") String rpcLanguage, @HeaderParam("x-rpc-mdk_version") String rpcMdkVersion,
            @HeaderParam("x-rpc-payment_version") String rpcPaymentVersion,
            @HeaderParam("x-rpc-sdk_version") String rpcSdkVersion,
            @HeaderParam("x-rpc-sub_channel_id") String rpcSubChannelId,
            @HeaderParam("x-rpc-sys_version") String rpcSystemVersion, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hk4e_cn/mdk/shield/api/loadConfig",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getShieldConfig(@HostParam("endpoint") String endpoint,
            @QueryParam("client") String client, @QueryParam("game_key") String gameKey,
            @HeaderParam("x-rpc-app_id") String rpcAppId, @HeaderParam("x-rpc-app_version") String rpcAppVersion,
            @HeaderParam("x-rpc-channel_id") String rpcChannelId,
            @HeaderParam("x-rpc-channel_version") String rpcChannelVersion,
            @HeaderParam("x-rpc-client_type") String rpcClientType,
            @HeaderParam("x-rpc-combo_version") String rpcComboVersion,
            @HeaderParam("x-rpc-device_fp") String rpcDeviceFingerprint,
            @HeaderParam("x-rpc-device_id") String rpcDeviceId,
            @HeaderParam("x-rpc-device_model") String rpcDeviceModel,
            @HeaderParam("x-rpc-device_name") String rpcDeviceName, @HeaderParam("x-rpc-game_biz") String rpcGameBiz,
            @HeaderParam("x-rpc-goods_third_party") String rpcGoodsThirdParty,
            @HeaderParam("x-rpc-language") String rpcLanguage, @HeaderParam("x-rpc-mdk_version") String rpcMdkVersion,
            @HeaderParam("x-rpc-payment_version") String rpcPaymentVersion,
            @HeaderParam("x-rpc-sdk_version") String rpcSdkVersion,
            @HeaderParam("x-rpc-sub_channel_id") String rpcSubChannelId,
            @HeaderParam("x-rpc-sys_version") String rpcSystemVersion, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
    }

    /**
     * The getCombo operation.
     * 
     * @param bizKey The bizKey parameter.
     * @param clientType The clientType parameter.
     * @param rpcAppId The rpcAppId parameter.
     * @param rpcAppVersion The rpcAppVersion parameter.
     * @param rpcChannelId The rpcChannelId parameter.
     * @param rpcChannelVersion The rpcChannelVersion parameter.
     * @param rpcClientType The rpcClientType parameter.
     * @param rpcComboVersion The rpcComboVersion parameter.
     * @param rpcDeviceFingerprint The rpcDeviceFingerprint parameter.
     * @param rpcDeviceId The rpcDeviceId parameter.
     * @param rpcDeviceModel The rpcDeviceModel parameter.
     * @param rpcDeviceName The rpcDeviceName parameter.
     * @param rpcGameBiz The rpcGameBiz parameter.
     * @param rpcGoodsThirdParty The rpcGoodsThirdParty parameter.
     * @param rpcLanguage The rpcLanguage parameter.
     * @param rpcMdkVersion The rpcMdkVersion parameter.
     * @param rpcPaymentVersion The rpcPaymentVersion parameter.
     * @param rpcSdkVersion The rpcSdkVersion parameter.
     * @param rpcSubChannelId The rpcSubChannelId parameter.
     * @param rpcSystemVersion The rpcSystemVersion parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getComboWithResponse(String bizKey, String clientType, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Config.ConfigApi.getCombo",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getCombo(this.client.getEndpoint(), bizKey, clientType, rpcAppId, rpcAppVersion,
                    rpcChannelId, rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId,
                    rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                    rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, accept, updatedContext);
            });
    }

    /**
     * The getPrecache operation.
     * 
     * @param biz The biz parameter.
     * @param clientParam The clientParam parameter.
     * @param rpcAppId The rpcAppId parameter.
     * @param rpcAppVersion The rpcAppVersion parameter.
     * @param rpcChannelId The rpcChannelId parameter.
     * @param rpcChannelVersion The rpcChannelVersion parameter.
     * @param rpcClientType The rpcClientType parameter.
     * @param rpcComboVersion The rpcComboVersion parameter.
     * @param rpcDeviceFingerprint The rpcDeviceFingerprint parameter.
     * @param rpcDeviceId The rpcDeviceId parameter.
     * @param rpcDeviceModel The rpcDeviceModel parameter.
     * @param rpcDeviceName The rpcDeviceName parameter.
     * @param rpcGameBiz The rpcGameBiz parameter.
     * @param rpcGoodsThirdParty The rpcGoodsThirdParty parameter.
     * @param rpcLanguage The rpcLanguage parameter.
     * @param rpcMdkVersion The rpcMdkVersion parameter.
     * @param rpcPaymentVersion The rpcPaymentVersion parameter.
     * @param rpcSdkVersion The rpcSdkVersion parameter.
     * @param rpcSubChannelId The rpcSubChannelId parameter.
     * @param rpcSystemVersion The rpcSystemVersion parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getPrecacheWithResponse(String biz, String clientParam, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Config.ConfigApi.getPrecache",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getPrecache(this.client.getEndpoint(), biz, clientParam, rpcAppId, rpcAppVersion,
                    rpcChannelId, rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId,
                    rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                    rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, accept, updatedContext);
            });
    }

    /**
     * The getGranterConfig operation.
     * 
     * @param appId The appId parameter.
     * @param channelId The channelId parameter.
     * @param clientType The clientType parameter.
     * @param rpcAppId The rpcAppId parameter.
     * @param rpcAppVersion The rpcAppVersion parameter.
     * @param rpcChannelId The rpcChannelId parameter.
     * @param rpcChannelVersion The rpcChannelVersion parameter.
     * @param rpcClientType The rpcClientType parameter.
     * @param rpcComboVersion The rpcComboVersion parameter.
     * @param rpcDeviceFingerprint The rpcDeviceFingerprint parameter.
     * @param rpcDeviceId The rpcDeviceId parameter.
     * @param rpcDeviceModel The rpcDeviceModel parameter.
     * @param rpcDeviceName The rpcDeviceName parameter.
     * @param rpcGameBiz The rpcGameBiz parameter.
     * @param rpcGoodsThirdParty The rpcGoodsThirdParty parameter.
     * @param rpcLanguage The rpcLanguage parameter.
     * @param rpcMdkVersion The rpcMdkVersion parameter.
     * @param rpcPaymentVersion The rpcPaymentVersion parameter.
     * @param rpcSdkVersion The rpcSdkVersion parameter.
     * @param rpcSubChannelId The rpcSubChannelId parameter.
     * @param rpcSystemVersion The rpcSystemVersion parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getGranterConfigWithResponse(String appId, String channelId,
        String clientType, String rpcAppId, String rpcAppVersion, String rpcChannelId, String rpcChannelVersion,
        String rpcClientType, String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId,
        String rpcDeviceModel, String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage,
        String rpcMdkVersion, String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId,
        String rpcSystemVersion, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Config.ConfigApi.getGranterConfig",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getGranterConfig(this.client.getEndpoint(), appId, channelId, clientType, rpcAppId,
                    rpcAppVersion, rpcChannelId, rpcChannelVersion, rpcClientType, rpcComboVersion,
                    rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty,
                    rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion,
                    accept, updatedContext);
            });
    }

    /**
     * The getShieldConfig operation.
     * 
     * @param clientParam The clientParam parameter.
     * @param gameKey The gameKey parameter.
     * @param rpcAppId The rpcAppId parameter.
     * @param rpcAppVersion The rpcAppVersion parameter.
     * @param rpcChannelId The rpcChannelId parameter.
     * @param rpcChannelVersion The rpcChannelVersion parameter.
     * @param rpcClientType The rpcClientType parameter.
     * @param rpcComboVersion The rpcComboVersion parameter.
     * @param rpcDeviceFingerprint The rpcDeviceFingerprint parameter.
     * @param rpcDeviceId The rpcDeviceId parameter.
     * @param rpcDeviceModel The rpcDeviceModel parameter.
     * @param rpcDeviceName The rpcDeviceName parameter.
     * @param rpcGameBiz The rpcGameBiz parameter.
     * @param rpcGoodsThirdParty The rpcGoodsThirdParty parameter.
     * @param rpcLanguage The rpcLanguage parameter.
     * @param rpcMdkVersion The rpcMdkVersion parameter.
     * @param rpcPaymentVersion The rpcPaymentVersion parameter.
     * @param rpcSdkVersion The rpcSdkVersion parameter.
     * @param rpcSubChannelId The rpcSubChannelId parameter.
     * @param rpcSystemVersion The rpcSystemVersion parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getShieldConfigWithResponse(String clientParam, String gameKey,
        String rpcAppId, String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Config.ConfigApi.getShieldConfig",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getShieldConfig(this.client.getEndpoint(), clientParam, gameKey, rpcAppId, rpcAppVersion,
                    rpcChannelId, rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId,
                    rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                    rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, accept, updatedContext);
            });
    }
}
