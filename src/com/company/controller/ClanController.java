package com.company.controller;

import com.company.entity.Clan;
import com.company.service.ClanManager;

public class ClanController {

    public void incGold(long clanId, int gold){//этот метод может вызываться до 1000 раз разными потоками
        Clan clan = ClanManager.getClan(clanId);
        clan.incGold(gold);
    }
}
