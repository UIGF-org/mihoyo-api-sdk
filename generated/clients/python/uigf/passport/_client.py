# coding=utf-8

from copy import deepcopy
import sys
from typing import Any

from corehttp.rest import HttpRequest, HttpResponse
from corehttp.runtime import PipelineClient, policies

from ._configuration import PassportClientConfiguration
from ._utils.serialization import Deserializer, Serializer
from .operations import (
    AccountTokenApiOperations,
    AuthTicketApiOperations,
    CaptchaApiOperations,
    QrLoginApiOperations,
    SessionApiOperations,
)

if sys.version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self  # type: ignore


class PassportClient:  # pylint: disable=client-accepts-api-version-keyword
    """Passport, login-ticket, QR login, and account-token APIs for CN services.

    :ivar auth_ticket_api: AuthTicketApiOperations operations
    :vartype auth_ticket_api: uigf.passport.operations.AuthTicketApiOperations
    :ivar captcha_api: CaptchaApiOperations operations
    :vartype captcha_api: uigf.passport.operations.CaptchaApiOperations
    :ivar qr_login_api: QrLoginApiOperations operations
    :vartype qr_login_api: uigf.passport.operations.QrLoginApiOperations
    :ivar session_api: SessionApiOperations operations
    :vartype session_api: uigf.passport.operations.SessionApiOperations
    :ivar account_token_api: AccountTokenApiOperations operations
    :vartype account_token_api: uigf.passport.operations.AccountTokenApiOperations
    :keyword endpoint: Service host. Default value is "https://passport-api.mihoyo.com".
    :paramtype endpoint: str
    """

    def __init__(  # pylint: disable=missing-client-constructor-parameter-credential
        self, *, endpoint: str = "https://passport-api.mihoyo.com", **kwargs: Any
    ) -> None:
        _endpoint = "{endpoint}"
        self._config = PassportClientConfiguration(endpoint=endpoint, **kwargs)

        _policies = kwargs.pop("policies", None)
        if _policies is None:
            _policies = [
                self._config.headers_policy,
                self._config.user_agent_policy,
                self._config.proxy_policy,
                policies.ContentDecodePolicy(**kwargs),
                self._config.retry_policy,
                self._config.authentication_policy,
                self._config.logging_policy,
            ]
        self._client: PipelineClient = PipelineClient(endpoint=_endpoint, policies=_policies, **kwargs)

        self._serialize = Serializer()
        self._deserialize = Deserializer()
        self._serialize.client_side_validation = False
        self.auth_ticket_api = AuthTicketApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.captcha_api = CaptchaApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.qr_login_api = QrLoginApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.session_api = SessionApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.account_token_api = AccountTokenApiOperations(
            self._client, self._config, self._serialize, self._deserialize
        )

    def send_request(self, request: HttpRequest, *, stream: bool = False, **kwargs: Any) -> HttpResponse:
        """Runs the network request through the client's chained policies.

        >>> from corehttp.rest import HttpRequest
        >>> request = HttpRequest("GET", "https://www.example.org/")
        <HttpRequest [GET], url: 'https://www.example.org/'>
        >>> response = client.send_request(request)
        <HttpResponse: 200 OK>

        For more information on this code flow, see https://aka.ms/azsdk/dpcodegen/python/send_request

        :param request: The network request you want to make. Required.
        :type request: ~corehttp.rest.HttpRequest
        :keyword bool stream: Whether the response payload will be streamed. Defaults to False.
        :return: The response of your network call. Does not do error handling on your response.
        :rtype: ~corehttp.rest.HttpResponse
        """

        request_copy = deepcopy(request)
        path_format_arguments = {
            "endpoint": self._serialize.url("self._config.endpoint", self._config.endpoint, "str", skip_quote=True),
        }

        request_copy.url = self._client.format_url(request_copy.url, **path_format_arguments)
        return self._client.send_request(request_copy, stream=stream, **kwargs)  # type: ignore

    def close(self) -> None:
        self._client.close()

    def __enter__(self) -> Self:
        self._client.__enter__()
        return self

    def __exit__(self, *exc_details: Any) -> None:
        self._client.__exit__(*exc_details)
