package uigf.uncategorized.telemetry.game;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.checkin.implementation.PerformanceApisImpl;
import uigf.uncategorized.UploadResponse;

/**
 * Initializes a new instance of the synchronous GameClient type.
 */
@ServiceClient(builder = GameClientBuilder.class)
public final class PerformanceApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final PerformanceApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of PerformanceApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    PerformanceApiClient(PerformanceApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<UploadResponse> verifyWithResponse(String deviceId, String name, String platform,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.Game.PerformanceApi.verify",
            requestContext,
            updatedContext -> this.serviceClient.verifyWithResponse(deviceId, name, platform, updatedContext));
    }

    /**
     * The verify operation.
     * 
     * @param deviceId The deviceId parameter.
     * @param name The name parameter.
     * @param platform The platform parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public UploadResponse verify(String deviceId, String name, String platform) {
        return verifyWithResponse(deviceId, name, platform, RequestContext.none()).getValue();
    }
}
