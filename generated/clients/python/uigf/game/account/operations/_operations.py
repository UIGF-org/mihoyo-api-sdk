# pylint: disable=too-many-lines
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

from ... import models as _models2, types as _types_models2
from .... import models as _models3
from ....passport import models as _passport_models4, types as _types_passport_models4
from ....passport._utils.model_base import SdkJSONEncoder, _deserialize
from ....passport._utils.serialization import Deserializer, Serializer
from .._configuration import GameAccountClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_game_token_api_exchange_game_token_request(**kwargs: Any) -> HttpRequest:  # pylint: disable=name-too-long
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/ma-cn-session/app/getTokenByGameToken"

    # Construct headers
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_action_ticket_api_get_by_s_token_request(  # pylint: disable=name-too-long
    *, cookie: str, ds: str, action_type: str, stoken: str, uid: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/auth/api/getActionTicketBySToken"

    # Construct parameters
    _params["action_type"] = _SERIALIZER.query("action_type", action_type, "str")
    _params["stoken"] = _SERIALIZER.query("stoken", stoken, "str")
    _params["uid"] = _SERIALIZER.query("uid", uid, "str")

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["DS"] = _SERIALIZER.header("ds", ds, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_binding_api_generate_auth_key_request(  # pylint: disable=name-too-long
    *, cookie: str, ds: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/binding/api/genAuthKey"

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["DS"] = _SERIALIZER.header("ds", ds, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_binding_api_get_roles_request(
    *, cookie: str, ds: Optional[str] = None, game_biz: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/binding/api/getUserGameRolesByCookie"

    # Construct parameters
    if game_biz is not None:
        _params["game_biz"] = _SERIALIZER.query("game_biz", game_biz, "str")

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    if ds is not None:
        _headers["DS"] = _SERIALIZER.header("ds", ds, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_genshin_obc_api_get_gacha_pool_request(  # pylint: disable=name-too-long
    *, app_sn: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/common/blackboard/ys_obc/v1/gacha_pool"

    # Construct parameters
    _params["app_sn"] = _SERIALIZER.query("app_sn", app_sn, "str")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_genshin_obc_api_get_home_positions_request(  # pylint: disable=name-too-long
    *, app_sn: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/common/blackboard/ys_obc/v1/home/position"

    # Construct parameters
    _params["app_sn"] = _SERIALIZER.query("app_sn", app_sn, "str")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_cultivation_api_batch_compute_request(  # pylint: disable=name-too-long
    *, cookie: str, ds: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/e20200928calculate/v3/batch_compute"

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["DS"] = _SERIALIZER.header("ds", ds, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_cultivation_api_list_avatars_request(  # pylint: disable=name-too-long
    *, cookie: str, ds: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/e20200928calculate/v1/avatar/list"

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["DS"] = _SERIALIZER.header("ds", ds, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_cultivation_api_list_weapons_request(  # pylint: disable=name-too-long
    *, cookie: str, ds: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/e20200928calculate/v1/weapon/list"

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["DS"] = _SERIALIZER.header("ds", ds, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_cultivation_api_sync_avatar_list_request(  # pylint: disable=name-too-long
    *, cookie: str, ds: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/e20200928calculate/v1/sync/avatar/list"

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["DS"] = _SERIALIZER.header("ds", ds, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


class GameTokenApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.GameAccountClient`'s
        :attr:`game_token_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GameAccountClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def exchange_game_token(
        self, body: _passport_models4.GameTokenRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
        """Exchanges the official game-token QR-login result for a session token.

        :param body: Required.
        :type body: ~uigf.passport.models.GameTokenRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def exchange_game_token(
        self, body: _types_passport_models4.GameTokenRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
        """Exchanges the official game-token QR-login result for a session token.

        :param body: Required.
        :type body: ~uigf.passport.types.GameTokenRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def exchange_game_token(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
        """Exchanges the official game-token QR-login result for a session token.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def exchange_game_token(
        self,
        body: Union[_passport_models4.GameTokenRequest, _types_passport_models4.GameTokenRequest, IO[bytes]],
        **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
        """Exchanges the official game-token QR-login result for a session token.

        :param body: Is either a GameTokenRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.passport.models.GameTokenRequest or ~uigf.passport.types.GameTokenRequest or
         IO[bytes]
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
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
        cls: ClsType[_models3.ApiResponseTokenInfo] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_game_token_api_exchange_game_token_request(
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
            deserialized = _deserialize(_models3.ApiResponseTokenInfo, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class ActionTicketApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.GameAccountClient`'s
        :attr:`action_ticket_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GameAccountClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def get_by_s_token(
        self, *, cookie: str, ds: str, action_type: str, stoken: str, uid: str, **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """get_by_s_token.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword action_type: Required.
        :paramtype action_type: str
        :keyword stoken: Required.
        :paramtype stoken: str
        :keyword uid: Required.
        :paramtype uid: str
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

        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_action_ticket_api_get_by_s_token_request(
            cookie=cookie,
            ds=ds,
            action_type=action_type,
            stoken=stoken,
            uid=uid,
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
            deserialized = _deserialize(_models3.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class BindingApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.GameAccountClient`'s
        :attr:`binding_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GameAccountClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def generate_auth_key(
        self,
        body: _models2.AuthKeyRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Generates an authenticated gacha authkey for a selected game role.

        :param body: Required.
        :type body: ~uigf.game.models.AuthKeyRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def generate_auth_key(
        self,
        body: _types_models2.AuthKeyRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Generates an authenticated gacha authkey for a selected game role.

        :param body: Required.
        :type body: ~uigf.game.types.AuthKeyRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def generate_auth_key(
        self, body: IO[bytes], *, cookie: str, ds: str, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Generates an authenticated gacha authkey for a selected game role.

        :param body: Required.
        :type body: IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def generate_auth_key(
        self,
        body: Union[_models2.AuthKeyRequest, _types_models2.AuthKeyRequest, IO[bytes]],
        *,
        cookie: str,
        ds: str,
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Generates an authenticated gacha authkey for a selected game role.

        :param body: Is either a AuthKeyRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.models.AuthKeyRequest or ~uigf.game.types.AuthKeyRequest or IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
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
        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_binding_api_generate_auth_key_request(
            cookie=cookie,
            ds=ds,
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
            deserialized = _deserialize(_models3.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_roles(
        self, *, cookie: str, ds: Optional[str] = None, game_biz: Optional[str] = None, **kwargs: Any
    ) -> _models3.ApiResponseGameRoleList:
        """Lists game roles that are bound to the authenticated community account.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Default value is None.
        :paramtype ds: str
        :keyword game_biz: Default value is None.
        :paramtype game_biz: str
        :return: ApiResponseGameRoleList. The ApiResponseGameRoleList is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseGameRoleList
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

        cls: ClsType[_models3.ApiResponseGameRoleList] = kwargs.pop("cls", None)

        _request = build_binding_api_get_roles_request(
            cookie=cookie,
            ds=ds,
            game_biz=game_biz,
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
            deserialized = _deserialize(_models3.ApiResponseGameRoleList, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class GenshinObcApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.GameAccountClient`'s
        :attr:`genshin_obc_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GameAccountClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def get_gacha_pool(self, *, app_sn: str, **kwargs: Any) -> _models3.ApiResponseJsonObject:
        """get_gacha_pool.

        :keyword app_sn: Required.
        :paramtype app_sn: str
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

        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_genshin_obc_api_get_gacha_pool_request(
            app_sn=app_sn,
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
            deserialized = _deserialize(_models3.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_home_positions(self, *, app_sn: str, **kwargs: Any) -> _models3.ApiResponseJsonObject:
        """get_home_positions.

        :keyword app_sn: Required.
        :paramtype app_sn: str
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

        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_genshin_obc_api_get_home_positions_request(
            app_sn=app_sn,
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
            deserialized = _deserialize(_models3.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class CultivationApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.GameAccountClient`'s
        :attr:`cultivation_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GameAccountClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def batch_compute(
        self,
        body: _models2.CalculateRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Calculates material consumption for a batch of characters and weapons.

        :param body: Required.
        :type body: ~uigf.game.models.CalculateRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def batch_compute(
        self,
        body: _types_models2.CalculateRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Calculates material consumption for a batch of characters and weapons.

        :param body: Required.
        :type body: ~uigf.game.types.CalculateRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def batch_compute(
        self, body: IO[bytes], *, cookie: str, ds: str, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Calculates material consumption for a batch of characters and weapons.

        :param body: Required.
        :type body: IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def batch_compute(
        self,
        body: Union[_models2.CalculateRequest, _types_models2.CalculateRequest, IO[bytes]],
        *,
        cookie: str,
        ds: str,
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Calculates material consumption for a batch of characters and weapons.

        :param body: Is either a CalculateRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.models.CalculateRequest or ~uigf.game.types.CalculateRequest or
         IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
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
        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_cultivation_api_batch_compute_request(
            cookie=cookie,
            ds=ds,
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
            deserialized = _deserialize(_models3.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def list_avatars(
        self,
        body: _models2.CalculateRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """list_avatars.

        :param body: Required.
        :type body: ~uigf.game.models.CalculateRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def list_avatars(
        self,
        body: _types_models2.CalculateRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """list_avatars.

        :param body: Required.
        :type body: ~uigf.game.types.CalculateRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def list_avatars(
        self, body: IO[bytes], *, cookie: str, ds: str, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """list_avatars.

        :param body: Required.
        :type body: IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def list_avatars(
        self,
        body: Union[_models2.CalculateRequest, _types_models2.CalculateRequest, IO[bytes]],
        *,
        cookie: str,
        ds: str,
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """list_avatars.

        :param body: Is either a CalculateRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.models.CalculateRequest or ~uigf.game.types.CalculateRequest or
         IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
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
        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_cultivation_api_list_avatars_request(
            cookie=cookie,
            ds=ds,
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
            deserialized = _deserialize(_models3.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def list_weapons(
        self,
        body: _models2.CalculateRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """list_weapons.

        :param body: Required.
        :type body: ~uigf.game.models.CalculateRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def list_weapons(
        self,
        body: _types_models2.CalculateRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """list_weapons.

        :param body: Required.
        :type body: ~uigf.game.types.CalculateRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def list_weapons(
        self, body: IO[bytes], *, cookie: str, ds: str, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """list_weapons.

        :param body: Required.
        :type body: IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def list_weapons(
        self,
        body: Union[_models2.CalculateRequest, _types_models2.CalculateRequest, IO[bytes]],
        *,
        cookie: str,
        ds: str,
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """list_weapons.

        :param body: Is either a CalculateRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.models.CalculateRequest or ~uigf.game.types.CalculateRequest or
         IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
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
        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_cultivation_api_list_weapons_request(
            cookie=cookie,
            ds=ds,
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
            deserialized = _deserialize(_models3.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def sync_avatar_list(
        self,
        body: _models2.CalculateRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """sync_avatar_list.

        :param body: Required.
        :type body: ~uigf.game.models.CalculateRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def sync_avatar_list(
        self,
        body: _types_models2.CalculateRequest,
        *,
        cookie: str,
        ds: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """sync_avatar_list.

        :param body: Required.
        :type body: ~uigf.game.types.CalculateRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def sync_avatar_list(
        self, body: IO[bytes], *, cookie: str, ds: str, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """sync_avatar_list.

        :param body: Required.
        :type body: IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def sync_avatar_list(
        self,
        body: Union[_models2.CalculateRequest, _types_models2.CalculateRequest, IO[bytes]],
        *,
        cookie: str,
        ds: str,
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """sync_avatar_list.

        :param body: Is either a CalculateRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.models.CalculateRequest or ~uigf.game.types.CalculateRequest or
         IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
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
        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_cultivation_api_sync_avatar_list_request(
            cookie=cookie,
            ds=ds,
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
            deserialized = _deserialize(_models3.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
