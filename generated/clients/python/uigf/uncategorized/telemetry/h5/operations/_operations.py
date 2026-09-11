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

from .... import models as _models3, types as _types_models3
from ..... import models as _models4
from .....passport._utils.model_base import SdkJSONEncoder, _deserialize
from .....passport._utils.serialization import Deserializer, Serializer
from .._configuration import H5ClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_batch_api_upload_request(*, topic: str, date: Optional[str] = None, **kwargs: Any) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/common/h5log/log/batch"

    # Construct parameters
    _params["topic"] = _SERIALIZER.query("topic", topic, "str")

    # Construct headers
    if date is not None:
        _headers["DATE"] = _SERIALIZER.header("date", date, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, params=_params, headers=_headers, **kwargs)


class BatchApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.H5Client`'s
        :attr:`batch_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: H5ClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def upload(
        self,
        body: _models3.H5LogRequest,
        *,
        topic: str,
        date: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """upload.

        :param body: Required.
        :type body: ~uigf.uncategorized.models.H5LogRequest
        :keyword topic: Required.
        :paramtype topic: str
        :keyword date: Default value is None.
        :paramtype date: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def upload(
        self,
        body: _types_models3.H5LogRequest,
        *,
        topic: str,
        date: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """upload.

        :param body: Required.
        :type body: ~uigf.uncategorized.types.H5LogRequest
        :keyword topic: Required.
        :paramtype topic: str
        :keyword date: Default value is None.
        :paramtype date: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def upload(
        self,
        body: IO[bytes],
        *,
        topic: str,
        date: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """upload.

        :param body: Required.
        :type body: IO[bytes]
        :keyword topic: Required.
        :paramtype topic: str
        :keyword date: Default value is None.
        :paramtype date: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def upload(
        self,
        body: Union[_models3.H5LogRequest, _types_models3.H5LogRequest, IO[bytes]],
        *,
        topic: str,
        date: Optional[str] = None,
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """upload.

        :param body: Is either a H5LogRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.uncategorized.models.H5LogRequest or ~uigf.uncategorized.types.H5LogRequest
         or IO[bytes]
        :keyword topic: Required.
        :paramtype topic: str
        :keyword date: Default value is None.
        :paramtype date: str
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

        _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
        _params = kwargs.pop("params", {}) or {}

        content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
        cls: ClsType[_models4.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_batch_api_upload_request(
            topic=topic,
            date=date,
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
            deserialized = _deserialize(_models4.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
