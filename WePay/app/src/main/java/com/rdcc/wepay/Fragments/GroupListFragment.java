package com.rdcc.wepay.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rdcc.wepay.Cloud.Group.Adapter;
import com.rdcc.wepay.Cloud.Group.Data;
import com.rdcc.wepay.Cloud.Group.Lab;
import com.rdcc.wepay.Cloud.Group.User;
import com.rdcc.wepay.R;

import java.util.ArrayList;
import java.util.List;

public class GroupListFragment extends Fragment{
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //TODO make ListView and Populate it
        ListView myList = (ListView) getActivity().findViewById(R.id.grouplistview);
        Lab groupLab = new Lab();
        Adapter adapter = new Adapter(getActivity(), groupLab.getDataList());
        myList.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.layout_grouplist, container, false);
    }
}
