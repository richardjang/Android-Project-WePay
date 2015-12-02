package com.rdcc.wepay.Cloud.Group;


import java.util.ArrayList;

public class Lab {
    private ArrayList<Data> data;

    public Lab(){
        data = new ArrayList<Data>();
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
}
