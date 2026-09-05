package uigf.passportv4;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponseTokenInfo;
import uigf.JsonObject;
import uigf.checkin.implementation.PassportV4SessionApisImpl;

/**
 * Initializes a new instance of the synchronous PassportV4Client type.
 */
@ServiceClient(builder = PassportV4ClientBuilder.class)
public final class PassportV4Client {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final PassportV4SessionApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of PassportV4Client class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    PassportV4Client(PassportV4SessionApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The verifyLToken operation.
     * 
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> verifyLTokenWithResponse(String cookie, JsonObject body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.PassportV4.SessionApi.verifyLToken", requestContext,
            updatedContext -> this.serviceClient.verifyLTokenWithResponse(cookie, body, updatedContext));
    }

    /**
     * The verifyLToken operation.
     * 
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseTokenInfo verifyLToken(String cookie, JsonObject body) {
        return verifyLTokenWithResponse(cookie, body, RequestContext.none()).getValue();
    }
}
