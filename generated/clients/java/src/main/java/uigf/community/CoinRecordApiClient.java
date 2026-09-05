package uigf.community;

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
import uigf.checkin.implementation.CoinRecordApisImpl;

/**
 * Initializes a new instance of the synchronous CommunityClient type.
 */
@ServiceClient(builder = CommunityClientBuilder.class)
public final class CoinRecordApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final CoinRecordApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CoinRecordApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    CoinRecordApiClient(CoinRecordApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
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
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> listWithResponse(String cookie, String ds, String appId, String pointSn,
        String time, ListRequestAction action, int size, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Community.CoinRecordApi.list", requestContext,
            updatedContext -> this.serviceClient.listWithResponse(cookie, ds, appId, pointSn, time, action, size,
                updatedContext));
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject list(String cookie, String ds, String appId, String pointSn, String time,
        ListRequestAction action, int size) {
        return listWithResponse(cookie, ds, appId, pointSn, time, action, size, RequestContext.none()).getValue();
    }
}
