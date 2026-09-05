package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
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

/**
 * An instance of this class provides access to all the operations defined in AccountTokenApis.
 */
public final class AccountTokenApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final AccountTokenApisService service;

    /**
     * The service client containing this operation class.
     */
    private final PassportClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of AccountTokenApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    AccountTokenApisImpl(PassportClientImpl client) {
        this.service = AccountTokenApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for PassportClientAccountTokenApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "PassportClientAccountTokenApis", host = "{endpoint}")
    public interface AccountTokenApisService {
        static AccountTokenApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.AccountTokenApisServiceImpl");
                return (AccountTokenApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/account/auth/api/getCookieAccountInfoBySToken",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseTokenInfo> getCookieAccountInfoBySToken(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/account/auth/api/getLTokenBySToken",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseTokenInfo> getLTokenBySToken(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * Returns account information for an authenticated SToken cookie.
     * 
     * @param cookie The cookie parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> getCookieAccountInfoBySTokenWithResponse(String cookie,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.AccountTokenApi.getCookieAccountInfoBySToken",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getCookieAccountInfoBySToken(this.client.getEndpoint(), cookie, accept, updatedContext);
            });
    }

    /**
     * Exchanges an SToken cookie for an LToken payload.
     * 
     * @param cookie The cookie parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> getLTokenBySTokenWithResponse(String cookie, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.AccountTokenApi.getLTokenBySToken",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getLTokenBySToken(this.client.getEndpoint(), cookie, accept, updatedContext);
            });
    }
}
