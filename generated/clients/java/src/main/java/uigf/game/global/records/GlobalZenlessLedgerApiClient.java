package uigf.game.global.records;

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
import uigf.checkin.implementation.GlobalZenlessLedgerApisImpl;

/**
 * Initializes a new instance of the synchronous GlobalGameRecordsClient type.
 */
@ServiceClient(builder = GlobalGameRecordsClientBuilder.class)
public final class GlobalZenlessLedgerApiClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GlobalZenlessLedgerApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalZenlessLedgerApiClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GlobalZenlessLedgerApiClient(GlobalZenlessLedgerApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getMonthInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param roleId The roleId parameter.
     * @param server The server parameter.
     * @param month The month parameter.
     * @param lang The lang parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMonthInfoWithResponse(String cookie, String roleId, String server,
        String month, String lang, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.ZenlessLedgerApi.getMonthInfo",
            requestContext, updatedContext -> this.serviceClient.getMonthInfoWithResponse(cookie, roleId, server, month,
                lang, updatedContext));
    }

    /**
     * The getMonthInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param roleId The roleId parameter.
     * @param server The server parameter.
     * @param month The month parameter.
     * @param lang The lang parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMonthInfo(String cookie, String roleId, String server, String month, String lang) {
        return getMonthInfoWithResponse(cookie, roleId, server, month, lang, RequestContext.none()).getValue();
    }

    /**
     * The getMonthInfo operation.
     * 
     * @param cookie The cookie parameter.
     * @param roleId The roleId parameter.
     * @param server The server parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMonthInfo(String cookie, String roleId, String server) {
        final String month = null;
        final String lang = null;
        return getMonthInfoWithResponse(cookie, roleId, server, month, lang, RequestContext.none()).getValue();
    }

    /**
     * The getMonthDetail operation.
     * 
     * @param cookie The cookie parameter.
     * @param type The type parameter.
     * @param currentPage The currentPage parameter.
     * @param roleId The roleId parameter.
     * @param server The server parameter.
     * @param pageSize The pageSize parameter.
     * @param month The month parameter.
     * @param lang The lang parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getMonthDetailWithResponse(String cookie, String type, int currentPage,
        String roleId, String server, Integer pageSize, String month, String lang, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Global.Records.ZenlessLedgerApi.getMonthDetail",
            requestContext, updatedContext -> this.serviceClient.getMonthDetailWithResponse(cookie, type, currentPage,
                roleId, server, pageSize, month, lang, updatedContext));
    }

    /**
     * The getMonthDetail operation.
     * 
     * @param cookie The cookie parameter.
     * @param type The type parameter.
     * @param currentPage The currentPage parameter.
     * @param roleId The roleId parameter.
     * @param server The server parameter.
     * @param pageSize The pageSize parameter.
     * @param month The month parameter.
     * @param lang The lang parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMonthDetail(String cookie, String type, int currentPage, String roleId,
        String server, Integer pageSize, String month, String lang) {
        return getMonthDetailWithResponse(cookie, type, currentPage, roleId, server, pageSize, month, lang,
            RequestContext.none()).getValue();
    }

    /**
     * The getMonthDetail operation.
     * 
     * @param cookie The cookie parameter.
     * @param type The type parameter.
     * @param currentPage The currentPage parameter.
     * @param roleId The roleId parameter.
     * @param server The server parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getMonthDetail(String cookie, String type, int currentPage, String roleId,
        String server) {
        final Integer pageSize = null;
        final String month = null;
        final String lang = null;
        return getMonthDetailWithResponse(cookie, type, currentPage, roleId, server, pageSize, month, lang,
            RequestContext.none()).getValue();
    }
}
