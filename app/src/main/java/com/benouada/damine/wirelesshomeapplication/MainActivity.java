package com.benouada.damine.wirelesshomeapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.benouada.damine.wirelesshomeapplication.rooms.Garage;
import com.getbase.floatingactionbutton.FloatingActionButton;

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

        final FragmentManager fragmentManager = getFragmentManager();
        final AddRoomDialogFragment addRoomDialogFragment = new AddRoomDialogFragment();

        btnGarage = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.garage);
        btnGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRoomDialogFragment.show(fragmentManager, "Add Garage Name");
                new RecyclerView(MainActivity.this);
            }
        });
    }

   /*
   public void fabAddClicked(View v) {
        NavigationDrawerRoomFragment drawerFragment = (NavigationDrawerRoomFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_room_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_room_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout), toolbar);
    }
    */

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

    public static int addRoom(int i){
        switch(i){
            case R.id.garage     : i=0;
                break;
            case R.id.bedroom    : i=1;
                break;
            case R.id.kitchen    : i=2;
                break;
            case R.id.bathroom   : i=3;
                break;
            case R.id.wc         : i=4;
                break;
            case R.id.livingroom : i=5;
                break;
        }
        return i;
    }

    public void enterRoom(View v) {

        Intent myIntent = new Intent(v.getContext(), Garage.class);
        startActivityForResult(myIntent, 0);
    }
}