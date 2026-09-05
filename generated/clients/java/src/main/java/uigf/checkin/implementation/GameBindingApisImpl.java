package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.QueryParam;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import uigf.ApiResponseGameRoleList;
import uigf.ApiResponseJsonObject;
import uigf.game.AuthKeyRequest;

/**
 * An instance of this class provides access to all the operations defined in GameBindingApis.
 */
public final class GameBindingApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GameBindingApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GameAccountClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GameBindingApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GameBindingApisImpl(GameAccountClientImpl client) {
        this.service = GameBindingApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GameAccountClientGameBindingApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "GameAccountClientGameBindingApis", host = "{endpoint}")
    public interface GameBindingApisService {
        static GameBindingApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GameBindingApisServiceImpl");
                return (GameBindingApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/binding/api/genAuthKey",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> generateAuthKey(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") AuthKeyRequest body, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/binding/api/getUserGameRolesByCookie",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseGameRoleList> getRoles(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("game_biz") String gameBiz,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * Generates an authenticated gacha authkey for a selected game role.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> generateAuthKeyWithResponse(String cookie, String ds, AuthKeyRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.BindingApi.generateAuthKey",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.generateAuthKey(this.client.getEndpoint(), cookie, ds, contentType, accept, body,
                    updatedContext);
            });
    }

    /**
     * Lists game roles that are bound to the authenticated community account.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param gameBiz The gameBiz parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGameRoleList> getRolesWithResponse(String cookie, String ds, String gameBiz,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.BindingApi.getRoles", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getRoles(this.client.getEndpoint(), cookie, ds, gameBiz, accept, updatedContext);
            });
    }
}
