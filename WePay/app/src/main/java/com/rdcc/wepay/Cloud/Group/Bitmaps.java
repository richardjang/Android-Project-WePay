package com.rdcc.wepay.Cloud.Group;

//our images are stored as ints
//we need to translate those ints into actual bitmaps
//bitmaps are png,jpg,gif that are stored in R.raw

import com.rdcc.wepay.R;

public enum Bitmaps {
    DEFAULT(0, R.drawable.icon);

    private Bitmaps(int id, int draw){
        bitID = id;
        drawable = draw;
    }
    private int bitID;
    private int drawable;
}

