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

from .. import models as _models1, types as _types_models1
from ... import models as _models2
from .._configuration import PassportClientConfiguration
from .._utils.model_base import SdkJSONEncoder, _deserialize
from .._utils.serialization import Deserializer, Serializer

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_auth_ticket_api_create_by_game_biz_request(**kwargs: Any) -> HttpRequest:  # pylint: disable=name-too-long
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/ma-cn-verifier/app/createAuthTicketByGameBiz"

    # Construct headers
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_captcha_api_create_request(**kwargs: Any) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/ma-cn-verifier/verifier/createLoginCaptcha"

    # Construct headers
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_qr_login_api_create_request(**kwargs: Any) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/ma-cn-passport/app/createQRLogin"

    # Construct headers
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_qr_login_api_get_status_request(**kwargs: Any) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/ma-cn-passport/app/queryQRLoginStatus"

    # Construct headers
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_qr_login_api_login_by_mobile_captcha_request(**kwargs: Any) -> HttpRequest:  # pylint: disable=name-too-long
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/ma-cn-passport/app/loginByMobileCaptcha"

    # Construct headers
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_qr_login_api_login_by_auth_ticket_request(**kwargs: Any) -> HttpRequest:  # pylint: disable=name-too-long
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/ma-cn-passport/app/loginByAuthTicket"

    # Construct headers
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_session_api_get_token_by_game_token_request(**kwargs: Any) -> HttpRequest:  # pylint: disable=name-too-long
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


def build_session_api_exchange_request(**kwargs: Any) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/ma-cn-session/app/exchange"

    # Construct headers
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_account_token_api_get_cookie_account_info_by_s_token_request(  # pylint: disable=name-too-long
    *, cookie: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/auth/api/getCookieAccountInfoBySToken"

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, headers=_headers, **kwargs)


def build_account_token_api_get_l_token_by_s_token_request(  # pylint: disable=name-too-long
    *, cookie: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/account/auth/api/getLTokenBySToken"

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, headers=_headers, **kwargs)


class AuthTicketApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.PassportClient`'s
        :attr:`auth_ticket_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def create_by_game_biz(
        self, body: _models1.AuthTicketRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Creates an action ticket for a game-biz authentication flow.

        :param body: Required.
        :type body: ~uigf.passport.models.AuthTicketRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def create_by_game_biz(
        self, body: _types_models1.AuthTicketRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Creates an action ticket for a game-biz authentication flow.

        :param body: Required.
        :type body: ~uigf.passport.types.AuthTicketRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def create_by_game_biz(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Creates an action ticket for a game-biz authentication flow.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def create_by_game_biz(
        self, body: Union[_models1.AuthTicketRequest, _types_models1.AuthTicketRequest, IO[bytes]], **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Creates an action ticket for a game-biz authentication flow.

        :param body: Is either a AuthTicketRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.passport.models.AuthTicketRequest or ~uigf.passport.types.AuthTicketRequest
         or IO[bytes]
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
        cls: ClsType[_models2.ApiResponseTokenInfo] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_auth_ticket_api_create_by_game_biz_request(
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
            deserialized = _deserialize(_models2.ApiResponseTokenInfo, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class CaptchaApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.PassportClient`'s
        :attr:`captcha_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def create(
        self, body: _models1.LoginCaptchaRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """Starts the vendor login-captcha challenge. Solve it through the official flow.

        :param body: Required.
        :type body: ~uigf.passport.models.LoginCaptchaRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def create(
        self, body: _types_models1.LoginCaptchaRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """Starts the vendor login-captcha challenge. Solve it through the official flow.

        :param body: Required.
        :type body: ~uigf.passport.types.LoginCaptchaRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def create(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """Starts the vendor login-captcha challenge. Solve it through the official flow.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def create(
        self, body: Union[_models1.LoginCaptchaRequest, _types_models1.LoginCaptchaRequest, IO[bytes]], **kwargs: Any
    ) -> _models2.ApiResponseJsonObject:
        """Starts the vendor login-captcha challenge. Solve it through the official flow.

        :param body: Is either a LoginCaptchaRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.passport.models.LoginCaptchaRequest or
         ~uigf.passport.types.LoginCaptchaRequest or IO[bytes]
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

        _request = build_captcha_api_create_request(
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


class QrLoginApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.PassportClient`'s
        :attr:`qr_login_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def create(
        self, body: _models1.QrLoginCreateRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseQrLoginTicket:
        """Creates an official QR login ticket.

        :param body: Required.
        :type body: ~uigf.passport.models.QrLoginCreateRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseQrLoginTicket. The ApiResponseQrLoginTicket is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseQrLoginTicket
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def create(
        self, body: _types_models1.QrLoginCreateRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseQrLoginTicket:
        """Creates an official QR login ticket.

        :param body: Required.
        :type body: ~uigf.passport.types.QrLoginCreateRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseQrLoginTicket. The ApiResponseQrLoginTicket is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseQrLoginTicket
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def create(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseQrLoginTicket:
        """Creates an official QR login ticket.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseQrLoginTicket. The ApiResponseQrLoginTicket is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseQrLoginTicket
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def create(
        self, body: Union[_models1.QrLoginCreateRequest, _types_models1.QrLoginCreateRequest, IO[bytes]], **kwargs: Any
    ) -> _models2.ApiResponseQrLoginTicket:
        """Creates an official QR login ticket.

        :param body: Is either a QrLoginCreateRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.passport.models.QrLoginCreateRequest or
         ~uigf.passport.types.QrLoginCreateRequest or IO[bytes]
        :return: ApiResponseQrLoginTicket. The ApiResponseQrLoginTicket is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseQrLoginTicket
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
        cls: ClsType[_models2.ApiResponseQrLoginTicket] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_qr_login_api_create_request(
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
            deserialized = _deserialize(_models2.ApiResponseQrLoginTicket, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def get_status(
        self, body: _models1.QrLoginStatusRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseQrLoginStatus:
        """Queries an official QR login ticket.

        :param body: Required.
        :type body: ~uigf.passport.models.QrLoginStatusRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseQrLoginStatus. The ApiResponseQrLoginStatus is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseQrLoginStatus
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def get_status(
        self, body: _types_models1.QrLoginStatusRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseQrLoginStatus:
        """Queries an official QR login ticket.

        :param body: Required.
        :type body: ~uigf.passport.types.QrLoginStatusRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseQrLoginStatus. The ApiResponseQrLoginStatus is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseQrLoginStatus
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def get_status(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseQrLoginStatus:
        """Queries an official QR login ticket.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseQrLoginStatus. The ApiResponseQrLoginStatus is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseQrLoginStatus
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def get_status(
        self, body: Union[_models1.QrLoginStatusRequest, _types_models1.QrLoginStatusRequest, IO[bytes]], **kwargs: Any
    ) -> _models2.ApiResponseQrLoginStatus:
        """Queries an official QR login ticket.

        :param body: Is either a QrLoginStatusRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.passport.models.QrLoginStatusRequest or
         ~uigf.passport.types.QrLoginStatusRequest or IO[bytes]
        :return: ApiResponseQrLoginStatus. The ApiResponseQrLoginStatus is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseQrLoginStatus
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
        cls: ClsType[_models2.ApiResponseQrLoginStatus] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_qr_login_api_get_status_request(
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
            deserialized = _deserialize(_models2.ApiResponseQrLoginStatus, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def login_by_mobile_captcha(
        self, body: _models1.MobileCaptchaLoginRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Logs in with a mobile-number captcha obtained through the official flow.

        :param body: Required.
        :type body: ~uigf.passport.models.MobileCaptchaLoginRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def login_by_mobile_captcha(
        self, body: _types_models1.MobileCaptchaLoginRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Logs in with a mobile-number captcha obtained through the official flow.

        :param body: Required.
        :type body: ~uigf.passport.types.MobileCaptchaLoginRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def login_by_mobile_captcha(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Logs in with a mobile-number captcha obtained through the official flow.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def login_by_mobile_captcha(
        self,
        body: Union[_models1.MobileCaptchaLoginRequest, _types_models1.MobileCaptchaLoginRequest, IO[bytes]],
        **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Logs in with a mobile-number captcha obtained through the official flow.

        :param body: Is either a MobileCaptchaLoginRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.passport.models.MobileCaptchaLoginRequest or
         ~uigf.passport.types.MobileCaptchaLoginRequest or IO[bytes]
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
        cls: ClsType[_models2.ApiResponseTokenInfo] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_qr_login_api_login_by_mobile_captcha_request(
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
            deserialized = _deserialize(_models2.ApiResponseTokenInfo, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def login_by_auth_ticket(
        self, body: _models1.AuthTicketLoginRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges an official auth ticket for the associated login-session payload.

        :param body: Required.
        :type body: ~uigf.passport.models.AuthTicketLoginRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def login_by_auth_ticket(
        self, body: _types_models1.AuthTicketLoginRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges an official auth ticket for the associated login-session payload.

        :param body: Required.
        :type body: ~uigf.passport.types.AuthTicketLoginRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def login_by_auth_ticket(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges an official auth ticket for the associated login-session payload.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def login_by_auth_ticket(
        self,
        body: Union[_models1.AuthTicketLoginRequest, _types_models1.AuthTicketLoginRequest, IO[bytes]],
        **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges an official auth ticket for the associated login-session payload.

        :param body: Is either a AuthTicketLoginRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.passport.models.AuthTicketLoginRequest or
         ~uigf.passport.types.AuthTicketLoginRequest or IO[bytes]
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
        cls: ClsType[_models2.ApiResponseTokenInfo] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_qr_login_api_login_by_auth_ticket_request(
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
            deserialized = _deserialize(_models2.ApiResponseTokenInfo, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class SessionApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.PassportClient`'s
        :attr:`session_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def get_token_by_game_token(
        self, body: _models1.GameTokenRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges a game token for an SToken/session payload.

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
    def get_token_by_game_token(
        self, body: _types_models1.GameTokenRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges a game token for an SToken/session payload.

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
    def get_token_by_game_token(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges a game token for an SToken/session payload.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def get_token_by_game_token(
        self, body: Union[_models1.GameTokenRequest, _types_models1.GameTokenRequest, IO[bytes]], **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges a game token for an SToken/session payload.

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
        cls: ClsType[_models2.ApiResponseTokenInfo] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_session_api_get_token_by_game_token_request(
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
            deserialized = _deserialize(_models2.ApiResponseTokenInfo, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def exchange(
        self, body: _models1.TokenExchangeRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges a source token for the requested destination token type.

        :param body: Required.
        :type body: ~uigf.passport.models.TokenExchangeRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def exchange(
        self, body: _types_models1.TokenExchangeRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges a source token for the requested destination token type.

        :param body: Required.
        :type body: ~uigf.passport.types.TokenExchangeRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def exchange(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges a source token for the requested destination token type.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseTokenInfo. The ApiResponseTokenInfo is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseTokenInfo
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def exchange(
        self, body: Union[_models1.TokenExchangeRequest, _types_models1.TokenExchangeRequest, IO[bytes]], **kwargs: Any
    ) -> _models2.ApiResponseTokenInfo:
        """Exchanges a source token for the requested destination token type.

        :param body: Is either a TokenExchangeRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.passport.models.TokenExchangeRequest or
         ~uigf.passport.types.TokenExchangeRequest or IO[bytes]
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
        cls: ClsType[_models2.ApiResponseTokenInfo] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_session_api_exchange_request(
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
            deserialized = _deserialize(_models2.ApiResponseTokenInfo, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class AccountTokenApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.PassportClient`'s
        :attr:`account_token_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def get_cookie_account_info_by_s_token(self, *, cookie: str, **kwargs: Any) -> _models2.ApiResponseTokenInfo:
        """Returns account information for an authenticated SToken cookie.

        :keyword cookie: Required.
        :paramtype cookie: str
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

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        cls: ClsType[_models2.ApiResponseTokenInfo] = kwargs.pop("cls", None)

        _request = build_account_token_api_get_cookie_account_info_by_s_token_request(
            cookie=cookie,
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
            deserialized = _deserialize(_models2.ApiResponseTokenInfo, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_l_token_by_s_token(self, *, cookie: str, **kwargs: Any) -> _models2.ApiResponseTokenInfo:
        """Exchanges an SToken cookie for an LToken payload.

        :keyword cookie: Required.
        :paramtype cookie: str
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

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        cls: ClsType[_models2.ApiResponseTokenInfo] = kwargs.pop("cls", None)

        _request = build_account_token_api_get_l_token_by_s_token_request(
            cookie=cookie,
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
            deserialized = _deserialize(_models2.ApiResponseTokenInfo, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
