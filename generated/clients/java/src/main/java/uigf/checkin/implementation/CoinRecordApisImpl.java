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
import uigf.community.ListRequestAction;

/**
 * An instance of this class provides access to all the operations defined in CoinRecordApis.
 */
public final class CoinRecordApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final CoinRecordApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommunityClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CoinRecordApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    CoinRecordApisImpl(CommunityClientImpl client) {
        this.service = CoinRecordApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommunityClientCoinRecordApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "CommunityClientCoinRecordApis", host = "{endpoint}")
    public interface CoinRecordApisService {
        static CoinRecordApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.CoinRecordApisServiceImpl");
                return (CoinRecordApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/common/homutreasure/v1/web/user/record",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> list(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("app_id") String appId,
            @QueryParam("point_sn") String pointSn, @QueryParam("time") String time,
            @QueryParam("action") ListRequestAction action, @QueryParam("size") int size,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * Returns MiYouShe coin earnings or spending records.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param appId The appId parameter.
     * @param pointSn The pointSn parameter.
     * @param time The time parameter.
     * @param action The action parameter.
     * @param size The size parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> listWithResponse(String cookie, String ds, String appId, String pointSn,
        String time, ListRequestAction action, int size, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.CoinRecordApi.list", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.list(this.client.getEndpoint(), cookie, ds, appId, pointSn, time, action, size, accept,
                    updatedContext);
            });
    }
}
