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

/**
 * An instance of this class provides access to all the operations defined in GlobalZenlessCultivationApis.
 */
public final class GlobalZenlessCultivationApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GlobalZenlessCultivationApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GlobalGameRecordsClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalZenlessCultivationApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GlobalZenlessCultivationApisImpl(GlobalGameRecordsClientImpl client) {
        this.service = GlobalZenlessCultivationApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GlobalGameRecordsClientGlobalZenlessCultivationApis to be used by the
     * proxy service to perform REST calls.
     */
    @ServiceInterface(name = "GlobalGameRecordsClientGlobalZenlessCultivationApis", host = "{endpoint}")
    public interface GlobalZenlessCultivationApisService {
        static GlobalZenlessCultivationApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GlobalZenlessCultivationApisServiceImpl");
                return (GlobalZenlessCultivationApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/nap_cultivate_tool/user/item_list",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getItems(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @QueryParam("uid") String uid, @QueryParam("region") String region,
            @QueryParam("avatar_id") int avatarId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/nap_cultivate_tool/user/icon_info",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getIconInfo(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @QueryParam("uid") String uid, @QueryParam("region") String region,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * The getItems operation.
     * 
     * @param cookie The cookie parameter.
     * @param uid The uid parameter.
     * @param region The region parameter.
     * @param avatarId The avatarId parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getItemsWithResponse(String cookie, String uid, String region, int avatarId,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.ZenlessCultivationApi.getItems",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getItems(this.client.getEndpoint(), cookie, uid, region, avatarId, accept,
                    updatedContext);
            });
    }

    /**
     * The getIconInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param uid The uid parameter.
     * @param region The region parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getIconInfoWithResponse(String cookie, String uid, String region,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.ZenlessCultivationApi.getIconInfo",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getIconInfo(this.client.getEndpoint(), cookie, uid, region, accept, updatedContext);
            });
    }
}
