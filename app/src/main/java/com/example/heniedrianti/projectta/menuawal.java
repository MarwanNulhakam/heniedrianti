package com.example.heniedrianti.projectta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.heniedrianti.projectta.database.DatabaseEngine;
import com.example.heniedrianti.projectta.variable.AllConstants;

public class menuawal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuawal);
        if(AllConstants.SQLiteProperties.nip.length()<2) {
            DatabaseEngine db = new DatabaseEngine(getApplicationContext());
            AllConstants.SQLiteProperties.nip = db.cursorToStringArray2D(db.executeQuery("SELECT * FROM person"), new int[]{0})[0][0];
        }
    }
    public void identitas(View view) {
        Intent bidentitas = new Intent(menuawal.this, identitas.class);
        startActivity(bidentitas);
    }
    public void inputak (View view) {
//        finish();
        Intent binputak = new Intent(menuawal.this, inputak.class);
        startActivity(binputak);
    }
    public void viewdata (View view) {
        Intent bview = new Intent(menuawal.this, ViewData.class);
//        String category = "B01";
//        String tableName = "mengajar";
//        bview.putExtra("query","select * from "+tableName+" where status = '' or status = '"+category+"'");
//        bview.putExtra("table","mengajar");
//        bview.putExtra("category",category);
        startActivity(bview);
    }
}
