package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the RecordClient type.
 */
public final class RecordClientImpl {
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
     * The GenshinRecordApisImpl object to access its operations.
     */
    private final GenshinRecordApisImpl genshinRecordApis;

    /**
     * Gets the GenshinRecordApisImpl object to access its operations.
     * 
     * @return the GenshinRecordApisImpl object.
     */
    public GenshinRecordApisImpl getGenshinRecordApis() {
        return this.genshinRecordApis;
    }

    /**
     * The CardApisImpl object to access its operations.
     */
    private final CardApisImpl cardApis;

    /**
     * Gets the CardApisImpl object to access its operations.
     * 
     * @return the CardApisImpl object.
     */
    public CardApisImpl getCardApis() {
        return this.cardApis;
    }

    /**
     * Initializes an instance of RecordClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public RecordClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.genshinRecordApis = new GenshinRecordApisImpl(this);
        this.cardApis = new CardApisImpl(this);
    }
}
