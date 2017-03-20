package com.example.alpit.formula2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Alpit on 25-02-2017.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private String ACTIVITY_TABLE = "activity_table";
    private String ACTIVITY_LIST = "activity_list";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ActivityTable";

    public DataBaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACTIVITY_TABLE = " CREATE TABLE " + ACTIVITY_TABLE + "(" + ACTIVITY_LIST + ")";
        db.execSQL(CREATE_ACTIVITY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ACTIVITY_TABLE);
        onCreate(db);
    }

    void add_activity(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ACTIVITY_LIST, name);
        db.insert(ACTIVITY_TABLE, null, contentValues);
        db.close();
    }
    void del_activity(String name)
    {
        SQLiteDatabase db= this.getWritableDatabase();
       db.delete(ACTIVITY_TABLE,ACTIVITY_LIST+"=?",new String[] { name });
        db.close();
    }
    public ArrayList getalllist() {
        ArrayList<String> arr = new ArrayList<String>();
        String selectquery = "SELECT  * FROM " + ACTIVITY_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        if (cursor.moveToFirst())
        {
            do{
                arr.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return arr;
    }
}




