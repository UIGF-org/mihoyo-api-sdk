package uigf.game.global.records;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ServiceClientBuilder;
import io.clientcore.core.http.client.HttpClient;
import io.clientcore.core.http.models.ProxyOptions;
import io.clientcore.core.http.pipeline.HttpInstrumentationOptions;
import io.clientcore.core.http.pipeline.HttpInstrumentationPolicy;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.http.pipeline.HttpPipelineBuilder;
import io.clientcore.core.http.pipeline.HttpPipelinePolicy;
import io.clientcore.core.http.pipeline.HttpRedirectOptions;
import io.clientcore.core.http.pipeline.HttpRedirectPolicy;
import io.clientcore.core.http.pipeline.HttpRetryOptions;
import io.clientcore.core.http.pipeline.HttpRetryPolicy;
import io.clientcore.core.instrumentation.Instrumentation;
import io.clientcore.core.instrumentation.SdkInstrumentationOptions;
import io.clientcore.core.traits.ConfigurationTrait;
import io.clientcore.core.traits.EndpointTrait;
import io.clientcore.core.traits.HttpTrait;
import io.clientcore.core.traits.ProxyTrait;
import io.clientcore.core.utils.CoreUtils;
import io.clientcore.core.utils.configuration.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import uigf.checkin.implementation.GlobalGameRecordsClientImpl;

/**
 * A builder for creating a new instance of the GlobalGameRecordsClient type.
 */
@ServiceClientBuilder(
    serviceClients = {
        GlobalGameRecordApiClient.class,
        ZenlessGameRecordApiClient.class,
        GlobalZenlessCultivationApiClient.class,
        GlobalStarRailLedgerApiClient.class,
        GlobalZenlessLedgerApiClient.class })
