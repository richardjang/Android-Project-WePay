package com.rdcc.wepay.Cloud;

import com.rdcc.wepay.R;

/**
 * Created by User on 12/1/2015.
 */
public class User {
    private int ID;
    private int name;
    private int bitmap;
    private double funds;

    public User(){
        bitmap = R.drawable.icon;
    }

    public int getBitmap() {
        return bitmap;
    }

    public void setBitmap(int bitmap) {
        this.bitmap = bitmap;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
