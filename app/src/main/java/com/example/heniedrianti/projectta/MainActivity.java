package com.example.heniedrianti.projectta;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.heniedrianti.projectta.connection.OnlineConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view) {
        Intent blogin = new Intent(MainActivity.this, menuawal.class);
        startActivity(blogin);

    }
    public void register(View view){
        Log.d("action","register");
        Intent bregister = new Intent(MainActivity.this, register.class);
        new OnlineConnection(this,"http://10.20.30.6/select.php").request("0",this);
//        startActivity(bregister);

    }
}

