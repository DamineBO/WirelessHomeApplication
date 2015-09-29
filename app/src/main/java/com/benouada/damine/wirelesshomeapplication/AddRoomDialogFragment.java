package com.benouada.damine.wirelesshomeapplication;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.benouada.damine.wirelesshomeapplication.rooms.Garage;

/**
 * Created by Damine's on 21/08/2015.
 */

public class AddRoomDialogFragment extends DialogFragment {

    Button okButton;
    Button cancelButton;
    EditText garageName;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_room_dialog, container, false);

        //SET TITLE
        getDialog().setTitle("Room name");

        cancelButton = (Button) v.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        okButton = (Button) v.findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRoomElement();
            }
        });

        return v;
    }

    private void addRoomElement() {
        int lastPosition = Garage.listRoomElementName.length;
        garageName = (EditText) garageName.findViewById(R.id.garageName);
        Garage.listRoomElementName[lastPosition] = garageName.getText().toString();
    }
}