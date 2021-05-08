package com.ashokas.userprofileui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ashokas.userprofileui.ASYNC.AsyncRcv;
import com.ashokas.userprofileui.ASYNC.AsyncSend;
import com.ashokas.userprofileui.DATAMODEL.Person;
import com.ashokas.userprofileui.INTERFACE.IresultData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ACT_home extends AppCompatActivity implements IresultData {
ArrayList<Person> personArrayList;
Person personOb;
TextView personLongList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
        initRcvWebData();



    }

    private void initTextView() {
        personLongList = findViewById(R.id.tag_mainact_person_txtvw);
    }
    void initRcvWebData() {
        AsyncRcv asyncRcv=new AsyncRcv(this);
        asyncRcv.execute();
    }
    void sendWebData(){
        //go to AsyncSend class change the web url and Parameter ..tis data based the current parameter.
        AsyncSend asyncSend=new AsyncSend();
        asyncSend.execute("25/05201","9.00pm","27/04/36","india,Kerala,Kollam,Anchal","9048210700","Ashok");
    }
    /*This method setDataFrmWeb is implimenter using IresultData interface. you can at top implimentation.
    setDataFrmWeb() get data from AsyncRCV class . from this class/activity we send refernce(Context) of this class to AsyncRCV class using calling method initLoadWeb()
    */
    @Override
    public void setDataFrmWeb(String data) {
        Log.d("WEB",data);
        try {
            JSONArray jsonArray = new JSONArray(data);
            personArrayList=new ArrayList<>();
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                personOb=new Person(jsonObject.getString("id"),jsonObject.getString("name"), jsonObject.getString("email"),jsonObject.getString("college"));
                personArrayList.add(personOb);
            }
            Person p = personArrayList.get(0);
            personLongList.setText(p.getName() + " \t" + p.getCollege() + " \t " + p.getEmail());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}