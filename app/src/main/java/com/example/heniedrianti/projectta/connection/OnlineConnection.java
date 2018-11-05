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


    public void request(final String id, final String tableDestination, final DatabaseEngine de)    {
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
                    Log.d("OnlineConnection","OnlineConnection.request.doInBackground");
                    nameValuePairs.add(new BasicNameValuePair("id", id));
                    HttpClient httpclient = new DefaultHttpClient();
                    Log.d("OnlineConnection","accessing URL: "+url);
                    HttpPost httppost = new HttpPost(url);
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    Log.e("OnlineConnection", "pass 1 connection success ");
                } catch (Exception e) {
                    Log.e("OnlinceConnection", e.toString());
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
                    Log.d("OnlineConnection", "pass 2 connection success ");
                } catch (Exception e) {
                    Log.e("Fail 2", e.toString());
                }
                JSONObject json_data = null;
                JSONArray json_array;
                try {
                    json_data = new JSONObject(result);
                    Log.d("OnlineConnection", "Pass 3 Success, return JSON Object");
                    return json_data.toString();

                } catch (Exception e) {
                    try{
                        json_array = new JSONArray(result);
                        String res = "";
                        for(int i=0;i<json_array.length();i++){
                            json_data = json_array.getJSONObject(i);
                            res = res + json_data.toString()+"###";
//                            Log.d("JSONArray exception",json_data.toString());
                        }
                        Log.d("OnlineConnection","Success, return Json Array");
                        return res.substring(0,res.length()-3);
                    }catch(Exception ex) {
                        json_data = null;
                        Log.e("Fail 3", e.toString());
                        return "";
                    }
                }

            }

            @Override
            protected void onPostExecute(String result) {
                if(result.length()<=1){
                    Log.e("OnPostExecute","tidak ada data yang terkirim ke proses insert");
                    return;
                }
                if(de!=null) {
                    try {
                        Log.d("OnlineConnection","insert data to local db");
                        String []res = result.split("###");
//                        for(int x1=0;x1<res.length;x1++) {
//                            System.out.println(res[x1]);
//                        }
                        String []col = AllConstants.SQLiteProperties.getTableColumn(tableDestination);
                        for(int x=0;x<res.length;x++) {
                            JSONObject obj = new JSONObject(res[x]);
                            String data[] = new String[col.length];
                            for (int i = 0; i < data.length; i++) {
                                data[i] = obj.getString(col[i]);
                            }
                            de.insert(tableDestination, col, data);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.d("OnlineConnection","no database selected as local db");
                }
            }
        }

        SendPostReqAsyncTask req = new SendPostReqAsyncTask();
        req.execute();
    }
}
