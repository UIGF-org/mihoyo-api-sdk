package uigf.game.genshin.record;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponseJsonObject;
import uigf.checkin.implementation.CardApisImpl;

/**
 * Initializes a new instance of the synchronous RecordClient type.
 */
@ServiceClient(builder = RecordClientBuilder.class)
public final class CardApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final CardApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CardApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    CardApiClient(CardApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getGameRecordCard operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param uid The uid parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getGameRecordCardWithResponse(String cookie, String ds, String uid,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.CardApi.getGameRecordCard",
            requestContext,
            updatedContext -> this.serviceClient.getGameRecordCardWithResponse(cookie, ds, uid, updatedContext));
    }

    /**
     * The getGameRecordCard operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param uid The uid parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getGameRecordCard(String cookie, String ds, String uid) {
        return getGameRecordCardWithResponse(cookie, ds, uid, RequestContext.none()).getValue();
    }
}
