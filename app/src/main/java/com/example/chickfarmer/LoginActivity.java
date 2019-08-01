package com.example.chickfarmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    EditText edtUsername;
    EditText edtPass;
    Button btnLogin;
    Button btnRegister;
Cursor cursor; //cursor class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper=new DatabaseHelper(this);
         db=openHelper.getReadableDatabase();
        edtUsername=(EditText) findViewById(R.id.edtUsername);
        edtPass=(EditText) findViewById(R.id.edtPass);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnRegister=(Button) findViewById(R.id.btnRegister);
      btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String username = edtUsername.getText().toString();//listening events of the button
              String pwd = edtPass.getText().toString();
              cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME  + " WHERE " + DatabaseHelper.COL_6 + "=? AND " + DatabaseHelper.COL_7 + "=?", new String[]{username, pwd});
              if (cursor != null) {
                  if (cursor.getCount() >= 0) {
                      cursor.moveToNext();
                      Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                      startActivity(intent);
                  }
              }
          }
      });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}
