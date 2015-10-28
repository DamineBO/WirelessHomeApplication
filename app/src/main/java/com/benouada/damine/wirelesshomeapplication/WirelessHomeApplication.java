package com.benouada.damine.wirelesshomeapplication;

import android.app.Application;

import com.benouada.damine.wirelesshomeapplication.data.RoomRepository;

/**
 * Created by Damine's on 28/10/2015.
 */
public class WirelessHomeApplication extends Application {

    RoomRepository roomRepository = RoomRepository.getInstance();

}
