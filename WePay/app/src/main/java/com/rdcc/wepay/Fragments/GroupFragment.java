package com.rdcc.wepay.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rdcc.wepay.Cloud.Group.Data;
import com.rdcc.wepay.Cloud.User;
import com.rdcc.wepay.R;

public class GroupFragment extends Fragment implements View.OnClickListener{
    FragmentCommunicator comm;
    Data myData;
    User userData;

    //views
    Button joinGroup, addFunds, addPay, adminArea, treasurerArea, payNow;
    EditText addAmount;
    LinearLayout empty, payment, admin, treasurer;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (FragmentCommunicator) getActivity();
        myData = comm.retrieveData();
        userData = comm.retrieveUser();
        if(myData != null && userData != null){
            //TODO fill up everything from database

            ImageView img = (ImageView) getActivity().findViewById(R.id.groupIcon);
            img.setImageResource(myData.getBitmap());

            TextView groupName = (TextView) getActivity().findViewById(R.id.groupName);
            groupName.setText(myData.getName());

            TextView groupID = (TextView) getActivity().findViewById(R.id.groupID);
            groupID.setText("ID: " + myData.getGroupID());

            TextView groupFunds = (TextView) getActivity().findViewById(R.id.groupFunds);
            groupFunds.setText("Funds: " + myData.getGroupFunds());

            TextView groupDesc = (TextView) getActivity().findViewById(R.id.groupDescription);
            groupDesc.setText(myData.getDescription());

            //TODO check if user is part of group
            //if part of the group, make "Join Group" Disabled and "Add Funds" Enabled
            //if admin, make "Admin" button Enabled
            //if treasure, make "Treasurer" button Enabled

            empty = (LinearLayout) getActivity().findViewById(R.id.emptyArea);
            joinGroup = (Button) getActivity().findViewById(R.id.buttonJoin);
            joinGroup.setOnClickListener(this);

            //Add Funds Area
            payment = (LinearLayout) getActivity().findViewById(R.id.paymentArea);
            addFunds = (Button) getActivity().findViewById(R.id.buttonAddFunds);
            addFunds.setOnClickListener(this);
            addAmount = (EditText) getActivity().findViewById(R.id.addAmount);
            addPay = (Button) getActivity().findViewById(R.id.addPay);
            addPay.setOnClickListener(this);

            //Admin Area
            admin = (LinearLayout) getActivity().findViewById(R.id.adminArea);
            adminArea = (Button) getActivity().findViewById(R.id.buttonAdmin);
            adminArea.setOnClickListener(this);

            //Treasurer Area
            treasurer = (LinearLayout) getActivity().findViewById(R.id.treasurerArea);
            treasurerArea = (Button) getActivity().findViewById(R.id.buttonTreasurer);
            treasurerArea.setOnClickListener(this);
            TextView history = (TextView) getActivity().findViewById(R.id.paymentHistory);
            payNow = (Button) getActivity().findViewById(R.id.treasurerCashOut);
            payNow.setOnClickListener(this);

        }else Log.d("Group Fragment", "No Data");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.layout_groupview, container, false);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonJoin:
                //TODO User joins the group and the add funds button appears

                joinGroup.setVisibility(View.GONE);
                addFunds.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonAddFunds:
                payment.setVisibility(View.VISIBLE);
                admin.setVisibility(View.GONE);
                treasurer.setVisibility(View.GONE);
                break;
            case R.id.addPay:
                if(!addAmount.getText().toString().equals("")){
                    myData.setGroupFunds(myData.getGroupFunds() + Float.parseFloat(addAmount.getText().toString()));
                    myData.setPayHistory(myData.getPayHistory() +
                            "\nUser: " + userData.getName() + " has made a payment of: $" + addAmount.getText().toString());
                    //TODO update funds and payment history on database

                    Toast.makeText(getActivity(), "Thank you for your Payment", Toast.LENGTH_LONG).show();
                    addAmount.setText("");
                }
                break;
            case R.id.buttonAdmin:
                admin.setVisibility(View.VISIBLE);
                payment.setVisibility(View.GONE);
                treasurer.setVisibility(View.GONE);
                break;
            case R.id.buttonTreasurer:
                treasurer.setVisibility(View.VISIBLE);
                payment.setVisibility(View.GONE);
                admin.setVisibility(View.GONE);
                break;
            case R.id.treasurerCashOut:
                myData.setPayHistory(myData.getPayHistory() +
                        "\n~~~Treasurer: " + userData.getName() + " has taken funds worth: $" + myData.getGroupFunds());
                userData.setFunds(userData.getFunds() + myData.getGroupFunds());
                myData.setGroupFunds(0);

                //TODO update funds for both user and group

                Toast.makeText(getActivity(), "Funds has been transferred to your account", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
