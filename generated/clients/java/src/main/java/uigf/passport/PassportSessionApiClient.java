package uigf.passport;

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
import uigf.checkin.implementation.PassportSessionApisImpl;

/**
 * Initializes a new instance of the synchronous PassportClient type.
 */
@ServiceClient(builder = PassportClientBuilder.class)
public final class PassportSessionApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final PassportSessionApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of PassportSessionApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    PassportSessionApiClient(PassportSessionApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * Exchanges a game token for an SToken/session payload.
     * 
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> getTokenByGameTokenWithResponse(GameTokenRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.SessionApi.getTokenByGameToken",
            requestContext, updatedContext -> this.serviceClient.getTokenByGameTokenWithResponse(body, updatedContext));
    }

    /**
     * Exchanges a game token for an SToken/session payload.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseTokenInfo getTokenByGameToken(GameTokenRequest body) {
        return getTokenByGameTokenWithResponse(body, RequestContext.none()).getValue();
    }
}
