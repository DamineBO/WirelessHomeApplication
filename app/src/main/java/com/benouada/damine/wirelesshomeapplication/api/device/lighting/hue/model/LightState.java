package com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model;

import com.google.gson.annotations.SerializedName;

// Light State
public class LightState {

    // on / off
    @SerializedName("on")
    private Boolean on;

    // brightness
    // the minimum brightness 0 to its maximum brightness 255.
    @SerializedName("bri")
    private Integer bri;

    // hue
    // 0 and 65535 (red), 25500 (green) and 46920 (blue).
    @SerializedName("hue")
    private Integer hue;

    // saturation
    // the minimum saturation 0 to its maximum brightness 255.
    @SerializedName("sat")
    private Integer sat;

    // c.i.e XY between 0 and 1
    @SerializedName("xy")
    private float[] xy;

    // the warmest color 2000K is 500 mired ("ct":500)
    // and the coldest color 6500K is 153 mired ("ct":153).
    @SerializedName("ct")
    private Integer ct;

    // color mode (xy, hs, ct)
    @SerializedName("colormode")
    private String colorMode;

    // alert
    @SerializedName("alert")
    private String alert;

    // effect
    @SerializedName("effect")
    private String effect;

    // reachable
    @SerializedName("reachable")
    private Boolean reachable;

    // transitiontime
    @SerializedName("transitiontime")
    private Integer transitiontime;

    public boolean reachable() {
        return reachable;
    }

    public boolean on() {
        return on;
    }

    public void on(Boolean on) {
        this.on = on;
    }

    public Integer bri() {
        return bri;
    }

    public void bri(Integer bri) {
        this.bri = bri;
    }

    public Integer hue() {
        return hue;
    }

    public void hue(Integer hue) {
        this.hue = hue;
    }

    public Integer sat() {
        return sat;
    }

    public void sat(Integer sat) {
        this.sat = sat;
    }

    public float[] xy() {
        return xy;
    }

    public void xy(float[] xy) {
        this.xy = xy;
    }

    public Integer ct() {
        return ct;
    }

    public void ct(Integer ct) {
        this.ct = ct;
    }

    public Alert alert() {
        return Alert.fromName(alert);
    }

    public void alert(Alert alert) {
        this.alert = alert.toString();
    }

    public Effect effect() {
        return Effect.fromName(effect);
    }

    public void effect(Effect effect) {
        this.effect = effect.toString();
    }

    public ColorMode colorMode() {
        return ColorMode.fromName(colorMode);
    }

    public void colorMode(ColorMode colorMode) {
        this.colorMode = colorMode.toString();
    }

    public void transitiontime(Integer transitiontime) {
        this.transitiontime = transitiontime;
    }

    // Color Mode
    public static enum ColorMode {
        HS("hs"), XY("xy"), CT("ct");

        public final String name;

        private ColorMode(String name) {
            this.name = name;
        }

        public static ColorMode fromName(String name) {
            for (ColorMode mode : ColorMode.values()) {
                if (mode.name.equals(name)) {
                    return mode;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    // Alert
    public static enum Alert {

        // no alert.
        NONE("none"),

        //breathe cycle.
        SELECT("select"),

        //breathe cycles for 30 seconds or until the alert is set.
        LSELECT("lselect");

        private final String name;

        private Alert(String name) {
            this.name = name;
        }

        public static Alert fromName(String name) {
            for (Alert alert : Alert.values()) {
                if (alert.name.equals(name)) {
                    return alert;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Effect
    public static enum Effect {
        // no effect.
        NONE("none"),

        // cycle through all hues using the current brightness and saturation settings.
        COLORLOOP("colorloop");

        public final String name;

        private Effect(String name) {
            this.name = name;
        }

        public static Effect fromName(String name) {
            for (Effect effect : Effect.values()) {
                if (effect.name.equals(name)) {
                    return effect;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // builder
    public LightState() {
    }

    public LightState(Builder builder) {
        if (builder != null) {
            if (builder.on != null) this.on(builder.on);// default (on = true)
            if (builder.bri != null) this.bri(builder.bri);
            if (builder.hue != null) this.hue(builder.hue);
            if (builder.sat != null) this.sat(builder.sat);
            if (builder.xy != null) this.xy(builder.xy);
            if (builder.ct != null) this.ct(builder.ct);
            if (builder.alert != null) this.alert(builder.alert);
            if (builder.effect != null) this.effect(builder.effect);
            if (builder.transitiontime != null) this.transitiontime(builder.transitiontime);
        }
    }

    // Builder
    public static class Builder {
        private Boolean on = Boolean.TRUE;
        private Integer bri;
        private Integer hue;
        private Integer sat;
        private float[] xy;
        private Integer ct;
        private Alert alert;
        private Effect effect;
        private Integer transitiontime;

        public Builder on(Boolean on) {
            this.on = on;
            return this;
        }

        public Builder bri(Integer bri) {
            // validate : ("bri":0) - ("bri":65535) -- red
            if (bri > 65535) bri = 65535;
            else if (bri < 0) bri = 0;
            this.bri = bri;
            return this;
        }

        public Builder hue(Integer hue) {
            // validate : ("hue":0) - ("hue":255).
            if (hue > 255) hue = 255;
            else if (hue < 0) hue = 0;
            this.hue = hue;
            return this;
        }

        public Builder sat(Integer sat) {
            // validate : ("sat":0) - ("sat":255).
            if (sat > 255) sat = 255;
            else if (sat < 0) sat = 0;
            this.sat = sat;
            return this;
        }

        public Builder xy(float x, float y) {
            this.xy = new float[]{x, y};
            return this;
        }

        public Builder ct(Integer ct) {
            // validate : ("ct":500) - ("ct":153).
            if (ct > 500) ct = 500;
            else if (ct < 153) ct = 153;
            this.ct = ct;
            return this;
        }

        public Builder alert(Alert alert) {
            this.alert = alert;
            return this;
        }

        public Builder effect(Effect effect) {
            this.effect = effect;
            return this;
        }

        public Builder transitiontime(Integer transitiontime) {
            this.transitiontime = transitiontime;
            return this;
        }

        // builder
        public LightState build() {
            return new LightState(this);
        }

        // relax
        public Builder relax() {
            return this.bri(254).ct(467);
        }

        // energize
        public Builder energize() {
            return this.bri(203).ct(156);
        }

        // reading
        public Builder reading() {
            return this.bri(240).ct(346);
        }

        // concentrate
        public Builder concentrate() {
            return this.bri(219).ct(231);
        }

    }
}
