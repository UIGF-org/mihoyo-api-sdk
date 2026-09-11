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
 * An instance of this class provides access to all the operations defined in UgcApis.
 */
public final class UgcApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final UgcApisService service;

    /**
     * The service client containing this operation class.
     */
    private final UgcAnnouncementsClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of UgcApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    UgcApisImpl(UgcAnnouncementsClientImpl client) {
        this.service = UgcApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for UgcAnnouncementsClientUgcApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "UgcAnnouncementsClientUgcApis", host = "{endpoint}")
    public interface UgcApisService {
        static UgcApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.UgcApisServiceImpl");
                return (UgcApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/common/hk4eugc_cn/announcement/api/getAlertAnn",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseAnnouncementList> getAlert(@HostParam("endpoint") String endpoint,
            @QueryParam("game") String game, @QueryParam("game_biz") String gameBiz, @QueryParam("lang") String lang,
            @QueryParam("bundle_id") String bundleId, @QueryParam("platform") ListRequestPlatform platform,
            @QueryParam("region") String region, @QueryParam("level") Integer level, @QueryParam("uid") String uid,
            @QueryParam("channel_id") Integer channelId, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
    }

    /**
     * The getAlert operation.
     * 
     * @param game The game parameter.
     * @param gameBiz The gameBiz parameter.
     * @param lang The lang parameter.
     * @param bundleId The bundleId parameter.
     * @param platform The platform parameter.
     * @param region The region parameter.
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
    public Response<ApiResponseAnnouncementList> getAlertWithResponse(String game, String gameBiz, String lang,
        String bundleId, ListRequestPlatform platform, String region, Integer level, String uid, Integer channelId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.UgcAnnouncements.UgcApi.getAlert",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getAlert(this.client.getEndpoint(), game, gameBiz, lang, bundleId, platform, region,
                    level, uid, channelId, accept, updatedContext);
            });
    }
}
