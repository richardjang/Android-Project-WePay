package com.rdcc.wepay.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rdcc.wepay.Cloud.Group.Data;
import com.rdcc.wepay.Cloud.User;
import com.rdcc.wepay.R;

public class GroupFragment extends Fragment implements View.OnClickListener{
    FragmentCommunicator comm;
    Data myData;
    User userData;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (FragmentCommunicator) getActivity();
        myData = comm.retrieveData();
        userData = comm.retrieveUser();
        if(myData != null && userData != null){
            ImageView img = (ImageView) getActivity().findViewById(R.id.groupIcon);
            img.setImageResource(myData.getBitmap());

            TextView groupName = (TextView) getActivity().findViewById(R.id.groupName);
            groupName.setText(myData.getName());

            TextView groupID = (TextView) getActivity().findViewById(R.id.groupID);
            groupID.setText("ID: " + myData.getGroupID());

            TextView groupFunds = (TextView) getActivity().findViewById(R.id.groupFunds);
            groupFunds.setText("Funds: " + myData.getGroupFunds());

            TextView groupDesc = (TextView) getActivity().findViewById(R.id.groupDescription);
            groupDesc.setText("Funds: " + myData.getDescription());

            //TODO check if user is part of group
            //if part of the group, make "Join Group" Disabled and "Add Funds" Enabled
            //if admin, make "Admin" button Enabled
            //if treasure, make "Treasurer" button Enabled

        }else Log.d("Group Fragment", "No Data");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.layout_groupview, container, false);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            default:
                break;
        }
    }
}
