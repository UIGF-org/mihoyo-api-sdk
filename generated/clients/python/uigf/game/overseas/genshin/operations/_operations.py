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
from corehttp.rest import HttpRequest, HttpResponse
from corehttp.runtime import PipelineClient
from corehttp.runtime.pipeline import PipelineResponse
from corehttp.utils import case_insensitive_dict

from ..... import models as _models4
from .....passport._utils.model_base import _deserialize
from .....passport._utils.serialization import Deserializer, Serializer
from .._configuration import GenshinClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_announcement_api_list_request(
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
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/common/hk4e_global/announcement/api/getAnnList"

    # Construct parameters
    _params["game"] = _SERIALIZER.query("game", game, "str")
    _params["game_biz"] = _SERIALIZER.query("game_biz", game_biz, "str")
    _params["lang"] = _SERIALIZER.query("lang", lang, "str")
    _params["bundle_id"] = _SERIALIZER.query("bundle_id", bundle_id, "str")
    _params["platform"] = _SERIALIZER.query("platform", platform, "str")
    _params["region"] = _SERIALIZER.query("region", region, "str")
    if level is not None:
        _params["level"] = _SERIALIZER.query("level", level, "int")
    if uid is not None:
        _params["uid"] = _SERIALIZER.query("uid", uid, "str")
    if channel_id is not None:
        _params["channel_id"] = _SERIALIZER.query("channel_id", channel_id, "int")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_announcement_api_get_content_request(  # pylint: disable=name-too-long
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
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/common/hk4e_global/announcement/api/getAnnContent"

    # Construct parameters
    _params["game"] = _SERIALIZER.query("game", game, "str")
    _params["game_biz"] = _SERIALIZER.query("game_biz", game_biz, "str")
    _params["lang"] = _SERIALIZER.query("lang", lang, "str")
    _params["bundle_id"] = _SERIALIZER.query("bundle_id", bundle_id, "str")
    _params["platform"] = _SERIALIZER.query("platform", platform, "str")
    _params["region"] = _SERIALIZER.query("region", region, "str")
    if level is not None:
        _params["level"] = _SERIALIZER.query("level", level, "int")
    if uid is not None:
        _params["uid"] = _SERIALIZER.query("uid", uid, "str")
    if channel_id is not None:
        _params["channel_id"] = _SERIALIZER.query("channel_id", channel_id, "int")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_announcement_api_get_alert_request(
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
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/common/hk4e_global/announcement/api/getAlertAnn"

    # Construct parameters
    _params["game"] = _SERIALIZER.query("game", game, "str")
    _params["game_biz"] = _SERIALIZER.query("game_biz", game_biz, "str")
    _params["lang"] = _SERIALIZER.query("lang", lang, "str")
    _params["bundle_id"] = _SERIALIZER.query("bundle_id", bundle_id, "str")
    _params["platform"] = _SERIALIZER.query("platform", platform, "str")
    _params["region"] = _SERIALIZER.query("region", region, "str")
    if level is not None:
        _params["level"] = _SERIALIZER.query("level", level, "int")
    if uid is not None:
        _params["uid"] = _SERIALIZER.query("uid", uid, "str")
    if channel_id is not None:
        _params["channel_id"] = _SERIALIZER.query("channel_id", channel_id, "int")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_ledger_api_get_month_info_request(
    *, cookie: str, role_id: str, server: str, month: Optional[str] = None, lang: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/ysledgeros/month_info"

    # Construct parameters
    if month is not None:
        _params["month"] = _SERIALIZER.query("month", month, "str")
    if lang is not None:
        _params["lang"] = _SERIALIZER.query("lang", lang, "str")
    _params["role_id"] = _SERIALIZER.query("role_id", role_id, "str")
    _params["server"] = _SERIALIZER.query("server", server, "str")

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_ledger_api_get_month_detail_request(  # pylint: disable=name-too-long
    *,
    cookie: str,
    type: int,
    current_page: int,
    role_id: str,
    server: str,
    month: Optional[str] = None,
    lang: Optional[str] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/ysledgeros/month_detail"

    # Construct parameters
    _params["type"] = _SERIALIZER.query("type", type, "int")
    _params["current_page"] = _SERIALIZER.query("current_page", current_page, "int")
    if month is not None:
        _params["month"] = _SERIALIZER.query("month", month, "str")
    if lang is not None:
        _params["lang"] = _SERIALIZER.query("lang", lang, "str")
    _params["role_id"] = _SERIALIZER.query("role_id", role_id, "str")
    _params["server"] = _SERIALIZER.query("server", server, "str")

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


class AnnouncementApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.GenshinClient`'s
        :attr:`announcement_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GenshinClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def list(
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
    ) -> _models4.ApiResponseAnnouncementList:
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

        cls: ClsType[_models4.ApiResponseAnnouncementList] = kwargs.pop("cls", None)

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
            deserialized = _deserialize(_models4.ApiResponseAnnouncementList, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_content(
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
    ) -> _models4.ApiResponseAnnouncementList:
        """get_content.

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

        cls: ClsType[_models4.ApiResponseAnnouncementList] = kwargs.pop("cls", None)

        _request = build_announcement_api_get_content_request(
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
            deserialized = _deserialize(_models4.ApiResponseAnnouncementList, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_alert(
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
    ) -> _models4.ApiResponseAnnouncementList:
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

        cls: ClsType[_models4.ApiResponseAnnouncementList] = kwargs.pop("cls", None)

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
            deserialized = _deserialize(_models4.ApiResponseAnnouncementList, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore


class LedgerApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.GenshinClient`'s
        :attr:`ledger_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GenshinClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def get_month_info(
        self,
        *,
        cookie: str,
        role_id: str,
        server: str,
        month: Optional[str] = None,
        lang: Optional[str] = None,
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """get_month_info.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword server: Required.
        :paramtype server: str
        :keyword month: Default value is None.
        :paramtype month: str
        :keyword lang: Default value is None.
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

        cls: ClsType[_models4.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_ledger_api_get_month_info_request(
            cookie=cookie,
            role_id=role_id,
            server=server,
            month=month,
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
            deserialized = _deserialize(_models4.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_month_detail(
        self,
        *,
        cookie: str,
        type: int,
        current_page: int,
        role_id: str,
        server: str,
        month: Optional[str] = None,
        lang: Optional[str] = None,
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """get_month_detail.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword type: Required.
        :paramtype type: int
        :keyword current_page: Required.
        :paramtype current_page: int
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword server: Required.
        :paramtype server: str
        :keyword month: Default value is None.
        :paramtype month: str
        :keyword lang: Default value is None.
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

        cls: ClsType[_models4.ApiResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_ledger_api_get_month_detail_request(
            cookie=cookie,
            type=type,
            current_page=current_page,
            role_id=role_id,
            server=server,
            month=month,
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
            deserialized = _deserialize(_models4.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
