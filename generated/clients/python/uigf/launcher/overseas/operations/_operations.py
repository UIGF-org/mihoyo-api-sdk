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

from ... import models as _models2, types as _types_models2
from .... import models as _models3
from ....passport._utils.model_base import SdkJSONEncoder, _deserialize
from ....passport._utils.serialization import Deserializer, Serializer
from .._configuration import GlobalLauncherClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_metadata_api_get_all_game_basic_info_request(  # pylint: disable=name-too-long
    *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hyp/hyp-connect/api/getAllGameBasicInfo"

    # Construct parameters
    _params["launcher_id"] = _SERIALIZER.query("launcher_id", launcher_id, "str")
    _params["language"] = _SERIALIZER.query("language", language, "str")
    if game_ids is not None:
        _params["game_ids[]"] = _SERIALIZER.query("game_ids", game_ids, "[str]", div=",")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_metadata_api_get_game_packages_request(  # pylint: disable=name-too-long
    *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hyp/hyp-connect/api/getGamePackages"

    # Construct parameters
    _params["launcher_id"] = _SERIALIZER.query("launcher_id", launcher_id, "str")
    _params["language"] = _SERIALIZER.query("language", language, "str")
    if game_ids is not None:
        _params["game_ids[]"] = _SERIALIZER.query("game_ids", game_ids, "[str]", div=",")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_metadata_api_get_game_channel_sdks_request(  # pylint: disable=name-too-long
    *,
    launcher_id: str,
    language: str,
    channel: Optional[int] = None,
    sub_channel: Optional[int] = None,
    game_ids: Optional[List[str]] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hyp/hyp-connect/api/getGameChannelSDKs"

    # Construct parameters
    if channel is not None:
        _params["channel"] = _SERIALIZER.query("channel", channel, "int")
    if sub_channel is not None:
        _params["sub_channel"] = _SERIALIZER.query("sub_channel", sub_channel, "int")
    _params["launcher_id"] = _SERIALIZER.query("launcher_id", launcher_id, "str")
    _params["language"] = _SERIALIZER.query("language", language, "str")
    if game_ids is not None:
        _params["game_ids[]"] = _SERIALIZER.query("game_ids", game_ids, "[str]", div=",")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_metadata_api_get_deprecated_file_configs_request(  # pylint: disable=name-too-long
    *,
    launcher_id: str,
    language: str,
    channel: Optional[int] = None,
    sub_channel: Optional[int] = None,
    game_ids: Optional[List[str]] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hyp/hyp-connect/api/getGameDeprecatedFileConfigs"

    # Construct parameters
    if channel is not None:
        _params["channel"] = _SERIALIZER.query("channel", channel, "int")
    if sub_channel is not None:
        _params["sub_channel"] = _SERIALIZER.query("sub_channel", sub_channel, "int")
    _params["launcher_id"] = _SERIALIZER.query("launcher_id", launcher_id, "str")
    _params["language"] = _SERIALIZER.query("language", language, "str")
    if game_ids is not None:
        _params["game_ids[]"] = _SERIALIZER.query("game_ids", game_ids, "[str]", div=",")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_metadata_api_get_game_configs_request(  # pylint: disable=name-too-long
    *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hyp/hyp-connect/api/getGameConfigs"

    # Construct parameters
    _params["launcher_id"] = _SERIALIZER.query("launcher_id", launcher_id, "str")
    _params["language"] = _SERIALIZER.query("language", language, "str")
    if game_ids is not None:
        _params["game_ids[]"] = _SERIALIZER.query("game_ids", game_ids, "[str]", div=",")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_metadata_api_get_game_scan_info_request(  # pylint: disable=name-too-long
    *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hyp/hyp-connect/api/getGameScanInfo"

    # Construct parameters
    _params["launcher_id"] = _SERIALIZER.query("launcher_id", launcher_id, "str")
    _params["language"] = _SERIALIZER.query("language", language, "str")
    if game_ids is not None:
        _params["game_ids[]"] = _SERIALIZER.query("game_ids", game_ids, "[str]", div=",")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_metadata_api_get_game_branches_request(  # pylint: disable=name-too-long
    *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hyp/hyp-connect/api/getGameBranches"

    # Construct parameters
    _params["launcher_id"] = _SERIALIZER.query("launcher_id", launcher_id, "str")
    _params["language"] = _SERIALIZER.query("language", language, "str")
    if game_ids is not None:
        _params["game_ids[]"] = _SERIALIZER.query("game_ids", game_ids, "[str]", div=",")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_metadata_api_get_wpf_packages_request(  # pylint: disable=name-too-long
    *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hyp/hyp-connect/api/getWPFPackages"

    # Construct parameters
    _params["launcher_id"] = _SERIALIZER.query("launcher_id", launcher_id, "str")
    _params["language"] = _SERIALIZER.query("language", language, "str")
    if game_ids is not None:
        _params["game_ids[]"] = _SERIALIZER.query("game_ids", game_ids, "[str]", div=",")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_metadata_api_get_dx_configs_request(  # pylint: disable=name-too-long
    *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hyp/hyp-connect/api/getDXConfigs"

    # Construct parameters
    _params["launcher_id"] = _SERIALIZER.query("launcher_id", launcher_id, "str")
    _params["language"] = _SERIALIZER.query("language", language, "str")
    if game_ids is not None:
        _params["game_ids[]"] = _SERIALIZER.query("game_ids", game_ids, "[str]", div=",")

    # Construct headers
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, params=_params, headers=_headers, **kwargs)


class MetadataApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.GlobalLauncherClient`'s
        :attr:`metadata_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: GlobalLauncherClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def get_all_game_basic_info(
        self, *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
    ) -> _models3.LauncherResponseGameBasicInfo:
        """get_all_game_basic_info.

        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :return: LauncherResponseGameBasicInfo. The LauncherResponseGameBasicInfo is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseGameBasicInfo
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

        cls: ClsType[_models3.LauncherResponseGameBasicInfo] = kwargs.pop("cls", None)

        _request = build_metadata_api_get_all_game_basic_info_request(
            launcher_id=launcher_id,
            language=language,
            game_ids=game_ids,
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
            deserialized = _deserialize(_models3.LauncherResponseGameBasicInfo, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_game_packages(
        self, *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_game_packages.

        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
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

        cls: ClsType[_models3.LauncherResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_metadata_api_get_game_packages_request(
            launcher_id=launcher_id,
            language=language,
            game_ids=game_ids,
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
            deserialized = _deserialize(_models3.LauncherResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_game_channel_sdks(
        self,
        *,
        launcher_id: str,
        language: str,
        channel: Optional[int] = None,
        sub_channel: Optional[int] = None,
        game_ids: Optional[List[str]] = None,
        **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_game_channel_sdks.

        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword channel: Default value is None.
        :paramtype channel: int
        :keyword sub_channel: Default value is None.
        :paramtype sub_channel: int
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
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

        cls: ClsType[_models3.LauncherResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_metadata_api_get_game_channel_sdks_request(
            launcher_id=launcher_id,
            language=language,
            channel=channel,
            sub_channel=sub_channel,
            game_ids=game_ids,
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
            deserialized = _deserialize(_models3.LauncherResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_deprecated_file_configs(
        self,
        *,
        launcher_id: str,
        language: str,
        channel: Optional[int] = None,
        sub_channel: Optional[int] = None,
        game_ids: Optional[List[str]] = None,
        **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_deprecated_file_configs.

        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword channel: Default value is None.
        :paramtype channel: int
        :keyword sub_channel: Default value is None.
        :paramtype sub_channel: int
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
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

        cls: ClsType[_models3.LauncherResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_metadata_api_get_deprecated_file_configs_request(
            launcher_id=launcher_id,
            language=language,
            channel=channel,
            sub_channel=sub_channel,
            game_ids=game_ids,
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
            deserialized = _deserialize(_models3.LauncherResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_game_configs(
        self, *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_game_configs.

        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
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

        cls: ClsType[_models3.LauncherResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_metadata_api_get_game_configs_request(
            launcher_id=launcher_id,
            language=language,
            game_ids=game_ids,
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
            deserialized = _deserialize(_models3.LauncherResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_game_scan_info(
        self, *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_game_scan_info.

        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
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

        cls: ClsType[_models3.LauncherResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_metadata_api_get_game_scan_info_request(
            launcher_id=launcher_id,
            language=language,
            game_ids=game_ids,
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
            deserialized = _deserialize(_models3.LauncherResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_game_branches(
        self, *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_game_branches.

        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
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

        cls: ClsType[_models3.LauncherResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_metadata_api_get_game_branches_request(
            launcher_id=launcher_id,
            language=language,
            game_ids=game_ids,
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
            deserialized = _deserialize(_models3.LauncherResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def get_wpf_packages(
        self, *, launcher_id: str, language: str, game_ids: Optional[List[str]] = None, **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_wpf_packages.

        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
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

        cls: ClsType[_models3.LauncherResponseJsonObject] = kwargs.pop("cls", None)

        _request = build_metadata_api_get_wpf_packages_request(
            launcher_id=launcher_id,
            language=language,
            game_ids=game_ids,
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
            deserialized = _deserialize(_models3.LauncherResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def get_dx_configs(
        self,
        body: _models2.DxConfigRequest,
        *,
        launcher_id: str,
        language: str,
        game_ids: Optional[List[str]] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_dx_configs.

        :param body: Required.
        :type body: ~uigf.launcher.models.DxConfigRequest
        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def get_dx_configs(
        self,
        body: _types_models2.DxConfigRequest,
        *,
        launcher_id: str,
        language: str,
        game_ids: Optional[List[str]] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_dx_configs.

        :param body: Required.
        :type body: ~uigf.launcher.types.DxConfigRequest
        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def get_dx_configs(
        self,
        body: IO[bytes],
        *,
        launcher_id: str,
        language: str,
        game_ids: Optional[List[str]] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_dx_configs.

        :param body: Required.
        :type body: IO[bytes]
        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def get_dx_configs(
        self,
        body: Union[_models2.DxConfigRequest, _types_models2.DxConfigRequest, IO[bytes]],
        *,
        launcher_id: str,
        language: str,
        game_ids: Optional[List[str]] = None,
        **kwargs: Any
    ) -> _models3.LauncherResponseJsonObject:
        """get_dx_configs.

        :param body: Is either a DxConfigRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.launcher.models.DxConfigRequest or ~uigf.launcher.types.DxConfigRequest or
         IO[bytes]
        :keyword launcher_id: Required.
        :paramtype launcher_id: str
        :keyword language: Required.
        :paramtype language: str
        :keyword game_ids: Default value is None.
        :paramtype game_ids: list[str]
        :return: LauncherResponseJsonObject. The LauncherResponseJsonObject is compatible with
         MutableMapping
        :rtype: ~uigf.models.LauncherResponseJsonObject
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
        cls: ClsType[_models3.LauncherResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_metadata_api_get_dx_configs_request(
            launcher_id=launcher_id,
            language=language,
            game_ids=game_ids,
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
            deserialized = _deserialize(_models3.LauncherResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
