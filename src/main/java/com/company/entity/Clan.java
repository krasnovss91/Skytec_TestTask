package com.company.entity;

public class Clan {//сущность



    private long id;
    private String name;
    private int gold;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Clan(long id, String name, int gold) {
        this.id = id;
        this.name = name;
        this.gold = gold;
    }


}
