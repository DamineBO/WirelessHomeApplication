package com.benouada.damine.wirelesshomeapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Damine's on 05/10/2015.
 */
public class GridItemAdapter extends BaseAdapter {
    private Context context;
    private final Integer[] icon;
    List<String> name;

    public GridItemAdapter(Context context, Integer[] icon, List<String> name) {
        this.context = context;
        this.icon = icon;
        this.name = name;
    }

    @Override
    public int getCount() {
        return icon.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null){
            gridView = new View(context);
            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.grid_item, null);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.room_item_icon);
            imageView.setImageResource(icon[position]);

            TextView textView = (TextView) gridView
                    .findViewById(R.id.room_item_name);
            textView.setText(name.get(position));

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
}
