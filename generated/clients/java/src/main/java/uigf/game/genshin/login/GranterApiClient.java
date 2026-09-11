package uigf.game.genshin.login;

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
import uigf.checkin.implementation.GranterApisImpl;
import uigf.game.genshin.sdk.GranterLoginRequest;

/**
 * Initializes a new instance of the synchronous LoginClient type.
 */
@ServiceClient(builder = LoginClientBuilder.class)
public final class GranterApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GranterApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GranterApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GranterApiClient(GranterApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * Submits the caller-provided official granter login payload.
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
    public Response<ApiResponseJsonObject> loginWithResponse(GranterLoginRequest body, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Login.GranterApi.login", requestContext,
            updatedContext -> this.serviceClient.loginWithResponse(body, rpcAppId, rpcAppVersion, rpcChannelId,
                rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel,
                rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion,
                rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, updatedContext));
    }

    /**
     * Submits the caller-provided official granter login payload.
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
    public ApiResponseJsonObject login(GranterLoginRequest body, String rpcAppId, String rpcAppVersion,
        String rpcChannelId, String rpcChannelVersion, String rpcClientType, String rpcComboVersion,
        String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel, String rpcDeviceName, String rpcGameBiz,
        String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion, String rpcPaymentVersion,
        String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion) {
        return loginWithResponse(body, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion, rpcClientType,
            rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName, rpcGameBiz,
            rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId,
            rpcSystemVersion, RequestContext.none()).getValue();
    }

    /**
     * Submits the caller-provided official granter login payload.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject login(GranterLoginRequest body) {
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
        return loginWithResponse(body, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion, rpcClientType,
            rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName, rpcGameBiz,
            rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId,
            rpcSystemVersion, RequestContext.none()).getValue();
    }
}
