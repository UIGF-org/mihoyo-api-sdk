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
import uigf.ApiResponseJsonObject;

/**
 * An instance of this class provides access to all the operations defined in CardApis.
 */
public final class CardApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final CardApisService service;

    /**
     * The service client containing this operation class.
     */
    private final RecordClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CardApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    CardApisImpl(RecordClientImpl client) {
        this.service = CardApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for RecordClientCardApis to be used by the proxy service to perform REST
     * calls.
     */
    @ServiceInterface(name = "RecordClientCardApis", host = "{endpoint}")
    public interface CardApisService {
        static CardApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.CardApisServiceImpl");
                return (CardApisService) clazz.getMethod("getNewInstance", HttpPipeline.class).invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/game_record/app/card/wapi/getGameRecordCard",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getGameRecordCard(@HostParam("endpoint") String endpoint,
            @HeaderParam("Cookie") String cookie, @HeaderParam("DS") String ds, @QueryParam("uid") String uid,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getGameRecordCardWithResponse(String cookie, String ds, String uid,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Game.Genshin.Record.CardApi.getGameRecordCard",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getGameRecordCard(this.client.getEndpoint(), cookie, ds, uid, accept, updatedContext);
            });
    }
}
