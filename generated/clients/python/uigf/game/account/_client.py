# coding=utf-8

from copy import deepcopy
import sys
from typing import Any

from corehttp.rest import HttpRequest, HttpResponse
from corehttp.runtime import PipelineClient, policies

from ...passport._utils.serialization import Deserializer, Serializer
from ._configuration import GameAccountClientConfiguration
from .operations import (
    ActionTicketApiOperations,
    BindingApiOperations,
    CultivationApiOperations,
    GameTokenApiOperations,
    GenshinObcApiOperations,
)

if sys.version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self  # type: ignore


class GameAccountClient:  # pylint: disable=client-accepts-api-version-keyword
    """CN game-account binding, Gacha auth-key, OBC, and cultivation calculator APIs.

    :ivar game_token_api: GameTokenApiOperations operations
    :vartype game_token_api: uigf.passport.operations.GameTokenApiOperations
    :ivar action_ticket_api: ActionTicketApiOperations operations
    :vartype action_ticket_api: uigf.passport.operations.ActionTicketApiOperations
    :ivar binding_api: BindingApiOperations operations
    :vartype binding_api: uigf.passport.operations.BindingApiOperations
    :ivar genshin_obc_api: GenshinObcApiOperations operations
    :vartype genshin_obc_api: uigf.passport.operations.GenshinObcApiOperations
    :ivar cultivation_api: CultivationApiOperations operations
    :vartype cultivation_api: uigf.passport.operations.CultivationApiOperations
    :keyword endpoint: Service host. Default value is "https://api-takumi.mihoyo.com".
    :paramtype endpoint: str
    """

    def __init__(  # pylint: disable=missing-client-constructor-parameter-credential
        self, *, endpoint: str = "https://api-takumi.mihoyo.com", **kwargs: Any
    ) -> None:
        _endpoint = "{endpoint}"
        self._config = GameAccountClientConfiguration(endpoint=endpoint, **kwargs)

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
        self.game_token_api = GameTokenApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.action_ticket_api = ActionTicketApiOperations(
            self._client, self._config, self._serialize, self._deserialize
        )
        self.binding_api = BindingApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.genshin_obc_api = GenshinObcApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.cultivation_api = CultivationApiOperations(self._client, self._config, self._serialize, self._deserialize)

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
