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
 * An instance of this class provides access to all the operations defined in ActionTicketApis.
 */
public final class ActionTicketApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ActionTicketApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GameAccountClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ActionTicketApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ActionTicketApisImpl(GameAccountClientImpl client) {
        this.service = ActionTicketApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GameAccountClientActionTicketApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "GameAccountClientActionTicketApis", host = "{endpoint}")
    public interface ActionTicketApisService {
        static ActionTicketApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.ActionTicketApisServiceImpl");
                return (ActionTicketApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/auth/api/getActionTicketBySToken",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getBySToken(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds,
            @QueryParam("action_type") String actionType, @QueryParam("stoken") String stoken,
            @QueryParam("uid") String uid, @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * The getBySToken operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param actionType The actionType parameter.
     * @param stoken The stoken parameter.
     * @param uid The uid parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getBySTokenWithResponse(String cookie, String ds, String actionType,
        String stoken, String uid, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Account.ActionTicketApi.getBySToken",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getBySToken(this.client.getEndpoint(), cookie, ds, actionType, stoken, uid, accept,
                    updatedContext);
            });
    }
}
