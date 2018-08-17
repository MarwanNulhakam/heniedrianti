


package com.example.heniedrianti.projectta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heniedrianti.projectta.database.DatabaseEngine;
import com.example.heniedrianti.projectta.variable.AllConstants;

import java.util.ArrayList;

public class OptionActivity extends AppCompatActivity {

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
        OptionActivity.checkboxList = new ArrayList<>();

        final String category = getIntent().getStringExtra("category");
        final String tableName = getIntent().getStringExtra("table");
        System.out.println("category: "+category);
        System.out.println("tableName: "+tableName);
        int[]a;
        switch (tableName){
            case "person"   :   a=linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[0].length);
                break;
            case "jabatan"  :   a=linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[5].length);
                break;
            case "jurnal"   :   a=linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[4].length);
                break;
            case "kegiatan" :   a=linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[3].length);
                break;
            case "mengajar" :   a=linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[1].length);
                break;
            case "pembinaan":   a=linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[6].length);
                break;
            case "skripsi"  :   a=linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[2].length);
                break;
            case "karir"    :   a=linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[7].length);
                break;
            default         :   a=new int[]{0};
                break;
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
            OptionActivity.checkboxList.add(checklist);
        }

        final String[][]temp = data;
        button = (Button)findViewById(R.id.option_list_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean a = true;
                String whereClause = tableName.equals("person") ? "nip = ?" : "id = ?";
                for(int i=0;i<checkboxList.size();i++){
                    System.out.println("checkboxlist "+i+" selected status: "+((CheckBox)checkboxList.get(i)).isSelected());
                    String[]x = OptionActivity.checkboxList.get(i).isChecked()
                            ? new String[]{category}
                            : new String[]{""};
                    a &= db.update(tableName,new String[]{"status"},x,whereClause,new String[]{temp[i][0]});
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
