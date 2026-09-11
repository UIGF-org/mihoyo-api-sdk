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
import java.util.List;
import uigf.JsonObject;
import uigf.checkin.implementation.GameTelemetryUploadApisImpl;
import uigf.uncategorized.UploadResponse;

/**
 * Initializes a new instance of the synchronous GameClient type.
 */
@ServiceClient(builder = GameClientBuilder.class)
public final class GameTelemetryUploadApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GameTelemetryUploadApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GameTelemetryUploadApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GameTelemetryUploadApiClient(GameTelemetryUploadApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The official client signs the upload headers; signing is intentionally caller-owned.
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
    public Response<UploadResponse> uploadCrashWithResponse(List<JsonObject> body, String authorization,
        String contentMd5, String date, String cmsSignature, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.Game.UploadApi.uploadCrash",
            requestContext, updatedContext -> this.serviceClient.uploadCrashWithResponse(body, authorization,
                contentMd5, date, cmsSignature, updatedContext));
    }

    /**
     * The official client signs the upload headers; signing is intentionally caller-owned.
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
    public UploadResponse uploadCrash(List<JsonObject> body, String authorization, String contentMd5, String date,
        String cmsSignature) {
        return uploadCrashWithResponse(body, authorization, contentMd5, date, cmsSignature, RequestContext.none())
            .getValue();
    }

    /**
     * The official client signs the upload headers; signing is intentionally caller-owned.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public UploadResponse uploadCrash(List<JsonObject> body) {
        final String authorization = null;
        final String contentMd5 = null;
        final String date = null;
        final String cmsSignature = null;
        return uploadCrashWithResponse(body, authorization, contentMd5, date, cmsSignature, RequestContext.none())
            .getValue();
    }

    /**
     * The uploadSdk operation.
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
    public Response<UploadResponse> uploadSdkWithResponse(List<JsonObject> body, String authorization,
        String contentMd5, String date, String cmsSignature, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.Game.UploadApi.uploadSdk",
            requestContext, updatedContext -> this.serviceClient.uploadSdkWithResponse(body, authorization, contentMd5,
                date, cmsSignature, updatedContext));
    }

    /**
     * The uploadSdk operation.
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
    public UploadResponse uploadSdk(List<JsonObject> body, String authorization, String contentMd5, String date,
        String cmsSignature) {
        return uploadSdkWithResponse(body, authorization, contentMd5, date, cmsSignature, RequestContext.none())
            .getValue();
    }

    /**
     * The uploadSdk operation.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public UploadResponse uploadSdk(List<JsonObject> body) {
        final String authorization = null;
        final String contentMd5 = null;
        final String date = null;
        final String cmsSignature = null;
        return uploadSdkWithResponse(body, authorization, contentMd5, date, cmsSignature, RequestContext.none())
            .getValue();
    }

    /**
     * The uploadCustom operation.
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
    public Response<UploadResponse> uploadCustomWithResponse(List<JsonObject> body, String authorization,
        String contentMd5, String date, String cmsSignature, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.Game.UploadApi.uploadCustom",
            requestContext, updatedContext -> this.serviceClient.uploadCustomWithResponse(body, authorization,
                contentMd5, date, cmsSignature, updatedContext));
    }

    /**
     * The uploadCustom operation.
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
    public UploadResponse uploadCustom(List<JsonObject> body, String authorization, String contentMd5, String date,
        String cmsSignature) {
        return uploadCustomWithResponse(body, authorization, contentMd5, date, cmsSignature, RequestContext.none())
            .getValue();
    }

    /**
     * The uploadCustom operation.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public UploadResponse uploadCustom(List<JsonObject> body) {
        final String authorization = null;
        final String contentMd5 = null;
        final String date = null;
        final String cmsSignature = null;
        return uploadCustomWithResponse(body, authorization, contentMd5, date, cmsSignature, RequestContext.none())
            .getValue();
    }
}
