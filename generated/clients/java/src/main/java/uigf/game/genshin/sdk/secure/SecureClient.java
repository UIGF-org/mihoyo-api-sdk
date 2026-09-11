package uigf.game.genshin.sdk.secure;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponseJsonObject;
import uigf.checkin.implementation.GenshinSdkSecureApisImpl;
import uigf.game.genshin.sdk.ProtocolVersionRequest;
import uigf.game.genshin.sdk.RedDotRequest;

/**
 * Initializes a new instance of the synchronous SecureClient type.
 */
@ServiceClient(builder = SecureClientBuilder.class)
public final class SecureClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GenshinSdkSecureApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of SecureClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    SecureClient(GenshinSdkSecureApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> compareProtocolVersionWithResponse(ProtocolVersionRequest body,
        String rpcAppId, String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Genshin.SDK.Secure.SecureApi.compareProtocolVersion", requestContext,
            updatedContext -> this.serviceClient.compareProtocolVersionWithResponse(body, rpcAppId, rpcAppVersion,
                rpcChannelId, rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId,
                rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject compareProtocolVersion(ProtocolVersionRequest body, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion) {
        return compareProtocolVersionWithResponse(body, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion,
            rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName,
            rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
    }

    /**
     * The compareProtocolVersion operation.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject compareProtocolVersion(ProtocolVersionRequest body) {
        final String rpcAppId = null;
        final String rpcAppVersion = null;
        final String rpcChannelId = null;
        final String rpcChannelVersion = null;
        final String rpcClientType = null;
        final String rpcComboVersion = null;
        final String rpcDeviceFingerprint = null;
        final String rpcDeviceId = null;
        final String rpcDeviceModel = null;
        final String rpcDeviceName = null;
        final String rpcGameBiz = null;
        final String rpcGoodsThirdParty = null;
        final String rpcLanguage = null;
        final String rpcMdkVersion = null;
        final String rpcPaymentVersion = null;
        final String rpcSdkVersion = null;
        final String rpcSubChannelId = null;
        final String rpcSystemVersion = null;
        return compareProtocolVersionWithResponse(body, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion,
            rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName,
            rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getRedDotsWithResponse(RedDotRequest body, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Secure.SecureApi.getRedDots",
            requestContext,
            updatedContext -> this.serviceClient.getRedDotsWithResponse(body, rpcAppId, rpcAppVersion, rpcChannelId,
                rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel,
                rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion,
                rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getRedDots(RedDotRequest body, String rpcAppId, String rpcAppVersion,
        String rpcChannelId, String rpcChannelVersion, String rpcClientType, String rpcComboVersion,
        String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel, String rpcDeviceName, String rpcGameBiz,
        String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion, String rpcPaymentVersion,
        String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion) {
        return getRedDotsWithResponse(body, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion, rpcClientType,
            rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName, rpcGameBiz,
            rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId,
            rpcSystemVersion, RequestContext.none()).getValue();
    }

    /**
     * The getRedDots operation.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getRedDots(RedDotRequest body) {
        final String rpcAppId = null;
        final String rpcAppVersion = null;
        final String rpcChannelId = null;
        final String rpcChannelVersion = null;
        final String rpcClientType = null;
        final String rpcComboVersion = null;
        final String rpcDeviceFingerprint = null;
        final String rpcDeviceId = null;
        final String rpcDeviceModel = null;
        final String rpcDeviceName = null;
        final String rpcGameBiz = null;
        final String rpcGoodsThirdParty = null;
        final String rpcLanguage = null;
        final String rpcMdkVersion = null;
        final String rpcPaymentVersion = null;
        final String rpcSdkVersion = null;
        final String rpcSubChannelId = null;
        final String rpcSystemVersion = null;
        return getRedDotsWithResponse(body, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion, rpcClientType,
            rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName, rpcGameBiz,
            rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId,
            rpcSystemVersion, RequestContext.none()).getValue();
    }
}
