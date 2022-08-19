package com.company.tracker;

import com.company.entity.Clan;

import java.sql.SQLException;

public interface ClanDao {
    void addClan(Clan clan) throws SQLException;

    void updateClan(Clan clan) throws SQLException;
}
