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
import java.util.List;
import uigf.JsonObject;
import uigf.uncategorized.UploadResponse;

/**
 * An instance of this class provides access to all the operations defined in GameTelemetryUploadApis.
 */
public final class GameTelemetryUploadApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GameTelemetryUploadApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GameClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GameTelemetryUploadApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GameTelemetryUploadApisImpl(GameClientImpl client) {
        this.service = GameTelemetryUploadApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GameClientGameTelemetryUploadApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "GameClientGameTelemetryUploadApis", host = "{endpoint}")
    public interface GameTelemetryUploadApisService {
        static GameTelemetryUploadApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GameTelemetryUploadApisServiceImpl");
                return (GameTelemetryUploadApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(method = HttpMethod.POST, path = "/crash/dataUpload", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<UploadResponse> uploadCrash(@HostParam("endpoint") String endpoint,
            @HeaderParam("Authorization") String authorization, @HeaderParam("CONTENT-MD5") String contentMd5,
            @HeaderParam("DATE") String date, @HeaderParam("cms-signature") String cmsSignature,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") List<JsonObject> body, RequestContext requestContext);

        @HttpRequestInformation(method = HttpMethod.POST, path = "/sdk/dataUpload", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<UploadResponse> uploadSdk(@HostParam("endpoint") String endpoint,
            @HeaderParam("Authorization") String authorization, @HeaderParam("CONTENT-MD5") String contentMd5,
            @HeaderParam("DATE") String date, @HeaderParam("cms-signature") String cmsSignature,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") List<JsonObject> body, RequestContext requestContext);

        @HttpRequestInformation(method = HttpMethod.POST, path = "/ys_custom/dataUpload", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<UploadResponse> uploadCustom(@HostParam("endpoint") String endpoint,
            @HeaderParam("Authorization") String authorization, @HeaderParam("CONTENT-MD5") String contentMd5,
            @HeaderParam("DATE") String date, @HeaderParam("cms-signature") String cmsSignature,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") List<JsonObject> body, RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<UploadResponse> uploadCrashWithResponse(List<JsonObject> body, String authorization,
        String contentMd5, String date, String cmsSignature, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.Game.UploadApi.uploadCrash",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.uploadCrash(this.client.getEndpoint(), authorization, contentMd5, date, cmsSignature,
                    contentType, accept, body, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<UploadResponse> uploadSdkWithResponse(List<JsonObject> body, String authorization,
        String contentMd5, String date, String cmsSignature, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.Game.UploadApi.uploadSdk",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.uploadSdk(this.client.getEndpoint(), authorization, contentMd5, date, cmsSignature,
                    contentType, accept, body, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<UploadResponse> uploadCustomWithResponse(List<JsonObject> body, String authorization,
        String contentMd5, String date, String cmsSignature, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.Game.UploadApi.uploadCustom",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.uploadCustom(this.client.getEndpoint(), authorization, contentMd5, date, cmsSignature,
                    contentType, accept, body, updatedContext);
            });
    }
}
