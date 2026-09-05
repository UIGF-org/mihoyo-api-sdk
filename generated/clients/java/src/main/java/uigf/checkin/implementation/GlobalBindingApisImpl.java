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
import uigf.ApiResponseGameRoleList;

/**
 * An instance of this class provides access to all the operations defined in GlobalBindingApis.
 */
public final class GlobalBindingApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GlobalBindingApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GlobalGameAccountClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalBindingApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GlobalBindingApisImpl(GlobalGameAccountClientImpl client) {
        this.service = GlobalBindingApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GlobalGameAccountClientGlobalBindingApis to be used by the proxy
     * service to perform REST calls.
     */
    @ServiceInterface(name = "GlobalGameAccountClientGlobalBindingApis", host = "{endpoint}")
    public interface GlobalBindingApisService {
        static GlobalBindingApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GlobalBindingApisServiceImpl");
                return (GlobalBindingApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/binding/api/getUserGameRolesByCookieToken",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseGameRoleList> getRoles(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @QueryParam("game_biz") String gameBiz,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * The getRoles operation.
     * 
     * @param cookie The cookie parameter.
     * @param gameBiz The gameBiz parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseGameRoleList> getRolesWithResponse(String cookie, String gameBiz,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Account.BindingApi.getRoles",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getRoles(this.client.getEndpoint(), cookie, gameBiz, accept, updatedContext);
            });
    }
}
