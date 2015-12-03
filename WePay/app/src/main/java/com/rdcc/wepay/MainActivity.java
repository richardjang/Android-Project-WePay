package com.rdcc.wepay;

//This class is the Split View Controller
//It will handle a;; the fragments that will show up on the Main Activity

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.widget.Button;

import com.rdcc.wepay.Cloud.Group.Data;
import com.rdcc.wepay.Cloud.User;
import com.rdcc.wepay.Fragments.FragmentCommunicator;
import com.rdcc.wepay.Fragments.GroupFragment;
import com.rdcc.wepay.Fragments.fragmentIDs;
import com.rdcc.wepay.Fragments.GroupListFragment;
import com.rdcc.wepay.Fragments.NewGroupFragment;
import com.rdcc.wepay.Fragments.SearchFragment;
import com.rdcc.wepay.Fragments.SettingsFragment;
import com.rdcc.wepay.Fragments.WelcomeFragment;

public class MainActivity extends Activity implements FragmentCommunicator, View.OnClickListener{
    String debugTag = "Main Activity";

    boolean orientPortrait;
    FragmentManager fm;

    Data dataToView; //stores a Data instance that will be used by groupView
    User userData;

    fragmentIDs win1; //keep track of what fragment is in win1
    fragmentIDs win4; //keep track of what frament is in win4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //retrieve user data from login screen activity through the bundle
        //temp for now
        userData = new User();
        dataToView = new Data();

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
            GroupListFragment glf = (GroupListFragment) fm.findFragmentByTag("P Group List Fragment");
            if(glf == null) glf = new GroupListFragment();
            ft.replace(R.id.winPort, glf, "P Group List Fragment");
            win1 = fragmentIDs.GroupList;

            Button news = (Button) findViewById(R.id.newsPort);
            news.setOnClickListener(this);

            Button add = (Button) findViewById(R.id.addPort);
            add.setOnClickListener(this);

            Button search = (Button) findViewById(R.id.searchPort);
            search.setOnClickListener(this);

            Button settings = (Button) findViewById(R.id.settingsPort);
            settings.setOnClickListener(this);
        }else {
            //orientation is landscape
            orientPortrait = false;
            setContentView(R.layout.layout_main_land);

            Button news = (Button) findViewById(R.id.newsLand);
            news.setOnClickListener(this);

            Button add = (Button) findViewById(R.id.addLand);
            add.setOnClickListener(this);

            Button search = (Button) findViewById(R.id.searchLand);
            search.setOnClickListener(this);

            Button settings = (Button) findViewById(R.id.settingsLand);
            settings.setOnClickListener(this);

            //show group list and welcome screen
            GroupListFragment glf = (GroupListFragment) fm.findFragmentByTag("L Group List Fragment");
            if(glf == null) glf = new GroupListFragment();

            WelcomeFragment wf = (WelcomeFragment) fm.findFragmentByTag("L Welcome Fragment");
            if(wf == null) wf = new WelcomeFragment();

            ft.replace(R.id.win1, glf, "L Group List Fragment");
            ft.commit();
            win1 = fragmentIDs.GroupList;

            ft = fm.beginTransaction();
            ft.replace(R.id.win4, wf, "L Welcome Fragment");
            win4 = fragmentIDs.Welcome;
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
        //We assume that the response is just to look at group view
//        switch(fragment){
//            case 1: //newgroup fragment is done and wants to open up the groupview
                fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                GroupFragment gf = new GroupFragment();
                ft.replace(R.id.winPort, gf, "P Group View Fragment");
                win1 = fragmentIDs.GroupView;
                ft.commit();
//                break;
//        }
    }
    private void landscapeResponse(int fragment, int data){
        //We assume that the response is just to look at group view
        //switch(fragment){
        //    case 1: //newgroup fragment is done and wants to open up the groupview
                fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                GroupFragment gf = new GroupFragment();
                ft.replace(R.id.win4, gf, "L Group View Fragment");
                win4 = fragmentIDs.GroupView;
                ft.commit();
        //      break;
        //}
    }

    @Override
    public void setData(Data data) {
        dataToView = data;
    }

    @Override
    public Data retrieveData() {
        return dataToView;
    }

    @Override
    public User retrieveUser() {
        return userData;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        initialize();
    }

    @Override
    public void onClick(View v) {
        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        //this is for our nav bar at the bottom
        switch(v.getId()){
            case R.id.newsLand:
                if(win1 != fragmentIDs.GroupList){
                    GroupListFragment glf = (GroupListFragment) fm.findFragmentByTag("L Group List Fragment");
                    if(glf == null) glf = new GroupListFragment();
                    ft.replace(R.id.win1, glf, "L Group List Fragment");
                    win1 = fragmentIDs.GroupList;
                }
                break;
            case R.id.newsPort:
                if(win1 != fragmentIDs.GroupList){
                    GroupListFragment glf = (GroupListFragment) fm.findFragmentByTag("P Group List Fragment");
                    if(glf == null) glf = new GroupListFragment();
                    ft.replace(R.id.winPort, glf, "P Group List Fragment");
                    win1 = fragmentIDs.GroupList;
                }
                break;
            case R.id.addLand:
                if(win4 != fragmentIDs.NewGroup){
                    NewGroupFragment ngf = (NewGroupFragment) fm.findFragmentByTag("L New Group Fragment");
                    if(ngf == null) ngf = new NewGroupFragment();
                    ft.replace(R.id.win4, ngf, "L New Group Fragment");
                    win4 = fragmentIDs.NewGroup;
                }
                break;
            case R.id.addPort:
                if(win1 != fragmentIDs.NewGroup){
                    NewGroupFragment ngf = (NewGroupFragment) fm.findFragmentByTag("P New Group Fragment");
                    if(ngf == null) ngf = new NewGroupFragment();
                    ft.replace(R.id.winPort, ngf, "P New Group Fragment");
                    win1 = fragmentIDs.NewGroup;
                }
                break;
            case R.id.searchLand:
                if(win4 != fragmentIDs.GroupSearch){
                    SearchFragment sf = (SearchFragment) fm.findFragmentByTag("L Search Fragment");
                    if(sf == null) sf = new SearchFragment();
                    ft.replace(R.id.win1, sf, "L Search Fragment");
                    win4 = fragmentIDs.GroupSearch;
                }
                break;
            case R.id.searchPort:
                if(win1 != fragmentIDs.GroupSearch){
                    SearchFragment sf = (SearchFragment) fm.findFragmentByTag("P Search Fragment");
                    if(sf == null) sf = new SearchFragment();
                    ft.replace(R.id.winPort, sf, "P Search Fragment");
                    win1 = fragmentIDs.GroupSearch;
                }
                break;
            case R.id.settingsLand:
                if(win4 != fragmentIDs.Settings){
                    SettingsFragment sf = (SettingsFragment) fm.findFragmentByTag("L Settings Fragment");
                    if(sf == null) sf = new SettingsFragment();
                    ft.replace(R.id.win4, sf, "L Settings Fragment");
                    win4 = fragmentIDs.Settings;
                }
                break;
            case R.id.settingsPort:
                if(win1 != fragmentIDs.Settings){
                    SettingsFragment sf = (SettingsFragment) fm.findFragmentByTag("P Settings Fragment");
                    if(sf == null) sf = new SettingsFragment();
                    ft.replace(R.id.winPort, sf, "P Settings Fragment");
                    win1 = fragmentIDs.Settings;
                }
                break;
            default:
                break;
        }
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        //theres no back button functionality anymore
    }
}
