package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the GlobalGameRecordsClient type.
 */
public final class GlobalGameRecordsClientImpl {
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
     * The GlobalGameRecordApisImpl object to access its operations.
     */
    private final GlobalGameRecordApisImpl globalGameRecordApis;

    /**
     * Gets the GlobalGameRecordApisImpl object to access its operations.
     * 
     * @return the GlobalGameRecordApisImpl object.
     */
    public GlobalGameRecordApisImpl getGlobalGameRecordApis() {
        return this.globalGameRecordApis;
    }

    /**
     * The ZenlessGameRecordApisImpl object to access its operations.
     */
    private final ZenlessGameRecordApisImpl zenlessGameRecordApis;

    /**
     * Gets the ZenlessGameRecordApisImpl object to access its operations.
     * 
     * @return the ZenlessGameRecordApisImpl object.
     */
    public ZenlessGameRecordApisImpl getZenlessGameRecordApis() {
        return this.zenlessGameRecordApis;
    }

    /**
     * The GlobalZenlessCultivationApisImpl object to access its operations.
     */
    private final GlobalZenlessCultivationApisImpl globalZenlessCultivationApis;

    /**
     * Gets the GlobalZenlessCultivationApisImpl object to access its operations.
     * 
     * @return the GlobalZenlessCultivationApisImpl object.
     */
    public GlobalZenlessCultivationApisImpl getGlobalZenlessCultivationApis() {
        return this.globalZenlessCultivationApis;
    }

    /**
     * The GlobalStarRailLedgerApisImpl object to access its operations.
     */
    private final GlobalStarRailLedgerApisImpl globalStarRailLedgerApis;

    /**
     * Gets the GlobalStarRailLedgerApisImpl object to access its operations.
     * 
     * @return the GlobalStarRailLedgerApisImpl object.
     */
    public GlobalStarRailLedgerApisImpl getGlobalStarRailLedgerApis() {
        return this.globalStarRailLedgerApis;
    }

    /**
     * The GlobalZenlessLedgerApisImpl object to access its operations.
     */
    private final GlobalZenlessLedgerApisImpl globalZenlessLedgerApis;

    /**
     * Gets the GlobalZenlessLedgerApisImpl object to access its operations.
     * 
     * @return the GlobalZenlessLedgerApisImpl object.
     */
    public GlobalZenlessLedgerApisImpl getGlobalZenlessLedgerApis() {
        return this.globalZenlessLedgerApis;
    }

    /**
     * Initializes an instance of GlobalGameRecordsClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public GlobalGameRecordsClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.globalGameRecordApis = new GlobalGameRecordApisImpl(this);
        this.zenlessGameRecordApis = new ZenlessGameRecordApisImpl(this);
        this.globalZenlessCultivationApis = new GlobalZenlessCultivationApisImpl(this);
        this.globalStarRailLedgerApis = new GlobalStarRailLedgerApisImpl(this);
        this.globalZenlessLedgerApis = new GlobalZenlessLedgerApisImpl(this);
    }
}
