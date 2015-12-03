package com.parse.starter;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Cann on 12/2/2015.
 */
public class UserandGroupDataBase {


    /*
    ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");

// Retrieve the object by id
query.getInBackground("xWMyZ4YEGZ", new GetCallback<ParseObject>() {
  public void done(ParseObject gameScore, ParseException e) {
    if (e == null) {
      // Now let's update it with some new data. In this case, only cheatMode and score
      // will get sent to the Parse Cloud. playerName hasn't changed.
      gameScore.put("score", 1338);
      gameScore.put("cheatMode", true);
      gameScore.saveInBackground();
    }
  }
});
     */
    public void updateFundsviaUserID(User user, final Double funds) { //this function will update the funds associated with a user ID


        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserFundInfo");

        // Retrieve the object by id which in our case is the userID
        query.getInBackground(user.getID(), new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    object.put("Funds", funds);
                    object.saveInBackground();
                }
            }
        });


    }

    public void updateFundsviaGroupID(Data group, final Double funds) { //this function will update the funds associated with a group ID

        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserFundInfo");

        // Retrieve the object by id which in our case is the userID
        query.getInBackground(group.getGroupID(), new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {

                    object.put("GroupFunds", funds);
                    object.saveInBackground();
                }
            }
        });


    }

    public void updatePaymentHistoryViaGroupID(Data group, final String paymentHistory) {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("PayHistory");

        // Retrieve the object by id which in our case is the GroupID
        query.getInBackground(group.getGroupID(), new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {

                    object.put("PayHistory", paymentHistory);
                    object.saveInBackground();
                }
            }
        });



    }


    public void storeUserandGroupData(int UserID, int GroupID) { //this will associate a user with a group.
        ParseObject testObject = new ParseObject("UserandGroupID");

        testObject.put("UserID", UserID);
        testObject.put("GroupID", GroupID);

        testObject.saveInBackground();

    }


    private class userHasaGroup {
        boolean hasAGroup = false;
    }


    public boolean doesUserhaveaGroup(final int GroupID, int UserID) { //checking if USERID has a GroupID associated with it
        final userHasaGroup hasaGroup = new userHasaGroup();


        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserandGroupID");
        query.whereEqualTo("UserID", UserID);
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, com.parse.ParseException e) {
                if (object != null) {   //if we're able to find the user ID

                    int groupIDfound = object.getInt("GroupID"); //the group ID associated with the user

                    if (groupIDfound == GroupID) { //the user is associated with this group
                        hasaGroup.hasAGroup = true;
                    } else { //the user is not associated with this group.
                        hasaGroup.hasAGroup = false;
                    }


                }
            }
        });


        return hasaGroup.hasAGroup;
    }


    class Holder<T> {
        private ArrayList<T> value;

        Holder(ArrayList<T> value) {
            setValue(value);
        }

        ArrayList<T> getValue() {
            return value;
        }

        void setValue(ArrayList<T> value) {
            this.value = value;
        }
    }

    public ArrayList<Data> getAllGroupIDAssociatedwithUSER(int UserID) { //this function will retrieve all group IDs associated with the user ID passedin

        final Holder<Data> holder = new Holder<Data>(new ArrayList<Data>());

        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserGroupFundsInfo");
        query.whereEqualTo("GroupID", 1);//looking for a value under UserID equal to userID
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for (Iterator<ParseObject> iter = objects.iterator(); iter.hasNext(); ) {
                        ParseObject object = iter.next();
                        Data data = new Data();
                        data.setBitmap(object.getInt("Bitmap"));
                        data.setName(object.getString("Name"));
                        Log.d("YES", "" + data.getName());
                        data.setAdminID(object.getInt("AdminID"));
                        data.setDescription(object.getString("Description"));
                        data.setGroupID(object.getString("GroupID"));
                        data.setGroupFunds(object.getDouble("GroupFunds"));
                        data.setPayHistory(object.getString("PayHistory"));
                        data.setTreasurerID(object.getInt("TreasureID"));
                        data.setAdminID(object.getInt("AdminID"));
                        ArrayList<Data> list = holder.getValue();
                        list.add(data);
                        holder.setValue(list);
                    }
                } else {
                    //failed
                }
                Log.d("YES", holder.getValue().get(0).getName());
            }
        });
        Log.d("YES", holder.getValue().get(0).getName());
        return holder.getValue();
    }

}
