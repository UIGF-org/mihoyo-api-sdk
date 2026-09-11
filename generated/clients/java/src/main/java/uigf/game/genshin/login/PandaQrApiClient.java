package uigf.game.genshin.login;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponsePandaQrResponse;
import uigf.checkin.implementation.PandaQrApisImpl;
import uigf.game.PandaQrRequest;

/**
 * Initializes a new instance of the synchronous LoginClient type.
 */
@ServiceClient(builder = LoginClientBuilder.class)
public final class PandaQrApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final PandaQrApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of PandaQrApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    PandaQrApiClient(PandaQrApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The upstream endpoint is deprecated; use only where officially supported.
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
    public Response<ApiResponsePandaQrResponse> createWithResponse(PandaQrRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Login.PandaQrApi.create", requestContext,
            updatedContext -> this.serviceClient.createWithResponse(body, updatedContext));
    }

    /**
     * The upstream endpoint is deprecated; use only where officially supported.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePandaQrResponse create(PandaQrRequest body) {
        return createWithResponse(body, RequestContext.none()).getValue();
    }

    /**
     * The upstream endpoint is deprecated; use only where officially supported.
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
    public Response<ApiResponsePandaQrResponse> getStatusWithResponse(PandaQrRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Login.PandaQrApi.getStatus",
            requestContext, updatedContext -> this.serviceClient.getStatusWithResponse(body, updatedContext));
    }

    /**
     * The upstream endpoint is deprecated; use only where officially supported.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePandaQrResponse getStatus(PandaQrRequest body) {
        return getStatusWithResponse(body, RequestContext.none()).getValue();
    }
}
