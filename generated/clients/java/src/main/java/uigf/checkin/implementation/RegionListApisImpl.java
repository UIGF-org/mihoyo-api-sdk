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
import io.clientcore.core.models.binarydata.BinaryData;
import java.lang.reflect.InvocationTargetException;

/**
 * An instance of this class provides access to all the operations defined in RegionListApis.
 */
public final class RegionListApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final RegionListApisService service;

    /**
     * The service client containing this operation class.
     */
    private final RegionListClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of RegionListApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    RegionListApisImpl(RegionListClientImpl client) {
        this.service = RegionListApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for RegionListClientRegionListApis to be used by the proxy service to
     * perform REST calls.
     */
    @ServiceInterface(name = "RegionListClientRegionListApis", host = "{endpoint}")
    public interface RegionListApisService {
        static RegionListApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.RegionListApisServiceImpl");
                return (RegionListApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(method = HttpMethod.GET, path = "/query_region_list", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<BinaryData> query(@HostParam("endpoint") String endpoint, @QueryParam("binary") String binary,
            @QueryParam("channel_id") String channelId, @QueryParam("lang") String lang,
            @QueryParam("platform") String platform, @QueryParam("sub_channel_id") String subChannelId,
            @QueryParam("time") String time, @QueryParam("version") String version,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * The query operation.
     * 
     * @param binary The binary parameter.
     * @param channelId The channelId parameter.
     * @param lang The lang parameter.
     * @param platform The platform parameter.
     * @param subChannelId The subChannelId parameter.
     * @param time The time parameter.
     * @param version The version parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> queryWithResponse(String binary, String channelId, String lang, String platform,
        String subChannelId, String time, String version, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Dispatch.RegionList.RegionListApi.query",
            requestContext, updatedContext -> {
                final String accept = "application/octet-stream";
                return service.query(this.client.getEndpoint(), binary, channelId, lang, platform, subChannelId, time,
                    version, accept, updatedContext);
            });
    }
}
