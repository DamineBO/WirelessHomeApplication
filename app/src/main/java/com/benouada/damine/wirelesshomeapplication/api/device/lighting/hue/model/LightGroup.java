package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Light Groupe
public class LightGroup extends BaseModel {

    // Name
    @SerializedName("name")
    private String name;

    // Type
    // Can be "LightGroup" or either "Luminiare" or "LightSource.
    // If not provided upon creation "LightGroup" is used.
    @SerializedName("type")
    private String type = "LightGroup";

    // Action
    @SerializedName("action")
    private LightState action;

    // Scene Id
    @SerializedName("scene")
    private String scene;

    // Light Ids List
    @SerializedName("lights")
    private List<String> lights;

    // encapsulate
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

    public void action(LightState action) {
        this.action = action;
    }

    public LightState action() {
        return action;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public List<String> lights() {
        return lights;
    }

    public void lights(List<String> lights) {
        this.lights = lights;
    }

    // constructor
    public LightGroup() {
    }

    public LightGroup(String id) {
        this.id(id);
    }

    public LightGroup(Builder builder) {
        if (builder != null) {
            if (builder.name != null) this.name(builder.name);
            if (builder.type != null) this.type(builder.type);
            if (builder.lights != null) this.lights(builder.lights);
        }
    }

    // Builder
    public static class Builder {
        private String name;
        private String type;
        private List<String> lights;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder lights(List<String> lights) {
            this.lights = lights;
            return this;
        }

        // build
        public LightGroup build() {
            return new LightGroup(this);
        }

    }

}
