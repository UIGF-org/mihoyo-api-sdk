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
     * @param gachaType The gachaType parameter.
     * @param authkey The authkey parameter.
     * @param authAppid The authAppid parameter.
     * @param lang The lang parameter.
     * @param gachaId The gachaId parameter.
     * @param endId The endId parameter.
     * @param page The page parameter.
     * @param size The size parameter.
     * @param region The region parameter.
     * @param gameBiz The gameBiz parameter.
     * @param deviceType The deviceType parameter.
     * @param gameVersion The gameVersion parameter.
     * @param initType The initType parameter.
     * @param noJoypadClose The noJoypadClose parameter.
     * @param timestamp The timestamp parameter.
     * @param winMode The winMode parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGachaLogPage> getHistoryWithResponse(String gachaType, String authkey, String authAppid,
        String lang, String gachaId, String endId, Integer page, Integer size, String region, String gameBiz,
        String deviceType, String gameVersion, String initType, String noJoypadClose, String timestamp, String winMode,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Gacha.GachaLogApi.getHistory",
            requestContext,
            updatedContext -> this.serviceClient.getHistoryWithResponse(gachaType, authkey, authAppid, lang, gachaId,
                endId, page, size, region, gameBiz, deviceType, gameVersion, initType, noJoypadClose, timestamp,
                winMode, updatedContext));
    }

    /**
     * The getHistory operation.
     * 
     * @param gachaType The gachaType parameter.
     * @param authkey The authkey parameter.
     * @param authAppid The authAppid parameter.
     * @param lang The lang parameter.
     * @param gachaId The gachaId parameter.
     * @param endId The endId parameter.
     * @param page The page parameter.
     * @param size The size parameter.
     * @param region The region parameter.
     * @param gameBiz The gameBiz parameter.
     * @param deviceType The deviceType parameter.
     * @param gameVersion The gameVersion parameter.
     * @param initType The initType parameter.
     * @param noJoypadClose The noJoypadClose parameter.
     * @param timestamp The timestamp parameter.
     * @param winMode The winMode parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getHistory(String gachaType, String authkey, String authAppid, String lang,
        String gachaId, String endId, Integer page, Integer size, String region, String gameBiz, String deviceType,
        String gameVersion, String initType, String noJoypadClose, String timestamp, String winMode) {
        return getHistoryWithResponse(gachaType, authkey, authAppid, lang, gachaId, endId, page, size, region, gameBiz,
            deviceType, gameVersion, initType, noJoypadClose, timestamp, winMode, RequestContext.none()).getValue();
    }

    /**
     * The getHistory operation.
     * 
     * @param gachaType The gachaType parameter.
     * @param authkey The authkey parameter.
     * @param authAppid The authAppid parameter.
     * @param lang The lang parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getHistory(String gachaType, String authkey, String authAppid, String lang) {
        final String gachaId = null;
        final String endId = null;
        final Integer page = null;
        final Integer size = null;
        final String region = null;
        final String gameBiz = null;
        final String deviceType = null;
        final String gameVersion = null;
        final String initType = null;
        final String noJoypadClose = null;
        final String timestamp = null;
        final String winMode = null;
        return getHistoryWithResponse(gachaType, authkey, authAppid, lang, gachaId, endId, page, size, region, gameBiz,
            deviceType, gameVersion, initType, noJoypadClose, timestamp, winMode, RequestContext.none()).getValue();
    }

    /**
     * The getBeyondHistory operation.
     * 
     * @param gachaType The gachaType parameter.
     * @param authkey The authkey parameter.
     * @param authAppid The authAppid parameter.
     * @param lang The lang parameter.
     * @param gachaId The gachaId parameter.
     * @param endId The endId parameter.
     * @param page The page parameter.
     * @param size The size parameter.
     * @param region The region parameter.
     * @param gameBiz The gameBiz parameter.
     * @param deviceType The deviceType parameter.
     * @param gameVersion The gameVersion parameter.
     * @param initType The initType parameter.
     * @param noJoypadClose The noJoypadClose parameter.
     * @param timestamp The timestamp parameter.
     * @param winMode The winMode parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGachaLogPage> getBeyondHistoryWithResponse(String gachaType, String authkey,
        String authAppid, String lang, String gachaId, String endId, Integer page, Integer size, String region,
        String gameBiz, String deviceType, String gameVersion, String initType, String noJoypadClose, String timestamp,
        String winMode, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Gacha.GachaLogApi.getBeyondHistory",
            requestContext,
            updatedContext -> this.serviceClient.getBeyondHistoryWithResponse(gachaType, authkey, authAppid, lang,
                gachaId, endId, page, size, region, gameBiz, deviceType, gameVersion, initType, noJoypadClose,
                timestamp, winMode, updatedContext));
    }

    /**
     * The getBeyondHistory operation.
     * 
     * @param gachaType The gachaType parameter.
     * @param authkey The authkey parameter.
     * @param authAppid The authAppid parameter.
     * @param lang The lang parameter.
     * @param gachaId The gachaId parameter.
     * @param endId The endId parameter.
     * @param page The page parameter.
     * @param size The size parameter.
     * @param region The region parameter.
     * @param gameBiz The gameBiz parameter.
     * @param deviceType The deviceType parameter.
     * @param gameVersion The gameVersion parameter.
     * @param initType The initType parameter.
     * @param noJoypadClose The noJoypadClose parameter.
     * @param timestamp The timestamp parameter.
     * @param winMode The winMode parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getBeyondHistory(String gachaType, String authkey, String authAppid, String lang,
        String gachaId, String endId, Integer page, Integer size, String region, String gameBiz, String deviceType,
        String gameVersion, String initType, String noJoypadClose, String timestamp, String winMode) {
        return getBeyondHistoryWithResponse(gachaType, authkey, authAppid, lang, gachaId, endId, page, size, region,
            gameBiz, deviceType, gameVersion, initType, noJoypadClose, timestamp, winMode, RequestContext.none())
                .getValue();
    }

    /**
     * The getBeyondHistory operation.
     * 
     * @param gachaType The gachaType parameter.
     * @param authkey The authkey parameter.
     * @param authAppid The authAppid parameter.
     * @param lang The lang parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getBeyondHistory(String gachaType, String authkey, String authAppid, String lang) {
        final String gachaId = null;
        final String endId = null;
        final Integer page = null;
        final Integer size = null;
        final String region = null;
        final String gameBiz = null;
        final String deviceType = null;
        final String gameVersion = null;
        final String initType = null;
        final String noJoypadClose = null;
        final String timestamp = null;
        final String winMode = null;
        return getBeyondHistoryWithResponse(gachaType, authkey, authAppid, lang, gachaId, endId, page, size, region,
            gameBiz, deviceType, gameVersion, initType, noJoypadClose, timestamp, winMode, RequestContext.none())
                .getValue();
    }
}
