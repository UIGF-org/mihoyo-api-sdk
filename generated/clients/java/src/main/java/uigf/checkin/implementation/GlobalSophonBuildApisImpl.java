package uigf.checkin.implementation;

import io.clientcore.core.annotations.ReturnType;
import io.clientcore.core.annotations.ServiceInterface;
import io.clientcore.core.annotations.ServiceMethod;
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
import uigf.ApiResponseJsonObject;

/**
 * An instance of this class provides access to all the operations defined in GlobalSophonBuildApis.
 */
public final class GlobalSophonBuildApisImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final GlobalSophonBuildApisService service;

    /**
     * The service client containing this operation class.
     */
    private final GlobalSophonClientImpl client;

    /**
     * The instance of instrumentation to report telemetry.
     */
    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of GlobalSophonBuildApisImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    GlobalSophonBuildApisImpl(GlobalSophonClientImpl client) {
        this.service = GlobalSophonBuildApisService.getNewInstance(client.getHttpPipeline());
        this.client = client;
        this.instrumentation = client.getInstrumentation();
    }

    /**
     * The interface defining all the services for GlobalSophonClientGlobalSophonBuildApis to be used by the proxy
     * service to perform REST calls.
     */
    @ServiceInterface(name = "GlobalSophonClientGlobalSophonBuildApis", host = "{endpoint}")
    public interface GlobalSophonBuildApisService {
        static GlobalSophonBuildApisService getNewInstance(HttpPipeline pipeline) {
            try {
                Class<?> clazz = Class.forName("uigf.checkin.implementation.GlobalSophonBuildApisServiceImpl");
                return (GlobalSophonBuildApisService) clazz.getMethod("getNewInstance", HttpPipeline.class)
                    .invoke(null, pipeline);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        @HttpRequestInformation(
            method = HttpMethod.GET,
            path = "/downloader/sophon_chunk/api/getBuild",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getBuild(@HostParam("endpoint") String endpoint,
            @QueryParam("branch") String branch, @QueryParam("package_id") String packageId,
            @QueryParam("password") String password, @QueryParam("tag") String tag,
            @HeaderParam("Accept") String accept, RequestContext requestContext);

        @HttpRequestInformation(
            method = HttpMethod.POST,
            path = "/downloader/sophon_chunk/api/getPatchBuild",
            expectedStatusCodes = { 200 })
        @UnexpectedResponseExceptionDetail
        Response<ApiResponseJsonObject> getPatchBuild(@HostParam("endpoint") String endpoint,
            @QueryParam("branch") String branch, @QueryParam("package_id") String packageId,
            @QueryParam("password") String password, @QueryParam("tag") String tag,
            @HeaderParam("Accept") String accept, RequestContext requestContext);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getBuildWithResponse(String branch, String packageId, String password,
        String tag, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Sophon.Global.BuildApi.getBuild",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getBuild(this.client.getEndpoint(), branch, packageId, password, tag, accept,
                    updatedContext);
            });
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getPatchBuildWithResponse(String branch, String packageId, String password,
        String tag, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.Launcher.Sophon.Global.BuildApi.getPatchBuild",
            requestContext, updatedContext -> {
                final String accept = "application/json";
                return service.getPatchBuild(this.client.getEndpoint(), branch, packageId, password, tag, accept,
                    updatedContext);
            });
    }
}
