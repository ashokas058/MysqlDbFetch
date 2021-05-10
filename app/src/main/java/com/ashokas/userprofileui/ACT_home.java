package com.ashokas.userprofileui;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.ashokas.userprofileui.DATAMODEL.PersonDetails;
import com.ashokas.userprofileui.INTERFACE.OnMysqlTableListener;

import org.json.JSONObject;

import java.util.ArrayList;

import static com.ashokas.userprofileui.ApplicationUtility.AppUtility.getPersonDetailList;

public class ACT_home extends AppCompatActivity implements OnMysqlTableListener {
ArrayList<PersonDetails> personDetailsArrayList;
PersonDetails personDetailsOb;
TextView txtViewPersonDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
        initRcvWebData();

    }

    private void initTextView() {
        txtViewPersonDetails = findViewById(R.id.tag_mainact_person_txtvw);
    }
    void initRcvWebData() {

    }

    @Override
    public void onTableJsonOjectListReceive(ArrayList<JSONObject> tableJsonOjectList, String queryCode) {
        if(tableJsonOjectList!=null) {
            switch (queryCode) {
                case "USER_DETAILS":
                    performActionUserDetails(tableJsonOjectList);
                    break;
                case "COLLEGE_LIST":
                    performActionCollegeList();
                    break;
            }

        }
    }

    private void performActionUserDetails(ArrayList<JSONObject> tableJsonArray)  {
        try{
            personDetailsArrayList=getPersonDetailList(tableJsonArray);
            PersonDetails pDet=personDetailsArrayList.get(0);
            txtViewPersonDetails.setText(pDet.getName()+" "+pDet.getCollege()+" "+pDet.getEmail());
        }
        catch (Exception e){}

    }

    private void performActionCollegeList() {
    }
}