package uigf.utility.device;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponseDeviceFingerprint;
import uigf.checkin.implementation.FingerprintApisImpl;
import uigf.game.DeviceFingerprintRequest;

/**
 * Initializes a new instance of the synchronous DeviceClient type.
 */
@ServiceClient(builder = DeviceClientBuilder.class)
public final class DeviceClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final FingerprintApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of DeviceClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    DeviceClient(FingerprintApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseDeviceFingerprint> getFingerprintWithResponse(String appVersion, String clientType,
        String requestedWith, DeviceFingerprintRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Utility.Device.FingerprintApi.getFingerprint",
            requestContext, updatedContext -> this.serviceClient.getFingerprintWithResponse(appVersion, clientType,
                requestedWith, body, updatedContext));
    }

    /**
     * Registers a legitimate client device fingerprint and returns its `device_fp` value.
     * 
     * @param appVersion The appVersion parameter.
     * @param clientType The clientType parameter.
     * @param requestedWith The requestedWith parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseDeviceFingerprint getFingerprint(String appVersion, String clientType, String requestedWith,
        DeviceFingerprintRequest body) {
        return getFingerprintWithResponse(appVersion, clientType, requestedWith, body, RequestContext.none())
            .getValue();
    }
}
