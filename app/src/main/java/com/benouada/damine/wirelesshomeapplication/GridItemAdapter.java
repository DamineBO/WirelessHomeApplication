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

    public interface OnClickListener {
        void onClick(View v, GridItem item);
    }

    OnClickListener mOnClickListener;

    public GridItemAdapter(Context context, List<GridItem> items, OnClickListener mOnClickListener) {
        super(context, R.layout.grid_item, items);
        this.context = context;
        this.items = items;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public GridItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    View gridItemView;

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // get layout from mobile.xml
        gridItemView = inflater.inflate(R.layout.grid_item, null);


        final GridItem current = getItem(position);
        gridItemView.setTag(current.type);

        // set image based on selected text
        ImageView imageView = (ImageView) gridItemView
                .findViewById(R.id.icon);
        imageView.setImageResource(current.resIconInGridId);

        TextView textView = (TextView) gridItemView
                .findViewById(R.id.name);
        textView.setText((current.name).toString());

        TextView textViewBagde = (TextView) gridItemView
                .findViewById(R.id.badge);
        textViewBagde.setText("" + current.badge);

        if (gridItemView.isSelected()) {
            selectedItem = current;
        }

        if (current.badge != 0) {
            textViewBagde.setVisibility(View.VISIBLE);
        }

        gridItemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnClickListener.onClick(v, current);
                    }

                }
        );

        return gridItemView;
    }

    GridItem selectedItem = null;

    public GridItem getSelectedItem() {
        return selectedItem;
    }
}
