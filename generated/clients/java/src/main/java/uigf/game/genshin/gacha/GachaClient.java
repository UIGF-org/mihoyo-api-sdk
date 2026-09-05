package uigf.game.genshin.gacha;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponseGachaLogPage;
import uigf.checkin.implementation.GachaLogApisImpl;

/**
 * Initializes a new instance of the synchronous GachaClient type.
 */
@ServiceClient(builder = GachaClientBuilder.class)
public final class GachaClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GachaLogApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GachaClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GachaClient(GachaLogApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getHistory operation.
     * 
     * @param authkey The authkey parameter.
     * @param gachaType The gachaType parameter.
     * @param lang The lang parameter.
     * @param authAppid The authAppid parameter.
     * @param endId The endId parameter.
     * @param size The size parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGachaLogPage> getHistoryWithResponse(String authkey, String gachaType, String lang,
        String authAppid, String endId, Integer size, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Gacha.GachaLogApi.getHistory",
            requestContext, updatedContext -> this.serviceClient.getHistoryWithResponse(authkey, gachaType, lang,
                authAppid, endId, size, updatedContext));
    }

    /**
     * The getHistory operation.
     * 
     * @param authkey The authkey parameter.
     * @param gachaType The gachaType parameter.
     * @param lang The lang parameter.
     * @param authAppid The authAppid parameter.
     * @param endId The endId parameter.
     * @param size The size parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getHistory(String authkey, String gachaType, String lang, String authAppid,
        String endId, Integer size) {
        return getHistoryWithResponse(authkey, gachaType, lang, authAppid, endId, size, RequestContext.none())
            .getValue();
    }

    /**
     * The getHistory operation.
     * 
     * @param authkey The authkey parameter.
     * @param gachaType The gachaType parameter.
     * @param lang The lang parameter.
     * @param authAppid The authAppid parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getHistory(String authkey, String gachaType, String lang, String authAppid) {
        final String endId = null;
        final Integer size = null;
        return getHistoryWithResponse(authkey, gachaType, lang, authAppid, endId, size, RequestContext.none())
            .getValue();
    }

    /**
     * The getBeyondHistory operation.
     * 
     * @param authkey The authkey parameter.
     * @param gachaType The gachaType parameter.
     * @param lang The lang parameter.
     * @param authAppid The authAppid parameter.
     * @param endId The endId parameter.
     * @param size The size parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGachaLogPage> getBeyondHistoryWithResponse(String authkey, String gachaType, String lang,
        String authAppid, String endId, Integer size, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Gacha.GachaLogApi.getBeyondHistory",
            requestContext, updatedContext -> this.serviceClient.getBeyondHistoryWithResponse(authkey, gachaType, lang,
                authAppid, endId, size, updatedContext));
    }

    /**
     * The getBeyondHistory operation.
     * 
     * @param authkey The authkey parameter.
     * @param gachaType The gachaType parameter.
     * @param lang The lang parameter.
     * @param authAppid The authAppid parameter.
     * @param endId The endId parameter.
     * @param size The size parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getBeyondHistory(String authkey, String gachaType, String lang, String authAppid,
        String endId, Integer size) {
        return getBeyondHistoryWithResponse(authkey, gachaType, lang, authAppid, endId, size, RequestContext.none())
            .getValue();
    }

    /**
     * The getBeyondHistory operation.
     * 
     * @param authkey The authkey parameter.
     * @param gachaType The gachaType parameter.
     * @param lang The lang parameter.
     * @param authAppid The authAppid parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getBeyondHistory(String authkey, String gachaType, String lang, String authAppid) {
        final String endId = null;
        final Integer size = null;
        return getBeyondHistoryWithResponse(authkey, gachaType, lang, authAppid, endId, size, RequestContext.none())
            .getValue();
    }
}
