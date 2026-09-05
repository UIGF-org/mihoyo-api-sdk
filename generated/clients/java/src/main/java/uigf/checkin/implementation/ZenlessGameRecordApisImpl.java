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
import uigf.ApiResponseGachaLogPage;
import uigf.ApiResponseJsonObject;

/**
 * An instance of this class provides access to all the operations defined in ZenlessGameRecordApis.
 */
public final class ZenlessGameRecordApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ZenlessGameRecordApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GlobalGameRecordsClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ZenlessGameRecordApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ZenlessGameRecordApisImpl(GlobalGameRecordsClientImpl client) {
        this.service = ZenlessGameRecordApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GlobalGameRecordsClientZenlessGameRecordApis to be used by the proxy
     * service to perform REST calls.
     */
    @ServiceInterface(name = "GlobalGameRecordsClientZenlessGameRecordApis", host = "{endpoint}")
    public interface ZenlessGameRecordApisService {
        static ZenlessGameRecordApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.ZenlessGameRecordApisServiceImpl");
                return (ZenlessGameRecordApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/game_record_zzz/api/zzz/index",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getIndex(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/game_record_zzz/api/zzz/note",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getDailyNote(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/game_record_zzz/api/zzz/gacha_record",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseGachaLogPage> getGachaRecord(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @QueryParam("uid") String uid, @QueryParam("region") String region,
            @QueryParam("gacha_type") int gachaType, @QueryParam("end_id") Long endId, @QueryParam("lang") String lang,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/game_record_zzz/api/zzz/hadal_info_v2",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getShiyuDefense(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @QueryParam("schedule_type") Integer scheduleType, @QueryParam("need_detail") Boolean needDetail,
            @QueryParam("need_all") Boolean needAll, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/game_record_zzz/api/zzz/hadal_mem_detail_v2",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getDeadlyAssault(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @QueryParam("schedule_type") int scheduleType, @QueryParam("region") String region,
            @QueryParam("uid") String uid, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/game_record_zzz/api/zzz/void_front_battle_abstract_info",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getThresholdSimulationSummary(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @QueryParam("region") String region, @QueryParam("uid") String uid,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/game_record_zzz/api/zzz/void_front_battle_detail",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getThresholdSimulationDetail(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @QueryParam("region") String region, @QueryParam("uid") String uid,
            @QueryParam("void_front_id") int voidFrontId, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
    }

    /**
     * The getIndex operation.
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getIndexWithResponse(String cookie, String server, String roleId, String ds,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.ZenlessGameRecordApi.getIndex",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getIndex(this.client.getEndpoint(), cookie, ds, server, roleId, accept, updatedContext);
            });
    }

    /**
     * The getDailyNote operation.
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getDailyNoteWithResponse(String cookie, String server, String roleId,
        String ds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.ZenlessGameRecordApi.getDailyNote",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getDailyNote(this.client.getEndpoint(), cookie, ds, server, roleId, accept,
                    updatedContext);
            });
    }

    /**
     * The getGachaRecord operation.
     * 
     * @param cookie The cookie parameter.
     * @param uid The uid parameter.
     * @param region The region parameter.
     * @param gachaType The gachaType parameter.
     * @param endId The endId parameter.
     * @param lang The lang parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGachaLogPage> getGachaRecordWithResponse(String cookie, String uid, String region,
        int gachaType, Long endId, String lang, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getGachaRecord", requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getGachaRecord(this.client.getEndpoint(), cookie, uid, region, gachaType, endId, lang,
                    accept, updatedContext);
            });
    }

    /**
     * The getShiyuDefense operation.
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getShiyuDefenseWithResponse(String cookie, String server, String roleId,
        String ds, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getShiyuDefense", requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getShiyuDefense(this.client.getEndpoint(), cookie, ds, scheduleType, needDetail, needAll,
                    server, roleId, accept, updatedContext);
            });
    }

    /**
     * The getDeadlyAssault operation.
     * 
     * @param cookie The cookie parameter.
     * @param scheduleType The scheduleType parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @param ds The ds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getDeadlyAssaultWithResponse(String cookie, int scheduleType, String region,
        String uid, String ds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getDeadlyAssault", requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getDeadlyAssault(this.client.getEndpoint(), cookie, ds, scheduleType, region, uid,
                    accept, updatedContext);
            });
    }

    /**
     * The getThresholdSimulationSummary operation.
     * 
     * @param cookie The cookie parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getThresholdSimulationSummaryWithResponse(String cookie, String region,
        String uid, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getThresholdSimulationSummary", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getThresholdSimulationSummary(this.client.getEndpoint(), cookie, region, uid, accept,
                    updatedContext);
            });
    }

    /**
     * The getThresholdSimulationDetail operation.
     * 
     * @param cookie The cookie parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @param voidFrontId The voidFrontId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getThresholdSimulationDetailWithResponse(String cookie, String region,
        String uid, int voidFrontId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getThresholdSimulationDetail", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getThresholdSimulationDetail(this.client.getEndpoint(), cookie, region, uid, voidFrontId,
                    accept, updatedContext);
            });
    }
}
