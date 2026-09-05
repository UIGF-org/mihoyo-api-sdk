package uigf.community;

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
import uigf.checkin.implementation.MiscApisImpl;

/**
 * Initializes a new instance of the synchronous CommunityClient type.
 */
@ServiceClient(builder = CommunityClientBuilder.class)
public final class MiscApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final MiscApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of MiscApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    MiscApiClient(MiscApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getEmoticonSet operation.
     * 
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getEmoticonSetWithResponse(RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.MiscApi.getEmoticonSet", requestContext,
            updatedContext -> this.serviceClient.getEmoticonSetWithResponse(updatedContext));
    }

    /**
     * The getEmoticonSet operation.
     * 
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getEmoticonSet() {
        return getEmoticonSetWithResponse(RequestContext.none()).getValue();
    }

    /**
     * Creates the official verification challenge required by selected operations.
     * 
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> createVerificationWithResponse(String cookie, VerificationCreateRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.MiscApi.createVerification", requestContext,
            updatedContext -> this.serviceClient.createVerificationWithResponse(cookie, body, updatedContext));
    }

    /**
     * Creates the official verification challenge required by selected operations.
     * 
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject createVerification(String cookie, VerificationCreateRequest body) {
        return createVerificationWithResponse(cookie, body, RequestContext.none()).getValue();
    }

    /**
     * Submits verification output obtained from the official challenge provider.
     * 
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> verifyVerificationWithResponse(String cookie, VerificationSubmitRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.MiscApi.verifyVerification", requestContext,
            updatedContext -> this.serviceClient.verifyVerificationWithResponse(cookie, body, updatedContext));
    }

    /**
     * Submits verification output obtained from the official challenge provider.
     * 
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject verifyVerification(String cookie, VerificationSubmitRequest body) {
        return verifyVerificationWithResponse(cookie, body, RequestContext.none()).getValue();
    }

    /**
     * The getGeetestChallenge operation.
     * 
     * @param cookie The cookie parameter.
     * @param actionType The actionType parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getGeetestChallengeWithResponse(String cookie, String actionType,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.MiscApi.getGeetestChallenge", requestContext,
            updatedContext -> this.serviceClient.getGeetestChallengeWithResponse(cookie, actionType, updatedContext));
    }

    /**
     * The getGeetestChallenge operation.
     * 
     * @param cookie The cookie parameter.
     * @param actionType The actionType parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGeetestChallenge(String cookie, String actionType) {
        return getGeetestChallengeWithResponse(cookie, actionType, RequestContext.none()).getValue();
    }

    /**
     * The getGeetestChallenge operation.
     * 
     * @param cookie The cookie parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGeetestChallenge(String cookie) {
        final String actionType = null;
        return getGeetestChallengeWithResponse(cookie, actionType, RequestContext.none()).getValue();
    }
}
