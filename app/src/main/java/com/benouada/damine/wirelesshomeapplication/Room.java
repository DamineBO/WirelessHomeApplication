package com.benouada.damine.wirelesshomeapplication;

import java.util.ArrayList;

/**
 * Created by Damine's on 24/08/2015.
 */
public class Room {

    RoomType type;
    String name            =  "";
    ArrayList<String> devices   =  null;


    public Room(RoomType type, String name, ArrayList<String> devices) {
        this.type = type; // name of the clicked button
        this.name = name; // the edited text in the dialog
        this.devices = devices;
    }
}
