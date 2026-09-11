# coding=utf-8
from collections.abc import MutableMapping
from typing import Any, Callable, Iterator, Optional, TypeVar

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

from ......passport._utils.serialization import Deserializer, Serializer
from .._configuration import RegionListClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_region_list_api_query_request(
    *,
    binary: Optional[str] = None,
    channel_id: Optional[str] = None,
    lang: Optional[str] = None,
    platform: Optional[str] = None,
    sub_channel_id: Optional[str] = None,
    time: Optional[str] = None,
    version: Optional[str] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/octet-stream")

    # Construct URL
    _url = "/query_region_list"

    # Construct parameters
    if binary is not None:
        _params["binary"] = _SERIALIZER.query("binary", binary, "str")
    if channel_id is not None:
        _params["channel_id"] = _SERIALIZER.query("channel_id", channel_id, "str")
    if lang is not None:
        _params["lang"] = _SERIALIZER.query("lang", lang, "str")
    if platform is not None:
        _params["platform"] = _SERIALIZER.query("platform", platform, "str")
    if sub_channel_id is not None:
        _params["sub_channel_id"] = _SERIALIZER.query("sub_channel_id", sub_channel_id, "str")
    if time is not None:
        _params["time"] = _SERIALIZER.query("time", time, "str")
    if version is not None:
        _params["version"] = _SERIALIZER.query("version", version, "str")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


class RegionListApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.RegionListClient`'s
        :attr:`region_list_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: RegionListClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def query(
        self,
        *,
        binary: Optional[str] = None,
        channel_id: Optional[str] = None,
        lang: Optional[str] = None,
        platform: Optional[str] = None,
        sub_channel_id: Optional[str] = None,
        time: Optional[str] = None,
        version: Optional[str] = None,
        **kwargs: Any
    ) -> Iterator[bytes]:
        """query.

        :keyword binary: Default value is None.
        :paramtype binary: str
        :keyword channel_id: Default value is None.
        :paramtype channel_id: str
        :keyword lang: Default value is None.
        :paramtype lang: str
        :keyword platform: Default value is None.
        :paramtype platform: str
        :keyword sub_channel_id: Default value is None.
        :paramtype sub_channel_id: str
        :keyword time: Default value is None.
        :paramtype time: str
        :keyword version: Default value is None.
        :paramtype version: str
        :return: Iterator[bytes]
        :rtype: Iterator[bytes]
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

        cls: ClsType[Iterator[bytes]] = kwargs.pop("cls", None)

        _request = build_region_list_api_query_request(
            binary=binary,
            channel_id=channel_id,
            lang=lang,
            platform=platform,
            sub_channel_id=sub_channel_id,
            time=time,
            version=version,
            headers=_headers,
            params=_params,
        )
        path_format_arguments = {
            "endpoint": self._serialize.url("self._config.endpoint", self._config.endpoint, "str", skip_quote=True),
        }
        _request.url = self._client.format_url(_request.url, **path_format_arguments)

        _decompress = kwargs.pop("decompress", True)
        _stream = kwargs.pop("stream", True)
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

        deserialized = response.iter_bytes() if _decompress else response.iter_raw()

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
