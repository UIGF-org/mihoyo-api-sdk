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
    build_announcement_api_get_alert_picture_request,
    build_announcement_api_get_alert_request,
    build_announcement_api_list_request,
)
from .._configuration import AnnouncementsClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class AnnouncementApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.AnnouncementsClient`'s
        :attr:`announcement_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: AnnouncementsClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def list(
        self,
        *,
        game: str,
        game_biz: str,
        lang: str,
        bundle_id: str,
        platform: Literal["pc", "android", "ios"],
        region: str,
        level: Optional[int] = None,
        uid: Optional[str] = None,
        channel_id: Optional[int] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseAnnouncementList:
        """list.

        :keyword game: Required.
        :paramtype game: str
        :keyword game_biz: Required.
        :paramtype game_biz: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword bundle_id: Required.
        :paramtype bundle_id: str
        :keyword platform: Is one of the following types: Literal["pc"], Literal["android"],
         Literal["ios"] Required.
        :paramtype platform: str or str or str
        :keyword region: Required.
        :paramtype region: str
        :keyword level: Default value is None.
        :paramtype level: int
        :keyword uid: Default value is None.
        :paramtype uid: str
        :keyword channel_id: Default value is None.
        :paramtype channel_id: int
        :return: ApiResponseAnnouncementList. The ApiResponseAnnouncementList is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseAnnouncementList
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

        cls: ClsType[_models5.ApiResponseAnnouncementList] = kwargs.pop("cls", None)

        _request = build_announcement_api_list_request(
            game=game,
            game_biz=game_biz,
            lang=lang,
            bundle_id=bundle_id,
            platform=platform,
            region=region,
            level=level,
            uid=uid,
            channel_id=channel_id,
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
            deserialized = _deserialize(_models5.ApiResponseAnnouncementList, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    async def get_alert(
        self,
        *,
        game: str,
        game_biz: str,
        lang: str,
        bundle_id: str,
        platform: Literal["pc", "android", "ios"],
        region: str,
        level: Optional[int] = None,
        uid: Optional[str] = None,
        channel_id: Optional[int] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseAnnouncementList:
        """get_alert.

        :keyword game: Required.
        :paramtype game: str
        :keyword game_biz: Required.
        :paramtype game_biz: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword bundle_id: Required.
        :paramtype bundle_id: str
        :keyword platform: Is one of the following types: Literal["pc"], Literal["android"],
         Literal["ios"] Required.
        :paramtype platform: str or str or str
        :keyword region: Required.
        :paramtype region: str
        :keyword level: Default value is None.
        :paramtype level: int
        :keyword uid: Default value is None.
        :paramtype uid: str
        :keyword channel_id: Default value is None.
        :paramtype channel_id: int
        :return: ApiResponseAnnouncementList. The ApiResponseAnnouncementList is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseAnnouncementList
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

        cls: ClsType[_models5.ApiResponseAnnouncementList] = kwargs.pop("cls", None)

        _request = build_announcement_api_get_alert_request(
            game=game,
            game_biz=game_biz,
            lang=lang,
            bundle_id=bundle_id,
            platform=platform,
            region=region,
            level=level,
            uid=uid,
            channel_id=channel_id,
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
            deserialized = _deserialize(_models5.ApiResponseAnnouncementList, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    async def get_alert_picture(
        self,
        *,
        game: str,
        game_biz: str,
        lang: str,
        bundle_id: str,
        platform: Literal["pc", "android", "ios"],
        region: str,
        level: Optional[int] = None,
        uid: Optional[str] = None,
        channel_id: Optional[int] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseAnnouncementList:
        """get_alert_picture.

        :keyword game: Required.
        :paramtype game: str
        :keyword game_biz: Required.
        :paramtype game_biz: str
        :keyword lang: Required.
        :paramtype lang: str
        :keyword bundle_id: Required.
        :paramtype bundle_id: str
        :keyword platform: Is one of the following types: Literal["pc"], Literal["android"],
         Literal["ios"] Required.
        :paramtype platform: str or str or str
        :keyword region: Required.
        :paramtype region: str
        :keyword level: Default value is None.
        :paramtype level: int
        :keyword uid: Default value is None.
        :paramtype uid: str
        :keyword channel_id: Default value is None.
        :paramtype channel_id: int
        :return: ApiResponseAnnouncementList. The ApiResponseAnnouncementList is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseAnnouncementList
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

        cls: ClsType[_models5.ApiResponseAnnouncementList] = kwargs.pop("cls", None)

        _request = build_announcement_api_get_alert_picture_request(
            game=game,
            game_biz=game_biz,
            lang=lang,
            bundle_id=bundle_id,
            platform=platform,
            region=region,
            level=level,
            uid=uid,
            channel_id=channel_id,
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
            deserialized = _deserialize(_models5.ApiResponseAnnouncementList, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
