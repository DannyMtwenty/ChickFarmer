package com.example.chickfarmer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registerFarmer";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FirstName";
    public static final String COL_3 = "LastName";
    public static final String COL_4 = "Age";
    public static final String COL_5 = "Contacts";
    public static final String COL_6 = "Username";
    public static final String COL_7 = "Password";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY  KEY AUTOINCREMENT,FirstName TEXT,LastName TEXT,Age TEXT,Contacts TEXT,Username TEXT,Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);//drops the older table if it exists
        onCreate(sqLiteDatabase);


    }


}