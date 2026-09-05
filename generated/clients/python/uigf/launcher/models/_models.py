# coding=utf-8
# pylint: disable=useless-super-delegation

from typing import Any, Mapping, Optional, TYPE_CHECKING, overload

from ...passport._utils.model_base import Model as _Model, rest_field

if TYPE_CHECKING:
    from .. import models as _models
    from ... import models as _models2
List = list


class DxConfigRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """DxConfigRequest.

    :ivar launcher_id: Required.
    :vartype launcher_id: str
    :ivar language: Required.
    :vartype language: str
    :ivar game_ids: Required.
    :vartype game_ids: list[str]
    :ivar gpu_info: Required.
    :vartype gpu_info: list[~uigf.launcher.models.GpuInfo]
    """

    launcher_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    language: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    game_ids: list[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    gpu_info: list["_models.GpuInfo"] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        launcher_id: str,
        language: str,
        game_ids: list[str],
        gpu_info: list["_models.GpuInfo"],
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class GameBasicInfo(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """GameBasicInfo.

    :ivar game_info_list:
    :vartype game_info_list: list[~uigf.models.JsonObject]
    """

    game_info_list: Optional[list["_models2.JsonObject"]] = rest_field(
        visibility=["read", "create", "update", "delete", "query"]
    )

    @overload
    def __init__(
        self,
        *,
        game_info_list: Optional[list["_models2.JsonObject"]] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class GpuInfo(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """GpuInfo.

    :ivar name:
    :vartype name: str
    :ivar vendor_id:
    :vartype vendor_id: int
    :ivar device_id:
    :vartype device_id: int
    """

    name: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    vendor_id: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    device_id: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        name: Optional[str] = None,
        vendor_id: Optional[int] = None,
        device_id: Optional[int] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)
