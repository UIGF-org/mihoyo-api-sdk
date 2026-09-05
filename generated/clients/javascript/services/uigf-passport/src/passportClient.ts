// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

import { PassportContext, PassportClientOptionalParams, createPassport } from "./api/index.js";
import {
  AccountTokenApiOperations,
  _getAccountTokenApiOperations,
} from "./classic/accountTokenApi/index.js";
import {
  AuthTicketApiOperations,
  _getAuthTicketApiOperations,
} from "./classic/authTicketApi/index.js";
import { CaptchaApiOperations, _getCaptchaApiOperations } from "./classic/captchaApi/index.js";
import { QrLoginApiOperations, _getQrLoginApiOperations } from "./classic/qrLoginApi/index.js";
import { SessionApiOperations, _getSessionApiOperations } from "./classic/sessionApi/index.js";
import { Pipeline } from "@azure/core-rest-pipeline";

export type { PassportClientOptionalParams } from "./api/passportContext.js";

export class PassportClient {
  private _client: PassportContext;
  /** The pipeline used by this client to make requests */
  public readonly pipeline: Pipeline;

  constructor(options: PassportClientOptionalParams = {}) {
    this._client = createPassport(options);
    this.pipeline = this._client.pipeline;
    this.accountTokenApi = _getAccountTokenApiOperations(this._client);
    this.sessionApi = _getSessionApiOperations(this._client);
    this.qrLoginApi = _getQrLoginApiOperations(this._client);
    this.captchaApi = _getCaptchaApiOperations(this._client);
    this.authTicketApi = _getAuthTicketApiOperations(this._client);
  }

  /** The operation groups for accountTokenApi */
  public readonly accountTokenApi: AccountTokenApiOperations;
  /** The operation groups for sessionApi */
  public readonly sessionApi: SessionApiOperations;
  /** The operation groups for qrLoginApi */
  public readonly qrLoginApi: QrLoginApiOperations;
  /** The operation groups for captchaApi */
  public readonly captchaApi: CaptchaApiOperations;
  /** The operation groups for authTicketApi */
  public readonly authTicketApi: AuthTicketApiOperations;
}
