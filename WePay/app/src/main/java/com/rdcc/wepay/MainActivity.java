package com.rdcc.wepay;

//This class is the Split View Controller
//It will handle a;; the fragments that will show up on the Main Activity

import android.app.Activity;
import android.os.Bundle;

import com.rdcc.wepay.Fragments.FragmentCommunicator;

public class MainActivity extends Activity implements FragmentCommunicator{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //retrieve user data from login screen activity through the bundle

        //initialize
    }

    @Override
    public void response(int fragment, int data) {

    }
}
