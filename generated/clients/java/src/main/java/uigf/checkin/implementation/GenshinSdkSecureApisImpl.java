package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import uigf.ApiResponseJsonObject;
import uigf.game.genshin.sdk.ProtocolVersionRequest;
import uigf.game.genshin.sdk.RedDotRequest;

/**
 * An instance of this class provides access to all the operations defined in GenshinSdkSecureApis.
 */
public final class GenshinSdkSecureApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GenshinSdkSecureApisService service;

    /**
     * The service client containing this operation class.
     */
    private final SecureClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GenshinSdkSecureApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GenshinSdkSecureApisImpl(SecureClientImpl client) {
        this.service = GenshinSdkSecureApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for SecureClientGenshinSdkSecureApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "SecureClientGenshinSdkSecureApis", host = "{endpoint}")
    public interface GenshinSdkSecureApisService {
        static GenshinSdkSecureApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GenshinSdkSecureApisServiceImpl");
                return (GenshinSdkSecureApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/hk4e_cn/combo/granter/api/compareProtocolVersion",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> compareProtocolVersion(@HostParam("endpoint") String endpoint,
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
            @HeaderParam("x-rpc-sys_version") String rpcSystemVersion, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") ProtocolVersionRequest body,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/hk4e_cn/combo/red_dot/list",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getRedDots(@HostParam("endpoint") String endpoint,
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
            @HeaderParam("x-rpc-sys_version") String rpcSystemVersion, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") RedDotRequest body,
            RequestContext requestContext);
    }

    /**
     * The compareProtocolVersion operation.
     * 
     * @param body The body parameter.
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
    public Response<ApiResponseJsonObject> compareProtocolVersionWithResponse(ProtocolVersionRequest body,
        String rpcAppId, String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Genshin.SDK.Secure.SecureApi.compareProtocolVersion", requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.compareProtocolVersion(this.client.getEndpoint(), rpcAppId, rpcAppVersion, rpcChannelId,
                    rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId,
                    rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                    rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, contentType, accept, body,
                    updatedContext);
            });
    }

    /**
     * The getRedDots operation.
     * 
     * @param body The body parameter.
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
    public Response<ApiResponseJsonObject> getRedDotsWithResponse(RedDotRequest body, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Secure.SecureApi.getRedDots",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.getRedDots(this.client.getEndpoint(), rpcAppId, rpcAppVersion, rpcChannelId,
                    rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId,
                    rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                    rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, contentType, accept, body,
                    updatedContext);
            });
    }
}
