# coding=utf-8

from typing_extensions import Required, TypedDict


class AuthKeyRequest(TypedDict, total=False):
    """AuthKeyRequest.

    :ivar auth_appid: Required.
    :vartype auth_appid: str
    :ivar game_biz: Required.
    :vartype game_biz: str
    :ivar game_uid: Required.
    :vartype game_uid: str
    :ivar region: Required.
    :vartype region: str
    """

    auth_appid: Required[str]
    """Required."""
    game_biz: Required[str]
    """Required."""
    game_uid: Required[str]
    """Required."""
    region: Required[str]
    """Required."""


class CalculateRequest(TypedDict, total=False):
    """CalculateRequest."""


class CharacterListRequest(TypedDict, total=False):
    """CharacterListRequest.

    :ivar role_id: Required.
    :vartype role_id: str
    :ivar server: Required.
    :vartype server: str
    """

    role_id: Required[str]
    """Required."""
    server: Required[str]
    """Required."""


class CharacterDetailRequest(CharacterListRequest):
    """CharacterDetailRequest.

    :ivar role_id: Required.
    :vartype role_id: str
    :ivar server: Required.
    :vartype server: str
    :ivar character_ids: Required.
    :vartype character_ids: list[str]
    """

    character_ids: Required[list[str]]
    """Required."""


class DeviceFingerprintRequest(TypedDict, total=False):
    """DeviceFingerprintRequest.

    :ivar app_name: Required.
    :vartype app_name: str
    :ivar device_fp: Required.
    :vartype device_fp: str
    :ivar seed_id: Required.
    :vartype seed_id: str
    :ivar device_id: Required.
    :vartype device_id: str
    :ivar ext_fields: Required.
    :vartype ext_fields: str
    :ivar platform: Required.
    :vartype platform: str
    :ivar seed_time: Required.
    :vartype seed_time: str
    """

    app_name: Required[str]
    """Required."""
    device_fp: Required[str]
    """Required."""
    seed_id: Required[str]
    """Required."""
    device_id: Required[str]
    """Required."""
    ext_fields: Required[str]
    """Required."""
    platform: Required[str]
    """Required."""
    seed_time: Required[str]
    """Required."""


class PandaQrRequest(TypedDict, total=False):
    """PandaQrRequest.

    :ivar app_id: Required.
    :vartype app_id: int
    :ivar device: Required.
    :vartype device: str
    :ivar ticket:
    :vartype ticket: str
    """

    app_id: Required[int]
    """Required."""
    device: Required[str]
    """Required."""
    ticket: str
