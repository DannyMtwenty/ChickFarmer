package com.example.chickfarmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText edtFname;
    EditText edtLname;
    EditText edtAge;
    EditText edtContacts;
    EditText edtUsername;
    EditText edtPassword;
    Button btnRegester;
    EditText confirmPass;
    TextView textViewLogin;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper=new DatabaseHelper(this);
        edtFname=( EditText)findViewById(R.id.edtFname);
        edtLname=( EditText)findViewById(R.id.edtLname);
        edtAge=( EditText)findViewById(R.id.edtUsername);
        edtContacts=( EditText)findViewById(R.id.edtContacts);
        edtUsername=(EditText) findViewById(R.id.edtUsername);
        edtPassword=(EditText) findViewById(R.id.edtPassword);
        btnRegester=(Button) findViewById(R.id.btnRegister);
        confirmPass=(EditText)findViewById(R.id.edtPass);
        textViewLogin=(TextView)findViewById(R.id.textViewLogin);
textViewLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent loginIntent=new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }
});
        btnRegester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper.getWritableDatabase();//write regestration content to database

                String Fname =edtFname.getText().toString().trim();
                String Lname =edtLname.getText().toString().trim();
                String age =edtAge.getText().toString().trim();
                String contacts =edtContacts.getText().toString().trim();
                String username =edtUsername.getText().toString().trim();
                String pwd = edtPassword.getText().toString().trim();
                insertdata(Fname,Lname,age,contacts,username,pwd);
            }
        });
    }
    public void insertdata(String Fname,String Lname,String age,String contacts,String username,String pwd){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,Fname);
        contentValues.put(DatabaseHelper.COL_3,Lname);
        contentValues.put(DatabaseHelper.COL_4,age);
        contentValues.put(DatabaseHelper.COL_5,contacts);
        contentValues.put(DatabaseHelper.COL_6,username);
        contentValues.put(DatabaseHelper.COL_7,pwd);
        long res = db.insert("registerFarmer", null, contentValues);
        Toast.makeText(getApplicationContext(),"registration successiful!",Toast.LENGTH_LONG).show();
    }

}
