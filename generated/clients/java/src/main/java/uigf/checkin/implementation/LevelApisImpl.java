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
import io.clientcore.core.models.binarydata.BinaryData;
import java.lang.reflect.InvocationTargetException;

/**
 * An instance of this class provides access to all the operations defined in LevelApis.
 */
public final class LevelApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final LevelApisService service;

    /**
     * The service client containing this operation class.
     */
    private final UGCClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of LevelApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    LevelApisImpl(UGCClientImpl client) {
        this.service = LevelApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for UGCClientLevelApis to be used by the proxy service to perform REST
     * calls.
     */
    @ServiceInterface(name = "UGCClientLevelApis", host = "{endpoint}")
    public interface LevelApisService {
        static LevelApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.LevelApisServiceImpl");
                return (LevelApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/ugc_gateway/v1/level_rec/index_redpoint",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<BinaryData> getIndexRedpoint(@HostParam("endpoint") String endpoint,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/ugc_gateway/v1/levels/collection/tiny_info",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<BinaryData> getCollectionTinyInfo(@HostParam("endpoint") String endpoint,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/octet-stream") BinaryData body, @HeaderParam("Content-Length") long contentLength,
            RequestContext requestContext);
    }

    /**
     * The observed request and response use the vendor's protobuf media type.
     * 
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getIndexRedpointWithResponse(RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.UGC.LevelApi.getIndexRedpoint",
            requestContext, updatedContext -> {
                final String accept = "application/octet-stream";
                return service.getIndexRedpoint(this.client.getEndpoint(), accept, updatedContext);
            });
    }

    /**
     * The gateway payload is opaque protobuf data in the available capture.
     * 
     * @param body The body parameter.
     * @param contentLength The Content-Length header for the request.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getCollectionTinyInfoWithResponse(BinaryData body, long contentLength,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.UGC.LevelApi.getCollectionTinyInfo",
            requestContext, updatedContext -> {
                final String contentType = "application/octet-stream";
                final String accept = "application/octet-stream";
                return service.getCollectionTinyInfo(this.client.getEndpoint(), contentType, accept, body,
                    contentLength, updatedContext);
            });
    }
}
