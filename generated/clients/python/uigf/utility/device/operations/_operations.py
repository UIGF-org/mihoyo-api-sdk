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

from .... import models as _models3
from ....game import models as _game_models4, types as _types_game_models4
from ....passport._utils.model_base import SdkJSONEncoder, _deserialize
from ....passport._utils.serialization import Deserializer, Serializer
from .._configuration import DeviceClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_fingerprint_api_get_extension_list_request(  # pylint: disable=name-too-long
    *, platform: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/device-fp/api/getExtList"

    # Construct parameters
    _params["platform"] = _SERIALIZER.query("platform", platform, "str")

    # Construct headers
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


def build_fingerprint_api_get_fingerprint_request(  # pylint: disable=name-too-long
    *, app_version: str, client_type: str, requested_with: str, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/device-fp/api/getFp"

    # Construct headers
    _headers["x-rpc-app_version"] = _SERIALIZER.header("app_version", app_version, "str")
    _headers["x-rpc-client_type"] = _SERIALIZER.header("client_type", client_type, "str")
    _headers["x-requested-with"] = _SERIALIZER.header("requested_with", requested_with, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


class FingerprintApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.DeviceClient`'s
        :attr:`fingerprint_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: DeviceClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    def get_extension_list(self, *, platform: str, **kwargs: Any) -> _models3.ApiResponseDeviceExtensionList:
        """Returns the client extension fields expected by the fingerprint registration endpoint.

        :keyword platform: Required.
        :paramtype platform: str
        :return: ApiResponseDeviceExtensionList. The ApiResponseDeviceExtensionList is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseDeviceExtensionList
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

        cls: ClsType[_models3.ApiResponseDeviceExtensionList] = kwargs.pop("cls", None)

        _request = build_fingerprint_api_get_extension_list_request(
            platform=platform,
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
            deserialized = _deserialize(_models3.ApiResponseDeviceExtensionList, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def get_fingerprint(
        self,
        body: _game_models4.DeviceFingerprintRequest,
        *,
        app_version: str,
        client_type: str,
        requested_with: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseDeviceFingerprint:
        """Registers a legitimate client device fingerprint and returns its ``device_fp`` value.

        :param body: Required.
        :type body: ~uigf.game.models.DeviceFingerprintRequest
        :keyword app_version: Required.
        :paramtype app_version: str
        :keyword client_type: Required.
        :paramtype client_type: str
        :keyword requested_with: Required.
        :paramtype requested_with: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseDeviceFingerprint. The ApiResponseDeviceFingerprint is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseDeviceFingerprint
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def get_fingerprint(
        self,
        body: _types_game_models4.DeviceFingerprintRequest,
        *,
        app_version: str,
        client_type: str,
        requested_with: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseDeviceFingerprint:
        """Registers a legitimate client device fingerprint and returns its ``device_fp`` value.

        :param body: Required.
        :type body: ~uigf.game.types.DeviceFingerprintRequest
        :keyword app_version: Required.
        :paramtype app_version: str
        :keyword client_type: Required.
        :paramtype client_type: str
        :keyword requested_with: Required.
        :paramtype requested_with: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseDeviceFingerprint. The ApiResponseDeviceFingerprint is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseDeviceFingerprint
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def get_fingerprint(
        self,
        body: IO[bytes],
        *,
        app_version: str,
        client_type: str,
        requested_with: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseDeviceFingerprint:
        """Registers a legitimate client device fingerprint and returns its ``device_fp`` value.

        :param body: Required.
        :type body: IO[bytes]
        :keyword app_version: Required.
        :paramtype app_version: str
        :keyword client_type: Required.
        :paramtype client_type: str
        :keyword requested_with: Required.
        :paramtype requested_with: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseDeviceFingerprint. The ApiResponseDeviceFingerprint is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseDeviceFingerprint
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def get_fingerprint(
        self,
        body: Union[_game_models4.DeviceFingerprintRequest, _types_game_models4.DeviceFingerprintRequest, IO[bytes]],
        *,
        app_version: str,
        client_type: str,
        requested_with: str,
        **kwargs: Any
    ) -> _models3.ApiResponseDeviceFingerprint:
        """Registers a legitimate client device fingerprint and returns its ``device_fp`` value.

        :param body: Is either a DeviceFingerprintRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.models.DeviceFingerprintRequest or
         ~uigf.game.types.DeviceFingerprintRequest or IO[bytes]
        :keyword app_version: Required.
        :paramtype app_version: str
        :keyword client_type: Required.
        :paramtype client_type: str
        :keyword requested_with: Required.
        :paramtype requested_with: str
        :return: ApiResponseDeviceFingerprint. The ApiResponseDeviceFingerprint is compatible with
         MutableMapping
        :rtype: ~uigf.models.ApiResponseDeviceFingerprint
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
        cls: ClsType[_models3.ApiResponseDeviceFingerprint] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_fingerprint_api_get_fingerprint_request(
            app_version=app_version,
            client_type=client_type,
            requested_with=requested_with,
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
            deserialized = _deserialize(_models3.ApiResponseDeviceFingerprint, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
