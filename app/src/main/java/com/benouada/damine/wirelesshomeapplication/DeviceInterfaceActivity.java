package com.benouada.damine.wirelesshomeapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.benouada.damine.wirelesshomeapplication.api.LocalLightAPI;
import com.benouada.damine.wirelesshomeapplication.api.device.lighting.hue.model.LightState;
import com.benouada.damine.wirelesshomeapplication.api.device.lighting.util.ColorUtility;
import com.benouada.damine.wirelesshomeapplication.api.device.lighting.util.ui.ColorPickerView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class DeviceInterfaceActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Toolbar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_interface);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // Controllers
        final ColorPickerView colorPicker = (ColorPickerView) findViewById(R.id.color_picker);
        final SeekBar SaturationBar = (SeekBar) findViewById(R.id.saturation);
        final SeekBar BrightnessBar = (SeekBar) findViewById(R.id.brightness);

        // Color Change Listener
        colorPicker.setOnColorChangedListener(new ColorPickerView.OnColorChangedListener() {
            @Override
            public void colorChanged(final int color) {
                Toast.makeText(getApplicationContext(), "color: " + color, Toast.LENGTH_LONG).show();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.4/api")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                LocalLightAPI api = retrofit.create(LocalLightAPI.class);
                LightState lightState = new LightState();
                lightState.xy(ColorUtility.calculateXYFromColor(color, "LCT001"));
                Call<String> call = api.setState("newdeveloper", 1, lightState);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response, Retrofit retrofit) {
                        Toast.makeText(getApplicationContext(), "Ca va ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(), "E: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
//                Call<List<LightBulb>> call = api.getLights();
//                call.enqueue(new Callback<List<LightBulb>>() {
//                    @Override
//                    public void onResponse(Response<List<LightBulb>> response, Retrofit retrofit) {
//                        List<LightBulb> lights = response.body();
//                        if (lights != null && lights.size() != 0) {
//                            Toast.makeText(getApplicationContext(), "Ca va ", Toast.LENGTH_LONG).show();
//                            for (LightBulb light : lights) {
//                                Log.i("Hamma", "Name : " + light.name());
//                            }
//                        } else {
//                            Log.d("Hamma", "Size = 0");
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//                        Toast.makeText(getApplicationContext(), "ERREEUUUUUUUUUUUUUURRR", Toast.LENGTH_LONG).show();
//                    }
//                });

            }
        });

    }



}
