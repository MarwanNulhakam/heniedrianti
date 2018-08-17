package com.example.heniedrianti.projectta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.heniedrianti.projectta.database.DatabaseEngine;
import com.example.heniedrianti.projectta.variable.AllConstants;

public class ViewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);
        viewDataListLayout = (LinearLayout)findViewById(R.id.view_data_list_layout);
        initComponents();
    }

    private void initComponents(){
        DatabaseEngine db = new DatabaseEngine(this.getApplicationContext());
        for(int i=0;i<tableSelected.length;i++) {
            for (int j = 0; j < tableSelected[i].length; j++) {
                String tableName = AllConstants.SQLiteProperties.TABLENAME[tableSelected[i][j]];
                String category = "" + ((char) (i + 65)) + (j < 9 ? "0" : "") + Integer.toString(j + 1);
                String query = "SELECT * FROM " + tableName + " WHERE status = \'" + category+"\'";
                String[][] data = db.cursorToStringArray2D(db.executeQuery(query), getColumnList(tableName));
                for (int k = 0; k < data.length; k++) {
                    String[] text = AllConstants.DataStructure.concatOptionList(tableName, data[k]);
                    addList(category, text[0] + " (" + text[1] + ")");
                }
            }
        }
    }

    private int[] getColumnList(String tableName){
        int[]a;
        switch (tableName) {
            case "person":
                a = linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[0].length);
                break;
            case "jabatan":
                a = linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[5].length);
                break;
            case "jurnal":
                a = linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[4].length);
                break;
            case "kegiatan":
                a = linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[3].length);
                break;
            case "mengajar":
                a = linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[1].length);
                break;
            case "pembinaan":
                a = linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[6].length);
                break;
            case "skripsi":
                a = linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[2].length);
                break;
            case "karir":
                a = linearSeries(AllConstants.SQLiteProperties.COLUMNNAME[7].length);
                break;
            default:
                a = new int[]{0};
                break;
        }
        return a;
    }

    private int[]linearSeries(int x){
        int[]res = new int[x];
        for(int i=0;i<x;i++){
            res[i]=i;
        }
        return res;
    }

    private void addList(String cat, String desc){
        View temp = getLayoutInflater().inflate(R.layout.list_view, viewDataListLayout, false);
        TextView category = (TextView) temp.findViewById(R.id.categoryName);
        TextView description = (TextView) temp.findViewById(R.id.categoryDesc);

        category.setText(cat);
        description.setText(desc);

        viewDataListLayout.addView(temp);
    }

    private final int[][]tableSelected = {
            {7,0},
            {1,6,6,2,2,6,3,3,3,5,6,3,3},
            {4,4,4,4,4,4,4,4},
            {5,3,3,3,3},
            {3,3,5,3,3,3,3,3,3,3}
    };

    LinearLayout viewDataListLayout;
}
