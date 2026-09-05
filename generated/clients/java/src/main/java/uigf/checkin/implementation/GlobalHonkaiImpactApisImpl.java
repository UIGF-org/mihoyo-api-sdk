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
 * An instance of this class provides access to all the operations defined in GlobalHonkaiImpactApis.
 */
public final class GlobalHonkaiImpactApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GlobalHonkaiImpactApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityRecordsClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalHonkaiImpactApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GlobalHonkaiImpactApisImpl(CommunityRecordsClientImpl client) {
        this.service = GlobalHonkaiImpactApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityRecordsClientGlobalHonkaiImpactApis to be used by the proxy
     * service to perform REST calls.
     */
    @ServiceInterface(name = "CommunityRecordsClientGlobalHonkaiImpactApis", host = "{endpoint}")
    public interface GlobalHonkaiImpactApisService {
        static GlobalHonkaiImpactApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GlobalHonkaiImpactApisServiceImpl");
                return (GlobalHonkaiImpactApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/honkai3rd/api/index",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getIndex(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/honkai3rd/api/note",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getDailyNote(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("server") String server,
            @QueryParam("role_id") String roleId, @HeaderParam("Accept") String accept, RequestContext requestContext);
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
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.CommunityRecords.HonkaiImpactApi.getIndex",
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
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Global.CommunityRecords.HonkaiImpactApi.getDailyNote", requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getDailyNote(this.client.getEndpoint(), cookie, ds, server, roleId, accept,
                    updatedContext);
            });
    }
}
