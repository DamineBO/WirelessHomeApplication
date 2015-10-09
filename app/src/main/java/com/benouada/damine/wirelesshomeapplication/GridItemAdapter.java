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
    List<GridItem> items;
//    Integer[] icon;
//    List<String> name;

    public GridItemAdapter(Context context, List<GridItem> items) {
        this.context = context;
        this.items = items;
//        this.icon = icon;
//        this.name = name;
    }

    @Override
    public int getCount() {
        return items.size();
//    return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    View gridView;

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            gridView = new View(context);
            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.grid_item, null);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.icon);
            imageView.setImageResource(items.get(position).resIconInGridId);

            TextView textView = (TextView) gridView
                    .findViewById(R.id.name);
            textView.setText((items.get(position).type).toString());

            TextView textViewBagde = (TextView) gridView
                    .findViewById(R.id.badge);
            textViewBagde.setText("3");

        } else {
            gridView = (View) convertView;
        }
        gridView.setTag(items.get(position).type);


//        BadgeView badge = new BadgeView(parent.getContext());
//         badge.applyTo(gridView);
//        badge.increment(1);


//        return badge.container;
        return gridView;
    }
}
