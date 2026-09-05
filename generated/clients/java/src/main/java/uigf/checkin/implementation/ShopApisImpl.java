package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.PathParam;
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
import uigf.ApiResponseOrderStatus;
import uigf.ApiResponseShopGoods;
import uigf.commerce.CreateOrderRequest;
import uigf.commerce.ShopGoodsRequest;

/**
 * An instance of this class provides access to all the operations defined in ShopApis.
 */
public final class ShopApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ShopApisService service;

    /**
     * The service client containing this operation class.
     */
    private final CommerceClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of ShopApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ShopApisImpl(CommerceClientImpl client) {
        this.service = ShopApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for CommerceClientShopApis to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "CommerceClientShopApis", host = "{endpoint}")
    public interface ShopApisService {
        static ShopApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.ShopApisServiceImpl");
                return (ShopApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/{gameBiz}/mdk/shopwindow/shopwindow/fetchGoods",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseShopGoods> fetchGoods(@HostParam("endpoint") String endpoint,
            @PathParam("gameBiz") String gameBiz, @HeaderParam("Cookie") String cookie,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") ShopGoodsRequest body, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/{gameBiz}/mdk/atropos/api/createOrder",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> createOrder(@HostParam("endpoint") String endpoint,
            @PathParam("gameBiz") String gameBiz, @HeaderParam("Cookie") String cookie,
            @HeaderParam("x-rpc-device_id") String deviceId, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") CreateOrderRequest body,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/{gameBiz}/mdk/atropos/api/checkOrder",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseOrderStatus> checkOrder(@HostParam("endpoint") String endpoint,
            @PathParam("gameBiz") String gameBiz, @HeaderParam("Cookie") String cookie,
            @QueryParam("order_no") String orderNo, @QueryParam("game") String game,
            @QueryParam("region") String region, @QueryParam("uid") String uid, @HeaderParam("Accept") String accept,
            RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseShopGoods> fetchGoodsWithResponse(String gameBiz, ShopGoodsRequest body, String cookie,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Commerce.CN.ShopApi.fetchGoods", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.fetchGoods(this.client.getEndpoint(), gameBiz, cookie, contentType, accept, body,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> createOrderWithResponse(String gameBiz, String cookie, String deviceId,
        CreateOrderRequest body, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Commerce.CN.ShopApi.createOrder", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.createOrder(this.client.getEndpoint(), gameBiz, cookie, deviceId, contentType, accept,
                    body, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseOrderStatus> checkOrderWithResponse(String gameBiz, String orderNo, String game,
        String region, String uid, String cookie, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Commerce.CN.ShopApi.checkOrder", requestContext,
            updatedContext -> {
                final String accept = "application/json";
                return service.checkOrder(this.client.getEndpoint(), gameBiz, cookie, orderNo, game, region, uid,
                    accept, updatedContext);
            });
    }
}
