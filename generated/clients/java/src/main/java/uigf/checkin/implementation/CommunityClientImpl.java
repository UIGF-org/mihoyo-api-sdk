package uigf.checkin.implementation;

import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;

/**
 * Initializes a new instance of the CommunityClient type.
 */
public final class CommunityClientImpl {
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
     * The CommunityUserApisImpl object to access its operations.
     */
    private final CommunityUserApisImpl communityUserApis;

    /**
     * Gets the CommunityUserApisImpl object to access its operations.
     * 
     * @return the CommunityUserApisImpl object.
     */
    public CommunityUserApisImpl getCommunityUserApis() {
        return this.communityUserApis;
    }

    /**
     * The MiscApisImpl object to access its operations.
     */
    private final MiscApisImpl miscApis;

    /**
     * Gets the MiscApisImpl object to access its operations.
     * 
     * @return the MiscApisImpl object.
     */
    public MiscApisImpl getMiscApis() {
        return this.miscApis;
    }

    /**
     * The CollectionApisImpl object to access its operations.
     */
    private final CollectionApisImpl collectionApis;

    /**
     * Gets the CollectionApisImpl object to access its operations.
     * 
     * @return the CollectionApisImpl object.
     */
    public CollectionApisImpl getCollectionApis() {
        return this.collectionApis;
    }

    /**
     * The CoinRecordApisImpl object to access its operations.
     */
    private final CoinRecordApisImpl coinRecordApis;

    /**
     * Gets the CoinRecordApisImpl object to access its operations.
     * 
     * @return the CoinRecordApisImpl object.
     */
    public CoinRecordApisImpl getCoinRecordApis() {
        return this.coinRecordApis;
    }

    /**
     * The PostApisImpl object to access its operations.
     */
    private final PostApisImpl postApis;

    /**
     * Gets the PostApisImpl object to access its operations.
     * 
     * @return the PostApisImpl object.
     */
    public PostApisImpl getPostApis() {
        return this.postApis;
    }

    /**
     * The FeedApisImpl object to access its operations.
     */
    private final FeedApisImpl feedApis;

    /**
     * Gets the FeedApisImpl object to access its operations.
     * 
     * @return the FeedApisImpl object.
     */
    public FeedApisImpl getFeedApis() {
        return this.feedApis;
    }

    /**
     * The TopicApisImpl object to access its operations.
     */
    private final TopicApisImpl topicApis;

    /**
     * Gets the TopicApisImpl object to access its operations.
     * 
     * @return the TopicApisImpl object.
     */
    public TopicApisImpl getTopicApis() {
        return this.topicApis;
    }

    /**
     * The ApiHubsImpl object to access its operations.
     */
    private final ApiHubsImpl apiHubs;

    /**
     * Gets the ApiHubsImpl object to access its operations.
     * 
     * @return the ApiHubsImpl object.
     */
    public ApiHubsImpl getApiHubs() {
        return this.apiHubs;
    }

    /**
     * Initializes an instance of CommunityClient client.
     * 
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param instrumentation The instance of instrumentation to report telemetry.
     * @param endpoint Service host.
     */
    public CommunityClientImpl(HttpPipeline httpPipeline, Instrumentation instrumentation, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.instrumentation = instrumentation;
        this.endpoint = endpoint;
        this.communityUserApis = new CommunityUserApisImpl(this);
        this.miscApis = new MiscApisImpl(this);
        this.collectionApis = new CollectionApisImpl(this);
        this.coinRecordApis = new CoinRecordApisImpl(this);
        this.postApis = new PostApisImpl(this);
        this.feedApis = new FeedApisImpl(this);
        this.topicApis = new TopicApisImpl(this);
        this.apiHubs = new ApiHubsImpl(this);
    }
}
