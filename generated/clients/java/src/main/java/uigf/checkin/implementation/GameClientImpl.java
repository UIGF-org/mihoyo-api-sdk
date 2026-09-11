package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the GameClient type.
 */
public final class GameClientImpl {
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
     * The PerformanceApisImpl object to access its operations.
     */
    private final PerformanceApisImpl performanceApis;

    /**
     * Gets the PerformanceApisImpl object to access its operations.
     * 
     * @return the PerformanceApisImpl object.
     */
    public PerformanceApisImpl getPerformanceApis() {
        return this.performanceApis;
    }

    /**
     * The GameTelemetryUploadApisImpl object to access its operations.
     */
    private final GameTelemetryUploadApisImpl gameTelemetryUploadApis;

    /**
     * Gets the GameTelemetryUploadApisImpl object to access its operations.
     * 
     * @return the GameTelemetryUploadApisImpl object.
     */
    public GameTelemetryUploadApisImpl getGameTelemetryUploadApis() {
        return this.gameTelemetryUploadApis;
    }

    /**
     * Initializes an instance of GameClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public GameClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.performanceApis = new PerformanceApisImpl(this);
        this.gameTelemetryUploadApis = new GameTelemetryUploadApisImpl(this);
    }
}
