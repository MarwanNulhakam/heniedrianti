package com.example.heniedrianti.projectta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.heniedrianti.projectta.database.DatabaseEngine;
import com.example.heniedrianti.projectta.variable.AllConstants;

public class SettingServerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_server);
        de = (DatabaseEngine) getIntent().getSerializableExtra("database");
        back = (ImageView) findViewById(R.id.backButton);
        ipAddress = (EditText)findViewById(R.id.editIpAddress);
        button = (Button) findViewById(R.id.ipSetButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checksum = ipAddress.getText().toString().split(".").length;
                if(checksum<4 || checksum>4){
                    Toast.makeText(getApplicationContext(),"IP invalid",Toast.LENGTH_LONG).show();
                    return;
                }
                DatabaseEngine de = new DatabaseEngine(getApplicationContext());
//                de.insert(AllConstants.SQLiteProperties.SETUPTABLE,new String[]{AllConstants.SQLiteProperties.SETUPTABLECOLUMN},new String[]{ipAddress.getText().toString()});
            }
        });
    }

    private DatabaseEngine de;
    private ImageView back;
    private EditText ipAddress;
    private Button button;


}
