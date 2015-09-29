//package com.benouada.damine.wirelesshomeapplication;
//
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.Collections;
//import java.util.List;
//
///**
// * Created by Damine's on 29/07/2015.
// */
//public class NavigationDrawerRoomFragmentAdapter extends RecyclerView.Adapter<NavigationDrawerRoomFragmentAdapter.MyViewHolder> {
//
//    private LayoutInflater inflater;
//    List<ViewHolderRoomItem> data = Collections.emptyList();
//    private Context context;
//
//    public NavigationDrawerRoomFragmentAdapter(Context context, List<ViewHolderRoomItem> data){
//        this.context = context;
//        inflater = LayoutInflater.from(context);
//        this.data = data;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.navigation_drawer_custom_row, parent, false);
//        Log.d("VIVZ","onCreateHolder called ");
//        MyViewHolder holder = new MyViewHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        ViewHolderRoomItem current = data.get(position);
//        Log.d("VIVZ","onBindViewHolder called " + position);
//        holder.title.setText(current.title);
//        holder.icon.setImageResource(current.iconId);
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView title;
//        ImageView icon;
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            title = (TextView) itemView.findViewById(R.id.listText);
//            icon = (ImageView) itemView.findViewById(R.id.listIcon);
//            icon.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(context, "Item clicked at " + getPosition(), Toast.LENGTH_SHORT).show();
//        }
//    }
//}
