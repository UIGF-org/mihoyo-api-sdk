package uigf.game.global.communityrecords;

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
import uigf.checkin.implementation.StarRailChallengeApisImpl;

/**
 * Initializes a new instance of the synchronous CommunityRecordsClient type.
 */
@ServiceClient(builder = CommunityRecordsClientBuilder.class)
public final class StarRailChallengeApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final StarRailChallengeApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of StarRailChallengeApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    StarRailChallengeApiClient(StarRailChallengeApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getForgottenHall operation.
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
    public Response<ApiResponseJsonObject> getForgottenHallWithResponse(String cookie, String ds, String server,
        String roleId, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.CommunityRecords.StarRailChallengeApi.getForgottenHall", requestContext,
            updatedContext -> this.serviceClient.getForgottenHallWithResponse(cookie, ds, server, roleId, scheduleType,
                needDetail, needAll, updatedContext));
    }

    /**
     * The getForgottenHall operation.
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
    public ApiResponseJsonObject getForgottenHall(String cookie, String ds, String server, String roleId,
        Integer scheduleType, Boolean needDetail, Boolean needAll) {
        return getForgottenHallWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getForgottenHall operation.
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
    public ApiResponseJsonObject getForgottenHall(String cookie, String ds, String server, String roleId) {
        final Integer scheduleType = null;
        final Boolean needDetail = null;
        final Boolean needAll = null;
        return getForgottenHallWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getPureFiction operation.
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
    public Response<ApiResponseJsonObject> getPureFictionWithResponse(String cookie, String ds, String server,
        String roleId, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.CommunityRecords.StarRailChallengeApi.getPureFiction", requestContext,
            updatedContext -> this.serviceClient.getPureFictionWithResponse(cookie, ds, server, roleId, scheduleType,
                needDetail, needAll, updatedContext));
    }

    /**
     * The getPureFiction operation.
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
    public ApiResponseJsonObject getPureFiction(String cookie, String ds, String server, String roleId,
        Integer scheduleType, Boolean needDetail, Boolean needAll) {
        return getPureFictionWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getPureFiction operation.
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
    public ApiResponseJsonObject getPureFiction(String cookie, String ds, String server, String roleId) {
        final Integer scheduleType = null;
        final Boolean needDetail = null;
        final Boolean needAll = null;
        return getPureFictionWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getApocalypticShadow operation.
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
    public Response<ApiResponseJsonObject> getApocalypticShadowWithResponse(String cookie, String ds, String server,
        String roleId, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.CommunityRecords.StarRailChallengeApi.getApocalypticShadow", requestContext,
            updatedContext -> this.serviceClient.getApocalypticShadowWithResponse(cookie, ds, server, roleId,
                scheduleType, needDetail, needAll, updatedContext));
    }

    /**
     * The getApocalypticShadow operation.
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
    public ApiResponseJsonObject getApocalypticShadow(String cookie, String ds, String server, String roleId,
        Integer scheduleType, Boolean needDetail, Boolean needAll) {
        return getApocalypticShadowWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getApocalypticShadow operation.
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
    public ApiResponseJsonObject getApocalypticShadow(String cookie, String ds, String server, String roleId) {
        final Integer scheduleType = null;
        final Boolean needDetail = null;
        final Boolean needAll = null;
        return getApocalypticShadowWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getSimulatedUniverse operation.
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
    public Response<ApiResponseJsonObject> getSimulatedUniverseWithResponse(String cookie, String ds, String server,
        String roleId, Integer scheduleType, Boolean needDetail, Boolean needAll, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.CommunityRecords.StarRailChallengeApi.getSimulatedUniverse", requestContext,
            updatedContext -> this.serviceClient.getSimulatedUniverseWithResponse(cookie, ds, server, roleId,
                scheduleType, needDetail, needAll, updatedContext));
    }

    /**
     * The getSimulatedUniverse operation.
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
    public ApiResponseJsonObject getSimulatedUniverse(String cookie, String ds, String server, String roleId,
        Integer scheduleType, Boolean needDetail, Boolean needAll) {
        return getSimulatedUniverseWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }

    /**
     * The getSimulatedUniverse operation.
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
    public ApiResponseJsonObject getSimulatedUniverse(String cookie, String ds, String server, String roleId) {
        final Integer scheduleType = null;
        final Boolean needDetail = null;
        final Boolean needAll = null;
        return getSimulatedUniverseWithResponse(cookie, ds, server, roleId, scheduleType, needDetail, needAll,
            RequestContext.none()).getValue();
    }
}
