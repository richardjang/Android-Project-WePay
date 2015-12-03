package com.parse.starter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Data> {
    public Adapter(Context context, ArrayList<Data> data){
        super(context, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list, parent, false);
        }

        Data data = getItem(position);
//        TextView text = (TextView) convertView.findViewById(R.id.list_item_name);
//        text.setText("Buttholes");

        return convertView;
    }
}
