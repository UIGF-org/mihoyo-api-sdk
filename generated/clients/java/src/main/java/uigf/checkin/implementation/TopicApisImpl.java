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
 * An instance of this class provides access to all the operations defined in TopicApis.
 */
public final class TopicApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final TopicApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of TopicApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    TopicApisImpl(CommunityClientImpl client) {
        this.service = TopicApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityClientTopicApis to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "CommunityClientTopicApis", host = "{endpoint}")
    public interface TopicApisService {
        static TopicApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.TopicApisServiceImpl");
                return (TopicApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/topic/wapi/getTopicFullInfo",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getFullInfo(@HostParam("endpoint") String endpoint,
            @QueryParam("gids") String gids, @QueryParam("id") String id, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
    }

    /**
     * The getFullInfo operation.
     * 
     * @param gids The gids parameter.
     * @param id The id parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getFullInfoWithResponse(String gids, String id,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.TopicApi.getFullInfo", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getFullInfo(this.client.getEndpoint(), gids, id, accept, updatedContext);
            });
    }
}
