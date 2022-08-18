package com.company.controller;

import com.company.entity.Clan;
import com.company.service.ClanManager;

public class ClanController {

    public synchronized void incGold(long clanId, int gold){//этот метод может вызываться до 1000 раз разными потоками
        Clan clan = ClanManager.getClan(clanId);
        int newGold = gold + clan.getGold();//добавлена возможность увеличения золота
        clan.setGold(newGold);

        clan.incGold(gold);
        ClanManager.saveClan(clanId);
    }

   public synchronized void decGold(long clanId, int gold){//метод для уменьшения количества золота
      Clan clan = ClanManager.getClan(clanId);
      int newGold = clan.getGold() - gold;
      clan.setGold(newGold);

      clan.decGold(gold);
      ClanManager.saveClan(clanId);
   }
}
