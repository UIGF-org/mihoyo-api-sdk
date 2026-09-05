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
import uigf.ApiResponseTokenInfo;
import uigf.passport.GameTokenRequest;

/**
 * An instance of this class provides access to all the operations defined in GameTokenApis.
 */
public final class GameTokenApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GameTokenApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GameAccountClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GameTokenApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GameTokenApisImpl(GameAccountClientImpl client) {
        this.service = GameTokenApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GameAccountClientGameTokenApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "GameAccountClientGameTokenApis", host = "{endpoint}")
    public interface GameTokenApisService {
        static GameTokenApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GameTokenApisServiceImpl");
                return (GameTokenApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/account/ma-cn-session/app/getTokenByGameToken",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseTokenInfo> exchangeGameToken(@HostParam("endpoint") String endpoint,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") GameTokenRequest body, RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> exchangeGameTokenWithResponse(GameTokenRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.GameTokenApi.exchangeGameToken",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.exchangeGameToken(this.client.getEndpoint(), contentType, accept, body, updatedContext);
            });
    }
}
