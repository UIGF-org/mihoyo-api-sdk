package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
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
import uigf.ApiResponseForumList;
import uigf.ApiResponseJsonObject;
import uigf.community.LikePostRequest;
import uigf.community.SignInRequest;

/**
 * An instance of this class provides access to all the operations defined in ApiHubs.
 */
public final class ApiHubsImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ApiHubsService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ApiHubsImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ApiHubsImpl(CommunityClientImpl client) {
        this.service = ApiHubsService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityClientApiHubs to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "CommunityClientApiHubs", host = "{endpoint}")
    public interface ApiHubsService {
        static ApiHubsService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.ApiHubsServiceImpl");
                return (ApiHubsService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/apihub/wapi/getAllGamesForums",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseForumList> getAllGamesForums(@HostParam("endpoint") String endpoint,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/apihub/api/getAppConfig",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getAppConfig(@HostParam("endpoint") String endpoint,
            @QueryParam("gid") String gid, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/apihub/wapi/getGameList",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseForumList> getGameList(@HostParam("endpoint") String endpoint,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/apihub/wapi/getMissions",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getMissions(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("point_sn") String pointSn,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/apihub/api/getShareConf",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getShareConfig(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @QueryParam("entity_id") String entityId, @QueryParam("entity_type") int entityType,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/apihub/wapi/getUserMissionsState",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getMissionState(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("point_sn") String pointSn,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(method = HttpMethod.GET, path = "/apihub/api/getVotes", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getVotes(@HostParam("endpoint") String endpoint,
            @QueryParam("owner_uid") String ownerUid, @QueryParam("vote_ids") String voteIds,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/apihub/api/getVotesResult",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getVoteResults(@HostParam("endpoint") String endpoint,
            @QueryParam("owner_uid") String ownerUid, @QueryParam("vote_ids") String voteIds,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(method = HttpMethod.GET, path = "/apihub/api/home/new", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getHome(@HostParam("endpoint") String endpoint, @QueryParam("gids") int gids,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/apihub/app/api/signIn",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> signIn(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @HeaderParam("x-rpc-challenge") String challenge, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") SignInRequest body,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/apihub/api/upvotePost",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> setPostVote(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") LikePostRequest body, RequestContext requestContext);
    }

    /**
     * The getAllGamesForums operation.
     * 
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseForumList> getAllGamesForumsWithResponse(RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getAllGamesForums", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getAllGamesForums(this.client.getEndpoint(), accept, updatedContext);
            });
    }

    /**
     * The getAppConfig operation.
     * 
     * @param gid The gid parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getAppConfigWithResponse(String gid, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getAppConfig", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getAppConfig(this.client.getEndpoint(), gid, accept, updatedContext);
            });
    }

    /**
     * The getGameList operation.
     * 
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseForumList> getGameListWithResponse(RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getGameList", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getGameList(this.client.getEndpoint(), accept, updatedContext);
            });
    }

    /**
     * The getMissions operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param pointSn The pointSn parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMissionsWithResponse(String cookie, String ds, String pointSn,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getMissions", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getMissions(this.client.getEndpoint(), cookie, ds, pointSn, accept, updatedContext);
            });
    }

    /**
     * The getShareConfig operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param entityId The entityId parameter.
     * @param entityType The entityType parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getShareConfigWithResponse(String cookie, String ds, String entityId,
        int entityType, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getShareConfig", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getShareConfig(this.client.getEndpoint(), cookie, ds, entityId, entityType, accept,
                    updatedContext);
            });
    }

    /**
     * The getMissionState operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param pointSn The pointSn parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMissionStateWithResponse(String cookie, String ds, String pointSn,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getMissionState", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getMissionState(this.client.getEndpoint(), cookie, ds, pointSn, accept, updatedContext);
            });
    }

    /**
     * The getVotes operation.
     * 
     * @param ownerUid The ownerUid parameter.
     * @param voteIds The voteIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getVotesWithResponse(String ownerUid, String voteIds,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getVotes", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getVotes(this.client.getEndpoint(), ownerUid, voteIds, accept, updatedContext);
            });
    }

    /**
     * The getVoteResults operation.
     * 
     * @param ownerUid The ownerUid parameter.
     * @param voteIds The voteIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getVoteResultsWithResponse(String ownerUid, String voteIds,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getVoteResults", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getVoteResults(this.client.getEndpoint(), ownerUid, voteIds, accept, updatedContext);
            });
    }

    /**
     * The getHome operation.
     * 
     * @param gids The gids parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getHomeWithResponse(int gids, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getHome", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getHome(this.client.getEndpoint(), gids, accept, updatedContext);
            });
    }

    /**
     * The signIn operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @param challenge The challenge parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> signInWithResponse(String cookie, String ds, SignInRequest body,
        String challenge, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.signIn", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.signIn(this.client.getEndpoint(), cookie, ds, challenge, contentType, accept, body,
                    updatedContext);
            });
    }

    /**
     * The setPostVote operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> setPostVoteWithResponse(String cookie, String ds, LikePostRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.setPostVote", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.setPostVote(this.client.getEndpoint(), cookie, ds, contentType, accept, body,
                    updatedContext);
            });
    }
}
