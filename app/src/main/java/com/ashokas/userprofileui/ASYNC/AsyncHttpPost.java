package com.ashokas.userprofileui.ASYNC;

import android.os.AsyncTask;

import com.ashokas.userprofileui.INTERFACE.OnMysqlTableListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AsyncHttpPost extends AsyncTask<Void,Void,String> {
    String webUrl, encoded;
    StringBuilder tableDataBuilder;
    OnMysqlTableListener onMysqlTableListener;
    JSONArray jsonArray;
    int queryCode;

    public AsyncHttpPost(String webUrl, String encoded, OnMysqlTableListener onMysqlTableListener, int queryCode) {
        this.webUrl = webUrl;
        this.encoded = encoded;
        this.onMysqlTableListener = onMysqlTableListener;
        this.queryCode = queryCode;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            tableDataBuilder=new StringBuilder();
            URL url=new URL(webUrl);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            OutputStreamWriter mySqlTableWriter=new OutputStreamWriter(urlConnection.getOutputStream());
            BufferedReader mySqlTableReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            if(!encoded.isEmpty()||encoded.contains("")) {
                mySqlTableWriter.write(encoded);
                mySqlTableWriter.flush();
            }
            String json;
            while ((json=mySqlTableReader.readLine())!=null){
                tableDataBuilder.append(json+"\n");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return tableDataBuilder.toString().trim();
        }
    }

    @Override
    protected void onPostExecute(String jsonResponce) {
        super.onPostExecute(jsonResponce);
        onMysqlTableListener.onTableJsonOjectListReceive(getJsonObjectList(getJsonArray(jsonResponce)),queryCode);
    }
    private JSONArray getJsonArray(String jsonResponce){
        try {
             jsonArray=new JSONArray(jsonResponce);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        finally {
            return jsonArray;
        }
    }

    public ArrayList<JSONObject> getJsonObjectList(JSONArray jsonArray){
        ArrayList<JSONObject>  jsonObjectArrayList=new ArrayList<>();

        for (int i=0;i<jsonArray.length();i++){
            try {
                jsonObjectArrayList.add(jsonArray.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObjectArrayList;
    }
}
