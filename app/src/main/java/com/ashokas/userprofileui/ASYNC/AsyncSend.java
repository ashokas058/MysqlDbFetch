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
        String callDate = strings[0];
        String callTime = strings[1];
        String sysDate = strings[2];
        String callGiotag = strings[3];
        String callNumber = strings[4];
        String callid = strings[5];

        try {

            String data = URLEncoder.encode("C_MOBILE", "UTF-8") + "=" + URLEncoder.encode(callNumber, "UTF-8") + "&"
                    + URLEncoder.encode("C_DATE", "UTF-8") + "=" + URLEncoder.encode(callDate, "UTF-8") + "&"
                    + URLEncoder.encode("C_TIME", "UTF-8") + "=" + URLEncoder.encode(callTime, "UTF-8") + "&" +
                    URLEncoder.encode("C_GIOTAG", "UTF-8") + "=" + URLEncoder.encode(callGiotag, "UTF-8") + "&" +
                    URLEncoder.encode("SYSDATE", "UTF-8") + "=" + URLEncoder.encode(sysDate, "UTF-8") + "&" +
                    URLEncoder.encode("C_LOGID", "UTF-8") + "=" + URLEncoder.encode(callid, "UTF-8");
            URL url = new URL("http://k.pythonanywhere.com/test-api");
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
