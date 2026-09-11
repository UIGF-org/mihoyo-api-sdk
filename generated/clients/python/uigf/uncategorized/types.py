# coding=utf-8

from typing_extensions import Required, TypedDict


class ComboTokenRequest(TypedDict, total=False):
    """ComboTokenRequest.

    :ivar biz: Required.
    :vartype biz: str
    """

    biz: Required[str]
    """Required."""


class ExperimentListRequest(TypedDict, total=False):
    """ExperimentListRequest.

    :ivar app_id: Required.
    :vartype app_id: int
    :ivar app_sign: Required.
    :vartype app_sign: str
    :ivar params: Required.
    :vartype params: list["ExperimentParameter"]
    :ivar scene_id: Required.
    :vartype scene_id: str
    :ivar uid: Required.
    :vartype uid: str
    """

    app_id: Required[int]
    """Required."""
    app_sign: Required[str]
    """Required."""
    params: Required[list["ExperimentParameter"]]
    """Required."""
    scene_id: Required[str]
    """Required."""
    uid: Required[str]
    """Required."""


class ExperimentParameter(TypedDict, total=False):
    """ExperimentParameter.

    :ivar k: Required.
    :vartype k: str
    :ivar v: Required.
    :vartype v: str
    """

    k: Required[str]
    """Required."""
    v: Required[str]
    """Required."""


class H5LogRequest(TypedDict, total=False):
    """H5LogRequest.

    :ivar data: Required.
    :vartype data: str
    """

    data: Required[str]
    """Required."""
