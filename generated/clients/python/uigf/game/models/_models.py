# coding=utf-8
# pylint: disable=useless-super-delegation

from typing import Any, Mapping, Optional, TYPE_CHECKING, overload

from ...passport._utils.model_base import Model as _Model, rest_field

if TYPE_CHECKING:
    from .. import models as _models
List = list


class AuthKeyRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
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

    auth_appid: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    game_biz: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    game_uid: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    region: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        auth_appid: str,
        game_biz: str,
        game_uid: str,
        region: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class CalculateRequest(_Model):
    """CalculateRequest."""


class Character(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Character.

    :ivar id:
    :vartype id: int
    :ivar name:
    :vartype name: str
    :ivar level:
    :vartype level: int
    :ivar image:
    :vartype image: str
    :ivar icon:
    :vartype icon: str
    :ivar rarity:
    :vartype rarity: int
    :ivar element:
    :vartype element: str
    :ivar fetter:
    :vartype fetter: int
    :ivar actived_constellation_num:
    :vartype actived_constellation_num: int
    """

    id: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    name: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    level: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    image: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    icon: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    rarity: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    element: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    fetter: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    actived_constellation_num: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        id: Optional[int] = None,  # pylint: disable=redefined-builtin
        name: Optional[str] = None,
        level: Optional[int] = None,
        image: Optional[str] = None,
        icon: Optional[str] = None,
        rarity: Optional[int] = None,
        element: Optional[str] = None,
        fetter: Optional[int] = None,
        actived_constellation_num: Optional[int] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class CharacterListRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """CharacterListRequest.

    :ivar role_id: Required.
    :vartype role_id: str
    :ivar server: Required.
    :vartype server: str
    """

    role_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    server: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        role_id: str,
        server: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class CharacterDetailRequest(CharacterListRequest):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """CharacterDetailRequest.

    :ivar role_id: Required.
    :vartype role_id: str
    :ivar server: Required.
    :vartype server: str
    :ivar character_ids: Required.
    :vartype character_ids: list[str]
    """

    character_ids: list[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        role_id: str,
        server: str,
        character_ids: list[str],
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class CharacterList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """CharacterList.

    :ivar list: Required.
    :vartype list: list[~uigf.game.models.Character]
    """

    list: list["_models.Character"] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        list: list["_models.Character"],
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class DeviceFingerprint(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """DeviceFingerprint.

    :ivar device_fp:
    :vartype device_fp: str
    :ivar code:
    :vartype code: int
    :ivar msg:
    :vartype msg: str
    """

    device_fp: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    code: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    msg: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        device_fp: Optional[str] = None,
        code: Optional[int] = None,
        msg: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class DeviceFingerprintRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """DeviceFingerprintRequest.

    :ivar seed_id: Required.
    :vartype seed_id: str
    :ivar device_id: Required.
    :vartype device_id: str
    :ivar platform: Required.
    :vartype platform: str
    """

    seed_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    device_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    platform: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        seed_id: str,
        device_id: str,
        platform: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class PandaQrRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """PandaQrRequest.

    :ivar app_id: Required.
    :vartype app_id: int
    :ivar device: Required.
    :vartype device: str
    :ivar ticket:
    :vartype ticket: str
    """

    app_id: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    device: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    ticket: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        app_id: int,
        device: str,
        ticket: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class PandaQrResponse(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """PandaQrResponse.

    :ivar ticket:
    :vartype ticket: str
    :ivar url:
    :vartype url: str
    :ivar stat:
    :vartype stat: str
    """

    ticket: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    url: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    stat: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        ticket: Optional[str] = None,
        url: Optional[str] = None,
        stat: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)
