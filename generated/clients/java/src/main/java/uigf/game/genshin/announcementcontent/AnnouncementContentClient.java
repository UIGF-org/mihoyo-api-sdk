package uigf.game.genshin.announcementcontent;

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
import uigf.checkin.implementation.ContentApisImpl;

/**
 * Initializes a new instance of the synchronous AnnouncementContentClient type.
 */
@ServiceClient(builder = AnnouncementContentClientBuilder.class)
public final class AnnouncementContentClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final ContentApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of AnnouncementContentClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    AnnouncementContentClient(ContentApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The get operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @param t The t parameter.
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
    public Response<ApiResponseAnnouncementList> getWithResponse(String game, String gameBiz, String lang,
        String bundleId, ListRequestPlatform platform, String region, String t, Integer level, String uid,
        Integer channelId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.AnnouncementContent.ContentApi.get",
            requestContext, updatedContext -> this.serviceClient.getWithResponse(game, gameBiz, lang, bundleId,
                platform, region, t, level, uid, channelId, updatedContext));
    }

    /**
     * The get operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @param t The t parameter.
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
    public ApiResponseAnnouncementList get(String game, String gameBiz, String lang, String bundleId,
        ListRequestPlatform platform, String region, String t, Integer level, String uid, Integer channelId) {
        return getWithResponse(game, gameBiz, lang, bundleId, platform, region, t, level, uid, channelId,
            RequestContext.none()).getValue();
    }

    /**
     * The get operation.
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
    public ApiResponseAnnouncementList get(String game, String gameBiz, String lang, String bundleId,
        ListRequestPlatform platform, String region) {
        final String t = null;
        final Integer level = null;
        final String uid = null;
        final Integer channelId = null;
        return getWithResponse(game, gameBiz, lang, bundleId, platform, region, t, level, uid, channelId,
            RequestContext.none()).getValue();
    }
}
