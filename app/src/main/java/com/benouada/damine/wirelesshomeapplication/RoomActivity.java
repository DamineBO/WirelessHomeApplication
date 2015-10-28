package com.benouada.damine.wirelesshomeapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.AddFloatingActionButton;

public class RoomActivity extends AppCompatActivity implements GridItemAdapter.OnClickListener {

    // --------------------------------------*******
    GridView grid;
    // --------------------------------------*******

    //    private MenuDrawer mDrawer;
    private Toolbar toolbar;
    private Toolbar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        //view
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // view
        grid = (GridView) findViewById(R.id.rooms_by_type_container);


// Menu----------------------------

        //final List<FloatingActionButton> button = Arrays.asList(b0);

/*        ScrollView menu_container = (ScrollView) findViewById(R.id.fab_menu_devices_container);

        // FAB_menu-----
        FloatingActionsMenu fab = new FloatingActionsMenu(this);
        //menu_container.addView(fab);
        // -----FAB_menu [end]

        //GridItem current = roomRepository.getItemsRoom().get(roomRepository.getItemsRoom().size() - 1);
        FloatingActionButton b0 = new FloatingActionButton(this);
        b0.setIcon(R.mipmap.ic_add);
        b0.setColorNormal(Color.parseColor("#ff5090c1"));
        //b0.setTag(current.type);
        menu_container.addView(b0);
        //fab.addButton(b0);*/

        /*for (final FloatingActionButton b : button) {
            final GridItem current = roomRepository.getItemsRoom().get(button.indexOf(b));

            b.setIcon(current.resIconId);
            b.setColorNormal(Color.parseColor("#FFFFFF"));
            b.setTag(current.type);
            fab.addButton(button.get(button.indexOf(b)));

            *//*b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    AlertDialog dialogInputText = new AlertDialog.Builder(RoomActivity.this).create();
                    dialogInputText.setTitle(String.valueOf(current.type));
                    dialogInputText.setView(getLayoutInflater().inflate(R.layout.dialog_input_text, null));
                    dialogInputText.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            *//**//**//**//**
         * TODO implement OK button action here
         *//**//**//**//*
                            Toast.makeText(RoomActivity.this, "" + grid.getChildAt(button.indexOf(b)).getTag(), Toast.LENGTH_LONG).show();
                        }
                    });
                    dialogInputText.show();
                }

            });*//*
        }*/

        AddFloatingActionButton fabAdd = (AddFloatingActionButton) findViewById(R.id.fab_add);


// ----------------------------Menu [end]

        // Instance of ImageAdapter Class

        grid.setAdapter(
                new GridItemAdapter(
                        this,
                        ((WirelessHomeApplication)getApplication()).roomRepository.getItemsRoomByType(getIntent().getStringExtra("type")),
                        this
                )
        );

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

    /**
     * OnClick action of fab_add button
     *
     * @param view
     */
    public void fabAddClick(View view) {
        Toast.makeText(this, "No actions for this button yet !!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v, GridItem item) {
        Toast.makeText(this, "Teeeeeest !!!", Toast.LENGTH_LONG).show();
    }
}