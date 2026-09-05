# coding=utf-8
# pylint: disable=useless-super-delegation

from typing import Any, Mapping, Optional, TYPE_CHECKING, overload

from ...passport._utils.model_base import Model as _Model, rest_field

if TYPE_CHECKING:
    from .. import models as _models
    from ... import models as _models2
List = list


class BonusDescription(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """BonusDescription.

    :ivar bonus_desc:
    :vartype bonus_desc: str
    :ivar bonus_unit:
    :vartype bonus_unit: int
    :ivar bonus_goods_id:
    :vartype bonus_goods_id: str
    :ivar bonus_icon:
    :vartype bonus_icon: str
    """

    bonus_desc: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    bonus_unit: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    bonus_goods_id: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    bonus_icon: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        bonus_desc: Optional[str] = None,
        bonus_unit: Optional[int] = None,
        bonus_goods_id: Optional[str] = None,
        bonus_icon: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class CreateOrderRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Vendor-signed order creation payload. ``sign`` must come from an authorized official client or
    payment integration; this SDK intentionally does not implement signing or retain payment
    secrets.

    :ivar open_id:
    :vartype open_id: str
    :ivar special_info:
    :vartype special_info: str
    :ivar order: Required.
    :vartype order: ~uigf.models.JsonObject
    :ivar sign: Required.
    :vartype sign: str
    """

    open_id: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    special_info: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    order: "_models2.JsonObject" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    sign: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        order: "_models2.JsonObject",
        sign: str,
        open_id: Optional[str] = None,
        special_info: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class OrderStatus(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """OrderStatus.

    :ivar status:
    :vartype status: int
    :ivar amount:
    :vartype amount: str
    :ivar goods_num:
    :vartype goods_num: str
    :ivar goods_title:
    :vartype goods_title: str
    :ivar order_no:
    :vartype order_no: str
    :ivar pay_plat:
    :vartype pay_plat: str
    """

    status: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    amount: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    goods_num: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    goods_title: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    order_no: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    pay_plat: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        status: Optional[int] = None,
        amount: Optional[str] = None,
        goods_num: Optional[str] = None,
        goods_title: Optional[str] = None,
        order_no: Optional[str] = None,
        pay_plat: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ShopGood(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """ShopGood.

    :ivar goods_id: Required.
    :vartype goods_id: str
    :ivar goods_name: Required.
    :vartype goods_name: str
    :ivar goods_type:
    :vartype goods_type: str
    :ivar goods_unit:
    :vartype goods_unit: str
    :ivar goods_icon:
    :vartype goods_icon: str
    :ivar currency:
    :vartype currency: str
    :ivar price:
    :vartype price: str
    :ivar symbol:
    :vartype symbol: str
    :ivar tier_id:
    :vartype tier_id: str
    :ivar bonus_desc:
    :vartype bonus_desc: ~uigf.commerce.models.BonusDescription
    :ivar once_bonus_desc:
    :vartype once_bonus_desc: ~uigf.commerce.models.BonusDescription
    :ivar available:
    :vartype available: bool
    """

    goods_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    goods_name: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    goods_type: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    goods_unit: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    goods_icon: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    currency: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    price: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    symbol: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    tier_id: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    bonus_desc: Optional["_models.BonusDescription"] = rest_field(
        visibility=["read", "create", "update", "delete", "query"]
    )
    once_bonus_desc: Optional["_models.BonusDescription"] = rest_field(
        visibility=["read", "create", "update", "delete", "query"]
    )
    available: Optional[bool] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        goods_id: str,
        goods_name: str,
        goods_type: Optional[str] = None,
        goods_unit: Optional[str] = None,
        goods_icon: Optional[str] = None,
        currency: Optional[str] = None,
        price: Optional[str] = None,
        symbol: Optional[str] = None,
        tier_id: Optional[str] = None,
        bonus_desc: Optional["_models.BonusDescription"] = None,
        once_bonus_desc: Optional["_models.BonusDescription"] = None,
        available: Optional[bool] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ShopGoods(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """ShopGoods.

    :ivar goods_list: Required.
    :vartype goods_list: list[~uigf.commerce.models.ShopGood]
    """

    goods_list: list["_models.ShopGood"] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        goods_list: list["_models.ShopGood"],
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ShopGoodsRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """ShopGoodsRequest.

    :ivar released_flag:
    :vartype released_flag: bool
    :ivar game: Required.
    :vartype game: str
    :ivar region: Required.
    :vartype region: str
    :ivar uid: Required.
    :vartype uid: str
    :ivar account: Required.
    :vartype account: str
    """

    released_flag: Optional[bool] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    game: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    region: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    uid: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    account: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        game: str,
        region: str,
        uid: str,
        account: str,
        released_flag: Optional[bool] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)
