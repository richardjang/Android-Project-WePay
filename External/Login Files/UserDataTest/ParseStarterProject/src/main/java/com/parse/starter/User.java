package com.parse.starter;

//package com.rdcc.wepay.Cloud;

import java.util.ArrayList;

public class User {
    private String ID;
    private String name;
    private int bitmap;
    private double funds;
    private ArrayList<Integer> usersGroups;


 //   private Bitmaps bm;


    public User(){
        ID = "";
        name = "User";
        funds = 0;
        usersGroups = new ArrayList<Integer>();
   //     bitmap = bm.conversion(4); //user icon is default profile icon
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
