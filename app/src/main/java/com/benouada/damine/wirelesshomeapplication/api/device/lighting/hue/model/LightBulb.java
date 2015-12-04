package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model;

import com.google.gson.annotations.SerializedName;

// LightBulb
public class LightBulb extends BaseModel {

    // Name
    @SerializedName("name")
    private String name;

    // Type
    @SerializedName("type")
    private String type;

    // Model
    @SerializedName("modelid")
    private String model;

    // SoftWare
    @SerializedName("swversion")
    private String swversion;

    // State
    @SerializedName("state")
    private LightState state;


    // Constructor
    public LightBulb() {
    }

    public LightBulb(String name) {
        this.name = name;
    }

    // Encapsulate Fields

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public String type() {
        return type;
    }

    public void type(String type) {
        this.type = type;
    }

    public String model() {
        return model;
    }

    public void model(String model) {
        this.model = model;
    }

    public String swversion() {
        return swversion;
    }

    public void swversion(String swversion) {
        this.swversion = swversion;
    }

    public LightState state() {
        return state;
    }

    public void state(LightState state) {
        this.state = state;
    }

    // to String
    @Override
    public String toString() {
        return "Light{" + "\nid =" + id() + "\nname =" + name + "\nmodel =" + model + "\n}";
    }
}
