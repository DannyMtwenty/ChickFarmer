package com.example.chickfarmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
public class LoginActivity extends AppCompatActivity {
   DatabaseAdaptor myDatabaseAdaptor;

    EditText edtUsername;
    EditText edtPass;
    Button btnLogin;
    Button btnRegister;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myDatabaseAdaptor=new DatabaseAdaptor(LoginActivity.this);
        edtUsername=(EditText) findViewById(R.id.edtUsername);
        edtPass=(EditText) findViewById(R.id.edtPass);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnRegister=(Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(registerIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseAdaptor = new DatabaseAdaptor(LoginActivity.this);
                boolean farmers = myDatabaseAdaptor.checkUser(edtUsername.getText().toString(),edtPass.getText().toString());
                Toast.makeText(LoginActivity.this, "emp"+farmers, Toast.LENGTH_SHORT).show();
                if(farmers == true){
                    Intent intent=new Intent(LoginActivity.this, RegistrationActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

}
