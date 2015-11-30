package com.rdcc.wepay.Cloud.Group;

//TODO: Follow lecture slides on fragments
//TODO: We need ALL event data classes to be created in a way that our fragment can work with it

import java.util.UUID;

public class Data {
    private UUID mID;
    private String mTitle;
    private int mIcon;
    private String mDescription;
    private int mCoverPhoto;
//TODO: convert ints to bitmaps
//TODO: add data for event date and location, contributors, comments etc

//All our getters and setters::
    public int getmIcon() {
        return mIcon;
    }
    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }
    public int getmCoverPhoto() {
        return mCoverPhoto;
    }
    public void setmCoverPhoto(int mCoverPhoto) {
        this.mCoverPhoto = mCoverPhoto;
    }
    public String getmDescription() {
        return mDescription;
    }
    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
    public UUID getmID() {
        return mID;
    }
    public void setmID(UUID mID) {
        this.mID = mID;
    }
    public String getmTitle() {
        return mTitle;
    }
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
