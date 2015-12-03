/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;


public class StarterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(this, "uAGZNC52nB88M9xMSFaa89hEPQuCAn6vAozFrunJ", "XqKm1Xi6Y4apeHFbLKzW7xKxbOFJHRxNYv79cHvU");

//    ParseObject testObject = new ParseObject("THISWORKS");
//    testObject.put("foo", "bar");
//    testObject.saveInBackground();
//


//    testObject.put("GroupID", 1234);
//    testObject.put("Bitmap", 2345);
//    testObject.put("Name", "Chheang");
//    testObject.put("AdminID", 4567);
//    testObject.put("Description", "None");
//    testObject.put("PayHistory", "none");
//    testObject.put("TreasurerID", 2345);
//    testObject.put("GroupFunds", 9);
//    testObject.saveInBackground();
//
//    UserandGroupDataBase ugb = new UserandGroupDataBase();
//    DataDataBase ddb = new DataDataBase();
//    UserDataBase udb = new UserDataBase();
//
//    Data myData = new Data();
//    myData.setGroupID(ddb.generateUniqueGroupID());
//    myData.setBitmap(1);
//    myData.setTreasurerID(2);
//    myData.setAdminID(3);
//    myData.setName("HellWorld");
//    myData.setPayHistory("No History");
//    myData.setDescription("No Description");
//    myData.setGroupFunds(0);

//    User myUser = new User();
//    myUser.setID(udb.generateUniqueUserID());
//  //  myUser.setID(1238947);
//    myUser.setName("Richard");
//    myUser.setBitmap(1);
//    myUser.setFunds(0);
//
//   ddb.storeGroupData(myData);
//    udb.storeDatainDB(myUser);
//    ugb.storeUserandGroupData(myUser.getID(), myData.getGroupID());
//
//    if(ugb.doesUserhaveaGroup(myUser.getID(), myData.getGroupID())){
//      Log.d("ugb", "User is part of this group");
//    }



    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
