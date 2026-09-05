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
import uigf.ApiResponseGameRoleList;
import uigf.ApiResponseJsonObject;
import uigf.checkin.implementation.GameBindingApisImpl;
import uigf.game.AuthKeyRequest;

/**
 * Initializes a new instance of the synchronous GameAccountClient type.
 */
@ServiceClient(builder = GameAccountClientBuilder.class)
public final class GameBindingApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GameBindingApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GameBindingApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GameBindingApiClient(GameBindingApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> generateAuthKeyWithResponse(String cookie, String ds, AuthKeyRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.BindingApi.generateAuthKey",
            requestContext,
            updatedContext -> this.serviceClient.generateAuthKeyWithResponse(cookie, ds, body, updatedContext));
    }

    /**
     * Generates an authenticated gacha authkey for a selected game role.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject generateAuthKey(String cookie, String ds, AuthKeyRequest body) {
        return generateAuthKeyWithResponse(cookie, ds, body, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGameRoleList> getRolesWithResponse(String cookie, String ds, String gameBiz,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.BindingApi.getRoles", requestContext,
            updatedContext -> this.serviceClient.getRolesWithResponse(cookie, ds, gameBiz, updatedContext));
    }

    /**
     * Lists game roles that are bound to the authenticated community account.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param gameBiz The gameBiz parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGameRoleList getRoles(String cookie, String ds, String gameBiz) {
        return getRolesWithResponse(cookie, ds, gameBiz, RequestContext.none()).getValue();
    }

    /**
     * Lists game roles that are bound to the authenticated community account.
     * 
     * @param cookie The cookie parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGameRoleList getRoles(String cookie) {
        final String ds = null;
        final String gameBiz = null;
        return getRolesWithResponse(cookie, ds, gameBiz, RequestContext.none()).getValue();
    }
}
