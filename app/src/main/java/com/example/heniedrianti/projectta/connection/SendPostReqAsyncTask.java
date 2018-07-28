package com.example.heniedrianti.projectta.connection;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.example.heniedrianti.projectta.Container;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
    private String url,id;
    private InputStream is;
    String result;

    public SendPostReqAsyncTask(String url, String id){
        this.id=id;
        this.url=url;
    }

    @Override
    protected String doInBackground(String... params) {
        Container.haltGetResult();
        try {
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            Log.d("execute","OnlineConnection.request.doInBackground");
            nameValuePairs.add(new BasicNameValuePair("id", id));
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.e("pass 1", "connection success ");
        } catch (Exception e) {
            Container.interrupt();
            Log.e("Fail 1", e.toString());
        }

        try {
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(is, "iso-8859-1"), 8);
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            Log.d("pass 2", "connection success ");
        } catch (Exception e) {
            Container.interrupt();
            Log.e("Fail 2", e.toString());
        }
        JSONObject json_data;
        try {
            json_data = new JSONObject(result);
            return json_data.getString("nama");

        } catch (Exception e) {
            Container.interrupt();
            json_data = null;
            Log.e("Fail 3", e.toString());
            return "";
        }

    }

    @Override
    protected void onPostExecute(String result) {
//                Log.d("result on post execute ", result);
        Container.result = result;
        Container.allowGetResult();
    }
}