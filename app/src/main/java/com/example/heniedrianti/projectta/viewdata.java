package com.example.heniedrianti.projectta;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heniedrianti.projectta.connection.OnlineConnection;
import com.example.heniedrianti.projectta.database.DatabaseEngine;
import com.example.heniedrianti.projectta.variable.AllConstants;

import java.util.ArrayList;
import java.util.List;

public class viewdata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_list);
        index = 0;
        initComponents();

    }

    private void initComponents(){
        db = new DatabaseEngine(getApplicationContext());
        optionListLinearLayout = (LinearLayout)findViewById(R.id.optionlistlayout);
        button = (Button)findViewById(R.id.option_list_button);
        viewdata.checkboxList = new ArrayList<>();

        final String category = getIntent().getStringExtra("category");
        final String tableName = getIntent().getStringExtra("table");
        System.out.println("category: "+category);
        int[]a;
        switch (tableName){
            case "mengajar" :   a=linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[1].length);
                                break;
            default         :   a=new int[]{0};
        }
        String[][]data = db.cursorToStringArray2D(db.executeQuery(getIntent().getStringExtra("query")),a);
        for(int i=0;i<data.length;i++) {
            View temp = getLayoutInflater().inflate(R.layout.option,optionListLinearLayout,false);
            CheckBox checklist = (CheckBox) temp.findViewById(R.id.list_option_checklist);
            TextView textView = (TextView) temp.findViewById(R.id.list_option_text);
            String []text = AllConstants.DataStructure.concatOptionList(tableName,data[i]);
            checklist.setText(text[0]);
            textView.setText(text[1]);
            checklist.setChecked(data[i][data[i].length-1]==null ? false : !data[i][data[i].length-1].equals(AllConstants.StatusLibrary.UNCHECKED_STATUS));
            optionListLinearLayout.addView(temp);
            viewdata.checkboxList.add(checklist);
        }

        final String[][]temp = data;
        button = (Button)findViewById(R.id.option_list_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean a = true;
                for(int i=0;i<checkboxList.size();i++){
                    System.out.println("checkboxlist "+i+" selected status: "+((CheckBox)checkboxList.get(i)).isSelected());
                    String[]x = viewdata.checkboxList.get(i).isChecked()
                            ? new String[]{category}
                            : new String[]{""};
                    a &= db.update(tableName,new String[]{"status"},x,"id = ?",new String[]{temp[i][0]});

                }
                Toast.makeText(getApplicationContext(),"Data "+(a ? "saved successfully" : "failed to save"),Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
    private int[]linearSeries(int x){
        int[]res = new int[x];
        for(int i=0;i<x;i++){
            res[i]=i;
        }
        return res;
    }
    int index;
    LinearLayout optionListLinearLayout;
    Button button;
    DatabaseEngine db;
    private static ArrayList<CheckBox> checkboxList;
}
