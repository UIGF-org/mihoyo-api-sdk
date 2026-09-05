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
import uigf.checkin.implementation.GenshinObcApisImpl;

/**
 * Initializes a new instance of the synchronous GameAccountClient type.
 */
@ServiceClient(builder = GameAccountClientBuilder.class)
public final class GenshinObcApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GenshinObcApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GenshinObcApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GenshinObcApiClient(GenshinObcApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getGachaPool operation.
     * 
     * @param appSn The appSn parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getGachaPoolWithResponse(String appSn, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.GenshinObcApi.getGachaPool",
            requestContext, updatedContext -> this.serviceClient.getGachaPoolWithResponse(appSn, updatedContext));
    }

    /**
     * The getGachaPool operation.
     * 
     * @param appSn The appSn parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGachaPool(String appSn) {
        return getGachaPoolWithResponse(appSn, RequestContext.none()).getValue();
    }

    /**
     * The getHomePositions operation.
     * 
     * @param appSn The appSn parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getHomePositionsWithResponse(String appSn, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.GenshinObcApi.getHomePositions",
            requestContext, updatedContext -> this.serviceClient.getHomePositionsWithResponse(appSn, updatedContext));
    }

    /**
     * The getHomePositions operation.
     * 
     * @param appSn The appSn parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getHomePositions(String appSn) {
        return getHomePositionsWithResponse(appSn, RequestContext.none()).getValue();
    }
}
