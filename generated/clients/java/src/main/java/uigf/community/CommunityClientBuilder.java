package uigf.community;

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
import uigf.checkin.implementation.CommunityClientImpl;

/**
 * A builder for creating a new instance of the CommunityClient type.
 */
@ServiceClientBuilder(
    serviceClients = {
        CommunityUserApiClient.class,
        MiscApiClient.class,
        CollectionApiClient.class,
        CoinRecordApiClient.class,
        PostApiClient.class,
        FeedApiClient.class,
        TopicApiClient.class,
        ApiHubClient.class })
public final class CommunityClientBuilder
    implements HttpTrait<CommunityClientBuilder>, ProxyTrait<CommunityClientBuilder>,
    ConfigurationTrait<CommunityClientBuilder>, EndpointTrait<CommunityClientBuilder> {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private static final String SDK_NAME = "name";

    @Metadata(properties = { MetadataProperties.GENERATED })
    private static final String SDK_VERSION = "version";

    @Metadata(properties = { MetadataProperties.GENERATED })
    private static final Map<String, String> PROPERTIES = CoreUtils.getProperties("uigf-checkin.properties");

    @Metadata(properties = { MetadataProperties.GENERATED })
    private final List<HttpPipelinePolicy> pipelinePolicies;

    /**
     * Create an instance of the CommunityClientBuilder.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CommunityClientBuilder() {
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
    public CommunityClientBuilder httpClient(HttpClient httpClient) {
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
    public CommunityClientBuilder httpRetryOptions(HttpRetryOptions retryOptions) {
        this.retryOptions = retryOptions;
        return this;
    }

    /**
     * {@inheritDoc}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public CommunityClientBuilder addHttpPipelinePolicy(HttpPipelinePolicy customPolicy) {
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
    public CommunityClientBuilder httpRedirectOptions(HttpRedirectOptions redirectOptions) {
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
    public CommunityClientBuilder httpInstrumentationOptions(HttpInstrumentationOptions httpInstrumentationOptions) {
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
    public CommunityClientBuilder proxyOptions(ProxyOptions proxyOptions) {
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
    public CommunityClientBuilder configuration(Configuration configuration) {
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
    public CommunityClientBuilder endpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Builds an instance of CommunityClientImpl with the provided parameters.
     * 
     * @return an instance of CommunityClientImpl.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private CommunityClientImpl buildInnerClient() {
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
        CommunityClientImpl client = new CommunityClientImpl(createHttpPipeline(), instrumentation, localEndpoint);
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
     * Builds an instance of CommunityUserApiClient class.
     * 
     * @return an instance of CommunityUserApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CommunityUserApiClient buildCommunityUserApiClient() {
        CommunityClientImpl innerClient = buildInnerClient();
        return new CommunityUserApiClient(innerClient.getCommunityUserApis(), innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of MiscApiClient class.
     * 
     * @return an instance of MiscApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public MiscApiClient buildMiscApiClient() {
        CommunityClientImpl innerClient = buildInnerClient();
        return new MiscApiClient(innerClient.getMiscApis(), innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of CollectionApiClient class.
     * 
     * @return an instance of CollectionApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CollectionApiClient buildCollectionApiClient() {
        CommunityClientImpl innerClient = buildInnerClient();
        return new CollectionApiClient(innerClient.getCollectionApis(), innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of CoinRecordApiClient class.
     * 
     * @return an instance of CoinRecordApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public CoinRecordApiClient buildCoinRecordApiClient() {
        CommunityClientImpl innerClient = buildInnerClient();
        return new CoinRecordApiClient(innerClient.getCoinRecordApis(), innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of PostApiClient class.
     * 
     * @return an instance of PostApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public PostApiClient buildPostApiClient() {
        CommunityClientImpl innerClient = buildInnerClient();
        return new PostApiClient(innerClient.getPostApis(), innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of FeedApiClient class.
     * 
     * @return an instance of FeedApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public FeedApiClient buildFeedApiClient() {
        CommunityClientImpl innerClient = buildInnerClient();
        return new FeedApiClient(innerClient.getFeedApis(), innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of TopicApiClient class.
     * 
     * @return an instance of TopicApiClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public TopicApiClient buildTopicApiClient() {
        CommunityClientImpl innerClient = buildInnerClient();
        return new TopicApiClient(innerClient.getTopicApis(), innerClient.getInstrumentation());
    }

    /**
     * Builds an instance of ApiHubClient class.
     * 
     * @return an instance of ApiHubClient.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public ApiHubClient buildApiHubClient() {
        CommunityClientImpl innerClient = buildInnerClient();
        return new ApiHubClient(innerClient.getApiHubs(), innerClient.getInstrumentation());
    }
}
