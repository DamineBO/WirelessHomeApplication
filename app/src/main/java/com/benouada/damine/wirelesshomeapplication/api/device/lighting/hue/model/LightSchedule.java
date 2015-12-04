package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model;

import com.google.gson.annotations.SerializedName;


// Light Schedule
public class LightSchedule extends BaseModel {

    // Name
    @SerializedName("name")
    private String name;

    // description
    @SerializedName("description")
    private String description;

    // Command
    @SerializedName("command")
    private ScheduleCommand command;

    // time (Absolute time, Randomized time, Recurring times, Recurring randomized times, Timers).
    @SerializedName("time")
    private String time;

    // starttime (UTC time that the timer was started. Only provided for timers).
    @SerializedName("starttime")
    private String starttime;

    @SerializedName("localtime")
    private String localtime;

    // status enabled (default) / disabled
    @SerializedName("status")
    private String status = "enabled";

    // autodelete (If set to true, the schedule will be removed automatically if expired,
    // if set to false it will be disabled. Default is true).
    @SerializedName("autodelete")
    private Boolean autodelete;

    // encapsulate

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public ScheduleCommand command() {
        return command;
    }

    public void command(ScheduleCommand command) {
        this.command = command;
    }

    public String description() {
        return description;
    }

    public void description(String description) {
        this.description = description;
    }

    public String time() {
        return time;
    }

    public void time(String time) {
        this.time = time;
    }

    public String localtime() {
        return localtime;
    }

    public void localtime(String localTime) {
        this.localtime = localTime;
    }

    public String starttime() {
        return starttime;
    }

    public void starttime(String starttime) {
        this.starttime = starttime;
    }

    public boolean enabled() {
        return status.equals("enabled");
    }

    public void enable(boolean enabled) {
        this.status = enabled ? "enabled" : "disabled";
    }

    public void autodelete(Boolean autodelete) {
        this.autodelete = Boolean.valueOf(autodelete);
    }

    // constructor
    public LightSchedule() {
    }

    private LightSchedule(Builder builder) {
        if (builder.name != null) this.name(builder.name);
        if (builder.description != null) this.description(builder.description);
        if (builder.command != null) this.command(builder.command);
        if (builder.localtime != null) this.localtime(builder.localtime);
        if (builder.starttime != null) this.starttime(builder.starttime);
        if (builder.status != null) this.enable(builder.status);
        if (builder.autodelete != null) this.autodelete(builder.autodelete);
    }

    // Builder
    public static class Builder {
        private String name;
        private String description;
        private ScheduleCommand command;
        private String time;
        private String localtime;
        private String starttime;
        private Boolean status;
        private Boolean autodelete;

        // name
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        // description
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        // Time
        public Builder time(String time) {
            this.time = time;
            return this;
        }

        public Builder localtime(String localtime) {
            this.localtime = localtime;
            return this;
        }

        public Builder starttime(String starttime) {
            this.starttime = starttime;
            return this;
        }

        public Builder enable(Boolean status) {
            this.status = status;
            return this;
        }

        public Builder autodelete(Boolean autodelete) {
            this.autodelete = autodelete;
            return this;
        }

        // build
        public LightSchedule build() {
            return new LightSchedule(this);
        }

    }
}
