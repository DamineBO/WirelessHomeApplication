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

import com.benouada.damine.wirelesshomeapplication.data.RoomRepository;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    GridView grid;
    RoomRepository roomRepository = new RoomRepository();
    List<GridItem> items = new ArrayList<>();


    private Toolbar toolbar;
    private Toolbar supportActionBar;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);

        //view
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // view
        grid = (GridView) findViewById(R.id.all_room_container);

// Menu----------------------------

        items.add(new GridItem("Bedroom", R.mipmap.r_bedroom, R.mipmap.bedroom, GridItem.ItemType.Bedroom));
        items.add(new GridItem("Kitchen", R.mipmap.r_kitchen, R.mipmap.kitchen, GridItem.ItemType.Kitchen));
        items.add(new GridItem("Livingroom", R.mipmap.r_livingroom, R.mipmap.livingroom, GridItem.ItemType.Livingroom));
        items.add(new GridItem("Bathroom", R.mipmap.r_bathroom, R.mipmap.bathroom, GridItem.ItemType.Bathroom));
        items.add(new GridItem("WC", R.mipmap.r_wc, R.mipmap.wc, GridItem.ItemType.WC));
        items.add(new GridItem("Garage", R.mipmap.r_garage, R.mipmap.garage, GridItem.ItemType.Garage));
        // Instance of ImageAdapter Class
        grid.setAdapter(new GridItemAdapter(this, items));


        FloatingActionButton b0 = new FloatingActionButton(this);
        FloatingActionButton b1 = new FloatingActionButton(this);
        FloatingActionButton b2 = new FloatingActionButton(this);
        FloatingActionButton b3 = new FloatingActionButton(this);
        FloatingActionButton b4 = new FloatingActionButton(this);
        FloatingActionButton b5 = new FloatingActionButton(this);

        final List<FloatingActionButton> button = Arrays.asList(b0, b1, b2, b3, b4, b5);

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
                    AlertDialog dialogInputText = new AlertDialog.Builder(MainActivity.this).create();
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
                            roomRepository.addRoom(toBeAdded);


                            Toast.makeText(MainActivity.this, grid.getChildAt(button.indexOf(b)).getTag() + " successfully created", Toast.LENGTH_LONG).show();

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

    /*public void increment(GridItem.ItemType type) {
        GridItem gi = null;
        TextView tv;

        while (gi.type == type) {
            tv = (TextView) findViewById(R.id.badge);
            tv.setText(String.valueOf(findViewById(R.id.badge)) + 1);
        }
    }*/

    /**
     * Add item to GridView that must contain all "rooms" or "devices" with :
     * the name (taken from the dialog inputText)
     * &
     * the icon according to the type.
     *
     * @param name gridItem name (room name).
     * @param type gridItem type (room type).
     *
     * @return the gridItem to Be Added on the grid
     *
     */
    public GridItem addRoom(String name, GridItem.ItemType type){
        GridItem toBeAdded = null;
        if (type == GridItem.ItemType.Bedroom){toBeAdded = GridItem.Bedroom(name, type);}
        else if (type == GridItem.ItemType.Kitchen){toBeAdded = GridItem.Kitchen(name, type);}
        else if (type == GridItem.ItemType.Livingroom){toBeAdded = GridItem.Livingroom(name, type);}
        else if (type == GridItem.ItemType.Bathroom){toBeAdded = GridItem.Bathroom(name, type);}
        else if (type == GridItem.ItemType.WC){toBeAdded = GridItem.WC(name, type);}
        else toBeAdded = GridItem.Garage(name, type);
        return toBeAdded;
    }

}