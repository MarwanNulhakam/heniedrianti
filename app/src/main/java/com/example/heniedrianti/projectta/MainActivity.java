package com.example.heniedrianti.projectta;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heniedrianti.projectta.connection.OnlineConnection;
import com.example.heniedrianti.projectta.database.DatabaseEngine;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();
        de = new DatabaseEngine(this.getApplicationContext());
        Cursor c = de.executeQuery("SELECT nip FROM person");
        if(c.getCount()!=0){
            startActivity(new Intent(MainActivity.this, menuawal.class));
            finish();
        }
    }
    public void login(View view) {
        initDB();
        Intent blogin = new Intent(MainActivity.this, menuawal.class);
        startActivity(blogin);
    }
    public void register(View view){
        Log.d("action","register");
        Intent bregister = new Intent(MainActivity.this, register.class);
//        startActivity(bregister);
    }
    private void initDB(){
        new OnlineConnection(this,"http://10.164.96.126/select.php?nip="+nipField.getText().toString()).request("0",de);
    }
    private void initVariable(){
        nipField = (EditText)findViewById(R.id.eusername);
    }
    DatabaseEngine de;
    EditText nipField;
}

