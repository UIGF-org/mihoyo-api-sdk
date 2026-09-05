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
import uigf.ApiResponseCommunityUser;
import uigf.checkin.implementation.CommunityUserApisImpl;

/**
 * Initializes a new instance of the synchronous CommunityClient type.
 */
@ServiceClient(builder = CommunityClientBuilder.class)
public final class CommunityUserApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final CommunityUserApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CommunityUserApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    CommunityUserApiClient(CommunityUserApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * Gets the authenticated or public MiYouShe user profile.
     * 
     * @param gids The gids parameter.
     * @param uid The uid parameter.
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the authenticated or public MiYouShe user profile along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseCommunityUser> getFullInfoWithResponse(String gids, String uid, String cookie, String ds,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.UserApi.getFullInfo", requestContext,
            updatedContext -> this.serviceClient.getFullInfoWithResponse(gids, uid, cookie, ds, updatedContext));
    }

    /**
     * Gets the authenticated or public MiYouShe user profile.
     * 
     * @param gids The gids parameter.
     * @param uid The uid parameter.
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the authenticated or public MiYouShe user profile.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseCommunityUser getFullInfo(String gids, String uid, String cookie, String ds) {
        return getFullInfoWithResponse(gids, uid, cookie, ds, RequestContext.none()).getValue();
    }

    /**
     * Gets the authenticated or public MiYouShe user profile.
     * 
     * @param gids The gids parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the authenticated or public MiYouShe user profile.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseCommunityUser getFullInfo(String gids) {
        final String uid = null;
        final String cookie = null;
        final String ds = null;
        return getFullInfoWithResponse(gids, uid, cookie, ds, RequestContext.none()).getValue();
    }
}
