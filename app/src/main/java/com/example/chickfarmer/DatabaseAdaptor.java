package com.example.chickfarmer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseAdaptor {
    DatabaseHelper myDatabaseHelper;



    public DatabaseAdaptor(Context context)  //Creating a Constructor.
    {
        Log.d("Context: ", context == null ? "is null": "is not null");
        myDatabaseHelper = new DatabaseHelper(context);     //make a object of database helper.
    }

    public long insertData(String Fname,String Lname,String age,String contacts,String username,String pwd)
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(myDatabaseHelper.FirstName,Fname);
        contentValues.put(myDatabaseHelper.LastName, Lname);
        contentValues.put(myDatabaseHelper.Age, age);
        contentValues.put(myDatabaseHelper.Contacts, contacts);
        contentValues.put(myDatabaseHelper.Username, username);
        contentValues.put(myDatabaseHelper.Password, pwd);

        long id = sqLiteDatabase.insert(myDatabaseHelper.TABLE_NAME, null, contentValues);
        return id;
    }


    public boolean getData(String username, String passwordget)
    {
        boolean val=false;
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        String [] collumn = {myDatabaseHelper.ID, myDatabaseHelper.FirstName, myDatabaseHelper.LastName, myDatabaseHelper.Age, myDatabaseHelper.Contacts, myDatabaseHelper.Username, myDatabaseHelper.Password};
        Cursor cursor = sqLiteDatabase.query(myDatabaseHelper.TABLE_NAME,collumn,null, null, null, null,null);

        ArrayList<Farmer> employees = new ArrayList<Farmer>();


        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(myDatabaseHelper.ID));
            String fname = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.FirstName));
            String lname= cursor.getString(cursor.getColumnIndex(myDatabaseHelper.LastName));
            String age = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.Age));
            String contacts= cursor.getString(cursor.getColumnIndex(myDatabaseHelper.Contacts));
            String user = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.Username));
            String password = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.Password));
//            employees.add(new Employee(id, name, email, password));
//                if (email == editTextEmailText && password == passwordget){
//                    val=true;
//                }
        }
        return val;
    }

    public boolean checkUser(String email, String password)
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        String [] collomn = {myDatabaseHelper.ID};
        String selection = myDatabaseHelper.Username + "=?" + " AND " + myDatabaseHelper.Password + "=?";
        String [] selectionArgs = {email , password};

        Cursor cursor = sqLiteDatabase.query(myDatabaseHelper.TABLE_NAME , collomn, selection, selectionArgs, null, null, null);

        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();

        if(cursorCount > 0)
        {
            return true;
        }
        return  false;
    }
}
