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
import uigf.JsonObject;

/**
 * An instance of this class provides access to all the operations defined in PassportV4SessionApis.
 */
public final class PassportV4SessionApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final PassportV4SessionApisService service;

    /**
     * The service client containing this operation class.
     */
    private final PassportV4ClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of PassportV4SessionApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    PassportV4SessionApisImpl(PassportV4ClientImpl client) {
        this.service = PassportV4SessionApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for PassportV4ClientPassportV4SessionApis to be used by the proxy service
     * to perform REST calls.
     */
    @ServiceInterface(name = "PassportV4ClientPassportV4SessionApis", host = "{endpoint}")
    public interface PassportV4SessionApisService {
        static PassportV4SessionApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.PassportV4SessionApisServiceImpl");
                return (PassportV4SessionApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/account/ma-cn-session/web/verifyLtoken",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseTokenInfo> verifyLToken(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") JsonObject body,
            RequestContext requestContext);
    }

    /**
     * The verifyLToken operation.
     * 
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> verifyLTokenWithResponse(String cookie, JsonObject body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.PassportV4.SessionApi.verifyLToken", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.verifyLToken(this.client.getEndpoint(), cookie, contentType, accept, body,
                    updatedContext);
            });
    }
}
