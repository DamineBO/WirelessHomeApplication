package com.benouada.damine.wirelesshomeapplication;

/**
 * Created by Damine's on 05/10/2015.
 */
public class GridItem {
    String  name;
    int     resIconId;
    int     resIconInGridId;

    public GridItem(String name, int resIconId, int resIconInGridId) {
        this.name = name;
        this.resIconId = resIconId;
        this.resIconInGridId = resIconInGridId;
    }
/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIcon() {
        return resIconId;
    }

    public void setIcon(Integer icon) {
        this.resIconId = resIconId;
    }*/
}
