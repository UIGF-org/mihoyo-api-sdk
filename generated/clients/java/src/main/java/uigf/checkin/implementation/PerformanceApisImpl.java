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
import uigf.uncategorized.UploadResponse;

/**
 * An instance of this class provides access to all the operations defined in PerformanceApis.
 */
public final class PerformanceApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final PerformanceApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GameClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of PerformanceApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    PerformanceApisImpl(GameClientImpl client) {
        this.service = PerformanceApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GameClientPerformanceApis to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "GameClientPerformanceApis", host = "{endpoint}")
    public interface PerformanceApisService {
        static PerformanceApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.PerformanceApisServiceImpl");
                return (PerformanceApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(method = HttpMethod.GET, path = "/perf/config/verify", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<UploadResponse> verify(@HostParam("endpoint") String endpoint,
            @QueryParam("device_id") String deviceId, @QueryParam("name") String name,
            @QueryParam("platform") String platform, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
    }

    /**
     * The verify operation.
     * 
     * @param deviceId The deviceId parameter.
     * @param name The name parameter.
     * @param platform The platform parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<UploadResponse> verifyWithResponse(String deviceId, String name, String platform,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.Game.PerformanceApi.verify",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.verify(this.client.getEndpoint(), deviceId, name, platform, accept, updatedContext);
            });
    }
}
