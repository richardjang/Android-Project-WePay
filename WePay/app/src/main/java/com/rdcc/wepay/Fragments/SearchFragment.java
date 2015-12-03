package com.rdcc.wepay.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.rdcc.wepay.Cloud.Group.Adapter;
import com.rdcc.wepay.Cloud.Group.Data;
import com.rdcc.wepay.Cloud.Group.Lab;
import com.rdcc.wepay.R;

public class SearchFragment extends Fragment{
    FragmentCommunicator comm;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        comm = (FragmentCommunicator) getActivity();
        final EditText searcher = (EditText) getActivity().findViewById(R.id.searchBar);
        Button searchButt = (Button) getActivity().findViewById(R.id.searchButton);

        ListView results = (ListView) getActivity().findViewById(R.id.searchList);
        final Lab groupLab = new Lab();
        Adapter adapter = new Adapter(getActivity(), groupLab.getDataList());
        results.setAdapter(adapter);
        results.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data data = (Data) parent.getItemAtPosition(position);

                comm.setData(data);
                comm.response(0,0);
            }
        });

        searchButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupLab.updateLab((int) Float.parseFloat(searcher.getText().toString()), (int) Float.parseFloat(searcher.getText().toString()));
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.layout_searchview, container, false);
    }

}
