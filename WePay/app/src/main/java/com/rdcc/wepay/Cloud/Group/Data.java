package com.rdcc.wepay.Cloud.Group;

import com.rdcc.wepay.R;

import java.util.Date;
import java.util.UUID;

public class Data {
    public int bitmap;
    public String name;

    public Data(){
        bitmap = R.drawable.icon;
        name = "Ballsacks";
    }

    public int getBitmap() {
        return bitmap;
    }

    public void setBitmap(int bitmap) {
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
