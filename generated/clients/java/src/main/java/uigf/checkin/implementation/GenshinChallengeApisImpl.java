package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
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
import uigf.ApiResponseJsonObject;

/**
 * An instance of this class provides access to all the operations defined in GenshinChallengeApis.
 */
public final class GenshinChallengeApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GenshinChallengeApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityRecordsClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GenshinChallengeApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GenshinChallengeApisImpl(CommunityRecordsClientImpl client) {
        this.service = GenshinChallengeApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityRecordsClientGenshinChallengeApis to be used by the proxy
     * service to perform REST calls.
     */
    @ServiceInterface(name = "CommunityRecordsClientGenshinChallengeApis", host = "{endpoint}")
    public interface GenshinChallengeApisService {
        static GenshinChallengeApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GenshinChallengeApisServiceImpl");
                return (GenshinChallengeApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

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
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @QueryParam("schedule_type") Integer scheduleType, @QueryParam("need_detail") Boolean needDetail,
            @QueryParam("need_all") Boolean needAll, @QueryParam("server") String server,
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
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.CommunityRecords.GenshinChallengeApi.getSpiralAbyss", requestContext, updatedContext -> {
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
        String roleId, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.CommunityRecords.GenshinChallengeApi.getImaginariumTheater", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getImaginariumTheater(this.client.getEndpoint(), cookie, ds, scheduleType, needDetail,
                    needAll, server, roleId, accept, updatedContext);
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
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.CommunityRecords.GenshinChallengeApi.getStygianOnslaught", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getStygianOnslaught(this.client.getEndpoint(), cookie, ds, scheduleType, needDetail,
                    needAll, server, roleId, accept, updatedContext);
            });
    }
}
