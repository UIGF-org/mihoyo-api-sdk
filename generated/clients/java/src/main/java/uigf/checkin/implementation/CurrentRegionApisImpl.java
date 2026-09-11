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
import uigf.game.genshin.dispatch.SignedDispatchResponse;

/**
 * An instance of this class provides access to all the operations defined in CurrentRegionApis.
 */
public final class CurrentRegionApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final CurrentRegionApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CurrentRegionClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CurrentRegionApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    CurrentRegionApisImpl(CurrentRegionClientImpl client) {
        this.service = CurrentRegionApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CurrentRegionClientCurrentRegionApis to be used by the proxy service
     * to perform REST calls.
     */
    @ServiceInterface(name = "CurrentRegionClientCurrentRegionApis", host = "{endpoint}")
    public interface CurrentRegionApisService {
        static CurrentRegionApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.CurrentRegionApisServiceImpl");
                return (CurrentRegionApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(method = HttpMethod.GET, path = "/query_cur_region", expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<SignedDispatchResponse> query(@HostParam("endpoint") String endpoint,
            @QueryParam("account_type") String accountType, @QueryParam("aid") String aid,
            @QueryParam("binary") String binary, @QueryParam("channel_id") String channelId,
            @QueryParam("dispatchSeed") String dispatchSeed, @QueryParam("key_id") String keyId,
            @QueryParam("lang") String lang, @QueryParam("platform") String platform,
            @QueryParam("sub_channel_id") String subChannelId, @QueryParam("time") String time,
            @QueryParam("version") String version, @HeaderParam("Accept") String accept, RequestContext requestContext);
    }

    /**
     * The query operation.
     * 
     * @param accountType The accountType parameter.
     * @param aid The aid parameter.
     * @param binary The binary parameter.
     * @param channelId The channelId parameter.
     * @param dispatchSeed The dispatchSeed parameter.
     * @param keyId The keyId parameter.
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
    public Response<SignedDispatchResponse> queryWithResponse(String accountType, String aid, String binary,
        String channelId, String dispatchSeed, String keyId, String lang, String platform, String subChannelId,
        String time, String version, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Genshin.Dispatch.CurrentRegion.CurrentRegionApi.query", requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.query(this.client.getEndpoint(), accountType, aid, binary, channelId, dispatchSeed,
                    keyId, lang, platform, subChannelId, time, version, accept, updatedContext);
            });
    }
}
