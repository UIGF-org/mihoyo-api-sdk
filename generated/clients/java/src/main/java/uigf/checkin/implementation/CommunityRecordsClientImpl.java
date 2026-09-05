package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the CommunityRecordsClient type.
 */
public final class CommunityRecordsClientImpl {
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
     * The GlobalUserApisImpl object to access its operations.
     */
    private final GlobalUserApisImpl globalUserApis;

    /**
     * Gets the GlobalUserApisImpl object to access its operations.
     * 
     * @return the GlobalUserApisImpl object.
     */
    public GlobalUserApisImpl getGlobalUserApis() {
        return this.globalUserApis;
    }

    /**
     * The GenshinChallengeApisImpl object to access its operations.
     */
    private final GenshinChallengeApisImpl genshinChallengeApis;

    /**
     * Gets the GenshinChallengeApisImpl object to access its operations.
     * 
     * @return the GenshinChallengeApisImpl object.
     */
    public GenshinChallengeApisImpl getGenshinChallengeApis() {
        return this.genshinChallengeApis;
    }

    /**
     * The StarRailChallengeApisImpl object to access its operations.
     */
    private final StarRailChallengeApisImpl starRailChallengeApis;

    /**
     * Gets the StarRailChallengeApisImpl object to access its operations.
     * 
     * @return the StarRailChallengeApisImpl object.
     */
    public StarRailChallengeApisImpl getStarRailChallengeApis() {
        return this.starRailChallengeApis;
    }

    /**
     * The GlobalHonkaiImpactApisImpl object to access its operations.
     */
    private final GlobalHonkaiImpactApisImpl globalHonkaiImpactApis;

    /**
     * Gets the GlobalHonkaiImpactApisImpl object to access its operations.
     * 
     * @return the GlobalHonkaiImpactApisImpl object.
     */
    public GlobalHonkaiImpactApisImpl getGlobalHonkaiImpactApis() {
        return this.globalHonkaiImpactApis;
    }

    /**
     * Initializes an instance of CommunityRecordsClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public CommunityRecordsClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.globalUserApis = new GlobalUserApisImpl(this);
        this.genshinChallengeApis = new GenshinChallengeApisImpl(this);
        this.starRailChallengeApis = new StarRailChallengeApisImpl(this);
        this.globalHonkaiImpactApis = new GlobalHonkaiImpactApisImpl(this);
    }
}
