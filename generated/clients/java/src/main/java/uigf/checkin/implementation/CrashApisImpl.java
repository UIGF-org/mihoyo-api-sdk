package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import uigf.JsonObject;

/**
 * An instance of this class provides access to all the operations defined in CrashApis.
 */
public final class CrashApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final CrashApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CrashClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CrashApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    CrashApisImpl(CrashClientImpl client) {
        this.service = CrashApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CrashClientCrashApis to be used by the proxy service to perform REST
     * calls.
     */
    @ServiceInterface(name = "CrashClientCrashApis", host = "{endpoint}")
    public interface CrashApisService {
        static CrashApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.CrashApisServiceImpl");
                return (CrashApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(method = HttpMethod.POST, path = "/log", expectedStatusCodes = { 204 })
        @UnexpectedResponseExceptionDetail
        Response<Void> upload(@HostParam("endpoint") String endpoint, @HeaderParam("Content-Type") String contentType,
            @BodyParam("application/json") JsonObject body, RequestContext requestContext);
    }

    /**
     * The upload operation.
     * 
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> uploadWithResponse(JsonObject body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.Crash.CrashApi.upload",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                return service.upload(this.client.getEndpoint(), contentType, body, updatedContext);
            });
    }
}
