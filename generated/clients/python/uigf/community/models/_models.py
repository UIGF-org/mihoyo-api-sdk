# coding=utf-8
# pylint: disable=useless-super-delegation

from typing import Any, Mapping, Optional, TYPE_CHECKING, overload

from ...passport._utils.model_base import Model as _Model, rest_field

if TYPE_CHECKING:
    from .. import models as _models
    from ... import models as _models2
List = list


class FavoritePostRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """FavoritePostRequest.

    :ivar post_id: Required.
    :vartype post_id: str
    :ivar is_cancel: Required.
    :vartype is_cancel: bool
    """

    post_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    is_cancel: bool = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        post_id: str,
        is_cancel: bool,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class Forum(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Forum.

    :ivar id:
    :vartype id: int
    :ivar game_id:
    :vartype game_id: int
    :ivar name:
    :vartype name: str
    :ivar icon:
    :vartype icon: str
    """

    id: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    game_id: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    name: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    icon: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        id: Optional[int] = None,  # pylint: disable=redefined-builtin
        game_id: Optional[int] = None,
        name: Optional[str] = None,
        icon: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class ForumList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """ForumList.

    :ivar list:
    :vartype list: list[~uigf.community.models.Forum]
    """

    list: Optional[list["_models.Forum"]] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        list: Optional[list["_models.Forum"]] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class LikePostRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """LikePostRequest.

    :ivar post_id: Required.
    :vartype post_id: str
    :ivar is_cancel: Required.
    :vartype is_cancel: bool
    """

    post_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    is_cancel: bool = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        post_id: str,
        is_cancel: bool,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class LunaCheckInRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """LunaCheckInRequest.

    :ivar act_id: Required.
    :vartype act_id: str
    """

    act_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        act_id: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class Post(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """Post.

    :ivar post_id:
    :vartype post_id: str
    :ivar subject:
    :vartype subject: str
    :ivar content:
    :vartype content: str
    :ivar created_at:
    :vartype created_at: int
    :ivar user:
    :vartype user: ~uigf.models.CommunityUser
    :ivar images:
    :vartype images: list[~uigf.models.JsonObject]
    """

    post_id: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    subject: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    content: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    created_at: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    user: Optional["_models2.CommunityUser"] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    images: Optional[list["_models2.JsonObject"]] = rest_field(
        visibility=["read", "create", "update", "delete", "query"]
    )

    @overload
    def __init__(
        self,
        *,
        post_id: Optional[str] = None,
        subject: Optional[str] = None,
        content: Optional[str] = None,
        created_at: Optional[int] = None,
        user: Optional["_models2.CommunityUser"] = None,
        images: Optional[list["_models2.JsonObject"]] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class PostList(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """PostList.

    :ivar list:
    :vartype list: list[~uigf.community.models.Post]
    :ivar is_last:
    :vartype is_last: bool
    :ivar last_id:
    :vartype last_id: str
    """

    list: Optional[list["_models.Post"]] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    is_last: Optional[bool] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    last_id: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        list: Optional[list["_models.Post"]] = None,
        is_last: Optional[bool] = None,
        last_id: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class SignInRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """SignInRequest.

    :ivar gids: Required.
    :vartype gids: int
    """

    gids: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        gids: int,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class VerificationCreateRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """VerificationCreateRequest.

    :ivar action_type: Required.
    :vartype action_type: str
    """

    action_type: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        action_type: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class VerificationSubmitRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """VerificationSubmitRequest.

    :ivar challenge: Required.
    :vartype challenge: str
    :ivar validate: Required.
    :vartype validate: str
    :ivar seccode:
    :vartype seccode: str
    """

    challenge: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    validate: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    seccode: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        challenge: str,
        validate: str,
        seccode: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)
