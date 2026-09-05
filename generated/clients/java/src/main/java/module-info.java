module uigf.checkin {
    requires transitive io.clientcore.core;

    exports uigf.checkin;
    exports uigf.passport;
    exports uigf.passportv4;
    exports uigf.community;
    exports uigf.game.account;
    exports uigf.game.genshin.record;
    exports uigf.game.genshin.gacha;
    exports uigf.game.genshin.announcements;
    exports uigf.game.genshin.login;
    exports uigf.game.genshin.ledger;
    exports uigf.game.global.account;
    exports uigf.game.global.records;
    exports uigf.game.global.genshin;
    exports uigf.game.global.communityrecords;
    exports uigf.game.cn.records;
    exports uigf.game.cn.events;
    exports uigf.game.cn.honkaiimpact;
    exports uigf.launcher.cn;
    exports uigf.launcher.global;
    exports uigf.launcher.sophon.cn;
    exports uigf.launcher.sophon.global;
    exports uigf.utility.device;
    exports uigf.utility.livestream;
    exports uigf.commerce.cn;
    exports uigf;
    exports uigf.game;
    exports uigf.launcher;
    exports uigf.commerce;

    opens uigf.passport to io.clientcore.core;
    opens uigf to io.clientcore.core;
    opens uigf.community to io.clientcore.core;
    opens uigf.game to io.clientcore.core;
    opens uigf.launcher to io.clientcore.core;
    opens uigf.commerce to io.clientcore.core;
}
