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

from .... import models as _models3
from .......passport._utils.model_base import _deserialize
from .......passport._utils.serialization import Deserializer, Serializer
from ...operations._operations import build_current_region_api_query_request
from .._configuration import CurrentRegionClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class CurrentRegionApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.CurrentRegionClient`'s
        :attr:`current_region_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: CurrentRegionClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    async def query(
        self,
        *,
        account_type: Optional[str] = None,
        aid: Optional[str] = None,
        binary: Optional[str] = None,
        channel_id: Optional[str] = None,
        dispatch_seed: Optional[str] = None,
        key_id: Optional[str] = None,
        lang: Optional[str] = None,
        platform: Optional[str] = None,
        sub_channel_id: Optional[str] = None,
        time: Optional[str] = None,
        version: Optional[str] = None,
        **kwargs: Any
    ) -> _models3.SignedDispatchResponse:
        """query.

        :keyword account_type: Default value is None.
        :paramtype account_type: str
        :keyword aid: Default value is None.
        :paramtype aid: str
        :keyword binary: Default value is None.
        :paramtype binary: str
        :keyword channel_id: Default value is None.
        :paramtype channel_id: str
        :keyword dispatch_seed: Default value is None.
        :paramtype dispatch_seed: str
        :keyword key_id: Default value is None.
        :paramtype key_id: str
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
        :return: SignedDispatchResponse. The SignedDispatchResponse is compatible with MutableMapping
        :rtype: ~uigf.game.genshin.dispatch.models.SignedDispatchResponse
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

        cls: ClsType[_models3.SignedDispatchResponse] = kwargs.pop("cls", None)

        _request = build_current_region_api_query_request(
            account_type=account_type,
            aid=aid,
            binary=binary,
            channel_id=channel_id,
            dispatch_seed=dispatch_seed,
            key_id=key_id,
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
            deserialized = _deserialize(_models3.SignedDispatchResponse, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
