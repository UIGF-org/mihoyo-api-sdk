package uigf.launcher.sophon.global;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.annotations.ServiceMethod;
import io.clientcore.core.http.models.HttpResponseException;
import io.clientcore.core.http.models.RequestContext;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.instrumentation.Instrumentation;
import uigf.ApiResponseJsonObject;
import uigf.checkin.implementation.GlobalSophonBuildApisImpl;

/**
 * Initializes a new instance of the synchronous GlobalSophonClient type.
 */
@ServiceClient(builder = GlobalSophonClientBuilder.class)
public final class GlobalSophonClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final GlobalSophonBuildApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalSophonClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    GlobalSophonClient(GlobalSophonBuildApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getBuild operation.
     * 
     * @param branch The branch parameter.
     * @param packageId The packageId parameter.
     * @param password The password parameter.
     * @param tag The tag parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getBuildWithResponse(String branch, String packageId, String password,
        String tag, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Sophon.Global.BuildApi.getBuild",
            requestContext, updatedContext -> this.serviceClient.getBuildWithResponse(branch, packageId, password, tag,
                updatedContext));
    }

    /**
     * The getBuild operation.
     * 
     * @param branch The branch parameter.
     * @param packageId The packageId parameter.
     * @param password The password parameter.
     * @param tag The tag parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getBuild(String branch, String packageId, String password, String tag) {
        return getBuildWithResponse(branch, packageId, password, tag, RequestContext.none()).getValue();
    }

    /**
     * The getBuild operation.
     * 
     * @param branch The branch parameter.
     * @param packageId The packageId parameter.
     * @param password The password parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getBuild(String branch, String packageId, String password) {
        final String tag = null;
        return getBuildWithResponse(branch, packageId, password, tag, RequestContext.none()).getValue();
    }

    /**
     * The getPatchBuild operation.
     * 
     * @param branch The branch parameter.
     * @param packageId The packageId parameter.
     * @param password The password parameter.
     * @param tag The tag parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getPatchBuildWithResponse(String branch, String packageId, String password,
        String tag, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Sophon.Global.BuildApi.getPatchBuild",
            requestContext, updatedContext -> this.serviceClient.getPatchBuildWithResponse(branch, packageId, password,
                tag, updatedContext));
    }

    /**
     * The getPatchBuild operation.
     * 
     * @param branch The branch parameter.
     * @param packageId The packageId parameter.
     * @param password The password parameter.
     * @param tag The tag parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getPatchBuild(String branch, String packageId, String password, String tag) {
        return getPatchBuildWithResponse(branch, packageId, password, tag, RequestContext.none()).getValue();
    }

    /**
     * The getPatchBuild operation.
     * 
     * @param branch The branch parameter.
     * @param packageId The packageId parameter.
     * @param password The password parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getPatchBuild(String branch, String packageId, String password) {
        final String tag = null;
        return getPatchBuildWithResponse(branch, packageId, password, tag, RequestContext.none()).getValue();
    }
}
