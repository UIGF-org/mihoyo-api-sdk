# coding=utf-8
# pylint: disable=wrong-import-position

from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from ._patch import *  # pylint: disable=unused-wildcard-import


from ._models import (  # type: ignore
    AuthTicketRequest,
    DeviceContext,
    GameTokenRequest,
    LoginCaptchaRequest,
    MobileCaptchaLoginRequest,
    QrLoginCreateRequest,
    QrLoginStatus,
    QrLoginStatusRequest,
    QrLoginTicket,
    TokenInfo,
)
from ._patch import __all__ as _patch_all
from ._patch import *
from ._patch import patch_sdk as _patch_sdk

__all__ = [
    "AuthTicketRequest",
    "DeviceContext",
    "GameTokenRequest",
    "LoginCaptchaRequest",
    "MobileCaptchaLoginRequest",
    "QrLoginCreateRequest",
    "QrLoginStatus",
    "QrLoginStatusRequest",
    "QrLoginTicket",
    "TokenInfo",
]
__all__.extend([p for p in _patch_all if p not in __all__])  # pyright: ignore
_patch_sdk()
