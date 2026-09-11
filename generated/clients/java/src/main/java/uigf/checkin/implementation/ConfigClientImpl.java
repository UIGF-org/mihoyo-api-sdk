package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the ConfigClient type.
 */
public final class ConfigClientImpl {
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
     * The GenshinSdkConfigApisImpl object to access its operations.
     */
    private final GenshinSdkConfigApisImpl genshinSdkConfigApis;

    /**
     * Gets the GenshinSdkConfigApisImpl object to access its operations.
     * 
     * @return the GenshinSdkConfigApisImpl object.
     */
    public GenshinSdkConfigApisImpl getGenshinSdkConfigApis() {
        return this.genshinSdkConfigApis;
    }

    /**
     * Initializes an instance of ConfigClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public ConfigClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.genshinSdkConfigApis = new GenshinSdkConfigApisImpl(this);
    }
}
