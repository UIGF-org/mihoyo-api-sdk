package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import uigf.ApiResponseQrLoginStatus;
import uigf.ApiResponseQrLoginTicket;
import uigf.ApiResponseTokenInfo;
import uigf.passport.MobileCaptchaLoginRequest;
import uigf.passport.QrLoginCreateRequest;
import uigf.passport.QrLoginStatusRequest;

/**
 * An instance of this class provides access to all the operations defined in QrLoginApis.
 */
public final class QrLoginApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final QrLoginApisService service;

    /**
     * The service client containing this operation class.
     */
    private final PassportClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of QrLoginApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    QrLoginApisImpl(PassportClientImpl client) {
        this.service = QrLoginApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for PassportClientQrLoginApis to be used by the proxy service to perform
     * REST calls.
     */
    @ServiceInterface(name = "PassportClientQrLoginApis", host = "{endpoint}")
    public interface QrLoginApisService {
        static QrLoginApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.QrLoginApisServiceImpl");
                return (QrLoginApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/account/ma-cn-passport/app/createQRLogin",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseQrLoginTicket> create(@HostParam("endpoint") String endpoint,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") QrLoginCreateRequest body, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/account/ma-cn-passport/app/queryQRLoginStatus",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseQrLoginStatus> getStatus(@HostParam("endpoint") String endpoint,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") QrLoginStatusRequest body, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/account/ma-cn-passport/app/loginByMobileCaptcha",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseTokenInfo> loginByMobileCaptcha(@HostParam("endpoint") String endpoint,
            @HeaderParam("Content-Type") String contentType, @HeaderParam("Accept") String accept,
            @BodyParam("application/json") MobileCaptchaLoginRequest body, RequestContext requestContext);
    }

    /**
     * Creates an official QR login ticket.
     * 
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseQrLoginTicket> createWithResponse(QrLoginCreateRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.QrLoginApi.create", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.create(this.client.getEndpoint(), contentType, accept, body, updatedContext);
            });
    }

    /**
     * Queries an official QR login ticket.
     * 
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseQrLoginStatus> getStatusWithResponse(QrLoginStatusRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.QrLoginApi.getStatus", requestContext,
            updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.getStatus(this.client.getEndpoint(), contentType, accept, body, updatedContext);
            });
    }

    /**
     * Logs in with a mobile-number captcha obtained through the official flow.
     * 
     * @param body The body parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseTokenInfo> loginByMobileCaptchaWithResponse(MobileCaptchaLoginRequest body,
        RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Passport.QrLoginApi.loginByMobileCaptcha",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                return service.loginByMobileCaptcha(this.client.getEndpoint(), contentType, accept, body,
                    updatedContext);
            });
    }
}
