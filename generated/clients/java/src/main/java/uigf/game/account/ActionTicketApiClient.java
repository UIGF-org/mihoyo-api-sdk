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
import uigf.ApiResponseJsonObject;
import uigf.checkin.implementation.ActionTicketApisImpl;

/**
 * Initializes a new instance of the synchronous GameAccountClient type.
 */
@ServiceClient(builder = GameAccountClientBuilder.class)
public final class ActionTicketApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final ActionTicketApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ActionTicketApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    ActionTicketApiClient(ActionTicketApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getBySToken operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param actionType The actionType parameter.
     * @param stoken The stoken parameter.
     * @param uid The uid parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getBySTokenWithResponse(String cookie, String ds, String actionType,
        String stoken, String uid, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.ActionTicketApi.getBySToken",
            requestContext, updatedContext -> this.serviceClient.getBySTokenWithResponse(cookie, ds, actionType, stoken,
                uid, updatedContext));
    }

    /**
     * The getBySToken operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param actionType The actionType parameter.
     * @param stoken The stoken parameter.
     * @param uid The uid parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getBySToken(String cookie, String ds, String actionType, String stoken, String uid) {
        return getBySTokenWithResponse(cookie, ds, actionType, stoken, uid, RequestContext.none()).getValue();
    }
}