public final class GlobalGameRecordsClientBuilder
    implements HttpTrait<GlobalGameRecordsClientBuilder>, ProxyTrait<GlobalGameRecordsClientBuilder>,
    ConfigurationTrait<GlobalGameRecordsClientBuilder>, EndpointTrait<GlobalGameRecordsClientBuilder> {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private static final String SDK_NAME = "name";

    @Metadata(properties = { MetadataProperties.GENERATED })
    private static final String SDK_VERSION = "version";

    @Metadata(properties = { MetadataProperties.GENERATED })
    private static final Map<String, String> PROPERTIES = CoreUtils.getProperties("uigf-checkin.properties");

    @Metadata(properties = { MetadataProperties.GENERATED })
    private final List<HttpPipelinePolicy> pipelinePolicies;

    /**
     * Create an instance of the GlobalGameRecordsClientBuilder.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GlobalGameRecordsClientBuilder() {
        this.pipelinePolicies = new ArrayList<>();
    }

    /*
     * The HTTP client used to send the request.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private HttpClient httpClient;

    /**
     * {@inheritDoc}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public GlobalGameRecordsClientBuilder httpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    /*
     * The retry options to configure retry policy for failed requests.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private HttpRetryOptions retryOptions;

    /**
     * {@inheritDoc}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public GlobalGameRecordsClientBuilder httpRetryOptions(HttpRetryOptions retryOptions) {
        this.retryOptions = retryOptions;
        return this;
    }

    /**
     * {@inheritDoc}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public GlobalGameRecordsClientBuilder addHttpPipelinePolicy(HttpPipelinePolicy customPolicy) {
        Objects.requireNonNull(customPolicy, "'customPolicy' cannot be null.");
        pipelinePolicies.add(customPolicy);
        return this;
    }

    /*
     * The redirect options to configure redirect policy
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private HttpRedirectOptions redirectOptions;

    /**
     * {@inheritDoc}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public GlobalGameRecordsClientBuilder httpRedirectOptions(HttpRedirectOptions redirectOptions) {
        this.redirectOptions = redirectOptions;
        return this;
    }

    /*
     * The instrumentation configuration for HTTP requests and responses.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private HttpInstrumentationOptions httpInstrumentationOptions;

    /**
     * {@inheritDoc}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public GlobalGameRecordsClientBuilder
        httpInstrumentationOptions(HttpInstrumentationOptions httpInstrumentationOptions) {
        this.httpInstrumentationOptions = httpInstrumentationOptions;
        return this;
    }

    /*
     * The proxy options used during construction of the service client.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private ProxyOptions proxyOptions;

    /**
     * {@inheritDoc}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public GlobalGameRecordsClientBuilder proxyOptions(ProxyOptions proxyOptions) {
        this.proxyOptions = proxyOptions;
        return this;
    }

    /*
     * The configuration store that is used during construction of the service client.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private Configuration configuration;

    /**
     * {@inheritDoc}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public GlobalGameRecordsClientBuilder configuration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    /*
     * The service endpoint
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String endpoint;

    /**
     * {@inheritDoc}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public GlobalGameRecordsClientBuilder endpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Builds an instance of GlobalGameRecordsClientImpl with the provided parameters.
     * 
     * @return an instance of GlobalGameRecordsClientImpl.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private GlobalGameRecordsClientImpl buildInnerClient() {
        this.validateClient();
        String localEndpoint = (endpoint != null) ? endpoint : "https://passport-api.mihoyo.com";
        HttpInstrumentationOptions localHttpInstrumentationOptions = this.httpInstrumentationOptions == null
            ? new HttpInstrumentationOptions()
            : this.httpInstrumentationOptions;
        SdkInstrumentationOptions sdkInstrumentationOptions
            = new SdkInstrumentationOptions(PROPERTIES.getOrDefault(SDK_NAME, "UnknownName"))
                .setSdkVersion(PROPERTIES.get(SDK_VERSION))
                .setEndpoint(localEndpoint);
        Instrumentation instrumentation
            = Instrumentation.create(localHttpInstrumentationOptions, sdkInstrumentationOptions);
        GlobalGameRecordsClientImpl client
            = new GlobalGameRecordsClientImpl(createHttpPipeline(), instrumentation, localEndpoint);
        return client;
    }

    @Metadata(properties = { MetadataProperties.GENERATED })
    private void validateClient() {
        // This method is invoked from 'buildInnerClient'/'buildClient' method.
        // Developer can customize this method, to validate that the necessary conditions are met for the new client.
    }

    @Metadata(properties = { MetadataProperties.GENERATED })
    private HttpPipeline createHttpPipeline() {
        Configuration buildConfiguration
            = (configuration == null) ? Configuration.getGlobalConfiguration() : configuration;
        HttpInstrumentationOptions localHttpInstrumentationOptions = this.httpInstrumentationOptions == null
            ? new HttpInstrumentationOptions()
            : this.httpInstrumentationOptions;
        HttpPipelineBuilder httpPipelineBuilder = new HttpPipelineBuilder();
        List<HttpPipelinePolicy> policies = new ArrayList<>();
        policies.add(redirectOptions == null ? new HttpRedirectPolicy() : new HttpRedirectPolicy(redirectOptions));
        policies.add(retryOptions == null ? new HttpRetryPolicy() : new HttpRetryPolicy(retryOptions));
        this.pipelinePolicies.stream().forEach(p -> policies.add(p));
        policies.add(new HttpInstrumentationPolicy(localHttpInstrumentationOptions));
        policies.forEach(httpPipelineBuilder::addPolicy);
        return httpPipelineBuilder.httpClient(httpClient).build();
    }

    /**
     * Builds an instance of GlobalGameRecordApiClient class.
     * 
     * @return an instance of GlobalGameRecordApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GlobalGameRecordApiClient buildGlobalGameRecordApiClient() {
        GlobalGameRecordsClientImpl innerClient = buildInnerClient();
        return new GlobalGameRecordApiClient(innerClient.getGlobalGameRecordApis(), innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of ZenlessGameRecordApiClient class.
     * 
     * @return an instance of ZenlessGameRecordApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public ZenlessGameRecordApiClient buildZenlessGameRecordApiClient() {
        GlobalGameRecordsClientImpl innerClient = buildInnerClient();
        return new ZenlessGameRecordApiClient(innerClient.getZenlessGameRecordApis(), innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of GlobalZenlessCultivationApiClient class.
     * 
     * @return an instance of GlobalZenlessCultivationApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GlobalZenlessCultivationApiClient buildGlobalZenlessCultivationApiClient() {
        GlobalGameRecordsClientImpl innerClient = buildInnerClient();
        return new GlobalZenlessCultivationApiClient(innerClient.getGlobalZenlessCultivationApis(),
            innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of GlobalStarRailLedgerApiClient class.
     * 
     * @return an instance of GlobalStarRailLedgerApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GlobalStarRailLedgerApiClient buildGlobalStarRailLedgerApiClient() {
        GlobalGameRecordsClientImpl innerClient = buildInnerClient();
        return new GlobalStarRailLedgerApiClient(innerClient.getGlobalStarRailLedgerApis(),
            innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of GlobalZenlessLedgerApiClient class.
     * 
     * @return an instance of GlobalZenlessLedgerApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public GlobalZenlessLedgerApiClient buildGlobalZenlessLedgerApiClient() {
        GlobalGameRecordsClientImpl innerClient = buildInnerClient();
        return new GlobalZenlessLedgerApiClient(innerClient.getGlobalZenlessLedgerApis(),
            innerClient.getInstrumentation());
    }
}
