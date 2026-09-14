import "./main.tsp";
import "@azure-tools/typespec-client-generator-core";

using Azure.ClientGenerator.Core;

// C# emits every service into one directory and Java places implementation
// clients in one package, so service names must be unique.
@@clientName(UIGF.Mihoyo.Game.Account, "GameAccountClient");
@@clientName(UIGF.Mihoyo.Game.Global.Account, "GlobalGameAccountClient");
@@clientName(UIGF.Mihoyo.Game.CN.Records, "CnGameRecordsClient");
@@clientName(UIGF.Mihoyo.Game.Global.Records, "GlobalGameRecordsClient");
@@clientName(UIGF.Mihoyo.Launcher.CN, "CnLauncherClient");
@@clientName(UIGF.Mihoyo.Launcher.Global, "GlobalLauncherClient");
@@clientName(UIGF.Mihoyo.Launcher.Sophon.CN, "CnSophonClient");
@@clientName(UIGF.Mihoyo.Launcher.Sophon.Global, "GlobalSophonClient");
@@clientName(UIGF.Mihoyo.Commerce.CN, "CommerceClient");
@@clientName(UIGF.Mihoyo.MiYouShe.Static, "MiYouSheStaticClient", "csharp");
@@clientName(UIGF.Mihoyo.SDK.Static, "SdkStaticClient", "java");
@@clientName(UIGF.Mihoyo.Uncategorized.Telemetry.Login, "LoginTelemetryClient", "csharp, java");
@@clientName(UIGF.Mihoyo.Uncategorized.Telemetry.Community, "CommunityTelemetryClient", "csharp, java");

// These emitters also share output filenames for operation groups across services.
@@clientName(UIGF.Mihoyo.Passport.SessionApi, "PassportSessionApi", "csharp, java");
@@clientName(UIGF.Mihoyo.PassportV4.SessionApi, "PassportV4SessionApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Community.UserApi, "CommunityUserApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Global.CommunityRecords.UserApi, "GlobalUserApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Account.BindingApi, "GameBindingApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Global.Account.BindingApi, "GlobalBindingApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.CN.MiYouSheAccount.BindingApi, "MiYouSheBindingApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Genshin.Record.GameRecordApi, "GenshinRecordApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Global.Records.GameRecordApi, "GlobalGameRecordApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Genshin.Announcements.AnnouncementApi, "GenshinAnnouncementApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Global.Genshin.AnnouncementApi, "GlobalAnnouncementApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Genshin.Ledger.LedgerApi, "GenshinLedgerApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Genshin.SDK.Config.ConfigApi, "GenshinSdkConfigApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Genshin.SDK.Secure.SecureApi, "GenshinSdkSecureApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Uncategorized.Telemetry.Game.UploadApi, "GameTelemetryUploadApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Uncategorized.Telemetry.SDK.UploadApi, "SdkTelemetryUploadApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Uncategorized.Telemetry.H5.BatchApi, "H5BatchApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Uncategorized.Telemetry.H5Minor.BatchApi, "H5MinorBatchApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Uncategorized.Telemetry.H5Collector.UploadApi, "H5CollectorUploadApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Uncategorized.Telemetry.Login.UploadApi, "LoginTelemetryUploadApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Uncategorized.Telemetry.Community.UploadApi, "CommunityTelemetryUploadApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Global.Genshin.LedgerApi, "GlobalGenshinLedgerApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Global.Records.ZenlessCultivationApi, "GlobalZenlessCultivationApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.CN.Events.ZenlessCultivationApi, "CnZenlessCultivationApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Global.Records.StarRailLedgerApi, "GlobalStarRailLedgerApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.CN.Events.StarRailLedgerApi, "CnStarRailLedgerApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Global.Records.ZenlessLedgerApi, "GlobalZenlessLedgerApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.CN.Events.ZenlessLedgerApi, "CnZenlessLedgerApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.Global.CommunityRecords.HonkaiImpactApi, "GlobalHonkaiImpactApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Game.CN.Records.HonkaiImpactApi, "CnHonkaiImpactApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Launcher.CN.MetadataApi, "CnLauncherMetadataApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Launcher.Global.MetadataApi, "GlobalLauncherMetadataApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Launcher.Sophon.CN.BuildApi, "CnSophonBuildApi", "csharp, java");
@@clientName(UIGF.Mihoyo.Launcher.Sophon.Global.BuildApi, "GlobalSophonBuildApi", "csharp, java");

// Python's `global` keyword cannot be used in an import statement.
@@clientNamespace(UIGF.Mihoyo.Game.Global, "uigf.mihoyo.game.overseas", "python");
@@clientNamespace(UIGF.Mihoyo.Launcher.Global, "uigf.mihoyo.launcher.overseas", "python");
@@clientNamespace(UIGF.Mihoyo.Launcher.Sophon.Global, "uigf.mihoyo.launcher.sophon.overseas", "python");

// Rust turns each namespace below the root service into a module, so a namespace
// segment that is a reserved word (`static`) or that only consists of a suffix the
// emitter strips (`PassportV4`, `PassportStatic`) cannot be emitted as written.
@@clientNamespace(UIGF.Mihoyo.PassportV4, "UIGF.Mihoyo.Passport.V4", "rust");
@@clientNamespace(UIGF.Mihoyo.PassportStatic, "UIGF.Mihoyo.Passport.StaticApi", "rust");
@@clientNamespace(UIGF.Mihoyo.SDK.Static, "UIGF.Mihoyo.SDK.StaticApi", "rust");
@@clientNamespace(UIGF.Mihoyo.MiYouShe.Static, "UIGF.Mihoyo.MiYouShe.StaticApi", "rust");
