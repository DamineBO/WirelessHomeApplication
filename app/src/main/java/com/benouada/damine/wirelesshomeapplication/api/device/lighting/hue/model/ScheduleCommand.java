package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model;

import com.google.gson.annotations.SerializedName;

// Command Schedule
public class ScheduleCommand {

    @SerializedName("address")
    private String address;

    @SerializedName("body")
    private Object body;

    @SerializedName("method")
    private String method;

    // constructor
    public ScheduleCommand(String address, Object body, String method) {
        this.address = address;
        this.body = body;
        this.method = method;
    }

    // encapsulation
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
