package uigf.game.global.records;

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
import uigf.checkin.implementation.GlobalGameRecordApisImpl;

/**
 * Initializes a new instance of the synchronous GlobalGameRecordsClient type.
 */
@ServiceClient(builder = GlobalGameRecordsClientBuilder.class)
public final class GlobalGameRecordApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GlobalGameRecordApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalGameRecordApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GlobalGameRecordApiClient(GlobalGameRecordApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getGenshinIndex operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @param avatarListType The avatarListType parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getGenshinIndexWithResponse(String cookie, String server, String roleId,
        String ds, Integer avatarListType, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.GameRecordApi.getGenshinIndex",
            requestContext, updatedContext -> this.serviceClient.getGenshinIndexWithResponse(cookie, server, roleId, ds,
                avatarListType, updatedContext));
    }

    /**
     * The getGenshinIndex operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @param avatarListType The avatarListType parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGenshinIndex(String cookie, String server, String roleId, String ds,
        Integer avatarListType) {
        return getGenshinIndexWithResponse(cookie, server, roleId, ds, avatarListType, RequestContext.none())
            .getValue();
    }

    /**
     * The getGenshinIndex operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGenshinIndex(String cookie, String server, String roleId) {
        final String ds = null;
        final Integer avatarListType = null;
        return getGenshinIndexWithResponse(cookie, server, roleId, ds, avatarListType, RequestContext.none())
            .getValue();
    }

    /**
     * The getGenshinDailyNote operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getGenshinDailyNoteWithResponse(String cookie, String server, String roleId,
        String ds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.GameRecordApi.getGenshinDailyNote",
            requestContext, updatedContext -> this.serviceClient.getGenshinDailyNoteWithResponse(cookie, server, roleId,
                ds, updatedContext));
    }

    /**
     * The getGenshinDailyNote operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGenshinDailyNote(String cookie, String server, String roleId, String ds) {
        return getGenshinDailyNoteWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
    }

    /**
     * The getGenshinDailyNote operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGenshinDailyNote(String cookie, String server, String roleId) {
        final String ds = null;
        return getGenshinDailyNoteWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
    }

    /**
     * The getStarRailIndex operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getStarRailIndexWithResponse(String cookie, String server, String roleId,
        String ds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.GameRecordApi.getStarRailIndex",
            requestContext, updatedContext -> this.serviceClient.getStarRailIndexWithResponse(cookie, server, roleId,
                ds, updatedContext));
    }

    /**
     * The getStarRailIndex operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getStarRailIndex(String cookie, String server, String roleId, String ds) {
        return getStarRailIndexWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
    }

    /**
     * The getStarRailIndex operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getStarRailIndex(String cookie, String server, String roleId) {
        final String ds = null;
        return getStarRailIndexWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
    }

    /**
     * The getStarRailDailyNote operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getStarRailDailyNoteWithResponse(String cookie, String server, String roleId,
        String ds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.GameRecordApi.getStarRailDailyNote", requestContext,
            updatedContext -> this.serviceClient.getStarRailDailyNoteWithResponse(cookie, server, roleId, ds,
                updatedContext));
    }

    /**
     * The getStarRailDailyNote operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getStarRailDailyNote(String cookie, String server, String roleId, String ds) {
        return getStarRailDailyNoteWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
    }

    /**
     * The getStarRailDailyNote operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getStarRailDailyNote(String cookie, String server, String roleId) {
        final String ds = null;
        return getStarRailDailyNoteWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
    }

    /**
     * The getStarRailChallengePeak operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @param scheduleType The scheduleType parameter.
     * @param needDetail The needDetail parameter.
     * @param needAll The needAll parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getStarRailChallengePeakWithResponse(String cookie, String server,
        String roleId, String ds, Integer scheduleType, Boolean needDetail, Boolean needAll,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.GameRecordApi.getStarRailChallengePeak", requestContext,
            updatedContext -> this.serviceClient.getStarRailChallengePeakWithResponse(cookie, server, roleId, ds,
                scheduleType, needDetail, needAll, updatedContext));
    }

    /**
     * The getStarRailChallengePeak operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param ds The ds parameter.
     * @param scheduleType The scheduleType parameter.
     * @param needDetail The needDetail parameter.
     * @param needAll The needAll parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getStarRailChallengePeak(String cookie, String server, String roleId, String ds,
        Integer scheduleType, Boolean needDetail, Boolean needAll) {
        return getStarRailChallengePeakWithResponse(cookie, server, roleId, ds, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getStarRailChallengePeak operation.
     * 
     * @param cookie The cookie parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getStarRailChallengePeak(String cookie, String server, String roleId) {
        final String ds = null;
        final Integer scheduleType = null;
        final Boolean needDetail = null;
        final Boolean needAll = null;
        return getStarRailChallengePeakWithResponse(cookie, server, roleId, ds, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }
}
