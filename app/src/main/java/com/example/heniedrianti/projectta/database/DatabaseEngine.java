package com.example.heniedrianti.projectta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.heniedrianti.projectta.variable.AllConstants;

public class DatabaseEngine extends SQLiteOpenHelper{

    public DatabaseEngine(Context context) {
        super(context, AllConstants.SQLiteProperties.DATABASENAME.toString(), null, 1);
        Toast.makeText(context,"database created",Toast.LENGTH_LONG);
        Log.e("db","database created");
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[]tableName = AllConstants.SQLiteProperties.TABLENAME;
        String[][]columnName = AllConstants.SQLiteProperties.COLUMNNAME;
        String statement = "CREATE TABLE ";
        for(int i=0;i<tableName.length;i++) {
            String column = "";
            for(int j=0;j<columnName[i].length;j++){
                column += columnName[i][j]+",";
            }
            db.execSQL(statement+tableName[i]+" ("+column.substring(0,column.length()-1)+")");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        String[]tableName = AllConstants.SQLiteProperties.TABLENAME;
        String statement = "DROP TABLE IF EXISTS ";
        for(int i=0;i<tableName.length;i++) {
            db.execSQL(statement+tableName[i]);
        }
        onCreate(db);
    }

    public boolean insert(String tableName, String[]column,String[]data){
        ContentValues contentValues = prepareContentValues(column,data);
        return contentValues!=null? insert(tableName,contentValues) : false;
    }

    private ContentValues prepareContentValues(String[]column, String[]data){
        ContentValues contentValues = new ContentValues();
        if(column.length!=data.length) {
            Log.e("DB insert data", "number of column doesn't match number of data");
            return null;
        }
        for(int i=0;i<column.length;i++){
            contentValues.put(column[i],data[i]);
        }
        return contentValues;
    }

    public boolean insert(String tableName, ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert(tableName,null,contentValues) != -1;
    }

    public Cursor getDataFrom(String tableName){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM "+tableName,null);
    }

    public String[]cursorToStringArray(Cursor cursor,int[]var){
        String[]data = new String[var.length];
        cursor.moveToFirst();
        for(int i=0;i<data.length;i++){
            data[i] = cursor.getString(var[i]);
        }
        return data;
    }

    public Cursor executeQuery(String query){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(query,null);
    }

    public boolean update(String tableName, String[] columnName, String[] data, String whereClause, String[] whereClauseData){
        ContentValues contentValues = prepareContentValues(columnName,data);
        return contentValues != null ? update(tableName,contentValues,whereClause,whereClauseData) : false;
    }

    public boolean update(String tableName, ContentValues contentValues, String whereClause, String[] whereClauseData){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.update(tableName,contentValues,whereClause,whereClauseData) != -1;
    }

    public boolean delete(String tableName,String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return (db.delete(tableName,"id = ?",new String[]{id}))>0;
    }
}
