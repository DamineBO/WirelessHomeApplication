package com.benouada.damine.wirelesshomeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends ActionBarActivity {

    private long splashDelay = 1000; //5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);*/

        TimerTask task = new TimerTask()
        {

            @Override
            public void run() {
                finish();
                Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }

        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);

    }
}
