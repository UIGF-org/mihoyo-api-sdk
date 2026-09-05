package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.QueryParam;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import uigf.ApiResponseCharacterList;
import uigf.ApiResponseJsonObject;
import uigf.game.CharacterDetailRequest;
import uigf.game.CharacterListRequest;

/**
 * An instance of this class provides access to all the operations defined in GenshinRecordApis.
 */
public final class GenshinRecordApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GenshinRecordApisService service;

    /**
     * The service client containing this operation class.
     */
    private final RecordClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GenshinRecordApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GenshinRecordApisImpl(RecordClientImpl client) {
        this.service = GenshinRecordApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for RecordClientGenshinRecordApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "RecordClientGenshinRecordApis", host = "{endpoint}")
    public interface GenshinRecordApisService {
        static GenshinRecordApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GenshinRecordApisServiceImpl");
                return (GenshinRecordApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/genshin/api/index",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getIndex(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @QueryParam("avatar_list_type") Integer avatarListType, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/game_record/app/genshin/api/character/list",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseCharacterList> listCharacters(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") CharacterListRequest body, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/game_record/app/genshin/api/character/detail",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseCharacterList> getCharacterDetails(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") CharacterDetailRequest body, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/genshin/api/dailyNote",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getDailyNote(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/genshin/api/spiralAbyss",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getSpiralAbyss(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @QueryParam("schedule_type") Integer scheduleType, @QueryParam("need_detail") Boolean needDetail,
            @QueryParam("need_all") Boolean needAll, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/genshin/api/role_combat",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getImaginariumTheater(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("active") Integer active,
            @QueryParam("schedule_type") Integer scheduleType, @QueryParam("need_detail") Boolean needDetail,
            @QueryParam("need_all") Boolean needAll, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/genshin/api/char_master",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getCharacterMaster(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/genshin/api/hard_challenge",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getStygianOnslaught(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @QueryParam("schedule_type") Integer scheduleType, @QueryParam("need_detail") Boolean needDetail,
            @QueryParam("need_all") Boolean needAll, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/genshin/api/hard_challenge/popularity",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getStygianPopularity(@HostParam("endpoint") String endpoint,
            @QueryParam("server") String server, @QueryParam("role_id") long roleId,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/game_record/app/genshin/api/act_calendar",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getActivityCalendar(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @HeaderParam("x-rpc-challenge") String challenge, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") CharacterListRequest body,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/genshin/api/tps",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getCharacterTps(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getIndexWithResponse(String cookie, String ds, String server, String roleId,
        Integer avatarListType, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getIndex",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getIndex(this.client.getEndpoint(), cookie, ds, avatarListType, server, roleId, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseCharacterList> listCharactersWithResponse(String cookie, String ds,
        CharacterListRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.listCharacters",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.listCharacters(this.client.getEndpoint(), cookie, ds, contentType, accept, body,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseCharacterList> getCharacterDetailsWithResponse(String cookie, String ds,
        CharacterDetailRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getCharacterDetails",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.getCharacterDetails(this.client.getEndpoint(), cookie, ds, contentType, accept, body,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getDailyNoteWithResponse(String cookie, String ds, String server,
        String roleId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getDailyNote",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getDailyNote(this.client.getEndpoint(), cookie, ds, server, roleId, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getSpiralAbyssWithResponse(String cookie, String ds, String server,
        String roleId, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getSpiralAbyss",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getSpiralAbyss(this.client.getEndpoint(), cookie, ds, scheduleType, needDetail, needAll,
                    server, roleId, accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getImaginariumTheaterWithResponse(String cookie, String ds, String server,
        String roleId, Integer active, Integer scheduleType, Boolean needDetail, Boolean needAll,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Genshin.Record.GameRecordApi.getImaginariumTheater", requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getImaginariumTheater(this.client.getEndpoint(), cookie, ds, active, scheduleType,
                    needDetail, needAll, server, roleId, accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getCharacterMasterWithResponse(String cookie, String ds, String server,
        String roleId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getCharacterMaster",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getCharacterMaster(this.client.getEndpoint(), cookie, ds, server, roleId, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getStygianOnslaughtWithResponse(String cookie, String ds, String server,
        String roleId, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getStygianOnslaught",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getStygianOnslaught(this.client.getEndpoint(), cookie, ds, scheduleType, needDetail,
                    needAll, server, roleId, accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getStygianPopularityWithResponse(String server, long roleId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Genshin.Record.GameRecordApi.getStygianPopularity", requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getStygianPopularity(this.client.getEndpoint(), server, roleId, accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getActivityCalendarWithResponse(String cookie, String ds,
        CharacterListRequest body, String challenge, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getActivityCalendar",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.getActivityCalendar(this.client.getEndpoint(), cookie, ds, challenge, contentType,
                    accept, body, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getCharacterTpsWithResponse(String cookie, String ds, String server,
        String roleId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.GameRecordApi.getCharacterTps",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getCharacterTps(this.client.getEndpoint(), cookie, ds, server, roleId, accept,
                    updatedContext);
            });
    }
}
