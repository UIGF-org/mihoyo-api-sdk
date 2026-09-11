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
import uigf.uncategorized.ExperimentListRequest;
import uigf.uncategorized.ExperimentListResponse;

/**
 * An instance of this class provides access to all the operations defined in ExperimentApis.
 */
public final class ExperimentApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ExperimentApisService service;

    /**
     * The service client containing this operation class.
     */
    private final ExperimentationClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ExperimentApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ExperimentApisImpl(ExperimentationClientImpl client) {
        this.service = ExperimentApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for ExperimentationClientExperimentApis to be used by the proxy service
     * to perform REST calls.
     */
    @ServiceInterface(name = "ExperimentationClientExperimentApis", host = "{endpoint}")
    public interface ExperimentApisService {
        static ExperimentApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.ExperimentApisServiceImpl");
                return (ExperimentApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/data_abtest_api/config/experiment/list",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ExperimentListResponse> list(@HostParam("endpoint") String endpoint,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") ExperimentListRequest body, RequestContext requestContext);
    }

    /**
     * The list operation.
     * 
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ExperimentListResponse> listWithResponse(ExperimentListRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Experimentation.ExperimentApi.list",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.list(this.client.getEndpoint(), contentType, accept, body, updatedContext);
            });
    }
}
