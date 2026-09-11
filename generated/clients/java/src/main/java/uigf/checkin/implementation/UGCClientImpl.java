package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the UGCClient type.
 */
public final class UGCClientImpl {
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
     * The TokenApisImpl object to access its operations.
     */
    private final TokenApisImpl tokenApis;

    /**
     * Gets the TokenApisImpl object to access its operations.
     * 
     * @return the TokenApisImpl object.
     */
    public TokenApisImpl getTokenApis() {
        return this.tokenApis;
    }

    /**
     * The LevelApisImpl object to access its operations.
     */
    private final LevelApisImpl levelApis;

    /**
     * Gets the LevelApisImpl object to access its operations.
     * 
     * @return the LevelApisImpl object.
     */
    public LevelApisImpl getLevelApis() {
        return this.levelApis;
    }

    /**
     * Initializes an instance of UGCClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public UGCClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.tokenApis = new TokenApisImpl(this);
        this.levelApis = new LevelApisImpl(this);
    }
}
