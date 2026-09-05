# coding=utf-8

from copy import deepcopy
import sys
from typing import Any

from corehttp.rest import HttpRequest, HttpResponse
from corehttp.runtime import PipelineClient, policies

from ..passport._utils.serialization import Deserializer, Serializer
from ._configuration import CommunityClientConfiguration
from .operations import (
    ApiHubOperations,
    CoinRecordApiOperations,
    CollectionApiOperations,
    FeedApiOperations,
    MiscApiOperations,
    PostApiOperations,
    TopicApiOperations,
    UserApiOperations,
)

if sys.version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self  # type: ignore


class CommunityClient:  # pylint: disable=client-accepts-api-version-keyword,too-many-instance-attributes
    """MiYouShe (CN community) forum, post, task, and check-in APIs.

    :ivar user_api: UserApiOperations operations
    :vartype user_api: uigf.passport.operations.UserApiOperations
    :ivar misc_api: MiscApiOperations operations
    :vartype misc_api: uigf.passport.operations.MiscApiOperations
    :ivar collection_api: CollectionApiOperations operations
    :vartype collection_api: uigf.passport.operations.CollectionApiOperations
    :ivar coin_record_api: CoinRecordApiOperations operations
    :vartype coin_record_api: uigf.passport.operations.CoinRecordApiOperations
    :ivar post_api: PostApiOperations operations
    :vartype post_api: uigf.passport.operations.PostApiOperations
    :ivar feed_api: FeedApiOperations operations
    :vartype feed_api: uigf.passport.operations.FeedApiOperations
    :ivar topic_api: TopicApiOperations operations
    :vartype topic_api: uigf.passport.operations.TopicApiOperations
    :ivar api_hub: ApiHubOperations operations
    :vartype api_hub: uigf.passport.operations.ApiHubOperations
    :keyword endpoint: Service host. Default value is "https://bbs-api.miyoushe.com".
    :paramtype endpoint: str
    """

    def __init__(  # pylint: disable=missing-client-constructor-parameter-credential
        self, *, endpoint: str = "https://bbs-api.miyoushe.com", **kwargs: Any
    ) -> None:
        _endpoint = "{endpoint}"
        self._config = CommunityClientConfiguration(endpoint=endpoint, **kwargs)

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
        self.user_api = UserApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.misc_api = MiscApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.collection_api = CollectionApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.coin_record_api = CoinRecordApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.post_api = PostApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.feed_api = FeedApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.topic_api = TopicApiOperations(self._client, self._config, self._serialize, self._deserialize)
        self.api_hub = ApiHubOperations(self._client, self._config, self._serialize, self._deserialize)

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
