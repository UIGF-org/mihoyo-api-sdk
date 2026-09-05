package uigf.launcher.global;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import java.util.List;
import uigf.LauncherResponseGameBasicInfo;
import uigf.LauncherResponseJsonObject;
import uigf.checkin.implementation.GlobalLauncherMetadataApisImpl;
import uigf.launcher.DxConfigRequest;

/**
 * Initializes a new instance of the synchronous GlobalLauncherClient type.
 */
@ServiceClient(builder = GlobalLauncherClientBuilder.class)
public final class GlobalLauncherClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GlobalLauncherMetadataApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalLauncherClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GlobalLauncherClient(GlobalLauncherMetadataApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getAllGameBasicInfo operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseGameBasicInfo> getAllGameBasicInfoWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getAllGameBasicInfo",
            requestContext, updatedContext -> this.serviceClient.getAllGameBasicInfoWithResponse(launcherId, language,
                gameIds, updatedContext));
    }

    /**
     * The getAllGameBasicInfo operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseGameBasicInfo getAllGameBasicInfo(String launcherId, String language, List<String> gameIds) {
        return getAllGameBasicInfoWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getAllGameBasicInfo operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseGameBasicInfo getAllGameBasicInfo(String launcherId, String language) {
        final List<String> gameIds = null;
        return getAllGameBasicInfoWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getGamePackages operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGamePackagesWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGamePackages",
            requestContext, updatedContext -> this.serviceClient.getGamePackagesWithResponse(launcherId, language,
                gameIds, updatedContext));
    }

    /**
     * The getGamePackages operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGamePackages(String launcherId, String language, List<String> gameIds) {
        return getGamePackagesWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getGamePackages operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGamePackages(String launcherId, String language) {
        final List<String> gameIds = null;
        return getGamePackagesWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getGameChannelSdks operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param channel The channel parameter.
     * @param subChannel The subChannel parameter.
     * @param gameIds The gameIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGameChannelSdksWithResponse(String launcherId, String language,
        Integer channel, Integer subChannel, List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGameChannelSdks",
            requestContext, updatedContext -> this.serviceClient.getGameChannelSdksWithResponse(launcherId, language,
                channel, subChannel, gameIds, updatedContext));
    }

    /**
     * The getGameChannelSdks operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param channel The channel parameter.
     * @param subChannel The subChannel parameter.
     * @param gameIds The gameIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGameChannelSdks(String launcherId, String language, Integer channel,
        Integer subChannel, List<String> gameIds) {
        return getGameChannelSdksWithResponse(launcherId, language, channel, subChannel, gameIds, RequestContext.none())
            .getValue();
    }

    /**
     * The getGameChannelSdks operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGameChannelSdks(String launcherId, String language) {
        final Integer channel = null;
        final Integer subChannel = null;
        final List<String> gameIds = null;
        return getGameChannelSdksWithResponse(launcherId, language, channel, subChannel, gameIds, RequestContext.none())
            .getValue();
    }

    /**
     * The getDeprecatedFileConfigs operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param channel The channel parameter.
     * @param subChannel The subChannel parameter.
     * @param gameIds The gameIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getDeprecatedFileConfigsWithResponse(String launcherId, String language,
        Integer channel, Integer subChannel, List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getDeprecatedFileConfigs",
            requestContext, updatedContext -> this.serviceClient.getDeprecatedFileConfigsWithResponse(launcherId,
                language, channel, subChannel, gameIds, updatedContext));
    }

    /**
     * The getDeprecatedFileConfigs operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param channel The channel parameter.
     * @param subChannel The subChannel parameter.
     * @param gameIds The gameIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getDeprecatedFileConfigs(String launcherId, String language, Integer channel,
        Integer subChannel, List<String> gameIds) {
        return getDeprecatedFileConfigsWithResponse(launcherId, language, channel, subChannel, gameIds,
            RequestContext.none()).getValue();
    }

    /**
     * The getDeprecatedFileConfigs operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getDeprecatedFileConfigs(String launcherId, String language) {
        final Integer channel = null;
        final Integer subChannel = null;
        final List<String> gameIds = null;
        return getDeprecatedFileConfigsWithResponse(launcherId, language, channel, subChannel, gameIds,
            RequestContext.none()).getValue();
    }

    /**
     * The getGameConfigs operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGameConfigsWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGameConfigs",
            requestContext, updatedContext -> this.serviceClient.getGameConfigsWithResponse(launcherId, language,
                gameIds, updatedContext));
    }

    /**
     * The getGameConfigs operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGameConfigs(String launcherId, String language, List<String> gameIds) {
        return getGameConfigsWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getGameConfigs operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGameConfigs(String launcherId, String language) {
        final List<String> gameIds = null;
        return getGameConfigsWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getGameScanInfo operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGameScanInfoWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGameScanInfo",
            requestContext, updatedContext -> this.serviceClient.getGameScanInfoWithResponse(launcherId, language,
                gameIds, updatedContext));
    }

    /**
     * The getGameScanInfo operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGameScanInfo(String launcherId, String language, List<String> gameIds) {
        return getGameScanInfoWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getGameScanInfo operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGameScanInfo(String launcherId, String language) {
        final List<String> gameIds = null;
        return getGameScanInfoWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getGameBranches operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGameBranchesWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGameBranches",
            requestContext, updatedContext -> this.serviceClient.getGameBranchesWithResponse(launcherId, language,
                gameIds, updatedContext));
    }

    /**
     * The getGameBranches operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGameBranches(String launcherId, String language, List<String> gameIds) {
        return getGameBranchesWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getGameBranches operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getGameBranches(String launcherId, String language) {
        final List<String> gameIds = null;
        return getGameBranchesWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getWpfPackages operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getWpfPackagesWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getWpfPackages",
            requestContext, updatedContext -> this.serviceClient.getWpfPackagesWithResponse(launcherId, language,
                gameIds, updatedContext));
    }

    /**
     * The getWpfPackages operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param gameIds The gameIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getWpfPackages(String launcherId, String language, List<String> gameIds) {
        return getWpfPackagesWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getWpfPackages operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getWpfPackages(String launcherId, String language) {
        final List<String> gameIds = null;
        return getWpfPackagesWithResponse(launcherId, language, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getDxConfigs operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param body The body parameter.
     * @param gameIds The gameIds parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getDxConfigsWithResponse(String launcherId, String language,
        DxConfigRequest body, List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getDxConfigs",
            requestContext, updatedContext -> this.serviceClient.getDxConfigsWithResponse(launcherId, language, body,
                gameIds, updatedContext));
    }

    /**
     * The getDxConfigs operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param body The body parameter.
     * @param gameIds The gameIds parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getDxConfigs(String launcherId, String language, DxConfigRequest body,
        List<String> gameIds) {
        return getDxConfigsWithResponse(launcherId, language, body, gameIds, RequestContext.none()).getValue();
    }

    /**
     * The getDxConfigs operation.
     * 
     * @param launcherId The launcherId parameter.
     * @param language The language parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common envelope used by the HoYoPlay and Sophon APIs.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LauncherResponseJsonObject getDxConfigs(String launcherId, String language, DxConfigRequest body) {
        final List<String> gameIds = null;
        return getDxConfigsWithResponse(launcherId, language, body, gameIds, RequestContext.none()).getValue();
    }
}
