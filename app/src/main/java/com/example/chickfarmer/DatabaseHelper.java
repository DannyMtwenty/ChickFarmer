package com.example.chickfarmer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "register.db";
    public static final String DATABASE_VERSION = "1";
    public static final String TABLE_NAME = "registerFarmer";
    public static final String ID = "id";
    public static final String FirstName= "FirstName";
    public static final String LastName = "LastName";
    public static final String Age= "Age";
    public static final String Contacts= "Contacts";
    public static final String Username= "Username";
    public static final String Password= "Password";
    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FirstName+" VARCHAR(20),"+LastName+" VARCHAR(50), "+Age+" VARCHAR(20),"+Contacts+" VARCHAR(20),"+Username+" VARCHAR(50),"+Password+" VARCHAR(50));";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " +TABLE_NAME;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, Integer.parseInt(DATABASE_VERSION));
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        try
        {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }
        catch (Exception e)
        {
            System.out.println("Error in onCreate method");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        try
        {
            sqLiteDatabase.execSQL(DROP_TABLE);
        }
        catch (Exception e)
        {
            System.out.println("Error in onUpgrade method");
        }
    }
}
