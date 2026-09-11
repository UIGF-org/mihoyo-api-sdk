# coding=utf-8
from collections.abc import MutableMapping
from typing import Any, Callable, Optional, TypeVar

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

from ....... import models as _models6
from .......passport._utils.model_base import _deserialize
from .......passport._utils.serialization import Deserializer, Serializer
from ...operations._operations import (
    build_config_api_get_combo_request,
    build_config_api_get_granter_config_request,
    build_config_api_get_precache_request,
    build_config_api_get_shield_config_request,
)
from .._configuration import ConfigClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class ConfigApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.ConfigClient`'s
        :attr:`config_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: ConfigClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def get_combo(  # pylint: disable=too-many-locals
        self,
        *,
        biz_key: str,
        client_type: str,
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
    ) -> _models6.ApiResponseJsonObject:
        """get_combo.

        :keyword biz_key: Required.
        :paramtype biz_key: str
        :keyword client_type: Required.
        :paramtype client_type: str
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

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        cls: ClsType[_models6.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_config_api_get_combo_request(
            biz_key=biz_key,
            client_type=client_type,
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
            deserialized = _deserialize(_models6.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    async def get_precache(  # pylint: disable=too-many-locals
        self,
        *,
        biz: str,
        client: str,
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
    ) -> _models6.ApiResponseJsonObject:
        """get_precache.

        :keyword biz: Required.
        :paramtype biz: str
        :keyword client: Required.
        :paramtype client: str
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

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        cls: ClsType[_models6.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_config_api_get_precache_request(
            biz=biz,
            client=client,
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
            deserialized = _deserialize(_models6.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    async def get_granter_config(  # pylint: disable=too-many-locals
        self,
        *,
        app_id: str,
        channel_id: str,
        client_type: str,
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
    ) -> _models6.ApiResponseJsonObject:
        """get_granter_config.

        :keyword app_id: Required.
        :paramtype app_id: str
        :keyword channel_id: Required.
        :paramtype channel_id: str
        :keyword client_type: Required.
        :paramtype client_type: str
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

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        cls: ClsType[_models6.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_config_api_get_granter_config_request(
            app_id=app_id,
            channel_id=channel_id,
            client_type=client_type,
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
            deserialized = _deserialize(_models6.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    async def get_shield_config(  # pylint: disable=too-many-locals
        self,
        *,
        client: str,
        game_key: str,
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
    ) -> _models6.ApiResponseJsonObject:
        """get_shield_config.

        :keyword client: Required.
        :paramtype client: str
        :keyword game_key: Required.
        :paramtype game_key: str
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

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        cls: ClsType[_models6.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_config_api_get_shield_config_request(
            client=client,
            game_key=game_key,
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
            deserialized = _deserialize(_models6.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
