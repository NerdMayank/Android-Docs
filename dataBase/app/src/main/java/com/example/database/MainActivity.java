package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    TextView tvLogin;
    EditText edtName,edtPass;
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("Rcpl",MODE_PRIVATE,null);
        db.execSQL("create table IF NOT EXISTS login(id int, name varchar(20), password varchar(20),city varchar(20))");

        tvLogin=findViewById(R.id.tvLogin);
        edtName=findViewById(R.id.edtName);
        edtPass=findViewById(R.id.edtPass);
        login=findViewById(R.id.login);
        register= findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=edtName.getText().toString();
                String p=edtPass.getText().toString();

                @SuppressLint("Recycle") Cursor c= db.rawQuery("select name,password from login where name='"+n+"' and password='"+p+"'",null);

                if(c.moveToNext()){
                    Intent obj= new Intent(MainActivity.this, ShowRecord.class);
                    startActivity(obj);
                }
                else{
                    Toast.makeText(MainActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }
            }


        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob= new Intent(MainActivity.this, Registration.class);
                startActivity(ob);
            }
        });
    }
}