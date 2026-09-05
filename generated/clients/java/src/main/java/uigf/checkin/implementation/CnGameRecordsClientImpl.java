package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the CnGameRecordsClient type.
 */
public final class CnGameRecordsClientImpl {
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
     * The CnHonkaiImpactApisImpl object to access its operations.
     */
    private final CnHonkaiImpactApisImpl cnHonkaiImpactApis;

    /**
     * Gets the CnHonkaiImpactApisImpl object to access its operations.
     * 
     * @return the CnHonkaiImpactApisImpl object.
     */
    public CnHonkaiImpactApisImpl getCnHonkaiImpactApis() {
        return this.cnHonkaiImpactApis;
    }

    /**
     * The StarRailApisImpl object to access its operations.
     */
    private final StarRailApisImpl starRailApis;

    /**
     * Gets the StarRailApisImpl object to access its operations.
     * 
     * @return the StarRailApisImpl object.
     */
    public StarRailApisImpl getStarRailApis() {
        return this.starRailApis;
    }

    /**
     * The ZenlessApisImpl object to access its operations.
     */
    private final ZenlessApisImpl zenlessApis;

    /**
     * Gets the ZenlessApisImpl object to access its operations.
     * 
     * @return the ZenlessApisImpl object.
     */
    public ZenlessApisImpl getZenlessApis() {
        return this.zenlessApis;
    }

    /**
     * Initializes an instance of CnGameRecordsClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public CnGameRecordsClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.cnHonkaiImpactApis = new CnHonkaiImpactApisImpl(this);
        this.starRailApis = new StarRailApisImpl(this);
        this.zenlessApis = new ZenlessApisImpl(this);
    }
}
