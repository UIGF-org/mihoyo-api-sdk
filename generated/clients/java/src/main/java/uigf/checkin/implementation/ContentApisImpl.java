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
import uigf.ApiResponseAnnouncementList;
import uigf.ListRequestPlatform;

/**
 * An instance of this class provides access to all the operations defined in ContentApis.
 */
public final class ContentApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ContentApisService service;

    /**
     * The service client containing this operation class.
     */
    private final AnnouncementContentClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ContentApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ContentApisImpl(AnnouncementContentClientImpl client) {
        this.service = ContentApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for AnnouncementContentClientContentApis to be used by the proxy service
     * to perform REST calls.
     */
    @ServiceInterface(name = "AnnouncementContentClientContentApis", host = "{endpoint}")
    public interface ContentApisService {
        static ContentApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.ContentApisServiceImpl");
                return (ContentApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/common/hk4e_cn/announcement/api/getAnnContent",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseAnnouncementList> get(@HostParam("endpoint") String endpoint, @QueryParam("t") String t,
            @QueryParam("game") String game, @QueryParam("game_biz") String gameBiz, @QueryParam("lang") String lang,
            @QueryParam("bundle_id") String bundleId, @QueryParam("platform") ListRequestPlatform platform,
            @QueryParam("region") String region, @QueryParam("level") Integer level, @QueryParam("uid") String uid,
            @QueryParam("channel_id") Integer channelId, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
    }

    /**
     * The get operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
     * @param t The t parameter.
     * @param level The level parameter.
     * @param uid The uid parameter.
     * @param channelId The channelId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseAnnouncementList> getWithResponse(String game, String gameBiz, String lang,
        String bundleId, ListRequestPlatform platform, String region, String t, Integer level, String uid,
        Integer channelId, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.AnnouncementContent.ContentApi.get",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.get(this.client.getEndpoint(), t, game, gameBiz, lang, bundleId, platform, region, level,
                    uid, channelId, accept, updatedContext);
            });
    }
}
