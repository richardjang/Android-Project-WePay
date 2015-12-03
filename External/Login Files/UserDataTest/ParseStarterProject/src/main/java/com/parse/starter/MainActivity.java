/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.parse.ParseAnalytics;


public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.list);

//    UserandGroupDataBase ugd = new UserandGroupDataBase();
//
//    ListView myList = (ListView) findViewById(R.id.grouplistview);
//    Adapter adapter = new Adapter(this, ugd.getAllGroupIDAssociatedwithUSER(2));
//    myList.setAdapter(adapter);


//    UserandGroupDataBase ugb = new UserandGroupDataBase();
//    DataDataBase ddb = new DataDataBase();
    UserDataBase udb = new UserDataBase();
//
//    Data myData = new Data();
//    myData.setGroupID(1);
//    myData.setBitmap(1);
//    myData.setTreasurerID(2);
//    myData.setAdminID(3);
//    myData.setName("HellWorld");
//    myData.setPayHistory("No History");
//    myData.setDescription("No Description");
//    myData.setGroupFunds(0);
//
    User myUser = udb.retrieveUserfromDB(1859750654);
    Log.d("USER", " " + myUser.getID());
    Log.d("USER", " " + myUser.getName());
//    myUser.setID(2);
//    myUser.setName("Richard");
//    myUser.setBitmap(1);
//    myUser.setFunds(0);
//
//    ddb.storeGroupData(myData);
//    ddb.storeGroupData(myData);
//    ddb.storeGroupData(myData);
//    ddb.storeGroupData(myData);
//    ddb.storeGroupData(myData);
//    udb.storeDatainDB(myUser);
//    ugb.storeUserandGroupData(myUser.getID(), myData.getGroupID());
//
//    if(ugb.doesUserhaveaGroup(myUser.getID(), myData.getGroupID())){
//      Log.d("ugb", "User is part of this group");
//    }

  }
}
