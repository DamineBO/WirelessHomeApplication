package com.benouada.damine.wirelesshomeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.AddFloatingActionButton;

/**
 * Created by Damine's on 28/10/2015.
 */
public class DeviceActivity extends AppCompatActivity implements GridItemAdapter.OnClickListener {

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


        AddFloatingActionButton fabAdd = (AddFloatingActionButton) findViewById(R.id.fab_add);


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
//        Toast.makeText(this, "This must take to the device interface", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DeviceInterfaceActivity.class);
        startActivity(intent);
    }
}
