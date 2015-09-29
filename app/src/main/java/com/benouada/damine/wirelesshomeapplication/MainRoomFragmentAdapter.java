package com.benouada.damine.wirelesshomeapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Damine's on 03/08/2015.
 */

public class MainRoomFragmentAdapter extends BaseAdapter {

    private Context mContext;
    ArrayList<Room> rooms;

    public MainRoomFragmentAdapter(Context context, ArrayList<Room> rooms) {
        mContext = context;


        this.rooms = rooms;


/*        this.listRoomIcon = listRoomIcon;
        this.listRoomName = listRoomName;*/
    }

    int[] listRoomIcon = {
            R.mipmap.r_garage,
            R.mipmap.r_bedroom,
            R.mipmap.r_kitchen,
            R.mipmap.r_bathroom,
            R.mipmap.r_wc,
            R.mipmap.r_livingroom,
    };
    String[] listRoomName = {
            "GARAGE",
            "BEDROOM",
            "KITCHEN",
            "BATHROOM",
            "WC",
            "LIVINGROOM",
    };

    public int getCount() {
        return rooms.size();
    }

    @Override
    public Room getItem(int position) {
        return rooms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //View grid;

        ViewHolderRoomItem viewHolder;


        //LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            //inflate the layout
            /*grid = new View(mContext);*/
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.main_room_custom_element, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolderRoomItem();
            viewHolder.iconId = (ImageView)convertView.findViewById(R.id.listRoomIcon);
            viewHolder.title  = (TextView) convertView.findViewById(R.id.listRoomName);

            //store the holder with the view
            convertView.setTag(viewHolder);



            /*grid = inflater.inflate(R.layout.main_room_custom_element, null);*/
            /*ImageView imageView = (ImageView) grid.findViewById(R.id.listRoomIcon);


            imageView.setImageResource(listRoomIcon[position]);
            TextView textView = (TextView) grid.findViewById(R.id.listRoomName);
            textView.setText(listRoomName[position]);*/



        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder

            viewHolder = (ViewHolderRoomItem) convertView.getTag();
        }

        // object item based on the position


        // item
        Room current = getItem(position);

        // assign values if the object is not null
        if(current != null) {
            int i = 0;
            // get the (TextView & ImageView) from the ViewHolder
            // and then set the text (item name), icon (item pic) and tag (item ID) values
            viewHolder.title.setText(current.name);
            viewHolder.iconId.setImageResource(listRoomIcon[MainActivity.addRoom(i)]); // i : position de l'icon de l'element "current" dans le tableau listRoomIcon


            viewHolder.title.setTag(current.name);
            viewHolder.iconId.setTag(current.type);
        }

        //image

        // label

        // TODO count -- badge


        return convertView;
    }

}
