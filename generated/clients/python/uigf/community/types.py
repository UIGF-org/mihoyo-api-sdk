# coding=utf-8

from typing_extensions import Required, TypedDict


class FavoritePostRequest(TypedDict, total=False):
    """FavoritePostRequest.

    :ivar post_id: Required.
    :vartype post_id: str
    :ivar is_cancel: Required.
    :vartype is_cancel: bool
    """

    post_id: Required[str]
    """Required."""
    is_cancel: Required[bool]
    """Required."""


class LikePostRequest(TypedDict, total=False):
    """LikePostRequest.

    :ivar post_id: Required.
    :vartype post_id: str
    :ivar is_cancel: Required.
    :vartype is_cancel: bool
    """

    post_id: Required[str]
    """Required."""
    is_cancel: Required[bool]
    """Required."""


class LunaCheckInRequest(TypedDict, total=False):
    """LunaCheckInRequest.

    :ivar act_id: Required.
    :vartype act_id: str
    """

    act_id: Required[str]
    """Required."""


class SignInRequest(TypedDict, total=False):
    """SignInRequest.

    :ivar gids: Required.
    :vartype gids: int
    """

    gids: Required[int]
    """Required."""


class VerificationCreateRequest(TypedDict, total=False):
    """VerificationCreateRequest.

    :ivar action_type: Required.
    :vartype action_type: str
    """

    action_type: Required[str]
    """Required."""


class VerificationSubmitRequest(TypedDict, total=False):
    """VerificationSubmitRequest.

    :ivar challenge: Required.
    :vartype challenge: str
    :ivar validate: Required.
    :vartype validate: str
    :ivar seccode:
    :vartype seccode: str
    """

    challenge: Required[str]
    """Required."""
    validate: Required[str]
    """Required."""
    seccode: str
