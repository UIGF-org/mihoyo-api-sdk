package uigf.game.genshin.dispatch.gate;

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
import uigf.checkin.implementation.GateApisImpl;

/**
 * Initializes a new instance of the synchronous GateClient type.
 */
@ServiceClient(builder = GateClientBuilder.class)
public final class GateClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GateApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GateClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GateClient(GateApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getAddress operation.
     * 
     * @param game The game parameter.
     * @param region The region parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getAddressWithResponse(String game, String region,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Dispatch.Gate.GateApi.getAddress",
            requestContext, updatedContext -> this.serviceClient.getAddressWithResponse(game, region, updatedContext));
    }

    /**
     * The getAddress operation.
     * 
     * @param game The game parameter.
     * @param region The region parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getAddress(String game, String region) {
        return getAddressWithResponse(game, region, RequestContext.none()).getValue();
    }
}
