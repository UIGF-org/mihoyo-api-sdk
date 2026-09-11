# pylint: disable=too-many-lines
# coding=utf-8
# pylint: disable=useless-super-delegation

from typing import Any, Mapping, Optional, TYPE_CHECKING, overload

from ..passport._utils.model_base import Model as _Model, rest_field

if TYPE_CHECKING:
    from .. import models as _models
    from ..commerce import models as _commerce_models2
    from ..community import models as _community_models2
    from ..game import models as _game_models2
    from ..launcher import models as _launcher_models2
    from ..passport import models as _passport_models2
    from ..utility.device import models as _utility_device_models3
List = list


class Announcement(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Announcement.

    :ivar ann_id:
    :vartype ann_id: int
    :ivar title:
    :vartype title: str
    :ivar subtitle:
    :vartype subtitle: str
    :ivar banner:
    :vartype banner: str
    :ivar content:
    :vartype content: str
    :ivar start_time:
    :vartype start_time: str
    :ivar end_time:
    :vartype end_time: str
    :ivar type:
    :vartype type: int
    """

    ann_id: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    title: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    subtitle: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    banner: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    content: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    start_time: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    end_time: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    type: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        ann_id: Optional[int] = None,
        title: Optional[str] = None,
        subtitle: Optional[str] = None,
        banner: Optional[str] = None,
        content: Optional[str] = None,
        start_time: Optional[str] = None,
        end_time: Optional[str] = None,
        type: Optional[int] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class AnnouncementList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """AnnouncementList.

    :ivar list:
    :vartype list: list[~uigf.models.Announcement]
    :ivar alert:
    :vartype alert: bool
    """

    list: Optional[list["_models.Announcement"]] = rest_field(
        visibility=["read", "create", "update", "delete", "query"]
    )
    alert: Optional[bool] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        list: Optional[list["_models.Announcement"]] = None,
        alert: Optional[bool] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseAnnouncementList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.models.AnnouncementList
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_models.AnnouncementList" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_models.AnnouncementList",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseArray(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: list[~uigf.models.JsonObject]
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: list["_models.JsonObject"] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: list["_models.JsonObject"],
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseCharacterList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.game.models.CharacterList
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_game_models2.CharacterList" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_game_models2.CharacterList",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseCommunityUser(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.models.CommunityUser
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_models.CommunityUser" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_models.CommunityUser",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseDeviceExtensionList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.utility.device.models.DeviceExtensionList
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_utility_device_models3.DeviceExtensionList" = rest_field(
        visibility=["read", "create", "update", "delete", "query"]
    )
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_utility_device_models3.DeviceExtensionList",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseDeviceFingerprint(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.game.models.DeviceFingerprint
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_game_models2.DeviceFingerprint" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_game_models2.DeviceFingerprint",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseForumList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.community.models.ForumList
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_community_models2.ForumList" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_community_models2.ForumList",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseGachaLogPage(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.models.GachaLogPage
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_models.GachaLogPage" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_models.GachaLogPage",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseGameRoleList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.models.GameRoleList
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_models.GameRoleList" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_models.GameRoleList",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseJsonObject(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.models.JsonObject
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_models.JsonObject" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_models.JsonObject",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseOrderStatus(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.commerce.models.OrderStatus
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_commerce_models2.OrderStatus" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_commerce_models2.OrderStatus",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponsePandaQrResponse(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.game.models.PandaQrResponse
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_game_models2.PandaQrResponse" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_game_models2.PandaQrResponse",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponsePost(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.community.models.Post
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_community_models2.Post" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_community_models2.Post",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponsePostList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.community.models.PostList
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_community_models2.PostList" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_community_models2.PostList",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseQrLoginStatus(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.passport.models.QrLoginStatus
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_passport_models2.QrLoginStatus" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_passport_models2.QrLoginStatus",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseQrLoginTicket(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.passport.models.QrLoginTicket
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_passport_models2.QrLoginTicket" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_passport_models2.QrLoginTicket",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseShopGoods(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.commerce.models.ShopGoods
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_commerce_models2.ShopGoods" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_commerce_models2.ShopGoods",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ApiResponseTokenInfo(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common response wrapper returned by MiHoYo and HoYoLAB services.

    :ivar retcode: Vendor result code. ``0`` normally represents success. Required.
    :vartype retcode: int
    :ivar message: Vendor diagnostic message. Required.
    :vartype message: str
    :ivar data: Endpoint-specific payload. Required.
    :vartype data: ~uigf.passport.models.TokenInfo
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor result code. ``0`` normally represents success. Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Vendor diagnostic message. Required."""
    data: "_passport_models2.TokenInfo" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Endpoint-specific payload. Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_passport_models2.TokenInfo",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class CommunityUser(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """A user profile returned by community-account APIs.

    :ivar uid: Required.
    :vartype uid: str
    :ivar nickname:
    :vartype nickname: str
    :ivar introduce:
    :vartype introduce: str
    :ivar avatar_url:
    :vartype avatar_url: str
    :ivar gender:
    :vartype gender: int
    :ivar level_exp:
    :vartype level_exp: ~uigf.models.JsonObject
    :ivar community_info:
    :vartype community_info: ~uigf.models.JsonObject
    """

    uid: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    nickname: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    introduce: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    avatar_url: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    gender: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    level_exp: Optional["_models.JsonObject"] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    community_info: Optional["_models.JsonObject"] = rest_field(
        visibility=["read", "create", "update", "delete", "query"]
    )

    @overload
    def __init__(
        self,
        *,
        uid: str,
        nickname: Optional[str] = None,
        introduce: Optional[str] = None,
        avatar_url: Optional[str] = None,
        gender: Optional[int] = None,
        level_exp: Optional["_models.JsonObject"] = None,
        community_info: Optional["_models.JsonObject"] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class GachaItem(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """GachaItem.

    :ivar uid:
    :vartype uid: str
    :ivar gacha_type:
    :vartype gacha_type: str
    :ivar item_id:
    :vartype item_id: str
    :ivar count:
    :vartype count: str
    :ivar time:
    :vartype time: str
    :ivar name:
    :vartype name: str
    :ivar item_type:
    :vartype item_type: str
    :ivar rank_type:
    :vartype rank_type: str
    :ivar id: Required.
    :vartype id: str
    """

    uid: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    gacha_type: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    item_id: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    count: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    time: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    name: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    item_type: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    rank_type: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        id: str,  # pylint: disable=redefined-builtin
        uid: Optional[str] = None,
        gacha_type: Optional[str] = None,
        item_id: Optional[str] = None,
        count: Optional[str] = None,
        time: Optional[str] = None,
        name: Optional[str] = None,
        item_type: Optional[str] = None,
        rank_type: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class GachaLogPage(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """GachaLogPage.

    :ivar page:
    :vartype page: int
    :ivar size:
    :vartype size: int
    :ivar total:
    :vartype total: int
    :ivar region:
    :vartype region: str
    :ivar list: Required.
    :vartype list: list[~uigf.models.GachaItem]
    """

    page: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    size: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    total: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    region: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    list: list["_models.GachaItem"] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        list: list["_models.GachaItem"],
        page: Optional[int] = None,
        size: Optional[int] = None,
        total: Optional[int] = None,
        region: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class GameRole(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Standard game account identity reused by record APIs.

    :ivar game_biz: Required.
    :vartype game_biz: str
    :ivar region: Required.
    :vartype region: str
    :ivar game_uid: Required.
    :vartype game_uid: str
    :ivar nickname:
    :vartype nickname: str
    :ivar level:
    :vartype level: int
    :ivar is_chosen:
    :vartype is_chosen: bool
    :ivar region_name:
    :vartype region_name: str
    :ivar game_name:
    :vartype game_name: str
    """

    game_biz: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    region: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    game_uid: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    nickname: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    level: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    is_chosen: Optional[bool] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    region_name: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    game_name: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        game_biz: str,
        region: str,
        game_uid: str,
        nickname: Optional[str] = None,
        level: Optional[int] = None,
        is_chosen: Optional[bool] = None,
        region_name: Optional[str] = None,
        game_name: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class GameRoleList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """GameRoleList.

    :ivar list: Required.
    :vartype list: list[~uigf.models.GameRole]
    """

    list: list["_models.GameRole"] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        list: list["_models.GameRole"],
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class JsonObject(_Model):
    """A JSON object whose vendor-defined properties are preserved by generated clients."""


class LauncherResponseGameBasicInfo(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common envelope used by the HoYoPlay and Sophon APIs.

    :ivar retcode: Required.
    :vartype retcode: int
    :ivar message: Required.
    :vartype message: str
    :ivar data: Required.
    :vartype data: ~uigf.launcher.models.GameBasicInfo
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    data: "_launcher_models2.GameBasicInfo" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_launcher_models2.GameBasicInfo",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class LauncherResponseJsonObject(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Common envelope used by the HoYoPlay and Sophon APIs.

    :ivar retcode: Required.
    :vartype retcode: int
    :ivar message: Required.
    :vartype message: str
    :ivar data: Required.
    :vartype data: ~uigf.models.JsonObject
    """

    retcode: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    message: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    data: "_models.JsonObject" = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        retcode: int,
        message: str,
        data: "_models.JsonObject",
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)
