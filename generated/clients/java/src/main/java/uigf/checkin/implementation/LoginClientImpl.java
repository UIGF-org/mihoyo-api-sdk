package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the LoginClient type.
 */
public final class LoginClientImpl {
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
     * The PandaQrApisImpl object to access its operations.
     */
    private final PandaQrApisImpl pandaQrApis;

    /**
     * Gets the PandaQrApisImpl object to access its operations.
     * 
     * @return the PandaQrApisImpl object.
     */
    public PandaQrApisImpl getPandaQrApis() {
        return this.pandaQrApis;
    }

    /**
     * The GranterApisImpl object to access its operations.
     */
    private final GranterApisImpl granterApis;

    /**
     * Gets the GranterApisImpl object to access its operations.
     * 
     * @return the GranterApisImpl object.
     */
    public GranterApisImpl getGranterApis() {
        return this.granterApis;
    }

    /**
     * Initializes an instance of LoginClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public LoginClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.pandaQrApis = new PandaQrApisImpl(this);
        this.granterApis = new GranterApisImpl(this);
    }
}
