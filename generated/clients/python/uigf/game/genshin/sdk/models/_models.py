# coding=utf-8
# pylint: disable=useless-super-delegation

from typing import Any, Mapping, overload

from .....passport._utils.model_base import Model as _Model, rest_field

List = list


class GranterLoginRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
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

    app_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    channel_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    data: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    device: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    sign: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        app_id: str,
        channel_id: str,
        data: str,
        device: str,
        sign: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ProtocolVersionRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
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

    app_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    channel_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    language: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    major: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    minimum: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        app_id: str,
        channel_id: str,
        language: str,
        major: str,
        minimum: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class RedDotRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
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

    game_biz: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    player_level: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    region: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    uid: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        game_biz: str,
        player_level: int,
        region: str,
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
