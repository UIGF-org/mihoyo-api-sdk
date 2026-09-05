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
 * An instance of this class provides access to all the operations defined in GlobalGenshinLedgerApis.
 */
public final class GlobalGenshinLedgerApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GlobalGenshinLedgerApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GenshinClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalGenshinLedgerApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GlobalGenshinLedgerApisImpl(GenshinClientImpl client) {
        this.service = GlobalGenshinLedgerApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GenshinClientGlobalGenshinLedgerApis to be used by the proxy service
     * to perform REST calls.
     */
    @ServiceInterface(name = "GenshinClientGlobalGenshinLedgerApis", host = "{endpoint}")
    public interface GlobalGenshinLedgerApisService {
        static GlobalGenshinLedgerApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GlobalGenshinLedgerApisServiceImpl");
                return (GlobalGenshinLedgerApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/ysledgeros/month_info",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getMonthInfo(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @QueryParam("month") String month, @QueryParam("lang") String lang,
            @QueryParam("role_id") String roleId, @QueryParam("server") String server,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/ysledgeros/month_detail",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getMonthDetail(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @QueryParam("type") int type,
            @QueryParam("current_page") int currentPage, @QueryParam("month") String month,
            @QueryParam("lang") String lang, @QueryParam("role_id") String roleId, @QueryParam("server") String server,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * The getMonthInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param roleId The roleId parameter.
     * @param server The server parameter.
     * @param month The month parameter.
     * @param lang The lang parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMonthInfoWithResponse(String cookie, String roleId, String server,
        String month, String lang, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Genshin.LedgerApi.getMonthInfo",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getMonthInfo(this.client.getEndpoint(), cookie, month, lang, roleId, server, accept,
                    updatedContext);
            });
    }

    /**
     * The getMonthDetail operation.
     * 
     * @param cookie The cookie parameter.
     * @param type The type parameter.
     * @param currentPage The currentPage parameter.
     * @param roleId The roleId parameter.
     * @param server The server parameter.
     * @param month The month parameter.
     * @param lang The lang parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMonthDetailWithResponse(String cookie, int type, int currentPage,
        String roleId, String server, String month, String lang, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Genshin.LedgerApi.getMonthDetail",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getMonthDetail(this.client.getEndpoint(), cookie, type, currentPage, month, lang, roleId,
                    server, accept, updatedContext);
            });
    }
}
