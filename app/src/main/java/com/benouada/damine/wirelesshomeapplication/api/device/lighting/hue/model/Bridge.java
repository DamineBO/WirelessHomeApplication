package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model;

import com.benouada.damine.wirelesshomeapplication.api.util.Utils;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


// Bridge Data Store
public class Bridge {

    @SerializedName("config")
    private Config config;

    @SerializedName("lights")
    private List<LightBulb> lights;

    @SerializedName("groups")
    private List<LightGroup> groups;

    @SerializedName("scenes")
    private List<LightScene> scenes;

    @SerializedName("schedules")
    private List<LightSchedule> schedules;

    // encapsulate
    public Config config() {
        return config;
    }

    public List<LightBulb> lights() {
        return lights;
    }

    public List<LightGroup> groups() {
        return groups;
    }

    public List<LightScene> scenes() {
        return scenes;
    }

    public List<LightSchedule> getSchedules() {
        return schedules;
    }


    /**
     * helpers*
     */
    // light scene by Id
    public LightScene getSceneById(String id) {
        if (!Utils.emptyList(scenes)) {
            for (LightScene scene : scenes) {
                if (!Utils.emptyString(scene.id())
                        && scene.id().trim().equalsIgnoreCase(id.trim())) {
                    return scene;
                }
            }
        }
        return null;
    }

    // light scene by Name
    public LightScene getSceneByName(String name) {
        if (!Utils.emptyList(scenes)) {
            for (LightScene scene : scenes) {
                if (!Utils.emptyString(scene.name())
                        && scene.name().trim().contains(name.trim())) {
                    return scene;
                }
            }
        }
        return null;
    }

    // reachable light list
    public List<LightBulb> getReachableLights() {
        if (Utils.emptyList(lights)) {
            return lights;
        }
        List<LightBulb> reachableLights = new ArrayList<>();
        for (LightBulb light : lights) {
            if (light.state() != null
                    && light.state().reachable()) {
                reachableLights.add(light);
            }
        }
        return reachableLights;
    }

    // String
    @Override
    public String toString() {

        return "Bridge DataStore\n" +
                "{ name=' " + config.name() + ",\n" +
                "  ipaddress=' " + config.ipaddress() + ",\n" +
                "  nbr light=' " + lights.size() + ",\n" +
                "  nbr group=' " + groups.size() + ",\n" +
                "  nbr scene=' " + scenes.size() + ",\n" +
                "  nbr schedule=' " + schedules.size() + ",\n" +
                "}";
    }
}
