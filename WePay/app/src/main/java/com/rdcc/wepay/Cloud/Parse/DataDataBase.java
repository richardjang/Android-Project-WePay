package com.rdcc.wepay.Cloud.Parse;

import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.rdcc.wepay.Cloud.Group.Data;

import java.util.Random;

public class DataDataBase {
    final static String database1 = "UserGroupFundsInfo";
    final static String database2 = "UserandGroupID";
    final static String database3 = "UserFundInfo";
    final static String objID = "objectID";

    public void storeGroupData(Data data) { //storing everything in the group data
        ParseObject testObject = new ParseObject(database1);

        testObject.put("Bitmap", data.getBitmap());
        testObject.put("Name", data.getName());
        testObject.put("AdminID", data.getAdminID());
        testObject.put("Description", data.getDescription());
        testObject.put("PayHistory", data.getPayHistory());
        testObject.put("TreasurerID", data.getTreasurerID());
        testObject.put("GroupFunds", data.getGroupFunds());
        testObject.saveInBackground();
    }

    public Data retrieveGroupDatabyGroupID(String GroupID) { //This function will retrieve
        Data data = new Data();

        ParseQuery<ParseObject> query = ParseQuery.getQuery(database1);
        query.whereEqualTo(objID, GroupID);
        try {
            ParseObject object = query.getFirst();
            data.setBitmap(object.getInt("Bitmap"));
            data.setName(object.getString("Name"));
            data.setAdminID(object.getInt("AdminID"));
            data.setDescription(object.getString("Description"));
            data.setGroupID(object.getObjectId());
            data.setGroupFunds(object.getDouble("GroupFunds"));
            data.setPayHistory(object.getString("PayHistory"));
            data.setTreasurerID(object.getInt("TreasureID"));
            data.setAdminID(object.getInt("AdminID"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}

//
//public class DataDataBase {
//
//
////    private class finish {
////        private boolean fin = false;
////
////        public boolean isFin() {
////            return fin;
////        }
////
////        public void setFin(boolean fin) {
////            this.fin = fin;
////        }
////    }
//
//
//
//    public int generateUniqueGroupID() {//this function will generate a unique group ID not already exisiting in the database
//
////        final finish fin = new finish();
//
//
//        Random r = new Random();
//        int randomGroupID = 0;
////
////        while (!fin.isFin()) {
//            randomGroupID = r.nextInt();
////
////            //Checking to see if we can find it in Table 3
////            ParseQuery<ParseObject> query = ParseQuery.getQuery("UserGroupInfo");
////            query.whereEqualTo("GroupID", randomGroupID); //Under the "Email" column in the database, we will see if what the email the user entered exists
////            query.getFirstInBackground(new GetCallback<ParseObject>() {
////                public void done(ParseObject object, com.parse.ParseException e) {
////                    if (object == null) {   //if group id does not exist then we can use it
////                        fin.setFin(true);
////
////
////                    } else {
////                        fin.setFin(false);
////
////                    }
////                }
////            });
////
////        }
//
//        return randomGroupID;
//    }
//
//
//    /*
//
////    ParseObject testObject = new ParseObject("teststsetest");
////    testObject.put("foo", "bar");
////    testObject.saveInBackground();
//     */
//
//
//    public void storeGroupData(Data data) { //storing everything in the group data
//        ParseObject testObject = new ParseObject("UserGroupFundsInfo");
//
//        testObject.put("GroupID", data.getGroupID());
//        testObject.put("Bitmap", data.getBitmap());
//        testObject.put("Name", data.getName());
//        testObject.put("AdminID", data.getAdminID());
//        testObject.put("Description", data.getDescription());
//        testObject.put("PayHistory", data.getPayHistory());
//        testObject.put("TreasurerID", data.getTreasurerID());
//        testObject.put("GroupFunds", data.getGroupFunds());
//        testObject.saveInBackground();
//
//    }
//
//    public Data retrieveGroupDatabyGroupID(int GroupID) { //This function will retrieve
//        final Data data = new Data();
//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserGroupFundsInfo");
//        query.whereEqualTo("GroupID", GroupID);
//        query.getFirstInBackground(new GetCallback<ParseObject>() {
//            public void done(ParseObject object, com.parse.ParseException e) {
//                if (object == null) { //check if id exists
//                    //id does not exist
//
//                } else {
//                    //id does exist
//                    //user1.setID(object.getInt("UserID"));
//                    data.setBitmap(object.getInt("Bitmap"));
//                    data.setName(object.getString("Name"));
//                    data.setAdminID(object.getInt("AdminID"));
//                    data.setDescription(object.getString("Description"));
//                    data.setGroupID(object.getInt("GroupID"));
//                    data.setGroupFunds(object.getDouble("GroupFunds"));
//                    data.setPayHistory(object.getString("PayHistory"));
//                    data.setTreasurerID(object.getInt("TreasureID"));
//                    data.setAdminID(object.getInt("AdminID"));
//
//
//                }
//            }
//        });
//
//
//        return data;
//    }
//
//    public Data retrieveGroupDatabyUserID(int UserID) { //This function will retrieve
//        final Data data = new Data();
//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserGroupFundsInfo");
//        query.whereEqualTo("GroupID", UserID);
//        query.getFirstInBackground(new GetCallback<ParseObject>() {
//            public void done(ParseObject object, com.parse.ParseException e) {
//                if (object == null) { //check if id exists
//                    //id does not exist
//
//                } else {
//                    //id does exist
//                    //user1.setID(object.getInt("UserID"));
//                    data.setBitmap(object.getInt("Bitmap"));
//                    data.setName(object.getString("Name"));
//                    data.setAdminID(object.getInt("AdminID"));
//                    data.setDescription(object.getString("Description"));
//                    data.setGroupID(object.getInt("GroupID"));
//                    data.setGroupFunds(object.getDouble("GroupFunds"));
//                    data.setPayHistory(object.getString("PayHistory"));
//                    data.setTreasurerID(object.getInt("TreasureID"));
//                    data.setAdminID(object.getInt("AdminID"));
//
//
//                }
//            }
//        });
//
//
//        return data;
//    }
//
//
//
//
//}
