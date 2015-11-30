package com.rdcc.wepay;

//Animated screen that displays our logo

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SplashScreen extends Activity{
    MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);

        bgm = MediaPlayer.create(this, R.raw.splashbgm);
        bgm.start();

        Thread timer = new Thread() {
            public void run() {
                try {
                    // run splash screen for 11.5 seconds
                    sleep(1000);// put at 1000 for testing
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    bgm.release();
                    // start activity
                    Intent myIntent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
            }
        };
        timer.start();

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        bgm.release();
        finish();
    }
}
