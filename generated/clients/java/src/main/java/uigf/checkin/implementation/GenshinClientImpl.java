package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the GenshinClient type.
 */
public final class GenshinClientImpl {
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
     * The GlobalAnnouncementApisImpl object to access its operations.
     */
    private final GlobalAnnouncementApisImpl globalAnnouncementApis;

    /**
     * Gets the GlobalAnnouncementApisImpl object to access its operations.
     * 
     * @return the GlobalAnnouncementApisImpl object.
     */
    public GlobalAnnouncementApisImpl getGlobalAnnouncementApis() {
        return this.globalAnnouncementApis;
    }

    /**
     * The GlobalGenshinLedgerApisImpl object to access its operations.
     */
    private final GlobalGenshinLedgerApisImpl globalGenshinLedgerApis;

    /**
     * Gets the GlobalGenshinLedgerApisImpl object to access its operations.
     * 
     * @return the GlobalGenshinLedgerApisImpl object.
     */
    public GlobalGenshinLedgerApisImpl getGlobalGenshinLedgerApis() {
        return this.globalGenshinLedgerApis;
    }

    /**
     * Initializes an instance of GenshinClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public GenshinClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.globalAnnouncementApis = new GlobalAnnouncementApisImpl(this);
        this.globalGenshinLedgerApis = new GlobalGenshinLedgerApisImpl(this);
    }
}
