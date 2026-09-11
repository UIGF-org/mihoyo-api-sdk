package uigf.game.genshin.dispatch.regionlist;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import io.clientcore.core.models.binarydata.BinaryData;
import uigf.checkin.implementation.RegionListApisImpl;

/**
 * Initializes a new instance of the synchronous RegionListClient type.
 */
@ServiceClient(builder = RegionListClientBuilder.class)
public final class RegionListClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final RegionListApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of RegionListClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    RegionListClient(RegionListApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> queryWithResponse(String binary, String channelId, String lang, String platform,
        String subChannelId, String time, String version, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Dispatch.RegionList.RegionListApi.query",
            requestContext, updatedContext -> this.serviceClient.queryWithResponse(binary, channelId, lang, platform,
                subChannelId, time, version, updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public BinaryData query(String binary, String channelId, String lang, String platform, String subChannelId,
        String time, String version) {
        return queryWithResponse(binary, channelId, lang, platform, subChannelId, time, version, RequestContext.none())
            .getValue();
    }

    /**
     * The query operation.
     * 
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public BinaryData query() {
        final String binary = null;
        final String channelId = null;
        final String lang = null;
        final String platform = null;
        final String subChannelId = null;
        final String time = null;
        final String version = null;
        return queryWithResponse(binary, channelId, lang, platform, subChannelId, time, version, RequestContext.none())
            .getValue();
    }
}
