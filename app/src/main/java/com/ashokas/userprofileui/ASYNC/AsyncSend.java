package com.ashokas.userprofileui.ASYNC;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AsyncSend extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        String strName = strings[0];
        String strEmail = strings[1];
        String strCollege = strings[2];
       

        try {
            //this code was re-edited for matching DataModel-(Person) without IDE.

            String data = URLEncoder.encode("C_NAME", "UTF-8") + "=" + URLEncoder.encode(strName, "UTF-8") + "&"
                    + URLEncoder.encode("C_EMAIL", "UTF-8") + "=" + URLEncoder.encode(strEmail, "UTF-8") + "&"
                    + URLEncoder.encode("C_COLLEGE", "UTF-8") + "=" + URLEncoder.encode(strCollege, "UTF-8");
            URL url = new URL("http://k.pythonanywhere.com/phpInsert.php");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);

            OutputStreamWriter opstream = new OutputStreamWriter(conn.getOutputStream());
            opstream.write(data);
            opstream.flush();
            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            int i;
            i = reader.read();
            while (i != -1) {
                char s = (char) i;

                Log.d("mess", String.valueOf(s));
                i = reader.read();
            }
        } catch (IOException e) {
            Log.d("errorNetwork",e.getMessage());
        }
        return null;
    }
}
