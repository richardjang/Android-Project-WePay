package com.rdcc.wepay.Fragments;

/**
 * Created by User on 12/2/2015.
 */
public enum fragmentIDs {
    Welcome(0), GroupList(1), NewGroup(2),
    GroupSearch(3), Group(5), Settings(4);
    private fragmentIDs(int id){
       this.id = id;
    }
    private int id;
    public int getID(){
        return id;
    }
}
