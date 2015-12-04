package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Light Scene
public class LightScene extends BaseModel {

    // Name
    @SerializedName("name")
    private String name;

    // Lights
    @SerializedName("lights")
    private List<String> lights;

    // state
    @SerializedName("active")
    private Boolean active;

    // encapsulate
    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public List<String> lights() {
        return lights;
    }

    public void lights(List<String> lights) {
        this.lights = lights;
    }

    public boolean active() {
        return active;
    }

    public void active(boolean active) {
        this.active = active;
    }

    // constructor
    public LightScene() {

    }

    public LightScene(String name) {
        this.name = name;
    }

    // Constructor
    private LightScene(Builder builder) {
        if (builder != null) {
            if (builder.name != null) this.name(builder.name);
            if (builder.lights != null) this.lights(builder.lights);
        }
    }

    // Builder
    public static class Builder {
        private String name;
        private String transitiontime;
        private List<String> lights;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lights(List<String> lights) {
            this.lights = lights;
            return this;
        }

        // build
        public LightScene build() {
            return new LightScene(this);
        }

    }
}