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
import uigf.ApiResponseDeviceFingerprint;
import uigf.game.DeviceFingerprintRequest;

/**
 * An instance of this class provides access to all the operations defined in FingerprintApis.
 */
public final class FingerprintApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final FingerprintApisService service;

    /**
     * The service client containing this operation class.
     */
    private final DeviceClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of FingerprintApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    FingerprintApisImpl(DeviceClientImpl client) {
        this.service = FingerprintApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for DeviceClientFingerprintApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "DeviceClientFingerprintApis", host = "{endpoint}")
    public interface FingerprintApisService {
        static FingerprintApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.FingerprintApisServiceImpl");
                return (FingerprintApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(method = HttpMethod.POST, path = "/device-fp/api/getFp", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseDeviceFingerprint> getFingerprint(@HostParam("endpoint") String endpoint,
            @HeaderParam("x-rpc-app_version") String appVersion, @HeaderParam("x-rpc-client_type") String clientType,
            @HeaderParam("x-requested-with") String requestedWith, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") DeviceFingerprintRequest body,
            RequestContext requestContext);
    }

    /**
     * Registers a legitimate client device fingerprint and returns its `device_fp` value.
     * 
     * @param appVersion The appVersion parameter.
     * @param clientType The clientType parameter.
     * @param requestedWith The requestedWith parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseDeviceFingerprint> getFingerprintWithResponse(String appVersion, String clientType,
        String requestedWith, DeviceFingerprintRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Utility.Device.FingerprintApi.getFingerprint",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.getFingerprint(this.client.getEndpoint(), appVersion, clientType, requestedWith,
                    contentType, accept, body, updatedContext);
            });
    }
}
