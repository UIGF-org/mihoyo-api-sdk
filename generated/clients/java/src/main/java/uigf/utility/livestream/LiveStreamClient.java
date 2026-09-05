package uigf.utility.livestream;

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
import uigf.checkin.implementation.RedemptionCodeApisImpl;

/**
 * Initializes a new instance of the synchronous LiveStreamClient type.
 */
@ServiceClient(builder = LiveStreamClientBuilder.class)
public final class LiveStreamClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final RedemptionCodeApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of LiveStreamClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    LiveStreamClient(RedemptionCodeApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The refresh operation.
     * 
     * @param activityId The activityId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> refreshWithResponse(String activityId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Utility.LiveStream.RedemptionCodeApi.refresh",
            requestContext, updatedContext -> this.serviceClient.refreshWithResponse(activityId, updatedContext));
    }

    /**
     * The refresh operation.
     * 
     * @param activityId The activityId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject refresh(String activityId) {
        return refreshWithResponse(activityId, RequestContext.none()).getValue();
    }
}
