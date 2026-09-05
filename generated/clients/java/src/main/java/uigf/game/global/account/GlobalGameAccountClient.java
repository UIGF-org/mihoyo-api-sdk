package uigf.game.global.account;

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
import uigf.checkin.implementation.GlobalBindingApisImpl;

/**
 * Initializes a new instance of the synchronous GlobalGameAccountClient type.
 */
@ServiceClient(builder = GlobalGameAccountClientBuilder.class)
public final class GlobalGameAccountClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GlobalBindingApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalGameAccountClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GlobalGameAccountClient(GlobalBindingApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getRoles operation.
     * 
     * @param cookie The cookie parameter.
     * @param gameBiz The gameBiz parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGameRoleList> getRolesWithResponse(String cookie, String gameBiz,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Account.BindingApi.getRoles",
            requestContext, updatedContext -> this.serviceClient.getRolesWithResponse(cookie, gameBiz, updatedContext));
    }

    /**
     * The getRoles operation.
     * 
     * @param cookie The cookie parameter.
     * @param gameBiz The gameBiz parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseGameRoleList getRoles(String cookie, String gameBiz) {
        return getRolesWithResponse(cookie, gameBiz, RequestContext.none()).getValue();
    }
}
