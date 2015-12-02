package com.rdcc.wepay.Cloud.Group;


import java.util.ArrayList;

public class Lab {
    private ArrayList<Data> data;

    public Lab(){
        data = new ArrayList<Data>();

        //sample data
        data.add(new Data());
        data.add(new Data());
        data.add(new Data());
        data.add(new Data());
        data.add(new Data());
        data.add(new Data());
        data.add(new Data());
        data.add(new Data());
        data.add(new Data());
    }
    public ArrayList<Data> getDataList(){
        return data;
    }
    public void updateLab(int userID, int groupID){
        //-1 in argument means not to search by a ID category

        //TODO clear and reparse data
    }

    //private void clearDuplicates(){
        //iterate through the list and clear the duplicate groups
        //to save time, we aren't implementing this
    //}
}
