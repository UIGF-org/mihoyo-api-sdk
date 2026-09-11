package uigf.commerce.cn;

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
import uigf.ApiResponseOrderStatus;
import uigf.ApiResponseShopGoods;
import uigf.JsonObject;
import uigf.checkin.implementation.ShopApisImpl;
import uigf.commerce.CreateOrderRequest;
import uigf.commerce.ShopGoodsRequest;

/**
 * Initializes a new instance of the synchronous CommerceClient type.
 */
@ServiceClient(builder = CommerceClientBuilder.class)
public final class CommerceClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final ShopApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CommerceClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    CommerceClient(ShopApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * Returns purchasable catalogue entries for the authenticated game account.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param body The body parameter.
     * @param cookie The cookie parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseShopGoods> fetchGoodsWithResponse(String gameBiz, ShopGoodsRequest body, String cookie,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Commerce.CN.ShopApi.fetchGoods", requestContext,
            updatedContext -> this.serviceClient.fetchGoodsWithResponse(gameBiz, body, cookie, updatedContext));
    }

    /**
     * Returns purchasable catalogue entries for the authenticated game account.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param body The body parameter.
     * @param cookie The cookie parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseShopGoods fetchGoods(String gameBiz, ShopGoodsRequest body, String cookie) {
        return fetchGoodsWithResponse(gameBiz, body, cookie, RequestContext.none()).getValue();
    }

    /**
     * Returns purchasable catalogue entries for the authenticated game account.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseShopGoods fetchGoods(String gameBiz, ShopGoodsRequest body) {
        final String cookie = null;
        return fetchGoodsWithResponse(gameBiz, body, cookie, RequestContext.none()).getValue();
    }

    /**
     * Returns the storefront currency and country inferred by the SDK host.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getCurrencyAndCountryByIpWithResponse(String gameBiz, JsonObject body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Commerce.CN.ShopApi.getCurrencyAndCountryByIp",
            requestContext,
            updatedContext -> this.serviceClient.getCurrencyAndCountryByIpWithResponse(gameBiz, body, updatedContext));
    }

    /**
     * Returns the storefront currency and country inferred by the SDK host.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getCurrencyAndCountryByIp(String gameBiz, JsonObject body) {
        return getCurrencyAndCountryByIpWithResponse(gameBiz, body, RequestContext.none()).getValue();
    }

    /**
     * Returns the storefront currency and country inferred by the SDK host.
     * 
     * @param gameBiz The gameBiz parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getCurrencyAndCountryByIp(String gameBiz) {
        final JsonObject body = null;
        return getCurrencyAndCountryByIpWithResponse(gameBiz, body, RequestContext.none()).getValue();
    }

    /**
     * Sends a vendor-signed order request; no payment signing is generated by this SDK.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param cookie The cookie parameter.
     * @param deviceId The deviceId parameter.
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> createOrderWithResponse(String gameBiz, String cookie, String deviceId,
        CreateOrderRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Commerce.CN.ShopApi.createOrder", requestContext,
            updatedContext -> this.serviceClient.createOrderWithResponse(gameBiz, cookie, deviceId, body,
                updatedContext));
    }

    /**
     * Sends a vendor-signed order request; no payment signing is generated by this SDK.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param cookie The cookie parameter.
     * @param deviceId The deviceId parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject createOrder(String gameBiz, String cookie, String deviceId, CreateOrderRequest body) {
        return createOrderWithResponse(gameBiz, cookie, deviceId, body, RequestContext.none()).getValue();
    }

    /**
     * The checkOrder operation.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param orderNo The orderNo parameter.
     * @param game The game parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @param cookie The cookie parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseOrderStatus> checkOrderWithResponse(String gameBiz, String orderNo, String game,
        String region, String uid, String cookie, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Commerce.CN.ShopApi.checkOrder", requestContext,
            updatedContext -> this.serviceClient.checkOrderWithResponse(gameBiz, orderNo, game, region, uid, cookie,
                updatedContext));
    }

    /**
     * The checkOrder operation.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param orderNo The orderNo parameter.
     * @param game The game parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @param cookie The cookie parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseOrderStatus checkOrder(String gameBiz, String orderNo, String game, String region, String uid,
        String cookie) {
        return checkOrderWithResponse(gameBiz, orderNo, game, region, uid, cookie, RequestContext.none()).getValue();
    }

    /**
     * The checkOrder operation.
     * 
     * @param gameBiz The gameBiz parameter.
     * @param orderNo The orderNo parameter.
     * @param game The game parameter.
     * @param region The region parameter.
     * @param uid The uid parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseOrderStatus checkOrder(String gameBiz, String orderNo, String game, String region, String uid) {
        final String cookie = null;
        return checkOrderWithResponse(gameBiz, orderNo, game, region, uid, cookie, RequestContext.none()).getValue();
    }
}
