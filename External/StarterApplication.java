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

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;


public class StarterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();



    // Enable Local Datastore.
 //   Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(this, "uAGZNC52nB88M9xMSFaa89hEPQuCAn6vAozFrunJ", "XqKm1Xi6Y4apeHFbLKzW7xKxbOFJHRxNYv79cHvU");

//    ParseObject testObject = new ParseObject("NEW");
//    testObject.put("foo", "foolish");
//    testObject.put("foo2", "hi there");
//    testObject.saveInBackground();



    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
