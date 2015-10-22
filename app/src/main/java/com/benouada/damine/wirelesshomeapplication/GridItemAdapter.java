package com.benouada.damine.wirelesshomeapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Damine's on 05/10/2015.
 */
public class GridItemAdapter extends ArrayAdapter<GridItem> {
    private Context context;
    List<GridItem> items;

    public GridItemAdapter(Context context, List<GridItem> items) {
        super(context, R.layout.grid_item, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public GridItem getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    View gridItemView;

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            // get layout from mobile.xml
            gridItemView = inflater.inflate(R.layout.grid_item, null);

            // set image based on selected text
            ImageView imageView = (ImageView) gridItemView
                    .findViewById(R.id.icon);
            imageView.setImageResource(items.get(position).resIconInGridId);

            TextView textView = (TextView) gridItemView
                    .findViewById(R.id.name);
            textView.setText((items.get(position).name).toString());

            TextView textViewBagde = (TextView) gridItemView
                    .findViewById(R.id.badge);
            textViewBagde.setText("1");


        } else {
            gridItemView = (View) convertView;
        }

/*
        gridItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/

        gridItemView.setTag(items.get(position).type);


//        BadgeView badge = new BadgeView(parent.getContext());
//         badge.applyTo(gridItemView);
//        badge.increment(1);


//        return badge.container;
        return gridItemView;
    }

}
