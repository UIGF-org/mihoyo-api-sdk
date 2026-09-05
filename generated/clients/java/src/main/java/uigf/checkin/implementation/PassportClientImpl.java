package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the PassportClient type.
 */
public final class PassportClientImpl {
    /**
     * Service host.
     */
    private final String endpoint;

    /**
     * Gets Service host.
     * 
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /**
     * The HTTP pipeline to send requests through.
     */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     * 
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Gets The instance of instrumentation to report telemetry.
     * 
     * @return the instrumentation value.
     */
    public Instrumentation getInstrumentation() {
        return this.instrumentation;
    }

    /**
     * The AuthTicketApisImpl object to access its operations.
     */
    private final AuthTicketApisImpl authTicketApis;

    /**
     * Gets the AuthTicketApisImpl object to access its operations.
     * 
     * @return the AuthTicketApisImpl object.
     */
    public AuthTicketApisImpl getAuthTicketApis() {
        return this.authTicketApis;
    }

    /**
     * The CaptchaApisImpl object to access its operations.
     */
    private final CaptchaApisImpl captchaApis;

    /**
     * Gets the CaptchaApisImpl object to access its operations.
     * 
     * @return the CaptchaApisImpl object.
     */
    public CaptchaApisImpl getCaptchaApis() {
        return this.captchaApis;
    }

    /**
     * The QrLoginApisImpl object to access its operations.
     */
    private final QrLoginApisImpl qrLoginApis;

    /**
     * Gets the QrLoginApisImpl object to access its operations.
     * 
     * @return the QrLoginApisImpl object.
     */
    public QrLoginApisImpl getQrLoginApis() {
        return this.qrLoginApis;
    }

    /**
     * The PassportSessionApisImpl object to access its operations.
     */
    private final PassportSessionApisImpl passportSessionApis;

    /**
     * Gets the PassportSessionApisImpl object to access its operations.
     * 
     * @return the PassportSessionApisImpl object.
     */
    public PassportSessionApisImpl getPassportSessionApis() {
        return this.passportSessionApis;
    }

    /**
     * The AccountTokenApisImpl object to access its operations.
     */
    private final AccountTokenApisImpl accountTokenApis;

    /**
     * Gets the AccountTokenApisImpl object to access its operations.
     * 
     * @return the AccountTokenApisImpl object.
     */
    public AccountTokenApisImpl getAccountTokenApis() {
        return this.accountTokenApis;
    }

    /**
     * Initializes an instance of PassportClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public PassportClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.authTicketApis = new AuthTicketApisImpl(this);
        this.captchaApis = new CaptchaApisImpl(this);
        this.qrLoginApis = new QrLoginApisImpl(this);
        this.passportSessionApis = new PassportSessionApisImpl(this);
        this.accountTokenApis = new AccountTokenApisImpl(this);
    }
}
