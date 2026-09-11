package uigf.uncategorized.ugc;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import io.clientcore.core.models.binarydata.BinaryData;
import uigf.checkin.implementation.LevelApisImpl;

/**
 * Initializes a new instance of the synchronous UGCClient type.
 */
@ServiceClient(builder = UGCClientBuilder.class)
public final class LevelApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final LevelApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of LevelApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    LevelApiClient(LevelApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getIndexRedpointWithResponse(RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.UGC.LevelApi.getIndexRedpoint",
            requestContext, updatedContext -> this.serviceClient.getIndexRedpointWithResponse(updatedContext));
    }

    /**
     * The observed request and response use the vendor's protobuf media type.
     * 
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public BinaryData getIndexRedpoint() {
        return getIndexRedpointWithResponse(RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getCollectionTinyInfoWithResponse(BinaryData body, long contentLength,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.UGC.LevelApi.getCollectionTinyInfo",
            requestContext, updatedContext -> this.serviceClient.getCollectionTinyInfoWithResponse(body, contentLength,
                updatedContext));
    }

    /**
     * The gateway payload is opaque protobuf data in the available capture.
     * 
     * @param body The body parameter.
     * @param contentLength The Content-Length header for the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public BinaryData getCollectionTinyInfo(BinaryData body, long contentLength) {
        return getCollectionTinyInfoWithResponse(body, contentLength, RequestContext.none()).getValue();
    }
}
