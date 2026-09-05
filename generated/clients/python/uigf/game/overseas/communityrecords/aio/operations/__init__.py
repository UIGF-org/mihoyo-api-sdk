# coding=utf-8
# pylint: disable=wrong-import-position

from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from ._patch import *  # pylint: disable=unused-wildcard-import

from ._operations import UserApiOperations  # type: ignore
from ._operations import GenshinChallengeApiOperations  # type: ignore
from ._operations import StarRailChallengeApiOperations  # type: ignore
from ._operations import HonkaiImpactApiOperations  # type: ignore

from ._patch import __all__ as _patch_all
from ._patch import *
from ._patch import patch_sdk as _patch_sdk

__all__ = [
    "UserApiOperations",
    "GenshinChallengeApiOperations",
    "StarRailChallengeApiOperations",
    "HonkaiImpactApiOperations",
]
__all__.extend([p for p in _patch_all if p not in __all__])  # pyright: ignore
_patch_sdk()
