"""Smoke-test the installed wheel, including shared root types and async imports."""
import importlib
import inspect
import json
from pathlib import Path
import sys

client_directory = Path(sys.argv[1]).resolve() if len(sys.argv) > 1 else Path(__file__).resolve().parents[1] / "generated" / "clients" / "python"
if len(sys.argv) > 1:
    sys.path.insert(0, str(client_directory))

import uigf

services_path = client_directory / "services.json"
expected_count = len(json.loads(services_path.read_text(encoding="utf-8"))["services"])
sync_count = async_count = 0
for package_root in uigf.__path__:
    root = Path(package_root).parent
    for file in sorted(Path(package_root).rglob("_client.py")):
        module_name = ".".join(file.relative_to(root).with_suffix("").parts)
        module = importlib.import_module(module_name)
        classes = [cls for _, cls in inspect.getmembers(module, inspect.isclass) if cls.__module__ == module_name]
        assert len(classes) == 1, module_name
        if ".aio." in module_name:
            async_count += 1
        else:
            client = classes[0](endpoint="https://example.invalid")
            client.close()
            sync_count += 1

assert (sync_count, async_count) == (expected_count, expected_count), (sync_count, async_count)
print(f"Installed wheel: constructed {sync_count} synchronous clients; imported {async_count} async clients.")
