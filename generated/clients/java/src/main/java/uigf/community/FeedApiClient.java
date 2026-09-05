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
import uigf.ApiResponsePostList;
import uigf.checkin.implementation.FeedApisImpl;

/**
 * Initializes a new instance of the synchronous CommunityClient type.
 */
@ServiceClient(builder = CommunityClientBuilder.class)
public final class FeedApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final FeedApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of FeedApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    FeedApiClient(FeedApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getNews operation.
     * 
     * @param gids The gids parameter.
     * @param offset The offset parameter.
     * @param size The size parameter.
     * @param lastId The lastId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getNewsWithResponse(String gids, Integer offset, Integer size, String lastId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getNews", requestContext,
            updatedContext -> this.serviceClient.getNewsWithResponse(gids, offset, size, lastId, updatedContext));
    }

    /**
     * The getNews operation.
     * 
     * @param gids The gids parameter.
     * @param offset The offset parameter.
     * @param size The size parameter.
     * @param lastId The lastId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getNews(String gids, Integer offset, Integer size, String lastId) {
        return getNewsWithResponse(gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getNews operation.
     * 
     * @param gids The gids parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getNews(String gids) {
        final Integer offset = null;
        final Integer size = null;
        final String lastId = null;
        return getNewsWithResponse(gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getHotForumPosts operation.
     * 
     * @param gids The gids parameter.
     * @param offset The offset parameter.
     * @param size The size parameter.
     * @param lastId The lastId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getHotForumPostsWithResponse(String gids, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getHotForumPosts", requestContext,
            updatedContext -> this.serviceClient.getHotForumPostsWithResponse(gids, offset, size, lastId,
                updatedContext));
    }

    /**
     * The getHotForumPosts operation.
     * 
     * @param gids The gids parameter.
     * @param offset The offset parameter.
     * @param size The size parameter.
     * @param lastId The lastId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getHotForumPosts(String gids, Integer offset, Integer size, String lastId) {
        return getHotForumPostsWithResponse(gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getHotForumPosts operation.
     * 
     * @param gids The gids parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getHotForumPosts(String gids) {
        final Integer offset = null;
        final Integer size = null;
        final String lastId = null;
        return getHotForumPostsWithResponse(gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getRecentForumPosts operation.
     * 
     * @param gids The gids parameter.
     * @param offset The offset parameter.
     * @param size The size parameter.
     * @param lastId The lastId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getRecentForumPostsWithResponse(String gids, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getRecentForumPosts", requestContext,
            updatedContext -> this.serviceClient.getRecentForumPostsWithResponse(gids, offset, size, lastId,
                updatedContext));
    }

    /**
     * The getRecentForumPosts operation.
     * 
     * @param gids The gids parameter.
     * @param offset The offset parameter.
     * @param size The size parameter.
     * @param lastId The lastId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getRecentForumPosts(String gids, Integer offset, Integer size, String lastId) {
        return getRecentForumPostsWithResponse(gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getRecentForumPosts operation.
     * 
     * @param gids The gids parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getRecentForumPosts(String gids) {
        final Integer offset = null;
        final Integer size = null;
        final String lastId = null;
        return getRecentForumPostsWithResponse(gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getTimeline operation.
     * 
     * @param gids The gids parameter.
     * @param offset The offset parameter.
     * @param size The size parameter.
     * @param lastId The lastId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getTimelineWithResponse(String gids, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getTimeline", requestContext,
            updatedContext -> this.serviceClient.getTimelineWithResponse(gids, offset, size, lastId, updatedContext));
    }

    /**
     * The getTimeline operation.
     * 
     * @param gids The gids parameter.
     * @param offset The offset parameter.
     * @param size The size parameter.
     * @param lastId The lastId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getTimeline(String gids, Integer offset, Integer size, String lastId) {
        return getTimelineWithResponse(gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getTimeline operation.
     * 
     * @param gids The gids parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getTimeline(String gids) {
        final Integer offset = null;
        final Integer size = null;
        final String lastId = null;
        return getTimelineWithResponse(gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getLotteryUserShow operation.
     * 
     * @param lotteryId The lotteryId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getLotteryUserShowWithResponse(String lotteryId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getLotteryUserShow", requestContext,
            updatedContext -> this.serviceClient.getLotteryUserShowWithResponse(lotteryId, updatedContext));
    }

    /**
     * The getLotteryUserShow operation.
     * 
     * @param lotteryId The lotteryId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getLotteryUserShow(String lotteryId) {
        return getLotteryUserShowWithResponse(lotteryId, RequestContext.none()).getValue();
    }
}
