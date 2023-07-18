package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MyRating extends AppCompatActivity {
    private RatingBar rb;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb=findViewById(R.id.rb);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str= String.valueOf(rb.getRating());
                Toast.makeText(getApplicationContext(), ""+str, Toast.LENGTH_LONG).show();
            }
        });
    }

}