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
import uigf.ApiResponsePost;
import uigf.ApiResponsePostList;
import uigf.checkin.implementation.PostApisImpl;

/**
 * Initializes a new instance of the synchronous CommunityClient type.
 */
@ServiceClient(builder = CommunityClientBuilder.class)
public final class PostApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final PostApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of PostApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    PostApiClient(PostApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getFull operation.
     * 
     * @param postId The postId parameter.
     * @param cookie The cookie parameter.
     * @param gids The gids parameter.
     * @param read The read parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePost> getFullWithResponse(String postId, String cookie, String gids, Integer read,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getFull", requestContext,
            updatedContext -> this.serviceClient.getFullWithResponse(postId, cookie, gids, read, updatedContext));
    }

    /**
     * The getFull operation.
     * 
     * @param postId The postId parameter.
     * @param cookie The cookie parameter.
     * @param gids The gids parameter.
     * @param read The read parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePost getFull(String postId, String cookie, String gids, Integer read) {
        return getFullWithResponse(postId, cookie, gids, read, RequestContext.none()).getValue();
    }

    /**
     * The getFull operation.
     * 
     * @param postId The postId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePost getFull(String postId) {
        final String cookie = null;
        final String gids = null;
        final Integer read = null;
        return getFullWithResponse(postId, cookie, gids, read, RequestContext.none()).getValue();
    }

    /**
     * The getFullInCollection operation.
     * 
     * @param collectionId The collectionId parameter.
     * @param postId The postId parameter.
     * @param gids The gids parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePost> getFullInCollectionWithResponse(String collectionId, String postId, String gids,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getFullInCollection", requestContext,
            updatedContext -> this.serviceClient.getFullInCollectionWithResponse(collectionId, postId, gids,
                updatedContext));
    }

    /**
     * The getFullInCollection operation.
     * 
     * @param collectionId The collectionId parameter.
     * @param postId The postId parameter.
     * @param gids The gids parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePost getFullInCollection(String collectionId, String postId, String gids) {
        return getFullInCollectionWithResponse(collectionId, postId, gids, RequestContext.none()).getValue();
    }

    /**
     * The getReplies operation.
     * 
     * @param postId The postId parameter.
     * @param lastId The lastId parameter.
     * @param size The size parameter.
     * @param gids The gids parameter.
     * @param read The read parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getRepliesWithResponse(String postId, String lastId, Integer size, String gids,
        Integer read, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getReplies", requestContext,
            updatedContext -> this.serviceClient.getRepliesWithResponse(postId, lastId, size, gids, read,
                updatedContext));
    }

    /**
     * The getReplies operation.
     * 
     * @param postId The postId parameter.
     * @param lastId The lastId parameter.
     * @param size The size parameter.
     * @param gids The gids parameter.
     * @param read The read parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getReplies(String postId, String lastId, Integer size, String gids, Integer read) {
        return getRepliesWithResponse(postId, lastId, size, gids, read, RequestContext.none()).getValue();
    }

    /**
     * The getReplies operation.
     * 
     * @param postId The postId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getReplies(String postId) {
        final String lastId = null;
        final Integer size = null;
        final String gids = null;
        final Integer read = null;
        return getRepliesWithResponse(postId, lastId, size, gids, read, RequestContext.none()).getValue();
    }

    /**
     * The getSubReplies operation.
     * 
     * @param postId The postId parameter.
     * @param replyId The replyId parameter.
     * @param lastId The lastId parameter.
     * @param size The size parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getSubRepliesWithResponse(String postId, String replyId, String lastId,
        Integer size, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getSubReplies", requestContext,
            updatedContext -> this.serviceClient.getSubRepliesWithResponse(postId, replyId, lastId, size,
                updatedContext));
    }

    /**
     * The getSubReplies operation.
     * 
     * @param postId The postId parameter.
     * @param replyId The replyId parameter.
     * @param lastId The lastId parameter.
     * @param size The size parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getSubReplies(String postId, String replyId, String lastId, Integer size) {
        return getSubRepliesWithResponse(postId, replyId, lastId, size, RequestContext.none()).getValue();
    }

    /**
     * The getSubReplies operation.
     * 
     * @param postId The postId parameter.
     * @param replyId The replyId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getSubReplies(String postId, String replyId) {
        final String lastId = null;
        final Integer size = null;
        return getSubRepliesWithResponse(postId, replyId, lastId, size, RequestContext.none()).getValue();
    }

    /**
     * The getTopicPosts operation.
     * 
     * @param gids The gids parameter.
     * @param topicId The topicId parameter.
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
    public Response<ApiResponsePostList> getTopicPostsWithResponse(String gids, String topicId, Integer offset,
        Integer size, String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getTopicPosts", requestContext,
            updatedContext -> this.serviceClient.getTopicPostsWithResponse(gids, topicId, offset, size, lastId,
                updatedContext));
    }

    /**
     * The getTopicPosts operation.
     * 
     * @param gids The gids parameter.
     * @param topicId The topicId parameter.
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
    public ApiResponsePostList getTopicPosts(String gids, String topicId, Integer offset, Integer size, String lastId) {
        return getTopicPostsWithResponse(gids, topicId, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getTopicPosts operation.
     * 
     * @param gids The gids parameter.
     * @param topicId The topicId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getTopicPosts(String gids, String topicId) {
        final Integer offset = null;
        final Integer size = null;
        final String lastId = null;
        return getTopicPostsWithResponse(gids, topicId, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getUserPosts operation.
     * 
     * @param uid The uid parameter.
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
    public Response<ApiResponsePostList> getUserPostsWithResponse(String uid, String gids, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getUserPosts", requestContext,
            updatedContext -> this.serviceClient.getUserPostsWithResponse(uid, gids, offset, size, lastId,
                updatedContext));
    }

    /**
     * The getUserPosts operation.
     * 
     * @param uid The uid parameter.
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
    public ApiResponsePostList getUserPosts(String uid, String gids, Integer offset, Integer size, String lastId) {
        return getUserPostsWithResponse(uid, gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The getUserPosts operation.
     * 
     * @param uid The uid parameter.
     * @param gids The gids parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList getUserPosts(String uid, String gids) {
        final Integer offset = null;
        final Integer size = null;
        final String lastId = null;
        return getUserPostsWithResponse(uid, gids, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The search operation.
     * 
     * @param gids The gids parameter.
     * @param keyword The keyword parameter.
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
    public Response<ApiResponsePostList> searchWithResponse(String gids, String keyword, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.search", requestContext,
            updatedContext -> this.serviceClient.searchWithResponse(gids, keyword, offset, size, lastId,
                updatedContext));
    }

    /**
     * The search operation.
     * 
     * @param gids The gids parameter.
     * @param keyword The keyword parameter.
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
    public ApiResponsePostList search(String gids, String keyword, Integer offset, Integer size, String lastId) {
        return searchWithResponse(gids, keyword, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The search operation.
     * 
     * @param gids The gids parameter.
     * @param keyword The keyword parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponsePostList search(String gids, String keyword) {
        final Integer offset = null;
        final Integer size = null;
        final String lastId = null;
        return searchWithResponse(gids, keyword, offset, size, lastId, RequestContext.none()).getValue();
    }

    /**
     * The setFavorite operation.
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
    public Response<ApiResponseJsonObject> setFavoriteWithResponse(String cookie, String ds, FavoritePostRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.setFavorite", requestContext,
            updatedContext -> this.serviceClient.setFavoriteWithResponse(cookie, ds, body, updatedContext));
    }

    /**
     * The setFavorite operation.
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
    public ApiResponseJsonObject setFavorite(String cookie, String ds, FavoritePostRequest body) {
        return setFavoriteWithResponse(cookie, ds, body, RequestContext.none()).getValue();
    }
}
