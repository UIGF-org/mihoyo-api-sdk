package uigf.game.cn.events;

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
import uigf.checkin.implementation.CnZenlessCultivationApisImpl;

/**
 * Initializes a new instance of the synchronous EventsClient type.
 */
@ServiceClient(builder = EventsClientBuilder.class)
public final class CnZenlessCultivationApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final CnZenlessCultivationApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CnZenlessCultivationApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    CnZenlessCultivationApiClient(CnZenlessCultivationApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getItems operation.
     * 
     * @param cookie The cookie parameter.
     * @param uid The uid parameter.
     * @param region The region parameter.
     * @param avatarId The avatarId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getItemsWithResponse(String cookie, String uid, String region, int avatarId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.CN.Events.ZenlessCultivationApi.getItems",
            requestContext,
            updatedContext -> this.serviceClient.getItemsWithResponse(cookie, uid, region, avatarId, updatedContext));
    }

    /**
     * The getItems operation.
     * 
     * @param cookie The cookie parameter.
     * @param uid The uid parameter.
     * @param region The region parameter.
     * @param avatarId The avatarId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getItems(String cookie, String uid, String region, int avatarId) {
        return getItemsWithResponse(cookie, uid, region, avatarId, RequestContext.none()).getValue();
    }

    /**
     * The getIconInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param uid The uid parameter.
     * @param region The region parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getIconInfoWithResponse(String cookie, String uid, String region,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.CN.Events.ZenlessCultivationApi.getIconInfo",
            requestContext,
            updatedContext -> this.serviceClient.getIconInfoWithResponse(cookie, uid, region, updatedContext));
    }

    /**
     * The getIconInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param uid The uid parameter.
     * @param region The region parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getIconInfo(String cookie, String uid, String region) {
        return getIconInfoWithResponse(cookie, uid, region, RequestContext.none()).getValue();
    }
}
