package uigf.game.genshin.dispatch.currentregion;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.checkin.implementation.CurrentRegionApisImpl;
import uigf.game.genshin.dispatch.SignedDispatchResponse;

/**
 * Initializes a new instance of the synchronous CurrentRegionClient type.
 */
@ServiceClient(builder = CurrentRegionClientBuilder.class)
public final class CurrentRegionClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final CurrentRegionApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CurrentRegionClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    CurrentRegionClient(CurrentRegionApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SignedDispatchResponse> queryWithResponse(String accountType, String aid, String binary,
        String channelId, String dispatchSeed, String keyId, String lang, String platform, String subChannelId,
        String time, String version, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse(
            "UIGF.Game.Genshin.Dispatch.CurrentRegion.CurrentRegionApi.query", requestContext,
            updatedContext -> this.serviceClient.queryWithResponse(accountType, aid, binary, channelId, dispatchSeed,
                keyId, lang, platform, subChannelId, time, version, updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SignedDispatchResponse query(String accountType, String aid, String binary, String channelId,
        String dispatchSeed, String keyId, String lang, String platform, String subChannelId, String time,
        String version) {
        return queryWithResponse(accountType, aid, binary, channelId, dispatchSeed, keyId, lang, platform, subChannelId,
            time, version, RequestContext.none()).getValue();
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
    public SignedDispatchResponse query() {
        final String accountType = null;
        final String aid = null;
        final String binary = null;
        final String channelId = null;
        final String dispatchSeed = null;
        final String keyId = null;
        final String lang = null;
        final String platform = null;
        final String subChannelId = null;
        final String time = null;
        final String version = null;
        return queryWithResponse(accountType, aid, binary, channelId, dispatchSeed, keyId, lang, platform, subChannelId,
            time, version, RequestContext.none()).getValue();
    }
}
