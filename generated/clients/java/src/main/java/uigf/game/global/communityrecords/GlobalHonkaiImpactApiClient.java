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
import uigf.checkin.implementation.GlobalHonkaiImpactApisImpl;

/**
 * Initializes a new instance of the synchronous CommunityRecordsClient type.
 */
@ServiceClient(builder = CommunityRecordsClientBuilder.class)
public final class GlobalHonkaiImpactApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GlobalHonkaiImpactApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalHonkaiImpactApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GlobalHonkaiImpactApiClient(GlobalHonkaiImpactApisImpl serviceClient, Instrumentation instrumentation) {
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
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.CommunityRecords.HonkaiImpactApi.getIndex",
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
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.CommunityRecords.HonkaiImpactApi.getDailyNote", requestContext,
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
}
