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
 * An instance of this class provides access to all the operations defined in GateApis.
 */
public final class GateApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GateApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GateClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GateApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GateApisImpl(GateClientImpl client) {
        this.service = GateApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GateClientGateApis to be used by the proxy service to perform REST
     * calls.
     */
    @ServiceInterface(name = "GateClientGateApis", host = "{endpoint}")
    public interface GateApisService {
        static GateApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GateApisServiceImpl");
                return (GateApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/dispatch/dispatch/getGateAddress",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getAddress(@HostParam("endpoint") String endpoint,
            @QueryParam("game") String game, @QueryParam("region") String region, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
    }

    /**
     * The getAddress operation.
     * 
     * @param game The game parameter.
     * @param region The region parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getAddressWithResponse(String game, String region,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Dispatch.Gate.GateApi.getAddress",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getAddress(this.client.getEndpoint(), game, region, accept, updatedContext);
            });
    }
}
