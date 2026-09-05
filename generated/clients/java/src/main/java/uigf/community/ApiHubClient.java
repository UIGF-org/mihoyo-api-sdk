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
import uigf.ApiResponseForumList;
import uigf.ApiResponseJsonObject;
import uigf.checkin.implementation.ApiHubsImpl;

/**
 * Initializes a new instance of the synchronous CommunityClient type.
 */
@ServiceClient(builder = CommunityClientBuilder.class)
public final class ApiHubClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final ApiHubsImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ApiHubClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    ApiHubClient(ApiHubsImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseForumList> getAllGamesForumsWithResponse(RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getAllGamesForums", requestContext,
            updatedContext -> this.serviceClient.getAllGamesForumsWithResponse(updatedContext));
    }

    /**
     * The getAllGamesForums operation.
     * 
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseForumList getAllGamesForums() {
        return getAllGamesForumsWithResponse(RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getAppConfigWithResponse(String gid, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getAppConfig", requestContext,
            updatedContext -> this.serviceClient.getAppConfigWithResponse(gid, updatedContext));
    }

    /**
     * The getAppConfig operation.
     * 
     * @param gid The gid parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getAppConfig(String gid) {
        return getAppConfigWithResponse(gid, RequestContext.none()).getValue();
    }

    /**
     * The getAppConfig operation.
     * 
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getAppConfig() {
        final String gid = null;
        return getAppConfigWithResponse(gid, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseForumList> getGameListWithResponse(RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getGameList", requestContext,
            updatedContext -> this.serviceClient.getGameListWithResponse(updatedContext));
    }

    /**
     * The getGameList operation.
     * 
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseForumList getGameList() {
        return getGameListWithResponse(RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMissionsWithResponse(String cookie, String ds, String pointSn,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getMissions", requestContext,
            updatedContext -> this.serviceClient.getMissionsWithResponse(cookie, ds, pointSn, updatedContext));
    }

    /**
     * The getMissions operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param pointSn The pointSn parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMissions(String cookie, String ds, String pointSn) {
        return getMissionsWithResponse(cookie, ds, pointSn, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getShareConfigWithResponse(String cookie, String ds, String entityId,
        int entityType, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getShareConfig", requestContext,
            updatedContext -> this.serviceClient.getShareConfigWithResponse(cookie, ds, entityId, entityType,
                updatedContext));
    }

    /**
     * The getShareConfig operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param entityId The entityId parameter.
     * @param entityType The entityType parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getShareConfig(String cookie, String ds, String entityId, int entityType) {
        return getShareConfigWithResponse(cookie, ds, entityId, entityType, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMissionStateWithResponse(String cookie, String ds, String pointSn,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getMissionState", requestContext,
            updatedContext -> this.serviceClient.getMissionStateWithResponse(cookie, ds, pointSn, updatedContext));
    }

    /**
     * The getMissionState operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param pointSn The pointSn parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMissionState(String cookie, String ds, String pointSn) {
        return getMissionStateWithResponse(cookie, ds, pointSn, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getVotesWithResponse(String ownerUid, String voteIds,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getVotes", requestContext,
            updatedContext -> this.serviceClient.getVotesWithResponse(ownerUid, voteIds, updatedContext));
    }

    /**
     * The getVotes operation.
     * 
     * @param ownerUid The ownerUid parameter.
     * @param voteIds The voteIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getVotes(String ownerUid, String voteIds) {
        return getVotesWithResponse(ownerUid, voteIds, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getVoteResultsWithResponse(String ownerUid, String voteIds,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getVoteResults", requestContext,
            updatedContext -> this.serviceClient.getVoteResultsWithResponse(ownerUid, voteIds, updatedContext));
    }

    /**
     * The getVoteResults operation.
     * 
     * @param ownerUid The ownerUid parameter.
     * @param voteIds The voteIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getVoteResults(String ownerUid, String voteIds) {
        return getVoteResultsWithResponse(ownerUid, voteIds, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getHomeWithResponse(int gids, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.getHome", requestContext,
            updatedContext -> this.serviceClient.getHomeWithResponse(gids, updatedContext));
    }

    /**
     * The getHome operation.
     * 
     * @param gids The gids parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getHome(int gids) {
        return getHomeWithResponse(gids, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> signInWithResponse(String cookie, String ds, SignInRequest body,
        String challenge, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.signIn", requestContext,
            updatedContext -> this.serviceClient.signInWithResponse(cookie, ds, body, challenge, updatedContext));
    }

    /**
     * The signIn operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @param challenge The challenge parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject signIn(String cookie, String ds, SignInRequest body, String challenge) {
        return signInWithResponse(cookie, ds, body, challenge, RequestContext.none()).getValue();
    }

    /**
     * The signIn operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject signIn(String cookie, String ds, SignInRequest body) {
        final String challenge = null;
        return signInWithResponse(cookie, ds, body, challenge, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> setPostVoteWithResponse(String cookie, String ds, LikePostRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.ApiHub.setPostVote", requestContext,
            updatedContext -> this.serviceClient.setPostVoteWithResponse(cookie, ds, body, updatedContext));
    }

    /**
     * The setPostVote operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject setPostVote(String cookie, String ds, LikePostRequest body) {
        return setPostVoteWithResponse(cookie, ds, body, RequestContext.none()).getValue();
    }
}
