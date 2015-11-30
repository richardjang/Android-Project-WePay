package com.rdcc.wepay.Fragments;

public interface FragmentCommunicator {
    public void response(int fragment, int data);
    //convention: fragment trying to say something to the main activity
    //data is what the fragment tells the main activity to do
}