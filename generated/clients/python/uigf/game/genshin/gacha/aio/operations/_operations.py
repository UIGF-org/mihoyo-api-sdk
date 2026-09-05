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
from corehttp.rest import AsyncHttpResponse, HttpRequest
from corehttp.runtime import AsyncPipelineClient
from corehttp.runtime.pipeline import PipelineResponse

from ...... import models as _models5
from ......passport._utils.model_base import _deserialize
from ......passport._utils.serialization import Deserializer, Serializer
from ...operations._operations import (
    build_gacha_log_api_get_beyond_history_request,
    build_gacha_log_api_get_history_request,
)
from .._configuration import GachaClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class GachaLogApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.GachaClient`'s
        :attr:`gacha_log_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GachaClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def get_history(
        self,
        *,
        authkey: str,
        gacha_type: str,
        lang: str,
        auth_appid: str,
        end_id: Optional[str] = None,
        size: Optional[int] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseGachaLogPage:
        """get_history.

        :keyword authkey: Required.
        :paramtype authkey: str
        :keyword gacha_type: Required.
        :paramtype gacha_type: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword auth_appid: Required.
        :paramtype auth_appid: str
        :keyword end_id: Default value is None.
        :paramtype end_id: str
        :keyword size: Default value is None.
        :paramtype size: int
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
        cls: ClsType[_models5.ApiResponseGachaLogPage] = kwargs.pop("cls", None)

        _request = build_gacha_log_api_get_history_request(
            authkey=authkey,
            gacha_type=gacha_type,
            lang=lang,
            auth_appid=auth_appid,
            end_id=end_id,
            size=size,
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
            deserialized = _deserialize(_models5.ApiResponseGachaLogPage, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    async def get_beyond_history(
        self,
        *,
        authkey: str,
        gacha_type: str,
        lang: str,
        auth_appid: str,
        end_id: Optional[str] = None,
        size: Optional[int] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseGachaLogPage:
        """get_beyond_history.

        :keyword authkey: Required.
        :paramtype authkey: str
        :keyword gacha_type: Required.
        :paramtype gacha_type: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword auth_appid: Required.
        :paramtype auth_appid: str
        :keyword end_id: Default value is None.
        :paramtype end_id: str
        :keyword size: Default value is None.
        :paramtype size: int
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
        cls: ClsType[_models5.ApiResponseGachaLogPage] = kwargs.pop("cls", None)

        _request = build_gacha_log_api_get_beyond_history_request(
            authkey=authkey,
            gacha_type=gacha_type,
            lang=lang,
            auth_appid=auth_appid,
            end_id=end_id,
            size=size,
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
            deserialized = _deserialize(_models5.ApiResponseGachaLogPage, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
