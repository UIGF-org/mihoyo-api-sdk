# coding=utf-8
# pylint: disable=wrong-import-position

from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from ._patch import *  # pylint: disable=unused-wildcard-import


from ._models import (  # type: ignore
    Announcement,
    AnnouncementList,
    ApiResponseAnnouncementList,
    ApiResponseCharacterList,
    ApiResponseCommunityUser,
    ApiResponseDeviceFingerprint,
    ApiResponseForumList,
    ApiResponseGachaLogPage,
    ApiResponseGameRoleList,
    ApiResponseJsonObject,
    ApiResponseOrderStatus,
    ApiResponsePandaQrResponse,
    ApiResponsePost,
    ApiResponsePostList,
    ApiResponseQrLoginStatus,
    ApiResponseQrLoginTicket,
    ApiResponseShopGoods,
    ApiResponseTokenInfo,
    CommunityUser,
    GachaItem,
    GachaLogPage,
    GameRole,
    GameRoleList,
    JsonObject,
    LauncherResponseGameBasicInfo,
    LauncherResponseJsonObject,
)
from ._patch import __all__ as _patch_all
from ._patch import *
from ._patch import patch_sdk as _patch_sdk

__all__ = [
    "Announcement",
    "AnnouncementList",
    "ApiResponseAnnouncementList",
    "ApiResponseCharacterList",
    "ApiResponseCommunityUser",
    "ApiResponseDeviceFingerprint",
    "ApiResponseForumList",
    "ApiResponseGachaLogPage",
    "ApiResponseGameRoleList",
    "ApiResponseJsonObject",
    "ApiResponseOrderStatus",
    "ApiResponsePandaQrResponse",
    "ApiResponsePost",
    "ApiResponsePostList",
    "ApiResponseQrLoginStatus",
    "ApiResponseQrLoginTicket",
    "ApiResponseShopGoods",
    "ApiResponseTokenInfo",
    "CommunityUser",
    "GachaItem",
    "GachaLogPage",
    "GameRole",
    "GameRoleList",
    "JsonObject",
    "LauncherResponseGameBasicInfo",
    "LauncherResponseJsonObject",
]
__all__.extend([p for p in _patch_all if p not in __all__])  # pyright: ignore
_patch_sdk()
