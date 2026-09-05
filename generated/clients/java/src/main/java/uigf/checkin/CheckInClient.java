package uigf.checkin;

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
import uigf.checkin.implementation.CheckInApisImpl;
import uigf.community.LunaCheckInRequest;

/**
 * Initializes a new instance of the synchronous CheckInClient type.
 */
@ServiceClient(builder = CheckInClientBuilder.class)
public final class CheckInClient {
    @Metadata(properties = { MetadataProperties.GENERATED })
    private final CheckInApisImpl serviceClient;

    private final Instrumentation instrumentation;

    /**
     * Initializes an instance of CheckInClient class.
     * 
     * @param serviceClient the service client implementation.
     * @param instrumentation the instrumentation instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    CheckInClient(CheckInApisImpl serviceClient, Instrumentation instrumentation) {
        this.serviceClient = serviceClient;
        this.instrumentation = instrumentation;
    }

    /**
     * The getHome operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getHomeWithResponse(String game, String cookie, String lang, String actId,
        String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.getHome", requestContext,
            updatedContext -> this.serviceClient.getHomeWithResponse(game, cookie, lang, actId, signGame,
                updatedContext));
    }

    /**
     * The getHome operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @param signGame The signGame parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getHome(String game, String cookie, String lang, String actId, String signGame) {
        return getHomeWithResponse(game, cookie, lang, actId, signGame, RequestContext.none()).getValue();
    }

    /**
     * The getHome operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getHome(String game, String cookie, String lang, String actId) {
        final String signGame = null;
        return getHomeWithResponse(game, cookie, lang, actId, signGame, RequestContext.none()).getValue();
    }

    /**
     * The getInfo operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getInfoWithResponse(String game, String cookie, String lang, String actId,
        String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.getInfo", requestContext,
            updatedContext -> this.serviceClient.getInfoWithResponse(game, cookie, lang, actId, signGame,
                updatedContext));
    }

    /**
     * The getInfo operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @param signGame The signGame parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getInfo(String game, String cookie, String lang, String actId, String signGame) {
        return getInfoWithResponse(game, cookie, lang, actId, signGame, RequestContext.none()).getValue();
    }

    /**
     * The getInfo operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getInfo(String game, String cookie, String lang, String actId) {
        final String signGame = null;
        return getInfoWithResponse(game, cookie, lang, actId, signGame, RequestContext.none()).getValue();
    }

    /**
     * The sign operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> signWithResponse(String game, String cookie, LunaCheckInRequest body,
        String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.sign", requestContext,
            updatedContext -> this.serviceClient.signWithResponse(game, cookie, body, signGame, updatedContext));
    }

    /**
     * The sign operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param signGame The signGame parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject sign(String game, String cookie, LunaCheckInRequest body, String signGame) {
        return signWithResponse(game, cookie, body, signGame, RequestContext.none()).getValue();
    }

    /**
     * The sign operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject sign(String game, String cookie, LunaCheckInRequest body) {
        final String signGame = null;
        return signWithResponse(game, cookie, body, signGame, RequestContext.none()).getValue();
    }

    /**
     * The getResignInfo operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> getResignInfoWithResponse(String game, String cookie, String lang,
        String actId, String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.getResignInfo", requestContext,
            updatedContext -> this.serviceClient.getResignInfoWithResponse(game, cookie, lang, actId, signGame,
                updatedContext));
    }

    /**
     * The getResignInfo operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @param signGame The signGame parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getResignInfo(String game, String cookie, String lang, String actId, String signGame) {
        return getResignInfoWithResponse(game, cookie, lang, actId, signGame, RequestContext.none()).getValue();
    }

    /**
     * The getResignInfo operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param lang The lang parameter.
     * @param actId The actId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject getResignInfo(String game, String cookie, String lang, String actId) {
        final String signGame = null;
        return getResignInfoWithResponse(game, cookie, lang, actId, signGame, RequestContext.none()).getValue();
    }

    /**
     * The resign operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param signGame The signGame parameter.
     * @param requestContext The context to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services along with {@link Response}.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApiResponseJsonObject> resignWithResponse(String game, String cookie, LunaCheckInRequest body,
        String signGame, RequestContext requestContext) {
        return this.instrumentation.instrumentWithResponse("UIGF.CheckIn.CheckInApi.resign", requestContext,
            updatedContext -> this.serviceClient.resignWithResponse(game, cookie, body, signGame, updatedContext));
    }

    /**
     * The resign operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @param signGame The signGame parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject resign(String game, String cookie, LunaCheckInRequest body, String signGame) {
        return resignWithResponse(game, cookie, body, signGame, RequestContext.none()).getValue();
    }

    /**
     * The resign operation.
     * 
     * @param game The game parameter.
     * @param cookie The cookie parameter.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return common response wrapper returned by MiHoYo and HoYoLAB services.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApiResponseJsonObject resign(String game, String cookie, LunaCheckInRequest body) {
        final String signGame = null;
        return resignWithResponse(game, cookie, body, signGame, RequestContext.none()).getValue();
    }
}
