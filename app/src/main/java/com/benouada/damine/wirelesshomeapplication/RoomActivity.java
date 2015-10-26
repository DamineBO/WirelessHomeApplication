package com.benouada.damine.wirelesshomeapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ScrollView;

import com.benouada.damine.wirelesshomeapplication.data.RoomRepository;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.Arrays;
import java.util.List;

public class RoomActivity extends AppCompatActivity {

    // --------------------------------------*******
    GridView grid;
    // --------------------------------------*******

    //    private MenuDrawer mDrawer;
    private Toolbar toolbar;
    private Toolbar supportActionBar;
    RoomRepository roomRepository = new RoomRepository();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        //view
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // view
        grid = (GridView) findViewById(R.id.all_devices_container);


// Menu----------------------------

        FloatingActionButton b0 = new FloatingActionButton(this);

        final List<FloatingActionButton> button = Arrays.asList(b0);

        ScrollView menu_container = (ScrollView) findViewById(R.id.fab_menu_devices_container);

        // FAB_menu-----
        FloatingActionsMenu fab = new FloatingActionsMenu(this);
        menu_container.addView(fab);


        // -----FAB_menu [end]

        for (final FloatingActionButton b : button) {
            final GridItem current = roomRepository.getItemsRoom().get(button.indexOf(b));

            b.setIcon(current.resIconId);
            b.setColorNormal(Color.parseColor("#FFFFFF"));
            b.setTag(current.type);
            fab.addButton(button.get(button.indexOf(b)));

            /*b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    AlertDialog dialogInputText = new AlertDialog.Builder(RoomActivity.this).create();
                    dialogInputText.setTitle(String.valueOf(current.type));
                    dialogInputText.setView(getLayoutInflater().inflate(R.layout.dialog_input_text, null));
                    dialogInputText.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            *//**//**
                             * TODO implement OK button action here
                             *//**//*
                            Toast.makeText(RoomActivity.this, "" + grid.getChildAt(button.indexOf(b)).getTag(), Toast.LENGTH_LONG).show();
                        }
                    });
                    dialogInputText.show();
                }

            });*/
        }

// ----------------------------Menu [end]

        // Instance of ImageAdapter Class

        grid.setAdapter(new GridItemAdapter(this,    roomRepository.getItemsRoomByType(getIntent().getStringExtra("type"))));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds itemsRoom to the action bar if it is present.
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

    public void itemClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}