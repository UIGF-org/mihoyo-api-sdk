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

from .... import models as _models3, types as _types_models3
from ..... import models as _models4, types as _types_models4
from .....passport._utils.model_base import SdkJSONEncoder, _deserialize
from .....passport._utils.serialization import Deserializer, Serializer
from ...operations._operations import (
    build_shop_api_check_order_request,
    build_shop_api_create_order_request,
    build_shop_api_fetch_goods_request,
    build_shop_api_get_currency_and_country_by_ip_request,
)
from .._configuration import CommerceClientConfiguration

T = TypeVar("T")
ClsType = Optional[Callable[[PipelineResponse[HttpRequest, AsyncHttpResponse], T, dict[str, Any]], Any]]
List = list


class ShopApiOperations:  # pylint: disable=docstring-missing-param
    """
    .. warning::
        **DO NOT** instantiate this class directly.

        Instead, you should access the following operations through
        :class:`~uigf.passport.aio.CommerceClient`'s
        :attr:`shop_api` attribute.
    """

    def __init__(self, *args, **kwargs) -> None:
        input_args = list(args)
        self._client: AsyncPipelineClient = input_args.pop(0) if input_args else kwargs.pop("client")
        self._config: CommerceClientConfiguration = input_args.pop(0) if input_args else kwargs.pop("config")
        self._serialize: Serializer = input_args.pop(0) if input_args else kwargs.pop("serializer")
        self._deserialize: Deserializer = input_args.pop(0) if input_args else kwargs.pop("deserializer")

    @overload
    async def fetch_goods(
        self,
        game_biz: str,
        body: _models3.ShopGoodsRequest,
        *,
        cookie: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseShopGoods:
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
    async def fetch_goods(
        self,
        game_biz: str,
        body: _types_models3.ShopGoodsRequest,
        *,
        cookie: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseShopGoods:
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
    async def fetch_goods(
        self,
        game_biz: str,
        body: IO[bytes],
        *,
        cookie: Optional[str] = None,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseShopGoods:
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

    async def fetch_goods(
        self,
        game_biz: str,
        body: Union[_models3.ShopGoodsRequest, _types_models3.ShopGoodsRequest, IO[bytes]],
        *,
        cookie: Optional[str] = None,
        **kwargs: Any
    ) -> _models4.ApiResponseShopGoods:
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
        cls: ClsType[_models4.ApiResponseShopGoods] = kwargs.pop("cls", None)

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
            deserialized = _deserialize(_models4.ApiResponseShopGoods, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    async def get_currency_and_country_by_ip(
        self,
        game_biz: str,
        body: Optional[_models4.JsonObject] = None,
        *,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """Returns the storefront currency and country inferred by the SDK host.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Default value is None.
        :type body: ~uigf.models.JsonObject
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def get_currency_and_country_by_ip(
        self,
        game_biz: str,
        body: Optional[_types_models4.JsonObject] = None,
        *,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """Returns the storefront currency and country inferred by the SDK host.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Default value is None.
        :type body: ~uigf.types.JsonObject
        :keyword content_type: Body Parameter content-type. Content type parameter for JSON body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    @overload
    async def get_currency_and_country_by_ip(
        self, game_biz: str, body: Optional[IO[bytes]] = None, *, content_type: str = "application/json", **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """Returns the storefront currency and country inferred by the SDK host.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Default value is None.
        :type body: IO[bytes]
        :keyword content_type: Body Parameter content-type. Content type parameter for binary body.
         Default value is "application/json".
        :paramtype content_type: str
        :return: ApiResponseJsonObject. The ApiResponseJsonObject is compatible with MutableMapping
        :rtype: ~uigf.models.ApiResponseJsonObject
        :raises ~corehttp.exceptions.HttpResponseError:
        """

    async def get_currency_and_country_by_ip(
        self,
        game_biz: str,
        body: Optional[Union[_models4.JsonObject, _types_models4.JsonObject, IO[bytes]]] = None,
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
        """Returns the storefront currency and country inferred by the SDK host.

        :param game_biz: Required.
        :type game_biz: str
        :param body: Is either a JsonObject type or a IO[bytes] type. Default value is None.
        :type body: ~uigf.models.JsonObject or ~uigf.types.JsonObject or IO[bytes]
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
        content_type = content_type if body else None
        cls: ClsType[_models4.ApiResponseJsonObject] = kwargs.pop("cls", None)

        content_type = content_type or "application/json" if body else None
        _content = None
        if isinstance(body, (IOBase, bytes)):
            _content = body
        else:
            if body is not None:
                _content = json.dumps(body, cls=SdkJSONEncoder, exclude_readonly=True)  # type: ignore
            else:
                _content = None

        _request = build_shop_api_get_currency_and_country_by_ip_request(
            game_biz=game_biz,
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
            deserialized = _deserialize(_models4.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    @overload
    async def create_order(
        self,
        game_biz: str,
        body: _models3.CreateOrderRequest,
        *,
        cookie: str,
        device_id: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
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
    async def create_order(
        self,
        game_biz: str,
        body: _types_models3.CreateOrderRequest,
        *,
        cookie: str,
        device_id: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
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
    async def create_order(
        self,
        game_biz: str,
        body: IO[bytes],
        *,
        cookie: str,
        device_id: str,
        content_type: str = "application/json",
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
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

    async def create_order(
        self,
        game_biz: str,
        body: Union[_models3.CreateOrderRequest, _types_models3.CreateOrderRequest, IO[bytes]],
        *,
        cookie: str,
        device_id: str,
        **kwargs: Any
    ) -> _models4.ApiResponseJsonObject:
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
        cls: ClsType[_models4.ApiResponseJsonObject] = kwargs.pop("cls", None)

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
            deserialized = _deserialize(_models4.ApiResponseJsonObject, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore

    async def check_order(
        self,
        game_biz: str,
        *,
        order_no: str,
        game: str,
        region: str,
        uid: str,
        cookie: Optional[str] = None,
        **kwargs: Any
    ) -> _models4.ApiResponseOrderStatus:
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

        cls: ClsType[_models4.ApiResponseOrderStatus] = kwargs.pop("cls", None)

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
            deserialized = _deserialize(_models4.ApiResponseOrderStatus, response.json())

        if cls:
            return cls(pipeline_response, deserialized, {})  # type: ignore

        return deserialized  # type: ignore
