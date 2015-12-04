package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model;

import com.google.gson.annotations.SerializedName;

// User
public class User {

    // Required
    @SerializedName("devicetype")
    private String devicetype = "Hue#android";

    // Optional,
    // If this is not provided,
    // A random key will be generated
    @SerializedName("username")
    private String username;

    public String username() {
        return username;
    }

    // Constructor
    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
