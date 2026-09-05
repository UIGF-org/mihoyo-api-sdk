package uigf.game.genshin.ledger;

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
import uigf.checkin.implementation.GenshinLedgerApisImpl;

/**
 * Initializes a new instance of the synchronous LedgerClient type.
 */
@ServiceClient(builder = LedgerClientBuilder.class)
public final class LedgerClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GenshinLedgerApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of LedgerClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    LedgerClient(GenshinLedgerApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getMonthInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param bindUid The bindUid parameter.
     * @param bindRegion The bindRegion parameter.
     * @param month The month parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMonthInfoWithResponse(String cookie, String ds, String bindUid,
        String bindRegion, Integer month, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Ledger.LedgerApi.getMonthInfo",
            requestContext, updatedContext -> this.serviceClient.getMonthInfoWithResponse(cookie, ds, bindUid,
                bindRegion, month, updatedContext));
    }

    /**
     * The getMonthInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param bindUid The bindUid parameter.
     * @param bindRegion The bindRegion parameter.
     * @param month The month parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMonthInfo(String cookie, String ds, String bindUid, String bindRegion,
        Integer month) {
        return getMonthInfoWithResponse(cookie, ds, bindUid, bindRegion, month, RequestContext.none()).getValue();
    }

    /**
     * The getMonthInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param bindUid The bindUid parameter.
     * @param bindRegion The bindRegion parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMonthInfo(String cookie, String ds, String bindUid, String bindRegion) {
        final Integer month = null;
        return getMonthInfoWithResponse(cookie, ds, bindUid, bindRegion, month, RequestContext.none()).getValue();
    }

    /**
     * The getMonthDetail operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param month The month parameter.
     * @param page The page parameter.
     * @param type The type parameter.
     * @param bindUid The bindUid parameter.
     * @param bindRegion The bindRegion parameter.
     * @param limit The limit parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMonthDetailWithResponse(String cookie, String ds, int month, int page,
        int type, String bindUid, String bindRegion, Integer limit, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Ledger.LedgerApi.getMonthDetail",
            requestContext, updatedContext -> this.serviceClient.getMonthDetailWithResponse(cookie, ds, month, page,
                type, bindUid, bindRegion, limit, updatedContext));
    }

    /**
     * The getMonthDetail operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param month The month parameter.
     * @param page The page parameter.
     * @param type The type parameter.
     * @param bindUid The bindUid parameter.
     * @param bindRegion The bindRegion parameter.
     * @param limit The limit parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMonthDetail(String cookie, String ds, int month, int page, int type, String bindUid,
        String bindRegion, Integer limit) {
        return getMonthDetailWithResponse(cookie, ds, month, page, type, bindUid, bindRegion, limit,
            RequestContext.none()).getValue();
    }

    /**
     * The getMonthDetail operation.
     * 
     * @param cookie The cookie parameter.
     * @param ds The ds parameter.
     * @param month The month parameter.
     * @param page The page parameter.
     * @param type The type parameter.
     * @param bindUid The bindUid parameter.
     * @param bindRegion The bindRegion parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMonthDetail(String cookie, String ds, int month, int page, int type, String bindUid,
        String bindRegion) {
        final Integer limit = null;
        return getMonthDetailWithResponse(cookie, ds, month, page, type, bindUid, bindRegion, limit,
            RequestContext.none()).getValue();
    }
}
