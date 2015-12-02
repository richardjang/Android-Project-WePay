package com.rdcc.wepay.Cloud.Group;

import com.rdcc.wepay.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Data {
    private int bitmap;
    private String name;
    private int groupID;
    private double groupFunds;
    private String description;
    private int adminID;
    private int treasurerID;
    private String payHistory;

    //TODO private int [] contributors;

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

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayHistory() {
        return payHistory;
    }

    public void setPayHistory(String payHistory) {
        this.payHistory = payHistory;
    }

    public int getTreasurerID() {
        return treasurerID;
    }

    public void setTreasurerID(int treasurerID) {
        this.treasurerID = treasurerID;
    }

    public double getGroupFunds() {
        return groupFunds;
    }

    public void setGroupFunds(double groupFunds) {
        this.groupFunds = groupFunds;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}
