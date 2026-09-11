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
 * An instance of this class provides access to all the operations defined in TokenApis.
 */
public final class TokenApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final TokenApisService service;

    /**
     * The service client containing this operation class.
     */
    private final UGCClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of TokenApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    TokenApisImpl(UGCClientImpl client) {
        this.service = TokenApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for UGCClientTokenApis to be used by the proxy service to perform REST
     * calls.
     */
    @ServiceInterface(name = "UGCClientTokenApis", host = "{endpoint}")
    public interface TokenApisService {
        static TokenApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.TokenApisServiceImpl");
                return (TokenApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/ugc_login/v1/client/ugc_token",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> get(@HostParam("endpoint") String endpoint,
            @QueryParam("authkey") String authkey, @QueryParam("auth_appid") String authAppid,
            @QueryParam("authkey_ver") String authkeyVer, @QueryParam("sign_type") String signType,
            @QueryParam("lang") String lang, @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * The get operation.
     * 
     * @param authkey The authkey parameter.
     * @param authAppid The authAppid parameter.
     * @param lang The lang parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getWithResponse(String authkey, String authAppid, String lang,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Uncategorized.UGC.TokenApi.get", requestContext,
            updatedContext -> {
                final String authkeyVer = "1";
                final String signType = "2";
                final String accept = "application/json";
                return service.get(this.client.getEndpoint(), authkey, authAppid, authkeyVer, signType, lang, accept,
                    updatedContext);
            });
    }
}
