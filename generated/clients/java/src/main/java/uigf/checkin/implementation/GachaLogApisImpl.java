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
import uigf.ApiResponseGachaLogPage;

/**
 * An instance of this class provides access to all the operations defined in GachaLogApis.
 */
public final class GachaLogApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GachaLogApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GachaClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GachaLogApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GachaLogApisImpl(GachaClientImpl client) {
        this.service = GachaLogApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GachaClientGachaLogApis to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "GachaClientGachaLogApis", host = "{endpoint}")
    public interface GachaLogApisService {
        static GachaLogApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GachaLogApisServiceImpl");
                return (GachaLogApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/gacha_info/api/getGachaLog",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseGachaLogPage> getHistory(@HostParam("endpoint") String endpoint,
            @QueryParam("authkey") String authkey, @QueryParam("gacha_type") String gachaType,
            @QueryParam("end_id") String endId, @QueryParam("lang") String lang,
            @QueryParam("auth_appid") String authAppid, @QueryParam("authkey_ver") String authkeyVer,
            @QueryParam("sign_type") String signType, @QueryParam("size") Integer size,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/gacha_info/api/getBeyondGachaLog",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseGachaLogPage> getBeyondHistory(@HostParam("endpoint") String endpoint,
            @QueryParam("authkey") String authkey, @QueryParam("gacha_type") String gachaType,
            @QueryParam("end_id") String endId, @QueryParam("lang") String lang,
            @QueryParam("auth_appid") String authAppid, @QueryParam("authkey_ver") String authkeyVer,
            @QueryParam("sign_type") String signType, @QueryParam("size") Integer size,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * The getHistory operation.
     * 
     * @param authkey The authkey parameter.
     * @param gachaType The gachaType parameter.
     * @param lang The lang parameter.
     * @param authAppid The authAppid parameter.
     * @param endId The endId parameter.
     * @param size The size parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGachaLogPage> getHistoryWithResponse(String authkey, String gachaType, String lang,
        String authAppid, String endId, Integer size, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Gacha.GachaLogApi.getHistory",
            requestContext, updatedContext -> {
                final String authkeyVer = "1";
                final String signType = "2";
                final String accept = "application/json";
                return service.getHistory(this.client.getEndpoint(), authkey, gachaType, endId, lang, authAppid,
                    authkeyVer, signType, size, accept, updatedContext);
            });
    }

    /**
     * The getBeyondHistory operation.
     * 
     * @param authkey The authkey parameter.
     * @param gachaType The gachaType parameter.
     * @param lang The lang parameter.
     * @param authAppid The authAppid parameter.
     * @param endId The endId parameter.
     * @param size The size parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGachaLogPage> getBeyondHistoryWithResponse(String authkey, String gachaType, String lang,
        String authAppid, String endId, Integer size, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Gacha.GachaLogApi.getBeyondHistory",
            requestContext, updatedContext -> {
                final String authkeyVer = "1";
                final String signType = "2";
                final String accept = "application/json";
                return service.getBeyondHistory(this.client.getEndpoint(), authkey, gachaType, endId, lang, authAppid,
                    authkeyVer, signType, size, accept, updatedContext);
            });
    }
}
