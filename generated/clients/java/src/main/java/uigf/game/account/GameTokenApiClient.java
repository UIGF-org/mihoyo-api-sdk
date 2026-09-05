package uigf.game.account;

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
import uigf.checkin.implementation.GameTokenApisImpl;
import uigf.passport.GameTokenRequest;

/**
 * Initializes a new instance of the synchronous GameAccountClient type.
 */
@ServiceClient(builder = GameAccountClientBuilder.class)
public final class GameTokenApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GameTokenApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GameTokenApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GameTokenApiClient(GameTokenApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * Exchanges the official game-token QR-login result for a session token.
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
    public Response<ApiResponseTokenInfo> exchangeGameTokenWithResponse(GameTokenRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.GameTokenApi.exchangeGameToken",
            requestContext, updatedContext -> this.serviceClient.exchangeGameTokenWithResponse(body, updatedContext));
    }

    /**
     * Exchanges the official game-token QR-login result for a session token.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseTokenInfo exchangeGameToken(GameTokenRequest body) {
        return exchangeGameTokenWithResponse(body, RequestContext.none()).getValue();
    }
}
