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
from corehttp.rest import HttpRequest, HttpResponse
from corehttp.runtime import PipelineClient
from corehttp.runtime.pipeline import PipelineResponse
from corehttp.utils import case_insensitive_dict

from ..... import models as _models4
from .....passport._utils.model_base import _deserialize
from .....passport._utils.serialization import Deserializer, Serializer
from .._configuration import EventsClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_star_rail_ledger_api_get_month_info_request(  # pylint: disable=name-too-long
    *, cookie: str, role_id: str, server: str, month: Optional[str] = None, lang: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/srledger/month_info"

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


def build_star_rail_ledger_api_get_month_detail_request(  # pylint: disable=name-too-long
    *,
    cookie: str,
    type: int,
    current_page: int,
    role_id: str,
    server: str,
    page_size: Optional[int] = None,
    month: Optional[str] = None,
    lang: Optional[str] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/srledger/month_detail"

    # Construct parameters
    _params["type"] = _SERIALIZER.query("type", type, "int")
    _params["current_page"] = _SERIALIZER.query("current_page", current_page, "int")
    if page_size is not None:
        _params["page_size"] = _SERIALIZER.query("page_size", page_size, "int")
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


def build_zenless_ledger_api_get_month_info_request(  # pylint: disable=name-too-long
    *, cookie: str, role_id: str, server: str, month: Optional[str] = None, lang: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/nap_ledger/month_info"

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


def build_zenless_ledger_api_get_month_detail_request(  # pylint: disable=name-too-long
    *,
    cookie: str,
    type: str,
    current_page: int,
    role_id: str,
    server: str,
    page_size: Optional[int] = None,
    month: Optional[str] = None,
    lang: Optional[str] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/nap_ledger/month_detail"

    # Construct parameters
    _params["type"] = _SERIALIZER.query("type", type, "str")
    _params["current_page"] = _SERIALIZER.query("current_page", current_page, "int")
    if page_size is not None:
        _params["page_size"] = _SERIALIZER.query("page_size", page_size, "int")
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


def build_zenless_cultivation_api_get_items_request(  # pylint: disable=name-too-long
    *, cookie: str, uid: str, region: str, avatar_id: int, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/nap_cultivate_tool/user/item_list"

    # Construct parameters
    _params["uid"] = _SERIALIZER.query("uid", uid, "str")
    _params["region"] = _SERIALIZER.query("region", region, "str")
    _params["avatar_id"] = _SERIALIZER.query("avatar_id", avatar_id, "int")

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_zenless_cultivation_api_get_icon_info_request(  # pylint: disable=name-too-long
    *, cookie: str, uid: str, region: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/event/nap_cultivate_tool/user/icon_info"

    # Construct parameters
    _params["uid"] = _SERIALIZER.query("uid", uid, "str")
    _params["region"] = _SERIALIZER.query("region", region, "str")

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


class StarRailLedgerApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.EventsClient`'s
        :attr:`star_rail_ledger_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: EventsClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
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

        _request = build_star_rail_ledger_api_get_month_info_request(
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
        page_size: Optional[int] = None,
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
        :keyword page_size: Default value is None.
        :paramtype page_size: int
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

        _request = build_star_rail_ledger_api_get_month_detail_request(
            cookie=cookie,
            type=type,
            current_page=current_page,
            role_id=role_id,
            server=server,
            page_size=page_size,
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


class ZenlessLedgerApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.EventsClient`'s
        :attr:`zenless_ledger_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: EventsClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
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

        _request = build_zenless_ledger_api_get_month_info_request(
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
        type: str,
        current_page: int,
        role_id: str,
        server: str,
        page_size: Optional[int] = None,
        month: Optional[str] = None,
        lang: Optional[str] = None,
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """get_month_detail.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword type: Required.
        :paramtype type: str
        :keyword current_page: Required.
        :paramtype current_page: int
        :keyword role_id: Required.
        :paramtype role_id: str
        :keyword server: Required.
        :paramtype server: str
        :keyword page_size: Default value is None.
        :paramtype page_size: int
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

        _request = build_zenless_ledger_api_get_month_detail_request(
            cookie=cookie,
            type=type,
            current_page=current_page,
            role_id=role_id,
            server=server,
            page_size=page_size,
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


class ZenlessCultivationApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.EventsClient`'s
        :attr:`zenless_cultivation_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: EventsClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def get_items(
        self, *, cookie: str, uid: str, region: str, avatar_id: int, **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """get_items.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword uid: Required.
        :paramtype uid: str
        :keyword region: Required.
        :paramtype region: str
        :keyword avatar_id: Required.
        :paramtype avatar_id: int
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

        _request = build_zenless_cultivation_api_get_items_request(
            cookie=cookie,
            uid=uid,
            region=region,
            avatar_id=avatar_id,
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

    def get_icon_info(self, *, cookie: str, uid: str, region: str, **kwargs: Any) -> _models4.ApiResponseJsonObject:
        """get_icon_info.

        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword uid: Required.
        :paramtype uid: str
        :keyword region: Required.
        :paramtype region: str
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

        _request = build_zenless_cultivation_api_get_icon_info_request(
            cookie=cookie,
            uid=uid,
            region=region,
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
