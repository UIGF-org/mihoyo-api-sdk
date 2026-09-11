import "./main.tsp";
import "@azure-tools/typespec-client-generator-core";

using Azure.ClientGenerator.Core;

// Java places implementation clients in one package, so service names must be unique.
@@clientName(UIGF.Game.Account, "GameAccountClient");
@@clientName(UIGF.Game.Global.Account, "GlobalGameAccountClient");
@@clientName(UIGF.Game.CN.Records, "CnGameRecordsClient");
@@clientName(UIGF.Game.Global.Records, "GlobalGameRecordsClient");
@@clientName(UIGF.Launcher.CN, "CnLauncherClient");
@@clientName(UIGF.Launcher.Global, "GlobalLauncherClient");
@@clientName(UIGF.Launcher.Sophon.CN, "CnSophonClient");
@@clientName(UIGF.Launcher.Sophon.Global, "GlobalSophonClient");
@@clientName(UIGF.Commerce.CN, "CommerceClient");

// These emitters also share output filenames for operation groups across services.
@@clientName(UIGF.Passport.SessionApi, "PassportSessionApi", "csharp, java");
@@clientName(UIGF.PassportV4.SessionApi, "PassportV4SessionApi", "csharp, java");
@@clientName(UIGF.Community.UserApi, "CommunityUserApi", "csharp, java");
@@clientName(UIGF.Game.Global.CommunityRecords.UserApi, "GlobalUserApi", "csharp, java");
@@clientName(UIGF.Game.Account.BindingApi, "GameBindingApi", "csharp, java");
@@clientName(UIGF.Game.Global.Account.BindingApi, "GlobalBindingApi", "csharp, java");
@@clientName(UIGF.Game.Genshin.Record.GameRecordApi, "GenshinRecordApi", "csharp, java");
@@clientName(UIGF.Game.Global.Records.GameRecordApi, "GlobalGameRecordApi", "csharp, java");
@@clientName(UIGF.Game.Genshin.Announcements.AnnouncementApi, "GenshinAnnouncementApi", "csharp, java");
@@clientName(UIGF.Game.Global.Genshin.AnnouncementApi, "GlobalAnnouncementApi", "csharp, java");
@@clientName(UIGF.Game.Genshin.Ledger.LedgerApi, "GenshinLedgerApi", "csharp, java");
@@clientName(UIGF.Game.Genshin.SDK.Config.ConfigApi, "GenshinSdkConfigApi", "csharp, java");
@@clientName(UIGF.Game.Genshin.SDK.Secure.SecureApi, "GenshinSdkSecureApi", "csharp, java");
@@clientName(UIGF.Uncategorized.Telemetry.Game.UploadApi, "GameTelemetryUploadApi", "csharp, java");
@@clientName(UIGF.Uncategorized.Telemetry.SDK.UploadApi, "SdkTelemetryUploadApi", "csharp, java");
@@clientName(UIGF.Game.Global.Genshin.LedgerApi, "GlobalGenshinLedgerApi", "csharp, java");
@@clientName(UIGF.Game.Global.Records.ZenlessCultivationApi, "GlobalZenlessCultivationApi", "csharp, java");
@@clientName(UIGF.Game.CN.Events.ZenlessCultivationApi, "CnZenlessCultivationApi", "csharp, java");
@@clientName(UIGF.Game.Global.Records.StarRailLedgerApi, "GlobalStarRailLedgerApi", "csharp, java");
@@clientName(UIGF.Game.CN.Events.StarRailLedgerApi, "CnStarRailLedgerApi", "csharp, java");
@@clientName(UIGF.Game.Global.Records.ZenlessLedgerApi, "GlobalZenlessLedgerApi", "csharp, java");
@@clientName(UIGF.Game.CN.Events.ZenlessLedgerApi, "CnZenlessLedgerApi", "csharp, java");
@@clientName(UIGF.Game.Global.CommunityRecords.HonkaiImpactApi, "GlobalHonkaiImpactApi", "csharp, java");
@@clientName(UIGF.Game.CN.Records.HonkaiImpactApi, "CnHonkaiImpactApi", "csharp, java");
@@clientName(UIGF.Launcher.CN.MetadataApi, "CnLauncherMetadataApi", "csharp, java");
@@clientName(UIGF.Launcher.Global.MetadataApi, "GlobalLauncherMetadataApi", "csharp, java");
@@clientName(UIGF.Launcher.Sophon.CN.BuildApi, "CnSophonBuildApi", "csharp, java");
@@clientName(UIGF.Launcher.Sophon.Global.BuildApi, "GlobalSophonBuildApi", "csharp, java");

// Python's `global` keyword cannot be used in an import statement.
@@clientNamespace(UIGF.Game.Global, "uigf.game.overseas", "python");
@@clientNamespace(UIGF.Launcher.Global, "uigf.launcher.overseas", "python");
@@clientNamespace(UIGF.Launcher.Sophon.Global, "uigf.launcher.sophon.overseas", "python");
