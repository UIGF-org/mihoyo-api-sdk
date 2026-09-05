package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.PathParam;
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
import uigf.community.LunaCheckInRequest;

/**
 * An instance of this class provides access to all the operations defined in CheckInApis.
 */
public final class CheckInApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final CheckInApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CheckInClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CheckInApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    CheckInApisImpl(CheckInClientImpl client) {
        this.service = CheckInApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CheckInClientCheckInApis to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "CheckInClientCheckInApis", host = "{endpoint}")
    public interface CheckInApisService {
        static CheckInApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.CheckInApisServiceImpl");
                return (CheckInApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/luna/{game}/home",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getHome(@HostParam("endpoint") String endpoint, @PathParam("game") String game,
            @HeaderParam("Cookie") String cookie, @HeaderParam("x-rpc-signgame") String signGame,
            @QueryParam("lang") String lang, @QueryParam("act_id") String actId, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/luna/{game}/info",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getInfo(@HostParam("endpoint") String endpoint, @PathParam("game") String game,
            @HeaderParam("Cookie") String cookie, @HeaderParam("x-rpc-signgame") String signGame,
            @QueryParam("lang") String lang, @QueryParam("act_id") String actId, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/event/luna/{game}/sign",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> sign(@HostParam("endpoint") String endpoint, @PathParam("game") String game,
            @HeaderParam("Cookie") String cookie, @HeaderParam("x-rpc-signgame") String signGame,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") LunaCheckInRequest body, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/event/luna/{game}/resign_info",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getResignInfo(@HostParam("endpoint") String endpoint,
            @PathParam("game") String game, @HeaderParam("Cookie") String cookie,
            @HeaderParam("x-rpc-signgame") String signGame, @QueryParam("lang") String lang,
            @QueryParam("act_id") String actId, @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/event/luna/{game}/resign",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> resign(@HostParam("endpoint") String endpoint, @PathParam("game") String game,
            @HeaderParam("Cookie") String cookie, @HeaderParam("x-rpc-signgame") String signGame,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") LunaCheckInRequest body, RequestContext requestContext);
    }

    /**
     * The getHome operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getHomeWithResponse(String game, String cookie, String lang, String actId,
        String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.getHome", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getHome(this.client.getEndpoint(), game, cookie, signGame, lang, actId, accept,
                    updatedContext);
            });
    }

    /**
     * The getInfo operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getInfoWithResponse(String game, String cookie, String lang, String actId,
        String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.getInfo", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getInfo(this.client.getEndpoint(), game, cookie, signGame, lang, actId, accept,
                    updatedContext);
            });
    }

    /**
     * The sign operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> signWithResponse(String game, String cookie, LunaCheckInRequest body,
        String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.sign", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.sign(this.client.getEndpoint(), game, cookie, signGame, contentType, accept, body,
                    updatedContext);
            });
    }

    /**
     * The getResignInfo operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getResignInfoWithResponse(String game, String cookie, String lang,
        String actId, String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.getResignInfo", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getResignInfo(this.client.getEndpoint(), game, cookie, signGame, lang, actId, accept,
                    updatedContext);
            });
    }

    /**
     * The resign operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> resignWithResponse(String game, String cookie, LunaCheckInRequest body,
        String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.resign", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.resign(this.client.getEndpoint(), game, cookie, signGame, contentType, accept, body,
                    updatedContext);
            });
    }
}
