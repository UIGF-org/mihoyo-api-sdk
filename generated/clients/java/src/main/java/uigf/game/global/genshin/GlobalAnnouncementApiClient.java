package uigf.game.global.genshin;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponseAnnouncementList;
import uigf.ListRequestPlatform;
import uigf.checkin.implementation.GlobalAnnouncementApisImpl;

/**
 * Initializes a new instance of the synchronous GenshinClient type.
 */
@ServiceClient(builder = GenshinClientBuilder.class)
public final class GlobalAnnouncementApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GlobalAnnouncementApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalAnnouncementApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GlobalAnnouncementApiClient(GlobalAnnouncementApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The list operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @param level The level parameter.
     * @param uid The uid parameter.
     * @param channelId The channelId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseAnnouncementList> listWithResponse(String game, String gameBiz, String lang,
        String bundleId, ListRequestPlatform platform, String region, Integer level, String uid, Integer channelId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Genshin.AnnouncementApi.list",
            requestContext, updatedContext -> this.serviceClient.listWithResponse(game, gameBiz, lang, bundleId,
                platform, region, level, uid, channelId, updatedContext));
    }

    /**
     * The list operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @param level The level parameter.
     * @param uid The uid parameter.
     * @param channelId The channelId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseAnnouncementList list(String game, String gameBiz, String lang, String bundleId,
        ListRequestPlatform platform, String region, Integer level, String uid, Integer channelId) {
        return listWithResponse(game, gameBiz, lang, bundleId, platform, region, level, uid, channelId,
            RequestContext.none()).getValue();
    }

    /**
     * The list operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseAnnouncementList list(String game, String gameBiz, String lang, String bundleId,
        ListRequestPlatform platform, String region) {
        final Integer level = null;
        final String uid = null;
        final Integer channelId = null;
        return listWithResponse(game, gameBiz, lang, bundleId, platform, region, level, uid, channelId,
            RequestContext.none()).getValue();
    }

    /**
     * The getContent operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @param level The level parameter.
     * @param uid The uid parameter.
     * @param channelId The channelId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseAnnouncementList> getContentWithResponse(String game, String gameBiz, String lang,
        String bundleId, ListRequestPlatform platform, String region, Integer level, String uid, Integer channelId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Genshin.AnnouncementApi.getContent",
            requestContext, updatedContext -> this.serviceClient.getContentWithResponse(game, gameBiz, lang, bundleId,
                platform, region, level, uid, channelId, updatedContext));
    }

    /**
     * The getContent operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @param level The level parameter.
     * @param uid The uid parameter.
     * @param channelId The channelId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseAnnouncementList getContent(String game, String gameBiz, String lang, String bundleId,
        ListRequestPlatform platform, String region, Integer level, String uid, Integer channelId) {
        return getContentWithResponse(game, gameBiz, lang, bundleId, platform, region, level, uid, channelId,
            RequestContext.none()).getValue();
    }

    /**
     * The getContent operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseAnnouncementList getContent(String game, String gameBiz, String lang, String bundleId,
        ListRequestPlatform platform, String region) {
        final Integer level = null;
        final String uid = null;
        final Integer channelId = null;
        return getContentWithResponse(game, gameBiz, lang, bundleId, platform, region, level, uid, channelId,
            RequestContext.none()).getValue();
    }

    /**
     * The getAlert operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @param level The level parameter.
     * @param uid The uid parameter.
     * @param channelId The channelId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseAnnouncementList> getAlertWithResponse(String game, String gameBiz, String lang,
        String bundleId, ListRequestPlatform platform, String region, Integer level, String uid, Integer channelId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Genshin.AnnouncementApi.getAlert",
            requestContext, updatedContext -> this.serviceClient.getAlertWithResponse(game, gameBiz, lang, bundleId,
                platform, region, level, uid, channelId, updatedContext));
    }

    /**
     * The getAlert operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @param level The level parameter.
     * @param uid The uid parameter.
     * @param channelId The channelId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseAnnouncementList getAlert(String game, String gameBiz, String lang, String bundleId,
        ListRequestPlatform platform, String region, Integer level, String uid, Integer channelId) {
        return getAlertWithResponse(game, gameBiz, lang, bundleId, platform, region, level, uid, channelId,
            RequestContext.none()).getValue();
    }

    /**
     * The getAlert operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseAnnouncementList getAlert(String game, String gameBiz, String lang, String bundleId,
        ListRequestPlatform platform, String region) {
        final Integer level = null;
        final String uid = null;
        final Integer channelId = null;
        return getAlertWithResponse(game, gameBiz, lang, bundleId, platform, region, level, uid, channelId,
            RequestContext.none()).getValue();
    }
}
