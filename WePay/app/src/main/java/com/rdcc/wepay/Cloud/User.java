package com.rdcc.wepay.Cloud;


import com.rdcc.wepay.Cloud.Group.Bitmaps;

public class User {

    private int ID;
    private String name;
    private int bitmap;
    private double funds;
    private Bitmaps bm = new Bitmaps();

    //TODO
    int [] groupIDs;

    public User(){
        ID = 0;
        name = "User";
        funds = 0;
        bitmap = bm.conversion(4); //user icon is default profile icon
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
