package uigf.uncategorized.ugc;

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
import uigf.checkin.implementation.TokenApisImpl;

/**
 * Initializes a new instance of the synchronous UGCClient type.
 */
@ServiceClient(builder = UGCClientBuilder.class)
public final class TokenApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final TokenApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of TokenApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    TokenApiClient(TokenApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The get operation.
     * 
     * @param authkey The authkey parameter.
     * @param authAppid The authAppid parameter.
     * @param lang The lang parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getWithResponse(String authkey, String authAppid, String lang,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.UGC.TokenApi.get", requestContext,
            updatedContext -> this.serviceClient.getWithResponse(authkey, authAppid, lang, updatedContext));
    }

    /**
     * The get operation.
     * 
     * @param authkey The authkey parameter.
     * @param authAppid The authAppid parameter.
     * @param lang The lang parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject get(String authkey, String authAppid, String lang) {
        return getWithResponse(authkey, authAppid, lang, RequestContext.none()).getValue();
    }
}
