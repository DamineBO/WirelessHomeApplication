package com.benouada.damine.wirelesshomeapplication;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainRoomFragment extends Fragment {

    ArrayList<Room> rooms;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_room,container,false);
        GridView gridView = (GridView) view.findViewById(R.id.gridviewRooms);



        //Room room = new Room() // what should I put as parameters



        MainRoomFragmentAdapter mainRoomFragmentAdapter = new MainRoomFragmentAdapter(getActivity(), rooms);
        gridView.setAdapter(mainRoomFragmentAdapter);

        //gridView.setAdapter(new MainRoomFragmentAdapter(view.getContext())); // uses the view to get the context instead of getActivity().
        return view;
    }
}