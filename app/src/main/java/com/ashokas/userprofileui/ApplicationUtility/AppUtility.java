package com.ashokas.userprofileui.ApplicationUtility;

import android.app.Application;
import android.app.Person;

import com.ashokas.userprofileui.DATAMODEL.PersonDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AppUtility extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }



    public static ArrayList<PersonDetails> getPersonDetailList(ArrayList<JSONObject> jsonObjectArrayList) throws JSONException {
        ArrayList<PersonDetails> personArrayList=new ArrayList<>();
        for (int i=0;i<jsonObjectArrayList.size();i++)
        {
            JSONObject jOb=jsonObjectArrayList.get(i);
            personArrayList.add(new PersonDetails(jOb.getString("id"),jOb.getString("name"),jOb.getString("email"),jOb.getString("college")));
        }
        return personArrayList;
    }
}
