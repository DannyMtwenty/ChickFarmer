package com.example.chickfarmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
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
    EditText edtPass;
    Button btnRegester;
    EditText confirmPass;
    TextView textViewLogin;
   DatabaseAdaptor myDatabaseAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtFname=( EditText)findViewById(R.id.edtFname);
        edtLname=( EditText)findViewById(R.id.edtLname);
        edtAge=( EditText)findViewById(R.id.edtAge);
        edtContacts=( EditText)findViewById(R.id.edtContacts);
        edtUsername=(EditText) findViewById(R.id.edtUsername);
        edtPass=(EditText) findViewById(R.id.edtPass);
        btnRegester=(Button) findViewById(R.id.btnRegister);
        textViewLogin=(TextView)findViewById(R.id.textViewLogin);
textViewLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent loginIntent=new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }
});

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        //intent.putExtra(MainActivity.EXTRA_KEY_PARCEL_EMPLOYEE);
        return intent;
    }

    public void addUser(View view)
    {
        String s1 = edtFname.getText().toString();
        String s2 = edtLname.getText().toString();
        String s3 = edtAge.getText().toString();
        String s4 = edtContacts.getText().toString();
        String s5 = edtUsername.getText().toString();
        String s6 = edtPass.getText().toString();

        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty() && s4.isEmpty() && s5.isEmpty() && s6.isEmpty() ) {
            Toast.makeText(this, "The fields can't be Empty!!!!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            myDatabaseAdaptor=new DatabaseAdaptor(RegistrationActivity.this);
            long id = myDatabaseAdaptor.insertData(s1, s2, s3, s4, s5, s6);

            if (id <= 0) {
                Toast.makeText(this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                edtFname.setText("");
                edtLname.setText("");
                edtAge.setText("");
                edtContacts.setText("");
                edtUsername.setText("");
                 edtPass.setText("");
            } else {
                Toast.makeText(this, "Insertion Successfull", Toast.LENGTH_SHORT).show();
                edtFname.setText("");
                edtLname.setText("");
                edtAge.setText("");
                edtContacts.setText("");
                edtUsername.setText("");
                edtPass.setText("");
            }

        }
    }
}
