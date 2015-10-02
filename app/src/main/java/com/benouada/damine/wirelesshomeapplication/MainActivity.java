package com.benouada.damine.wirelesshomeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    static FloatingActionButton btnGarage;


    //    private MenuDrawer mDrawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // menu
        List<String> menu = Arrays.asList("Garage", "Kitchen", "Bedroom");
        ScrollView menu_container = (ScrollView) findViewById(R.id.fab_menu_container);
        FloatingActionsMenu fab = new FloatingActionsMenu(this);

        FloatingActionButton b1 = new FloatingActionButton(this);
        b1.setTitle(menu.get(0));
        b1.setIcon(R.mipmap.r_garage);
        fab.addButton(b1);

        menu_container.addView(fab);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toLivingroom(View view) {
        startActivity(new Intent(getApplicationContext(), LivingroomActivity.class));
    }

}