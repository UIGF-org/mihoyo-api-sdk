# coding=utf-8

from typing import Any

from corehttp.runtime import policies

from ._version import VERSION


class PassportClientConfiguration:
    """Configuration for PassportClient.

    Note that all parameters used to create this instance are saved as instance
    attributes.

    :param endpoint: Service host. Default value is "https://passport-api.mihoyo.com".
    :type endpoint: str
    """

    def __init__(self, endpoint: str = "https://passport-api.mihoyo.com", **kwargs: Any) -> None:

        self.endpoint = endpoint
        kwargs.setdefault("sdk_moniker", "uigf-mihoyo/{}".format(VERSION))
        self.polling_interval = kwargs.get("polling_interval", 30)
        self._configure(**kwargs)

    def _configure(self, **kwargs: Any) -> None:
        self.user_agent_policy = kwargs.get("user_agent_policy") or policies.UserAgentPolicy(**kwargs)
        self.headers_policy = kwargs.get("headers_policy") or policies.HeadersPolicy(**kwargs)
        self.proxy_policy = kwargs.get("proxy_policy") or policies.ProxyPolicy(**kwargs)
        self.logging_policy = kwargs.get("logging_policy") or policies.NetworkTraceLoggingPolicy(**kwargs)
        self.retry_policy = kwargs.get("retry_policy") or policies.RetryPolicy(**kwargs)
        self.authentication_policy = kwargs.get("authentication_policy")
