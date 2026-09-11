package uigf.game.genshin.sdk.config;

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
import uigf.checkin.implementation.GenshinSdkConfigApisImpl;

/**
 * Initializes a new instance of the synchronous ConfigClient type.
 */
@ServiceClient(builder = ConfigClientBuilder.class)
public final class ConfigClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GenshinSdkConfigApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ConfigClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    ConfigClient(GenshinSdkConfigApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getComboWithResponse(String bizKey, String clientType, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Config.ConfigApi.getCombo",
            requestContext,
            updatedContext -> this.serviceClient.getComboWithResponse(bizKey, clientType, rpcAppId, rpcAppVersion,
                rpcChannelId, rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId,
                rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getCombo(String bizKey, String clientType, String rpcAppId, String rpcAppVersion,
        String rpcChannelId, String rpcChannelVersion, String rpcClientType, String rpcComboVersion,
        String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel, String rpcDeviceName, String rpcGameBiz,
        String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion, String rpcPaymentVersion,
        String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion) {
        return getComboWithResponse(bizKey, clientType, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion,
            rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName,
            rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
    }

    /**
     * The getCombo operation.
     * 
     * @param bizKey The bizKey parameter.
     * @param clientType The clientType parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getCombo(String bizKey, String clientType) {
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
        return getComboWithResponse(bizKey, clientType, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion,
            rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName,
            rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getPrecacheWithResponse(String biz, String clientParam, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Config.ConfigApi.getPrecache",
            requestContext,
            updatedContext -> this.serviceClient.getPrecacheWithResponse(biz, clientParam, rpcAppId, rpcAppVersion,
                rpcChannelId, rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId,
                rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getPrecache(String biz, String clientParam, String rpcAppId, String rpcAppVersion,
        String rpcChannelId, String rpcChannelVersion, String rpcClientType, String rpcComboVersion,
        String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel, String rpcDeviceName, String rpcGameBiz,
        String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion, String rpcPaymentVersion,
        String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion) {
        return getPrecacheWithResponse(biz, clientParam, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion,
            rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName,
            rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
    }

    /**
     * The getPrecache operation.
     * 
     * @param biz The biz parameter.
     * @param clientParam The clientParam parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getPrecache(String biz, String clientParam) {
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
        return getPrecacheWithResponse(biz, clientParam, rpcAppId, rpcAppVersion, rpcChannelId, rpcChannelVersion,
            rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel, rpcDeviceName,
            rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getGranterConfigWithResponse(String appId, String channelId,
        String clientType, String rpcAppId, String rpcAppVersion, String rpcChannelId, String rpcChannelVersion,
        String rpcClientType, String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId,
        String rpcDeviceModel, String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage,
        String rpcMdkVersion, String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId,
        String rpcSystemVersion, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Config.ConfigApi.getGranterConfig",
            requestContext,
            updatedContext -> this.serviceClient.getGranterConfigWithResponse(appId, channelId, clientType, rpcAppId,
                rpcAppVersion, rpcChannelId, rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint,
                rpcDeviceId, rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGranterConfig(String appId, String channelId, String clientType, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion) {
        return getGranterConfigWithResponse(appId, channelId, clientType, rpcAppId, rpcAppVersion, rpcChannelId,
            rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel,
            rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
    }

    /**
     * The getGranterConfig operation.
     * 
     * @param appId The appId parameter.
     * @param channelId The channelId parameter.
     * @param clientType The clientType parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGranterConfig(String appId, String channelId, String clientType) {
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
        return getGranterConfigWithResponse(appId, channelId, clientType, rpcAppId, rpcAppVersion, rpcChannelId,
            rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel,
            rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getShieldConfigWithResponse(String clientParam, String gameKey,
        String rpcAppId, String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.SDK.Config.ConfigApi.getShieldConfig",
            requestContext,
            updatedContext -> this.serviceClient.getShieldConfigWithResponse(clientParam, gameKey, rpcAppId,
                rpcAppVersion, rpcChannelId, rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint,
                rpcDeviceId, rpcDeviceModel, rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion,
                rpcPaymentVersion, rpcSdkVersion, rpcSubChannelId, rpcSystemVersion, updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getShieldConfig(String clientParam, String gameKey, String rpcAppId,
        String rpcAppVersion, String rpcChannelId, String rpcChannelVersion, String rpcClientType,
        String rpcComboVersion, String rpcDeviceFingerprint, String rpcDeviceId, String rpcDeviceModel,
        String rpcDeviceName, String rpcGameBiz, String rpcGoodsThirdParty, String rpcLanguage, String rpcMdkVersion,
        String rpcPaymentVersion, String rpcSdkVersion, String rpcSubChannelId, String rpcSystemVersion) {
        return getShieldConfigWithResponse(clientParam, gameKey, rpcAppId, rpcAppVersion, rpcChannelId,
            rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel,
            rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
    }

    /**
     * The getShieldConfig operation.
     * 
     * @param clientParam The clientParam parameter.
     * @param gameKey The gameKey parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getShieldConfig(String clientParam, String gameKey) {
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
        return getShieldConfigWithResponse(clientParam, gameKey, rpcAppId, rpcAppVersion, rpcChannelId,
            rpcChannelVersion, rpcClientType, rpcComboVersion, rpcDeviceFingerprint, rpcDeviceId, rpcDeviceModel,
            rpcDeviceName, rpcGameBiz, rpcGoodsThirdParty, rpcLanguage, rpcMdkVersion, rpcPaymentVersion, rpcSdkVersion,
            rpcSubChannelId, rpcSystemVersion, RequestContext.none()).getValue();
    }
}
