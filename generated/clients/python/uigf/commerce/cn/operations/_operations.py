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
from .._configuration import CommerceClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, HttpResponse], T, dict[str, Any]], Any]]
List = list

_SERIALIZER = Serializer()
_SERIALIZER.client_side_validation = False


def build_shop_api_fetch_goods_request(game_biz: str, *, cookie: Optional[str] = None, **kwargs: Any) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/{gameBiz}/mdk/shopwindow/shopwindow/fetchGoods"
    path_format_arguments = {
        "gameBiz": _SERIALIZER.url("game_biz", game_biz, "str"),
    }

    _url: str = _url.format(**path_format_arguments)  # type: ignore

    # Construct headers
    if cookie is not None:
        _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_shop_api_create_order_request(game_biz: str, *, cookie: str, device_id: str, **kwargs: Any) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})

    content_type: Optional[str] = kwargs.pop("content_type", _headers.pop("Content-Type", None))
    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/{gameBiz}/mdk/atropos/api/createOrder"
    path_format_arguments = {
        "gameBiz": _SERIALIZER.url("game_biz", game_biz, "str"),
    }

    _url: str = _url.format(**path_format_arguments)  # type: ignore

    # Construct headers
    _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["x-rpc-device_id"] = _SERIALIZER.header("device_id", device_id, "str")
    if content_type is not None:
        _headers["Content-Type"] = _SERIALIZER.header("content_type", content_type, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="POST", url=_url, headers=_headers, **kwargs)


def build_shop_api_check_order_request(
    game_biz: str, *, order_no: str, game: str, region: str, uid: str, cookie: Optional[str] = None, **kwargs: Any
) -> HttpRequest:
    _headers = case_insensitive_dict(kwargs.pop("headers", {}) or {})
    _params = case_insensitive_dict(kwargs.pop("params", {}) or {})

    accept = _headers.pop("Accept", "application/json")

    # Construct URL
    _url = "/{gameBiz}/mdk/atropos/api/checkOrder"
    path_format_arguments = {
        "gameBiz": _SERIALIZER.url("game_biz", game_biz, "str"),
    }

    _url: str = _url.format(**path_format_arguments)  # type: ignore

    # Construct parameters
    _params["order_no"] = _SERIALIZER.query("order_no", order_no, "str")
    _params["game"] = _SERIALIZER.query("game", game, "str")
    _params["region"] = _SERIALIZER.query("region", region, "str")
    _params["uid"] = _SERIALIZER.query("uid", uid, "str")

    # Construct headers
    if cookie is not None:
        _headers["Cookie"] = _SERIALIZER.header("cookie", cookie, "str")
    _headers["Accept"] = _SERIALIZER.header("accept", accept, "str")

    return HttpRequest(method="GET", url=_url, params=_params, headers=_headers, **kwargs)


class ShopApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.CommerceClient`'s
        :attr:`shop_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: PipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: CommerceClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    def fetch_goods(
        self,
        game_biz: str,
        body: _models2.ShopGoodsRequest,
        *,
        cookie: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseShopGoods:
        """Returns purchasable catalogue entries for the authenticated game account.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Required.
        :type body: ~uigf.commerce.models.ShopGoodsRequest
        :keyword cookie: Default value is None.
        :paramtype cookie: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseShopGoods. The ApiResponseShopGoods is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseShopGoods
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def fetch_goods(
        self,
        game_biz: str,
        body: _types_models2.ShopGoodsRequest,
        *,
        cookie: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseShopGoods:
        """Returns purchasable catalogue entries for the authenticated game account.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Required.
        :type body: ~uigf.commerce.types.ShopGoodsRequest
        :keyword cookie: Default value is None.
        :paramtype cookie: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseShopGoods. The ApiResponseShopGoods is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseShopGoods
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def fetch_goods(
        self,
        game_biz: str,
        body: IO[bytes],
        *,
        cookie: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseShopGoods:
        """Returns purchasable catalogue entries for the authenticated game account.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Required.
        :type body: IO[bytes]
        :keyword cookie: Default value is None.
        :paramtype cookie: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseShopGoods. The ApiResponseShopGoods is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseShopGoods
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def fetch_goods(
        self,
        game_biz: str,
        body: Union[_models2.ShopGoodsRequest, _types_models2.ShopGoodsRequest, IO[bytes]],
        *,
        cookie: Optional[str] = None,
        **kwargs: Any
    ) -> _models3.ApiResponseShopGoods:
        """Returns purchasable catalogue entries for the authenticated game account.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Is either a ShopGoodsRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.commerce.models.ShopGoodsRequest or ~uigf.commerce.types.ShopGoodsRequest or
         IO[bytes]
        :keyword cookie: Default value is None.
        :paramtype cookie: str
        :return: ApiResponseShopGoods. The ApiResponseShopGoods is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseShopGoods
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
        cls: ClsType[_models3.ApiResponseShopGoods] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_shop_api_fetch_goods_request(
            game_biz=game_biz,
            cookie=cookie,
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
            deserialized = _deserialize(_models3.ApiResponseShopGoods, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    def create_order(
        self,
        game_biz: str,
        body: _models2.CreateOrderRequest,
        *,
        cookie: str,
        device_id: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Sends a vendor-signed order request; no payment signing is generated by this SDK.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Required.
        :type body: ~uigf.commerce.models.CreateOrderRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword device_id: Required.
        :paramtype device_id: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def create_order(
        self,
        game_biz: str,
        body: _types_models2.CreateOrderRequest,
        *,
        cookie: str,
        device_id: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Sends a vendor-signed order request; no payment signing is generated by this SDK.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Required.
        :type body: ~uigf.commerce.types.CreateOrderRequest
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword device_id: Required.
        :paramtype device_id: str
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    def create_order(
        self,
        game_biz: str,
        body: IO[bytes],
        *,
        cookie: str,
        device_id: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Sends a vendor-signed order request; no payment signing is generated by this SDK.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Required.
        :type body: IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword device_id: Required.
        :paramtype device_id: str
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    def create_order(
        self,
        game_biz: str,
        body: Union[_models2.CreateOrderRequest, _types_models2.CreateOrderRequest, IO[bytes]],
        *,
        cookie: str,
        device_id: str,
        **kwargs: Any
    ) -> _models3.ApiResponseJsonObject:
        """Sends a vendor-signed order request; no payment signing is generated by this SDK.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Is either a CreateOrderRequest type or a IO[bytes] type. Required.
        :type body: ~uigf.commerce.models.CreateOrderRequest or ~uigf.commerce.types.CreateOrderRequest
         or IO[bytes]
        :keyword cookie: Required.
        :paramtype cookie: str
        :keyword device_id: Required.
        :paramtype device_id: str
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
        cls: ClsType[_models3.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json"
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore

        _request = build_shop_api_create_order_request(
            game_biz=game_biz,
            cookie=cookie,
            device_id=device_id,
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
            deserialized = _deserialize(_models3.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    def check_order(
        self,
        game_biz: str,
        *,
        order_no: str,
        game: str,
        region: str,
        uid: str,
        cookie: Optional[str] = None,
        **kwargs: Any
    ) -> _models3.ApiResponseOrderStatus:
        """check_order.

        :param game_biz: Required.
        :type game_biz: str
        :keyword order_no: Required.
        :paramtype order_no: str
        :keyword game: Required.
        :paramtype game: str
        :keyword region: Required.
        :paramtype region: str
        :keyword uid: Required.
        :paramtype uid: str
        :keyword cookie: Default value is None.
        :paramtype cookie: str
        :return: ApiResponseOrderStatus. The ApiResponseOrderStatus is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseOrderStatus
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

        cls: ClsType[_models3.ApiResponseOrderStatus] = kwargs.pop("cls", None)

        _request = build_shop_api_check_order_request(
            game_biz=game_biz,
            order_no=order_no,
            game=game,
            region=region,
            uid=uid,
            cookie=cookie,
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
            deserialized = _deserialize(_models3.ApiResponseOrderStatus, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
