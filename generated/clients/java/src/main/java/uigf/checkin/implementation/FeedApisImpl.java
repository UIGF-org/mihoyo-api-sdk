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
import uigf.ApiResponseJsonObject;
import uigf.ApiResponsePostList;

/**
 * An instance of this class provides access to all the operations defined in FeedApis.
 */
public final class FeedApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final FeedApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of FeedApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    FeedApisImpl(CommunityClientImpl client) {
        this.service = FeedApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityClientFeedApis to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "CommunityClientFeedApis", host = "{endpoint}")
    public interface FeedApisService {
        static FeedApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.FeedApisServiceImpl");
                return (FeedApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/painter/wapi/getNewsList",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePostList> getNews(@HostParam("endpoint") String endpoint, @QueryParam("gids") String gids,
            @QueryParam("offset") Integer offset, @QueryParam("size") Integer size,
            @QueryParam("last_id") String lastId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/painter/wapi/getHotForumPostList",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePostList> getHotForumPosts(@HostParam("endpoint") String endpoint,
            @QueryParam("gids") String gids, @QueryParam("offset") Integer offset, @QueryParam("size") Integer size,
            @QueryParam("last_id") String lastId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/painter/wapi/getRecentForumPostList",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePostList> getRecentForumPosts(@HostParam("endpoint") String endpoint,
            @QueryParam("gids") String gids, @QueryParam("offset") Integer offset, @QueryParam("size") Integer size,
            @QueryParam("last_id") String lastId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/painter/wapi/getTimelineList",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponsePostList> getTimeline(@HostParam("endpoint") String endpoint,
            @QueryParam("gids") String gids, @QueryParam("offset") Integer offset, @QueryParam("size") Integer size,
            @QueryParam("last_id") String lastId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/painter/wapi/lotteryUserShow",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getLotteryUserShow(@HostParam("endpoint") String endpoint,
            @QueryParam("lottery_id") String lotteryId, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getNewsWithResponse(String gids, Integer offset, Integer size, String lastId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getNews", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getNews(this.client.getEndpoint(), gids, offset, size, lastId, accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getHotForumPostsWithResponse(String gids, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getHotForumPosts", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getHotForumPosts(this.client.getEndpoint(), gids, offset, size, lastId, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getRecentForumPostsWithResponse(String gids, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getRecentForumPosts", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getRecentForumPosts(this.client.getEndpoint(), gids, offset, size, lastId, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponsePostList> getTimelineWithResponse(String gids, Integer offset, Integer size,
        String lastId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getTimeline", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getTimeline(this.client.getEndpoint(), gids, offset, size, lastId, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getLotteryUserShowWithResponse(String lotteryId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.FeedApi.getLotteryUserShow", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getLotteryUserShow(this.client.getEndpoint(), lotteryId, accept, updatedContext);
            });
    }
}
