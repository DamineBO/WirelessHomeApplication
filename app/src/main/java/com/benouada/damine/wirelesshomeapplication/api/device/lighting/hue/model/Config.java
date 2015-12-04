package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model;

import com.google.gson.annotations.SerializedName;

// Bridge Config
public class Config {

    // Id
    @SerializedName("id")
    private String id;

    // Upnp
    @SerializedName("internalipaddress")
    private String upnp;

    // Name
    @SerializedName("name")
    private String name = "philips hue";

    // Mac
    @SerializedName("mac")
    private String mac;

    // dhcp
    @SerializedName("dhcp")
    private boolean dhcp;

    // Ip
    @SerializedName("ipaddress")
    private String ipaddress;

    // Link Button
    @SerializedName("linkbutton")
    private Boolean linkbutton;

    // SoftWare
    @SerializedName("swversion")
    private String swversion;

    // Time Zone
    @SerializedName("timezone")
    private String timezone;

    // Api Version
    @SerializedName("apiversion")
    private String apiversion;

    // Constructor
    public Config() {
    }

    public Config(String upnp) {
        this.upnp = upnp;
    }

    // encapsulation
    public String upnp() {
        return upnp;
    }

    public String name() {
        return name;
    }

    public String ipaddress() {
        return ipaddress;
    }

    public String mac() {
        return mac;
    }

    public boolean linkbutton() {
        return linkbutton;
    }

    public String swversion() {
        return swversion;
    }

    public String timezone() {
        return timezone;
    }

    public String apiversion() {
        return apiversion;
    }


    // String
    @Override
    public String toString() {

        return "Bridge Config{\n" +
                " name='" + name() + '\'' +
                ", mac='" + mac() + '\'' +
                ", ipaddress='" + ipaddress() + '\'' +
                ", swversion='" + swversion() + '\'' +
                ", timezone='" + timezone() + '\'' +
                ", apiversion='" + apiversion() + '\'' +
                '}';
    }

}
