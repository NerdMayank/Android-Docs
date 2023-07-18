package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowRecord extends AppCompatActivity {
    Button u,d,s;
    TextView tv;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_record);

        db = openOrCreateDatabase("Rcpl",MODE_PRIVATE,null);

        u = findViewById(R.id.button4);
        d = findViewById(R.id.button5);
        s = findViewById(R.id.button6);
        tv = findViewById(R.id.textView3);

        @SuppressLint("Recycle") Cursor c = db.rawQuery("SELECT * from login ",null);
        StringBuilder data = new StringBuilder();
        while (c.moveToNext()){
            data.append(c.getInt(0)).append("  ").append(c.getString(1)).append("  ").append(c.getString(2)).append("  ").append(c.getString(3)).append("\n");
        }

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Obj= new Intent(ShowRecord.this,UpdateRecord.class);
            }
        });

        tv.setText(data.toString());
    }
}