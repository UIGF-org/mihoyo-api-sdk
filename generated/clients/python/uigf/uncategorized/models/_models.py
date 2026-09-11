# coding=utf-8
# pylint: disable=useless-super-delegation

from typing import Any, Mapping, Optional, TYPE_CHECKING, overload

from ...models import ApiResponseArray
from ...passport._utils.model_base import Model as _Model, rest_field

if TYPE_CHECKING:
    from .. import models as _models
    from ... import models as _models2
List = list


class ComboTokenRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """ComboTokenRequest.

    :ivar biz: Required.
    :vartype biz: str
    """

    biz: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        biz: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ExperimentListRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """ExperimentListRequest.

    :ivar app_id: Required.
    :vartype app_id: int
    :ivar app_sign: Required.
    :vartype app_sign: str
    :ivar params: Required.
    :vartype params: list[~uigf.uncategorized.models.ExperimentParameter]
    :ivar scene_id: Required.
    :vartype scene_id: str
    :ivar uid: Required.
    :vartype uid: str
    """

    app_id: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    app_sign: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    params: list["_models.ExperimentParameter"] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    scene_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    uid: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        app_id: int,
        app_sign: str,
        params: list["_models.ExperimentParameter"],
        scene_id: str,
        uid: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ExperimentListResponse(ApiResponseArray):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """ExperimentListResponse.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: list[~uigf.models.JsonObject]
    :ivar success:
    :vartype success: bool
    """

    success: Optional[bool] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: list["_models2.JsonObject"],
        success: Optional[bool] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ExperimentParameter(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """ExperimentParameter.

    :ivar k: Required.
    :vartype k: str
    :ivar v: Required.
    :vartype v: str
    """

    k: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    v: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        k: str,
        v: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class H5LogRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """H5LogRequest.

    :ivar data: Required.
    :vartype data: str
    """

    data: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        data: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class UploadResponse(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """UploadResponse.

    :ivar code: Required.
    :vartype code: int
    :ivar message: Required.
    :vartype message: str
    """

    code: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        code: int,
        message: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)
