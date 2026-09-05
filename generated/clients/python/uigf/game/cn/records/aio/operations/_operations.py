# pylint: disable=too-many-lines
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

from ...... import models as _models5
from ......passport._utils.model_base import _deserialize
from ......passport._utils.serialization import Deserializer, Serializer
from ...operations._operations import (
    build_honkai_impact_api_get_index_request,
    build_star_rail_api_get_apocalyptic_shadow_request,
    build_star_rail_api_get_challenge_peak_request,
    build_star_rail_api_get_daily_note_request,
    build_star_rail_api_get_forgotten_hall_request,
    build_star_rail_api_get_index_request,
    build_star_rail_api_get_pure_fiction_request,
    build_star_rail_api_get_simulated_universe_request,
    build_zenless_api_get_daily_note_request,
    build_zenless_api_get_deadly_assault_request,
    build_zenless_api_get_gacha_record_request,
    build_zenless_api_get_index_request,
    build_zenless_api_get_shiyu_defense_request,
    build_zenless_api_get_threshold_simulation_detail_request,
    build_zenless_api_get_threshold_simulation_summary_request,
)
from .._configuration import CnGameRecordsClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class HonkaiImpactApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.CnGameRecordsClient`'s
        :attr:`honkai_impact_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: CnGameRecordsClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def get_index(
        self, *, cookie: str, server: str, role_id: str, ds: Optional[str] = None, **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_index.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword ds: Default value is None.
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

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_honkai_impact_api_get_index_request(
            cookie=cookie,
            server=server,
            role_id=role_id,
            ds=ds,
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


class StarRailApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.CnGameRecordsClient`'s
        :attr:`star_rail_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: CnGameRecordsClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def get_index(
        self, *, cookie: str, ds: str, server: str, role_id: str, **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_index.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_star_rail_api_get_index_request(
            cookie=cookie,
            ds=ds,
            server=server,
            role_id=role_id,
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

    async def get_daily_note(
        self, *, cookie: str, ds: str, server: str, role_id: str, **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_daily_note.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_star_rail_api_get_daily_note_request(
            cookie=cookie,
            ds=ds,
            server=server,
            role_id=role_id,
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

    async def get_forgotten_hall(
        self,
        *,
        cookie: str,
        ds: str,
        server: str,
        role_id: str,
        schedule_type: Optional[int] = None,
        need_detail: Optional[bool] = None,
        need_all: Optional[bool] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_forgotten_hall.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword schedule_type: Default value is None.
        :paramtype schedule_type: int
        :keyword need_detail: Default value is None.
        :paramtype need_detail: bool
        :keyword need_all: Default value is None.
        :paramtype need_all: bool
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_star_rail_api_get_forgotten_hall_request(
            cookie=cookie,
            ds=ds,
            server=server,
            role_id=role_id,
            schedule_type=schedule_type,
            need_detail=need_detail,
            need_all=need_all,
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

    async def get_pure_fiction(
        self,
        *,
        cookie: str,
        ds: str,
        server: str,
        role_id: str,
        schedule_type: Optional[int] = None,
        need_detail: Optional[bool] = None,
        need_all: Optional[bool] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_pure_fiction.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword schedule_type: Default value is None.
        :paramtype schedule_type: int
        :keyword need_detail: Default value is None.
        :paramtype need_detail: bool
        :keyword need_all: Default value is None.
        :paramtype need_all: bool
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_star_rail_api_get_pure_fiction_request(
            cookie=cookie,
            ds=ds,
            server=server,
            role_id=role_id,
            schedule_type=schedule_type,
            need_detail=need_detail,
            need_all=need_all,
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

    async def get_apocalyptic_shadow(
        self,
        *,
        cookie: str,
        ds: str,
        server: str,
        role_id: str,
        schedule_type: Optional[int] = None,
        need_detail: Optional[bool] = None,
        need_all: Optional[bool] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_apocalyptic_shadow.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword schedule_type: Default value is None.
        :paramtype schedule_type: int
        :keyword need_detail: Default value is None.
        :paramtype need_detail: bool
        :keyword need_all: Default value is None.
        :paramtype need_all: bool
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_star_rail_api_get_apocalyptic_shadow_request(
            cookie=cookie,
            ds=ds,
            server=server,
            role_id=role_id,
            schedule_type=schedule_type,
            need_detail=need_detail,
            need_all=need_all,
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

    async def get_simulated_universe(
        self,
        *,
        cookie: str,
        ds: str,
        server: str,
        role_id: str,
        schedule_type: Optional[int] = None,
        need_detail: Optional[bool] = None,
        need_all: Optional[bool] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_simulated_universe.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword schedule_type: Default value is None.
        :paramtype schedule_type: int
        :keyword need_detail: Default value is None.
        :paramtype need_detail: bool
        :keyword need_all: Default value is None.
        :paramtype need_all: bool
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_star_rail_api_get_simulated_universe_request(
            cookie=cookie,
            ds=ds,
            server=server,
            role_id=role_id,
            schedule_type=schedule_type,
            need_detail=need_detail,
            need_all=need_all,
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

    async def get_challenge_peak(
        self,
        *,
        cookie: str,
        ds: str,
        server: str,
        role_id: str,
        schedule_type: Optional[int] = None,
        need_detail: Optional[bool] = None,
        need_all: Optional[bool] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_challenge_peak.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword schedule_type: Default value is None.
        :paramtype schedule_type: int
        :keyword need_detail: Default value is None.
        :paramtype need_detail: bool
        :keyword need_all: Default value is None.
        :paramtype need_all: bool
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_star_rail_api_get_challenge_peak_request(
            cookie=cookie,
            ds=ds,
            server=server,
            role_id=role_id,
            schedule_type=schedule_type,
            need_detail=need_detail,
            need_all=need_all,
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


class ZenlessApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.CnGameRecordsClient`'s
        :attr:`zenless_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: CnGameRecordsClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def get_index(
        self, *, cookie: str, server: str, role_id: str, ds: Optional[str] = None, **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_index.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword ds: Default value is None.
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

        _headers = kwargs.pop("headers", {}) or {}
        _params = kwargs.pop("params", {}) or {}

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_zenless_api_get_index_request(
            cookie=cookie,
            server=server,
            role_id=role_id,
            ds=ds,
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

    async def get_daily_note(
        self, *, cookie: str, server: str, role_id: str, **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_daily_note.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_zenless_api_get_daily_note_request(
            cookie=cookie,
            server=server,
            role_id=role_id,
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

    async def get_gacha_record(
        self,
        *,
        cookie: str,
        uid: str,
        region: str,
        gacha_type: int,
        end_id: Optional[int] = None,
        lang: Optional[str] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseGachaLogPage:
        """get_gacha_record.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword uid: Required.
        :paramtype uid: str
        :keyword region: Required.
        :paramtype region: str
        :keyword gacha_type: Required.
        :paramtype gacha_type: int
        :keyword end_id: Default value is None.
        :paramtype end_id: int
        :keyword lang: Default value is None.
        :paramtype lang: str
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

        cls: ClsType[_models5.ApiResponseGachaLogPage] = kwargs.pop("cls", None)

        _request = build_zenless_api_get_gacha_record_request(
            cookie=cookie,
            uid=uid,
            region=region,
            gacha_type=gacha_type,
            end_id=end_id,
            lang=lang,
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

    async def get_shiyu_defense(
        self,
        *,
        cookie: str,
        ds: str,
        server: str,
        role_id: str,
        schedule_type: Optional[int] = None,
        need_detail: Optional[bool] = None,
        need_all: Optional[bool] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_shiyu_defense.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword server: Required.
        :paramtype server: str
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword schedule_type: Default value is None.
        :paramtype schedule_type: int
        :keyword need_detail: Default value is None.
        :paramtype need_detail: bool
        :keyword need_all: Default value is None.
        :paramtype need_all: bool
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_zenless_api_get_shiyu_defense_request(
            cookie=cookie,
            ds=ds,
            server=server,
            role_id=role_id,
            schedule_type=schedule_type,
            need_detail=need_detail,
            need_all=need_all,
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

    async def get_deadly_assault(
        self, *, cookie: str, ds: str, schedule_type: int, region: str, uid: str, **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_deadly_assault.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword ds: Required.
        :paramtype ds: str
        :keyword schedule_type: Required.
        :paramtype schedule_type: int
        :keyword region: Required.
        :paramtype region: str
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_zenless_api_get_deadly_assault_request(
            cookie=cookie,
            ds=ds,
            schedule_type=schedule_type,
            region=region,
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

    async def get_threshold_simulation_summary(
        self, *, cookie: str, region: str, uid: str, **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_threshold_simulation_summary.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword region: Required.
        :paramtype region: str
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_zenless_api_get_threshold_simulation_summary_request(
            cookie=cookie,
            region=region,
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

    async def get_threshold_simulation_detail(
        self, *, cookie: str, region: str, uid: str, void_front_id: int, **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_threshold_simulation_detail.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword region: Required.
        :paramtype region: str
        :keyword uid: Required.
        :paramtype uid: str
        :keyword void_front_id: Required.
        :paramtype void_front_id: int
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

        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_zenless_api_get_threshold_simulation_detail_request(
            cookie=cookie,
            region=region,
            uid=uid,
            void_front_id=void_front_id,
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
