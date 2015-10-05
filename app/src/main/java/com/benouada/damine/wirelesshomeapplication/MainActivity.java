package com.benouada.damine.wirelesshomeapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    // --------------------------------------*******
    GridView grid;
    List<String> listRoom;
    Button addGarage;
    // --------------------------------------*******

    //    private MenuDrawer mDrawer;
    private Toolbar toolbar;
    private Toolbar supportActionBar;

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
        for (int i = 0; i < 6; i++) {
            button.get(i).setTitle(menu.get(i));
            button.get(i).setIcon((Integer) icon.get(i));
            fab.addButton(button.get(i));
        }
        // ----------------------------Menu [end]

        listRoom = new ArrayList<String>();
        grid = (GridView) findViewById(R.id.all_room_container);

        addGarage = (Button) findViewById(R.id.garageBtn);

        addGarage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                listRoom.add("test item");
                add();
            }
        });

    }

    public void add() {
        ArrayAdapter<String> adp = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_dropdown_item_1line, listRoom);
        grid.setAdapter(adp);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub

                Toast.makeText(getBaseContext(), (CharSequence) listRoom.get(arg2),
                        Toast.LENGTH_SHORT).show();
            }
        });
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

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}