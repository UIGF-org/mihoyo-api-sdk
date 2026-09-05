package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.annotations.BodyParam;
import io.clientcore.core.http.annotations.HeaderParam;
import io.clientcore.core.http.annotations.HostParam;
import io.clientcore.core.http.annotations.HttpRequestInformation;
import io.clientcore.core.http.annotations.QueryParam;
import io.clientcore.core.http.annotations.UnexpectedResponseExceptionDetail;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.instrumentation.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import uigf.LauncherResponseGameBasicInfo;
import uigf.LauncherResponseJsonObject;
import uigf.launcher.DxConfigRequest;

/**
 * An instance of this class provides access to all the operations defined in GlobalLauncherMetadataApis.
 */
public final class GlobalLauncherMetadataApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GlobalLauncherMetadataApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GlobalLauncherClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalLauncherMetadataApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GlobalLauncherMetadataApisImpl(GlobalLauncherClientImpl client) {
        this.service = GlobalLauncherMetadataApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GlobalLauncherClientGlobalLauncherMetadataApis to be used by the
     * proxy service to perform REST calls.
     */
    @ServiceInterface(name = "GlobalLauncherClientGlobalLauncherMetadataApis", host = "{endpoint}")
    public interface GlobalLauncherMetadataApisService {
        static GlobalLauncherMetadataApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GlobalLauncherMetadataApisServiceImpl");
                return (GlobalLauncherMetadataApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hyp/hyp-connect/api/getAllGameBasicInfo",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<LauncherResponseGameBasicInfo> getAllGameBasicInfo(@HostParam("endpoint") String endpoint,
            @QueryParam("launcher_id") String launcherId, @QueryParam("language") String language,
            @QueryParam("game_ids[]") String gameIds, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hyp/hyp-connect/api/getGamePackages",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<LauncherResponseJsonObject> getGamePackages(@HostParam("endpoint") String endpoint,
            @QueryParam("launcher_id") String launcherId, @QueryParam("language") String language,
            @QueryParam("game_ids[]") String gameIds, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hyp/hyp-connect/api/getGameChannelSDKs",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<LauncherResponseJsonObject> getGameChannelSdks(@HostParam("endpoint") String endpoint,
            @QueryParam("channel") Integer channel, @QueryParam("sub_channel") Integer subChannel,
            @QueryParam("launcher_id") String launcherId, @QueryParam("language") String language,
            @QueryParam("game_ids[]") String gameIds, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hyp/hyp-connect/api/getGameDeprecatedFileConfigs",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<LauncherResponseJsonObject> getDeprecatedFileConfigs(@HostParam("endpoint") String endpoint,
            @QueryParam("channel") Integer channel, @QueryParam("sub_channel") Integer subChannel,
            @QueryParam("launcher_id") String launcherId, @QueryParam("language") String language,
            @QueryParam("game_ids[]") String gameIds, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hyp/hyp-connect/api/getGameConfigs",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<LauncherResponseJsonObject> getGameConfigs(@HostParam("endpoint") String endpoint,
            @QueryParam("launcher_id") String launcherId, @QueryParam("language") String language,
            @QueryParam("game_ids[]") String gameIds, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hyp/hyp-connect/api/getGameScanInfo",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<LauncherResponseJsonObject> getGameScanInfo(@HostParam("endpoint") String endpoint,
            @QueryParam("launcher_id") String launcherId, @QueryParam("language") String language,
            @QueryParam("game_ids[]") String gameIds, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hyp/hyp-connect/api/getGameBranches",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<LauncherResponseJsonObject> getGameBranches(@HostParam("endpoint") String endpoint,
            @QueryParam("launcher_id") String launcherId, @QueryParam("language") String language,
            @QueryParam("game_ids[]") String gameIds, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/hyp/hyp-connect/api/getWPFPackages",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<LauncherResponseJsonObject> getWpfPackages(@HostParam("endpoint") String endpoint,
            @QueryParam("launcher_id") String launcherId, @QueryParam("language") String language,
            @QueryParam("game_ids[]") String gameIds, @HeaderParam("Accept") String accept,
            RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/hyp/hyp-connect/api/getDXConfigs",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<LauncherResponseJsonObject> getDxConfigs(@HostParam("endpoint") String endpoint,
            @QueryParam("launcher_id") String launcherId, @QueryParam("language") String language,
            @QueryParam("game_ids[]") String gameIds, @HeaderParam("Content-Type") String contentType,
            @HeaderParam("Accept") String accept, @BodyParam("application/json") DxConfigRequest body,
            RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseGameBasicInfo> getAllGameBasicInfoWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getAllGameBasicInfo",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                String gameIdsConverted = (gameIds == null)
                    ? null
                    : gameIds.stream()
                        .map(paramItemValue -> Objects.toString(paramItemValue, ""))
                        .collect(Collectors.joining(","));
                return service.getAllGameBasicInfo(this.client.getEndpoint(), launcherId, language, gameIdsConverted,
                    accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGamePackagesWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGamePackages",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                String gameIdsConverted = (gameIds == null)
                    ? null
                    : gameIds.stream()
                        .map(paramItemValue -> Objects.toString(paramItemValue, ""))
                        .collect(Collectors.joining(","));
                return service.getGamePackages(this.client.getEndpoint(), launcherId, language, gameIdsConverted,
                    accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGameChannelSdksWithResponse(String launcherId, String language,
        Integer channel, Integer subChannel, List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGameChannelSdks",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                String gameIdsConverted = (gameIds == null)
                    ? null
                    : gameIds.stream()
                        .map(paramItemValue -> Objects.toString(paramItemValue, ""))
                        .collect(Collectors.joining(","));
                return service.getGameChannelSdks(this.client.getEndpoint(), channel, subChannel, launcherId, language,
                    gameIdsConverted, accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getDeprecatedFileConfigsWithResponse(String launcherId, String language,
        Integer channel, Integer subChannel, List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getDeprecatedFileConfigs",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                String gameIdsConverted = (gameIds == null)
                    ? null
                    : gameIds.stream()
                        .map(paramItemValue -> Objects.toString(paramItemValue, ""))
                        .collect(Collectors.joining(","));
                return service.getDeprecatedFileConfigs(this.client.getEndpoint(), channel, subChannel, launcherId,
                    language, gameIdsConverted, accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGameConfigsWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGameConfigs",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                String gameIdsConverted = (gameIds == null)
                    ? null
                    : gameIds.stream()
                        .map(paramItemValue -> Objects.toString(paramItemValue, ""))
                        .collect(Collectors.joining(","));
                return service.getGameConfigs(this.client.getEndpoint(), launcherId, language, gameIdsConverted, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGameScanInfoWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGameScanInfo",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                String gameIdsConverted = (gameIds == null)
                    ? null
                    : gameIds.stream()
                        .map(paramItemValue -> Objects.toString(paramItemValue, ""))
                        .collect(Collectors.joining(","));
                return service.getGameScanInfo(this.client.getEndpoint(), launcherId, language, gameIdsConverted,
                    accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getGameBranchesWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getGameBranches",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                String gameIdsConverted = (gameIds == null)
                    ? null
                    : gameIds.stream()
                        .map(paramItemValue -> Objects.toString(paramItemValue, ""))
                        .collect(Collectors.joining(","));
                return service.getGameBranches(this.client.getEndpoint(), launcherId, language, gameIdsConverted,
                    accept, updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getWpfPackagesWithResponse(String launcherId, String language,
        List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getWpfPackages",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                String gameIdsConverted = (gameIds == null)
                    ? null
                    : gameIds.stream()
                        .map(paramItemValue -> Objects.toString(paramItemValue, ""))
                        .collect(Collectors.joining(","));
                return service.getWpfPackages(this.client.getEndpoint(), launcherId, language, gameIdsConverted, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LauncherResponseJsonObject> getDxConfigsWithResponse(String launcherId, String language,
        DxConfigRequest body, List<String> gameIds, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Global.MetadataApi.getDxConfigs",
            requestContext, updatedContext -> {
                final String contentType = "application/json";
                final String accept = "application/json";
                String gameIdsConverted = (gameIds == null)
                    ? null
                    : gameIds.stream()
                        .map(paramItemValue -> Objects.toString(paramItemValue, ""))
                        .collect(Collectors.joining(","));
                return service.getDxConfigs(this.client.getEndpoint(), launcherId, language, gameIdsConverted,
                    contentType, accept, body, updatedContext);
            });
    }
}
