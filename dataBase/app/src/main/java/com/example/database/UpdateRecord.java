package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateRecord extends AppCompatActivity {
    EditText ed,ed1,ed2,ed3;
    Button b;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        db = openOrCreateDatabase("Rcpl", MODE_PRIVATE, null);
        ed=findViewById(R.id.ed);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(ed.getText().toString());
                String n= ed1.getText().toString();
                String p= ed2.getText().toString();
                String c= ed3.getText().toString();
                db.execSQL("update login set name='"+n+"', password='"+p+"',city='"+c+"' where id='"+id+"'");
                Intent obj = new Intent(UpdateRecord.this,ShowRecord.class);
            }
        });
    }
}