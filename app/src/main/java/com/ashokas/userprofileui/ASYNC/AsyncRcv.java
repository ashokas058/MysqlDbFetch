package com.ashokas.userprofileui.ASYNC;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.ashokas.userprofileui.INTERFACE.IresultData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncRcv extends AsyncTask<Void,Void,String> {
    IresultData  iresultData;
    public AsyncRcv(Context context){
        iresultData= (IresultData) context;

    }

    @Override
    protected String doInBackground(Void... voids) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL("https://shomekerala.000webhostapp.com/phpselect.php");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String json;
            while ((json = bufferedReader.readLine()) != null) {
                Log.i("dataWEB",json);
                sb.append(json + "\n");
            }

        } catch (Exception e) {
            return null;
        }
        finally {
            return sb.toString().trim();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        iresultData.setDataFrmWeb(s);
    }
}
