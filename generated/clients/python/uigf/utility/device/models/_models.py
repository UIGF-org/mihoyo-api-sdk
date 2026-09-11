# coding=utf-8
# pylint: disable=useless-super-delegation

from typing import Any, Mapping, Optional, overload

from ....passport._utils.model_base import Model as _Model, rest_field

List = list


class DeviceExtensionList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """DeviceExtensionList.

    :ivar code:
    :vartype code: int
    :ivar ext_list:
    :vartype ext_list: list[str]
    :ivar msg:
    :vartype msg: str
    :ivar pkg_list:
    :vartype pkg_list: list[str]
    :ivar pkg_str:
    :vartype pkg_str: str
    """

    code: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    ext_list: Optional[list[str]] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    msg: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    pkg_list: Optional[list[str]] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    pkg_str: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        code: Optional[int] = None,
        ext_list: Optional[list[str]] = None,
        msg: Optional[str] = None,
        pkg_list: Optional[list[str]] = None,
        pkg_str: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)
