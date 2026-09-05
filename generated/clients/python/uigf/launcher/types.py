# coding=utf-8

from typing_extensions import Required, TypedDict


class DxConfigRequest(TypedDict, total=False):
    """DxConfigRequest.

    :ivar launcher_id: Required.
    :vartype launcher_id: str
    :ivar language: Required.
    :vartype language: str
    :ivar game_ids: Required.
    :vartype game_ids: list[str]
    :ivar gpu_info: Required.
    :vartype gpu_info: list["GpuInfo"]
    """

    launcher_id: Required[str]
    """Required."""
    language: Required[str]
    """Required."""
    game_ids: Required[list[str]]
    """Required."""
    gpu_info: Required[list["GpuInfo"]]
    """Required."""


class GpuInfo(TypedDict, total=False):
    """GpuInfo.

    :ivar name:
    :vartype name: str
    :ivar vendor_id:
    :vartype vendor_id: int
    :ivar device_id:
    :vartype device_id: int
    """

    name: str
    vendor_id: int
    device_id: int
