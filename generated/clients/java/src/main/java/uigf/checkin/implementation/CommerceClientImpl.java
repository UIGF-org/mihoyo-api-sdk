package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the CommerceClient type.
 */
public final class CommerceClientImpl {
    /**
     * Complete game SDK origin, for example `https://hk4e-sdk.mihoyo.com`.
     */
    private final String endpoint;

    /**
     * Gets Complete game SDK origin, for example `https://hk4e-sdk.mihoyo.com`.
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
     * The ShopApisImpl object to access its operations.
     */
    private final ShopApisImpl shopApis;

    /**
     * Gets the ShopApisImpl object to access its operations.
     * 
     * @return the ShopApisImpl object.
     */
    public ShopApisImpl getShopApis() {
        return this.shopApis;
    }

    /**
     * Initializes an instance of CommerceClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Complete game SDK origin, for example `https://hk4e-sdk.mihoyo.com`.
     */
    public CommerceClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.shopApis = new ShopApisImpl(this);
    }
}
