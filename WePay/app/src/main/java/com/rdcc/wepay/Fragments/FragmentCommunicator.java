package com.rdcc.wepay.Fragments;

import com.rdcc.wepay.Cloud.Group.Data;
import com.rdcc.wepay.Cloud.User;

public interface FragmentCommunicator {
    public void response(int fragment, int data);
    //convention: fragment trying to say something to the main activity
    //data is what the fragment tells the main activity to do

    public Data retrieveData();
    //returns data stored by the activity

    public User retrieveUser();
}