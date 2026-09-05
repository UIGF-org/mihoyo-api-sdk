// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { logger } from "../logger.js";
import pkgJson from "@uigf/mihoyo-client/package.json" with { type: "json" };
import { Client, ClientOptions, getClient } from "@azure-rest/core-client";

export interface LauncherGlobalContext extends Client {}

/** Optional parameters for the client. */
export interface LauncherGlobalClientOptionalParams extends ClientOptions {}

export function createLauncherGlobal(
  options: LauncherGlobalClientOptionalParams = {},
): LauncherGlobalContext {
  const endpointUrl = options.endpoint ?? "https://sg-hyp-api.hoyoverse.com";
  const prefixFromOptions = options?.userAgentOptions?.userAgentPrefix;
  const userAgentInfo = `azsdk-js-mihoyo-client/${pkgJson.version}`;
  const userAgentPrefix = prefixFromOptions
    ? `${prefixFromOptions} ${userAgentInfo}`
    : `${userAgentInfo}`;
  const { apiVersion: _, ...updatedOptions } = {
    ...options,
    userAgentOptions: { userAgentPrefix },
    loggingOptions: { logger: options.loggingOptions?.logger ?? logger.info },
  };
  const clientContext = getClient(endpointUrl, undefined, updatedOptions);

  if (options.apiVersion) {
    logger.warning(
      "This client does not support client api-version, please change it at the operation level",
    );
  }
  return clientContext;
}
