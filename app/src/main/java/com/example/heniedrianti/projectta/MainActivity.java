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
        ipAddress = "10.20.30.32";
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
        finish();
    }
    public void register(View view){
        Log.d("action","register");
        Intent bregister = new Intent(MainActivity.this, register.class);
//        startActivity(bregister);
    }
    private void initDB(){
        new OnlineConnection(this,"http://"+ipAddress+"/select.php?nip="+nipField.getText().toString()).request("0","person",de);
        new OnlineConnection(this,"http://"+ipAddress+"/dynamicQuery.php?query=SELECT%20matakuliah.namamatkul,%20matakuliah.sks,%20matakuliah.semester,%20mengajar.tahunakademik,%20mengajar.kelas,%20mengajar.statusmatakuliah%20FROM%20matakuliah%20LEFT%20JOIN%20mengajar%20ON%20matakuliah.id=mengajar.idmatakuliah%20where%20mengajar.nip%20=%20%27"+nipField.getText().toString()+"%27").request("0","mengajar",de);
        new OnlineConnection(this,"http://"+ipAddress+"/dynamicQuery.php?query=SELECT%20all_data_on_table%20FROM%20skripsi%20WHERE%20pembimbingutama="+nipField.getText().toString()+"%20OR%20pembimbingpendamping="+nipField.getText().toString()+"%20OR%20pengujiutama="+nipField.getText().toString()+"%20OR%20penguji2="+nipField.getText().toString()+"%20OR%20penguji3="+nipField.getText().toString()+"").request("0","skripsi",de);
    }
    private void initVariable(){
        nipField = (EditText)findViewById(R.id.eusername);
    }
    DatabaseEngine de;
    EditText nipField;
    private String ipAddress;
}

