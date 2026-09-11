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
 * An instance of this class provides access to all the operations defined in SdkTelemetryUploadApis.
 */
public final class SdkTelemetryUploadApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final SdkTelemetryUploadApisService service;

    /**
     * The service client containing this operation class.
     */
    private final SDKClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of SdkTelemetryUploadApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    SdkTelemetryUploadApisImpl(SDKClientImpl client) {
        this.service = SdkTelemetryUploadApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for SDKClientSdkTelemetryUploadApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "SDKClientSdkTelemetryUploadApis", host = "{endpoint}")
    public interface SdkTelemetryUploadApisService {
        static SdkTelemetryUploadApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.SdkTelemetryUploadApisServiceImpl");
                return (SdkTelemetryUploadApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(method = HttpMethod.POST, path = "/sdk/dataUpload", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<UploadResponse> upload(@HostParam("endpoint") String endpoint,
            @HeaderParam("Authorization") String authorization, @HeaderParam("CONTENT-MD5") String contentMd5,
            @HeaderParam("DATE") String date, @HeaderParam("cms-signature") String cmsSignature,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") List<JsonObject> body, RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<UploadResponse> uploadWithResponse(List<JsonObject> body, String authorization, String contentMd5,
        String date, String cmsSignature, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.Telemetry.SDK.UploadApi.upload",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.upload(this.client.getEndpoint(), authorization, contentMd5, date, cmsSignature,
                    contentType, accept, body, updatedContext);
            });
    }
}
