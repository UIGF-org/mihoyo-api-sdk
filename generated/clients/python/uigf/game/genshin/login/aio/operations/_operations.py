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

from ..... import models as _models4, types as _types_models4
from ...... import models as _models5
from ......passport._utils.model_base import SdkJSONEncoder, _deserialize
from ......passport._utils.serialization import Deserializer, Serializer
from ....sdk import models as _sdk_models4, types as _types_sdk_models4
from ...operations._operations import (
    build_granter_api_login_request,
    build_panda_qr_api_create_request,
    build_panda_qr_api_get_status_request,
)
from .._configuration import LoginClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class PandaQrApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.LoginClient`'s
        :attr:`panda_qr_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: LoginClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    async def create(
        self, body: _models4.PandaQrRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models5.ApiResponsePandaQrResponse:
        """The upstream endpoint is deprecated; use only where officially supported.

        :param body: Required.
        :type body: ~uigf.game.models.PandaQrRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponsePandaQrResponse. The ApiResponsePandaQrResponse is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponsePandaQrResponse
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def create(
        self, body: _types_models4.PandaQrRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models5.ApiResponsePandaQrResponse:
        """The upstream endpoint is deprecated; use only where officially supported.

        :param body: Required.
        :type body: ~uigf.game.types.PandaQrRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponsePandaQrResponse. The ApiResponsePandaQrResponse is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponsePandaQrResponse
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def create(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models5.ApiResponsePandaQrResponse:
        """The upstream endpoint is deprecated; use only where officially supported.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponsePandaQrResponse. The ApiResponsePandaQrResponse is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponsePandaQrResponse
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    async def create(
        self, body: Union[_models4.PandaQrRequest, _types_models4.PandaQrRequest, IO[bytes]], **kwargs: Any
    ) -> _models5.ApiResponsePandaQrResponse:
        """The upstream endpoint is deprecated; use only where officially supported.

        :param body: Is either a PandaQrRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.models.PandaQrRequest or ~uigf.game.types.PandaQrRequest or IO[bytes]
        :return: ApiResponsePandaQrResponse. The ApiResponsePandaQrResponse is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponsePandaQrResponse
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
        cls: ClsType[_models5.ApiResponsePandaQrResponse] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_panda_qr_api_create_request(
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
            deserialized = _deserialize(_models5.ApiResponsePandaQrResponse, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    async def get_status(
        self, body: _models4.PandaQrRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models5.ApiResponsePandaQrResponse:
        """The upstream endpoint is deprecated; use only where officially supported.

        :param body: Required.
        :type body: ~uigf.game.models.PandaQrRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponsePandaQrResponse. The ApiResponsePandaQrResponse is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponsePandaQrResponse
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def get_status(
        self, body: _types_models4.PandaQrRequest, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models5.ApiResponsePandaQrResponse:
        """The upstream endpoint is deprecated; use only where officially supported.

        :param body: Required.
        :type body: ~uigf.game.types.PandaQrRequest
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponsePandaQrResponse. The ApiResponsePandaQrResponse is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponsePandaQrResponse
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def get_status(
        self, body: IO[bytes], *, content_type: str = "application/json", **kwargs: Any
    ) -> _models5.ApiResponsePandaQrResponse:
        """The upstream endpoint is deprecated; use only where officially supported.

        :param body: Required.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponsePandaQrResponse. The ApiResponsePandaQrResponse is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponsePandaQrResponse
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    async def get_status(
        self, body: Union[_models4.PandaQrRequest, _types_models4.PandaQrRequest, IO[bytes]], **kwargs: Any
    ) -> _models5.ApiResponsePandaQrResponse:
        """The upstream endpoint is deprecated; use only where officially supported.

        :param body: Is either a PandaQrRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.models.PandaQrRequest or ~uigf.game.types.PandaQrRequest or IO[bytes]
        :return: ApiResponsePandaQrResponse. The ApiResponsePandaQrResponse is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponsePandaQrResponse
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
        cls: ClsType[_models5.ApiResponsePandaQrResponse] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_panda_qr_api_get_status_request(
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
            deserialized = _deserialize(_models5.ApiResponsePandaQrResponse, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class GranterApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.LoginClient`'s
        :attr:`granter_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: LoginClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    async def login(
        self,
        body: _sdk_models4.GranterLoginRequest,
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """Submits the caller-provided official granter login payload.

        :param body: Required.
        :type body: ~uigf.game.genshin.sdk.models.GranterLoginRequest
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def login(
        self,
        body: _types_sdk_models4.GranterLoginRequest,
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """Submits the caller-provided official granter login payload.

        :param body: Required.
        :type body: ~uigf.game.genshin.sdk.types.GranterLoginRequest
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def login(
        self,
        body: IO[bytes],
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """Submits the caller-provided official granter login payload.

        :param body: Required.
        :type body: IO[bytes]
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    async def login(  # pylint: disable=too-many-locals
        self,
        body: Union[_sdk_models4.GranterLoginRequest, _types_sdk_models4.GranterLoginRequest, IO[bytes]],
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """Submits the caller-provided official granter login payload.

        :param body: Is either a GranterLoginRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.genshin.sdk.models.GranterLoginRequest or
         ~uigf.game.genshin.sdk.types.GranterLoginRequest or IO[bytes]
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
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
        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_granter_api_login_request(
            rpc_app_id=rpc_app_id,
            rpc_app_version=rpc_app_version,
            rpc_channel_id=rpc_channel_id,
            rpc_channel_version=rpc_channel_version,
            rpc_client_type=rpc_client_type,
            rpc_combo_version=rpc_combo_version,
            rpc_device_fingerprint=rpc_device_fingerprint,
            rpc_device_id=rpc_device_id,
            rpc_device_model=rpc_device_model,
            rpc_device_name=rpc_device_name,
            rpc_game_biz=rpc_game_biz,
            rpc_goods_third_party=rpc_goods_third_party,
            rpc_language=rpc_language,
            rpc_mdk_version=rpc_mdk_version,
            rpc_payment_version=rpc_payment_version,
            rpc_sdk_version=rpc_sdk_version,
            rpc_sub_channel_id=rpc_sub_channel_id,
            rpc_system_version=rpc_system_version,
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
            deserialized = _deserialize(_models5.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
