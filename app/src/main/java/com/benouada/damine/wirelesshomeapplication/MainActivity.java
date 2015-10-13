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
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;

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

        //view
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // view
        grid = (GridView) findViewById(R.id.all_room_container);


// Menu----------------------------
//        final List<String> name = Arrays.asList("Bedroom", "Kitchen", "Livingroom", "Bathroom", "WC", "Garage");
//        final Integer[] icon = {R.mipmap.r_bedroom, R.mipmap.r_kitchen, R.mipmap.r_livingroom, R.mipmap.r_bathroom, R.mipmap.r_wc, R.mipmap.r_garage};
//        final Integer[] iconInGrid = {R.mipmap.bedroom, R.mipmap.kitchen, R.mipmap.livingroom, R.mipmap.bathroom, R.mipmap.wc, R.mipmap.garage};

        final List<GridItem> items = Arrays.asList(
                new GridItem("Bedroom"   , R.mipmap.r_bedroom   , R.mipmap.bedroom   , GridItem.ItemType.Bedroom    ),
                new GridItem("Kitchen"   , R.mipmap.r_kitchen   , R.mipmap.kitchen   , GridItem.ItemType.Kitchen    ),
                new GridItem("Livingroom", R.mipmap.r_livingroom, R.mipmap.livingroom, GridItem.ItemType.Livingroom ),
                new GridItem("Bathroom"  , R.mipmap.r_bathroom  , R.mipmap.bathroom  , GridItem.ItemType.Bathroom   ),
                new GridItem("WC"        , R.mipmap.r_wc        , R.mipmap.wc        , GridItem.ItemType.WC         ),
                new GridItem("Garage"    , R.mipmap.r_garage    , R.mipmap.garage    , GridItem.ItemType.Garage     ));

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



        int i = 0;
        for (final FloatingActionButton b : button) {
            final GridItem current = items.get(button.indexOf(b));
            b.setTitle(String.valueOf(current.name));
            b.setIcon(current.resIconId);
            b.setColorNormal(Color.parseColor("#FFFFFF"));
            fab.addButton(button.get(button.indexOf(b)));

            /*BadgeView badge = new BadgeView(MainActivity.this, b);
            badge.increment(i++);
            badge.show();*/

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    AlertDialog dialogInputText = new AlertDialog.Builder(MainActivity.this).create();
                    //dialogInputText.setTitle("Add " + String.valueOf(current.name));
                    dialogInputText.setTitle(String.valueOf(current.type));
                    dialogInputText.setView(getLayoutInflater().inflate(R.layout.dialog_input_text, null));
                    dialogInputText.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            /**
                             * TODO implement OK button action here
                             */

                            //Toast.makeText(MainActivity.this, "" + grid.getChildCount(), Toast.LENGTH_LONG).show();
                            //increment(current.type);
                            final TextView textViewToChange = (TextView) findViewById(R.id.badge);
                            textViewToChange.setText("2");

                            //grid.setAdapter(new GridItemAdapter(getApplicationContext(), items));
                        }
                    });

                    dialogInputText.show();

                }

            });

        }

// ----------------------------Menu [end]


        //------------------ BADGE ---------------------------
        /*View target = findViewById(R.id.all_room_container);
        BadgeView badge = new BadgeView(this, target);
        badge.setText("1");
        badge.show();*/
        //------------------ BADGE [end]----------------------

        //listRoom = new ArrayList<String>();
        listRoom = new ArrayList<GridItem>();


        // Instance of ImageAdapter Class
        grid.setAdapter(new GridItemAdapter(this, items));


        /*grid.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "" + grid.getChildCount(), Toast.LENGTH_LONG).show();

            }
        });*/


    }

//    public void add() {
//        ArrayAdapter<GridItem> adp = new ArrayAdapter<GridItem>(getBaseContext(),
//                R.layout.grid_item, listRoom);
//        grid.setAdapter(adp);
//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//                                    long arg3) {
//                // TODO Auto-generated method stub
//
//                Toast.makeText(getBaseContext(), (CharSequence) listRoom.get(arg2),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

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

    public void increment(GridItem.ItemType type) {
        GridItem gi = null;
        TextView tv;

        while (gi.type == type) {
            tv = (TextView) findViewById(R.id.badge);
            tv.setText(String.valueOf(findViewById(R.id.badge)) + 1);
        }
    }

    /**
     * Add item to GridView that must contain all "rooms" or "devices"...
     * To entre to a specific room
     public void toLivingroom(View view) {
     startActivity(new Intent(getApplicationContext(), LivingroomActivity.class));
     }*/


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

}