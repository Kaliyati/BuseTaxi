package com.example.int_systems.busetaxi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Int-Systems on 3/10/2018.
 */
public class DatabaseClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BuseTaxi.db";

    public static final String TABLE_NAME = "AccesType";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "accessID";


    public DatabaseClass(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT,accessID TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

//this method creates access level if access level is 1 then the user is a driver but if access level is 2 then its the raider
    public boolean createAccessLevel(String accessID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,accessID);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //get user Access ID

    public Cursor getAccessID() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

}
