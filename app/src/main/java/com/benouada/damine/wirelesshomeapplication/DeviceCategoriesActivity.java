package com.benouada.damine.wirelesshomeapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Damine's on 28/10/2015.
 */
public class DeviceCategoriesActivity extends Activity implements GridItemAdapter.OnClickListener {

    GridView grid;
    List<GridItem> items = new ArrayList<>();


    private Toolbar toolbar;
    private Toolbar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // view
        grid = (GridView) findViewById(R.id.all_room_container);

        // Menu----------------------------

        items.add(new GridItem("Light", R.mipmap.r_light, R.mipmap.light, GridItem.ItemType.Light));
        // Instance of ImageAdapter Class
        grid.setAdapter(new GridItemAdapter(this, items, this));


        FloatingActionButton b0 = new FloatingActionButton(this);

        final List<FloatingActionButton> button = Arrays.asList(b0);

        ScrollView menu_container = (ScrollView) findViewById(R.id.fab_menu_container);


        // FAB_menu-----
        FloatingActionsMenu fab = new FloatingActionsMenu(this);
        menu_container.addView(fab);
        // -----FAB_menu [end]


        for (final FloatingActionButton b : button) {
            final GridItem current = items.get(button.indexOf(b));
//            b.setTitle(String.valueOf(current.name));
            b.setIcon(current.resIconId);
            b.setColorNormal(Color.parseColor("#FFFFFF"));
            b.setTag(current.type);
            fab.addButton(button.get(button.indexOf(b)));

            b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(final View v) {
                    AlertDialog dialogInputText = new AlertDialog.Builder(DeviceCategoriesActivity.this).create();
                    //dialogInputText.setTitle("Add " + String.valueOf(current.name));
                    dialogInputText.setTitle(String.valueOf(current.type));


                    View dialogView = getLayoutInflater().inflate(R.layout.dialog_input_text, null);
                    final EditText dialogTextName = (EditText) dialogView.findViewById(R.id.dialog_text_name);

                    dialogInputText.setView(dialogView);
                    dialogInputText.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            // grid type
                            GridItem.ItemType type = current.type;
                            String name = dialogTextName.getText().toString();

                            // add gridItem with correct icon
                            GridItem toBeAdded = addRoom(name, type);

                            // badge Type ++
                            ((GridItemAdapter) grid.getAdapter()).items.get(button.indexOf(b)).badge++;

                            ((GridItemAdapter) grid.getAdapter()).notifyDataSetChanged();

                            // item Type add
                            ((WirelessHomeApplication)getApplication()).roomRepository.addRoom(toBeAdded);


                            Toast.makeText(DeviceCategoriesActivity.this, grid.getChildAt(button.indexOf(b)).getTag() + " successfully created", Toast.LENGTH_LONG).show();

                        }
                    });

                    dialogInputText.show();

                }

            });
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

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
    /**
     * Add item to GridView that must contain all "rooms" or "devices" with :
     * the name (taken from the dialog inputText)
     * &
     * the icon according to the type.
     *
     * @param name gridItem name (room name).
     * @param type gridItem type (room type).
     * @return the gridItem to Be Added on the grid
     */
    public GridItem addRoom(String name, GridItem.ItemType type) {
        GridItem toBeAdded = null;
        if (type == GridItem.ItemType.Light) {
            toBeAdded = GridItem.Light(name, type);
        }
        /*else toBeAdded = GridItem.Garage(name, type);*/
        return toBeAdded;
    }


    @Override
    public void onClick(View v, GridItem item) {
        Toast.makeText(this, "Hi I'm Light", Toast.LENGTH_LONG).show();

    }
}
