package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.QueryParam;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import uigf.ApiResponseCommunityUser;

/**
 * An instance of this class provides access to all the operations defined in CommunityUserApis.
 */
public final class CommunityUserApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final CommunityUserApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CommunityUserApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    CommunityUserApisImpl(CommunityClientImpl client) {
        this.service = CommunityUserApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityClientCommunityUserApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "CommunityClientCommunityUserApis", host = "{endpoint}")
    public interface CommunityUserApisService {
        static CommunityUserApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.CommunityUserApisServiceImpl");
                return (CommunityUserApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/user/wapi/getUserFullInfo",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseCommunityUser> getFullInfo(@HostParam("endpoint") String endpoint,
            @QueryParam("gids") String gids, @QueryParam("uid") String uid, @HeaderParam("Cookie") String cookie,
            @HeaderParam("DS") String ds, @HeaderParam("Accept") String accept, RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseCommunityUser> getFullInfoWithResponse(String gids, String uid, String cookie, String ds,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.UserApi.getFullInfo", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getFullInfo(this.client.getEndpoint(), gids, uid, cookie, ds, accept, updatedContext);
            });
    }
}
