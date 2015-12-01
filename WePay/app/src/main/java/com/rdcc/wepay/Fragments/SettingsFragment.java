package com.rdcc.wepay.Fragments;

//User Profile::
//Name and Icon
//User ID
//Payment Methods
//Set PIN
//Sound
//Log out

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rdcc.wepay.R;

public class SettingsFragment extends Fragment{
    TextView username, userID;
    ImageView profpic;
    Button logout;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        username = (TextView) getActivity().findViewById(R.id.profileName);
        userID = (TextView) getActivity().findViewById(R.id.profileID);
        profpic = (ImageView) getActivity().findViewById(R.id.profilePic);

        //TODO use the database to find and set username, id, and picture
        logout = (Button) getActivity().findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: LOGOUT
                getActivity().finish();
            }
        });
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.layout_settings, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        super.onDetach();
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        logout = null;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
}
