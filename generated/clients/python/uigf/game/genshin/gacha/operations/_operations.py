# coding=utf-8
from collections.abc import MutableMapping
from typing import Any, Callable, Literal, Optional, TypeVar

from corehttp.exceptions import (
    ClientAuthenticationError,
    HttpResponseError,
    ResourceExistsError,
    ResourceNotFoundError,
    ResourceNotModifiedError,
    StreamClosedError,
    StreamConsumedError,
    map_error,
)
from corehttp.rest import HttpRequest, HttpResponse
from corehttp.runtime import PipelineClient
from corehttp.runtime.pipeline import PipelineResponse
from corehttp.utils import case_insensitive_dict

from ..... import models as _models4
from .....passport._utils.model_base import _deserialize
from .....passport._utils.serialization import Deserializer, Serializer
from .._configuration import GachaClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_gacha_log_api_get_history_request(
    *,
    gacha_type: str,
    authkey: str,
    auth_appid: str,
    lang: str,
    gacha_id: Optional[str] = None,
    end_id: Optional[str] = None,
    page: Optional[int] = None,
    size: Optional[int] = None,
    region: Optional[str] = None,
    game_biz: Optional[str] = None,
    device_type: Optional[str] = None,
    game_version: Optional[str] = None,
    init_type: Optional[str] = None,
    no_joypad_close: Optional[str] = None,
    timestamp: Optional[str] = None,
    win_mode: Optional[str] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    authkey_ver: Literal["1"] = kwargs.pop("authkey_ver", _params.pop("authkey_ver", "1"))
    sign_type: Literal["2"] = kwargs.pop("sign_type", _params.pop("sign_type", "2"))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/gacha_info/api/getGachaLog"

    # Construct parameters
    _params["gacha_type"] = _SERIALIZER.query("gacha_type", gacha_type, "str")
    if gacha_id is not None:
        _params["gacha_id"] = _SERIALIZER.query("gacha_id", gacha_id, "str")
    if end_id is not None:
        _params["end_id"] = _SERIALIZER.query("end_id", end_id, "str")
    if page is not None:
        _params["page"] = _SERIALIZER.query("page", page, "int")
    if size is not None:
        _params["size"] = _SERIALIZER.query("size", size, "int")
    if region is not None:
        _params["region"] = _SERIALIZER.query("region", region, "str")
    if game_biz is not None:
        _params["game_biz"] = _SERIALIZER.query("game_biz", game_biz, "str")
    if device_type is not None:
        _params["device_type"] = _SERIALIZER.query("device_type", device_type, "str")
    if game_version is not None:
        _params["game_version"] = _SERIALIZER.query("game_version", game_version, "str")
    if init_type is not None:
        _params["init_type"] = _SERIALIZER.query("init_type", init_type, "str")
    if no_joypad_close is not None:
        _params["no_joypad_close"] = _SERIALIZER.query("no_joypad_close", no_joypad_close, "str")
    if timestamp is not None:
        _params["timestamp"] = _SERIALIZER.query("timestamp", timestamp, "str")
    if win_mode is not None:
        _params["win_mode"] = _SERIALIZER.query("win_mode", win_mode, "str")
    _params["authkey"] = _SERIALIZER.query("authkey", authkey, "str")
    _params["auth_appid"] = _SERIALIZER.query("auth_appid", auth_appid, "str")
    _params["authkey_ver"] = _SERIALIZER.query("authkey_ver", authkey_ver, "str")
    _params["sign_type"] = _SERIALIZER.query("sign_type", sign_type, "str")
    _params["lang"] = _SERIALIZER.query("lang", lang, "str")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_gacha_log_api_get_beyond_history_request(  # pylint: disable=name-too-long
    *,
    gacha_type: str,
    authkey: str,
    auth_appid: str,
    lang: str,
    gacha_id: Optional[str] = None,
    end_id: Optional[str] = None,
    page: Optional[int] = None,
    size: Optional[int] = None,
    region: Optional[str] = None,
    game_biz: Optional[str] = None,
    device_type: Optional[str] = None,
    game_version: Optional[str] = None,
    init_type: Optional[str] = None,
    no_joypad_close: Optional[str] = None,
    timestamp: Optional[str] = None,
    win_mode: Optional[str] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    authkey_ver: Literal["1"] = kwargs.pop("authkey_ver", _params.pop("authkey_ver", "1"))
    sign_type: Literal["2"] = kwargs.pop("sign_type", _params.pop("sign_type", "2"))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/gacha_info/api/getBeyondGachaLog"

    # Construct parameters
    _params["gacha_type"] = _SERIALIZER.query("gacha_type", gacha_type, "str")
    if gacha_id is not None:
        _params["gacha_id"] = _SERIALIZER.query("gacha_id", gacha_id, "str")
    if end_id is not None:
        _params["end_id"] = _SERIALIZER.query("end_id", end_id, "str")
    if page is not None:
        _params["page"] = _SERIALIZER.query("page", page, "int")
    if size is not None:
        _params["size"] = _SERIALIZER.query("size", size, "int")
    if region is not None:
        _params["region"] = _SERIALIZER.query("region", region, "str")
    if game_biz is not None:
        _params["game_biz"] = _SERIALIZER.query("game_biz", game_biz, "str")
    if device_type is not None:
        _params["device_type"] = _SERIALIZER.query("device_type", device_type, "str")
    if game_version is not None:
        _params["game_version"] = _SERIALIZER.query("game_version", game_version, "str")
    if init_type is not None:
        _params["init_type"] = _SERIALIZER.query("init_type", init_type, "str")
    if no_joypad_close is not None:
        _params["no_joypad_close"] = _SERIALIZER.query("no_joypad_close", no_joypad_close, "str")
    if timestamp is not None:
        _params["timestamp"] = _SERIALIZER.query("timestamp", timestamp, "str")
    if win_mode is not None:
        _params["win_mode"] = _SERIALIZER.query("win_mode", win_mode, "str")
    _params["authkey"] = _SERIALIZER.query("authkey", authkey, "str")
    _params["auth_appid"] = _SERIALIZER.query("auth_appid", auth_appid, "str")
    _params["authkey_ver"] = _SERIALIZER.query("authkey_ver", authkey_ver, "str")
    _params["sign_type"] = _SERIALIZER.query("sign_type", sign_type, "str")
    _params["lang"] = _SERIALIZER.query("lang", lang, "str")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


class GachaLogApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.GachaClient`'s
        :attr:`gacha_log_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GachaClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def get_history(  # pylint: disable=too-many-locals
        self,
        *,
        gacha_type: str,
        authkey: str,
        auth_appid: str,
        lang: str,
        gacha_id: Optional[str] = None,
        end_id: Optional[str] = None,
        page: Optional[int] = None,
        size: Optional[int] = None,
        region: Optional[str] = None,
        game_biz: Optional[str] = None,
        device_type: Optional[str] = None,
        game_version: Optional[str] = None,
        init_type: Optional[str] = None,
        no_joypad_close: Optional[str] = None,
        timestamp: Optional[str] = None,
        win_mode: Optional[str] = None,
        **kwargs: Any
    ) -> _models4.ApiResponseGachaLogPage:
        """get_history.

        :keyword gacha_type: Required.
        :paramtype gacha_type: str
        :keyword authkey: Required.
        :paramtype authkey: str
        :keyword auth_appid: Required.
        :paramtype auth_appid: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword gacha_id: Default value is None.
        :paramtype gacha_id: str
        :keyword end_id: Default value is None.
        :paramtype end_id: str
        :keyword page: Default value is None.
        :paramtype page: int
        :keyword size: Default value is None.
        :paramtype size: int
        :keyword region: Default value is None.
        :paramtype region: str
        :keyword game_biz: Default value is None.
        :paramtype game_biz: str
        :keyword device_type: Default value is None.
        :paramtype device_type: str
        :keyword game_version: Default value is None.
        :paramtype game_version: str
        :keyword init_type: Default value is None.
        :paramtype init_type: str
        :keyword no_joypad_close: Default value is None.
        :paramtype no_joypad_close: str
        :keyword timestamp: Default value is None.
        :paramtype timestamp: str
        :keyword win_mode: Default value is None.
        :paramtype win_mode: str
        :return: ApiResponseGachaLogPage. The ApiResponseGachaLogPage is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseGachaLogPage
        :raises ~corehttp.exceptions.HttpResponseError:
        """
        error_map: MutableMapping = {
            401: ClientAuthenticationError,
            404: ResourceNotFoundError,
            409: ResourceExistsError,
            304: ResourceNotModifiedError,
        }
        error_map.update(kwargs.pop("error_map", {}) or {})

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        authkey_ver: Literal["1"] = kwargs.pop("authkey_ver", _params.pop("authkey_ver", "1"))
        sign_type: Literal["2"] = kwargs.pop("sign_type", _params.pop("sign_type", "2"))
        cls: ClsType[_models4.ApiResponseGachaLogPage] = kwargs.pop("cls", None)

        _request = build_gacha_log_api_get_history_request(
            gacha_type=gacha_type,
            authkey=authkey,
            auth_appid=auth_appid,
            lang=lang,
            gacha_id=gacha_id,
            end_id=end_id,
            page=page,
            size=size,
            region=region,
            game_biz=game_biz,
            device_type=device_type,
            game_version=game_version,
            init_type=init_type,
            no_joypad_close=no_joypad_close,
            timestamp=timestamp,
            win_mode=win_mode,
            authkey_ver=authkey_ver,
            sign_type=sign_type,
            headers=_headers,
            params=_params,
        )
        path_format_arguments = {
            "endpoint": self._serialize.url("self._config.endpoint", self._config.endpoint, "str", skip_quote=True),
        }
        _request.url = self._client.format_url(_request.url, **path_format_arguments)

        _decompress = kwargs.pop("decompress", True)
        _stream = kwargs.pop("stream", False)
        pipeline_response: PipelineResponse = self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    response.read()  # Load the body in memory and close the socket
                except (StreamConsumedError, StreamClosedError):
                    pass
            map_error(status_code=response.status_code, response=response, error_map=error_map)
            raise HttpResponseError(response=response)

        if _stream:
            deserialized = response.iter_bytes() if _decompress else response.iter_raw()
        else:
            deserialized = _deserialize(_models4.ApiResponseGachaLogPage, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_beyond_history(  # pylint: disable=too-many-locals
        self,
        *,
        gacha_type: str,
        authkey: str,
        auth_appid: str,
        lang: str,
        gacha_id: Optional[str] = None,
        end_id: Optional[str] = None,
        page: Optional[int] = None,
        size: Optional[int] = None,
        region: Optional[str] = None,
        game_biz: Optional[str] = None,
        device_type: Optional[str] = None,
        game_version: Optional[str] = None,
        init_type: Optional[str] = None,
        no_joypad_close: Optional[str] = None,
        timestamp: Optional[str] = None,
        win_mode: Optional[str] = None,
        **kwargs: Any
    ) -> _models4.ApiResponseGachaLogPage:
        """get_beyond_history.

        :keyword gacha_type: Required.
        :paramtype gacha_type: str
        :keyword authkey: Required.
        :paramtype authkey: str
        :keyword auth_appid: Required.
        :paramtype auth_appid: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword gacha_id: Default value is None.
        :paramtype gacha_id: str
        :keyword end_id: Default value is None.
        :paramtype end_id: str
        :keyword page: Default value is None.
        :paramtype page: int
        :keyword size: Default value is None.
        :paramtype size: int
        :keyword region: Default value is None.
        :paramtype region: str
        :keyword game_biz: Default value is None.
        :paramtype game_biz: str
        :keyword device_type: Default value is None.
        :paramtype device_type: str
        :keyword game_version: Default value is None.
        :paramtype game_version: str
        :keyword init_type: Default value is None.
        :paramtype init_type: str
        :keyword no_joypad_close: Default value is None.
        :paramtype no_joypad_close: str
        :keyword timestamp: Default value is None.
        :paramtype timestamp: str
        :keyword win_mode: Default value is None.
        :paramtype win_mode: str
        :return: ApiResponseGachaLogPage. The ApiResponseGachaLogPage is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseGachaLogPage
        :raises ~corehttp.exceptions.HttpResponseError:
        """
        error_map: MutableMapping = {
            401: ClientAuthenticationError,
            404: ResourceNotFoundError,
            409: ResourceExistsError,
            304: ResourceNotModifiedError,
        }
        error_map.update(kwargs.pop("error_map", {}) or {})

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        authkey_ver: Literal["1"] = kwargs.pop("authkey_ver", _params.pop("authkey_ver", "1"))
        sign_type: Literal["2"] = kwargs.pop("sign_type", _params.pop("sign_type", "2"))
        cls: ClsType[_models4.ApiResponseGachaLogPage] = kwargs.pop("cls", None)

        _request = build_gacha_log_api_get_beyond_history_request(
            gacha_type=gacha_type,
            authkey=authkey,
            auth_appid=auth_appid,
            lang=lang,
            gacha_id=gacha_id,
            end_id=end_id,
            page=page,
            size=size,
            region=region,
            game_biz=game_biz,
            device_type=device_type,
            game_version=game_version,
            init_type=init_type,
            no_joypad_close=no_joypad_close,
            timestamp=timestamp,
            win_mode=win_mode,
            authkey_ver=authkey_ver,
            sign_type=sign_type,
            headers=_headers,
            params=_params,
        )
        path_format_arguments = {
            "endpoint": self._serialize.url("self._config.endpoint", self._config.endpoint, "str", skip_quote=True),
        }
        _request.url = self._client.format_url(_request.url, **path_format_arguments)

        _decompress = kwargs.pop("decompress", True)
        _stream = kwargs.pop("stream", False)
        pipeline_response: PipelineResponse = self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    response.read()  # Load the body in memory and close the socket
                except (StreamConsumedError, StreamClosedError):
                    pass
            map_error(status_code=response.status_code, response=response, error_map=error_map)
            raise HttpResponseError(response=response)

        if _stream:
            deserialized = response.iter_bytes() if _decompress else response.iter_raw()
        else:
            deserialized = _deserialize(_models4.ApiResponseGachaLogPage, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
