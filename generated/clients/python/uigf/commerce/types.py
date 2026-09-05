# coding=utf-8

from typing import TYPE_CHECKING
from typing_extensions import Required, TypedDict

if TYPE_CHECKING:
    from ..types import JsonObject


class CreateOrderRequest(TypedDict, total=False):
    """Vendor-signed order creation payload. ``sign`` must come from an authorized official client or
    payment integration; this SDK intentionally does not implement signing or retain payment
    secrets.

    :ivar open_id:
    :vartype open_id: str
    :ivar special_info:
    :vartype special_info: str
    :ivar order: Required.
    :vartype order: "JsonObject"
    :ivar sign: Required.
    :vartype sign: str
    """

    open_id: str
    special_info: str
    order: Required["JsonObject"]
    """Required."""
    sign: Required[str]
    """Required."""


class ShopGoodsRequest(TypedDict, total=False):
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

    released_flag: bool
    game: Required[str]
    """Required."""
    region: Required[str]
    """Required."""
    uid: Required[str]
    """Required."""
    account: Required[str]
    """Required."""
