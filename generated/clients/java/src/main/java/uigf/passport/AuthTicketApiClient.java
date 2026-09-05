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
import uigf.checkin.implementation.AuthTicketApisImpl;

/**
 * Initializes a new instance of the synchronous PassportClient type.
 */
@ServiceClient(builder = PassportClientBuilder.class)
public final class AuthTicketApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final AuthTicketApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of AuthTicketApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    AuthTicketApiClient(AuthTicketApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * Creates an action ticket for a game-biz authentication flow.
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
    public Response<ApiResponseTokenInfo> createByGameBizWithResponse(AuthTicketRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.AuthTicketApi.createByGameBiz",
            requestContext, updatedContext -> this.serviceClient.createByGameBizWithResponse(body, updatedContext));
    }

    /**
     * Creates an action ticket for a game-biz authentication flow.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseTokenInfo createByGameBiz(AuthTicketRequest body) {
        return createByGameBizWithResponse(body, RequestContext.none()).getValue();
    }
}
