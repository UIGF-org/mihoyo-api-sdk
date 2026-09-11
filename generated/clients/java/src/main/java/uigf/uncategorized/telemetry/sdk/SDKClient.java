package uigf.uncategorized.telemetry.sdk;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import java.util.List;
import uigf.JsonObject;
import uigf.checkin.implementation.SdkTelemetryUploadApisImpl;
import uigf.uncategorized.UploadResponse;

/**
 * Initializes a new instance of the synchronous SDKClient type.
 */
@ServiceClient(builder = SDKClientBuilder.class)
public final class SDKClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final SdkTelemetryUploadApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of SDKClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    SDKClient(SdkTelemetryUploadApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The upload operation.
     * 
     * @param body The body parameter.
     * @param authorization The authorization parameter.
     * @param contentMd5 The contentMd5 parameter.
     * @param date The date parameter.
     * @param cmsSignature The cmsSignature parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<UploadResponse> uploadWithResponse(List<JsonObject> body, String authorization, String contentMd5,
        String date, String cmsSignature, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.SDK.UploadApi.upload",
            requestContext, updatedContext -> this.serviceClient.uploadWithResponse(body, authorization, contentMd5,
                date, cmsSignature, updatedContext));
    }

    /**
     * The upload operation.
     * 
     * @param body The body parameter.
     * @param authorization The authorization parameter.
     * @param contentMd5 The contentMd5 parameter.
     * @param date The date parameter.
     * @param cmsSignature The cmsSignature parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public UploadResponse upload(List<JsonObject> body, String authorization, String contentMd5, String date,
        String cmsSignature) {
        return uploadWithResponse(body, authorization, contentMd5, date, cmsSignature, RequestContext.none())
            .getValue();
    }

    /**
     * The upload operation.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public UploadResponse upload(List<JsonObject> body) {
        final String authorization = null;
        final String contentMd5 = null;
        final String date = null;
        final String cmsSignature = null;
        return uploadWithResponse(body, authorization, contentMd5, date, cmsSignature, RequestContext.none())
            .getValue();
    }
}
