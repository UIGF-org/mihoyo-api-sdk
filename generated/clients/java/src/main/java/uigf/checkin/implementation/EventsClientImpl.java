package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the EventsClient type.
 */
public final class EventsClientImpl {
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
     * The CnStarRailLedgerApisImpl object to access its operations.
     */
    private final CnStarRailLedgerApisImpl cnStarRailLedgerApis;

    /**
     * Gets the CnStarRailLedgerApisImpl object to access its operations.
     * 
     * @return the CnStarRailLedgerApisImpl object.
     */
    public CnStarRailLedgerApisImpl getCnStarRailLedgerApis() {
        return this.cnStarRailLedgerApis;
    }

    /**
     * The CnZenlessLedgerApisImpl object to access its operations.
     */
    private final CnZenlessLedgerApisImpl cnZenlessLedgerApis;

    /**
     * Gets the CnZenlessLedgerApisImpl object to access its operations.
     * 
     * @return the CnZenlessLedgerApisImpl object.
     */
    public CnZenlessLedgerApisImpl getCnZenlessLedgerApis() {
        return this.cnZenlessLedgerApis;
    }

    /**
     * The CnZenlessCultivationApisImpl object to access its operations.
     */
    private final CnZenlessCultivationApisImpl cnZenlessCultivationApis;

    /**
     * Gets the CnZenlessCultivationApisImpl object to access its operations.
     * 
     * @return the CnZenlessCultivationApisImpl object.
     */
    public CnZenlessCultivationApisImpl getCnZenlessCultivationApis() {
        return this.cnZenlessCultivationApis;
    }

    /**
     * Initializes an instance of EventsClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public EventsClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.cnStarRailLedgerApis = new CnStarRailLedgerApisImpl(this);
        this.cnZenlessLedgerApis = new CnZenlessLedgerApisImpl(this);
        this.cnZenlessCultivationApis = new CnZenlessCultivationApisImpl(this);
    }
}
