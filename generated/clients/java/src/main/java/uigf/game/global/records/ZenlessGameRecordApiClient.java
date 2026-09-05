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
import uigf.ApiResponseGachaLogPage;
import uigf.ApiResponseJsonObject;
import uigf.checkin.implementation.ZenlessGameRecordApisImpl;

/**
 * Initializes a new instance of the synchronous GlobalGameRecordsClient type.
 */
@ServiceClient(builder = GlobalGameRecordsClientBuilder.class)
public final class ZenlessGameRecordApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final ZenlessGameRecordApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ZenlessGameRecordApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    ZenlessGameRecordApiClient(ZenlessGameRecordApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getIndexWithResponse(String cookie, String server, String roleId, String ds,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.ZenlessGameRecordApi.getIndex",
            requestContext,
            updatedContext -> this.serviceClient.getIndexWithResponse(cookie, server, roleId, ds, updatedContext));
    }

    /**
     * The getIndex operation.
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
    public ApiResponseJsonObject getIndex(String cookie, String server, String roleId, String ds) {
        return getIndexWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
    }

    /**
     * The getIndex operation.
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
    public ApiResponseJsonObject getIndex(String cookie, String server, String roleId) {
        final String ds = null;
        return getIndexWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getDailyNoteWithResponse(String cookie, String server, String roleId,
        String ds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.ZenlessGameRecordApi.getDailyNote",
            requestContext,
            updatedContext -> this.serviceClient.getDailyNoteWithResponse(cookie, server, roleId, ds, updatedContext));
    }

    /**
     * The getDailyNote operation.
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
    public ApiResponseJsonObject getDailyNote(String cookie, String server, String roleId, String ds) {
        return getDailyNoteWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
    }

    /**
     * The getDailyNote operation.
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
    public ApiResponseJsonObject getDailyNote(String cookie, String server, String roleId) {
        final String ds = null;
        return getDailyNoteWithResponse(cookie, server, roleId, ds, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGachaLogPage> getGachaRecordWithResponse(String cookie, String uid, String region,
        int gachaType, Long endId, String lang, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getGachaRecord", requestContext,
            updatedContext -> this.serviceClient.getGachaRecordWithResponse(cookie, uid, region, gachaType, endId, lang,
                updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getGachaRecord(String cookie, String uid, String region, int gachaType, Long endId,
        String lang) {
        return getGachaRecordWithResponse(cookie, uid, region, gachaType, endId, lang, RequestContext.none())
            .getValue();
    }

    /**
     * The getGachaRecord operation.
     * 
     * @param cookie The cookie parameter.
     * @param uid The uid parameter.
     * @param region The region parameter.
     * @param gachaType The gachaType parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGachaLogPage getGachaRecord(String cookie, String uid, String region, int gachaType) {
        final Long endId = null;
        final String lang = null;
        return getGachaRecordWithResponse(cookie, uid, region, gachaType, endId, lang, RequestContext.none())
            .getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getShiyuDefenseWithResponse(String cookie, String server, String roleId,
        String ds, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getShiyuDefense", requestContext,
            updatedContext -> this.serviceClient.getShiyuDefenseWithResponse(cookie, server, roleId, ds, scheduleType,
                needDetail, needAll, updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getShiyuDefense(String cookie, String server, String roleId, String ds,
        Integer scheduleType, Boolean needDetail, Boolean needAll) {
        return getShiyuDefenseWithResponse(cookie, server, roleId, ds, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getShiyuDefense operation.
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
    public ApiResponseJsonObject getShiyuDefense(String cookie, String server, String roleId) {
        final String ds = null;
        final Integer scheduleType = null;
        final Boolean needDetail = null;
        final Boolean needAll = null;
        return getShiyuDefenseWithResponse(cookie, server, roleId, ds, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getDeadlyAssaultWithResponse(String cookie, int scheduleType, String region,
        String uid, String ds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getDeadlyAssault", requestContext,
            updatedContext -> this.serviceClient.getDeadlyAssaultWithResponse(cookie, scheduleType, region, uid, ds,
                updatedContext));
    }

    /**
     * The getDeadlyAssault operation.
     * 
     * @param cookie The cookie parameter.
     * @param scheduleType The scheduleType parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @param ds The ds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getDeadlyAssault(String cookie, int scheduleType, String region, String uid,
        String ds) {
        return getDeadlyAssaultWithResponse(cookie, scheduleType, region, uid, ds, RequestContext.none()).getValue();
    }

    /**
     * The getDeadlyAssault operation.
     * 
     * @param cookie The cookie parameter.
     * @param scheduleType The scheduleType parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getDeadlyAssault(String cookie, int scheduleType, String region, String uid) {
        final String ds = null;
        return getDeadlyAssaultWithResponse(cookie, scheduleType, region, uid, ds, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getThresholdSimulationSummaryWithResponse(String cookie, String region,
        String uid, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getThresholdSimulationSummary", requestContext,
            updatedContext -> this.serviceClient.getThresholdSimulationSummaryWithResponse(cookie, region, uid,
                updatedContext));
    }

    /**
     * The getThresholdSimulationSummary operation.
     * 
     * @param cookie The cookie parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getThresholdSimulationSummary(String cookie, String region, String uid) {
        return getThresholdSimulationSummaryWithResponse(cookie, region, uid, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getThresholdSimulationDetailWithResponse(String cookie, String region,
        String uid, int voidFrontId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.Records.ZenlessGameRecordApi.getThresholdSimulationDetail", requestContext,
            updatedContext -> this.serviceClient.getThresholdSimulationDetailWithResponse(cookie, region, uid,
                voidFrontId, updatedContext));
    }

    /**
     * The getThresholdSimulationDetail operation.
     * 
     * @param cookie The cookie parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @param voidFrontId The voidFrontId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getThresholdSimulationDetail(String cookie, String region, String uid,
        int voidFrontId) {
        return getThresholdSimulationDetailWithResponse(cookie, region, uid, voidFrontId, RequestContext.none())
            .getValue();
    }
}
