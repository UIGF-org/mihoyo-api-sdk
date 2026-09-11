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

from ..... import models as _models4
from ...... import models as _models5, types as _types_models5
from ......passport._utils.model_base import SdkJSONEncoder, _deserialize
from ......passport._utils.serialization import Deserializer, Serializer
from ...operations._operations import build_upload_api_upload_request
from .._configuration import SDKClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class UploadApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.SDKClient`'s
        :attr:`upload_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: SDKClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    async def upload(
        self,
        body: List[_models5.JsonObject],
        *,
        authorization: Optional[str] = None,
        content_md5: Optional[str] = None,
        date: Optional[str] = None,
        cms_signature: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.UploadResponse:
        """upload.

        :param body: Required.
        :type body: list[~uigf.models.JsonObject]
        :keyword authorization: Default value is None.
        :paramtype authorization: str
        :keyword content_md5: Default value is None.
        :paramtype content_md5: str
        :keyword date: Default value is None.
        :paramtype date: str
        :keyword cms_signature: Default value is None.
        :paramtype cms_signature: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: UploadResponse. The UploadResponse is compatible with MutableMapping
        :rtype: ~uigf.uncategorized.models.UploadResponse
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def upload(
        self,
        body: List[_types_models5.JsonObject],
        *,
        authorization: Optional[str] = None,
        content_md5: Optional[str] = None,
        date: Optional[str] = None,
        cms_signature: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.UploadResponse:
        """upload.

        :param body: Required.
        :type body: list[~uigf.types.JsonObject]
        :keyword authorization: Default value is None.
        :paramtype authorization: str
        :keyword content_md5: Default value is None.
        :paramtype content_md5: str
        :keyword date: Default value is None.
        :paramtype date: str
        :keyword cms_signature: Default value is None.
        :paramtype cms_signature: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: UploadResponse. The UploadResponse is compatible with MutableMapping
        :rtype: ~uigf.uncategorized.models.UploadResponse
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def upload(
        self,
        body: IO[bytes],
        *,
        authorization: Optional[str] = None,
        content_md5: Optional[str] = None,
        date: Optional[str] = None,
        cms_signature: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.UploadResponse:
        """upload.

        :param body: Required.
        :type body: IO[bytes]
        :keyword authorization: Default value is None.
        :paramtype authorization: str
        :keyword content_md5: Default value is None.
        :paramtype content_md5: str
        :keyword date: Default value is None.
        :paramtype date: str
        :keyword cms_signature: Default value is None.
        :paramtype cms_signature: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: UploadResponse. The UploadResponse is compatible with MutableMapping
        :rtype: ~uigf.uncategorized.models.UploadResponse
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    async def upload(
        self,
        body: Union[List[_models5.JsonObject], List[_types_models5.JsonObject], IO[bytes]],
        *,
        authorization: Optional[str] = None,
        content_md5: Optional[str] = None,
        date: Optional[str] = None,
        cms_signature: Optional[str] = None,
        **kwargs: Any
    ) -> _models4.UploadResponse:
        """upload.

        :param body: Is either a [JsonObject] type or a IO[bytes] type. Required.
        :type body: list[~uigf.models.JsonObject] or list[~uigf.types.JsonObject] or IO[bytes]
        :keyword authorization: Default value is None.
        :paramtype authorization: str
        :keyword content_md5: Default value is None.
        :paramtype content_md5: str
        :keyword date: Default value is None.
        :paramtype date: str
        :keyword cms_signature: Default value is None.
        :paramtype cms_signature: str
        :return: UploadResponse. The UploadResponse is compatible with MutableMapping
        :rtype: ~uigf.uncategorized.models.UploadResponse
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
        cls: ClsType[_models4.UploadResponse] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_upload_api_upload_request(
            authorization=authorization,
            content_md5=content_md5,
            date=date,
            cms_signature=cms_signature,
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
            deserialized = _deserialize(_models4.UploadResponse, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
