# coding=utf-8

from typing_extensions import TypedDict


class JsonObject(TypedDict, total=False):
    """A JSON object whose vendor-defined properties are preserved by generated clients."""
