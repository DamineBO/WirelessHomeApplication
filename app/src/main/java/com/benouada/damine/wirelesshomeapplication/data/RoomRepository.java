package com.benouada.damine.wirelesshomeapplication.data;

import com.benouada.damine.wirelesshomeapplication.GridItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damine's on 22/10/2015.
 */
public class RoomRepository {
   static List<GridItem> itemsRoom = new ArrayList<>();

    public List<GridItem> getItemsRoom() {
        return itemsRoom;
    }

    public void setItemsRoom(List<GridItem> itemsRoom) {
        this.itemsRoom = itemsRoom;
    }

    public void addRoom(GridItem gridItem){

        itemsRoom.add(gridItem);
    }
}
