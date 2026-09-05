package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the GameAccountClient type.
 */
public final class GameAccountClientImpl {
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
     * The GameTokenApisImpl object to access its operations.
     */
    private final GameTokenApisImpl gameTokenApis;

    /**
     * Gets the GameTokenApisImpl object to access its operations.
     * 
     * @return the GameTokenApisImpl object.
     */
    public GameTokenApisImpl getGameTokenApis() {
        return this.gameTokenApis;
    }

    /**
     * The ActionTicketApisImpl object to access its operations.
     */
    private final ActionTicketApisImpl actionTicketApis;

    /**
     * Gets the ActionTicketApisImpl object to access its operations.
     * 
     * @return the ActionTicketApisImpl object.
     */
    public ActionTicketApisImpl getActionTicketApis() {
        return this.actionTicketApis;
    }

    /**
     * The GameBindingApisImpl object to access its operations.
     */
    private final GameBindingApisImpl gameBindingApis;

    /**
     * Gets the GameBindingApisImpl object to access its operations.
     * 
     * @return the GameBindingApisImpl object.
     */
    public GameBindingApisImpl getGameBindingApis() {
        return this.gameBindingApis;
    }

    /**
     * The GenshinObcApisImpl object to access its operations.
     */
    private final GenshinObcApisImpl genshinObcApis;

    /**
     * Gets the GenshinObcApisImpl object to access its operations.
     * 
     * @return the GenshinObcApisImpl object.
     */
    public GenshinObcApisImpl getGenshinObcApis() {
        return this.genshinObcApis;
    }

    /**
     * The CultivationApisImpl object to access its operations.
     */
    private final CultivationApisImpl cultivationApis;

    /**
     * Gets the CultivationApisImpl object to access its operations.
     * 
     * @return the CultivationApisImpl object.
     */
    public CultivationApisImpl getCultivationApis() {
        return this.cultivationApis;
    }

    /**
     * Initializes an instance of GameAccountClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public GameAccountClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.gameTokenApis = new GameTokenApisImpl(this);
        this.actionTicketApis = new ActionTicketApisImpl(this);
        this.gameBindingApis = new GameBindingApisImpl(this);
        this.genshinObcApis = new GenshinObcApisImpl(this);
        this.cultivationApis = new CultivationApisImpl(this);
    }
}
