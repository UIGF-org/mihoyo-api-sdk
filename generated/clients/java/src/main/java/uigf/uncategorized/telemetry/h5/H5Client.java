package uigf.uncategorized.telemetry.h5;

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
import uigf.checkin.implementation.BatchApisImpl;
import uigf.uncategorized.H5LogRequest;

/**
 * Initializes a new instance of the synchronous H5Client type.
 */
@ServiceClient(builder = H5ClientBuilder.class)
public final class H5Client {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final BatchApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of H5Client class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    H5Client(BatchApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> uploadWithResponse(String topic, H5LogRequest body, String date,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.H5.BatchApi.upload",
            requestContext, updatedContext -> this.serviceClient.uploadWithResponse(topic, body, date, updatedContext));
    }

    /**
     * The upload operation.
     * 
     * @param topic The topic parameter.
     * @param body The body parameter.
     * @param date The date parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject upload(String topic, H5LogRequest body, String date) {
        return uploadWithResponse(topic, body, date, RequestContext.none()).getValue();
    }

    /**
     * The upload operation.
     * 
     * @param topic The topic parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject upload(String topic, H5LogRequest body) {
        final String date = null;
        return uploadWithResponse(topic, body, date, RequestContext.none()).getValue();
    }
}
