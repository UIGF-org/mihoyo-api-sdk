package uigf.game.genshin.record;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponseCharacterList;
import uigf.ApiResponseJsonObject;
import uigf.checkin.implementation.GenshinRecordApisImpl;
import uigf.game.CharacterDetailRequest;
import uigf.game.CharacterListRequest;

/**
 * Initializes a new instance of the synchronous RecordClient type.
 */
@ServiceClient(builder = RecordClientBuilder.class)
public final class GenshinRecordApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GenshinRecordApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GenshinRecordApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GenshinRecordApiClient(GenshinRecordApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getIndex operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param avatarListType The avatarListType parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getIndexWithResponse(String cookie, String ds, String server, String roleId,
        Integer avatarListType, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getIndex",
            requestContext, updatedContext -> this.serviceClient.getIndexWithResponse(cookie, ds, server, roleId,
                avatarListType, updatedContext));
    }

    /**
     * The getIndex operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param avatarListType The avatarListType parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getIndex(String cookie, String ds, String server, String roleId,
        Integer avatarListType) {
        return getIndexWithResponse(cookie, ds, server, roleId, avatarListType, RequestContext.none()).getValue();
    }

    /**
     * The getIndex operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getIndex(String cookie, String ds, String server, String roleId) {
        final Integer avatarListType = null;
        return getIndexWithResponse(cookie, ds, server, roleId, avatarListType, RequestContext.none()).getValue();
    }

    /**
     * The listCharacters operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseCharacterList> listCharactersWithResponse(String cookie, String ds,
        CharacterListRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.listCharacters",
            requestContext,
            updatedContext -> this.serviceClient.listCharactersWithResponse(cookie, ds, body, updatedContext));
    }

    /**
     * The listCharacters operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseCharacterList listCharacters(String cookie, String ds, CharacterListRequest body) {
        return listCharactersWithResponse(cookie, ds, body, RequestContext.none()).getValue();
    }

    /**
     * Character IDs should be sent in batches of at most 40, as used by TeyvatGuide.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseCharacterList> getCharacterDetailsWithResponse(String cookie, String ds,
        CharacterDetailRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getCharacterDetails",
            requestContext,
            updatedContext -> this.serviceClient.getCharacterDetailsWithResponse(cookie, ds, body, updatedContext));
    }

    /**
     * Character IDs should be sent in batches of at most 40, as used by TeyvatGuide.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseCharacterList getCharacterDetails(String cookie, String ds, CharacterDetailRequest body) {
        return getCharacterDetailsWithResponse(cookie, ds, body, RequestContext.none()).getValue();
    }

    /**
     * The getDailyNote operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getDailyNoteWithResponse(String cookie, String ds, String server,
        String roleId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getDailyNote",
            requestContext,
            updatedContext -> this.serviceClient.getDailyNoteWithResponse(cookie, ds, server, roleId, updatedContext));
    }

    /**
     * The getDailyNote operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getDailyNote(String cookie, String ds, String server, String roleId) {
        return getDailyNoteWithResponse(cookie, ds, server, roleId, RequestContext.none()).getValue();
    }

    /**
     * The getSpiralAbyss operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
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
    public Response<ApiResponseJsonObject> getSpiralAbyssWithResponse(String cookie, String ds, String server,
        String roleId, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getSpiralAbyss",
            requestContext, updatedContext -> this.serviceClient.getSpiralAbyssWithResponse(cookie, ds, server, roleId,
                scheduleType, needDetail, needAll, updatedContext));
    }

    /**
     * The getSpiralAbyss operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
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
    public ApiResponseJsonObject getSpiralAbyss(String cookie, String ds, String server, String roleId,
        Integer scheduleType, Boolean needDetail, Boolean needAll) {
        return getSpiralAbyssWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getSpiralAbyss operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getSpiralAbyss(String cookie, String ds, String server, String roleId) {
        final Integer scheduleType = null;
        final Boolean needDetail = null;
        final Boolean needAll = null;
        return getSpiralAbyssWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getImaginariumTheater operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param active The active parameter.
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
    public Response<ApiResponseJsonObject> getImaginariumTheaterWithResponse(String cookie, String ds, String server,
        String roleId, Integer active, Integer scheduleType, Boolean needDetail, Boolean needAll,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Genshin.Record.GameRecordApi.getImaginariumTheater", requestContext,
            updatedContext -> this.serviceClient.getImaginariumTheaterWithResponse(cookie, ds, server, roleId, active,
                scheduleType, needDetail, needAll, updatedContext));
    }

    /**
     * The getImaginariumTheater operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param active The active parameter.
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
    public ApiResponseJsonObject getImaginariumTheater(String cookie, String ds, String server, String roleId,
        Integer active, Integer scheduleType, Boolean needDetail, Boolean needAll) {
        return getImaginariumTheaterWithResponse(cookie, ds, server, roleId, active, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getImaginariumTheater operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getImaginariumTheater(String cookie, String ds, String server, String roleId) {
        final Integer active = null;
        final Integer scheduleType = null;
        final Boolean needDetail = null;
        final Boolean needAll = null;
        return getImaginariumTheaterWithResponse(cookie, ds, server, roleId, active, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getCharacterMaster operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getCharacterMasterWithResponse(String cookie, String ds, String server,
        String roleId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getCharacterMaster",
            requestContext, updatedContext -> this.serviceClient.getCharacterMasterWithResponse(cookie, ds, server,
                roleId, updatedContext));
    }

    /**
     * The getCharacterMaster operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getCharacterMaster(String cookie, String ds, String server, String roleId) {
        return getCharacterMasterWithResponse(cookie, ds, server, roleId, RequestContext.none()).getValue();
    }

    /**
     * The getStygianOnslaught operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
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
    public Response<ApiResponseJsonObject> getStygianOnslaughtWithResponse(String cookie, String ds, String server,
        String roleId, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getStygianOnslaught",
            requestContext, updatedContext -> this.serviceClient.getStygianOnslaughtWithResponse(cookie, ds, server,
                roleId, scheduleType, needDetail, needAll, updatedContext));
    }

    /**
     * The getStygianOnslaught operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
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
    public ApiResponseJsonObject getStygianOnslaught(String cookie, String ds, String server, String roleId,
        Integer scheduleType, Boolean needDetail, Boolean needAll) {
        return getStygianOnslaughtWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getStygianOnslaught operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getStygianOnslaught(String cookie, String ds, String server, String roleId) {
        final Integer scheduleType = null;
        final Boolean needDetail = null;
        final Boolean needAll = null;
        return getStygianOnslaughtWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getStygianPopularity operation.
     * 
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getStygianPopularityWithResponse(String server, long roleId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Genshin.Record.GameRecordApi.getStygianPopularity", requestContext,
            updatedContext -> this.serviceClient.getStygianPopularityWithResponse(server, roleId, updatedContext));
    }

    /**
     * The getStygianPopularity operation.
     * 
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getStygianPopularity(String server, long roleId) {
        return getStygianPopularityWithResponse(server, roleId, RequestContext.none()).getValue();
    }

    /**
     * The getActivityCalendar operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @param challenge The challenge parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getActivityCalendarWithResponse(String cookie, String ds,
        CharacterListRequest body, String challenge, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getActivityCalendar",
            requestContext, updatedContext -> this.serviceClient.getActivityCalendarWithResponse(cookie, ds, body,
                challenge, updatedContext));
    }

    /**
     * The getActivityCalendar operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @param challenge The challenge parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getActivityCalendar(String cookie, String ds, CharacterListRequest body,
        String challenge) {
        return getActivityCalendarWithResponse(cookie, ds, body, challenge, RequestContext.none()).getValue();
    }

    /**
     * The getActivityCalendar operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getActivityCalendar(String cookie, String ds, CharacterListRequest body) {
        final String challenge = null;
        return getActivityCalendarWithResponse(cookie, ds, body, challenge, RequestContext.none()).getValue();
    }

    /**
     * The getCharacterTps operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getCharacterTpsWithResponse(String cookie, String ds, String server,
        String roleId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getCharacterTps",
            requestContext, updatedContext -> this.serviceClient.getCharacterTpsWithResponse(cookie, ds, server, roleId,
                updatedContext));
    }

    /**
     * The getCharacterTps operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param server The server parameter.
     * @param roleId The roleId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getCharacterTps(String cookie, String ds, String server, String roleId) {
        return getCharacterTpsWithResponse(cookie, ds, server, roleId, RequestContext.none()).getValue();
    }
}
