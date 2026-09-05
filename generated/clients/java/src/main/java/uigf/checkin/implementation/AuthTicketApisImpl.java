package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import uigf.ApiResponseTokenInfo;
import uigf.passport.AuthTicketRequest;

/**
 * An instance of this class provides access to all the operations defined in AuthTicketApis.
 */
public final class AuthTicketApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final AuthTicketApisService service;

    /**
     * The service client containing this operation class.
     */
    private final PassportClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of AuthTicketApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    AuthTicketApisImpl(PassportClientImpl client) {
        this.service = AuthTicketApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for PassportClientAuthTicketApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "PassportClientAuthTicketApis", host = "{endpoint}")
    public interface AuthTicketApisService {
        static AuthTicketApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.AuthTicketApisServiceImpl");
                return (AuthTicketApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/account/ma-cn-verifier/app/createAuthTicketByGameBiz",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseTokenInfo> createByGameBiz(@HostParam("endpoint") String endpoint,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") AuthTicketRequest body, RequestContext requestContext);
    }

    /**
     * Creates an action ticket for a game-biz authentication flow.
     * 
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> createByGameBizWithResponse(AuthTicketRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.AuthTicketApi.createByGameBiz",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.createByGameBiz(this.client.getEndpoint(), contentType, accept, body, updatedContext);
            });
    }
}
