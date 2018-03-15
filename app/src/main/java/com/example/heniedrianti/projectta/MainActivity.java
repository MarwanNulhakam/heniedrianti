package com.example.heniedrianti.projectta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        Intent bregister = new Intent(MainActivity.this, register.class);
        startActivity(bregister);

    }
}

