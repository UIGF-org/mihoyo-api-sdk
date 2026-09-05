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
 * An instance of this class provides access to all the operations defined in CollectionApis.
 */
public final class CollectionApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final CollectionApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CollectionApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    CollectionApisImpl(CommunityClientImpl client) {
        this.service = CollectionApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityClientCollectionApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "CommunityClientCollectionApis", host = "{endpoint}")
    public interface CollectionApisService {
        static CollectionApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.CollectionApisServiceImpl");
                return (CollectionApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/collection/wapi/collection/detail",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getDetail(@HostParam("endpoint") String endpoint, @QueryParam("gids") int gids,
            @QueryParam("id") String id, @HeaderParam("DS") String ds, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
    }

    /**
     * The getDetail operation.
     * 
     * @param gids The gids parameter.
     * @param id The id parameter.
     * @param ds The ds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getDetailWithResponse(int gids, String id, String ds,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.CollectionApi.getDetail", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.getDetail(this.client.getEndpoint(), gids, id, ds, accept, updatedContext);
            });
    }
}
