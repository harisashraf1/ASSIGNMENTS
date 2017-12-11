package com.example.fawad.highlowgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fawad on 10/15/2017.
 */

public class HighScore extends SQLiteOpenHelper {

    public static final int DB_V=1;
    public static final String DB_Name="HighScore.db";
    public static final String TABLE_NAME="highscore_table";
    public static final String COL_1="EMAIL";
    public static final String COL_2="NAME";
    public static final String COL_3="SCORE";

    public HighScore(Context context) {
        super(context, DB_Name, null, DB_V);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (EMAIL TEXT PRIMARY KEY,NAME TEXT,SCORE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean InsertData(String email,String name,int score){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1,email);
        values.put(COL_2,name);
        values.put(COL_3,score);
        long newRowId =db.insert(TABLE_NAME,null,values);
        if(newRowId<0) return false;
        return true;
    }
    public Cursor ReadData(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME,null,null,null,null,null,"SCORE DESC","5");

    }
}
