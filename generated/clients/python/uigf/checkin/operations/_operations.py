# coding=utf-8
from collections.abc import MutableMapping
from io import IOBase
import json
from typing import Any, Callable, IO, Optional, TypeVar, Union, overload

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

from ... import models as _models2
from ...community import models as _community_models3, types as _types_community_models3
from ...passport._utils.model_base import SdkJSONEncoder, _deserialize
from ...passport._utils.serialization import Deserializer, Serializer
from .._configuration import CheckInClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_check_in_api_get_home_request(
    game: str, *, cookie: str, lang: str, act_id: str, sign_game: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/luna/{game}/home"
    path_format_arguments = {
        "game": _SERIALIZER.url("game", game, "str"),
    }

    _url: str = _url.format(**path_format_arguments)  # type: ignore

    # Construct parameters
    _params["lang"] = _SERIALIZER.query("lang", lang, "str")
    _params["act_id"] = _SERIALIZER.query("act_id", act_id, "str")

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    if sign_game is not None:
        _headers["x-rpc-signgame"] = _SERIALIZER.header("sign_game", sign_game, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_check_in_api_get_info_request(
    game: str, *, cookie: str, lang: str, act_id: str, sign_game: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/luna/{game}/info"
    path_format_arguments = {
        "game": _SERIALIZER.url("game", game, "str"),
    }

    _url: str = _url.format(**path_format_arguments)  # type: ignore

    # Construct parameters
    _params["lang"] = _SERIALIZER.query("lang", lang, "str")
    _params["act_id"] = _SERIALIZER.query("act_id", act_id, "str")

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    if sign_game is not None:
        _headers["x-rpc-signgame"] = _SERIALIZER.header("sign_game", sign_game, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_check_in_api_sign_request(
    game: str, *, cookie: str, sign_game: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/luna/{game}/sign"
    path_format_arguments = {
        "game": _SERIALIZER.url("game", game, "str"),
    }

    _url: str = _url.format(**path_format_arguments)  # type: ignore

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    if sign_game is not None:
        _headers["x-rpc-signgame"] = _SERIALIZER.header("sign_game", sign_game, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_check_in_api_get_resign_info_request(  # pylint: disable=name-too-long
    game: str, *, cookie: str, lang: str, act_id: str, sign_game: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/luna/{game}/resign_info"
    path_format_arguments = {
        "game": _SERIALIZER.url("game", game, "str"),
    }

    _url: str = _url.format(**path_format_arguments)  # type: ignore

    # Construct parameters
    _params["lang"] = _SERIALIZER.query("lang", lang, "str")
    _params["act_id"] = _SERIALIZER.query("act_id", act_id, "str")

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    if sign_game is not None:
        _headers["x-rpc-signgame"] = _SERIALIZER.header("sign_game", sign_game, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_check_in_api_resign_request(
    game: str, *, cookie: str, sign_game: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/luna/{game}/resign"
    path_format_arguments = {
        "game": _SERIALIZER.url("game", game, "str"),
    }

    _url: str = _url.format(**path_format_arguments)  # type: ignore

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    if sign_game is not None:
        _headers["x-rpc-signgame"] = _SERIALIZER.header("sign_game", sign_game, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


class CheckInApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.CheckInClient`'s
        :attr:`check_in_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: CheckInClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def get_home(
        self, game: str, *, cookie: str, lang: str, act_id: str, sign_game: Optional[str] = None, **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """get_home.

        :param game: Required.
        :type game: str
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword act_id: Required.
        :paramtype act_id: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
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

        cls: ClsType[_models2.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_check_in_api_get_home_request(
            game=game,
            cookie=cookie,
            lang=lang,
            act_id=act_id,
            sign_game=sign_game,
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
            deserialized = _deserialize(_models2.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_info(
        self, game: str, *, cookie: str, lang: str, act_id: str, sign_game: Optional[str] = None, **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """get_info.

        :param game: Required.
        :type game: str
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword act_id: Required.
        :paramtype act_id: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
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

        cls: ClsType[_models2.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_check_in_api_get_info_request(
            game=game,
            cookie=cookie,
            lang=lang,
            act_id=act_id,
            sign_game=sign_game,
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
            deserialized = _deserialize(_models2.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def sign(
        self,
        game: str,
        body: _community_models3.LunaCheckInRequest,
        *,
        cookie: str,
        sign_game: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """sign.

        :param game: Required.
        :type game: str
        :param body: Required.
        :type body: ~uigf.community.models.LunaCheckInRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def sign(
        self,
        game: str,
        body: _types_community_models3.LunaCheckInRequest,
        *,
        cookie: str,
        sign_game: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """sign.

        :param game: Required.
        :type game: str
        :param body: Required.
        :type body: ~uigf.community.types.LunaCheckInRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def sign(
        self,
        game: str,
        body: IO[bytes],
        *,
        cookie: str,
        sign_game: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """sign.

        :param game: Required.
        :type game: str
        :param body: Required.
        :type body: IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def sign(
        self,
        game: str,
        body: Union[_community_models3.LunaCheckInRequest, _types_community_models3.LunaCheckInRequest, IO[bytes]],
        *,
        cookie: str,
        sign_game: Optional[str] = None,
        **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """sign.

        :param game: Required.
        :type game: str
        :param body: Is either a LunaCheckInRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.community.models.LunaCheckInRequest or
         ~uigf.community.types.LunaCheckInRequest or IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """
        error_map: MutableMapping = {
            401: ClientAuthenticationError,
            404: ResourceNotFoundError,
            409: ResourceExistsError,
            304: ResourceNotModifiedError,
        }
        error_map.update(kwargs.pop("error_map", {}) or {})

        _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
        _params = kwargs.pop("params", {}) or {}

        content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
        cls: ClsType[_models2.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_check_in_api_sign_request(
            game=game,
            cookie=cookie,
            sign_game=sign_game,
            content_type=content_type,
            content=_content,
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
            deserialized = _deserialize(_models2.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_resign_info(
        self, game: str, *, cookie: str, lang: str, act_id: str, sign_game: Optional[str] = None, **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """get_resign_info.

        :param game: Required.
        :type game: str
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword act_id: Required.
        :paramtype act_id: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
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

        cls: ClsType[_models2.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_check_in_api_get_resign_info_request(
            game=game,
            cookie=cookie,
            lang=lang,
            act_id=act_id,
            sign_game=sign_game,
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
            deserialized = _deserialize(_models2.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def resign(
        self,
        game: str,
        body: _community_models3.LunaCheckInRequest,
        *,
        cookie: str,
        sign_game: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """resign.

        :param game: Required.
        :type game: str
        :param body: Required.
        :type body: ~uigf.community.models.LunaCheckInRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def resign(
        self,
        game: str,
        body: _types_community_models3.LunaCheckInRequest,
        *,
        cookie: str,
        sign_game: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """resign.

        :param game: Required.
        :type game: str
        :param body: Required.
        :type body: ~uigf.community.types.LunaCheckInRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def resign(
        self,
        game: str,
        body: IO[bytes],
        *,
        cookie: str,
        sign_game: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """resign.

        :param game: Required.
        :type game: str
        :param body: Required.
        :type body: IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def resign(
        self,
        game: str,
        body: Union[_community_models3.LunaCheckInRequest, _types_community_models3.LunaCheckInRequest, IO[bytes]],
        *,
        cookie: str,
        sign_game: Optional[str] = None,
        **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """resign.

        :param game: Required.
        :type game: str
        :param body: Is either a LunaCheckInRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.community.models.LunaCheckInRequest or
         ~uigf.community.types.LunaCheckInRequest or IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword sign_game: Default value is None.
        :paramtype sign_game: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """
        error_map: MutableMapping = {
            401: ClientAuthenticationError,
            404: ResourceNotFoundError,
            409: ResourceExistsError,
            304: ResourceNotModifiedError,
        }
        error_map.update(kwargs.pop("error_map", {}) or {})

        _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
        _params = kwargs.pop("params", {}) or {}

        content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
        cls: ClsType[_models2.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_check_in_api_resign_request(
            game=game,
            cookie=cookie,
            sign_game=sign_game,
            content_type=content_type,
            content=_content,
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
            deserialized = _deserialize(_models2.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
