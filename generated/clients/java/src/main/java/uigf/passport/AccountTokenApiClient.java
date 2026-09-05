package uigf.passport;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponseTokenInfo;
import uigf.checkin.implementation.AccountTokenApisImpl;

/**
 * Initializes a new instance of the synchronous PassportClient type.
 */
@ServiceClient(builder = PassportClientBuilder.class)
public final class AccountTokenApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final AccountTokenApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of AccountTokenApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    AccountTokenApiClient(AccountTokenApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> getCookieAccountInfoBySTokenWithResponse(String cookie,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.AccountTokenApi.getCookieAccountInfoBySToken",
            requestContext,
            updatedContext -> this.serviceClient.getCookieAccountInfoBySTokenWithResponse(cookie, updatedContext));
    }

    /**
     * Returns account information for an authenticated SToken cookie.
     * 
     * @param cookie The cookie parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseTokenInfo getCookieAccountInfoBySToken(String cookie) {
        return getCookieAccountInfoBySTokenWithResponse(cookie, RequestContext.none()).getValue();
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> getLTokenBySTokenWithResponse(String cookie, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.AccountTokenApi.getLTokenBySToken",
            requestContext, updatedContext -> this.serviceClient.getLTokenBySTokenWithResponse(cookie, updatedContext));
    }

    /**
     * Exchanges an SToken cookie for an LToken payload.
     * 
     * @param cookie The cookie parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseTokenInfo getLTokenBySToken(String cookie) {
        return getLTokenBySTokenWithResponse(cookie, RequestContext.none()).getValue();
    }
}
