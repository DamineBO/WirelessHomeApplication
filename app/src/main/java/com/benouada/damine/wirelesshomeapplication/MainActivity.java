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

        // Menu----------------------------
        List<String> menu = Arrays.asList("Bedroom", "Kitchen", "Livingroom", "Bathroom", "WC", "Garage");
        List icon = Arrays.asList(R.mipmap.r_bedroom, R.mipmap.r_kitchen, R.mipmap.r_livingroom, R.mipmap.r_bathroom, R.mipmap.r_wc, R.mipmap.r_garage);

        FloatingActionButton b0 = new FloatingActionButton(this);
        FloatingActionButton b1 = new FloatingActionButton(this);
        FloatingActionButton b2 = new FloatingActionButton(this);
        FloatingActionButton b3 = new FloatingActionButton(this);
        FloatingActionButton b4 = new FloatingActionButton(this);
        FloatingActionButton b5 = new FloatingActionButton(this);

        List<FloatingActionButton> button = Arrays.asList(b0, b1, b2, b3, b4, b5);

        ScrollView menu_container = (ScrollView) findViewById(R.id.fab_menu_container);
        // FAB_menu-----
        FloatingActionsMenu fab = new FloatingActionsMenu(this);
        menu_container.addView(fab);
        // -----FAB_menu [end]
        for (int i=0 ; i<6 ;i++) {
        button.get(i).setTitle(menu.get(i));
        button.get(i).setIcon((Integer) icon.get(i));
        fab.addButton(button.get(i));


        }

        // ----------------------------Menu [end]

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