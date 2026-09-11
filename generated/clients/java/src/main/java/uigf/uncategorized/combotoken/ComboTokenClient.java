package uigf.uncategorized.combotoken;

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
import uigf.checkin.implementation.ComboTokenApisImpl;
import uigf.uncategorized.ComboTokenRequest;

/**
 * Initializes a new instance of the synchronous ComboTokenClient type.
 */
@ServiceClient(builder = ComboTokenClientBuilder.class)
public final class ComboTokenClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final ComboTokenApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ComboTokenClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    ComboTokenClient(ComboTokenApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The exchange operation.
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
    public Response<ApiResponseJsonObject> exchangeWithResponse(ComboTokenRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.ComboToken.ComboTokenApi.exchange",
            requestContext, updatedContext -> this.serviceClient.exchangeWithResponse(body, updatedContext));
    }

    /**
     * The exchange operation.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject exchange(ComboTokenRequest body) {
        return exchangeWithResponse(body, RequestContext.none()).getValue();
    }
}
