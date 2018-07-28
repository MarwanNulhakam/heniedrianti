package com.example.heniedrianti.projectta.connection;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.heniedrianti.projectta.MainActivity;
import com.example.heniedrianti.projectta.database.DatabaseEngine;
import com.example.heniedrianti.projectta.variable.AllConstants;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OnlineConnection {
    private String url,result;
    private InputStream is;
    private Activity activity;

    public OnlineConnection(Activity activity, String url){
        this.url = url;
        this.activity = activity;
    }


    public void request(final String id, final DatabaseEngine de)    {
        Log.d("execute","OnlineConnection.request");
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        nameValuePairs.add(new BasicNameValuePair("id",id));

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            private String results;
            private void setResult(String value){
                results=value;
            }
            public String getResult(){
                return results;
            }

            @Override
            protected String doInBackground(String... params) {

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
                    Log.e("Fail 2", e.toString());
                }
                JSONObject json_data = null;
                JSONArray json_array;
                try {
                    json_data = new JSONObject(result);
                    Log.d("result ", json_data.toString());
                    return json_data.toString();

                } catch (Exception e) {
                    try{
                        json_array = new JSONArray(result);
                        for(int i=0;i<json_array.length();i++){
                            json_data = json_array.getJSONObject(i);
                            Log.d("JSONArray exception",json_data.toString());
                        }
                        return json_data.toString();
                    }catch(Exception ex) {
                        json_data = null;
                        Log.e("Fail 3", e.toString());
                        return "";
                    }
                }

            }

            @Override
            protected void onPostExecute(String result) {
                Log.d("connection result",result);
                try {
                    JSONObject obj = new JSONObject(result);
                    String data[] = new String[AllConstants.SQLiteProperties.dosenColumn.length];
                    for(int i=0;i<data.length;i++){
                        data[i]=obj.getString(AllConstants.SQLiteProperties.dosenColumn[i]);
                    }
                    de.insert("person",AllConstants.SQLiteProperties.dosenColumn,data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        SendPostReqAsyncTask req = new SendPostReqAsyncTask();
        req.execute();
    }
}
