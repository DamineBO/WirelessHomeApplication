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


    public List<GridItem> getItemsRoomByType(String type) {
        List<GridItem> rooms = new ArrayList<>();
        for(GridItem i: itemsRoom){
            if(type.equals(i.type.name())){
                rooms.add(i);
            }
        }
        return rooms;
    }

    public void setItemsRoom(List<GridItem> itemsRoom) {
        this.itemsRoom = itemsRoom;
    }

    public void addRoom(GridItem gridItem){

        itemsRoom.add(gridItem);
    }
}
