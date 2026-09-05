package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
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
import uigf.community.VerificationCreateRequest;
import uigf.community.VerificationSubmitRequest;

/**
 * An instance of this class provides access to all the operations defined in MiscApis.
 */
public final class MiscApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final MiscApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of MiscApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    MiscApisImpl(CommunityClientImpl client) {
        this.service = MiscApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityClientMiscApis to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "CommunityClientMiscApis", host = "{endpoint}")
    public interface MiscApisService {
        static MiscApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.MiscApisServiceImpl");
                return (MiscApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(method = HttpMethod.GET, path = "/misc/api/emoticon_set", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getEmoticonSet(@HostParam("endpoint") String endpoint,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/misc/api/createVerification",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> createVerification(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") VerificationCreateRequest body,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/misc/api/verifyVerification",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> verifyVerification(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") VerificationSubmitRequest body,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/misc/api/getGeetestChallenge",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getGeetestChallenge(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @QueryParam("action_type") String actionType,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * The getEmoticonSet operation.
     * 
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getEmoticonSetWithResponse(RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.MiscApi.getEmoticonSet", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getEmoticonSet(this.client.getEndpoint(), accept, updatedContext);
            });
    }

    /**
     * Creates the official verification challenge required by selected operations.
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
    public Response<ApiResponseJsonObject> createVerificationWithResponse(String cookie, VerificationCreateRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.MiscApi.createVerification", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.createVerification(this.client.getEndpoint(), cookie, contentType, accept, body,
                    updatedContext);
            });
    }

    /**
     * Submits verification output obtained from the official challenge provider.
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
    public Response<ApiResponseJsonObject> verifyVerificationWithResponse(String cookie, VerificationSubmitRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.MiscApi.verifyVerification", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.verifyVerification(this.client.getEndpoint(), cookie, contentType, accept, body,
                    updatedContext);
            });
    }

    /**
     * The getGeetestChallenge operation.
     * 
     * @param cookie The cookie parameter.
     * @param actionType The actionType parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getGeetestChallengeWithResponse(String cookie, String actionType,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.MiscApi.getGeetestChallenge", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getGeetestChallenge(this.client.getEndpoint(), cookie, actionType, accept,
                    updatedContext);
            });
    }
}
