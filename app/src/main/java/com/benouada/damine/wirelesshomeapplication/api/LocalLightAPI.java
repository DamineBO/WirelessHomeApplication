package com.benouada.damine.wirelesshomeapplication.api;

import com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model.LightBulb;
import com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model.LightState;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Damine's on 04/12/2015.
 */
public interface LocalLightAPI {
    @GET("/newdeveloper/lights")
    Call<List<LightBulb>> getLights();

    @PUT("/api/{username}/lights/{id}/state")
    Call<String> setState(@Path("username") String username, @Path("id") int id, @Body LightState lightState);
}
