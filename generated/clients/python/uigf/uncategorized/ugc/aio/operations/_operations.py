# coding=utf-8
from collections.abc import MutableMapping
from typing import Any, AsyncIterator, Callable, IO, Literal, Optional, TypeVar, Union, overload

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

from ..... import models as _models4
from .....passport._utils.model_base import _deserialize
from .....passport._utils.serialization import Deserializer, Serializer
from ...operations._operations import (
    build_level_api_get_collection_tiny_info_request,
    build_level_api_get_index_redpoint_request,
    build_token_api_get_request,
)
from .._configuration import UGCClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class TokenApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.UGCClient`'s
        :attr:`token_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: UGCClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def get(self, *, authkey: str, auth_appid: str, lang: str, **kwargs: Any) -> _models4.ApiResponseJsonObject:
        """get.

        :keyword authkey: Required.
        :paramtype authkey: str
        :keyword auth_appid: Required.
        :paramtype auth_appid: str
        :keyword lang: Required.
        :paramtype lang: str
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

        authkey_ver: Literal["1"] = kwargs.pop("authkey_ver", _params.pop("authkey_ver", "1"))
        sign_type: Literal["2"] = kwargs.pop("sign_type", _params.pop("sign_type", "2"))
        cls: ClsType[_models4.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_token_api_get_request(
            authkey=authkey,
            auth_appid=auth_appid,
            lang=lang,
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
            deserialized = _deserialize(_models4.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class LevelApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.UGCClient`'s
        :attr:`level_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: UGCClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def get_index_redpoint(self, **kwargs: Any) -> AsyncIterator[bytes]:
        """The observed request and response use the vendor's protobuf media type.

        :return: AsyncIterator[bytes]
        :rtype: AsyncIterator[bytes]
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

        cls: ClsType[AsyncIterator[bytes]] = kwargs.pop("cls", None)

        _request = build_level_api_get_index_redpoint_request(
            headers=_headers,
            params=_params,
        )
        path_format_arguments = {
            "endpoint": self._serialize.url("self._config.endpoint", self._config.endpoint, "str", skip_quote=True),
        }
        _request.url = self._client.format_url(_request.url, **path_format_arguments)

        _decompress = kwargs.pop("decompress", True)
        _stream = kwargs.pop("stream", True)
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

        deserialized = response.iter_bytes() if _decompress else response.iter_raw()

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    async def get_collection_tiny_info(
        self, body: bytes, *, content_type: str = "application/octet-stream", **kwargs: Any
    ) -> AsyncIterator[bytes]:
        """The gateway payload is opaque protobuf data in the available capture.

        :param body: Required.
        :type body: bytes
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/octet-stream".
        :paramtype content_type: str
        :return: AsyncIterator[bytes]
        :rtype: AsyncIterator[bytes]
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def get_collection_tiny_info(
        self, body: IO[bytes], *, content_type: str = "application/octet-stream", **kwargs: Any
    ) -> AsyncIterator[bytes]:
        """The gateway payload is opaque protobuf data in the available capture.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/octet-stream".
        :paramtype content_type: str
        :return: AsyncIterator[bytes]
        :rtype: AsyncIterator[bytes]
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    async def get_collection_tiny_info(self, body: Union[bytes, IO[bytes]], **kwargs: Any) -> AsyncIterator[bytes]:
        """The gateway payload is opaque protobuf data in the available capture.

        :param body: Is either a bytes type or a IO[bytes] type. Required.
        :type body: bytes or IO[bytes]
        :return: AsyncIterator[bytes]
        :rtype: AsyncIterator[bytes]
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
        cls: ClsType[AsyncIterator[bytes]] = kwargs.pop("cls", None)

        content_type = content_type or "application/octet-stream"
        _content = body

        _request = build_level_api_get_collection_tiny_info_request(
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
        _stream = kwargs.pop("stream", True)
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

        deserialized = response.iter_bytes() if _decompress else response.iter_raw()

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
