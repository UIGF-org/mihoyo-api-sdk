package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
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
import uigf.uncategorized.H5LogRequest;

/**
 * An instance of this class provides access to all the operations defined in BatchApis.
 */
public final class BatchApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final BatchApisService service;

    /**
     * The service client containing this operation class.
     */
    private final H5ClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of BatchApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    BatchApisImpl(H5ClientImpl client) {
        this.service = BatchApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for H5ClientBatchApis to be used by the proxy service to perform REST
     * calls.
     */
    @ServiceInterface(name = "H5ClientBatchApis", host = "{endpoint}")
    public interface BatchApisService {
        static BatchApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.BatchApisServiceImpl");
                return (BatchApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/common/h5log/log/batch",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> upload(@HostParam("endpoint") String endpoint,
            @QueryParam("topic") String topic, @HeaderParam("DATE") String date,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") H5LogRequest body, RequestContext requestContext);
    }

    /**
     * The upload operation.
     * 
     * @param topic The topic parameter.
     * @param body The body parameter.
     * @param date The date parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> uploadWithResponse(String topic, H5LogRequest body, String date,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.H5.BatchApi.upload",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.upload(this.client.getEndpoint(), topic, date, contentType, accept, body,
                    updatedContext);
            });
    }
}
