package com.benouada.damine.wirelesshomeapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    List<GridItem> listRoom;

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
        final List<String> name = Arrays.asList("Bedroom", "Kitchen", "Livingroom", "Bathroom", "WC", "Garage");
        final Integer[] icon = {R.mipmap.r_bedroom, R.mipmap.r_kitchen, R.mipmap.r_livingroom, R.mipmap.r_bathroom, R.mipmap.r_wc, R.mipmap.r_garage};
        final Integer[] iconInGrid = {R.mipmap.bedroom, R.mipmap.kitchen, R.mipmap.livingroom, R.mipmap.bathroom, R.mipmap.wc, R.mipmap.garage};

        final List<GridItem> items = Arrays.asList(
                new GridItem("Bedroom"   , R.mipmap.r_bedroom,    R.mipmap.bedroom),
                new GridItem("Kitchen"   , R.mipmap.r_kitchen,    R.mipmap.kitchen),
                new GridItem("Livingroom", R.mipmap.r_livingroom, R.mipmap.livingroom),
                new GridItem("Bathroom"  , R.mipmap.r_bathroom,   R.mipmap.bathroom),
                new GridItem("WC"        , R.mipmap.r_wc,         R.mipmap.wc),
                new GridItem("Garage"    , R.mipmap.r_garage,     R.mipmap.garage)
        );

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
        for (FloatingActionButton b : button) {
            b.setTitle(String.valueOf(items.get(button.indexOf(b)).name));
            b.setIcon(items.get(button.indexOf(b)).resIconId);
            b.setColorNormal(Color.parseColor("#FFFFFF"));
            fab.addButton(button.get(button.indexOf(b)));
            //b.setOnClickListeners();
        }

        // ----------------------------Menu [end]

        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int badgeCount = 0;
                try {
                    badgeCount = 10;
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Error input", Toast.LENGTH_SHORT).show();
                }
//                    ShortcutBadger.setBadge(getApplicationContext(), badgeCount);
                ShortcutBadger.with(getApplicationContext()).count(badgeCount);
                Toast.makeText(getApplicationContext(), "Set count=" + badgeCount, Toast.LENGTH_SHORT).show();
            }
        });*/

        //------------------ BADGE ---------------------------
        View target = findViewById(R.id.all_room_container);
        BadgeView badge = new BadgeView(this, target);
        badge.setText("1");
        badge.show();
        //------------------ BADGE [end]----------------------

        //listRoom = new ArrayList<String>();
        listRoom = new ArrayList<GridItem>();
        grid = (GridView) findViewById(R.id.all_room_container);

        // Instance of ImageAdapter Class
        grid.setAdapter(new GridItemAdapter(this, iconInGrid, name));

        //final RoomItem roomItem = new RoomItem("Room Item expl", R.drawable.garage1);

        //addGarage = (Button) findViewById(R.id.garageBtn);

        //addGarage.setOnClickListener(new View.OnClickListener() {

/*
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                listRoom.add(roomItem);
                add();
            }
        });
*/

    }

    public void add() {
        ArrayAdapter<GridItem> adp = new ArrayAdapter<GridItem>(getBaseContext(),
                R.layout.grid_item, listRoom);
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

    /**
     * Add item to GridView that must contain all "rooms" or "devices"...
     *
     * @param buttonId the clicked button.
     * @param roomItem the item that will be added.
     */
    /*public void addElement(final FloatingActionButton buttonId, GridItem roomItem) {
        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button[buttonId.indexOf]
            }
        });
    }*/

}