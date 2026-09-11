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
from corehttp.rest import AsyncHttpResponse, HttpRequest
from corehttp.runtime import AsyncPipelineClient
from corehttp.runtime.pipeline import PipelineResponse
from corehttp.utils import case_insensitive_dict

from ... import models as _models2, types as _types_models2
from .... import models as _models3
from ..._utils.model_base import SdkJSONEncoder, _deserialize
from ..._utils.serialization import Deserializer, Serializer
from ...operations._operations import (
    build_account_token_api_get_cookie_account_info_by_s_token_request,
    build_account_token_api_get_l_token_by_s_token_request,
    build_auth_ticket_api_create_by_game_biz_request,
    build_captcha_api_create_request,
    build_qr_login_api_create_request,
    build_qr_login_api_get_status_request,
    build_qr_login_api_login_by_auth_ticket_request,
    build_qr_login_api_login_by_mobile_captcha_request,
    build_session_api_exchange_request,
    build_session_api_get_token_by_game_token_request,
)
from .._configuration import PassportClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class AuthTicketApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.PassportClient`'s
        :attr:`auth_ticket_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    async def create_by_game_biz(
        self, body: _models2.AuthTicketRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def create_by_game_biz(
        self, body: _types_models2.AuthTicketRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def create_by_game_biz(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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

    async def create_by_game_biz(
        self, body: Union[_models2.AuthTicketRequest, _types_models2.AuthTicketRequest, IO[bytes]], **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
        cls: ClsType[_models3.ApiResponseTokenInfo] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
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


class CaptchaApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.PassportClient`'s
        :attr:`captcha_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    async def create(
        self, body: _models2.LoginCaptchaRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
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
    async def create(
        self, body: _types_models2.LoginCaptchaRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
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
    async def create(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
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

    async def create(
        self, body: Union[_models2.LoginCaptchaRequest, _types_models2.LoginCaptchaRequest, IO[bytes]], **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
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
        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
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


class QrLoginApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.PassportClient`'s
        :attr:`qr_login_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    async def create(
        self, body: _models2.QrLoginCreateRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseQrLoginTicket:
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
    async def create(
        self, body: _types_models2.QrLoginCreateRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseQrLoginTicket:
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
    async def create(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseQrLoginTicket:
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

    async def create(
        self, body: Union[_models2.QrLoginCreateRequest, _types_models2.QrLoginCreateRequest, IO[bytes]], **kwargs: Any
    ) -> _models3.ApiResponseQrLoginTicket:
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
        cls: ClsType[_models3.ApiResponseQrLoginTicket] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
                except (StreamConsumedError, StreamClosedError):
                    pass
            map_error(status_code=response.status_code, response=response, error_map=error_map)
            raise HttpResponseError(response=response)

        if _stream:
            deserialized = response.iter_bytes() if _decompress else response.iter_raw()
        else:
            deserialized = _deserialize(_models3.ApiResponseQrLoginTicket, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    async def get_status(
        self, body: _models2.QrLoginStatusRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseQrLoginStatus:
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
    async def get_status(
        self, body: _types_models2.QrLoginStatusRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseQrLoginStatus:
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
    async def get_status(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseQrLoginStatus:
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

    async def get_status(
        self, body: Union[_models2.QrLoginStatusRequest, _types_models2.QrLoginStatusRequest, IO[bytes]], **kwargs: Any
    ) -> _models3.ApiResponseQrLoginStatus:
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
        cls: ClsType[_models3.ApiResponseQrLoginStatus] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
                except (StreamConsumedError, StreamClosedError):
                    pass
            map_error(status_code=response.status_code, response=response, error_map=error_map)
            raise HttpResponseError(response=response)

        if _stream:
            deserialized = response.iter_bytes() if _decompress else response.iter_raw()
        else:
            deserialized = _deserialize(_models3.ApiResponseQrLoginStatus, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    async def login_by_mobile_captcha(
        self, body: _models2.MobileCaptchaLoginRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def login_by_mobile_captcha(
        self, body: _types_models2.MobileCaptchaLoginRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def login_by_mobile_captcha(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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

    async def login_by_mobile_captcha(
        self,
        body: Union[_models2.MobileCaptchaLoginRequest, _types_models2.MobileCaptchaLoginRequest, IO[bytes]],
        **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
        cls: ClsType[_models3.ApiResponseTokenInfo] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
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

    @overload
    async def login_by_auth_ticket(
        self, body: _models2.AuthTicketLoginRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def login_by_auth_ticket(
        self, body: _types_models2.AuthTicketLoginRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def login_by_auth_ticket(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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

    async def login_by_auth_ticket(
        self,
        body: Union[_models2.AuthTicketLoginRequest, _types_models2.AuthTicketLoginRequest, IO[bytes]],
        **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
        cls: ClsType[_models3.ApiResponseTokenInfo] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
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


class SessionApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.PassportClient`'s
        :attr:`session_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    async def get_token_by_game_token(
        self, body: _models2.GameTokenRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def get_token_by_game_token(
        self, body: _types_models2.GameTokenRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def get_token_by_game_token(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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

    async def get_token_by_game_token(
        self, body: Union[_models2.GameTokenRequest, _types_models2.GameTokenRequest, IO[bytes]], **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
        cls: ClsType[_models3.ApiResponseTokenInfo] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
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

    @overload
    async def exchange(
        self, body: _models2.TokenExchangeRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def exchange(
        self, body: _types_models2.TokenExchangeRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
    async def exchange(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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

    async def exchange(
        self, body: Union[_models2.TokenExchangeRequest, _types_models2.TokenExchangeRequest, IO[bytes]], **kwargs: Any
    ) -> _models3.ApiResponseTokenInfo:
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
        cls: ClsType[_models3.ApiResponseTokenInfo] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
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


class AccountTokenApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.PassportClient`'s
        :attr:`account_token_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: PassportClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def get_cookie_account_info_by_s_token(self, *, cookie: str, **kwargs: Any) -> _models3.ApiResponseTokenInfo:
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

        cls: ClsType[_models3.ApiResponseTokenInfo] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
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

    async def get_l_token_by_s_token(self, *, cookie: str, **kwargs: Any) -> _models3.ApiResponseTokenInfo:
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

        cls: ClsType[_models3.ApiResponseTokenInfo] = kwargs.pop("cls", None)

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
        pipeline_response: PipelineResponse = await self._client.pipeline.run(_request, stream=_stream, **kwargs)

        response = pipeline_response.http_response

        if response.status_code not in [200]:
            if _stream:
                try:
                    await response.read()  # Load the body in memory and close the socket
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
