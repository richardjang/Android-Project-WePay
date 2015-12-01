package com.rdcc.wepay;

//This class is the Split View Controller
//It will handle a;; the fragments that will show up on the Main Activity

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.widget.Toast;

import com.rdcc.wepay.Fragments.FragmentCommunicator;
import com.rdcc.wepay.Fragments.GroupListFragment;
import com.rdcc.wepay.Fragments.SettingsFragment;
import com.rdcc.wepay.Fragments.WelcomeFragment;

public class MainActivity extends Activity implements FragmentCommunicator{
    String debugTag = "Main Activity";
    boolean orientPortrait;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //retrieve user data from login screen activity through the bundle

        //initialize
        initialize();
    }

    private void initialize(){
        //we need to put some fragments into our view
        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        //screen orientation check
        Display display = getWindowManager().getDefaultDisplay();
        int orient = display.getRotation();
        if(Surface.ROTATION_0 == orient || Surface.ROTATION_180 == orient){
            //orientation is portrait
            orientPortrait = true;
            setContentView(R.layout.layout_main_port);

            //show group list only
            GroupListFragment glf = new GroupListFragment();
            ft.replace(R.id.winPort, glf, "Group Portrait");
        }else {
            //orientation is landscape
            orientPortrait = false;
            setContentView(R.layout.layout_main_land);

            //show group list and welcome screen
            GroupListFragment glf = new GroupListFragment();
            WelcomeFragment wf = new WelcomeFragment();
            ft.replace(R.id.win1, glf, "Group List Fragment");
            ft.commit();
            ft = fm.beginTransaction();
            ft.replace(R.id.win2, wf, "Welcome Fragment");
            ft.commit();

            SettingsFragment sf = new SettingsFragment();
            ft = fm.beginTransaction();
            ft.replace(R.id.win3, sf, "Settings Fragment");
        }
        ft.commit();
    }

    @Override
    public void response(int fragment, int data) {
        if(orientPortrait){
            portraitResponse(fragment, data);
        }else{
            landscapeResponse(fragment, data);
        }
    }
    private void portraitResponse(int fragment, int data){

    }
    private void landscapeResponse(int fragment, int data){

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //TODO clean this up

        //we need to put some fragments into our view
        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        //screen orientation check
        Display display = getWindowManager().getDefaultDisplay();
        int orient = display.getRotation();
        if(Surface.ROTATION_0 == orient || Surface.ROTATION_180 == orient){
            //orientation is portrait
            orientPortrait = true;
            setContentView(R.layout.layout_main_port);

            //show group list only
            GroupListFragment glf = new GroupListFragment();
            ft.replace(R.id.winPort, glf, "Group Portrait");
        }else {
            //orientation is landscape
            orientPortrait = false;
            setContentView(R.layout.layout_main_land);

            //show group list and welcome screen
            GroupListFragment glf = new GroupListFragment();
            WelcomeFragment wf = new WelcomeFragment();
            ft.replace(R.id.win1, glf, "Group List Fragment");
            ft.commit();
            ft = fm.beginTransaction();
            ft.replace(R.id.win2, wf, "Welcome Fragment");
            ft.commit();

            SettingsFragment sf = new SettingsFragment();
            ft = fm.beginTransaction();
            ft.replace(R.id.win3, sf, "Settings Fragment");
        }
        ft.commit();
    }
}
