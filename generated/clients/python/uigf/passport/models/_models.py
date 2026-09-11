# coding=utf-8
# pylint: disable=useless-super-delegation

from typing import Any, Mapping, Optional, TYPE_CHECKING, overload

from .._utils.model_base import Model as _Model, rest_field

if TYPE_CHECKING:
    from ... import models as _models2
List = list


class AuthTicketLoginRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """AuthTicketLoginRequest.

    :ivar ticket: Required.
    :vartype ticket: str
    """

    ticket: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        ticket: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class DeviceContext(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """DeviceContext.

    :ivar device: Required.
    :vartype device: str
    :ivar device_fp:
    :vartype device_fp: str
    :ivar device_name:
    :vartype device_name: str
    :ivar device_model:
    :vartype device_model: str
    :ivar device_id:
    :vartype device_id: str
    :ivar app_id:
    :vartype app_id: str
    """

    device: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    device_fp: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    device_name: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    device_model: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    device_id: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    app_id: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        device: str,
        device_fp: Optional[str] = None,
        device_name: Optional[str] = None,
        device_model: Optional[str] = None,
        device_id: Optional[str] = None,
        app_id: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class AuthTicketRequest(DeviceContext):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """AuthTicketRequest.

    :ivar device: Required.
    :vartype device: str
    :ivar device_fp:
    :vartype device_fp: str
    :ivar device_name:
    :vartype device_name: str
    :ivar device_model:
    :vartype device_model: str
    :ivar device_id:
    :vartype device_id: str
    :ivar app_id:
    :vartype app_id: str
    :ivar game_biz: Required.
    :vartype game_biz: str
    """

    game_biz: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        device: str,
        game_biz: str,
        device_fp: Optional[str] = None,
        device_name: Optional[str] = None,
        device_model: Optional[str] = None,
        device_id: Optional[str] = None,
        app_id: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class GameTokenRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """GameTokenRequest.

    :ivar account_id: Required.
    :vartype account_id: int
    :ivar game_token: Required.
    :vartype game_token: str
    """

    account_id: int = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    game_token: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        account_id: int,
        game_token: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class LoginCaptchaRequest(DeviceContext):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """LoginCaptchaRequest.

    :ivar device: Required.
    :vartype device: str
    :ivar device_fp:
    :vartype device_fp: str
    :ivar device_name:
    :vartype device_name: str
    :ivar device_model:
    :vartype device_model: str
    :ivar device_id:
    :vartype device_id: str
    :ivar app_id:
    :vartype app_id: str
    :ivar action_type: Required.
    :vartype action_type: str
    :ivar game_biz:
    :vartype game_biz: str
    """

    action_type: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    game_biz: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        device: str,
        action_type: str,
        device_fp: Optional[str] = None,
        device_name: Optional[str] = None,
        device_model: Optional[str] = None,
        device_id: Optional[str] = None,
        app_id: Optional[str] = None,
        game_biz: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class MobileCaptchaLoginRequest(DeviceContext):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """MobileCaptchaLoginRequest.

    :ivar device: Required.
    :vartype device: str
    :ivar device_fp:
    :vartype device_fp: str
    :ivar device_name:
    :vartype device_name: str
    :ivar device_model:
    :vartype device_model: str
    :ivar device_id:
    :vartype device_id: str
    :ivar app_id:
    :vartype app_id: str
    :ivar mobile: Required.
    :vartype mobile: str
    :ivar mobile_captcha: Required.
    :vartype mobile_captcha: str
    :ivar action_ticket:
    :vartype action_ticket: str
    :ivar game_biz:
    :vartype game_biz: str
    """

    mobile: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    mobile_captcha: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    action_ticket: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    game_biz: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        device: str,
        mobile: str,
        mobile_captcha: str,
        device_fp: Optional[str] = None,
        device_name: Optional[str] = None,
        device_model: Optional[str] = None,
        device_id: Optional[str] = None,
        app_id: Optional[str] = None,
        action_ticket: Optional[str] = None,
        game_biz: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class QrLoginCreateRequest(DeviceContext):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """QrLoginCreateRequest.

    :ivar device: Required.
    :vartype device: str
    :ivar device_fp:
    :vartype device_fp: str
    :ivar device_name:
    :vartype device_name: str
    :ivar device_model:
    :vartype device_model: str
    :ivar device_id:
    :vartype device_id: str
    :ivar app_id: Required.
    :vartype app_id: str
    """

    app_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        device: str,
        app_id: str,
        device_fp: Optional[str] = None,
        device_name: Optional[str] = None,
        device_model: Optional[str] = None,
        device_id: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class QrLoginStatus(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """QrLoginStatus.

    :ivar stat:
    :vartype stat: str
    :ivar status:
    :vartype status: str
    :ivar payload:
    :vartype payload: ~uigf.models.JsonObject
    """

    stat: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    status: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    payload: Optional["_models2.JsonObject"] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        stat: Optional[str] = None,
        status: Optional[str] = None,
        payload: Optional["_models2.JsonObject"] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class QrLoginStatusRequest(DeviceContext):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """QrLoginStatusRequest.

    :ivar device: Required.
    :vartype device: str
    :ivar device_fp:
    :vartype device_fp: str
    :ivar device_name:
    :vartype device_name: str
    :ivar device_model:
    :vartype device_model: str
    :ivar device_id:
    :vartype device_id: str
    :ivar ticket: Required.
    :vartype ticket: str
    :ivar app_id: Required.
    :vartype app_id: str
    """

    ticket: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    app_id: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        device: str,
        ticket: str,
        app_id: str,
        device_fp: Optional[str] = None,
        device_name: Optional[str] = None,
        device_model: Optional[str] = None,
        device_id: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class QrLoginTicket(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """QrLoginTicket.

    :ivar ticket: Required.
    :vartype ticket: str
    :ivar url:
    :vartype url: str
    :ivar expires_in:
    :vartype expires_in: int
    """

    ticket: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    url: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    expires_in: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        ticket: str,
        url: Optional[str] = None,
        expires_in: Optional[int] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class TokenExchangeRequest(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """TokenExchangeRequest.

    :ivar dst_token_type: Required.
    :vartype dst_token_type: str
    :ivar mid: Required.
    :vartype mid: str
    :ivar src_token: Required.
    :vartype src_token: str
    """

    dst_token_type: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    mid: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""
    src_token: str = rest_field(visibility=["read", "create", "update", "delete", "query"])
    """Required."""

    @overload
    def __init__(
        self,
        *,
        dst_token_type: str,
        mid: str,
        src_token: str,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)


class TokenInfo(_Model):  # pylint: disable=docstring-keyword-should-match-keyword-only
    """TokenInfo.

    :ivar account_id:
    :vartype account_id: int
    :ivar uid:
    :vartype uid: str
    :ivar token:
    :vartype token: str
    :ivar game_token:
    :vartype game_token: str
    :ivar stoken:
    :vartype stoken: str
    :ivar ltoken:
    :vartype ltoken: str
    :ivar cookie_token:
    :vartype cookie_token: str
    :ivar mid:
    :vartype mid: str
    """

    account_id: Optional[int] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    uid: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    token: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    game_token: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    stoken: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    ltoken: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    cookie_token: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])
    mid: Optional[str] = rest_field(visibility=["read", "create", "update", "delete", "query"])

    @overload
    def __init__(
        self,
        *,
        account_id: Optional[int] = None,
        uid: Optional[str] = None,
        token: Optional[str] = None,
        game_token: Optional[str] = None,
        stoken: Optional[str] = None,
        ltoken: Optional[str] = None,
        cookie_token: Optional[str] = None,
        mid: Optional[str] = None,
    ) -> None: ...

    @overload
    def __init__(self, mapping: Mapping[str, Any]) -> None:
        """
        :param mapping: raw JSON to initialize the model.
        :type mapping: Mapping[str, Any]
        """

    def __init__(self, *args: Any, **kwargs: Any) -> None:
        super().__init__(*args, **kwargs)
