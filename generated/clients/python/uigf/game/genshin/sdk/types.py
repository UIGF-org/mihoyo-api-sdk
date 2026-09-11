# coding=utf-8

from typing_extensions import Required, TypedDict


class GranterLoginRequest(TypedDict, total=False):
    """GranterLoginRequest.

    :ivar app_id: Required.
    :vartype app_id: str
    :ivar channel_id: Required.
    :vartype channel_id: str
    :ivar data: Required.
    :vartype data: str
    :ivar device: Required.
    :vartype device: str
    :ivar sign: Required.
    :vartype sign: str
    """

    app_id: Required[str]
    """Required."""
    channel_id: Required[str]
    """Required."""
    data: Required[str]
    """Required."""
    device: Required[str]
    """Required."""
    sign: Required[str]
    """Required."""


class ProtocolVersionRequest(TypedDict, total=False):
    """ProtocolVersionRequest.

    :ivar app_id: Required.
    :vartype app_id: str
    :ivar channel_id: Required.
    :vartype channel_id: str
    :ivar language: Required.
    :vartype language: str
    :ivar major: Required.
    :vartype major: str
    :ivar minimum: Required.
    :vartype minimum: str
    """

    app_id: Required[str]
    """Required."""
    channel_id: Required[str]
    """Required."""
    language: Required[str]
    """Required."""
    major: Required[str]
    """Required."""
    minimum: Required[str]
    """Required."""


class RedDotRequest(TypedDict, total=False):
    """RedDotRequest.

    :ivar game_biz: Required.
    :vartype game_biz: str
    :ivar player_level: Required.
    :vartype player_level: int
    :ivar region: Required.
    :vartype region: str
    :ivar uid: Required.
    :vartype uid: str
    """

    game_biz: Required[str]
    """Required."""
    player_level: Required[int]
    """Required."""
    region: Required[str]
    """Required."""
    uid: Required[str]
    """Required."""
