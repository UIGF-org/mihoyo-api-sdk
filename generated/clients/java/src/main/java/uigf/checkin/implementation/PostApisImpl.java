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
import uigf.ApiResponseJsonObject;
import uigf.ApiResponsePost;
import uigf.ApiResponsePostList;
import uigf.community.FavoritePostRequest;

/**
 * An instance of this class provides access to all the operations defined in PostApis.
 */
public final class PostApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final PostApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of PostApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    PostApisImpl(CommunityClientImpl client) {
        this.service = PostApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityClientPostApis to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "CommunityClientPostApis", host = "{endpoint}")
    public interface PostApisService {
        static PostApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.PostApisServiceImpl");
                return (PostApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(method = HttpMethod.GET, path = "/post/wapi/getPostFull", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePost> getFull(@HostParam("endpoint") String endpoint, @HeaderParam("Cookie") String cookie,
            @QueryParam("post_id") String postId, @QueryParam("gids") String gids, @QueryParam("read") Integer read,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/post/wapi/getPostFullInCollection",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePost> getFullInCollection(@HostParam("endpoint") String endpoint,
            @QueryParam("collection_id") String collectionId, @QueryParam("post_id") String postId,
            @QueryParam("gids") String gids, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/post/wapi/getPostReplies",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePostList> getReplies(@HostParam("endpoint") String endpoint,
            @QueryParam("last_id") String lastId, @QueryParam("size") Integer size,
            @QueryParam("post_id") String postId, @QueryParam("gids") String gids, @QueryParam("read") Integer read,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/post/wapi/getSubReplies",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePostList> getSubReplies(@HostParam("endpoint") String endpoint,
            @QueryParam("post_id") String postId, @QueryParam("reply_id") String replyId,
            @QueryParam("last_id") String lastId, @QueryParam("size") Integer size,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/post/wapi/getTopicPostList",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePostList> getTopicPosts(@HostParam("endpoint") String endpoint,
            @QueryParam("gids") String gids, @QueryParam("topic_id") String topicId,
            @QueryParam("offset") Integer offset, @QueryParam("size") Integer size,
            @QueryParam("last_id") String lastId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(method = HttpMethod.GET, path = "/post/wapi/userPost", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePostList> getUserPosts(@HostParam("endpoint") String endpoint,
            @QueryParam("uid") String uid, @QueryParam("gids") String gids, @QueryParam("offset") Integer offset,
            @QueryParam("size") Integer size, @QueryParam("last_id") String lastId,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(method = HttpMethod.GET, path = "/post/wapi/searchPosts", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePostList> search(@HostParam("endpoint") String endpoint, @QueryParam("gids") String gids,
            @QueryParam("keyword") String keyword, @QueryParam("offset") Integer offset,
            @QueryParam("size") Integer size, @QueryParam("last_id") String lastId,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/post/wapi/userFavoritePost",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> setFavorite(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") FavoritePostRequest body, RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePost> getFullWithResponse(String postId, String cookie, String gids, Integer read,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getFull", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getFull(this.client.getEndpoint(), cookie, postId, gids, read, accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePost> getFullInCollectionWithResponse(String collectionId, String postId, String gids,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getFullInCollection", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getFullInCollection(this.client.getEndpoint(), collectionId, postId, gids, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getRepliesWithResponse(String postId, String lastId, Integer size, String gids,
        Integer read, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getReplies", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getReplies(this.client.getEndpoint(), lastId, size, postId, gids, read, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getSubRepliesWithResponse(String postId, String replyId, String lastId,
        Integer size, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getSubReplies", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getSubReplies(this.client.getEndpoint(), postId, replyId, lastId, size, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getTopicPostsWithResponse(String gids, String topicId, Integer offset,
        Integer size, String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getTopicPosts", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getTopicPosts(this.client.getEndpoint(), gids, topicId, offset, size, lastId, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getUserPostsWithResponse(String uid, String gids, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.getUserPosts", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getUserPosts(this.client.getEndpoint(), uid, gids, offset, size, lastId, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> searchWithResponse(String gids, String keyword, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.search", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.search(this.client.getEndpoint(), gids, keyword, offset, size, lastId, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> setFavoriteWithResponse(String cookie, String ds, FavoritePostRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.PostApi.setFavorite", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.setFavorite(this.client.getEndpoint(), cookie, ds, contentType, accept, body,
                    updatedContext);
            });
    }
}
