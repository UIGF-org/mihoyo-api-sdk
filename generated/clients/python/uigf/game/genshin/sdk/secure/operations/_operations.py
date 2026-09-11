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
from ...... import models as _models5
from ......passport._utils.model_base import SdkJSONEncoder, _deserialize
from ......passport._utils.serialization import Deserializer, Serializer
from .._configuration import SecureClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_secure_api_compare_protocol_version_request(  # pylint: disable=name-too-long
    *,
    rpc_app_id: Optional[str] = None,
    rpc_app_version: Optional[str] = None,
    rpc_channel_id: Optional[str] = None,
    rpc_channel_version: Optional[str] = None,
    rpc_client_type: Optional[str] = None,
    rpc_combo_version: Optional[str] = None,
    rpc_device_fingerprint: Optional[str] = None,
    rpc_device_id: Optional[str] = None,
    rpc_device_model: Optional[str] = None,
    rpc_device_name: Optional[str] = None,
    rpc_game_biz: Optional[str] = None,
    rpc_goods_third_party: Optional[str] = None,
    rpc_language: Optional[str] = None,
    rpc_mdk_version: Optional[str] = None,
    rpc_payment_version: Optional[str] = None,
    rpc_sdk_version: Optional[str] = None,
    rpc_sub_channel_id: Optional[str] = None,
    rpc_system_version: Optional[str] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hk4e_cn/combo/granter/api/compareProtocolVersion"

    # Construct headers
    if rpc_app_id is not None:
        _headers["x-rpc-app_id"] = _SERIALIZER.header("rpc_app_id", rpc_app_id, "str")
    if rpc_app_version is not None:
        _headers["x-rpc-app_version"] = _SERIALIZER.header("rpc_app_version", rpc_app_version, "str")
    if rpc_channel_id is not None:
        _headers["x-rpc-channel_id"] = _SERIALIZER.header("rpc_channel_id", rpc_channel_id, "str")
    if rpc_channel_version is not None:
        _headers["x-rpc-channel_version"] = _SERIALIZER.header("rpc_channel_version", rpc_channel_version, "str")
    if rpc_client_type is not None:
        _headers["x-rpc-client_type"] = _SERIALIZER.header("rpc_client_type", rpc_client_type, "str")
    if rpc_combo_version is not None:
        _headers["x-rpc-combo_version"] = _SERIALIZER.header("rpc_combo_version", rpc_combo_version, "str")
    if rpc_device_fingerprint is not None:
        _headers["x-rpc-device_fp"] = _SERIALIZER.header("rpc_device_fingerprint", rpc_device_fingerprint, "str")
    if rpc_device_id is not None:
        _headers["x-rpc-device_id"] = _SERIALIZER.header("rpc_device_id", rpc_device_id, "str")
    if rpc_device_model is not None:
        _headers["x-rpc-device_model"] = _SERIALIZER.header("rpc_device_model", rpc_device_model, "str")
    if rpc_device_name is not None:
        _headers["x-rpc-device_name"] = _SERIALIZER.header("rpc_device_name", rpc_device_name, "str")
    if rpc_game_biz is not None:
        _headers["x-rpc-game_biz"] = _SERIALIZER.header("rpc_game_biz", rpc_game_biz, "str")
    if rpc_goods_third_party is not None:
        _headers["x-rpc-goods_third_party"] = _SERIALIZER.header("rpc_goods_third_party", rpc_goods_third_party, "str")
    if rpc_language is not None:
        _headers["x-rpc-language"] = _SERIALIZER.header("rpc_language", rpc_language, "str")
    if rpc_mdk_version is not None:
        _headers["x-rpc-mdk_version"] = _SERIALIZER.header("rpc_mdk_version", rpc_mdk_version, "str")
    if rpc_payment_version is not None:
        _headers["x-rpc-payment_version"] = _SERIALIZER.header("rpc_payment_version", rpc_payment_version, "str")
    if rpc_sdk_version is not None:
        _headers["x-rpc-sdk_version"] = _SERIALIZER.header("rpc_sdk_version", rpc_sdk_version, "str")
    if rpc_sub_channel_id is not None:
        _headers["x-rpc-sub_channel_id"] = _SERIALIZER.header("rpc_sub_channel_id", rpc_sub_channel_id, "str")
    if rpc_system_version is not None:
        _headers["x-rpc-sys_version"] = _SERIALIZER.header("rpc_system_version", rpc_system_version, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_secure_api_get_red_dots_request(
    *,
    rpc_app_id: Optional[str] = None,
    rpc_app_version: Optional[str] = None,
    rpc_channel_id: Optional[str] = None,
    rpc_channel_version: Optional[str] = None,
    rpc_client_type: Optional[str] = None,
    rpc_combo_version: Optional[str] = None,
    rpc_device_fingerprint: Optional[str] = None,
    rpc_device_id: Optional[str] = None,
    rpc_device_model: Optional[str] = None,
    rpc_device_name: Optional[str] = None,
    rpc_game_biz: Optional[str] = None,
    rpc_goods_third_party: Optional[str] = None,
    rpc_language: Optional[str] = None,
    rpc_mdk_version: Optional[str] = None,
    rpc_payment_version: Optional[str] = None,
    rpc_sdk_version: Optional[str] = None,
    rpc_sub_channel_id: Optional[str] = None,
    rpc_system_version: Optional[str] = None,
    **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/hk4e_cn/combo/red_dot/list"

    # Construct headers
    if rpc_app_id is not None:
        _headers["x-rpc-app_id"] = _SERIALIZER.header("rpc_app_id", rpc_app_id, "str")
    if rpc_app_version is not None:
        _headers["x-rpc-app_version"] = _SERIALIZER.header("rpc_app_version", rpc_app_version, "str")
    if rpc_channel_id is not None:
        _headers["x-rpc-channel_id"] = _SERIALIZER.header("rpc_channel_id", rpc_channel_id, "str")
    if rpc_channel_version is not None:
        _headers["x-rpc-channel_version"] = _SERIALIZER.header("rpc_channel_version", rpc_channel_version, "str")
    if rpc_client_type is not None:
        _headers["x-rpc-client_type"] = _SERIALIZER.header("rpc_client_type", rpc_client_type, "str")
    if rpc_combo_version is not None:
        _headers["x-rpc-combo_version"] = _SERIALIZER.header("rpc_combo_version", rpc_combo_version, "str")
    if rpc_device_fingerprint is not None:
        _headers["x-rpc-device_fp"] = _SERIALIZER.header("rpc_device_fingerprint", rpc_device_fingerprint, "str")
    if rpc_device_id is not None:
        _headers["x-rpc-device_id"] = _SERIALIZER.header("rpc_device_id", rpc_device_id, "str")
    if rpc_device_model is not None:
        _headers["x-rpc-device_model"] = _SERIALIZER.header("rpc_device_model", rpc_device_model, "str")
    if rpc_device_name is not None:
        _headers["x-rpc-device_name"] = _SERIALIZER.header("rpc_device_name", rpc_device_name, "str")
    if rpc_game_biz is not None:
        _headers["x-rpc-game_biz"] = _SERIALIZER.header("rpc_game_biz", rpc_game_biz, "str")
    if rpc_goods_third_party is not None:
        _headers["x-rpc-goods_third_party"] = _SERIALIZER.header("rpc_goods_third_party", rpc_goods_third_party, "str")
    if rpc_language is not None:
        _headers["x-rpc-language"] = _SERIALIZER.header("rpc_language", rpc_language, "str")
    if rpc_mdk_version is not None:
        _headers["x-rpc-mdk_version"] = _SERIALIZER.header("rpc_mdk_version", rpc_mdk_version, "str")
    if rpc_payment_version is not None:
        _headers["x-rpc-payment_version"] = _SERIALIZER.header("rpc_payment_version", rpc_payment_version, "str")
    if rpc_sdk_version is not None:
        _headers["x-rpc-sdk_version"] = _SERIALIZER.header("rpc_sdk_version", rpc_sdk_version, "str")
    if rpc_sub_channel_id is not None:
        _headers["x-rpc-sub_channel_id"] = _SERIALIZER.header("rpc_sub_channel_id", rpc_sub_channel_id, "str")
    if rpc_system_version is not None:
        _headers["x-rpc-sys_version"] = _SERIALIZER.header("rpc_system_version", rpc_system_version, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


class SecureApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.SecureClient`'s
        :attr:`secure_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: SecureClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def compare_protocol_version(
        self,
        body: _models2.ProtocolVersionRequest,
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """compare_protocol_version.

        :param body: Required.
        :type body: ~uigf.game.genshin.sdk.models.ProtocolVersionRequest
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def compare_protocol_version(
        self,
        body: _types_models2.ProtocolVersionRequest,
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """compare_protocol_version.

        :param body: Required.
        :type body: ~uigf.game.genshin.sdk.types.ProtocolVersionRequest
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def compare_protocol_version(
        self,
        body: IO[bytes],
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """compare_protocol_version.

        :param body: Required.
        :type body: IO[bytes]
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def compare_protocol_version(  # pylint: disable=too-many-locals
        self,
        body: Union[_models2.ProtocolVersionRequest, _types_models2.ProtocolVersionRequest, IO[bytes]],
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """compare_protocol_version.

        :param body: Is either a ProtocolVersionRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.genshin.sdk.models.ProtocolVersionRequest or
         ~uigf.game.genshin.sdk.types.ProtocolVersionRequest or IO[bytes]
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
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
        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_secure_api_compare_protocol_version_request(
            rpc_app_id=rpc_app_id,
            rpc_app_version=rpc_app_version,
            rpc_channel_id=rpc_channel_id,
            rpc_channel_version=rpc_channel_version,
            rpc_client_type=rpc_client_type,
            rpc_combo_version=rpc_combo_version,
            rpc_device_fingerprint=rpc_device_fingerprint,
            rpc_device_id=rpc_device_id,
            rpc_device_model=rpc_device_model,
            rpc_device_name=rpc_device_name,
            rpc_game_biz=rpc_game_biz,
            rpc_goods_third_party=rpc_goods_third_party,
            rpc_language=rpc_language,
            rpc_mdk_version=rpc_mdk_version,
            rpc_payment_version=rpc_payment_version,
            rpc_sdk_version=rpc_sdk_version,
            rpc_sub_channel_id=rpc_sub_channel_id,
            rpc_system_version=rpc_system_version,
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
            deserialized = _deserialize(_models5.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def get_red_dots(
        self,
        body: _models2.RedDotRequest,
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_red_dots.

        :param body: Required.
        :type body: ~uigf.game.genshin.sdk.models.RedDotRequest
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def get_red_dots(
        self,
        body: _types_models2.RedDotRequest,
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_red_dots.

        :param body: Required.
        :type body: ~uigf.game.genshin.sdk.types.RedDotRequest
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def get_red_dots(
        self,
        body: IO[bytes],
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_red_dots.

        :param body: Required.
        :type body: IO[bytes]
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def get_red_dots(  # pylint: disable=too-many-locals
        self,
        body: Union[_models2.RedDotRequest, _types_models2.RedDotRequest, IO[bytes]],
        *,
        rpc_app_id: Optional[str] = None,
        rpc_app_version: Optional[str] = None,
        rpc_channel_id: Optional[str] = None,
        rpc_channel_version: Optional[str] = None,
        rpc_client_type: Optional[str] = None,
        rpc_combo_version: Optional[str] = None,
        rpc_device_fingerprint: Optional[str] = None,
        rpc_device_id: Optional[str] = None,
        rpc_device_model: Optional[str] = None,
        rpc_device_name: Optional[str] = None,
        rpc_game_biz: Optional[str] = None,
        rpc_goods_third_party: Optional[str] = None,
        rpc_language: Optional[str] = None,
        rpc_mdk_version: Optional[str] = None,
        rpc_payment_version: Optional[str] = None,
        rpc_sdk_version: Optional[str] = None,
        rpc_sub_channel_id: Optional[str] = None,
        rpc_system_version: Optional[str] = None,
        **kwargs: Any
    ) -> _models5.ApiResponseJsonObject:
        """get_red_dots.

        :param body: Is either a RedDotRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.game.genshin.sdk.models.RedDotRequest or
         ~uigf.game.genshin.sdk.types.RedDotRequest or IO[bytes]
        :keyword rpc_app_id: Default value is None.
        :paramtype rpc_app_id: str
        :keyword rpc_app_version: Default value is None.
        :paramtype rpc_app_version: str
        :keyword rpc_channel_id: Default value is None.
        :paramtype rpc_channel_id: str
        :keyword rpc_channel_version: Default value is None.
        :paramtype rpc_channel_version: str
        :keyword rpc_client_type: Default value is None.
        :paramtype rpc_client_type: str
        :keyword rpc_combo_version: Default value is None.
        :paramtype rpc_combo_version: str
        :keyword rpc_device_fingerprint: Default value is None.
        :paramtype rpc_device_fingerprint: str
        :keyword rpc_device_id: Default value is None.
        :paramtype rpc_device_id: str
        :keyword rpc_device_model: Default value is None.
        :paramtype rpc_device_model: str
        :keyword rpc_device_name: Default value is None.
        :paramtype rpc_device_name: str
        :keyword rpc_game_biz: Default value is None.
        :paramtype rpc_game_biz: str
        :keyword rpc_goods_third_party: Default value is None.
        :paramtype rpc_goods_third_party: str
        :keyword rpc_language: Default value is None.
        :paramtype rpc_language: str
        :keyword rpc_mdk_version: Default value is None.
        :paramtype rpc_mdk_version: str
        :keyword rpc_payment_version: Default value is None.
        :paramtype rpc_payment_version: str
        :keyword rpc_sdk_version: Default value is None.
        :paramtype rpc_sdk_version: str
        :keyword rpc_sub_channel_id: Default value is None.
        :paramtype rpc_sub_channel_id: str
        :keyword rpc_system_version: Default value is None.
        :paramtype rpc_system_version: str
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
        cls: ClsType[_models5.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_secure_api_get_red_dots_request(
            rpc_app_id=rpc_app_id,
            rpc_app_version=rpc_app_version,
            rpc_channel_id=rpc_channel_id,
            rpc_channel_version=rpc_channel_version,
            rpc_client_type=rpc_client_type,
            rpc_combo_version=rpc_combo_version,
            rpc_device_fingerprint=rpc_device_fingerprint,
            rpc_device_id=rpc_device_id,
            rpc_device_model=rpc_device_model,
            rpc_device_name=rpc_device_name,
            rpc_game_biz=rpc_game_biz,
            rpc_goods_third_party=rpc_goods_third_party,
            rpc_language=rpc_language,
            rpc_mdk_version=rpc_mdk_version,
            rpc_payment_version=rpc_payment_version,
            rpc_sdk_version=rpc_sdk_version,
            rpc_sub_channel_id=rpc_sub_channel_id,
            rpc_system_version=rpc_system_version,
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
            deserialized = _deserialize(_models5.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
