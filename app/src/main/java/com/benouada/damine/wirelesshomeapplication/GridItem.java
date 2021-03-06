package com.benouada.damine.wirelesshomeapplication;

/**
 * Created by Damine's on 05/10/2015.
 */
public class GridItem {
    String name;
    int resIconId;
    int resIconInGridId;
    public ItemType type = null;
    int badge = 0;


    public enum ItemType {
        Bedroom,
        Kitchen,
        Livingroom,
        Bathroom,
        WC,
        Garage,
        Light;
    }

    public GridItem(String name, int resIconId, int resIconInGridId, ItemType type) {
        this.name = name;
        this.resIconId = resIconId;
        this.resIconInGridId = resIconInGridId;
        this.type = type;
    }


    // Rooms Constructors :
    public static GridItem Bedroom(String name, ItemType type) {

        return new GridItem(name, R.mipmap.r_bedroom, R.mipmap.bedroom, type);
    }

    public static GridItem Kitchen(String name, ItemType type) {

        return new GridItem(name, R.mipmap.r_kitchen, R.mipmap.kitchen, type);
    }

    public static GridItem Livingroom(String name, ItemType type) {

        return new GridItem(name, R.mipmap.r_livingroom, R.mipmap.livingroom, type);
    }

    public static GridItem Bathroom(String name, ItemType type) {

        return new GridItem(name, R.mipmap.r_bathroom, R.mipmap.bathroom, type);
    }

    public static GridItem WC(String name, ItemType type) {

        return new GridItem(name, R.mipmap.r_wc, R.mipmap.wc, type);
    }

    public static GridItem Garage(String name, ItemType type) {

        return new GridItem(name, R.mipmap.r_garage, R.mipmap.garage, type);
    }

    // Devices Constructors :
    public static GridItem Light(String name, ItemType type) {
        return new GridItem(name, R.mipmap.r_light, R.mipmap.light, type);
    }

}
