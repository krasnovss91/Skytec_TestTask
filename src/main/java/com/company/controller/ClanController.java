package com.company.controller;

import com.company.entity.Clan;
import com.company.service.ClanManager;
import com.company.tracker.Tracker;

import javax.transaction.SystemException;

public class ClanController {

    public synchronized void incGold(long clanId, int gold) throws SystemException {//этот метод может вызываться до 1000 раз разными потоками
        Clan clan = ClanManager.getClan(clanId);
        int newGold = gold + clan.getGold();//добавлена возможность увеличения золота
        clan.setGold(newGold);

        clan.incGold(gold);
        //здесь вызвать трекер для сохранения в базу
        Tracker.trackerClanGold(clan);
        ClanManager.saveClan(clanId);
    }

   public synchronized void decGold(long clanId, int gold) throws SystemException {//метод для уменьшения количества золота
      Clan clan = ClanManager.getClan(clanId);
      int newGold = clan.getGold() - gold;
      clan.setGold(newGold);

      clan.decGold(gold);
      //и здесь
       Tracker.trackerClanGold(clan);
      ClanManager.saveClan(clanId);
   }
}
